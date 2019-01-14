package com.example.mmanoghna.juicebergserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.mmanoghna.juicebergserver.R;

import Interface.ItemClickListener;

/**
 * Created by m.manoghna on 1/18/2018.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {
    public TextView txtOrderId,txtOrderStatus,txtOrderPhone ;
    private ItemClickListener itemClickListener;
    public OrderViewHolder(View itemView) {
        super(itemView);
        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
    txtOrderStatus=(TextView)itemView.findViewById(R.id.order_status);
    txtOrderPhone=(TextView)itemView.findViewById(R.id.order_phone);
    itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
public void onClick(View view)
    {

        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("select the action");
        menu.add(0,0,getAdapterPosition(),"Update");
        menu.add(0,1,getAdapterPosition(),"Update");
    }
}
