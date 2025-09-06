package com.kakaoent.leonchat.data.messages;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001C\u0010\t\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001C\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001A\u0004\b\u0011\u0010\u0006R\u001A\u0010\u0012\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006R\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R\u001A\u0010\u0016\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001A\u0004\b\u0017\u0010\u0006R\u0017\u0010\u0018\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001A\u0004\b\u0019\u0010\u0006R\u0017\u0010\u001A\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0004\u001A\u0004\b\u001B\u0010\u0006R\u0017\u0010\u001D\u001A\u00020\u001C8\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u0017\u0010\"\u001A\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/UserMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/InputMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "id", "c", "channelId", "getChannelId", "", "chatId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "message", "f", "chatType", "getChatType", "sentTime", "getSentTime", "createdDt", "d", "roomId", "getRoomId", "rowMessage", "getRowMessage", "", "includeBannedWord", "Z", "getIncludeBannedWord", "()Z", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "fromUser", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "e", "()Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserMessageEntity extends InputMessage {
    @Nullable
    private final String channelId;
    @Nullable
    private final Long chatId;
    @NotNull
    private final String chatType;
    @NotNull
    private final String createdDt;
    @NotNull
    private final LeonUserInfo fromUser;
    @NotNull
    private final String id;
    private final boolean includeBannedWord;
    @NotNull
    private final String message;
    @NotNull
    private final String roomId;
    @NotNull
    private final String rowMessage;
    @Nullable
    private final String sentTime;
    @NotNull
    private final String type;

    public UserMessageEntity(String s, String s1, LeonUserInfo leonUserInfo0) {
        q.g(s, "message");
        q.g(s1, "rowMessage");
        super();
        this.type = "USER_MESSAGE";
        this.id = "ID_MADE_BY_CLIENT";
        this.channelId = null;
        this.chatId = null;
        this.message = s;
        this.chatType = "MELON";
        this.sentTime = null;
        this.createdDt = "";
        this.roomId = "";
        this.rowMessage = s1;
        this.includeBannedWord = false;
        this.fromUser = leonUserInfo0;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final String a() {
        return this.type;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final Long b() {
        return this.chatId;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final String c() {
        return this.id;
    }

    public final String d() {
        return this.createdDt;
    }

    public final LeonUserInfo e() {
        return this.fromUser;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UserMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((UserMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.id, ((UserMessageEntity)object0).id)) {
            return false;
        }
        if(!q.b(this.channelId, ((UserMessageEntity)object0).channelId)) {
            return false;
        }
        if(!q.b(this.chatId, ((UserMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.message, ((UserMessageEntity)object0).message)) {
            return false;
        }
        if(!q.b(this.chatType, ((UserMessageEntity)object0).chatType)) {
            return false;
        }
        if(!q.b(this.sentTime, ((UserMessageEntity)object0).sentTime)) {
            return false;
        }
        if(!q.b(this.createdDt, ((UserMessageEntity)object0).createdDt)) {
            return false;
        }
        if(!q.b(this.roomId, ((UserMessageEntity)object0).roomId)) {
            return false;
        }
        if(!q.b(this.rowMessage, ((UserMessageEntity)object0).rowMessage)) {
            return false;
        }
        return this.includeBannedWord == ((UserMessageEntity)object0).includeBannedWord ? q.b(this.fromUser, ((UserMessageEntity)object0).fromUser) : false;
    }

    public final String f() {
        return this.message;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final int hashCode() {
        int v = 0;
        int v1 = x.b(x.b(((x.b(this.type.hashCode() * 0x1F, 0x1F, this.id) + (this.channelId == null ? 0 : this.channelId.hashCode())) * 0x1F + (this.chatId == null ? 0 : this.chatId.hashCode())) * 0x1F, 0x1F, this.message), 0x1F, this.chatType);
        String s = this.sentTime;
        if(s != null) {
            v = s.hashCode();
        }
        int v2 = x.b(x.b(x.b((v1 + v) * 0x1F, 0x1F, this.createdDt), 0x1F, this.roomId), 0x1F, this.rowMessage);
        int v3 = this.includeBannedWord;
        if(v3) {
            v3 = 1;
        }
        return this.fromUser.hashCode() + (v2 + v3) * 0x1F;
    }

    @Override
    public final String toString() {
        return "UserMessageEntity(type=" + this.type + ", id=" + this.id + ", channelId=" + this.channelId + ", chatId=" + this.chatId + ", message=" + this.message + ", chatType=" + this.chatType + ", sentTime=" + this.sentTime + ", createdDt=" + this.createdDt + ", roomId=" + this.roomId + ", rowMessage=" + this.rowMessage + ", includeBannedWord=" + this.includeBannedWord + ", fromUser=" + this.fromUser + ')';
    }
}

