package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001B\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\b\u0016\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/facebook/FacebookSdkNotInitializedException;", "Lcom/facebook/FacebookException;", "()V", "message", "", "(Ljava/lang/String;)V", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookSdkNotInitializedException extends FacebookException {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/FacebookSdkNotInitializedException$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final long serialVersionUID = 1L;

    static {
        FacebookSdkNotInitializedException.Companion = new Companion(null);
    }

    public FacebookSdkNotInitializedException() {
    }

    public FacebookSdkNotInitializedException(@Nullable String s) {
        super(s);
    }

    public FacebookSdkNotInitializedException(@Nullable String s, @Nullable Throwable throwable0) {
        super(s, throwable0);
    }

    public FacebookSdkNotInitializedException(@Nullable Throwable throwable0) {
        super(throwable0);
    }
}

