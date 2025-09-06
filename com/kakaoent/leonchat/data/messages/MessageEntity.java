package com.kakaoent.leonchat.data.messages;

import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class MessageEntity {
    public abstract String a();

    @Override
    public boolean equals(Object object0) {
        if(this != object0) {
            if(this.getClass().equals((object0 == null ? null : object0.getClass()))) {
                q.e(object0, "null cannot be cast to non-null type com.kakaoent.leonchat.data.messages.MessageEntity");
                return q.b(this.a(), ((MessageEntity)object0).a());
            }
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.a().hashCode();
    }
}

