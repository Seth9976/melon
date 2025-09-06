package com.kakaoent.leonchat.data.messages;

import U4.x;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001C\u0010\t\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001C\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001A\u0004\b\u0011\u0010\u0006R\u001A\u0010\u0012\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006R\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R\u001A\u0010\u0016\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001A\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001A\u0004\b\u0019\u0010\u0006R\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0004\u001A\u0004\b\u001B\u0010\u0006¨\u0006\u001C"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/NoticeMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/InputMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "id", "c", "channelId", "getChannelId", "", "chatId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "message", "d", "chatType", "getChatType", "sentTime", "getSentTime", "createdDt", "getCreatedDt", "actionTitle", "getActionTitle", "actionUrl", "getActionUrl", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NoticeMessageEntity extends InputMessage {
    @Nullable
    private final String actionTitle;
    @Nullable
    private final String actionUrl;
    @Nullable
    private final String channelId;
    @Nullable
    private final Long chatId;
    @NotNull
    private final String chatType;
    @NotNull
    private final String createdDt;
    @NotNull
    private final String id;
    @NotNull
    private final String message;
    @Nullable
    private final String sentTime;
    @NotNull
    private final String type;

    public NoticeMessageEntity(String s) {
        q.g(s, "message");
        super();
        this.type = "NOTICE_MESSAGE";
        this.id = "ID_MADE_BY_CLIENT";
        this.channelId = null;
        this.chatId = null;
        this.message = s;
        this.chatType = "STANDARD";
        this.sentTime = null;
        this.createdDt = "";
        this.actionTitle = null;
        this.actionUrl = null;
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
        return this.message;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof NoticeMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((NoticeMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.id, ((NoticeMessageEntity)object0).id)) {
            return false;
        }
        if(!q.b(this.channelId, ((NoticeMessageEntity)object0).channelId)) {
            return false;
        }
        if(!q.b(this.chatId, ((NoticeMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.message, ((NoticeMessageEntity)object0).message)) {
            return false;
        }
        if(!q.b(this.chatType, ((NoticeMessageEntity)object0).chatType)) {
            return false;
        }
        if(!q.b(this.sentTime, ((NoticeMessageEntity)object0).sentTime)) {
            return false;
        }
        if(!q.b(this.createdDt, ((NoticeMessageEntity)object0).createdDt)) {
            return false;
        }
        return q.b(this.actionTitle, ((NoticeMessageEntity)object0).actionTitle) ? q.b(this.actionUrl, ((NoticeMessageEntity)object0).actionUrl) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final int hashCode() {
        int v = 0;
        int v1 = x.b((x.b(x.b(((x.b(this.type.hashCode() * 0x1F, 0x1F, this.id) + (this.channelId == null ? 0 : this.channelId.hashCode())) * 0x1F + (this.chatId == null ? 0 : this.chatId.hashCode())) * 0x1F, 0x1F, this.message), 0x1F, this.chatType) + (this.sentTime == null ? 0 : this.sentTime.hashCode())) * 0x1F, 0x1F, this.createdDt);
        int v2 = this.actionTitle == null ? 0 : this.actionTitle.hashCode();
        String s = this.actionUrl;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("NoticeMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", channelId=");
        stringBuilder0.append(this.channelId);
        stringBuilder0.append(", chatId=");
        stringBuilder0.append(this.chatId);
        stringBuilder0.append(", message=");
        stringBuilder0.append(this.message);
        stringBuilder0.append(", chatType=");
        stringBuilder0.append(this.chatType);
        stringBuilder0.append(", sentTime=");
        stringBuilder0.append(this.sentTime);
        stringBuilder0.append(", createdDt=");
        stringBuilder0.append(this.createdDt);
        stringBuilder0.append(", actionTitle=");
        stringBuilder0.append(this.actionTitle);
        stringBuilder0.append(", actionUrl=");
        return o.r(stringBuilder0, this.actionUrl, ')');
    }
}

