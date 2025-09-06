package org.greenrobot.eventbus.android;

import android.os.Looper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.HandlerPoster;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.Poster;

public class DefaultAndroidMainThreadSupport implements MainThreadSupport {
    @Override  // org.greenrobot.eventbus.MainThreadSupport
    public Poster createPoster(EventBus eventBus0) {
        return new HandlerPoster(eventBus0, Looper.getMainLooper(), 10);
    }

    @Override  // org.greenrobot.eventbus.MainThreadSupport
    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}

