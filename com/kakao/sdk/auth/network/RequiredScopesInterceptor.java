package com.kakao.sdk.auth.network;

import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.AuthCodeClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ExceptionWrapper;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/kakao/sdk/auth/network/RequiredScopesInterceptor;", "Lokhttp3/Interceptor;", "contextInfo", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "(Lcom/kakao/sdk/common/model/ApplicationContextInfo;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RequiredScopesInterceptor implements Interceptor {
    @NotNull
    private final ApplicationContextInfo contextInfo;

    public RequiredScopesInterceptor() {
        this(null, 1, null);
    }

    public RequiredScopesInterceptor(@NotNull ApplicationContextInfo applicationContextInfo0) {
        q.g(applicationContextInfo0, "contextInfo");
        super();
        this.contextInfo = applicationContextInfo0;
    }

    public RequiredScopesInterceptor(ApplicationContextInfo applicationContextInfo0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            applicationContextInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        this(applicationContextInfo0);
    }

    @Override  // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Chain interceptor$Chain0) {
        ApiErrorResponse apiErrorResponse0;
        ResponseBody responseBody1;
        q.g(interceptor$Chain0, "chain");
        Response response0 = interceptor$Chain0.proceed(interceptor$Chain0.request());
        ResponseBody responseBody0 = response0.body();
        ApiErrorCause apiErrorCause0 = null;
        String s = responseBody0 == null ? null : responseBody0.string();
        Builder response$Builder0 = response0.newBuilder();
        if(s == null) {
            responseBody1 = null;
        }
        else {
            MediaType mediaType0 = responseBody0.contentType();
            responseBody1 = ResponseBody.Companion.create(s, mediaType0);
        }
        Response response1 = response$Builder0.body(responseBody1).build();
        if(s != null) {
            MediaType mediaType1 = responseBody0.contentType();
            ResponseBody.Companion.create(s, mediaType1);
        }
        if(!response1.isSuccessful()) {
            if(s == null) {
                apiErrorResponse0 = null;
            }
            else {
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                apiErrorResponse0 = (ApiErrorResponse)json0.decodeFromString(ApiErrorResponse.Companion.serializer(), s);
            }
            if(apiErrorResponse0 != null) {
                Json json1 = KakaoJson.INSTANCE.getJson();
                json1.getSerializersModule();
                apiErrorCause0 = (ApiErrorCause)json1.decodeFromString(ApiErrorCause.Companion.serializer(), String.valueOf(apiErrorResponse0.getCode()));
            }
            if(apiErrorCause0 != null) {
                ApiError apiError0 = new ApiError(response1.code(), apiErrorCause0, apiErrorResponse0);
                List list0 = apiError0.getResponse().getRequiredScopes();
                if(apiError0.getReason() == ApiErrorCause.InsufficientScope) {
                    if(list0 != null && !list0.isEmpty()) {
                        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        CountDownLatch countDownLatch0 = new CountDownLatch(1);
                        AuthApiClient.Companion.getInstance().agt(new n(countDownLatch0, this, list0, h0) {
                            final H $err;
                            final CountDownLatch $latch;
                            final List $requiredScopes;
                            final H $token;

                            {
                                this.$err = h0;
                                this.$latch = countDownLatch0;
                                RequiredScopesInterceptor.this = requiredScopesInterceptor0;
                                this.$requiredScopes = list0;
                                this.$token = h1;
                                super(2);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                this.invoke(((String)object0), ((Throwable)object1));
                                return ie.H.a;
                            }

                            public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                                if(throwable0 != null) {
                                    this.$err.a = throwable0;
                                    this.$latch.countDown();
                                    return;
                                }
                                AuthCodeClient authCodeClient0 = AuthCodeClient.Companion.getInstance();
                                com.kakao.sdk.auth.network.RequiredScopesInterceptor.intercept.1.1.1 requiredScopesInterceptor$intercept$1$1$10 = new n(this.$latch, "ls/2UXFCY8F27RnH9Do7N4jkNqLPc2DZV9IfqV1YJ3hSh3AIFp8jTfIR5uPLfvhyRLDZelhcWdORKuA4w8tlcw", this.$token) {
                                    final String $codeVerifier;
                                    final H $err;
                                    final CountDownLatch $latch;
                                    final H $token;

                                    {
                                        this.$err = h0;
                                        this.$latch = countDownLatch0;
                                        this.$codeVerifier = s;
                                        this.$token = h1;
                                        super(2);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        this.invoke(((String)object0), ((Throwable)object1));
                                        return ie.H.a;
                                    }

                                    public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                                        if(throwable0 != null) {
                                            this.$err.a = throwable0;
                                            this.$latch.countDown();
                                            return;
                                        }
                                        AuthApiClient authApiClient0 = AuthApiClient.Companion.getInstance();
                                        q.d(s);
                                        com.kakao.sdk.auth.network.RequiredScopesInterceptor.intercept.1.1.1.1 requiredScopesInterceptor$intercept$1$1$1$10 = new n(this.$err, this.$latch) {
                                            final H $err;
                                            final CountDownLatch $latch;
                                            final H $token;

                                            {
                                                this.$token = h0;
                                                this.$err = h1;
                                                this.$latch = countDownLatch0;
                                                super(2);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                this.invoke(((OAuthToken)object0), ((Throwable)object1));
                                                return ie.H.a;
                                            }

                                            public final void invoke(@Nullable OAuthToken oAuthToken0, @Nullable Throwable throwable0) {
                                                this.$token.a = oAuthToken0;
                                                this.$err.a = throwable0;
                                                this.$latch.countDown();
                                            }
                                        };
                                        authApiClient0.issueAccessToken(s, this.$codeVerifier, requiredScopesInterceptor$intercept$1$1$1$10);
                                    }
                                };
                                AuthCodeClient.authorizeWithKakaoAccount$default(authCodeClient0, RequiredScopesInterceptor.this.contextInfo.getApplicationContext(), null, this.$requiredScopes, null, s, null, null, null, "ls/2UXFCY8F27RnH9Do7N4jkNqLPc2DZV9IfqV1YJ3hSh3AIFp8jTfIR5uPLfvhyRLDZelhcWdORKuA4w8tlcw", null, requiredScopesInterceptor$intercept$1$1$10, 746, null);
                            }
                        });
                        countDownLatch0.await();
                        OAuthToken oAuthToken0 = (OAuthToken)h0.a;
                        if(oAuthToken0 != null) {
                            String s1 = oAuthToken0.getAccessToken();
                            if(s1 != null) {
                                Response response2 = interceptor$Chain0.proceed(AccessTokenInterceptorKt.withAccessToken(response1.request(), s1));
                                if(response2 != null) {
                                    return response2;
                                }
                            }
                        }
                        Object object0 = h1.a;
                        q.d(object0);
                        throw new ExceptionWrapper(((Throwable)object0));
                    }
                    ApiErrorResponse apiErrorResponse1 = new ApiErrorResponse(ApiErrorCause.Unknown.getErrorCode(), "requiredScopes not exist", null, apiError0.getResponse().getRequiredScopes(), apiError0.getResponse().getAllowedScopes(), 4, null);
                    throw new ExceptionWrapper(new ApiError(apiError0.getStatusCode(), ApiErrorCause.Unknown, apiErrorResponse1));
                }
            }
        }
        return response1;
    }
}

