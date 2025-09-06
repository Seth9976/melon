package okhttp3.internal.connection;

import e2.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocketFactory;
import je.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00A7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001`\u0018\u00002\u00020\u0001:\u0002z{B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0015J\u000F\u0010\u001F\u001A\u00020\u0016H\u0000\u00A2\u0006\u0004\b\u001E\u0010\u0018J\u001D\u0010!\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\u0006\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010(\u001A\u00020%2\u0006\u0010$\u001A\u00020#H\u0000\u00A2\u0006\u0004\b&\u0010\'J\u0015\u0010+\u001A\u00020\u00112\u0006\u0010*\u001A\u00020)\u00A2\u0006\u0004\b+\u0010,J;\u00105\u001A\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010-2\u0006\u0010/\u001A\u00020%2\u0006\u00100\u001A\u00020\u00062\u0006\u00101\u001A\u00020\u00062\u0006\u00102\u001A\u00028\u0000H\u0000\u00A2\u0006\u0004\b3\u00104J\u001B\u00108\u001A\u0004\u0018\u00010-2\b\u00102\u001A\u0004\u0018\u00010-H\u0000\u00A2\u0006\u0004\b6\u00107J\u0011\u0010<\u001A\u0004\u0018\u000109H\u0000\u00A2\u0006\u0004\b:\u0010;J\r\u0010=\u001A\u00020\u0011\u00A2\u0006\u0004\b=\u0010\u0013J\u0017\u0010A\u001A\u00020\u00112\u0006\u0010>\u001A\u00020\u0006H\u0000\u00A2\u0006\u0004\b?\u0010@J\r\u0010B\u001A\u00020\u0006\u00A2\u0006\u0004\bB\u0010\u0015J\u000F\u0010F\u001A\u00020CH\u0000\u00A2\u0006\u0004\bD\u0010EJ\u000F\u0010G\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\bG\u0010\u0013J#\u0010H\u001A\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010-2\u0006\u00102\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\bH\u00107J#\u0010J\u001A\u00028\u0000\"\n\b\u0000\u0010.*\u0004\u0018\u00010-2\u0006\u0010I\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\bJ\u00107J\u0017\u0010N\u001A\u00020M2\u0006\u0010L\u001A\u00020KH\u0002\u00A2\u0006\u0004\bN\u0010OJ\u000F\u0010P\u001A\u00020CH\u0002\u00A2\u0006\u0004\bP\u0010ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010Q\u001A\u0004\bR\u0010SR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010T\u001A\u0004\bU\u0010\u0010R\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010V\u001A\u0004\bW\u0010\u0015R\u0014\u0010Y\u001A\u00020X8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bY\u0010ZR\u001A\u0010\\\u001A\u00020[8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\\\u0010]\u001A\u0004\b^\u0010_R\u0014\u0010\u000B\u001A\u00020`8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010aR\u0014\u0010c\u001A\u00020b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001A\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001A\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bi\u0010jR(\u0010*\u001A\u0004\u0018\u00010)2\b\u0010k\u001A\u0004\u0018\u00010)8\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b*\u0010l\u001A\u0004\bm\u0010nR\u0016\u0010=\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010VR(\u0010o\u001A\u0004\u0018\u00010%2\b\u0010k\u001A\u0004\u0018\u00010%8\u0000@BX\u0080\u000E\u00A2\u0006\f\n\u0004\bo\u0010p\u001A\u0004\bq\u0010rR\u0016\u0010s\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bs\u0010VR\u0016\u0010t\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bt\u0010VR\u0016\u0010u\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bu\u0010VR\u0016\u0010v\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bv\u0010VR\u0018\u0010/\u001A\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u0010pR$\u0010w\u001A\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bw\u0010l\u001A\u0004\bx\u0010n\"\u0004\by\u0010,\u00A8\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/Request;", "originalRequest", "", "forWebSocket", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "Lokio/AsyncTimeout;", "timeout", "()Lokio/AsyncTimeout;", "clone", "()Lokhttp3/internal/connection/RealCall;", "request", "()Lokhttp3/Request;", "Lie/H;", "cancel", "()V", "isCanceled", "()Z", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "enqueue", "(Lokhttp3/Callback;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "Ljava/io/IOException;", "E", "exchange", "requestDone", "responseDone", "e", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "(Ljava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "", "redactedUrl$okhttp", "()Ljava/lang/String;", "redactedUrl", "callStart", "callDone", "cause", "timeoutExit", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Address;", "createAddress", "(Lokhttp3/HttpUrl;)Lokhttp3/Address;", "toLoggableString", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "getOriginalRequest", "Z", "getForWebSocket", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "callStackTrace", "Ljava/lang/Object;", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "interceptorScopedExchange", "Lokhttp3/internal/connection/Exchange;", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RealCall implements Call {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\n\u0010\u0007\u001A\u00060\u0000R\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R$\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00128\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001B\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u001F\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\"\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/Callback;", "responseCallback", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "Lokhttp3/internal/connection/RealCall;", "other", "Lie/H;", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "Lokhttp3/Callback;", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "", "getHost", "()Ljava/lang/String;", "host", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", "call", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class AsyncCall implements Runnable {
        @NotNull
        private volatile AtomicInteger callsPerHost;
        @NotNull
        private final Callback responseCallback;

        public AsyncCall(@NotNull Callback callback0) {
            q.g(callback0, "responseCallback");
            RealCall.this = realCall0;
            super();
            this.responseCallback = callback0;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(@NotNull ExecutorService executorService0) {
            q.g(executorService0, "executorService");
            Dispatcher dispatcher0 = RealCall.this.getClient().dispatcher();
            if(Util.assertionsEnabled && Thread.holdsLock(dispatcher0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2534 MUST NOT hold lock on " + dispatcher0);
            }
            try {
                executorService0.execute(this);
            }
            catch(RejectedExecutionException rejectedExecutionException0) {
                InterruptedIOException interruptedIOException0 = new InterruptedIOException("executor rejected");
                interruptedIOException0.initCause(rejectedExecutionException0);
                RealCall.this.noMoreExchanges$okhttp(interruptedIOException0);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException0);
            }
            finally {
                RealCall.this.getClient().dispatcher().finished$okhttp(this);
            }
        }

        @NotNull
        public final RealCall getCall() {
            return RealCall.this;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return RealCall.this.getOriginalRequest().url().host();
        }

        @NotNull
        public final Request getRequest() {
            return RealCall.this.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall realCall$AsyncCall0) {
            q.g(realCall$AsyncCall0, "other");
            this.callsPerHost = realCall$AsyncCall0.callsPerHost;
        }

        @Override
        public void run() {
            Response response0;
            RealCall realCall0 = RealCall.this;
            Thread thread0 = Thread.currentThread();
            thread0.setName("OkHttp " + RealCall.this.redactedUrl$okhttp());
            try {
                realCall0.timeout.enter();
                boolean z = false;
                try {
                    response0 = realCall0.getResponseWithInterceptorChain$okhttp();
                }
                catch(IOException iOException0) {
                    try {
                        goto label_16;
                    }
                    catch(Throwable throwable1) {
                        realCall0.getClient().dispatcher().finished$okhttp(this);
                        throw throwable1;
                    }
                }
                catch(Throwable throwable0) {
                    goto label_23;
                }
                try {
                    this.responseCallback.onResponse(realCall0, response0);
                    goto label_33;
                }
                catch(IOException iOException0) {
                }
                catch(Throwable throwable0) {
                    goto label_22;
                }
                z = true;
                try {
                label_16:
                    if(z) {
                        Platform.Companion.get().log("Callback failure for " + realCall0.toLoggableString(), 4, iOException0);
                    }
                    else {
                        this.responseCallback.onFailure(realCall0, iOException0);
                        goto label_33;
                    label_22:
                        z = true;
                    label_23:
                        realCall0.cancel();
                        if(!z) {
                            IOException iOException1 = new IOException("canceled due to " + throwable0);
                            a.q(iOException1, throwable0);
                            this.responseCallback.onFailure(realCall0, iOException1);
                        }
                        throw throwable0;
                    }
                }
                catch(Throwable throwable1) {
                    realCall0.getClient().dispatcher().finished$okhttp(this);
                    throw throwable1;
                }
            label_33:
                realCall0.getClient().dispatcher().finished$okhttp(this);
            }
            finally {
                thread0.setName("jeb-dexdec-sb-st-2536");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CallReference extends WeakReference {
        @Nullable
        private final Object callStackTrace;

        public CallReference(@NotNull RealCall realCall0, @Nullable Object object0) {
            q.g(realCall0, "referent");
            super(realCall0);
            this.callStackTrace = object0;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    @Nullable
    private Object callStackTrace;
    private volatile boolean canceled;
    @NotNull
    private final OkHttpClient client;
    @Nullable
    private RealConnection connection;
    @NotNull
    private final RealConnectionPool connectionPool;
    @Nullable
    private volatile RealConnection connectionToCancel;
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private volatile Exchange exchange;
    @Nullable
    private ExchangeFinder exchangeFinder;
    @NotNull
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    @Nullable
    private Exchange interceptorScopedExchange;
    @NotNull
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    @NotNull
    private final okhttp3.internal.connection.RealCall.timeout.1 timeout;
    private boolean timeoutEarlyExit;

    public RealCall(@NotNull OkHttpClient okHttpClient0, @NotNull Request request0, boolean z) {
        q.g(okHttpClient0, "client");
        q.g(request0, "originalRequest");
        super();
        this.client = okHttpClient0;
        this.originalRequest = request0;
        this.forWebSocket = z;
        this.connectionPool = okHttpClient0.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient0.eventListenerFactory().create(this);
        okhttp3.internal.connection.RealCall.timeout.1 realCall$timeout$10 = new AsyncTimeout() {
            @Override  // okio.AsyncTimeout
            public void timedOut() {
                RealCall.this.cancel();
            }
        };
        realCall$timeout$10.timeout(((long)okHttpClient0.callTimeoutMillis()), TimeUnit.MILLISECONDS);
        this.timeout = realCall$timeout$10;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection realConnection0) {
        q.g(realConnection0, "connection");
        if(Util.assertionsEnabled && !Thread.holdsLock(realConnection0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2523 MUST hold lock on " + realConnection0);
        }
        if(this.connection != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.connection = realConnection0;
        realConnection0.getCalls().add(new CallReference(this, this.callStackTrace));
    }

    private final IOException callDone(IOException iOException0) {
        Socket socket0;
        boolean z = Util.assertionsEnabled;
        if(z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2536 MUST NOT hold lock on " + this);
        }
        RealConnection realConnection0 = this.connection;
        if(realConnection0 != null) {
            if(z && Thread.holdsLock(realConnection0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2536 MUST NOT hold lock on " + realConnection0);
            }
            synchronized(realConnection0) {
                socket0 = this.releaseConnectionNoEvents$okhttp();
            }
            if(this.connection == null) {
                if(socket0 != null) {
                    Util.closeQuietly(socket0);
                }
                this.eventListener.connectionReleased(this, realConnection0);
            }
            else if(socket0 != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException iOException1 = this.timeoutExit(iOException0);
        if(iOException0 != null) {
            q.d(iOException1);
            this.eventListener.callFailed(this, iOException1);
            return iOException1;
        }
        this.eventListener.callEnd(this);
        return iOException1;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    @Override  // okhttp3.Call
    public void cancel() {
        if(this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange0 = this.exchange;
        if(exchange0 != null) {
            exchange0.cancel();
        }
        RealConnection realConnection0 = this.connectionToCancel;
        if(realConnection0 != null) {
            realConnection0.cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    @Override  // okhttp3.Call
    public Call clone() {
        return this.clone();
    }

    @NotNull
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    private final Address createAddress(HttpUrl httpUrl0) {
        if(httpUrl0.isHttps()) {
            SSLSocketFactory sSLSocketFactory0 = this.client.sslSocketFactory();
            return new Address(httpUrl0.host(), httpUrl0.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory0, this.client.hostnameVerifier(), this.client.certificatePinner(), this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
        }
        return new Address(httpUrl0.host(), httpUrl0.port(), this.client.dns(), this.client.socketFactory(), null, null, null, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    @Override  // okhttp3.Call
    public void enqueue(@NotNull Callback callback0) {
        q.g(callback0, "responseCallback");
        if(!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        this.callStart();
        AsyncCall realCall$AsyncCall0 = new AsyncCall(this, callback0);
        this.client.dispatcher().enqueue$okhttp(realCall$AsyncCall0);
    }

    public final void enterNetworkInterceptorExchange(@NotNull Request request0, boolean z) {
        q.g(request0, "request");
        if(this.interceptorScopedExchange != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized(this) {
            if(!this.responseBodyOpen) {
                if(this.requestBodyOpen) {
                    throw new IllegalStateException("Check failed.");
                }
                if(z) {
                    Address address0 = this.createAddress(request0.url());
                    this.exchangeFinder = new ExchangeFinder(this.connectionPool, address0, this, this.eventListener);
                }
                return;
            }
        }
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
    }

    @Override  // okhttp3.Call
    @NotNull
    public Response execute() {
        if(this.executed.compareAndSet(false, true)) {
            this.timeout.enter();
            this.callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return this.getResponseWithInterceptorChain$okhttp();
            }
            finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        }
        throw new IllegalStateException("Already Executed");
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        synchronized(this) {
            if(this.expectMoreExchanges) {
                if(z) {
                    Exchange exchange0 = this.exchange;
                    if(exchange0 != null) {
                        exchange0.detachWithViolence();
                    }
                }
                this.interceptorScopedExchange = null;
                return;
            }
        }
        throw new IllegalStateException("released");
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @NotNull
    public final Response getResponseWithInterceptorChain$okhttp() {
        Response response0;
        ArrayList arrayList0 = new ArrayList();
        u.U(arrayList0, this.client.interceptors());
        arrayList0.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList0.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList0.add(new CacheInterceptor(this.client.cache()));
        arrayList0.add(ConnectInterceptor.INSTANCE);
        if(!this.forWebSocket) {
            u.U(arrayList0, this.client.networkInterceptors());
        }
        arrayList0.add(new CallServerInterceptor(this.forWebSocket));
        RealInterceptorChain realInterceptorChain0 = new RealInterceptorChain(this, arrayList0, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        boolean z = false;
        try {
            try {
                response0 = realInterceptorChain0.proceed(this.originalRequest);
                if(this.isCanceled()) {
                    Util.closeQuietly(response0);
                    throw new IOException("Canceled");
                }
            }
            catch(IOException iOException0) {
                z = true;
                IOException iOException1 = this.noMoreExchanges$okhttp(iOException0);
                q.e(iOException1, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOException1;
            }
        }
        catch(Throwable throwable0) {
            if(!z) {
                this.noMoreExchanges$okhttp(null);
            }
            throw throwable0;
        }
        this.noMoreExchanges$okhttp(null);
        return response0;
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain realInterceptorChain0) {
        q.g(realInterceptorChain0, "chain");
        synchronized(this) {
            if(this.expectMoreExchanges) {
                if(this.responseBodyOpen || this.requestBodyOpen) {
                    throw new IllegalStateException("Check failed.");
                }
                ExchangeFinder exchangeFinder0 = this.exchangeFinder;
                q.d(exchangeFinder0);
                ExchangeCodec exchangeCodec0 = exchangeFinder0.find(this.client, realInterceptorChain0);
                Exchange exchange0 = new Exchange(this, this.eventListener, exchangeFinder0, exchangeCodec0);
                this.interceptorScopedExchange = exchange0;
                this.exchange = exchange0;
                synchronized(this) {
                    this.requestBodyOpen = true;
                    this.responseBodyOpen = true;
                }
                if(this.canceled) {
                    throw new IOException("Canceled");
                }
                return exchange0;
            }
        }
        throw new IllegalStateException("released");
    }

    @Override  // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override  // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    public final IOException messageDone$okhttp(@NotNull Exchange exchange0, boolean z, boolean z1, IOException iOException0) {
        int v2;
        q.g(exchange0, "exchange");
        if(exchange0.equals(this.exchange)) {
            synchronized(this) {
                int v = 0;
                if((!z || !this.requestBodyOpen) && (!z1 || !this.responseBodyOpen)) {
                    v2 = 0;
                }
                else {
                    if(z) {
                        this.requestBodyOpen = false;
                    }
                    if(z1) {
                        this.responseBodyOpen = false;
                    }
                    int v1 = this.requestBodyOpen || this.responseBodyOpen ? 0 : 1;
                    if(!this.requestBodyOpen && !this.responseBodyOpen && !this.expectMoreExchanges) {
                        v = 1;
                    }
                    v2 = v;
                    v = v1;
                }
            }
            if(v != 0) {
                this.exchange = null;
                RealConnection realConnection0 = this.connection;
                if(realConnection0 != null) {
                    realConnection0.incrementSuccessCount$okhttp();
                }
            }
            return v2 == 0 ? iOException0 : this.callDone(iOException0);
        }
        return iOException0;
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException iOException0) {
        boolean z;
        synchronized(this) {
            z = false;
            if(this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if(!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
        }
        return z ? this.callDone(iOException0) : iOException0;
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection0 = this.connection;
        q.d(realConnection0);
        if(Util.assertionsEnabled && !Thread.holdsLock(realConnection0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2529 MUST hold lock on " + realConnection0);
        }
        List list0 = realConnection0.getCalls();
        int v = 0;
        Iterator iterator0 = list0.iterator();
        while(true) {
            if(!iterator0.hasNext()) {
                v = -1;
                break;
            }
            Object object0 = iterator0.next();
            if(q.b(((Reference)object0).get(), this)) {
                break;
            }
            ++v;
        }
        if(v == -1) {
            throw new IllegalStateException("Check failed.");
        }
        list0.remove(v);
        this.connection = null;
        if(list0.isEmpty()) {
            realConnection0.setIdleAtNs$okhttp(System.nanoTime());
            return this.connectionPool.connectionBecameIdle(realConnection0) ? realConnection0.socket() : null;
        }
        return null;
    }

    @Override  // okhttp3.Call
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder0 = this.exchangeFinder;
        q.d(exchangeFinder0);
        return exchangeFinder0.retryAfterFailure();
    }

    public final void setConnectionToCancel(@Nullable RealConnection realConnection0) {
        this.connectionToCancel = realConnection0;
    }

    @NotNull
    public AsyncTimeout timeout() {
        return this.timeout;
    }

    @Override  // okhttp3.Call
    public Timeout timeout() {
        return this.timeout();
    }

    public final void timeoutEarlyExit() {
        if(this.timeoutEarlyExit) {
            throw new IllegalStateException("Check failed.");
        }
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }

    private final IOException timeoutExit(IOException iOException0) {
        if(this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException0;
        }
        IOException iOException1 = new InterruptedIOException("timeout");
        if(iOException0 != null) {
            iOException1.initCause(iOException0);
        }
        return iOException1;
    }

    // 去混淆评级： 低(40)
    private final String toLoggableString() {
        return (this.isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : "call") + " to " + this.redactedUrl$okhttp();
    }
}

