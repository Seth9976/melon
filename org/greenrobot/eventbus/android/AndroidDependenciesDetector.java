package org.greenrobot.eventbus.android;

import android.os.Looper;

public class AndroidDependenciesDetector {
    private static final String ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME = "org.greenrobot.eventbus.android.AndroidComponentsImpl";

    public static boolean areAndroidComponentsAvailable() [...] // Inlined contents

    // 去混淆评级： 低(20)
    public static AndroidComponents instantiateAndroidComponents() {
        return new AndroidComponentsImpl();
    }

    // 去混淆评级： 低(40)
    public static boolean isAndroidSDKAvailable() {
        return Looper.getMainLooper() != null;
    }
}

