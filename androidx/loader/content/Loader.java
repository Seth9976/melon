package androidx.loader.content;

import U4.x;
import V2.b;
import V2.c;
import android.content.Context;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader {
    private boolean mAbandoned;
    private boolean mContentChanged;
    private Context mContext;
    private int mId;
    private c mListener;
    private b mOnLoadCanceledListener;
    private boolean mProcessingChange;
    private boolean mReset;
    private boolean mStarted;

    public Loader(Context context0) {
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = context0.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
    }

    public boolean cancelLoad() {
        return this.onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(Object object0) {
        StringBuilder stringBuilder0 = new StringBuilder(0x40);
        if(object0 == null) {
            stringBuilder0.append("null");
            return stringBuilder0.toString();
        }
        Class class0 = object0.getClass();
        stringBuilder0.append(class0.getSimpleName());
        stringBuilder0.append("{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(class0)));
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }

    public void deliverCancellation() {
    }

    public void deliverResult(Object object0) {
        c c0 = this.mListener;
        if(c0 != null) {
            if(Looper.myLooper() == Looper.getMainLooper()) {
                ((U2.c)c0).setValue(object0);
                return;
            }
            ((U2.c)c0).postValue(object0);
        }
    }

    public void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        printWriter0.print(s);
        printWriter0.print("mId=");
        printWriter0.print(this.mId);
        printWriter0.print(" mListener=");
        printWriter0.println(this.mListener);
        if(this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter0.print(s);
            printWriter0.print("mStarted=");
            printWriter0.print(this.mStarted);
            printWriter0.print(" mContentChanged=");
            printWriter0.print(this.mContentChanged);
            printWriter0.print(" mProcessingChange=");
            printWriter0.println(this.mProcessingChange);
        }
        if(!this.mAbandoned && !this.mReset) {
            return;
        }
        printWriter0.print(s);
        printWriter0.print("mAbandoned=");
        printWriter0.print(this.mAbandoned);
        printWriter0.print(" mReset=");
        printWriter0.println(this.mReset);
    }

    public void forceLoad() {
        this.onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void onAbandon() {
    }

    public boolean onCancelLoad() {
        return false;
    }

    public void onContentChanged() {
        if(this.mStarted) {
            this.forceLoad();
            return;
        }
        this.mContentChanged = true;
    }

    public void onForceLoad() {
    }

    public void onReset() {
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void registerListener(int v, c c0) {
        if(this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = c0;
        this.mId = v;
    }

    public void registerOnLoadCanceledListener(b b0) {
    }

    public void reset() {
        this.onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if(this.mProcessingChange) {
            this.onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        this.onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        this.onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x40);
        Class class0 = this.getClass();
        stringBuilder0.append(class0.getSimpleName());
        stringBuilder0.append("{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(class0)));
        stringBuilder0.append(" id=");
        return x.g(this.mId, "}", stringBuilder0);
    }

    public void unregisterListener(c c0) {
        c c1 = this.mListener;
        if(c1 == null) {
            throw new IllegalStateException("No listener register");
        }
        if(c1 != c0) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mListener = null;
    }

    public void unregisterOnLoadCanceledListener(b b0) {
        throw new IllegalStateException("No listener register");
    }
}

