package com.kakao.sdk.network;

import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.util.KakaoJson;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A;\u0010\u0007\u001A\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u001A\u0010\u0006\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A9\u0010\u000B\u001A\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0018\u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000B\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Lokhttp3/Interceptor$Chain;", "Lokhttp3/Request;", "request", "Lkotlin/Function2;", "Lokhttp3/Response;", "", "bodyHandler", "proceedBodyString", "(Lokhttp3/Interceptor$Chain;Lokhttp3/Request;Lwe/n;)Lokhttp3/Response;", "Lcom/kakao/sdk/common/model/ApiError;", "errorHandler", "proceedApiError", "network_release"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class UtilityKt {
    @NotNull
    public static final Response proceedApiError(@NotNull Chain interceptor$Chain0, @NotNull Request request0, @NotNull n n0) {
        ApiErrorResponse apiErrorResponse0;
        ResponseBody responseBody1;
        q.g(interceptor$Chain0, "<this>");
        q.g(request0, "request");
        q.g(n0, "errorHandler");
        Response response0 = interceptor$Chain0.proceed(request0);
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
            return apiErrorCause0 == null ? response1 : ((Response)n0.invoke(response1, new ApiError(response1.code(), apiErrorCause0, apiErrorResponse0)));
        }
        return response1;
    }

    @NotNull
    public static final Response proceedBodyString(@NotNull Chain interceptor$Chain0, @NotNull Request request0, @NotNull n n0) {
        q.g(interceptor$Chain0, "<this>");
        q.g(request0, "request");
        q.g(n0, "bodyHandler");
        Response response0 = interceptor$Chain0.proceed(request0);
        ResponseBody responseBody0 = response0.body();
        ResponseBody responseBody1 = null;
        String s = responseBody0 == null ? null : responseBody0.string();
        Builder response$Builder0 = response0.newBuilder();
        if(s != null) {
            MediaType mediaType0 = responseBody0.contentType();
            responseBody1 = ResponseBody.Companion.create(s, mediaType0);
        }
        Response response1 = response$Builder0.body(responseBody1).build();
        if(s != null) {
            MediaType mediaType1 = responseBody0.contentType();
            ResponseBody.Companion.create(s, mediaType1);
        }
        return (Response)n0.invoke(response1, s);
    }
}

