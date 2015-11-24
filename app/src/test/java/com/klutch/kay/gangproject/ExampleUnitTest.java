package com.klutch.kay.gangproject;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest extends AppCompatActivity {
    @Test
    public void addition_isCorrect() throws Exception {
        String str2;

        InputStream is = getApplicationContext().getAssets().open("skiGolf.json");
        String str = is.toString();
        JsonObject jobj = new JsonParser().parse(str).getAsJsonObject();
        Log.d("J obj", jobj.getAsJsonArray().get(1).toString());
        str2 = jobj.getAsJsonArray().get(1).toString();

        System.out.println("HAHSHSHSHAHSHASHAHS"+str2);
        assertEquals(4, 2 + 2);
    }
}