package com.example.the_cats_app_pragma;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorModel extends RecyclerView.Adapter<AdaptadorModel.ItemViewHolder> {
    private List<Models> itemList;
    Context context;

    public AdaptadorModel(Context context, List<Models> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Models item = itemList.get(position);

        // Set the data to the views in the item view
        holder.breedname.setText(item.getNombre());
        holder.origin.setText(item.getAfectionlevel());
        holder.Afectionlevel.setText(item.getOringin());
        holder.inteligenciaview.setText(item.getInteligencia());

        // Load image using a library like Picasso or Glide
        Picasso.with(holder.imageView.getContext()).load(item.getImageUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView breedname;
        public TextView origin;
        public TextView Afectionlevel;
        public TextView inteligenciaview;
        public ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            breedname = itemView.findViewById(R.id.breedname);
            origin = itemView.findViewById(R.id.afectionlevel);
            Afectionlevel = itemView.findViewById(R.id.oringin);
            inteligenciaview = itemView.findViewById(R.id.inteligence);

            imageView = itemView.findViewById(R.id.imagen_item);
        }
    }
}

