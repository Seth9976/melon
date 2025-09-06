package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class PromiseNotifier implements GenericFutureListener {
    private final boolean logNotifyFailure;
    private static final InternalLogger logger;
    private final Promise[] promises;

    static {
        PromiseNotifier.logger = InternalLoggerFactory.getInstance(PromiseNotifier.class);
    }

    @SafeVarargs
    public PromiseNotifier(boolean z, Promise[] arr_promise) {
        ObjectUtil.checkNotNull(arr_promise, "promises");
        for(int v = 0; v < arr_promise.length; ++v) {
            ObjectUtil.checkNotNullWithIAE(arr_promise[v], "promise");
        }
        this.promises = (Promise[])arr_promise.clone();
        this.logNotifyFailure = z;
    }

    @SafeVarargs
    public PromiseNotifier(Promise[] arr_promise) {
        this(true, arr_promise);
    }

    public static Future cascade(Future future0, Promise promise0) {
        return PromiseNotifier.cascade(true, future0, promise0);
    }

    public static Future cascade(boolean z, Future future0, Promise promise0) {
        promise0.addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isCancelled()) {
                    future0.cancel(false);
                }
            }
        });
        future0.addListener(new PromiseNotifier(z, new Promise[]{promise0}) {
            @Override  // io.netty.util.concurrent.PromiseNotifier
            public void operationComplete(Future future0) {
                if(promise0.isCancelled() && future0.isCancelled()) {
                    return;
                }
                super.operationComplete(future0);
            }
        });
        return future0;
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future future0) {
        InternalLogger internalLogger0 = this.logNotifyFailure ? PromiseNotifier.logger : null;
        int v = 0;
        if(future0.isSuccess()) {
            Object object0 = future0.get();
            Promise[] arr_promise = this.promises;
            while(v < arr_promise.length) {
                PromiseNotificationUtil.trySuccess(arr_promise[v], object0, internalLogger0);
                ++v;
            }
            return;
        }
        if(future0.isCancelled()) {
            Promise[] arr_promise1 = this.promises;
            while(v < arr_promise1.length) {
                PromiseNotificationUtil.tryCancel(arr_promise1[v], internalLogger0);
                ++v;
            }
            return;
        }
        Throwable throwable0 = future0.cause();
        Promise[] arr_promise2 = this.promises;
        while(v < arr_promise2.length) {
            PromiseNotificationUtil.tryFailure(arr_promise2[v], throwable0, internalLogger0);
            ++v;
        }
    }
}

