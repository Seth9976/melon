package com.kakaoent.leonchat.data.messages;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/ChatTokenEntity;", "", "", "token", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ChatTokenEntity {
    @NotNull
    private final String token;

    public final String a() {
        return this.token;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ChatTokenEntity ? q.b(this.token, ((ChatTokenEntity)object0).token) : false;
    }

    @Override
    public final int hashCode() {
        return this.token.hashCode();
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("ChatTokenEntity(token="), this.token, ')');
    }
}

