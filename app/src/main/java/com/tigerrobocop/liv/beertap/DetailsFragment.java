package com.tigerrobocop.liv.beertap;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tigerrobocop.liv.beertap.Model.Beer;


public class DetailsFragment extends Fragment {

    public static final String EXTRA_ITEM_DETAILS = "itemDetails";
    public static final String TAG_DETAILS = "itemDetails";

    Beer mBeer;

    ImageView mImgLogo;
    TextView mTextBrand;
    TextView mTextCity;
    TextView mTextOrigin;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(Beer beer) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEM_DETAILS, beer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBeer = (Beer) getArguments().getSerializable(EXTRA_ITEM_DETAILS);
            setHasOptionsMenu(true);

            if(!itemExists(mBeer)){
                ((BeerApp)getActivity().getApplication()).getBeers().add(mBeer);
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View  layout =inflater.inflate(R.layout.fragment_details, container, false);

        mImgLogo = (ImageView) layout.findViewById(R.id.img_details_logo);
        mTextBrand = (TextView) layout.findViewById(R.id.lbl_details_brand);
        mTextCity = (TextView) layout.findViewById(R.id.lbl_details_city);
        mTextOrigin = (TextView) layout.findViewById(R.id.lbl_details_origin);

        if (mBeer != null) {
            mTextBrand.setText(mBeer.brand);
            mTextCity.setText(mBeer.city);
            mTextOrigin.setText(mBeer.origin);
            mImgLogo.setImageResource(mBeer.photoID);
        }
        return layout;
    }

    boolean itemExists(Beer beer){
        boolean exists = false;

        for(Beer b :  ((BeerApp)getActivity().getApplication()).getBeers()) {
            if(b.id == beer.id) {
                return true;
            }
        }

        return exists;
    }

}
