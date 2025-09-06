package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class TabCallbackDelegateImpl implements U {
    static class TabCallbackStub extends Stub {
        private final X mCallback;

        public TabCallbackStub(X x0) {
        }

        private Object lambda$onTabSelected$0(String s) {
            throw null;
        }

        @Override  // androidx.car.app.model.ITabCallback
        public void onTabSelected(String s, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onTabSelected", new p(this, s, 2));
        }
    }

    private final ITabCallback mStubCallback;

    private TabCallbackDelegateImpl() {
        this.mStubCallback = null;
    }

    private TabCallbackDelegateImpl(X x0) {
        this.mStubCallback = new TabCallbackStub(x0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static U create(X x0) {
        return new TabCallbackDelegateImpl(x0);
    }

    public void sendTabSelected(String s, h h0) {
        try {
            Objects.requireNonNull(this.mStubCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mStubCallback.onTabSelected(s, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

