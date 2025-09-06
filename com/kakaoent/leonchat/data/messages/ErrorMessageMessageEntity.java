package com.kakaoent.leonchat.data.messages;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006¨\u0006\u000B"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/ErrorMessageMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "code", "b", "reason", "c", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ErrorMessageMessageEntity extends MessageEntity {
    @NotNull
    private final String code;
    @NotNull
    private final String reason;
    @NotNull
    private final String type;

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final String a() {
        return this.type;
    }

    public final String b() {
        return this.code;
    }

    public final String c() {
        return this.reason;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ErrorMessageMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((ErrorMessageMessageEntity)object0).type)) {
            return false;
        }
        return q.b(this.code, ((ErrorMessageMessageEntity)object0).code) ? q.b(this.reason, ((ErrorMessageMessageEntity)object0).reason) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final int hashCode() {
        return this.reason.hashCode() + x.b(this.type.hashCode() * 0x1F, 0x1F, this.code);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ErrorMessageMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", code=");
        stringBuilder0.append(this.code);
        stringBuilder0.append(", reason=");
        return o.r(stringBuilder0, this.reason, ')');
    }
}

