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

import java.text.BreakIterator;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Viewholder> {

    private Context context;
    private ArrayList<ItemModel> itemModelArrayList;

    // Constructor
    public ItemAdapter(Context context, ArrayList<ItemModel> itemModelArrayList) {
        this.context = context;
        this.itemModelArrayList = itemModelArrayList;
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
        ItemModel model = itemModelArrayList.get(position);
        holder.itemName.setText(model.getItem_name());
        holder.itemDescription.setText(model.getItem_description());
        holder.itemRating.setText("" + model.getItem_rating());
        holder.itemImage.setImageResource(model.getItem_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return itemModelArrayList.size();
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
