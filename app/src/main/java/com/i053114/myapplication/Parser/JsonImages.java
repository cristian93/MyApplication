package com.i053114.myapplication.Parser;

import com.i053114.myapplication.Models.Images;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;





public class JsonImages {
    /**
   // public static List<Images> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<Images> countryList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){

            JSONObject item = jsonArray.getJSONObject(i);
            Images  imageDates= new Images();
            imageDates.setTitle(item.getString("title"));
            imageDates.setUrl(item.getString("url"));
            countryList.add(imageDates);

        }
        return countryList;
    }
 */
}
