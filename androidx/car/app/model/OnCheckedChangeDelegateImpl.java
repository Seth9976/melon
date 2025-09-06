package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class OnCheckedChangeDelegateImpl implements z {
    static class OnCheckedChangeListenerStub extends Stub {
        private final a0 mListener;

        public OnCheckedChangeListenerStub(a0 a00) {
        }

        // 检测为 Lambda 实现
        private Object lambda$onCheckedChange$0(boolean z) [...]

        @Override  // androidx.car.app.model.IOnCheckedChangeListener
        public void onCheckedChange(boolean z, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onCheckedChange", () -> throw null);
        }
    }

    private final IOnCheckedChangeListener mStub;

    private OnCheckedChangeDelegateImpl() {
        this.mStub = null;
    }

    private OnCheckedChangeDelegateImpl(a0 a00) {
        this.mStub = new OnCheckedChangeListenerStub(a00);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static z create(a0 a00) {
        return new OnCheckedChangeDelegateImpl(a00);
    }

    public void sendCheckedChange(boolean z, h h0) {
        try {
            Objects.requireNonNull(this.mStub);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mStub.onCheckedChange(z, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

