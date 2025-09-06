package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import android.util.Log;
import b7.c;
import e7.f;
import h7.a0;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileStore {
    public final String a;
    public final File b;
    public final File c;
    public final File d;
    public final File e;
    public final File f;
    public final File g;

    public FileStore(Context context0) {
        String s = ((a0)c.b.d(context0)).a;
        this.a = s;
        File file0 = context0.getFilesDir();
        this.b = file0;
        File file1 = new File(file0, (s.isEmpty() ? ".com.google.firebase.crashlytics.files.v1" : ".crashlytics.v3/" + (s.length() <= 40 ? s.replaceAll("[^a-zA-Z0-9.]", "_") : f.h(s))));
        FileStore.c(file1);
        this.c = file1;
        File file2 = new File(file1, "open-sessions");
        FileStore.c(file2);
        this.d = file2;
        File file3 = new File(file1, "reports");
        FileStore.c(file3);
        this.e = file3;
        File file4 = new File(file1, "priority-reports");
        FileStore.c(file4);
        this.f = file4;
        File file5 = new File(file1, "native-reports");
        FileStore.c(file5);
        this.g = file5;
    }

    public final void a(String s) {
        File file0 = new File(this.b, s);
        if(file0.exists() && FileStore.d(file0)) {
            String s1 = "Deleted previous Crashlytics file system: " + file0.getPath();
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", s1, null);
            }
        }
    }

    public final File b(String s, String s1) {
        File file0 = new File(this.d, s);
        file0.mkdirs();
        return new File(file0, s1);
    }

    public static void c(File file0) {
        synchronized(FileStore.class) {
            if(file0.exists()) {
                if(file0.isDirectory()) {
                    return;
                }
                if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Unexpected non-directory file: " + file0 + "; deleting file and creating new directory.", null);
                }
                file0.delete();
            }
            if(!file0.mkdirs()) {
                Log.e("FirebaseCrashlytics", "Could not create Crashlytics-specific directory: " + file0, null);
            }
        }
    }

    public static boolean d(File file0) {
        File[] arr_file = file0.listFiles();
        if(arr_file != null) {
            for(int v = 0; v < arr_file.length; ++v) {
                FileStore.d(arr_file[v]);
            }
        }
        return file0.delete();
    }

    public static List e(Object[] arr_object) {
        return arr_object == null ? Collections.EMPTY_LIST : Arrays.asList(arr_object);
    }
}

