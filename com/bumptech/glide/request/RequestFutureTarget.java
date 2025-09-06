package com.bumptech.glide.request;

import U4.x;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget implements FutureTarget, RequestListener {
    static class Waiter {
        public void notifyAll(Object object0) {
            object0.notifyAll();
        }

        public void waitForTimeout(Object object0, long v) {
            object0.wait(v);
        }
    }

    private static final Waiter DEFAULT_WAITER;
    private final boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private Request request;
    private Object resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    static {
        RequestFutureTarget.DEFAULT_WAITER = new Waiter();
    }

    public RequestFutureTarget(int v, int v1) {
        this(v, v1, true, RequestFutureTarget.DEFAULT_WAITER);
    }

    public RequestFutureTarget(int v, int v1, boolean z, Waiter requestFutureTarget$Waiter0) {
        this.width = v;
        this.height = v1;
        this.assertBackgroundThread = z;
        this.waiter = requestFutureTarget$Waiter0;
    }

    @Override
    public boolean cancel(boolean z) {
        Request request0;
        synchronized(this) {
            if(this.isDone()) {
                return false;
            }
            this.isCancelled = true;
            this.waiter.notifyAll(this);
            request0 = null;
            if(z) {
                Request request1 = this.request;
                this.request = null;
                request0 = request1;
            }
        }
        if(request0 != null) {
            request0.clear();
        }
        return true;
    }

    private Object doGet(Long long0) {
        synchronized(this) {
            if(this.assertBackgroundThread && !this.isDone()) {
                Util.assertBackgroundThread();
            }
            if(!this.isCancelled) {
                if(this.loadFailed) {
                    throw new ExecutionException(this.exception);
                }
                if(this.resultReceived) {
                    return this.resource;
                }
                if(long0 == null) {
                    this.waiter.waitForTimeout(this, 0L);
                }
                else if(((long)long0) > 0L) {
                    long v1 = System.currentTimeMillis();
                    long v2 = ((long)long0) + v1;
                    while(!this.isDone() && v1 < v2) {
                        this.waiter.waitForTimeout(this, v2 - v1);
                        v1 = System.currentTimeMillis();
                    }
                }
                if(Thread.interrupted()) {
                    throw new InterruptedException();
                }
                if(this.loadFailed) {
                    throw new ExecutionException(this.exception);
                }
                if(this.isCancelled) {
                    throw new CancellationException();
                }
                if(!this.resultReceived) {
                    throw new TimeoutException();
                }
                return this.resource;
            }
        }
        throw new CancellationException();
    }

    @Override
    public Object get() {
        try {
            return this.doGet(null);
        }
        catch(TimeoutException timeoutException0) {
            throw new AssertionError(timeoutException0);
        }
    }

    @Override
    public Object get(long v, TimeUnit timeUnit0) {
        return this.doGet(timeUnit0.toMillis(v));
    }

    @Override  // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        synchronized(this) {
        }
        return this.request;
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback0) {
        sizeReadyCallback0.onSizeReady(this.width, this.height);
    }

    @Override
    public boolean isCancelled() {
        synchronized(this) {
        }
        return this.isCancelled;
    }

    @Override
    public boolean isDone() {
        synchronized(this) {
        }
        return this.isCancelled || this.resultReceived || this.loadFailed;
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable0) {
        synchronized(this) {
        }
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException0, Object object0, Target target0, boolean z) {
        synchronized(this) {
            this.loadFailed = true;
            this.exception = glideException0;
            this.waiter.notifyAll(this);
            return false;
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object object0, Transition transition0) {
        synchronized(this) {
        }
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Object object0, Object object1, Target target0, DataSource dataSource0, boolean z) {
        synchronized(this) {
            this.resultReceived = true;
            this.resource = object0;
            this.waiter.notifyAll(this);
            return false;
        }
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void setRequest(Request request0) {
        synchronized(this) {
            this.request = request0;
        }
    }

    @Override
    public String toString() {
        String s1;
        Request request0 = null;
        String s = x.m(new StringBuilder(), super.toString(), "[status=");
        synchronized(this) {
            if(this.isCancelled) {
                s1 = "CANCELLED";
            }
            else if(this.loadFailed) {
                s1 = "FAILURE";
            }
            else if(this.resultReceived) {
                s1 = "SUCCESS";
            }
            else {
                s1 = "PENDING";
                request0 = this.request;
            }
        }
        return request0 == null ? s + s1 + "]" : s + s1 + ", request=[" + request0 + "]]";
    }
}

