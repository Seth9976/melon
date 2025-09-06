package com.kakaoent.leonchat.data.messages;

import H0.b;
import U4.x;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001C\u0010\t\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001C\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001A\u0004\b\u0011\u0010\u0006R\u001A\u0010\u0012\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006R\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R\u001A\u0010\u0016\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0016\u0010\u0004\u001A\u0004\b\u0017\u0010\u0006R$\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER$\u0010\u001F\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001F\u0010\u0004\u001A\u0004\b \u0010\u0006\"\u0004\b!\u0010\"R:\u0010%\u001A\u001A\u0012\u0006\b\u0000\u0012\u00020\u0001\u0018\u00010#j\f\u0012\u0006\b\u0000\u0012\u00020\u0001\u0018\u0001`$8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001A\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001A\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b2\u0010-\u001A\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00105\u001A\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b5\u0010-\u001A\u0004\b6\u0010/\"\u0004\b7\u00101R\"\u00109\u001A\u0002088\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010:\u001A\u0004\b9\u0010;\"\u0004\b<\u0010=\u00A8\u0006>"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/InitMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/InputMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "id", "c", "channelId", "getChannelId", "", "chatId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "message", "getMessage", "chatType", "getChatType", "sentTime", "getSentTime", "createdDt", "getCreatedDt", "Lcom/kakaoent/leonchat/data/messages/ChatMeta;", "chatMeta", "Lcom/kakaoent/leonchat/data/messages/ChatMeta;", "getChatMeta", "()Lcom/kakaoent/leonchat/data/messages/ChatMeta;", "setChatMeta", "(Lcom/kakaoent/leonchat/data/messages/ChatMeta;)V", "roomId", "e", "setRoomId", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "recentMessages", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "setRecentMessages", "(Ljava/util/ArrayList;)V", "", "noticeMessages", "Ljava/lang/Object;", "getNoticeMessages", "()Ljava/lang/Object;", "setNoticeMessages", "(Ljava/lang/Object;)V", "userFixedMessages", "getUserFixedMessages", "setUserFixedMessages", "artistFixedMessages", "getArtistFixedMessages", "setArtistFixedMessages", "", "isFreeze", "Z", "()Z", "setFreeze", "(Z)V", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InitMessageEntity extends InputMessage {
    @Nullable
    private Object artistFixedMessages;
    @Nullable
    private final String channelId;
    @Nullable
    private final Long chatId;
    @Nullable
    private ChatMeta chatMeta;
    @NotNull
    private final String chatType;
    @NotNull
    private final String createdDt;
    @NotNull
    private final String id;
    private boolean isFreeze;
    @NotNull
    private final String message;
    @Nullable
    private Object noticeMessages;
    @Nullable
    private ArrayList recentMessages;
    @Nullable
    private String roomId;
    @Nullable
    private final String sentTime;
    @NotNull
    private final String type;
    @Nullable
    private Object userFixedMessages;

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

    public final ArrayList d() {
        return this.recentMessages;
    }

    public final String e() {
        return this.roomId;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof InitMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((InitMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.id, ((InitMessageEntity)object0).id)) {
            return false;
        }
        if(!q.b(this.channelId, ((InitMessageEntity)object0).channelId)) {
            return false;
        }
        if(!q.b(this.chatId, ((InitMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.message, ((InitMessageEntity)object0).message)) {
            return false;
        }
        if(!q.b(this.chatType, ((InitMessageEntity)object0).chatType)) {
            return false;
        }
        if(!q.b(this.sentTime, ((InitMessageEntity)object0).sentTime)) {
            return false;
        }
        if(!q.b(this.createdDt, ((InitMessageEntity)object0).createdDt)) {
            return false;
        }
        if(!q.b(this.chatMeta, ((InitMessageEntity)object0).chatMeta)) {
            return false;
        }
        if(!q.b(this.roomId, ((InitMessageEntity)object0).roomId)) {
            return false;
        }
        if(!q.b(this.recentMessages, ((InitMessageEntity)object0).recentMessages)) {
            return false;
        }
        if(!q.b(this.noticeMessages, ((InitMessageEntity)object0).noticeMessages)) {
            return false;
        }
        if(!q.b(this.userFixedMessages, ((InitMessageEntity)object0).userFixedMessages)) {
            return false;
        }
        return q.b(this.artistFixedMessages, ((InitMessageEntity)object0).artistFixedMessages) ? this.isFreeze == ((InitMessageEntity)object0).isFreeze : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.InputMessage
    public final int hashCode() {
        int v = 0;
        int v1 = x.b((x.b(x.b(((x.b(this.type.hashCode() * 0x1F, 0x1F, this.id) + (this.channelId == null ? 0 : this.channelId.hashCode())) * 0x1F + (this.chatId == null ? 0 : this.chatId.hashCode())) * 0x1F, 0x1F, this.message), 0x1F, this.chatType) + (this.sentTime == null ? 0 : this.sentTime.hashCode())) * 0x1F, 0x1F, this.createdDt);
        int v2 = this.chatMeta == null ? 0 : this.chatMeta.hashCode();
        int v3 = this.roomId == null ? 0 : this.roomId.hashCode();
        int v4 = this.recentMessages == null ? 0 : this.recentMessages.hashCode();
        int v5 = this.noticeMessages == null ? 0 : this.noticeMessages.hashCode();
        int v6 = this.userFixedMessages == null ? 0 : this.userFixedMessages.hashCode();
        Object object0 = this.artistFixedMessages;
        if(object0 != null) {
            v = object0.hashCode();
        }
        int v7 = this.isFreeze;
        if(v7) {
            v7 = 1;
        }
        return ((((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v) * 0x1F + v7;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("InitMessageEntity(type=");
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
        stringBuilder0.append(", chatMeta=");
        stringBuilder0.append(this.chatMeta);
        stringBuilder0.append(", roomId=");
        stringBuilder0.append(this.roomId);
        stringBuilder0.append(", recentMessages=");
        stringBuilder0.append(this.recentMessages);
        stringBuilder0.append(", noticeMessages=");
        stringBuilder0.append(this.noticeMessages);
        stringBuilder0.append(", userFixedMessages=");
        stringBuilder0.append(this.userFixedMessages);
        stringBuilder0.append(", artistFixedMessages=");
        stringBuilder0.append(this.artistFixedMessages);
        stringBuilder0.append(", isFreeze=");
        return b.k(stringBuilder0, this.isFreeze, ')');
    }
}

