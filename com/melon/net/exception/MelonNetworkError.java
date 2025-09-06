package com.melon.net.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001F\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/melon/net/exception/MelonNetworkError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/melon/net/exception/NetworkError;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonNetworkError extends Exception implements NetworkError {
    public static final int $stable = 8;
    @Nullable
    private final Throwable cause;
    @Nullable
    private final String message;

    public MelonNetworkError() {
        this(null, null, 3, null);
    }

    public MelonNetworkError(@Nullable String s, @Nullable Throwable throwable0) {
        super(s, throwable0);
        this.message = s;
        this.cause = throwable0;
    }

    public MelonNetworkError(String s, Throwable throwable0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
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

