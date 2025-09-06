package androidx.loader.content;

import V2.a;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateUtils;
import e0.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class AsyncTaskLoader extends Loader {
    private static final boolean DEBUG = false;
    private static final String TAG = "AsyncTaskLoader";
    private volatile a mCancellingTask;
    private Executor mExecutor;
    private Handler mHandler;
    private long mLastLoadCompleteTime;
    private volatile a mTask;
    private long mUpdateThrottle;

    public AsyncTaskLoader(Context context0) {
        super(context0);
        this.mLastLoadCompleteTime = -10000L;
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(a a0, Object object0) {
        this.onCanceled(object0);
        if(this.mCancellingTask == a0) {
            this.rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            this.executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(a a0, Object object0) {
        if(this.mTask != a0) {
            this.dispatchOnCancelled(a0, object0);
            return;
        }
        if(this.isAbandoned()) {
            this.onCanceled(object0);
            return;
        }
        this.commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        this.deliverResult(object0);
    }

    @Override  // androidx.loader.content.Loader
    @Deprecated
    public void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(s, fileDescriptor0, printWriter0, arr_s);
        if(this.mTask != null) {
            printWriter0.print(s);
            printWriter0.print("mTask=");
            printWriter0.print(this.mTask);
            printWriter0.print(" waiting=");
            printWriter0.println(this.mTask.e);
        }
        if(this.mCancellingTask != null) {
            printWriter0.print(s);
            printWriter0.print("mCancellingTask=");
            printWriter0.print(this.mCancellingTask);
            printWriter0.print(" waiting=");
            printWriter0.println(this.mCancellingTask.e);
        }
        if(this.mUpdateThrottle != 0L) {
            printWriter0.print(s);
            printWriter0.print("mUpdateThrottle=");
            TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
            printWriter0.print(DateUtils.formatElapsedTime(timeUnit0.toSeconds(this.mUpdateThrottle)));
            printWriter0.print(" mLastLoadCompleteTime=");
            printWriter0.print((this.mLastLoadCompleteTime == -10000L ? "--" : "-" + DateUtils.formatElapsedTime(timeUnit0.toSeconds(SystemClock.uptimeMillis() - this.mLastLoadCompleteTime))));
            printWriter0.println();
        }
    }

    public void executePendingTask() {
        if(this.mCancellingTask == null && this.mTask != null) {
            if(this.mTask.e) {
                this.mTask.e = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if(Long.compare(this.mUpdateThrottle, 0L) > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.e = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                return;
            }
            if(this.mExecutor == null) {
                this.mExecutor = this.getExecutor();
            }
            a a0 = this.mTask;
            Executor executor0 = this.mExecutor;
            if(a0.b != 1) {
                switch(b.b(a0.b)) {
                    case 1: {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    }
                    case 2: {
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                    default: {
                        throw new IllegalStateException("We should never reach this state");
                    }
                }
            }
            a0.b = 2;
            executor0.execute(a0.a);
        }
    }

    public Executor getExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract Object loadInBackground();

    @Override  // androidx.loader.content.Loader
    public boolean onCancelLoad() {
        if(this.mTask != null) {
            if(!this.isStarted()) {
                this.onContentChanged();
            }
            if(this.mCancellingTask != null) {
                if(this.mTask.e) {
                    this.mTask.e = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
                return false;
            }
            if(this.mTask.e) {
                this.mTask.e = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
                return false;
            }
            a a0 = this.mTask;
            a0.c.set(true);
            boolean z = a0.a.cancel(false);
            if(z) {
                this.mCancellingTask = this.mTask;
                this.cancelLoadInBackground();
            }
            this.mTask = null;
            return z;
        }
        return false;
    }

    public void onCanceled(Object object0) {
    }

    @Override  // androidx.loader.content.Loader
    public void onForceLoad() {
        this.cancelLoad();
        this.mTask = new a(this);
        this.executePendingTask();
    }

    public Object onLoadInBackground() {
        return this.loadInBackground();
    }

    public void setUpdateThrottle(long v) {
        this.mUpdateThrottle = v;
        if(v != 0L) {
            this.mHandler = new Handler();
        }
    }
}

