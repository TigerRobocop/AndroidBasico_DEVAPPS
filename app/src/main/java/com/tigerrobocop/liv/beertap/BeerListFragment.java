package com.tigerrobocop.liv.beertap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tigerrobocop.liv.beertap.Adapters.BeerAdapter;
import com.tigerrobocop.liv.beertap.Model.Beer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeerListFragment extends ListFragment {

    List<Beer> mListBeer;
    BeerAdapter mAdapter;

    public static final String TAG_NEWITEM = "newItem";


    public BeerListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListBeer = ((BeerApp)getActivity().getApplication()).getBeers();

        /*
        Intent intent = getActivity().getIntent();
        Beer item = (Beer)intent.getSerializableExtra(NewItemActivity.EXTRA_NEWITEM);

        if (item != null) {
            Beer it = (Beer) bundle.getSerializable(NewItemFragment.EXTRA_NEWITEM);
            mListBeer.add(item);
        }
        */

        clearSearch();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity activity = getActivity();
        if (activity instanceof OnItemClick) {
            Beer beer = (Beer) l.getItemAtPosition(position);
            ((OnItemClick) activity).itemClick(beer);
        }
    }

    public void searchItem(String s) {
        if (s == null || s.trim().equals("")) {
            clearSearch();
            return;
        }

        List<Beer> result = new ArrayList<Beer>(mListBeer);
        for (int i = result.size() - 1; i >= 0; i--) {
            Beer beer = result.get(i);

            String brand = beer.brand;

            if (!brand.toUpperCase().contains(s.toUpperCase())) {
                result.remove(beer);
            }

            mAdapter = new BeerAdapter(getActivity(), result);

            setListAdapter(mAdapter);
        }
    }

    public void clearSearch() {
        mAdapter = new BeerAdapter(getActivity(), mListBeer);
        setListAdapter(mAdapter);
    }

}
