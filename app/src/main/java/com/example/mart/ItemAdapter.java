package com.example.mart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Viewholder> {
    private static final String baseurl = "https://mobileapp25.blob.core.windows.net/images/";
    private Context context;
    Item []itemslist;

    public ItemAdapter(Context context, Item[] itemslist) {
        this.context = context;
        this.itemslist = itemslist;
    }



    @NonNull
    @Override
    public ItemAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_cardview_layout, parent, false);



        return new Viewholder(view);
    }

 

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout

        Item item = itemslist[position];
        holder.itemName.setText(item.getName());
        holder.itemDescription.setText(item.getDescription());
        holder.itemRating.setText(item.getRating().toString());
        Glide.with(holder.itemImage.getContext()).load(baseurl+item.getImage()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return itemslist.length;
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemName, itemRating,itemDescription;
        private Button itemAdd,itemRemove,buyNow;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemDescription = itemView.findViewById(R.id.itemShortDescription);
            itemRating = itemView.findViewById(R.id.itemRating);

            itemAdd = itemView.findViewById(R.id.itemAdd);
            itemRemove = itemView.findViewById(R.id.itemRemove);
            buyNow = itemView.findViewById(R.id.itemBuy);

            itemAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
                }
            });

            itemRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Item deleted from cart", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
