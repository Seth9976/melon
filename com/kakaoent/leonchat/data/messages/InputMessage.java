package com.kakaoent.leonchat.data.messages;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/InputMessage;", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "Companion", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class InputMessage extends MessageEntity {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000B\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0004R\u0014\u0010\f\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u000E"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/InputMessage$Companion;", "", "", "TYPE_ARTIST_FIXED_MESSAGE", "Ljava/lang/String;", "TYPE_ARTIST_MESSAGE", "TYPE_INIT_MESSAGE", "TYPE_NOTICE_FIXED_MESSAGE", "TYPE_NOTICE_MESSAGE", "TYPE_PONG", "TYPE_USER_FIXED_MESSAGE", "TYPE_USER_JOIN_ROOM", "TYPE_USER_LEFT_ROOM", "TYPE_USER_MESSAGE", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TYPE_ARTIST_FIXED_MESSAGE = "ARTIST_FIXED_MESSAGE";
    @NotNull
    public static final String TYPE_ARTIST_MESSAGE = "ARTIST_MESSAGE";
    @NotNull
    public static final String TYPE_INIT_MESSAGE = "INIT_MESSAGE";
    @NotNull
    public static final String TYPE_NOTICE_FIXED_MESSAGE = "NOTICE_FIXED_MESSAGE";
    @NotNull
    public static final String TYPE_NOTICE_MESSAGE = "NOTICE_MESSAGE";
    @NotNull
    public static final String TYPE_PONG = "PONG";
    @NotNull
    public static final String TYPE_USER_FIXED_MESSAGE = "USER_FIXED_MESSAGE";
    @NotNull
    public static final String TYPE_USER_JOIN_ROOM = "USER_JOIN_ROOM";
    @NotNull
    public static final String TYPE_USER_LEFT_ROOM = "USER_LEFT_ROOM";
    @NotNull
    public static final String TYPE_USER_MESSAGE = "USER_MESSAGE";

    static {
        InputMessage.Companion = new Companion();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public abstract Long b();

    public abstract String c();

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public boolean equals(Object object0) {
        if(this != object0) {
            if(this.getClass().equals((object0 == null ? null : object0.getClass()))) {
                q.e(object0, "null cannot be cast to non-null type com.kakaoent.leonchat.data.messages.InputMessage");
                return q.b(this.c(), ((InputMessage)object0).c());
            }
            return false;
        }
        return true;
    }

    @Override  // com.kakaoent.leonchat.data.messages.MessageEntity
    public int hashCode() {
        return this.c().hashCode();
    }
}

