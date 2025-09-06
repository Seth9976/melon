package com.kakao.sdk.auth;

import d3.g;
import ie.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/kakao/sdk/auth/TokenManagerProvider;", "", "manager", "Lcom/kakao/sdk/auth/TokenManageable;", "(Lcom/kakao/sdk/auth/TokenManageable;)V", "getManager", "()Lcom/kakao/sdk/auth/TokenManageable;", "setManager", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TokenManagerProvider {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/auth/TokenManagerProvider$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/auth/TokenManagerProvider;", "getInstance$annotations", "instance", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TokenManagerProvider getInstance() {
            return (TokenManagerProvider)TokenManagerProvider.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private TokenManageable manager;

    static {
        TokenManagerProvider.Companion = new Companion(null);
        TokenManagerProvider.instance$delegate = g.Q(TokenManagerProvider.Companion.instance.2.INSTANCE);
    }

    public TokenManagerProvider() {
        this(null, 1, null);
    }

    public TokenManagerProvider(@NotNull TokenManageable tokenManageable0) {
        q.g(tokenManageable0, "manager");
        super();
        this.manager = tokenManageable0;
    }

    public TokenManagerProvider(TokenManageable tokenManageable0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            tokenManageable0 = TokenManager.Companion.getInstance();
        }
        this(tokenManageable0);
    }

    @NotNull
    public static final TokenManagerProvider getInstance() {
        return TokenManagerProvider.Companion.getInstance();
    }

    @NotNull
    public final TokenManageable getManager() {
        return this.manager;
    }

    public final void setManager(@NotNull TokenManageable tokenManageable0) {
        q.g(tokenManageable0, "<set-?>");
        this.manager = tokenManageable0;
    }
}

