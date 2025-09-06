package com.kakaoent.leonchat.data.messages;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/CommandMessage;", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "Companion", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class CommandMessage extends MessageEntity {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/CommandMessage$Companion;", "", "", "TYPE_BLOCK_USER", "Ljava/lang/String;", "TYPE_CHANGE_ROOM", "TYPE_FREEZE_CHAT", "TYPE_SLOW_CHAT", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TYPE_BLOCK_USER = "BLOCK_USER";
    @NotNull
    public static final String TYPE_CHANGE_ROOM = "CHANGE_ROOM";
    @NotNull
    public static final String TYPE_FREEZE_CHAT = "FREEZE_CHAT";
    @NotNull
    public static final String TYPE_SLOW_CHAT = "SLOW_CHAT";

    static {
        CommandMessage.Companion = new Companion();  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

