package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ?\u0010\u0015\u001A\u00020\u00142\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u0017\u001A\u00020\u00142\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001D\u0010!\u001A\u00020 2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b!\u0010\"J\u0015\u0010&\u001A\u00020%2\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b&\u0010\'J\r\u0010(\u001A\u00020\u0011\u00A2\u0006\u0004\b(\u0010)J\u0015\u0010,\u001A\u00020\u00112\u0006\u0010+\u001A\u00020*\u00A2\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010.R\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010/\u001A\u0004\b0\u00101R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u00102R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u00103R\u0018\u00105\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001A\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010>\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010?\u00A8\u0006@"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/EventListener;", "eventListener", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/RealConnection;", "findHealthyConnection", "(IIIIZZ)Lokhttp3/internal/connection/RealConnection;", "findConnection", "(IIIIZ)Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/Route;", "retryRoute", "()Lokhttp3/Route;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "find", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "Ljava/io/IOException;", "e", "Lie/H;", "trackFailure", "(Ljava/io/IOException;)V", "retryAfterFailure", "()Z", "Lokhttp3/HttpUrl;", "url", "sameHostAndPort", "(Lokhttp3/HttpUrl;)Z", "Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/Address;", "getAddress$okhttp", "()Lokhttp3/Address;", "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/EventListener;", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/internal/connection/RouteSelector;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "refusedStreamCount", "I", "connectionShutdownCount", "otherFailureCount", "nextRouteToTry", "Lokhttp3/Route;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ExchangeFinder {
    @NotNull
    private final Address address;
    @NotNull
    private final RealCall call;
    @NotNull
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    @Nullable
    private Selection routeSelection;
    @Nullable
    private RouteSelector routeSelector;

    public ExchangeFinder(@NotNull RealConnectionPool realConnectionPool0, @NotNull Address address0, @NotNull RealCall realCall0, @NotNull EventListener eventListener0) {
        q.g(realConnectionPool0, "connectionPool");
        q.g(address0, "address");
        q.g(realCall0, "call");
        q.g(eventListener0, "eventListener");
        super();
        this.connectionPool = realConnectionPool0;
        this.address = address0;
        this.call = realCall0;
        this.eventListener = eventListener0;
    }

    @NotNull
    public final ExchangeCodec find(@NotNull OkHttpClient okHttpClient0, @NotNull RealInterceptorChain realInterceptorChain0) {
        q.g(okHttpClient0, "client");
        q.g(realInterceptorChain0, "chain");
        try {
            return this.findHealthyConnection(realInterceptorChain0.getConnectTimeoutMillis$okhttp(), realInterceptorChain0.getReadTimeoutMillis$okhttp(), realInterceptorChain0.getWriteTimeoutMillis$okhttp(), okHttpClient0.pingIntervalMillis(), okHttpClient0.retryOnConnectionFailure(), !q.b(realInterceptorChain0.getRequest$okhttp().method(), "GET")).newCodec$okhttp(okHttpClient0, realInterceptorChain0);
        }
        catch(RouteException routeException0) {
            this.trackFailure(routeException0.getLastConnectException());
            throw routeException0;
        }
        catch(IOException iOException0) {
            this.trackFailure(iOException0);
            throw new RouteException(iOException0);
        }
    }

    private final RealConnection findConnection(int v, int v1, int v2, int v3, boolean z) {
        Socket socket0;
        List list0;
        if(this.call.isCanceled()) {
            throw new IOException("Canceled");
        }
        RealConnection realConnection0 = this.call.getConnection();
        if(realConnection0 != null) {
            synchronized(realConnection0) {
                socket0 = realConnection0.getNoNewExchanges() || !this.sameHostAndPort(realConnection0.route().address().url()) ? this.call.releaseConnectionNoEvents$okhttp() : null;
            }
            if(this.call.getConnection() != null) {
                if(socket0 != null) {
                    throw new IllegalStateException("Check failed.");
                }
                return realConnection0;
            }
            if(socket0 != null) {
                Util.closeQuietly(socket0);
            }
            this.eventListener.connectionReleased(this.call, realConnection0);
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if(this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
            RealConnection realConnection1 = this.call.getConnection();
            q.d(realConnection1);
            this.eventListener.connectionAcquired(this.call, realConnection1);
            return realConnection1;
        }
        Route route0 = this.nextRouteToTry;
        if(route0 == null) {
            Selection routeSelector$Selection0 = this.routeSelection;
            if(routeSelector$Selection0 != null) {
                q.d(routeSelector$Selection0);
                if(routeSelector$Selection0.hasNext()) {
                    Selection routeSelector$Selection1 = this.routeSelection;
                    q.d(routeSelector$Selection1);
                    route0 = routeSelector$Selection1.next();
                    list0 = null;
                    goto label_53;
                }
            }
            RouteSelector routeSelector0 = this.routeSelector;
            if(routeSelector0 == null) {
                routeSelector0 = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                this.routeSelector = routeSelector0;
            }
            Selection routeSelector$Selection2 = routeSelector0.next();
            this.routeSelection = routeSelector$Selection2;
            list0 = routeSelector$Selection2.getRoutes();
            if(this.call.isCanceled()) {
                throw new IOException("Canceled");
            }
            if(this.connectionPool.callAcquirePooledConnection(this.address, this.call, list0, false)) {
                RealConnection realConnection2 = this.call.getConnection();
                q.d(realConnection2);
                this.eventListener.connectionAcquired(this.call, realConnection2);
                return realConnection2;
            }
            route0 = routeSelector$Selection2.next();
        }
        else {
            q.d(route0);
            this.nextRouteToTry = null;
            list0 = null;
        }
    label_53:
        RealConnection realConnection3 = new RealConnection(this.connectionPool, route0);
        this.call.setConnectionToCancel(realConnection3);
        try {
            realConnection3.connect(v, v1, v2, v3, z, this.call, this.eventListener);
        }
        finally {
            this.call.setConnectionToCancel(null);
        }
        this.call.getClient().getRouteDatabase().connected(realConnection3.route());
        if(this.connectionPool.callAcquirePooledConnection(this.address, this.call, list0, true)) {
            RealConnection realConnection4 = this.call.getConnection();
            q.d(realConnection4);
            this.nextRouteToTry = route0;
            Util.closeQuietly(realConnection3.socket());
            this.eventListener.connectionAcquired(this.call, realConnection4);
            return realConnection4;
        }
        synchronized(realConnection3) {
            this.connectionPool.put(realConnection3);
            this.call.acquireConnectionNoEvents(realConnection3);
        }
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    private final RealConnection findHealthyConnection(int v, int v1, int v2, int v3, boolean z, boolean z1) {
        boolean z2;
        do {
            do {
                RealConnection realConnection0 = this.findConnection(v, v1, v2, v3, z);
                if(realConnection0.isHealthy(z1)) {
                    return realConnection0;
                }
                z2 = true;
                realConnection0.noNewExchanges$okhttp();
            }
            while(this.nextRouteToTry != null || (this.routeSelection == null ? true : this.routeSelection.hasNext()));
            RouteSelector routeSelector0 = this.routeSelector;
            if(routeSelector0 != null) {
                z2 = routeSelector0.hasNext();
            }
        }
        while(z2);
        throw new IOException("exhausted all routes");
    }

    @NotNull
    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        if(this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if(this.nextRouteToTry != null) {
            return true;
        }
        Route route0 = this.retryRoute();
        if(route0 != null) {
            this.nextRouteToTry = route0;
            return true;
        }
        if(this.routeSelection != null && this.routeSelection.hasNext()) {
            return true;
        }
        return this.routeSelector == null ? true : this.routeSelector.hasNext();
    }

    private final Route retryRoute() {
        if(this.refusedStreamCount <= 1 && this.connectionShutdownCount <= 1 && this.otherFailureCount <= 0) {
            RealConnection realConnection0 = this.call.getConnection();
            if(realConnection0 == null) {
                return null;
            }
            synchronized(realConnection0) {
                if(realConnection0.getRouteFailureCount$okhttp() != 0) {
                    return null;
                }
                if(!Util.canReuseConnectionFor(realConnection0.route().address().url(), this.address.url())) {
                    return null;
                }
            }
            return realConnection0.route();
        }
        return null;
    }

    public final boolean sameHostAndPort(@NotNull HttpUrl httpUrl0) {
        q.g(httpUrl0, "url");
        HttpUrl httpUrl1 = this.address.url();
        return httpUrl0.port() == httpUrl1.port() && q.b(httpUrl0.host(), httpUrl1.host());
    }

    public final void trackFailure(@NotNull IOException iOException0) {
        q.g(iOException0, "e");
        this.nextRouteToTry = null;
        if(iOException0 instanceof StreamResetException && ((StreamResetException)iOException0).errorCode == ErrorCode.REFUSED_STREAM) {
            ++this.refusedStreamCount;
            return;
        }
        if(iOException0 instanceof ConnectionShutdownException) {
            ++this.connectionShutdownCount;
            return;
        }
        ++this.otherFailureCount;
    }
}

