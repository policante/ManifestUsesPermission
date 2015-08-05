package com.rpolicante.checkmanifestusespermisson;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 *
 * READ MORE: http://developer.android.com/reference/android/Manifest.permission.html
 *
 * Created by policante on 8/5/15.
 */
public class CheckManifest {

    private static final String TAG = "CHECKMANIFEST";

    public static boolean bluetoothIsAllowed(Context c){
        String[] permissions = new String[]{
                Manifest.permission.BLUETOOTH,
                Manifest.permission.BLUETOOTH_ADMIN,
                Manifest.permission.BLUETOOTH_PRIVILEGED
        };

        return permissionsIsAllowed(c, permissions);
    }

    public static boolean storageIsAllowed(Context c){
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };

        return permissionsIsAllowed(c, permissions);
    }

    public static boolean internetIsAllowed(Context c){
        String[] permissions = new String[]{
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE
        };

        return permissionsIsAllowed(c, permissions);
    }

    public static boolean cameraIsAllowed(Context c){
        String[] permissions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.FLASHLIGHT
        };

        return permissionsIsAllowed(c, permissions);
    }

    public static boolean permissionsIsAllowed(Context c, String[] permissions ){
        if (c == null){
            throw new IllegalArgumentException("Checked failed: context is null!");
        }

        if (permissions.length <= 0) {
            Log.e(TAG, "Permissions is empty" );
            return false;
        }

        boolean isAllowed = true;
        for(String p: permissions){
            if (c.checkCallingOrSelfPermission(p) != PackageManager.PERMISSION_GRANTED){
                Log.e(TAG,p + " not found!");
                isAllowed = false;
            }
        }

        return isAllowed;

    }
}
