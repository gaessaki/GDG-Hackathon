package com.brunstorm.awdronea;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.*;
import android.view.*;
import android.content.Intent;

public class CenterActivity extends Activity {

    private TextView mTextView;
    private TextView TextToPrint;
    private TextView txtView;
    private Button mybtn;
    private WatchViewStub stub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
    /*
        mybtn = (Button)findViewById(R.id.UpButton);
        mybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtView.setText("UP");
            }
        });
    */

    }

    public void PrintLaunch(View v){
        Resources res = getResources();
        String Print = res.getString(R.string.Launch);
        TextView txt = (TextView) stub.findViewById(R.id.UpTextView);
        txt.setText(Print);

    }

    public void PrintLand(View v){
        Resources res = getResources();
        String Print = res.getString(R.string.Land);
        TextView txt = (TextView) stub.findViewById(R.id.UpTextView);
        txt.setText(Print);
    }
}

