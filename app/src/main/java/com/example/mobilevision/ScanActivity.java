package com.example.mobilevision;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.widget.Toast;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

import info.androidhive.barcode.BarcodeReader;
import info.androidhive.barcode.ScannerOverlay;

public class ScanActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {
    BarcodeReader barcodeReader;// = new BarcodeReader();
    ScannerOverlay scannerOverlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        barcodeReader =(BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
        barcodeReader.setListener(this);
        scannerOverlay=findViewById(R.id.scanner_overlay);
    }
    @Override
    public void onScanned(Barcode barcode) {
        Intent intent = new Intent(ScanActivity.this,TicketActivity.class);
        intent.putExtra("code",barcode.displayValue.toString() );
        startActivity(intent);
        //finish();
    }
    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }
    @Override
    public void onScanError(String errorMessage) {
        Log.d("SCAN",errorMessage);
//        Toast.makeText(ScanActivity.this,"Error " +errorMessage ,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onCameraPermissionDenied() {
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        barcodeReader.onDestroy();
    }
    @Override
    protected void onPause() {
        super.onPause();
        barcodeReader.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        barcodeReader.onResume();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            barcodeReader.onStop();
            Intent main = new Intent(ScanActivity.this,MainActivity.class);
            startActivity(main);
            //finish();
        }
        scannerOverlay.onKeyDown(keyCode, event);
        return super.onKeyDown(keyCode, event);
    }
}

