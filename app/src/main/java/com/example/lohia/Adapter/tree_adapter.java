package com.example.lohia.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lohia.R;

public class tree_adapter extends RecyclerView.Adapter<tree_adapter.tree_view> {

    private final tree_adapter_interface tree_interface;

    public tree_adapter(tree_adapter_interface tree_interface) {
        this.tree_interface = tree_interface;
    }

    @NonNull
    @Override
    public tree_view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tree_view_node, parent, false);
        return new tree_view(view);

    }

    @Override
    public void onBindViewHolder(@NonNull tree_view holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class tree_view extends RecyclerView.ViewHolder {
        public tree_view(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tree_interface != null){
                        int pos=getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            tree_interface.onItemClick(pos);
                        }
                    }
                }
            });
        }

    }
}
