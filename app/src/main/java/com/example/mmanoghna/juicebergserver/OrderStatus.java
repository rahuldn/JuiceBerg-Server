package com.example.mmanoghna.juicebergserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mmanoghna.juicebergserver.Common.Common;
import com.example.mmanoghna.juicebergserver.Model.request;
import com.example.mmanoghna.juicebergserver.ViewHolder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Interface.ItemClickListener;

public class OrderStatus extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<request,OrderViewHolder> adapter;
    FirebaseDatabase db;
    DatabaseReference Requests;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);
        db=FirebaseDatabase.getInstance();
        Requests=db.getReference("Requests");

        recyclerView=(RecyclerView)findViewById(R.id.list_orders);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadOrders();
    }

    private void loadOrders() {
        adapter=new FirebaseRecyclerAdapter<request, OrderViewHolder>(request.class,R.layout.order_layout,OrderViewHolder.class,Requests) {

            @Override
            protected void populateViewHolder(OrderViewHolder viewHolder, request model, int position) {

                viewHolder.txtOrderId.setText(adapter.getRef(position).getKey());//check 10:54
                viewHolder.txtOrderPhone.setText(model.getPhone());

                viewHolder.txtOrderStatus.setText("Placed");//check common order status,13:11:53
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                    }
                });

            }
        };
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }
}
