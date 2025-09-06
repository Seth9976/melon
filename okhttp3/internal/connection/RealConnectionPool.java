package okhttp3.internal.connection;

import e.k;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001.\u0018\u0000 42\u00020\u0001:\u00014B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0012J5\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u000E\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u001C\u001A\u00020\u001B¢\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010 \u001A\u00020\u001F2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001A\u00020\u001B2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\u001F¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0006¢\u0006\u0004\b&\u0010\'R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010)\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001A\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001A\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001A\u00102\u001A\b\u0012\u0004\u0012\u00020\f018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "Lokhttp3/internal/connection/RealConnection;", "connection", "now", "pruneAndGetAllocationCount", "(Lokhttp3/internal/connection/RealConnection;J)I", "idleConnectionCount", "()I", "connectionCount", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", "call", "", "Lokhttp3/Route;", "routes", "", "requireMultiplexed", "callAcquirePooledConnection", "(Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Ljava/util/List;Z)Z", "Lie/H;", "put", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionBecameIdle", "(Lokhttp3/internal/connection/RealConnection;)Z", "evictAll", "()V", "cleanup", "(J)J", "I", "keepAliveDurationNs", "J", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RealConnectionPool {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RealConnectionPool get(@NotNull ConnectionPool connectionPool0) {
            q.g(connectionPool0, "connectionPool");
            return connectionPool0.getDelegate$okhttp();
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final TaskQueue cleanupQueue;
    @NotNull
    private final okhttp3.internal.connection.RealConnectionPool.cleanupTask.1 cleanupTask;
    @NotNull
    private final ConcurrentLinkedQueue connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    static {
        RealConnectionPool.Companion = new Companion(null);
    }

    public RealConnectionPool(@NotNull TaskRunner taskRunner0, int v, long v1, @NotNull TimeUnit timeUnit0) {
        q.g(taskRunner0, "taskRunner");
        q.g(timeUnit0, "timeUnit");
        super();
        this.maxIdleConnections = v;
        this.keepAliveDurationNs = timeUnit0.toNanos(v1);
        this.cleanupQueue = taskRunner0.newQueue();
        this.cleanupTask = new Task("OkHttp ConnectionPool") {
            {
                RealConnectionPool.this = realConnectionPool0;
                super(s, false, 2, null);
            }

            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue();
        if(v1 <= 0L) {
            throw new IllegalArgumentException(e.a(v1, "keepAliveDuration <= 0: ").toString());
        }
    }

    public final boolean callAcquirePooledConnection(@NotNull Address address0, @NotNull RealCall realCall0, @Nullable List list0, boolean z) {
        q.g(address0, "address");
        q.g(realCall0, "call");
        for(Object object0: this.connections) {
            RealConnection realConnection0 = (RealConnection)object0;
            q.f(realConnection0, "connection");
            __monitor_enter(realConnection0);
            try {
                if((!z || realConnection0.isMultiplexed$okhttp()) && realConnection0.isEligible$okhttp(address0, list0)) {
                    realCall0.acquireConnectionNoEvents(realConnection0);
                    goto label_14;
                }
                goto label_16;
            }
            catch(Throwable throwable0) {
            }
            __monitor_exit(realConnection0);
            throw throwable0;
        label_14:
            __monitor_exit(realConnection0);
            return true;
        label_16:
            __monitor_exit(realConnection0);
        }
        return false;
    }

    public final long cleanup(long v) {
        int v1 = 0;
        long v2 = 0x8000000000000000L;
        RealConnection realConnection0 = null;
        int v3 = 0;
        for(Object object0: this.connections) {
            RealConnection realConnection1 = (RealConnection)object0;
            q.f(realConnection1, "connection");
            synchronized(realConnection1) {
                if(this.pruneAndGetAllocationCount(realConnection1, v) > 0) {
                    ++v3;
                }
                else {
                    ++v1;
                    long v5 = v - realConnection1.getIdleAtNs$okhttp();
                    if(v5 > v2) {
                        realConnection0 = realConnection1;
                        v2 = v5;
                    }
                }
            }
        }
        long v6 = this.keepAliveDurationNs;
        if(v2 < v6 && v1 <= this.maxIdleConnections) {
            if(v1 > 0) {
                return v6 - v2;
            }
            return v3 <= 0 ? -1L : v6;
        }
        q.d(realConnection0);
        synchronized(realConnection0) {
            if(!realConnection0.getCalls().isEmpty()) {
                return 0L;
            }
            if(realConnection0.getIdleAtNs$okhttp() + v2 != v) {
                return 0L;
            }
            realConnection0.setNoNewExchanges(true);
            this.connections.remove(realConnection0);
        }
        Util.closeQuietly(realConnection0.socket());
        if(this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return 0L;
    }

    public final boolean connectionBecameIdle(@NotNull RealConnection realConnection0) {
        q.g(realConnection0, "connection");
        if(Util.assertionsEnabled && !Thread.holdsLock(realConnection0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2420 MUST hold lock on " + realConnection0);
        }
        if(!realConnection0.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        realConnection0.setNoNewExchanges(true);
        this.connections.remove(realConnection0);
        if(this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket0;
        Iterator iterator0 = this.connections.iterator();
        q.f(iterator0, "connections.iterator()");
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            RealConnection realConnection0 = (RealConnection)object0;
            q.f(realConnection0, "connection");
            synchronized(realConnection0) {
                if(realConnection0.getCalls().isEmpty()) {
                    iterator0.remove();
                    realConnection0.setNoNewExchanges(true);
                    socket0 = realConnection0.socket();
                }
                else {
                    socket0 = null;
                }
            }
            if(socket0 != null) {
                Util.closeQuietly(socket0);
            }
        }
        if(this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        ConcurrentLinkedQueue concurrentLinkedQueue0 = this.connections;
        int v = 0;
        if(concurrentLinkedQueue0 != null && concurrentLinkedQueue0.isEmpty()) {
            return 0;
        }
        for(Object object0: concurrentLinkedQueue0) {
            q.f(((RealConnection)object0), "it");
            synchronized(((RealConnection)object0)) {
            }
            if(((RealConnection)object0).getCalls().isEmpty()) {
                ++v;
                if(v < 0) {
                    k.N();
                    throw null;
                }
                if(false) {
                    break;
                }
            }
        }
        return v;
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection0, long v) {
        if(Util.assertionsEnabled && !Thread.holdsLock(realConnection0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2400 MUST hold lock on " + realConnection0);
        }
        List list0 = realConnection0.getCalls();
        int v1 = 0;
        while(v1 < list0.size()) {
            Reference reference0 = (Reference)list0.get(v1);
            if(reference0.get() == null) {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection0.route().address().url() + " was leaked. Did you forget to close a response body?", ((CallReference)reference0).getCallStackTrace());
                list0.remove(v1);
                realConnection0.setNoNewExchanges(true);
                if(list0.isEmpty()) {
                    realConnection0.setIdleAtNs$okhttp(v - this.keepAliveDurationNs);
                    return 0;
                }
                if(false) {
                    break;
                }
            }
            else {
                ++v1;
            }
        }
        return list0.size();
    }

    public final void put(@NotNull RealConnection realConnection0) {
        q.g(realConnection0, "connection");
        if(Util.assertionsEnabled && !Thread.holdsLock(realConnection0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2466 MUST hold lock on " + realConnection0);
        }
        this.connections.add(realConnection0);
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }
}

