package androidx.car.app.messaging.model;

import androidx.car.app.utils.a;

public final class d implements a {
    public final ConversationCallbackStub a;
    public final String b;

    public d(ConversationCallbackStub conversationCallbackDelegateImpl$ConversationCallbackStub0, String s) {
        this.a = conversationCallbackDelegateImpl$ConversationCallbackStub0;
        this.b = s;
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a.lambda$onTextReply$1(this.b);
    }
}

