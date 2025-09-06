package androidx.car.app.messaging.model;

import android.os.RemoteException;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.h;
import androidx.car.app.utils.g;
import java.util.Objects;

class ConversationCallbackDelegateImpl implements c {
    static class ConversationCallbackStub extends Stub {
        private final b mConversationCallback;

        public ConversationCallbackStub(b b0) {
            this.mConversationCallback = b0;
        }

        // 检测为 Lambda 实现
        private Object lambda$onMarkAsRead$0() [...]

        // 检测为 Lambda 实现
        private Object lambda$onTextReply$1(String s) [...]

        @Override  // androidx.car.app.messaging.model.IConversationCallback
        public void onMarkAsRead(IOnDoneCallback iOnDoneCallback0) {
            g.b(iOnDoneCallback0, "onMarkAsRead", () -> {
                this.mConversationCallback.getClass();
                return null;
            });
        }

        @Override  // androidx.car.app.messaging.model.IConversationCallback
        public void onTextReply(IOnDoneCallback iOnDoneCallback0, String s) {
            g.b(iOnDoneCallback0, "onReply", () -> {
                this.mConversationCallback.getClass();
                return null;
            });
        }
    }

    private final IConversationCallback mConversationCallbackBinder;

    private ConversationCallbackDelegateImpl() {
        this.mConversationCallbackBinder = null;
    }

    public ConversationCallbackDelegateImpl(b b0) {
        this.mConversationCallbackBinder = new ConversationCallbackStub(b0);
    }

    public void sendMarkAsRead(h h0) {
        try {
            Objects.requireNonNull(this.mConversationCallbackBinder);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mConversationCallbackBinder.onMarkAsRead(iOnDoneCallback0);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }

    public void sendTextReply(String s, h h0) {
        try {
            Objects.requireNonNull(this.mConversationCallbackBinder);
            IOnDoneCallback iOnDoneCallback0 = g.a();
            this.mConversationCallbackBinder.onTextReply(iOnDoneCallback0, s);
        }
        catch(RemoteException remoteException0) {
            throw new RuntimeException(remoteException0);
        }
    }
}

