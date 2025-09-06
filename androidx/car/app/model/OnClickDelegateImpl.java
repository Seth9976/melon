package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class OnClickDelegateImpl implements B {
    static class OnClickListenerStub extends Stub {
        private final C mOnClickListener;

        public OnClickListenerStub(C c0) {
            this.mOnClickListener = c0;
        }

        private Object lambda$onClick$0() {
            this.mOnClickListener.onClick();
            return null;
        }

        @Override  // androidx.car.app.model.IOnClickListener
        public void onClick(IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onClick", new f(this, 1));
        }
    }

    private final boolean mIsParkedOnly;
    private final IOnClickListener mListener;

    private OnClickDelegateImpl() {
        this.mListener = null;
        this.mIsParkedOnly = false;
    }

    private OnClickDelegateImpl(C c0, boolean z) {
        this.mListener = new OnClickListenerStub(c0);
        this.mIsParkedOnly = z;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static B create(C c0) {
        return new OnClickDelegateImpl(c0, c0 instanceof ParkedOnlyOnClickListener);
    }

    @Override  // androidx.car.app.model.B
    public boolean isParkedOnly() {
        return this.mIsParkedOnly;
    }

    public void sendClick(h h0) {
        try {
            Objects.requireNonNull(this.mListener);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mListener.onClick(iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

