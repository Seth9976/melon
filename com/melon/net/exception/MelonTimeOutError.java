package com.melon.net.exception;

import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/melon/net/exception/MelonTimeOutError;", "Ljava/net/SocketTimeoutException;", "Lcom/melon/net/exception/NetworkError;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTimeOutError extends SocketTimeoutException implements NetworkError {
    public static final int $stable = 8;
    @Nullable
    private final Throwable cause;
    @Nullable
    private final String message;

    public MelonTimeOutError() {
        this(null, null, 3, null);
    }

    public MelonTimeOutError(@Nullable String s, @Nullable Throwable throwable0) {
        super(s);
        this.message = s;
        this.cause = throwable0;
    }

    public MelonTimeOutError(String s, Throwable throwable0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            throwable0 = null;
        }
        this(s, throwable0);
    }

    @Override  // com.melon.net.exception.NetworkError
    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    @Override  // com.melon.net.exception.NetworkError
    @Nullable
    public String getMessage() {
        return this.message;
    }
}

