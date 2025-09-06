package com.kakaoent.leonchat.data.messages;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/OutputMessage;", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "Companion", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class OutputMessage extends MessageEntity {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/OutputMessage$Companion;", "", "", "TYPE_PING_MESSAGE", "Ljava/lang/String;", "TYPE_SEND_MESSAGE", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TYPE_PING_MESSAGE = "PONG";
    @NotNull
    public static final String TYPE_SEND_MESSAGE = "SEND_MESSAGE";

    static {
        OutputMessage.Companion = new Companion();  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

