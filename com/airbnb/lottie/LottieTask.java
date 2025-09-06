package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import l.a;

public class LottieTask {
    static class LottieFutureTask extends FutureTask {
        private LottieTask lottieTask;

        public LottieFutureTask(LottieTask lottieTask0, Callable callable0) {
            super(callable0);
            this.lottieTask = lottieTask0;
        }

        @Override
        public void done() {
            try {
                if(this.isCancelled()) {
                    return;
                }
                try {
                    this.lottieTask.setResult(((LottieResult)this.get()));
                }
                catch(InterruptedException | ExecutionException interruptedException0) {
                    this.lottieTask.setResult(new LottieResult(interruptedException0));
                }
            }
            finally {
                this.lottieTask = null;
            }
        }
    }

    static final String DIRECT_EXECUTOR_PROPERTY_NAME = "lottie.testing.directExecutor";
    public static Executor EXECUTOR;
    private final Set failureListeners;
    private final Handler handler;
    private volatile LottieResult result;
    private final Set successListeners;

    static {
        if("true".equals(System.getProperty("lottie.testing.directExecutor"))) {
            LottieTask.EXECUTOR = new a(1);
            return;
        }
        LottieTask.EXECUTOR = Executors.newCachedThreadPool(new LottieThreadFactory());
    }

    public LottieTask(Object object0) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        this.setResult(new LottieResult(object0));
    }

    public LottieTask(Callable callable0) {
        this(callable0, false);
    }

    public LottieTask(Callable callable0, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if(z) {
            try {
                this.setResult(((LottieResult)callable0.call()));
            }
            catch(Throwable throwable0) {
                this.setResult(new LottieResult(throwable0));
            }
            return;
        }
        LottieTask.EXECUTOR.execute(new LottieFutureTask(this, callable0));
    }

    public LottieTask addFailureListener(LottieListener lottieListener0) {
        synchronized(this) {
            LottieResult lottieResult0 = this.result;
            if(lottieResult0 != null && lottieResult0.getException() != null) {
                lottieListener0.onResult(lottieResult0.getException());
            }
            this.failureListeners.add(lottieListener0);
            return this;
        }
    }

    public LottieTask addListener(LottieListener lottieListener0) {
        synchronized(this) {
            LottieResult lottieResult0 = this.result;
            if(lottieResult0 != null && lottieResult0.getValue() != null) {
                lottieListener0.onResult(lottieResult0.getValue());
            }
            this.successListeners.add(lottieListener0);
            return this;
        }
    }

    public LottieResult getResult() {
        return this.result;
    }

    private void notifyFailureListeners(Throwable throwable0) {
        synchronized(this) {
            ArrayList arrayList0 = new ArrayList(this.failureListeners);
            if(arrayList0.isEmpty()) {
                Logger.warning("Lottie encountered an error but no failure listener was added:", throwable0);
                return;
            }
            for(Object object0: arrayList0) {
                ((LottieListener)object0).onResult(throwable0);
            }
        }
    }

    private void notifyListeners() {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            this.notifyListenersInternal();
            return;
        }
        e e0 = new e(this, 3);
        this.handler.post(e0);
    }

    private void notifyListenersInternal() {
        LottieResult lottieResult0 = this.result;
        if(lottieResult0 == null) {
            return;
        }
        if(lottieResult0.getValue() != null) {
            this.notifySuccessListeners(lottieResult0.getValue());
            return;
        }
        this.notifyFailureListeners(lottieResult0.getException());
    }

    private void notifySuccessListeners(Object object0) {
        synchronized(this) {
            for(Object object1: new ArrayList(this.successListeners)) {
                ((LottieListener)object1).onResult(object0);
            }
        }
    }

    public LottieTask removeFailureListener(LottieListener lottieListener0) {
        synchronized(this) {
            this.failureListeners.remove(lottieListener0);
            return this;
        }
    }

    public LottieTask removeListener(LottieListener lottieListener0) {
        synchronized(this) {
            this.successListeners.remove(lottieListener0);
            return this;
        }
    }

    private void setResult(LottieResult lottieResult0) {
        if(this.result != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.result = lottieResult0;
        this.notifyListeners();
    }
}

