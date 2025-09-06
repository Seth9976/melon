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

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b&\b\u0087\u0001\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001C\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001Fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'¨\u0006)"}, d2 = {"Lcom/kakao/sdk/common/model/ApiErrorCause;", "", "errorCode", "", "(Ljava/lang/String;II)V", "getErrorCode$annotations", "()V", "getErrorCode", "()I", "InternalError", "IllegalParams", "UnsupportedApi", "BlockedAction", "PermissionDenied", "DeprecatedApi", "ApiLimitExceeded", "NotRegisteredUser", "AlreadyRegisteredUser", "AccountDoesNotExist", "PropertyKeyDoesNotExist", "AppDoesNotExist", "InvalidToken", "InsufficientScope", "RequiredAgeVerification", "UnderAgeLimit", "SigningIsNotCompleted", "InvalidTransaction", "TransactionHasExpired", "NotTalkUser", "NotFriend", "UserDeviceUnsupported", "TalkMessageDisabled", "TalkSendMessageMonthlyLimitExceed", "TalkSendMessageDailyLimitExceed", "ImageUploadSizeExceeded", "ServerTimeOut", "ImageMaxUploadCountExceed", "DeveloperDoesNotExist", "UnderMaintenance", "Unknown", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable(with = ApiErrorCauseSerializer.class)
public enum ApiErrorCause {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/common/model/ApiErrorCause$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/common/model/ApiErrorCause;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final j get$cachedSerializer$delegate() {
            return ApiErrorCause.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer serializer() {
            return (KSerializer)this.get$cachedSerializer$delegate().getValue();
        }
    }

    @SerialName("-1")
    InternalError(-1),
    @SerialName("-2")
    IllegalParams(-2),
    @SerialName("-3")
    UnsupportedApi(-3),
    @SerialName("-4")
    BlockedAction(-4),
    @SerialName("-5")
    PermissionDenied(-5),
    @SerialName("-9")
    DeprecatedApi(-9),
    @SerialName("-10")
    ApiLimitExceeded(-10),
    @SerialName("-101")
    NotRegisteredUser(-101),
    @SerialName("-102")
    AlreadyRegisteredUser(-102),
    @SerialName("-103")
    AccountDoesNotExist(-103),
    @SerialName("-201")
    PropertyKeyDoesNotExist(-201),
    @SerialName("-301")
    AppDoesNotExist(-301),
    @SerialName("-401")
    InvalidToken(-401),
    @SerialName("-402")
    InsufficientScope(-402),
    @SerialName("-405")
    RequiredAgeVerification(-405),
    @SerialName("-406")
    UnderAgeLimit(-406),
    @SerialName("-421")
    SigningIsNotCompleted(-421),
    @SerialName("-422")
    InvalidTransaction(-422),
    @SerialName("-423")
    TransactionHasExpired(-423),
    @SerialName("-501")
    NotTalkUser(-501),
    @SerialName("-502")
    NotFriend(-502),
    @SerialName("-504")
    UserDeviceUnsupported(-504),
    @SerialName("-530")
    TalkMessageDisabled(-530),
    @SerialName("-531")
    TalkSendMessageMonthlyLimitExceed(-531),
    @SerialName("-532")
    TalkSendMessageDailyLimitExceed(-532),
    @SerialName("-602")
    ImageUploadSizeExceeded(-602),
    @SerialName("-603")
    ServerTimeOut(-603),
    @SerialName("-606")
    ImageMaxUploadCountExceed(-606),
    @SerialName("-903")
    DeveloperDoesNotExist(-903),
    @SerialName("-9798")
    UnderMaintenance(-9798),
    @UnknownValue
    Unknown(0x7FFFFFFF);

    @NotNull
    private static final j $cachedSerializer$delegate;
    @NotNull
    public static final Companion Companion;
    private final int errorCode;

    private static final ApiErrorCause[] $values() [...] // Inlined contents

    static {
        j j0;
        ApiErrorCause.Companion = new Companion(null);
        a a0 = ApiErrorCause.Companion..cachedSerializer.delegate.1.INSTANCE;
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
        ApiErrorCause.$cachedSerializer$delegate = j0;
    }

    private ApiErrorCause(int v1) {
        this.errorCode = v1;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @SerialName("error_code")
    public static void getErrorCode$annotations() {
    }
}

