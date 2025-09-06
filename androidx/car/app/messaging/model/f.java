package androidx.car.app.messaging.model;

import N1.C;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public final String a;
    public final CarText b;
    public final C c;
    public final CarIcon d;
    public final boolean e;
    public List f;
    public final c g;
    public final ArrayList h;

    public f(ConversationItem conversationItem0) {
        this.a = conversationItem0.getId();
        this.b = conversationItem0.getTitle();
        this.c = conversationItem0.getSelf();
        this.d = conversationItem0.getIcon();
        this.e = conversationItem0.isGroupConversation();
        this.g = conversationItem0.getConversationCallbackDelegate();
        this.f = conversationItem0.getMessages();
        this.h = new ArrayList(conversationItem0.getActions());
    }
}

