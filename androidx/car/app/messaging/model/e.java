package androidx.car.app.messaging.model;

import androidx.car.app.utils.a;

public final class e implements a {
    public final ConversationCallbackStub a;

    public e(ConversationCallbackStub conversationCallbackDelegateImpl$ConversationCallbackStub0) {
        this.a = conversationCallbackDelegateImpl$ConversationCallbackStub0;
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a.lambda$onMarkAsRead$0();
    }
}

