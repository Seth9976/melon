package androidx.car.app.model;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

public class SearchCallbackDelegateImpl implements O {
    static class SearchCallbackStub extends Stub {
        private final S mCallback;

        public SearchCallbackStub(S s0) {
        }

        private Object lambda$onSearchSubmitted$1(String s) {
            throw null;
        }

        private Object lambda$onSearchTextChanged$0(String s) {
            throw null;
        }

        @Override  // androidx.car.app.model.ISearchCallback
        public void onSearchSubmitted(String s, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onSearchSubmitted", new P(this, s, 0));
        }

        @Override  // androidx.car.app.model.ISearchCallback
        public void onSearchTextChanged(String s, IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onSearchTextChanged", new P(this, s, 1));
        }
    }

    private final ISearchCallback mStubCallback;

    private SearchCallbackDelegateImpl() {
        this.mStubCallback = null;
    }

    private SearchCallbackDelegateImpl(S s0) {
        this.mStubCallback = new SearchCallbackStub(s0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static O create(S s0) {
        return new SearchCallbackDelegateImpl(s0);
    }

    public void sendSearchSubmitted(String s, h h0) {
        try {
            Objects.requireNonNull(this.mStubCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mStubCallback.onSearchSubmitted(s, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }

    public void sendSearchTextChanged(String s, h h0) {
        try {
            Objects.requireNonNull(this.mStubCallback);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mStubCallback.onSearchTextChanged(s, iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

