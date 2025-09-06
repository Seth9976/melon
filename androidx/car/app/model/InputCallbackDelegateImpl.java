package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class InputCallbackDelegateImpl implements o {
    static class OnInputCallbackStub extends Stub {
        private final n mCallback;

        public OnInputCallbackStub(n n0) {
        }

        private Object lambda$onInputSubmitted$0(String s) {
            throw null;
        }

        private Object lambda$onInputTextChanged$1(String s) {
            throw null;
        }

        @Override  // androidx.car.app.model.IInputCallback
        public void onInputSubmitted(String s, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onInputSubmitted", new p(this, s, 1));
        }

        @Override  // androidx.car.app.model.IInputCallback
        public void onInputTextChanged(String s, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onInputTextChanged", new p(this, s, 0));
        }
    }

    private final IInputCallback mCallback;

    private InputCallbackDelegateImpl() {
        this.mCallback = null;
    }

    private InputCallbackDelegateImpl(n n0) {
        this.mCallback = new OnInputCallbackStub(n0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static o create(n n0) {
        Objects.requireNonNull(n0);
        throw new ClassCastException();
    }

    public void sendInputSubmitted(String s, h h0) {
        try {
            Objects.requireNonNull(this.mCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mCallback.onInputSubmitted(s, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }

    public void sendInputTextChanged(String s, h h0) {
        try {
            Objects.requireNonNull(this.mCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mCallback.onInputTextChanged(s, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

