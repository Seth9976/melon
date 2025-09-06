package com.kakaoent.leonchat.data.messages;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\u0004\u001A\u0004\b\f\u0010\u0006R\u0017\u0010\u000E\u001A\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/SendMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/OutputMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "message", "getMessage", "chatId", "getChatId", "roomId", "getRoomId", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "fromUser", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "getFromUser", "()Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "sentTime", "getSentTime", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SendMessageEntity extends OutputMessage {
    @NotNull
    private final String chatId;
    @NotNull
    private final LeonUserInfo fromUser;
    @NotNull
    private final String message;
    @NotNull
    private final String roomId;
    @NotNull
    private final String sentTime;
    @NotNull
    private final String type;

    public SendMessageEntity(String s, String s1, String s2, LeonUserInfo leonUserInfo0, String s3) {
        q.g(s1, "chatId");
        q.g(s2, "roomId");
        q.g(leonUserInfo0, "fromUser");
        super();
        this.type = "SEND_MESSAGE";
        this.message = s;
        this.chatId = s1;
        this.roomId = s2;
        this.fromUser = leonUserInfo0;
        this.sentTime = s3;
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
        if(!(object0 instanceof SendMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((SendMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.message, ((SendMessageEntity)object0).message)) {
            return false;
        }
        if(!q.b(this.chatId, ((SendMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.roomId, ((SendMessageEntity)object0).roomId)) {
            return false;
        }
        return q.b(this.fromUser, ((SendMessageEntity)object0).fromUser) ? q.b(this.sentTime, ((SendMessageEntity)object0).sentTime) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final int hashCode() {
        return this.sentTime.hashCode() + (this.fromUser.hashCode() + x.b(x.b(x.b(this.type.hashCode() * 0x1F, 0x1F, this.message), 0x1F, this.chatId), 0x1F, this.roomId)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SendMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", message=");
        stringBuilder0.append(this.message);
        stringBuilder0.append(", chatId=");
        stringBuilder0.append(this.chatId);
        stringBuilder0.append(", roomId=");
        stringBuilder0.append(this.roomId);
        stringBuilder0.append(", fromUser=");
        stringBuilder0.append(this.fromUser);
        stringBuilder0.append(", sentTime=");
        return o.r(stringBuilder0, this.sentTime, ')');
    }
}

