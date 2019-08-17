package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject SandwitchJson = new JSONObject(json);
        JSONObject Name= SandwitchJson.getJSONObject( "name" );
        String SandwitchMainName=Name.getString( "mainName" );
        JSONArray alsoKnownAs=Name.getJSONArray( "alsoKnownAs" );
        List<String> alsoKnownAsList=new ArrayList<>(  );
        for(int i=0;i<alsoKnownAs.length();i++){
            alsoKnownAsList.add( alsoKnownAs.getString( i ) );
        }
        String placeOfOrigin= SandwitchJson.getString( "placeOfOrigin" );
        String description= SandwitchJson.getString( "description" );
        String image= SandwitchJson.getString( "image" );
        JSONArray ingredients=SandwitchJson.getJSONArray( "ingredients" );
        List<String> ingredientsList=new ArrayList<>(  );
        for (int i=0;i<ingredients.length();i++){
            ingredientsList.add( ingredients.getString( i ) );
        }
        return new Sandwich( SandwitchMainName,alsoKnownAsList,  placeOfOrigin,  description,  image,  ingredientsList);
    }
}
