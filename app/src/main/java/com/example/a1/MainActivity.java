package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "StartActivity";
    private Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("counter")) {
            counter = savedInstanceState.getInt("counter");
        }
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
    }
    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(counter.toString());
        Log.d(TAG, "resetUI");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onRestart");
    }
    @Override
    public void onStart() {
        super.onStart();
        resetUI();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }

    public void onClickBtnAddSon(View view) {
        counter=counter+1000;
        TextView counterView = findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


}