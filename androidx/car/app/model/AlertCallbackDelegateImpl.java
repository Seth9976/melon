package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class AlertCallbackDelegateImpl implements e {
    static class AlertCallbackStub extends Stub {
        private final d mCallback;

        public AlertCallbackStub(d d0) {
        }

        private Object lambda$onAlertCancelled$0(int v) {
            throw null;
        }

        private Object lambda$onAlertDismissed$1() {
            throw null;
        }

        @Override  // androidx.car.app.model.IAlertCallback
        public void onAlertCancelled(int v, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onCancel", new androidx.car.app.model.g(this, v, 0));
        }

        @Override  // androidx.car.app.model.IAlertCallback
        public void onAlertDismissed(IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onDismiss", new f(this, 0));
        }
    }

    private final IAlertCallback mCallback;

    private AlertCallbackDelegateImpl() {
        this.mCallback = null;
    }

    private AlertCallbackDelegateImpl(d d0) {
        this.mCallback = new AlertCallbackStub(d0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static e create(d d0) {
        return new AlertCallbackDelegateImpl(d0);
    }

    public void sendCancel(int v, h h0) {
        try {
            Objects.requireNonNull(this.mCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mCallback.onAlertCancelled(v, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }

    public void sendDismiss(h h0) {
        try {
            Objects.requireNonNull(this.mCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mCallback.onAlertDismissed(iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

