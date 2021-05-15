package com.example.mobilevision;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class AdapterRecycleview  extends RecyclerView.Adapter<AdapterRecycleview.ViewHolder> {
    public Context contextt;
    public ArrayList<Object> objectArrayList;
    public AdapterRecycleview (Context context, ArrayList<Object> arrObjects)
    {
        this.objectArrayList = arrObjects;
        this.contextt = context;
    }
    @NonNull
    @Override
    public AdapterRecycleview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_history, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterRecycleview.ViewHolder holder, int position) {
    final Object object = objectArrayList.get(position);
    //get image
        String http = "http://";
    String url = "192.168.1.13/";
    String img = object.getPicture();
    String newimg = img.replace("\\","");
    String path = url + img;
       // Log.d("path", path);
        String path_Orignal = http + url + img;
    Glide.with(contextt).load(path_Orignal).into(holder.imageView);
    //--//get name...
//    String name = object.getName();
    holder.tv_name.setText(object.getName());
//    String price = object.getPrice();
    holder.tv_price.setText(object.getPrice());
//    String des = object.getDescription();
        //String bacham="...";
    holder.tv_descripion.setText(object.getDescription());
    }
    @Override
    public int getItemCount() {
        return objectArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_name;
        TextView tv_price;
        TextView tv_descripion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_picture_history);
            tv_name = itemView.findViewById(R.id.tv_name_history);
            tv_price = itemView.findViewById(R.id.tv_price_history);
            tv_descripion = itemView.findViewById(R.id.tv_description_history);
        }
    }
}
