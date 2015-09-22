package com.example.cbm.restclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cbm on 20/09/2015.
 */
public class HttpManager2 {
    public static String getData(String uri)
    {
        BufferedReader reader = null;
        try
        {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            return sb.toString();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch(Exception ex)
                {
                    //ex.printStackTrace();
                }
            }
        }
    }
}
