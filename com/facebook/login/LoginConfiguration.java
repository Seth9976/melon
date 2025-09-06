package com.facebook.login;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001E\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB!\b\u0017\u0012\u000E\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0002\u0010\u0006B+\b\u0016\u0012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginConfiguration;", "", "permissions", "", "", "nonce", "(Ljava/util/Collection;Ljava/lang/String;)V", "codeVerifier", "(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)V", "getCodeVerifier", "()Ljava/lang/String;", "getNonce", "", "getPermissions", "()Ljava/util/Set;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LoginConfiguration {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/LoginConfiguration$Companion;", "", "()V", "OPENID", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String OPENID = "openid";
    @NotNull
    private final String codeVerifier;
    @NotNull
    private final String nonce;
    @NotNull
    private final Set permissions;

    static {
        LoginConfiguration.Companion = new Companion(null);
    }

    public LoginConfiguration(@Nullable Collection collection0) {
        this(collection0, null, 2, null);
    }

    public LoginConfiguration(@Nullable Collection collection0, @NotNull String s) {
        q.g(s, "nonce");
        this(collection0, s, PKCEUtil.generateCodeVerifier());
    }

    public LoginConfiguration(Collection collection0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s = "b791d2e7-e434-43e4-a61b-ebb49273c68a";
            q.f("b791d2e7-e434-43e4-a61b-ebb49273c68a", "randomUUID().toString()");
        }
        this(collection0, s);
    }

    public LoginConfiguration(@Nullable Collection collection0, @NotNull String s, @NotNull String s1) {
        q.g(s, "nonce");
        q.g(s1, "codeVerifier");
        super();
        if(!NonceUtil.isValidNonce(s) || !PKCEUtil.isValidCodeVerifier(s1)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        HashSet hashSet0 = collection0 == null ? new HashSet() : new HashSet(collection0);
        hashSet0.add("openid");
        Set set0 = Collections.unmodifiableSet(hashSet0);
        q.f(set0, "unmodifiableSet(permissions)");
        this.permissions = set0;
        this.nonce = s;
        this.codeVerifier = s1;
    }

    public LoginConfiguration(Collection collection0, String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            collection0 = null;
        }
        if((v & 2) != 0) {
            s = "8da3e09e-c20e-4bfa-b2b7-4af569ef8bf9";
            q.f("8da3e09e-c20e-4bfa-b2b7-4af569ef8bf9", "randomUUID().toString()");
        }
        this(collection0, s, s1);
    }

    @NotNull
    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    @NotNull
    public final String getNonce() {
        return this.nonce;
    }

    @NotNull
    public final Set getPermissions() {
        return this.permissions;
    }
}

