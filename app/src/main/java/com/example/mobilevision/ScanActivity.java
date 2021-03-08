package com.example.mobilevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class ScanActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    BarcodeReader barcodeReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
    }
    @Override
    public void onScanned(Barcode barcode) {
        Intent intent = new Intent(ScanActivity.this,TicketActivity.class);
        intent.putExtra("code",barcode.displayValue.toString() );
        startActivity(intent);

    }
    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

        Intent intent = new Intent(ScanActivity.this,TicketActivity.class);
        intent.putExtra("code",sparseArray.toString());
        startActivity(intent);
    }

    @Override
    public void onScanError(String errorMessage) {
        Toast.makeText(ScanActivity.this,"Error " +errorMessage ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCameraPermissionDenied() {
        finish();
    }

}

