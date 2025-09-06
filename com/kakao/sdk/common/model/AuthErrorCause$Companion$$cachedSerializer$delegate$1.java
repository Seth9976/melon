package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
final class AuthErrorCause.Companion..cachedSerializer.delegate.1 extends r implements a {
    public static final AuthErrorCause.Companion..cachedSerializer.delegate.1 INSTANCE;

    static {
        AuthErrorCause.Companion..cachedSerializer.delegate.1.INSTANCE = new AuthErrorCause.Companion..cachedSerializer.delegate.1();
    }

    public AuthErrorCause.Companion..cachedSerializer.delegate.1() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    @NotNull
    public final KSerializer invoke() {
        return AuthErrorCauseSerializer.INSTANCE;
    }
}

