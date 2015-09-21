package com.example.cbm.restclient;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView output;
    ProgressBar progressBar;
    List<MyTask> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar campo de TextView
        output = (TextView) findViewById(R.id.textoMensaje);
        output.setMovementMethod(new ScrollingMovementMethod());

        //Inicializar barra de progreso
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.INVISIBLE);

        //inicializar lista de tareas
        tasks = new ArrayList<MainActivity.MyTask>();

    }
    //Boton borrar
    public void btnBorrarOnClick(View v)
    {
        output.setText("");
    }


    //Boton obtener datos
    public void btnObtenerDatosOnClick(View v)
    {
        if (isOnline())
        {
            requestData("http://192.168.1.103:8080/WsSeminario/webresources/py.com.consultoresinformaticos.seminarios.model.disertante/");
        }
        else
        {
            //Muestra el mensaje de error de acceso
            Toast.makeText(this, "Red no disponible", Toast.LENGTH_LONG).show();
        }

    }

    private void requestData(String uri) {
        MyTask task = new MyTask();
        task.execute(uri);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
               updateDisplay("selectedItem");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void updateDisplay(String message)
    {

        output.append(message + "\n");
    }

    protected boolean isOnline()
    {
        ConnectivityManager cm =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    /***
     *Proporciona acceso a un thread en background
     */
    private class MyTask extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute()
        {
            updateDisplay("Starting Task");
            if (tasks.size() == 0)
            {
                progressBar.setVisibility(View.VISIBLE);
            }
            tasks.add(this);
        }


        @Override
        protected String doInBackground(String ... params)
        {
            String content;
            content=HttpManager2.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String result)
        {
            //super.onPostExecute(result);
            updateDisplay(result);
            tasks.remove(this);
            if (tasks.size() == 0)
            {
                progressBar.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            updateDisplay(values[0]);
        }
    }

}
