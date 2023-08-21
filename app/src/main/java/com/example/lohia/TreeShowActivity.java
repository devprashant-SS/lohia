package com.example.lohia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lohia.Adapter.tree_adapter;
import com.example.lohia.Adapter.tree_adapter_interface;

public class TreeShowActivity extends AppCompatActivity implements tree_adapter_interface {

    RecyclerView treerecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_show);

        treerecyclerView=findViewById(R.id.idTreeView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        treerecyclerView.setLayoutManager(layoutManager);

        treerecyclerView.setAdapter(new tree_adapter(this));

    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(getApplicationContext(), UserDataActivity.class));
    }
}