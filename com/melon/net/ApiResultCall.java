package com.melon.net;

import com.iloen.melon.net.HttpResponse;
import ie.H;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import tg.Q;
import tg.d;
import tg.g;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001D\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003*\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\u000F\u001A\u00020\u000E2\u0012\u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001B\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0013\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001A\u0010\u0017J\u000F\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0016¢\u0006\u0004\b\u001F\u0010 R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\"¨\u0006#"}, d2 = {"Lcom/melon/net/ApiResultCall;", "T", "Ltg/d;", "Lcom/melon/net/ApiResult;", "call", "Ljava/lang/reflect/Type;", "dataType", "<init>", "(Ltg/d;Ljava/lang/reflect/Type;)V", "Ltg/Q;", "toApiResult", "(Ltg/Q;)Lcom/melon/net/ApiResult;", "Ltg/g;", "callback", "Lie/H;", "enqueue", "(Ltg/g;)V", "clone", "()Ltg/d;", "execute", "()Ltg/Q;", "", "isExecuted", "()Z", "cancel", "()V", "isCanceled", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Ltg/d;", "Ljava/lang/reflect/Type;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class ApiResultCall implements d {
    @NotNull
    private final d call;
    @NotNull
    private final Type dataType;

    public ApiResultCall(@NotNull d d0, @NotNull Type type0) {
        q.g(d0, "call");
        q.g(type0, "dataType");
        super();
        this.call = d0;
        this.dataType = type0;
    }

    @Override  // tg.d
    public void cancel() {
        this.call.cancel();
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    @Override  // tg.d
    @NotNull
    public d clone() {
        d d0 = this.call.clone();
        q.f(d0, "clone(...)");
        return new ApiResultCall(d0, this.dataType);
    }

    @Override  // tg.d
    public void enqueue(@NotNull g g0) {
        q.g(g0, "callback");
        com.melon.net.ApiResultCall.enqueue.1 apiResultCall$enqueue$10 = new g() {
            @Override  // tg.g
            public void onFailure(d d0, Throwable throwable0) {
                q.g(d0, "call");
                q.g(throwable0, "throwable");
                MelonThrowable melonThrowable0 = throwable0 instanceof MelonThrowable ? ((MelonThrowable)throwable0) : new NetworkError(null, throwable0, null, 4, null);
                Q q0 = Q.a(new MelonFailure(melonThrowable0.getMessage(), melonThrowable0));
                this.$callback.onResponse(g0, q0);
            }

            @Override  // tg.g
            public void onResponse(d d0, Q q0) {
                HttpResponse httpResponse0 = null;
                q.g(d0, "call");
                q.g(q0, "response");
                String s = q0.a.headers().get("M-Log");
                if(s != null) {
                    if(s.length() <= 0) {
                        s = null;
                    }
                    if(s != null) {
                        Object object0 = q0.b;
                        if(object0 instanceof HttpResponse) {
                            httpResponse0 = (HttpResponse)object0;
                        }
                        if(httpResponse0 != null) {
                            httpResponse0.logging = s;
                        }
                    }
                }
                Q q1 = Q.a(g0.toApiResult(q0));
                this.$callback.onResponse(g0, q1);
            }
        };
        this.call.enqueue(apiResultCall$enqueue$10);
    }

    @Override  // tg.d
    @NotNull
    public Q execute() {
        throw new UnsupportedOperationException("Not Support This Function");
    }

    @Override  // tg.d
    public boolean isCanceled() {
        return this.call.isCanceled();
    }

    @Override  // tg.d
    public boolean isExecuted() {
        return this.call.isExecuted();
    }

    @Override  // tg.d
    @NotNull
    public Request request() {
        Request request0 = this.call.request();
        q.f(request0, "request(...)");
        return request0;
    }

    @Override  // tg.d
    @NotNull
    public Timeout timeout() {
        Timeout timeout0 = this.call.timeout();
        q.f(timeout0, "timeout(...)");
        return timeout0;
    }

    private final ApiResult toApiResult(Q q0) {
        Response response0 = q0.a;
        if(!q0.a.isSuccessful()) {
            int v = response0.code();
            if(v == 401 || v == 403) {
                q.f(response0, "raw(...)");
                AuthFailureError melonThrowable$AuthFailureError0 = new AuthFailureError(response0, response0.code(), null, 4, null);
                return new MelonFailure(melonThrowable$AuthFailureError0.getMessage(), melonThrowable$AuthFailureError0);
            }
            if(400 <= v && v < 500) {
                q.f(response0, "raw(...)");
                ClientError melonThrowable$ClientError0 = new ClientError(response0, response0.code(), null, 4, null);
                return new MelonFailure(melonThrowable$ClientError0.getMessage(), melonThrowable$ClientError0);
            }
            if(500 <= v && v < 600) {
                q.f(response0, "raw(...)");
                ServerError melonThrowable$ServerError0 = new ServerError(response0, response0.code(), null, 4, null);
                return new MelonFailure(melonThrowable$ServerError0.getMessage(), melonThrowable$ServerError0);
            }
            q.f(response0, "raw(...)");
            ServerError melonThrowable$ServerError1 = new ServerError(response0, response0.code(), null, 4, null);
            return new MelonFailure(melonThrowable$ServerError1.getMessage(), melonThrowable$ServerError1);
        }
        Object object0 = q0.b;
        if(object0 != null) {
            return new Success(object0);
        }
        if(q.b(this.dataType, H.class)) {
            return new Success(H.a);
        }
        String s = response0.message();
        q.f(s, "message(...)");
        return new MelonFailure(s, new NetworkError(response0.code(), null, null, 4, null));
    }
}

