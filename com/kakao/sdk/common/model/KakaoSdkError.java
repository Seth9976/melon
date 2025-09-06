package com.kakao.sdk.common.model;

import d3.g;
import ie.d;
import ie.j;
import ie.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001A2\u00060\u0001j\u0002`\u0002:\u0001\u001AB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0017\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000BJ(\u0010\u0012\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FHÇ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\u0082\u0001\u0004\u001B\u001C\u001D\u001E¨\u0006\u001F"}, d2 = {"Lcom/kakao/sdk/common/model/KakaoSdkError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "msg", "<init>", "(Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/common/model/KakaoSdkError;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "isInvalidTokenError", "()Z", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "Companion", "Lcom/kakao/sdk/common/model/ApiError;", "Lcom/kakao/sdk/common/model/AppsError;", "Lcom/kakao/sdk/common/model/AuthError;", "Lcom/kakao/sdk/common/model/ClientError;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public abstract class KakaoSdkError extends RuntimeException {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/common/model/KakaoSdkError$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final j get$cachedSerializer$delegate() {
            return KakaoSdkError.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer serializer() {
            return (KSerializer)this.get$cachedSerializer$delegate().getValue();
        }
    }

    @NotNull
    private static final j $cachedSerializer$delegate;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String msg;

    static {
        KakaoSdkError.Companion = new Companion(null);
        KakaoSdkError.$cachedSerializer$delegate = g.P(k.b, KakaoSdkError.Companion..cachedSerializer.delegate.1.INSTANCE);
    }

    @d
    public KakaoSdkError(int v, String s, SerializationConstructorMarker serializationConstructorMarker0) {
        this.msg = s;
    }

    private KakaoSdkError(String s) {
        super(s);
        this.msg = s;
    }

    public KakaoSdkError(String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s);
    }

    @NotNull
    public String getMsg() {
        return this.msg;
    }

    // 去混淆评级： 低(30)
    public final boolean isInvalidTokenError() {
        return this instanceof AuthError ? ((AuthError)this).getReason() == AuthErrorCause.InvalidGrant : this instanceof ApiError && ((ApiError)this).getReason() == ApiErrorCause.InvalidToken;
    }

    public static final void write$Self(@NotNull KakaoSdkError kakaoSdkError0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(kakaoSdkError0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeStringElement(serialDescriptor0, 0, kakaoSdkError0.getMsg());
    }
}

