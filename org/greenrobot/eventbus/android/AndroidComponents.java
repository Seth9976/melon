package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;

public abstract class AndroidComponents {
    public final MainThreadSupport defaultMainThreadSupport;
    private static final AndroidComponents implementation;
    public final Logger logger;

    static {
        AndroidComponents.implementation = AndroidDependenciesDetector.isAndroidSDKAvailable() ? AndroidDependenciesDetector.instantiateAndroidComponents() : null;
    }

    public AndroidComponents(Logger logger0, MainThreadSupport mainThreadSupport0) {
        this.logger = logger0;
        this.defaultMainThreadSupport = mainThreadSupport0;
    }

    public static boolean areAvailable() [...] // 潜在的解密器

    public static AndroidComponents get() {
        return AndroidComponents.implementation;
    }
}

