package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.RemoteException;

@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    class MyResultReceiver extends Stub {
        @Override  // android.support.v4.os.IResultReceiver
        public void send(int v, Bundle bundle0) {
            ResultReceiver resultReceiver0 = ResultReceiver.this;
            Handler handler0 = resultReceiver0.mHandler;
            if(handler0 != null) {
                handler0.post(new MyRunnable(resultReceiver0, v, bundle0));
                return;
            }
            resultReceiver0.onReceiveResult(v, bundle0);
        }
    }

    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;

        public MyRunnable(int v, Bundle bundle0) {
            this.mResultCode = v;
            this.mResultData = bundle0;
        }

        @Override
        public void run() {
            ResultReceiver.this.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    public static final Parcelable.Creator CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    static {
        ResultReceiver.CREATOR = new Parcelable.Creator() {
            public ResultReceiver createFromParcel(Parcel parcel0) {
                return new ResultReceiver(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ResultReceiver[] newArray(int v) {
                return new ResultReceiver[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ResultReceiver(Handler handler0) {
        this.mLocal = true;
        this.mHandler = handler0;
    }

    public ResultReceiver(Parcel parcel0) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = Stub.asInterface(parcel0.readStrongBinder());
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 检测为 Lambda 实现
    public void onReceiveResult(int v, Bundle bundle0) [...]

    public void send(int v, Bundle bundle0) {
        if(this.mLocal) {
            Handler handler0 = this.mHandler;
            if(handler0 != null) {
                handler0.post(() -> {
                });
                return;
            }
            this.onReceiveResult(v, bundle0);
            return;
        }
        IResultReceiver iResultReceiver0 = this.mReceiver;
        if(iResultReceiver0 != null) {
            try {
                iResultReceiver0.send(v, bundle0);
            }
            catch(RemoteException unused_ex) {
            }
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        synchronized(this) {
            if(this.mReceiver == null) {
                this.mReceiver = new MyResultReceiver(this);
            }
            parcel0.writeStrongBinder(this.mReceiver.asBinder());
        }
    }
}

