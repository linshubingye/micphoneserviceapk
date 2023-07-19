package com.micphone.service.utile;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.gd.gdmicphoneservice.BuildConfig;

import java.util.HashMap;
import java.util.Map;

public class Config {

    private static boolean mNeedCheckMicphoneName = true;


    private static Map<Integer, Integer> mDeviceList = new HashMap<Integer ,Integer >() {
        {
            put(0x1235,0x0002);
            put(0x31b1,0x2430);
        }
    };

    public static boolean isFrontService() {
       // if(BuildConfig.FRONT_SERVICE)
            return true;
     //   else return false;
    }


    public static String getVersion(Context context) {
        String version = "";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null){
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                version = packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        return version;
    }

    public static boolean isSupportDevice(int vid, int pid){
        if (mDeviceList.isEmpty())
            return false;

        for (Map.Entry<Integer,Integer> m : mDeviceList.entrySet()){
            if (m.getKey() == vid && m.getValue() == pid)
                return true;
        }

        return false;
    }
    public static boolean needCheckMicphoneName(){
        return mNeedCheckMicphoneName;
    }

}
