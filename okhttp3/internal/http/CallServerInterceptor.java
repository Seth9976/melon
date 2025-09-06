package okhttp3.internal.http;

import e2.a;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0010\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override  // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Chain interceptor$Chain0) {
        int v2;
        Builder response$Builder0;
        q.g(interceptor$Chain0, "chain");
        Exchange exchange0 = ((RealInterceptorChain)interceptor$Chain0).getExchange$okhttp();
        q.d(exchange0);
        Request request0 = ((RealInterceptorChain)interceptor$Chain0).getRequest$okhttp();
        RequestBody requestBody0 = request0.body();
        long v = System.currentTimeMillis();
        int v1 = 1;
        Long long0 = null;
        try {
            exchange0.writeRequestHeaders(request0);
            if(!HttpMethod.permitsRequestBody(request0.method()) || requestBody0 == null) {
                goto label_31;
            }
            else {
                if("100-continue".equalsIgnoreCase(request0.header("Expect"))) {
                    exchange0.flushRequest();
                    response$Builder0 = exchange0.readResponseHeaders(true);
                    goto label_13;
                }
                else {
                    goto label_16;
                }
                goto label_18;
            }
            goto label_37;
        }
        catch(IOException iOException0) {
            response$Builder0 = null;
            goto label_41;
        }
        try {
        label_13:
            exchange0.responseHeadersStart();
            v2 = 0;
            goto label_18;
        }
        catch(IOException iOException0) {
            goto label_41;
        }
        try {
        label_16:
            v2 = 1;
            response$Builder0 = null;
        }
        catch(IOException iOException0) {
            response$Builder0 = null;
            goto label_41;
        }
        try {
        label_18:
            if(response$Builder0 == null) {
                BufferedSink bufferedSink0 = Okio.buffer(exchange0.createRequestBody(request0, false));
                requestBody0.writeTo(bufferedSink0);
                bufferedSink0.close();
            }
            else {
                exchange0.noRequestBody();
                if(!exchange0.getConnection$okhttp().isMultiplexed$okhttp()) {
                    exchange0.noNewExchangesOnConnection();
                }
            }
            v1 = v2;
            goto label_37;
        }
        catch(IOException iOException0) {
            v1 = v2;
            goto label_41;
        }
        try {
        label_31:
            exchange0.noRequestBody();
            response$Builder0 = null;
        }
        catch(IOException iOException0) {
            response$Builder0 = null;
            goto label_41;
        }
        try {
        label_37:
            exchange0.finishRequest();
            iOException0 = null;
            goto label_43;
        }
        catch(IOException iOException0) {
        }
    label_41:
        if(iOException0 instanceof ConnectionShutdownException || !exchange0.getHasFailure$okhttp()) {
            throw iOException0;
        }
        try {
        label_43:
            if(response$Builder0 == null) {
                response$Builder0 = exchange0.readResponseHeaders(false);
                q.d(response$Builder0);
                if(v1 != 0) {
                    exchange0.responseHeadersStart();
                    v1 = 0;
                }
            }
            Response response0 = response$Builder0.request(request0).handshake(exchange0.getConnection$okhttp().handshake()).sentRequestAtMillis(v).receivedResponseAtMillis(System.currentTimeMillis()).build();
            int v3 = response0.code();
            if(this.shouldIgnoreAndWaitForRealResponse(v3)) {
                Builder response$Builder1 = exchange0.readResponseHeaders(false);
                q.d(response$Builder1);
                if(v1 != 0) {
                    exchange0.responseHeadersStart();
                }
                response0 = response$Builder1.request(request0).handshake(exchange0.getConnection$okhttp().handshake()).sentRequestAtMillis(v).receivedResponseAtMillis(System.currentTimeMillis()).build();
                v3 = response0.code();
            }
            exchange0.responseHeadersEnd(response0);
            Response response1 = !this.forWebSocket || v3 != 101 ? response0.newBuilder().body(exchange0.openResponseBody(response0)).build() : response0.newBuilder().body(Util.EMPTY_RESPONSE).build();
            if("close".equalsIgnoreCase(response1.request().header("Connection")) || "close".equalsIgnoreCase(Response.header$default(response1, "Connection", null, 2, null))) {
                exchange0.noNewExchangesOnConnection();
            }
            if(v3 == 204 || v3 == 205) {
                ResponseBody responseBody0 = response1.body();
                if((responseBody0 == null ? -1L : responseBody0.contentLength()) > 0L) {
                    StringBuilder stringBuilder0 = new StringBuilder("HTTP ");
                    stringBuilder0.append(v3);
                    stringBuilder0.append(" had non-zero Content-Length: ");
                    ResponseBody responseBody1 = response1.body();
                    if(responseBody1 != null) {
                        long0 = responseBody1.contentLength();
                    }
                    stringBuilder0.append(long0);
                    throw new ProtocolException(stringBuilder0.toString());
                }
            }
            return response1;
        label_75:
            if(iOException0 == null) {
                throw iOException1;
            }
        }
        catch(IOException iOException1) {
            goto label_75;
        }
        a.q(iOException0, iOException1);
        throw iOException0;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int v) {
        return v == 100 ? true : 102 <= v && v < 200;
    }
}

