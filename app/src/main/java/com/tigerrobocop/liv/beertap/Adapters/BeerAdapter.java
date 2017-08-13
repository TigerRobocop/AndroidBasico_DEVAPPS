package com.tigerrobocop.liv.beertap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tigerrobocop.liv.beertap.Model.Beer;
import com.tigerrobocop.liv.beertap.R;

import java.util.List;

/**
 * Created by Livia on 12/08/2017.
 */

public class BeerAdapter extends ArrayAdapter<Beer> {
    public BeerAdapter(Context context, List<Beer> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mVH;

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.beer_list_item, null);

            mVH = new ViewHolder();
            mVH.mImgLogo = (ImageView) convertView.findViewById(R.id.img_item_logo);
            mVH.mInputBrand = (TextView) convertView.findViewById(R.id.lbl_item_brand);
            mVH.mInputCity = (TextView) convertView.findViewById(R.id.lbl_item_city);
            mVH.mInputType = (TextView) convertView.findViewById(R.id.lbl_item_type);

            convertView.setTag(mVH);

        } else {
            mVH = (ViewHolder) convertView.getTag();
        }

        Beer b = getItem(position);
        if (b != null){
            mVH.mImgLogo.setImageResource(b.photoID);
            mVH.mInputCity.setText(b.city);
            mVH.mInputType.setText(b.type);
            mVH.mInputBrand.setText(b.brand);
        }

        return convertView;

    }
}


class ViewHolder {
    ImageView mImgLogo;
    TextView mInputBrand;
    TextView mInputType;
    TextView mInputCity;
}
