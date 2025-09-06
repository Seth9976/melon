package org.greenrobot.eventbus;

public interface MainThreadSupport {
    Poster createPoster(EventBus arg1);

    boolean isMainThread();
}

