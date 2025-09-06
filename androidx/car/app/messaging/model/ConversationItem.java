package androidx.car.app.messaging.model;

import N1.C;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText.Builder;
import androidx.car.app.model.CarText;
import androidx.car.app.model.q;
import androidx.car.app.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import y5.a;

public class ConversationItem implements q {
    private final List mActions;
    private final c mConversationCallbackDelegate;
    private final CarIcon mIcon;
    private final String mId;
    private final boolean mIsGroupConversation;
    private final List mMessages;
    private final C mSelf;
    private final CarText mTitle;

    private ConversationItem() {
        this.mId = "";
        this.mTitle = new Builder("").build();
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.a = "";
        c0.b = null;
        c0.c = null;
        c0.d = null;
        c0.e = false;
        c0.f = false;
        this.mSelf = c0;
        this.mIcon = null;
        this.mIsGroupConversation = false;
        this.mMessages = new ArrayList();
        this.mConversationCallbackDelegate = new ConversationCallbackDelegateImpl(new R6.c(15));
        this.mActions = Collections.EMPTY_LIST;
    }

    public ConversationItem(f f0) {
        Objects.requireNonNull(f0.a);
        this.mId = f0.a;
        Objects.requireNonNull(f0.b);
        this.mTitle = f0.b;
        this.mSelf = ConversationItem.validateSender(f0.c);
        this.mIcon = f0.d;
        this.mIsGroupConversation = f0.e;
        List list0 = g.g(f0.f);
        Objects.requireNonNull(list0);
        this.mMessages = list0;
        Q1.c.p("Message list cannot be empty.", !list0.isEmpty());
        Objects.requireNonNull(f0.g);
        this.mConversationCallbackDelegate = f0.g;
        this.mActions = g.g(f0.h);
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ConversationItem ? Objects.equals(this.mId, ((ConversationItem)object0).mId) && Objects.equals(this.mTitle, ((ConversationItem)object0).mTitle) && Objects.equals(this.mIcon, ((ConversationItem)object0).mIcon) && a.j(this.getSelf(), ((ConversationItem)object0).getSelf()) && this.mIsGroupConversation == ((ConversationItem)object0).mIsGroupConversation && Objects.equals(this.mMessages, ((ConversationItem)object0).mMessages) && Objects.equals(this.mActions, ((ConversationItem)object0).mActions) : false;
    }

    public List getActions() {
        return this.mActions;
    }

    public c getConversationCallbackDelegate() {
        return this.mConversationCallbackDelegate;
    }

    public CarIcon getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public List getMessages() {
        return this.mMessages;
    }

    public C getSelf() {
        return this.mSelf;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{a.I(this.getSelf()), this.mId, this.mTitle, this.mIcon, Boolean.valueOf(this.mIsGroupConversation), this.mMessages, this.mActions});
    }

    public boolean isGroupConversation() {
        return this.mIsGroupConversation;
    }

    public static C validateSender(C c0) {
        Objects.requireNonNull(c0);
        Objects.requireNonNull(c0.a);
        Objects.requireNonNull(c0.d);
        return c0;
    }
}

