package com.kakaoent.leonchat.data.messages;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/PingMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/OutputMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "message", "getMessage", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PingMessageEntity extends OutputMessage {
    @NotNull
    private final String message;
    @NotNull
    private final String type;

    public PingMessageEntity() {
        this.type = "PING";
        this.message = "PING";
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final String a() {
        return this.type;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PingMessageEntity)) {
            return false;
        }
        return q.b(this.type, ((PingMessageEntity)object0).type) ? q.b(this.message, ((PingMessageEntity)object0).message) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final int hashCode() {
        return this.message.hashCode() + this.type.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PingMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", message=");
        return o.r(stringBuilder0, this.message, ')');
    }
}

