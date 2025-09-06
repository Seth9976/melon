package org.greenrobot.eventbus.android;

public class AndroidComponentsImpl extends AndroidComponents {
    public static final int a;

    public AndroidComponentsImpl() {
        super(new AndroidLogger("EventBus"), new DefaultAndroidMainThreadSupport());
    }
}

