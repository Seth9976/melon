package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class OnSelectedDelegateImpl implements H {
    static class OnSelectedListenerStub extends Stub {
        private final t mListener;

        public OnSelectedListenerStub(t t0) {
        }

        private Object lambda$onSelected$0(int v) {
            throw null;
        }

        @Override  // androidx.car.app.model.IOnSelectedListener
        public void onSelected(int v, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onSelectedListener", new androidx.car.app.model.g(this, v, 1));
        }
    }

    private final IOnSelectedListener mStub;

    private OnSelectedDelegateImpl() {
        this.mStub = null;
    }

    private OnSelectedDelegateImpl(t t0) {
        this.mStub = new OnSelectedListenerStub(t0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static H create(t t0) {
        return new OnSelectedDelegateImpl(t0);
    }

    public void sendSelected(int v, h h0) {
        try {
            Objects.requireNonNull(this.mStub);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mStub.onSelected(v, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

