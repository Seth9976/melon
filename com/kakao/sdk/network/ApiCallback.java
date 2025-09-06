package com.kakao.sdk.network;

import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.Q;
import tg.d;
import tg.g;
import tg.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000B\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00018\u00002\b\u0010\t\u001A\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000B\u0010\fJ%\u0010\u0010\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/kakao/sdk/network/ApiCallback;", "T", "Ltg/g;", "", "logging", "<init>", "(Z)V", "model", "", "error", "Lie/H;", "onComplete", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Ltg/d;", "call", "t", "onFailure", "(Ltg/d;Ljava/lang/Throwable;)V", "Ltg/Q;", "response", "onResponse", "(Ltg/d;Ltg/Q;)V", "Z", "getLogging", "()Z", "Companion", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class ApiCallback implements g {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/network/ApiCallback$Companion;", "", "()V", "translateError", "", "t", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Throwable translateError(@NotNull Throwable throwable0) {
            String s;
            q.g(throwable0, "t");
            try {
                if(throwable0 instanceof p) {
                    Q q0 = ((p)throwable0).c;
                    if(q0 == null) {
                        s = null;
                    }
                    else {
                        ResponseBody responseBody0 = q0.c;
                        s = responseBody0 == null ? null : responseBody0.string();
                    }
                    q.d(s);
                    Json json0 = KakaoJson.INSTANCE.getJson();
                    json0.getSerializersModule();
                    ApiErrorResponse apiErrorResponse0 = (ApiErrorResponse)json0.decodeFromString(ApiErrorResponse.Companion.serializer(), s);
                    Json json1 = KakaoJson.INSTANCE.getJson();
                    json1.getSerializersModule();
                    ApiErrorCause apiErrorCause0 = (ApiErrorCause)json1.decodeFromString(BuiltinSerializersKt.getNullable(ApiErrorCause.Companion.serializer()), String.valueOf(apiErrorResponse0.getCode()));
                    if(apiErrorCause0 == null) {
                        apiErrorCause0 = ApiErrorCause.Unknown;
                    }
                    return new ApiError(((p)throwable0).a, apiErrorCause0, apiErrorResponse0);
                }
                return ExceptionWrapperKt.getOrigin(throwable0);
            }
            catch(Throwable throwable1) {
            }
            return throwable1;
        }
    }

    @NotNull
    public static final Companion Companion;
    private final boolean logging;

    static {
        ApiCallback.Companion = new Companion(null);
    }

    public ApiCallback() {
        this(false, 1, null);
    }

    public ApiCallback(boolean z) {
        this.logging = z;
    }

    public ApiCallback(boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            z = true;
        }
        this(z);
    }

    public final boolean getLogging() {
        return this.logging;
    }

    public abstract void onComplete(@Nullable Object arg1, @Nullable Throwable arg2);

    @Override  // tg.g
    public void onFailure(@NotNull d d0, @NotNull Throwable throwable0) {
        q.g(d0, "call");
        q.g(throwable0, "t");
        Throwable throwable1 = ExceptionWrapperKt.getOrigin(throwable0);
        if(this.logging) {
            SdkLog.Companion.e(throwable1);
        }
        this.onComplete(null, throwable1);
    }

    @Override  // tg.g
    public void onResponse(@NotNull d d0, @NotNull Q q0) {
        q.g(d0, "call");
        q.g(q0, "response");
        Object object0 = q0.b;
        if(object0 != null) {
            if(this.logging) {
                SdkLog.Companion.i(object0);
            }
            this.onComplete(object0, null);
            return;
        }
        p p0 = new p(q0);
        this.onFailure(d0, ApiCallback.Companion.translateError(p0));
    }
}

