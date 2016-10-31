package com.piled.ble.ota;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

public class FileService extends Service {
    private final static String TAG = "piled.ota";
    private final static int MAX_UPDATE_SIZE = 32 * 1024;

    private void broadcastUpdate(final String action) {
        final Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    public class LocalBinder extends Binder {
        FileService getService() {
            return FileService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        close();
        return super.onUnbind(intent);
    }

    private final IBinder mBinder = new LocalBinder();

    public boolean initialize() {
        
        return true;
    }

    public void close() {
    }
    
    public byte[] getUpdateBytes() {
        File sdcard = Environment.getExternalStorageDirectory();
        if (sdcard == null) {
            Log.d(TAG, "sdcard is null");
            return null;
        }
        File[] updateFiles = sdcard.listFiles(new OTAPackages());
        if (updateFiles.length == 0) {
            Log.d(TAG, "can't find a package");
            return null;
        }
        if (updateFiles[0].length() >= MAX_UPDATE_SIZE) {
            Log.d(TAG, "a package is too big");
            return null;
        }
        byte[] updateBuffer = new byte[(int)updateFiles[0].length()];
        try {
            FileInputStream stream = new FileInputStream(updateFiles[0]);
            int readBytes = stream.read(updateBuffer);
            if (updateBuffer.length != readBytes) {
                Log.d(TAG, "read " + readBytes + " bytes, expected " + updateBuffer.length);
                return null;
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException " + e);
            return null;
        } catch (IOException e) {
            Log.e(TAG, "IOException " + e);
            return null;
        }
        return updateBuffer;
    }
    
    static class OTAPackages implements FilenameFilter {
        public boolean accept(File dir, String name) {
            Log.d(TAG, "accept(): " + name);
            return name.endsWith(".ser");
        }
    }

}
