package com.kakao.sdk.common.model;

import com.kakao.sdk.common.json.UnknownValue;
import i.n.i.b.a.s.e.M3;
import ie.C;
import ie.I;
import ie.j;
import ie.k;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0087\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/kakao/sdk/common/model/AppsErrorCause;", "", "(Ljava/lang/String;I)V", "InternalServerError", "InvalidRequest", "InvalidParameter", "TimeExpired", "InvalidChannel", "IllegalStateChannel", "AppTypeError", "AppScopeError", "PermissionError", "AppKeyTypeError", "AppChannelNotConnected", "AuthError", "NotRegisteredUser", "InvalidScope", "AccountTermsError", "LoginRequired", "InvalidShippingAddressId", "Unknown", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable(with = AppsErrorCauseSerializer.class)
public enum AppsErrorCause {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/common/model/AppsErrorCause$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/common/model/AppsErrorCause;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final j get$cachedSerializer$delegate() {
            return AppsErrorCause.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer serializer() {
            return (KSerializer)this.get$cachedSerializer$delegate().getValue();
        }
    }

    @SerialName("KAE001")
    InternalServerError,
    @SerialName("KAE002")
    InvalidRequest,
    @SerialName("KAE003")
    InvalidParameter,
    @SerialName("KAE004")
    TimeExpired,
    @SerialName("KAE005")
    InvalidChannel,
    @SerialName("KAE006")
    IllegalStateChannel,
    @SerialName("KAE101")
    AppTypeError,
    @SerialName("KAE102")
    AppScopeError,
    @SerialName("KAE103")
    PermissionError,
    @SerialName("KAE104")
    AppKeyTypeError,
    @SerialName("KAE105")
    AppChannelNotConnected,
    @SerialName("KAE201")
    AuthError,
    @SerialName("KAE202")
    NotRegisteredUser,
    @SerialName("KAE203")
    InvalidScope,
    @SerialName("KAE204")
    AccountTermsError,
    @SerialName("KAE205")
    LoginRequired,
    @SerialName("KAE206")
    InvalidShippingAddressId,
    @UnknownValue
    Unknown;

    @NotNull
    private static final j $cachedSerializer$delegate;
    @NotNull
    public static final Companion Companion;

    private static final AppsErrorCause[] $values() [...] // Inlined contents

    static {
        j j0;
        AppsErrorCause.Companion = new Companion(null);
        a a0 = AppsErrorCause.Companion..cachedSerializer.delegate.1.INSTANCE;
        C c0 = C.a;
        if(a0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException(q.i("initializer"));
            q.l(nullPointerException0, q.class.getName());
            throw nullPointerException0;
        }
        switch(k.b.ordinal()) {
            case 0: {
                j0 = new r(a0);
                break;
            }
            case 1: {
                j j1 = new ie.q();  // 初始化器: Ljava/lang/Object;-><init>()V
                j1.a = a0;
                j1.b = c0;
                j0 = j1;
                break;
            }
            case 2: {
                j j2 = new I();  // 初始化器: Ljava/lang/Object;-><init>()V
                j2.a = a0;
                j2.b = c0;
                j0 = j2;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        AppsErrorCause.$cachedSerializer$delegate = j0;
    }
}

