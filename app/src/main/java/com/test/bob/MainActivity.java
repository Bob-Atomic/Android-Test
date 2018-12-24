package com.test.bob;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("hello");
    }

    private Toolbar toolbar;
    private Button activity;
    private Button service;
    private Button broadcast;
    private Button contentProvider;
    private Button jni;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activity = (Button) findViewById(R.id.button_activity);
        service = (Button) findViewById(R.id.button_service);
        broadcast = (Button) findViewById(R.id.button_broadcast);
        contentProvider = (Button) findViewById(R.id.button_contentProvider);
        jni = (Button) findViewById(R.id.button_jni);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()){
            case R.id.button_activity:
                intent = new Intent();
                intent.setComponent(new ComponentName("com.bob.test", "com.test.bob.activity.ActivityHome"));
                break;
            case R.id.button_service:
                intent = new Intent();
                intent.setComponent(new ComponentName("com.bob.test", "com.test.bob.activity.ActivityHome"));
                break;
            case R.id.button_broadcast:
                intent = new Intent();
                intent.setComponent(new ComponentName("com.bob.test", "com.test.bob.activity.ActivityHome"));
                break;
            case R.id.button_contentProvider:
                intent = new Intent();
                intent.setComponent(new ComponentName("com.bob.test", "com.test.bob.activity.ActivityHome"));
                break;
            case R.id.button_jni:
                intent = new Intent();
                intent.setComponent(new ComponentName("com.bob.test", "com.test.bob.activity.ActivityHome"));
                break;
            default:
                break;
        }

        if(null != intent){
            startActivity(intent);
        }
    }
}


