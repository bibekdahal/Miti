package com.bibta.miti;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Grabber that grabs tithi from online database and stores the data in local database.
 */
public class TithiGrabber {

    public static final String URL = "https://raw.githubusercontent.com/bibekdahal/tithi/master/data.json";

    public interface Listener {
        void onNewDataFetched();
    }

    private Context mContext;

    /**
     * Create new Tithi Grabber object.
     * @param context Context that handles this grabber.
     */
    public TithiGrabber(Context context) {
        mContext = context;
    }

    /**
     * Store tithi data provided in a json object in local database.
     * @param jsonData JSON object containing "data" which is JSON Array of date-tithi pairs.
     * @throws JSONException
     */
    public void storeData(JSONObject jsonData) throws JSONException {
        TithiDb db = new TithiDb(mContext);
        JSONArray data = jsonData.getJSONArray("data");

        // Store each element in data array in the database.
        for (int i=0; i<data.length(); ++i) {
            JSONObject element = data.getJSONObject(i);

            String date = element.getString("date");
            String tithi = element.getString("tithi");

            // Check if date exists and update if it does.
            // Insert new if it doesn't.

            String c = db.get(date);
            if (c.equals(""))
                db.insert(date, tithi);
            else
                db.update(date, tithi);
        }
    }

    /**
     * Fetch new tithi data from online database.
     * @param listener Callback listener for listening to fetch complete event.
     */
    public void fetchData(final Listener listener) {
        new AsyncTask<Void, Void, Void>() {
            private boolean mSuccess = false;

            @Override
            protected Void doInBackground(Void... params) {
                try {

                    // Make connection to server.

                    java.net.URL url = new URL(URL);
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setDoOutput(false);
                    connection.setRequestMethod("GET");

                    connection.setRequestProperty("Accept", "application/json");
                    connection.setRequestProperty("Content-Type", "application/json");

                    // Get the result and store data locally.

                    InputStream in = new BufferedInputStream(connection.getInputStream());
                    String result = new Scanner(in).useDelimiter("\\A").next();
                    storeData(new JSONObject(result));

                    Log.d("Fetched new data", "Tithi updated");

                    mSuccess = true;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                if (mSuccess)
                    listener.onNewDataFetched();
            }
        }.execute();
    }
}
