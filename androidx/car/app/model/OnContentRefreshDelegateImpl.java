package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class OnContentRefreshDelegateImpl implements D {
    static class OnContentRefreshListenerStub extends Stub {
        private final E mOnContentRefreshListener;

        public OnContentRefreshListenerStub(E e0) {
        }

        private Object lambda$onContentRefreshRequested$0() {
            throw null;
        }

        @Override  // androidx.car.app.model.IOnContentRefreshListener
        public void onContentRefreshRequested(IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onClick", new f(this, 2));
        }
    }

    private final IOnContentRefreshListener mListener;

    private OnContentRefreshDelegateImpl() {
        this.mListener = null;
    }

    private OnContentRefreshDelegateImpl(E e0) {
        this.mListener = new OnContentRefreshListenerStub(e0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static D create(E e0) {
        return new OnContentRefreshDelegateImpl(e0);
    }

    public void sendContentRefreshRequested(h h0) {
        try {
            Objects.requireNonNull(this.mListener);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mListener.onContentRefreshRequested(iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

