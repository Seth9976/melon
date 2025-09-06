package com.facebook.appevents.gps.topics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import we.a;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
final class GpsTopicsManager.executor.2 extends r implements a {
    public static final GpsTopicsManager.executor.2 INSTANCE;

    static {
        GpsTopicsManager.executor.2.INSTANCE = new GpsTopicsManager.executor.2();
    }

    public GpsTopicsManager.executor.2() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    public final ExecutorService invoke() {
        return Executors.newCachedThreadPool();
    }
}

