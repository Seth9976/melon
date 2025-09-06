package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = false;
    private static final File FD_SIZE_LIST = null;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED = false;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    @Deprecated
    public static final int NO_MAX_FD_COUNT = -1;
    private static final int REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P = 500;
    private static final String TAG = "HardwareConfig";
    private int decodesSinceLastFdCheck;
    private static volatile HardwareConfigState instance;
    private boolean isFdSizeBelowHardwareLimit;
    private final AtomicBoolean isHardwareConfigAllowedByAppState;
    private final int sdkBasedMaxFdCount;

    static {
        boolean z = false;
        HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = Build.VERSION.SDK_INT < 29;
        if(Build.VERSION.SDK_INT >= 28) {
            z = true;
        }
        HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED = z;
        HardwareConfigState.FD_SIZE_LIST = new File("/proc/self/fd");
    }

    public HardwareConfigState() {
        this.isFdSizeBelowHardwareLimit = true;
        this.isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
        this.sdkBasedMaxFdCount = 20000;
    }

    // 去混淆评级： 低(20)
    private boolean areHardwareBitmapsBlockedByAppState() {
        return HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get();
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public static HardwareConfigState getInstance() {
        if(HardwareConfigState.instance == null) {
            Class class0 = HardwareConfigState.class;
            synchronized(class0) {
                if(HardwareConfigState.instance == null) {
                    HardwareConfigState.instance = new HardwareConfigState();
                }
            }
        }
        return HardwareConfigState.instance;
    }

    // 去混淆评级： 低(20)
    private int getMaxFdCount() {
        return HardwareConfigState.isHardwareBitmapCountReducedOnApi28ByB139097735() ? 500 : this.sdkBasedMaxFdCount;
    }

    private boolean isFdSizeBelowHardwareLimit() {
        synchronized(this) {
            boolean z = true;
            int v1 = this.decodesSinceLastFdCheck + 1;
            this.decodesSinceLastFdCheck = v1;
            if(v1 >= 50) {
                this.decodesSinceLastFdCheck = 0;
                String[] arr_s = HardwareConfigState.FD_SIZE_LIST.list();
                long v2 = (long)this.getMaxFdCount();
                if(((long)arr_s.length) >= v2) {
                    z = false;
                }
                this.isFdSizeBelowHardwareLimit = z;
                if(!z && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we\'re over the file descriptor limit, file descriptors " + arr_s.length + ", limit " + v2);
                }
            }
            return this.isFdSizeBelowHardwareLimit;
        }
    }

    private static boolean isHardwareBitmapCountReducedOnApi28ByB139097735() {
        if(Build.VERSION.SDK_INT != 28) {
            return false;
        }
        for(Object object0: Arrays.asList(new String[]{"GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013"})) {
            if(Build.MODEL.startsWith(((String)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public boolean isHardwareConfigAllowed(int v, int v1, boolean z, boolean z1) {
        if(!z) {
            if(Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if(!HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED) {
            if(Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if(this.areHardwareBitmapsBlockedByAppState()) {
            if(Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if(z1) {
            if(Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if(v >= 0 && v1 >= 0) {
            if(!this.isFdSizeBelowHardwareLimit()) {
                if(Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
            return true;
        }
        if(Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
        }
        return false;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int v, int v1, BitmapFactory.Options bitmapFactory$Options0, boolean z, boolean z1) {
        boolean z2 = this.isHardwareConfigAllowed(v, v1, z, z1);
        if(z2) {
            bitmapFactory$Options0.inPreferredConfig = Bitmap.Config.HARDWARE;
            bitmapFactory$Options0.inMutable = false;
        }
        return z2;
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }
}

