package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class OnItemVisibilityChangedDelegateImpl implements F {
    static class OnItemVisibilityChangedListenerStub extends Stub {
        private final s mListener;

        public OnItemVisibilityChangedListenerStub(s s0) {
        }

        // 检测为 Lambda 实现
        private Object lambda$onItemVisibilityChanged$0(int v, int v1) [...]

        @Override  // androidx.car.app.model.IOnItemVisibilityChangedListener
        public void onItemVisibilityChanged(int v, int v1, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onItemVisibilityChanged", () -> throw null);
        }
    }

    private final IOnItemVisibilityChangedListener mStub;

    private OnItemVisibilityChangedDelegateImpl() {
        this.mStub = null;
    }

    private OnItemVisibilityChangedDelegateImpl(s s0) {
        this.mStub = new OnItemVisibilityChangedListenerStub(s0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static F create(s s0) {
        return new OnItemVisibilityChangedDelegateImpl(s0);
    }

    public void sendItemVisibilityChanged(int v, int v1, h h0) {
        try {
            Objects.requireNonNull(this.mStub);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mStub.onItemVisibilityChanged(v, v1, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

