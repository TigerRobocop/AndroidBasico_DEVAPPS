package com.tigerrobocop.liv.beertap;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewItemActivity extends AppCompatActivity {

    public static final String EXTRA_NEWITEM = "newItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

        NewItemFragment newItemFragment = NewItemFragment.newInstance();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_newItem, newItemFragment, NewItemFragment.TAG_NEWITEM);
        ft.commit();
    }
}
