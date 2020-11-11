package io.github.storagereloaded.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), manager.getOrientation()));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerViewAdapter(this));
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, ItemViewActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}