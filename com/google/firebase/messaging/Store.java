package com.google.firebase.messaging;

import P1.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.io.IOException;

class Store {
    public final SharedPreferences a;

    public Store(Context context0) {
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.google.android.gms.appid", 0);
        this.a = sharedPreferences0;
        File file0 = new File(c.getNoBackupFilesDir(context0), "com.google.android.gms.appid-no-backup");
        if(!file0.exists()) {
            try {
                if(file0.createNewFile()) {
                    synchronized(this) {
                        boolean z = sharedPreferences0.getAll().isEmpty();
                    }
                    if(!z) {
                        Log.i("FirebaseMessaging", "App restored, clearing state");
                        synchronized(this) {
                            sharedPreferences0.edit().clear().commit();
                        }
                    }
                }
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + iOException0.getMessage());
                }
            }
        }
    }
}

