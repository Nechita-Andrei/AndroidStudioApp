package com.example.mersultrenurilor;

import android.os.AsyncTask;
import android.service.voice.VoiceInteractionService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data="";
    String dataParsed="";
    String singleParsed="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("https://api.npoint.io/dd8c56da61b07dba7495");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null){
                line=bufferedReader.readLine();
                data=data+line;
            }

            JSONArray jsonArray=new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject object = (JSONObject) jsonArray.get(i);
                singleParsed = "Destinatie: " + object.get("destinatie") + "\n" +
                        "Plecare: " + object.get("plecare") + "\n" +
                        "Ora plecare: " + object.get("departure") + "\n" +
                        "Ora cand ajunge: " + object.get("arrive") + "\n" +
                        "Tren: " + object.get("numeTren") + "\n";

                dataParsed = dataParsed +"\n"+ singleParsed;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        DataFetched.data.setText(this.dataParsed);
    }
}
