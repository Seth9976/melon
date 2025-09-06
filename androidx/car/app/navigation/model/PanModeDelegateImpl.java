package androidx.car.app.navigation.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import java.util.Objects;

public class PanModeDelegateImpl implements g {
    static class PanModeListenerStub extends Stub {
        private final i mListener;

        public PanModeListenerStub(i i0) {
        }

        // 检测为 Lambda 实现
        private Object lambda$onPanModeChanged$0(boolean z) [...]

        @Override  // androidx.car.app.navigation.model.IPanModeListener
        public void onPanModeChanged(boolean z, IOnDoneCallback iOnDoneCallback0) {
            androidx.car.app.utils.g.b(iOnDoneCallback0, "onPanModeChanged", () -> throw null);
        }
    }

    private final IPanModeListener mStub;

    private PanModeDelegateImpl() {
        this.mStub = null;
    }

    private PanModeDelegateImpl(i i0) {
        this.mStub = new PanModeListenerStub(i0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static g create(i i0) {
        return new PanModeDelegateImpl(i0);
    }

    public void sendPanModeChanged(boolean z, h h0) {
        try {
            Objects.requireNonNull(this.mStub);
            IOnDoneCallback iOnDoneCallback0 = androidx.car.app.utils.g.a();
            this.mStub.onPanModeChanged(z, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

