package com.kakaoent.leonchat.data.messages;

import U4.x;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001A\u0010\t\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R\u001A\u0010\u000B\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0004\u001A\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001A\u0004\b\u000E\u0010\u0006R\u0017\u0010\u0010\u001A\u00020\u000F8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R+\u0010\u0018\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u0017\u0010\u001C\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0004\u001A\u0004\b\u001D\u0010\u0006R\u0017\u0010\u001E\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u0004\u001A\u0004\b\u001F\u0010\u0006¨\u0006 "}, d2 = {"Lcom/kakaoent/leonchat/data/messages/BlockUserMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/CommandMessage;", "", "type", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "targetType", "getTargetType", "chatId", "getChatId", "chatType", "getChatType", "broadcastType", "getBroadcastType", "", "targetRoomIds", "Ljava/lang/Object;", "getTargetRoomIds", "()Ljava/lang/Object;", "channelId", "getChannelId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "targetUserIds", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "blockType", "b", "duration", "getDuration", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BlockUserMessageEntity extends CommandMessage {
    @NotNull
    private final String blockType;
    @NotNull
    private final String broadcastType;
    @NotNull
    private final String channelId;
    @NotNull
    private final String chatId;
    @NotNull
    private final String chatType;
    @NotNull
    private final String duration;
    @NotNull
    private final Object targetRoomIds;
    @NotNull
    private final String targetType;
    @Nullable
    private final ArrayList targetUserIds;
    @NotNull
    private final String type;

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final String a() {
        return this.type;
    }

    public final String b() {
        return this.blockType;
    }

    public final ArrayList c() {
        return this.targetUserIds;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BlockUserMessageEntity)) {
            return false;
        }
        if(!q.b(this.type, ((BlockUserMessageEntity)object0).type)) {
            return false;
        }
        if(!q.b(this.targetType, ((BlockUserMessageEntity)object0).targetType)) {
            return false;
        }
        if(!q.b(this.chatId, ((BlockUserMessageEntity)object0).chatId)) {
            return false;
        }
        if(!q.b(this.chatType, ((BlockUserMessageEntity)object0).chatType)) {
            return false;
        }
        if(!q.b(this.broadcastType, ((BlockUserMessageEntity)object0).broadcastType)) {
            return false;
        }
        if(!q.b(this.targetRoomIds, ((BlockUserMessageEntity)object0).targetRoomIds)) {
            return false;
        }
        if(!q.b(this.channelId, ((BlockUserMessageEntity)object0).channelId)) {
            return false;
        }
        if(!q.b(this.targetUserIds, ((BlockUserMessageEntity)object0).targetUserIds)) {
            return false;
        }
        return q.b(this.blockType, ((BlockUserMessageEntity)object0).blockType) ? q.b(this.duration, ((BlockUserMessageEntity)object0).duration) : false;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public final int hashCode() {
        int v = x.b((this.targetRoomIds.hashCode() + x.b(x.b(x.b(x.b(this.type.hashCode() * 0x1F, 0x1F, this.targetType), 0x1F, this.chatId), 0x1F, this.chatType), 0x1F, this.broadcastType)) * 0x1F, 0x1F, this.channelId);
        return this.targetUserIds == null ? this.duration.hashCode() + x.b(v * 0x1F, 0x1F, this.blockType) : this.duration.hashCode() + x.b((v + this.targetUserIds.hashCode()) * 0x1F, 0x1F, this.blockType);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BlockUserMessageEntity(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", targetType=");
        stringBuilder0.append(this.targetType);
        stringBuilder0.append(", chatId=");
        stringBuilder0.append(this.chatId);
        stringBuilder0.append(", chatType=");
        stringBuilder0.append(this.chatType);
        stringBuilder0.append(", broadcastType=");
        stringBuilder0.append(this.broadcastType);
        stringBuilder0.append(", targetRoomIds=");
        stringBuilder0.append(this.targetRoomIds);
        stringBuilder0.append(", channelId=");
        stringBuilder0.append(this.channelId);
        stringBuilder0.append(", targetUserIds=");
        stringBuilder0.append(this.targetUserIds);
        stringBuilder0.append(", blockType=");
        stringBuilder0.append(this.blockType);
        stringBuilder0.append(", duration=");
        return o.r(stringBuilder0, this.duration, ')');
    }
}

