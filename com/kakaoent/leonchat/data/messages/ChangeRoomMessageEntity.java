package com.kakaoent.leonchat.data.messages;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001A\u0010\t\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001A\u0010\u000B\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0004\u001A\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001A\u0004\b\u000E\u0010\u0006R\u0017\u0010\u000F\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0004\u001A\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/ChangeRoomMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/CommandMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "targetType", "getTargetType", "chatId", "getChatId", "chatType", "getChatType", "existRoomId", "getExistRoomId", "changeRoomId", "b", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ChangeRoomMessageEntity extends CommandMessage {
    @NotNull
    private final String changeRoomId;
    @NotNull
    private final String chatId;
    @NotNull
    private final String chatType;
    @NotNull
    private final String existRoomId;
    @NotNull
    private final String targetType;
    @NotNull
    private final String type;

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final String a() {
        return this.type;
    }

    public final String b() {
        return this.changeRoomId;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ChangeRoomMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((ChangeRoomMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.targetType, ((ChangeRoomMessageEntity)object0).targetType)) {
            return false;
        }
        if(!q.b(this.chatId, ((ChangeRoomMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.chatType, ((ChangeRoomMessageEntity)object0).chatType)) {
            return false;
        }
        return q.b(this.existRoomId, ((ChangeRoomMessageEntity)object0).existRoomId) ? q.b(this.changeRoomId, ((ChangeRoomMessageEntity)object0).changeRoomId) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final int hashCode() {
        return this.changeRoomId.hashCode() + x.b(x.b(x.b(x.b(this.type.hashCode() * 0x1F, 0x1F, this.targetType), 0x1F, this.chatId), 0x1F, this.chatType), 0x1F, this.existRoomId);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ChangeRoomMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", targetType=");
        stringBuilder0.append(this.targetType);
        stringBuilder0.append(", chatId=");
        stringBuilder0.append(this.chatId);
        stringBuilder0.append(", chatType=");
        stringBuilder0.append(this.chatType);
        stringBuilder0.append(", existRoomId=");
        stringBuilder0.append(this.existRoomId);
        stringBuilder0.append(", changeRoomId=");
        return o.r(stringBuilder0, this.changeRoomId, ')');
    }
}

