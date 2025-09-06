package com.kakao.sdk.common.model;

import De.d;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.r;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
final class KakaoSdkError.Companion..cachedSerializer.delegate.1 extends r implements a {
    public static final KakaoSdkError.Companion..cachedSerializer.delegate.1 INSTANCE;

    static {
        KakaoSdkError.Companion..cachedSerializer.delegate.1.INSTANCE = new KakaoSdkError.Companion..cachedSerializer.delegate.1();
    }

    public KakaoSdkError.Companion..cachedSerializer.delegate.1() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    @NotNull
    public final KSerializer invoke() {
        return new SealedClassSerializer("com.kakao.sdk.common.model.KakaoSdkError", I.a.b(KakaoSdkError.class), new d[]{I.a.b(ApiError.class), I.a.b(AppsError.class), I.a.b(AuthError.class)}, new KSerializer[]{.serializer.INSTANCE, com.kakao.sdk.common.model.AppsError..serializer.INSTANCE, com.kakao.sdk.common.model.AuthError..serializer.INSTANCE}, new Annotation[0]);
    }
}

