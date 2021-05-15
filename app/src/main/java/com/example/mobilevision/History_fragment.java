package com.example.mobilevision;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class History_fragment extends Fragment {
    private View view;
    RecyclerView rcv_history_list;
    ArrayList<Object> objects = new ArrayList<>();
    AdapterRecycleview adapter;
    private  static  final String MY_KEY= "JSON";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recyclerview_list_history,container,false);
        rcv_history_list = view.findViewById(R.id.rcv_history_list);

        getPreferenceObjectJson();
        showData();
        return view;
        // View inf = inflater.inflate(R.layout.fragment_history,container,false);
//        textView = inf.findViewById(R.id.tvv);
//        textView.setText("dangminh");
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MY_KEY, Context.MODE_PRIVATE);
//        String json = sharedPreferences.getString("dulieu",null);
    }
    public void getPreferenceObjectJson(){
       // SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MY_KEY,TicketActivity.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MY_KEY, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("dulieu",null);
        if (sharedPreferences != null) {
            Log.d("JSON", json);
            Gson gson = new Gson();
            Object object = gson.fromJson(json,Object.class);
            objects = getObjectArrayList(object);
        }
    }
    public ArrayList<Object> getObjectArrayList(Object object) {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        objectArrayList.add(object);
        //setRecycleview(objectArrayList);
        return objectArrayList;
    }
    public void showData() {
        rcv_history_list.setHasFixedSize(true);
        rcv_history_list.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new AdapterRecycleview(getActivity().getApplicationContext(), objects); // Chinh sua
        rcv_history_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
