package com.iloen.melon.player.video.chat;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatUi;", "", "Type", "ChatView", "ErrorView", "Lcom/iloen/melon/player/video/chat/ChatUi$ChatView;", "Lcom/iloen/melon/player/video/chat/ChatUi$ErrorView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ChatUi {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0016\u001A\u00020\u00042\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u000B¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatUi$ChatView;", "Lcom/iloen/melon/player/video/chat/ChatUi;", "Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "type", "", "enableSendMessage", "<init>", "(Lcom/iloen/melon/player/video/chat/ChatUi$Type;Z)V", "component1", "()Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "component2", "()Z", "copy", "(Lcom/iloen/melon/player/video/chat/ChatUi$Type;Z)Lcom/iloen/melon/player/video/chat/ChatUi$ChatView;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "getType", "b", "Z", "getEnableSendMessage", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ChatView extends ChatUi {
        public static final int $stable;
        public final Type a;
        public final boolean b;

        public ChatView(@NotNull Type chatUi$Type0, boolean z) {
            q.g(chatUi$Type0, "type");
            super(null);
            this.a = chatUi$Type0;
            this.b = z;
        }

        public ChatView(Type chatUi$Type0, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                chatUi$Type0 = Type.NONE;
            }
            this(chatUi$Type0, z);
        }

        @NotNull
        public final Type component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final ChatView copy(@NotNull Type chatUi$Type0, boolean z) {
            q.g(chatUi$Type0, "type");
            return new ChatView(chatUi$Type0, z);
        }

        public static ChatView copy$default(ChatView chatUi$ChatView0, Type chatUi$Type0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                chatUi$Type0 = chatUi$ChatView0.a;
            }
            if((v & 2) != 0) {
                z = chatUi$ChatView0.b;
            }
            return chatUi$ChatView0.copy(chatUi$Type0, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ChatView)) {
                return false;
            }
            return this.a == ((ChatView)object0).a ? this.b == ((ChatView)object0).b : false;
        }

        public final boolean getEnableSendMessage() {
            return this.b;
        }

        @NotNull
        public final Type getType() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "ChatView(type=" + this.a + ", enableSendMessage=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0012\u0010\r\u001A\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ0\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\nR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\fR\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u001D\u001A\u0004\b \u0010\f¨\u0006!"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatUi$ErrorView;", "Lcom/iloen/melon/player/video/chat/ChatUi;", "Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "type", "", "groundMessage", "inputPopupMessage", "<init>", "(Lcom/iloen/melon/player/video/chat/ChatUi$Type;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "component2", "()Ljava/lang/String;", "component3", "copy", "(Lcom/iloen/melon/player/video/chat/ChatUi$Type;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/player/video/chat/ChatUi$ErrorView;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "getType", "b", "Ljava/lang/String;", "getGroundMessage", "c", "getInputPopupMessage", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ErrorView extends ChatUi {
        public static final int $stable;
        public final Type a;
        public final String b;
        public final String c;

        public ErrorView(@NotNull Type chatUi$Type0, @NotNull String s, @Nullable String s1) {
            q.g(chatUi$Type0, "type");
            q.g(s, "groundMessage");
            super(null);
            this.a = chatUi$Type0;
            this.b = s;
            this.c = s1;
        }

        public ErrorView(Type chatUi$Type0, String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                s1 = null;
            }
            this(chatUi$Type0, s, s1);
        }

        @NotNull
        public final Type component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final ErrorView copy(@NotNull Type chatUi$Type0, @NotNull String s, @Nullable String s1) {
            q.g(chatUi$Type0, "type");
            q.g(s, "groundMessage");
            return new ErrorView(chatUi$Type0, s, s1);
        }

        public static ErrorView copy$default(ErrorView chatUi$ErrorView0, Type chatUi$Type0, String s, String s1, int v, Object object0) {
            if((v & 1) != 0) {
                chatUi$Type0 = chatUi$ErrorView0.a;
            }
            if((v & 2) != 0) {
                s = chatUi$ErrorView0.b;
            }
            if((v & 4) != 0) {
                s1 = chatUi$ErrorView0.c;
            }
            return chatUi$ErrorView0.copy(chatUi$Type0, s, s1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ErrorView)) {
                return false;
            }
            if(this.a != ((ErrorView)object0).a) {
                return false;
            }
            return q.b(this.b, ((ErrorView)object0).b) ? q.b(this.c, ((ErrorView)object0).c) : false;
        }

        @NotNull
        public final String getGroundMessage() {
            return this.b;
        }

        @Nullable
        public final String getInputPopupMessage() {
            return this.c;
        }

        @NotNull
        public final Type getType() {
            return this.a;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
            return this.c == null ? v : v + this.c.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("ErrorView(type=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", groundMessage=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", inputPopupMessage=");
            return x.m(stringBuilder0, this.c, ")");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatUi$Type;", "", "NONE", "NO_CHAT", "UNAUTHORIZED_USER", "CONNECTION_FAILED", "BAN", "FREEZING", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum Type {
        NONE,
        NO_CHAT,
        UNAUTHORIZED_USER,
        CONNECTION_FAILED,
        BAN,
        FREEZING;

        public static final Type[] a;
        public static final b b;

        static {
            Type.a = arr_chatUi$Type;
            q.g(arr_chatUi$Type, "entries");
            Type.b = new b(arr_chatUi$Type);
        }

        @NotNull
        public static a getEntries() {
            return Type.b;
        }
    }

    public static final int $stable;

    public ChatUi(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

