package com.kakaoent.leonchat.data.messages;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u0017\u0010\u000E\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u0004\u001A\u0004\b\u000F\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/PongMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "message", "getMessage", "", "broadcast", "Z", "getBroadcast", "()Z", "createdDt", "getCreatedDt", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PongMessageEntity extends MessageEntity {
    private final boolean broadcast;
    @NotNull
    private final String createdDt;
    @NotNull
    private final String message;
    @NotNull
    private final String type;

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final String a() {
        return this.type;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PongMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((PongMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.message, ((PongMessageEntity)object0).message)) {
            return false;
        }
        return this.broadcast == ((PongMessageEntity)object0).broadcast ? q.b(this.createdDt, ((PongMessageEntity)object0).createdDt) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final int hashCode() {
        int v = x.b(this.type.hashCode() * 0x1F, 0x1F, this.message);
        int v1 = this.broadcast;
        if(v1) {
            v1 = 1;
        }
        return this.createdDt.hashCode() + (v + v1) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PongMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", message=");
        stringBuilder0.append(this.message);
        stringBuilder0.append(", broadcast=");
        stringBuilder0.append(this.broadcast);
        stringBuilder0.append(", createdDt=");
        return o.r(stringBuilder0, this.createdDt, ')');
    }
}

