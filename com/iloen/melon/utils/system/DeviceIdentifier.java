package com.iloen.melon.utils.system;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class DeviceIdentifier {
    public static String a;

    public static String a(File file0) {
        RandomAccessFile randomAccessFile0 = new RandomAccessFile(file0, "r");
        byte[] arr_b = new byte[((int)randomAccessFile0.length())];
        randomAccessFile0.readFully(arr_b);
        randomAccessFile0.close();
        return new String(arr_b);
    }

    public static String id(Context context0) {
        synchronized(DeviceIdentifier.class) {
            if(DeviceIdentifier.a == null) {
                File file0 = new File(context0.getFilesDir(), "DeviceIdentifier");
                try {
                    if(!file0.exists()) {
                        FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
                        fileOutputStream0.write("0a656adb-c50e-464f-adfe-fe701b2340ea".getBytes());
                        fileOutputStream0.close();
                    }
                    DeviceIdentifier.a = DeviceIdentifier.a(file0);
                }
                catch(Exception exception0) {
                    throw new RuntimeException(exception0);
                }
            }
            return DeviceIdentifier.a;
        }
    }
}

