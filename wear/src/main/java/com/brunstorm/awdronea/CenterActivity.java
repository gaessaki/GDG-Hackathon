package com.brunstorm.awdronea;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import de.yadrone.base.ARDrone;
import de.yadrone.base.IARDrone;
import de.yadrone.base.navdata.BatteryListener;

public class CenterActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        IARDrone drone = null;
        try
        {
            drone = new ARDrone();
            drone.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {
            if (drone != null)
                drone.stop();
            System.exit(0);
        }
        drone.getNavDataManager().addBatteryListener(new BatteryListener() {

            public void batteryLevelChanged(int percentage)
            {
                //System.out.println("Battery: " + percentage + " %");
            }

            public void voltageChanged(int vbat_raw) { }
        });


    }
}
