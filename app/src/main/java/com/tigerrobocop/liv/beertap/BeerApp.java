package com.tigerrobocop.liv.beertap;

import android.app.Application;

import com.tigerrobocop.liv.beertap.Model.Beer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Livia on 12/08/2017.
 */

public class BeerApp extends Application {
   List<Beer> mListBeers;
    @Override
    public void onCreate() {
        super.onCreate();

        mListBeers = loadBeers();
    }

    public  List<Beer> getBeers(){
        return mListBeers;
    }

    private List<Beer> loadBeers(){
        List<Beer> result = new ArrayList<>();


        result.add(new Beer(1, "IPA", "Capunga", R.integer.local
                , "Recife - PE", R.drawable.logo_capunga,"http://www.capunga.com/"));

        result.add(new Beer(2, "Lager", "Debron", R.integer.local
                , "Jabooatão dos Guararapes - PE", R.drawable.logo_debron, "https://www.facebook.com/DeBronBier/"));

        result.add(new Beer(3, "IPA", "Ekaut", R.integer.local
                , "Recife - PE", R.drawable.logo_ekaut, "http://ekaut.com.br/"));

        result.add(new Beer(4, "Pilsen" ,"Indie Beer", R.integer.local
                , "Recife - PE", R.drawable.logo_indie, "https://www.facebook.com/IBCA2016/"));

        return result;

    }


}
