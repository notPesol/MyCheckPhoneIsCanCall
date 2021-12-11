package com.example.mycheckcall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkIsCanCall();
    }

    private void checkIsCanCall() {
        String result = "";
        TelephonyManager telephonyManager = (TelephonyManager)
                getSystemService(TELEPHONY_SERVICE);
        PackageManager packageManager = getPackageManager();
        if (telephonyManager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE
                || !packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)
        ) {
            result = "ไม่รองรับ";
        } else {
            result = "รองรับ";
        }
        Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
    }
}