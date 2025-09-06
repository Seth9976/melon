package com.kakaoent.leonchat.data.messages;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001C\u0010\t\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001C\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001A\u0004\b\u0011\u0010\u0006R\u001A\u0010\u0012\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006R\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R\u001A\u0010\u0016\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001A\u0004\b\u0017\u0010\u0006R\u0017\u0010\u0019\u001A\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/ArtistMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/InputMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "id", "c", "channelId", "getChannelId", "", "chatId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "message", "f", "chatType", "getChatType", "sentTime", "getSentTime", "createdDt", "d", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "fromUser", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "e", "()Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ArtistMessageEntity extends InputMessage {
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
    @NotNull
    private final String message;
    @Nullable
    private final String sentTime;
    @NotNull
    private final String type;

    public ArtistMessageEntity(String s, LeonUserInfo leonUserInfo0) {
        q.g(s, "message");
        super();
        this.type = "ARTIST_MESSAGE";
        this.id = "ID_MADE_BY_CLIENT";
        this.channelId = null;
        this.chatId = null;
        this.message = s;
        this.chatType = "STANDARD";
        this.sentTime = null;
        this.createdDt = "";
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
        if(!(object0 instanceof ArtistMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((ArtistMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.id, ((ArtistMessageEntity)object0).id)) {
            return false;
        }
        if(!q.b(this.channelId, ((ArtistMessageEntity)object0).channelId)) {
            return false;
        }
        if(!q.b(this.chatId, ((ArtistMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.message, ((ArtistMessageEntity)object0).message)) {
            return false;
        }
        if(!q.b(this.chatType, ((ArtistMessageEntity)object0).chatType)) {
            return false;
        }
        if(!q.b(this.sentTime, ((ArtistMessageEntity)object0).sentTime)) {
            return false;
        }
        return q.b(this.createdDt, ((ArtistMessageEntity)object0).createdDt) ? q.b(this.fromUser, ((ArtistMessageEntity)object0).fromUser) : false;
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
        return this.fromUser.hashCode() + x.b((v1 + v) * 0x1F, 0x1F, this.createdDt);
    }

    @Override
    public final String toString() {
        return "ArtistMessageEntity(type=" + this.type + ", id=" + this.id + ", channelId=" + this.channelId + ", chatId=" + this.chatId + ", message=" + this.message + ", chatType=" + this.chatType + ", sentTime=" + this.sentTime + ", createdDt=" + this.createdDt + ", fromUser=" + this.fromUser + ')';
    }
}

