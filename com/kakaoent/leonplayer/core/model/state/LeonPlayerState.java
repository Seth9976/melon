package com.kakaoent.leonplayer.core.model.state;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000B¨\u0006\f"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "", "Completion", "Error", "Idle", "Prepared", "Preparing", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Completion;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Error;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Idle;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Prepared;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Preparing;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonPlayerState {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Completion;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "()V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Completion implements LeonPlayerState {
        @NotNull
        public static final Completion INSTANCE;

        static {
            Completion.INSTANCE = new Completion();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Error;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Error implements LeonPlayerState {
        private final int code;
        @NotNull
        private final String message;

        public Error(int v, @NotNull String s) {
            q.g(s, "message");
            super();
            this.code = v;
            this.message = s;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Idle;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "()V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Idle implements LeonPlayerState {
        @NotNull
        public static final Idle INSTANCE;

        static {
            Idle.INSTANCE = new Idle();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Prepared;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "()V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Prepared implements LeonPlayerState {
        @NotNull
        public static final Prepared INSTANCE;

        static {
            Prepared.INSTANCE = new Prepared();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState$Preparing;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "()V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Preparing implements LeonPlayerState {
        @NotNull
        public static final Preparing INSTANCE;

        static {
            Preparing.INSTANCE = new Preparing();
        }
    }

}

