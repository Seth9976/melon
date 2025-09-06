package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements LoaderErrorThrower {
    public interface Callback {
        void onLoadCanceled(Loadable arg1, long arg2, long arg3, boolean arg4);

        void onLoadCompleted(Loadable arg1, long arg2, long arg3);

        LoadErrorAction onLoadError(Loadable arg1, long arg2, long arg3, IOException arg4, int arg5);
    }

    public static final class LoadErrorAction {
        private final long retryDelayMillis;
        private final int type;

        private LoadErrorAction(int v, long v1) {
            this.type = v;
            this.retryDelayMillis = v1;
        }

        public LoadErrorAction(int v, long v1, com.google.android.exoplayer2.upstream.Loader.1 loader$10) {
            this(v, v1);
        }

        public boolean isRetry() {
            return this.type == 0 || this.type == 1;
        }
    }

    @SuppressLint({"HandlerLeak"})
    final class LoadTask extends Handler implements Runnable {
        private static final int MSG_FATAL_ERROR = 3;
        private static final int MSG_FINISH = 1;
        private static final int MSG_IO_EXCEPTION = 2;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";
        private Callback callback;
        private boolean canceled;
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;
        private Thread executorThread;
        private final Loadable loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper0, Loadable loader$Loadable0, Callback loader$Callback0, int v, long v1) {
            super(looper0);
            this.loadable = loader$Loadable0;
            this.callback = loader$Callback0;
            this.defaultMinRetryCount = v;
            this.startTimeMs = v1;
        }

        public void cancel(boolean z) {
            this.released = z;
            this.currentError = null;
            if(this.hasMessages(0)) {
                this.canceled = true;
                this.removeMessages(0);
                if(!z) {
                    this.sendEmptyMessage(1);
                }
            }
            else {
                synchronized(this) {
                    this.canceled = true;
                    this.loadable.cancelLoad();
                    Thread thread0 = this.executorThread;
                    if(thread0 != null) {
                        thread0.interrupt();
                    }
                }
            }
            if(z) {
                this.finish();
                long v = SystemClock.elapsedRealtime();
                ((Callback)Assertions.checkNotNull(this.callback)).onLoadCanceled(this.loadable, v, v - this.startTimeMs, true);
                this.callback = null;
            }
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute(((Runnable)Assertions.checkNotNull(Loader.this.currentTask)));
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return (long)Math.min((this.errorCount - 1) * 1000, 5000);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            if(!this.released) {
                int v = message0.what;
                if(v == 0) {
                    this.execute();
                    return;
                }
                if(v != 3) {
                    this.finish();
                    long v1 = SystemClock.elapsedRealtime();
                    long v2 = v1 - this.startTimeMs;
                    Callback loader$Callback0 = (Callback)Assertions.checkNotNull(this.callback);
                    if(this.canceled) {
                        loader$Callback0.onLoadCanceled(this.loadable, v1, v2, false);
                        return;
                    }
                    switch(message0.what) {
                        case 1: {
                            try {
                                loader$Callback0.onLoadCompleted(this.loadable, v1, v2);
                            }
                            catch(RuntimeException runtimeException0) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", runtimeException0);
                                UnexpectedLoaderException loader$UnexpectedLoaderException0 = new UnexpectedLoaderException(runtimeException0);
                                Loader.this.fatalError = loader$UnexpectedLoaderException0;
                            }
                            return;
                        }
                        case 2: {
                            this.currentError = (IOException)message0.obj;
                            int v3 = this.errorCount + 1;
                            this.errorCount = v3;
                            LoadErrorAction loader$LoadErrorAction0 = loader$Callback0.onLoadError(this.loadable, v1, v2, ((IOException)message0.obj), v3);
                            if(loader$LoadErrorAction0.type == 3) {
                                Loader.this.fatalError = this.currentError;
                                return;
                            }
                            switch(loader$LoadErrorAction0.type) {
                                case 1: {
                                    this.errorCount = 1;
                                    this.start((loader$LoadErrorAction0.retryDelayMillis == 0x8000000000000001L ? this.getRetryDelayMillis() : loader$LoadErrorAction0.retryDelayMillis));
                                    return;
                                }
                                case 2: {
                                    return;
                                }
                                default: {
                                    this.start((loader$LoadErrorAction0.retryDelayMillis == 0x8000000000000001L ? this.getRetryDelayMillis() : loader$LoadErrorAction0.retryDelayMillis));
                                    return;
                                }
                            }
                        }
                        default: {
                            return;
                        }
                    }
                }
                throw (Error)message0.obj;
            }
        }

        public void maybeThrowError(int v) {
            IOException iOException0 = this.currentError;
            if(iOException0 != null && this.errorCount > v) {
                throw iOException0;
            }
        }

        @Override
        public void run() {
            try {
                __monitor_enter(this);
                this.executorThread = Thread.currentThread();
                __monitor_exit(this);
                if(!this.canceled) {
                    String s = this.loadable.getClass().getSimpleName();
                    TraceUtil.beginSection((s.length() == 0 ? new String("load:") : "load:" + s));
                    try {
                        this.loadable.load();
                    }
                    finally {
                        TraceUtil.endSection();
                    }
                }
                synchronized(this) {
                    this.executorThread = null;
                    Thread.interrupted();
                }
                if(!this.released) {
                    this.sendEmptyMessage(1);
                    return;
                label_28:
                    if(!this.released) {
                        goto label_29;
                    }
                }
                return;
            }
            catch(IOException iOException0) {
                goto label_28;
            }
            catch(InterruptedException unused_ex) {
                goto label_31;
            }
            catch(Exception exception0) {
                goto label_35;
            }
            catch(OutOfMemoryError outOfMemoryError0) {
                goto label_39;
            }
            catch(Error error0) {
                goto label_43;
            }
        label_29:
            this.obtainMessage(2, iOException0).sendToTarget();
            return;
        label_31:
            Assertions.checkState(this.canceled);
            if(!this.released) {
                this.sendEmptyMessage(1);
                return;
            label_35:
                Log.e("LoadTask", "Unexpected exception loading stream", exception0);
                if(!this.released) {
                    this.obtainMessage(2, new UnexpectedLoaderException(exception0)).sendToTarget();
                    return;
                label_39:
                    Log.e("LoadTask", "OutOfMemory error loading stream", outOfMemoryError0);
                    if(!this.released) {
                        this.obtainMessage(2, new UnexpectedLoaderException(outOfMemoryError0)).sendToTarget();
                        return;
                    label_43:
                        Log.e("LoadTask", "Unexpected error loading stream", error0);
                        if(!this.released) {
                            this.obtainMessage(3, error0).sendToTarget();
                        }
                        throw error0;
                    }
                }
            }
        }

        public void start(long v) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if(v > 0L) {
                this.sendEmptyMessageDelayed(0, v);
                return;
            }
            this.execute();
        }
    }

    public interface Loadable {
        void cancelLoad();

        void load();
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback loader$ReleaseCallback0) {
            this.callback = loader$ReleaseCallback0;
        }

        @Override
        public void run() {
            this.callback.onLoaderReleased();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable throwable0) {
            super("Unexpected " + throwable0.getClass().getSimpleName() + ": " + throwable0.getMessage(), throwable0);
        }
    }

    private static final int ACTION_TYPE_DONT_RETRY = 2;
    private static final int ACTION_TYPE_DONT_RETRY_FATAL = 3;
    private static final int ACTION_TYPE_RETRY = 0;
    private static final int ACTION_TYPE_RETRY_AND_RESET_ERROR_COUNT = 1;
    public static final LoadErrorAction DONT_RETRY;
    public static final LoadErrorAction DONT_RETRY_FATAL;
    public static final LoadErrorAction RETRY;
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT;
    private LoadTask currentTask;
    private final ExecutorService downloadExecutorService;
    private IOException fatalError;

    static {
        Loader.RETRY = Loader.createRetryAction(false, 0x8000000000000001L);
        Loader.RETRY_RESET_ERROR_COUNT = Loader.createRetryAction(true, 0x8000000000000001L);
        Loader.DONT_RETRY = new LoadErrorAction(2, 0x8000000000000001L, null);
        Loader.DONT_RETRY_FATAL = new LoadErrorAction(3, 0x8000000000000001L, null);
    }

    public Loader(String s) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(s);
    }

    public void cancelLoading() {
        ((LoadTask)Assertions.checkStateNotNull(this.currentTask)).cancel(false);
    }

    public void clearFatalError() {
        this.fatalError = null;
    }

    public static LoadErrorAction createRetryAction(boolean z, long v) {
        return new LoadErrorAction(((int)z), v, null);
    }

    public boolean hasFatalError() {
        return this.fatalError != null;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    @Override  // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() {
        this.maybeThrowError(0x80000000);
    }

    @Override  // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int v) {
        IOException iOException0 = this.fatalError;
        if(iOException0 != null) {
            throw iOException0;
        }
        LoadTask loader$LoadTask0 = this.currentTask;
        if(loader$LoadTask0 != null) {
            if(v == 0x80000000) {
                v = loader$LoadTask0.defaultMinRetryCount;
            }
            loader$LoadTask0.maybeThrowError(v);
        }
    }

    public void release() {
        this.release(null);
    }

    public void release(ReleaseCallback loader$ReleaseCallback0) {
        LoadTask loader$LoadTask0 = this.currentTask;
        if(loader$LoadTask0 != null) {
            loader$LoadTask0.cancel(true);
        }
        if(loader$ReleaseCallback0 != null) {
            ReleaseTask loader$ReleaseTask0 = new ReleaseTask(loader$ReleaseCallback0);
            this.downloadExecutorService.execute(loader$ReleaseTask0);
        }
        this.downloadExecutorService.shutdown();
    }

    public long startLoading(Loadable loader$Loadable0, Callback loader$Callback0, int v) {
        Object object0 = Assertions.checkStateNotNull(Looper.myLooper());
        this.fatalError = null;
        long v1 = SystemClock.elapsedRealtime();
        new LoadTask(this, ((Looper)object0), loader$Loadable0, loader$Callback0, v, v1).start(0L);
        return v1;
    }

    class com.google.android.exoplayer2.upstream.Loader.1 {
    }

}

