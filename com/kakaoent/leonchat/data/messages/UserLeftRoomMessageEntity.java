package com.kakaoent.leonchat.data.messages;

import H0.b;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001C\u0010\t\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001A\u0010\u000B\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0004\u001A\u0004\b\f\u0010\u0006R\u001C\u0010\r\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001A\u0004\b\u000E\u0010\u0006R\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R\u001A\u0010\u0016\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001A\u0004\b\u0017\u0010\u0006R\u001A\u0010\u0018\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001A\u0004\b\u0019\u0010\u0006R\u001A\u0010\u001B\u001A\u00020\u001A8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u001A\u0010 \u001A\u00020\u001F8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/UserLeftRoomMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/UserJoinAndLeftRoomMessageEntity;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "id", "c", "channelId", "getChannelId", "chatType", "getChatType", "sentTime", "getSentTime", "", "chatId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "message", "getMessage", "createdDt", "getCreatedDt", "roomId", "getRoomId", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "fromUser", "Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "getFromUser", "()Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "", "broadcast", "Z", "getBroadcast", "()Z", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserLeftRoomMessageEntity extends UserJoinAndLeftRoomMessageEntity {
    private final boolean broadcast;
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
    @NotNull
    private final String roomId;
    @Nullable
    private final String sentTime;
    @NotNull
    private final String type;

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

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UserLeftRoomMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((UserLeftRoomMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.id, ((UserLeftRoomMessageEntity)object0).id)) {
            return false;
        }
        if(!q.b(this.channelId, ((UserLeftRoomMessageEntity)object0).channelId)) {
            return false;
        }
        if(!q.b(this.chatType, ((UserLeftRoomMessageEntity)object0).chatType)) {
            return false;
        }
        if(!q.b(this.sentTime, ((UserLeftRoomMessageEntity)object0).sentTime)) {
            return false;
        }
        if(!q.b(this.chatId, ((UserLeftRoomMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.message, ((UserLeftRoomMessageEntity)object0).message)) {
            return false;
        }
        if(!q.b(this.createdDt, ((UserLeftRoomMessageEntity)object0).createdDt)) {
            return false;
        }
        if(!q.b(this.roomId, ((UserLeftRoomMessageEntity)object0).roomId)) {
            return false;
        }
        return q.b(this.fromUser, ((UserLeftRoomMessageEntity)object0).fromUser) ? this.broadcast == ((UserLeftRoomMessageEntity)object0).broadcast : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final int hashCode() {
        int v = 0;
        int v1 = x.b((x.b(this.type.hashCode() * 0x1F, 0x1F, this.id) + (this.channelId == null ? 0 : this.channelId.hashCode())) * 0x1F, 0x1F, this.chatType);
        int v2 = this.sentTime == null ? 0 : this.sentTime.hashCode();
        Long long0 = this.chatId;
        if(long0 != null) {
            v = long0.hashCode();
        }
        int v3 = x.b(x.b(x.b(((v1 + v2) * 0x1F + v) * 0x1F, 0x1F, this.message), 0x1F, this.createdDt), 0x1F, this.roomId);
        int v4 = this.fromUser.hashCode();
        int v5 = this.broadcast;
        if(v5) {
            v5 = 1;
        }
        return (v4 + v3) * 0x1F + v5;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("UserLeftRoomMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", channelId=");
        stringBuilder0.append(this.channelId);
        stringBuilder0.append(", chatType=");
        stringBuilder0.append(this.chatType);
        stringBuilder0.append(", sentTime=");
        stringBuilder0.append(this.sentTime);
        stringBuilder0.append(", chatId=");
        stringBuilder0.append(this.chatId);
        stringBuilder0.append(", message=");
        stringBuilder0.append(this.message);
        stringBuilder0.append(", createdDt=");
        stringBuilder0.append(this.createdDt);
        stringBuilder0.append(", roomId=");
        stringBuilder0.append(this.roomId);
        stringBuilder0.append(", fromUser=");
        stringBuilder0.append(this.fromUser);
        stringBuilder0.append(", broadcast=");
        return b.k(stringBuilder0, this.broadcast, ')');
    }
}

