package com.example.cbm.restclient;

/**
 * Created by cbm on 20/09/2015.
 */
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HttpManager {

    public static String getData(String uri)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(uri);
            HttpResponse response = client.execute(request);

// Get the response

            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            String line ="";
            while ((line = rd.readLine()) != null)
            {
                sb.append(line);
            }

        }
        catch(Exception ex)
        {

        }

        return sb.toString();

    }
}
