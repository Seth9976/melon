package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    public static int availableProcessors() [...] // 潜在的解密器

    private static int getCoreCountPre17() {
        File[] arr_file;
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
        try {
            arr_file = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file0, String s) {
                    return Pattern.compile("cpu[0-9]+").matcher(s).matches();
                }
            });
        }
        catch(Throwable unused_ex) {
            try {
                if(Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", throwable0);
                }
            }
            finally {
                StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
            }
            throw new NullPointerException();
        }
        StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        return arr_file == null ? 1 : Math.max(1, arr_file.length);
    }
}

