package io.github.storagereloaded.android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ItemViewActivity extends AppCompatActivity implements NestedScrollView.OnScrollChangeListener {

    ExtendedFloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        fab = findViewById(R.id.floatingActionButton);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        NestedScrollView scrollView = findViewById(R.id.scroll_view);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(this::onNavigationClick);

        scrollView.setOnScrollChangeListener(this);
    }

    private void onNavigationClick(View view) {
        onBackPressed();
    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        Log.d("Scroll", scrollX + ", " + scrollY);
        if(scrollY < 5)
            fab.extend();
        else
            fab.shrink();
    }
}