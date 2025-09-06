package com.kakao.emoticon.net;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000B\u001A\u00020\u0005H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonApiError;", "", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "toString", "Companion", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonApiError {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonApiError$Companion;", "", "()V", "NETWORK_ERROR", "", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final int NETWORK_ERROR = -600;
    private final int code;
    @NotNull
    private final String message;

    static {
        EmoticonApiError.Companion = new Companion(null);
    }

    public EmoticonApiError(int v, @NotNull String s) {
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

    @Override
    @NotNull
    public String toString() {
        return String.format("status code %d message %s", Arrays.copyOf(new Object[]{this.code, this.message}, 2));
    }
}

