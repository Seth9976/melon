package com.facebook.login;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/login/LoginTargetApp;", "", "targetApp", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FACEBOOK", "INSTAGRAM", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum LoginTargetApp {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/LoginTargetApp$Companion;", "", "()V", "fromString", "Lcom/facebook/login/LoginTargetApp;", "stringValue", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LoginTargetApp fromString(@Nullable String s) {
            LoginTargetApp[] arr_loginTargetApp = LoginTargetApp.values();
            for(int v = 0; v < arr_loginTargetApp.length; ++v) {
                LoginTargetApp loginTargetApp0 = arr_loginTargetApp[v];
                if(q.b(loginTargetApp0.toString(), s)) {
                    return loginTargetApp0;
                }
            }
            return LoginTargetApp.FACEBOOK;
        }
    }

    FACEBOOK("facebook"),
    INSTAGRAM("instagram");

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String targetApp;

    private static final LoginTargetApp[] $values() [...] // Inlined contents

    static {
        LoginTargetApp.Companion = new Companion(null);
    }

    private LoginTargetApp(String s1) {
        this.targetApp = s1;
    }

    @NotNull
    public static final LoginTargetApp fromString(@Nullable String s) {
        return LoginTargetApp.Companion.fromString(s);
    }

    @Override
    @NotNull
    public String toString() {
        return this.targetApp;
    }
}

