package okhttp3;

import ie.d;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall.AsyncCall;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0002\u0010\u0006J\u001D\u0010\u000B\u001A\b\u0018\u00010\tR\u00020\n2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ+\u0010\u0015\u001A\u00020\u0014\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0013\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001B\u0010\u0019\u001A\u00020\u00142\n\u0010\u0013\u001A\u00060\tR\u00020\nH\u0000\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001A\u001A\u00020\u0014\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u0017\u0010\u001D\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\nH\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010\u0015\u001A\u00020\u00142\n\u0010\u0013\u001A\u00060\tR\u00020\nH\u0000\u00A2\u0006\u0004\b\u001E\u0010\u0018J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\nH\u0000\u00A2\u0006\u0004\b\u001E\u0010\u001CJ\u0013\u0010!\u001A\b\u0012\u0004\u0012\u00020 0\u001F\u00A2\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001A\b\u0012\u0004\u0012\u00020 0\u001F\u00A2\u0006\u0004\b#\u0010\"J\r\u0010%\u001A\u00020$\u00A2\u0006\u0004\b%\u0010&J\r\u0010\'\u001A\u00020$\u00A2\u0006\u0004\b\'\u0010&J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b(\u0010)R*\u0010*\u001A\u00020$2\u0006\u0010*\u001A\u00020$8F@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010&\"\u0004\b-\u0010.R*\u0010/\u001A\u00020$2\u0006\u0010/\u001A\u00020$8F@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b/\u0010+\u001A\u0004\b0\u0010&\"\u0004\b1\u0010.R.\u00104\u001A\u0004\u0018\u0001022\b\u00103\u001A\u0004\u0018\u0001028F@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b4\u00105\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010:\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u001E\u0010=\u001A\f\u0012\b\u0012\u00060\tR\u00020\n0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u001E\u0010?\u001A\f\u0012\b\u0012\u00060\tR\u00020\n0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b?\u0010>R\u001A\u0010@\u001A\b\u0012\u0004\u0012\u00020\n0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010>R\u0011\u0010\u0005\u001A\u00020\u00048G\u00A2\u0006\u0006\u001A\u0004\b\u0005\u0010)\u00A8\u0006A"}, d2 = {"Lokhttp3/Dispatcher;", "", "<init>", "()V", "Ljava/util/concurrent/ExecutorService;", "executorService", "(Ljava/util/concurrent/ExecutorService;)V", "", "host", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "findExistingCallWithHost", "(Ljava/lang/String;)Lokhttp3/internal/connection/RealCall$AsyncCall;", "", "promoteAndExecute", "()Z", "T", "Ljava/util/Deque;", "calls", "call", "Lie/H;", "finished", "(Ljava/util/Deque;Ljava/lang/Object;)V", "enqueue$okhttp", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "enqueue", "cancelAll", "executed$okhttp", "(Lokhttp3/internal/connection/RealCall;)V", "executed", "finished$okhttp", "", "Lokhttp3/Call;", "queuedCalls", "()Ljava/util/List;", "runningCalls", "", "queuedCallsCount", "()I", "runningCallsCount", "-deprecated_executorService", "()Ljava/util/concurrent/ExecutorService;", "maxRequests", "I", "getMaxRequests", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ljava/lang/Runnable;", "<set-?>", "idleCallback", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "executorServiceOrNull", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "runningAsyncCalls", "runningSyncCalls", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Dispatcher {
    @Nullable
    private ExecutorService executorServiceOrNull;
    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    @NotNull
    private final ArrayDeque readyAsyncCalls;
    @NotNull
    private final ArrayDeque runningAsyncCalls;
    @NotNull
    private final ArrayDeque runningSyncCalls;

    @d
    @NotNull
    public final ExecutorService -deprecated_executorService() {
        return this.executorService();
    }

    public Dispatcher() {
        this.maxRequests = 0x40;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    public Dispatcher(@NotNull ExecutorService executorService0) {
        q.g(executorService0, "executorService");
        this();
        this.executorServiceOrNull = executorService0;
    }

    public final void cancelAll() {
        synchronized(this) {
            for(Object object0: this.readyAsyncCalls) {
                ((AsyncCall)object0).getCall().cancel();
            }
            for(Object object1: this.runningAsyncCalls) {
                ((AsyncCall)object1).getCall().cancel();
            }
            for(Object object2: this.runningSyncCalls) {
                ((RealCall)object2).cancel();
            }
        }
    }

    public final void enqueue$okhttp(@NotNull AsyncCall realCall$AsyncCall0) {
        q.g(realCall$AsyncCall0, "call");
        synchronized(this) {
            this.readyAsyncCalls.add(realCall$AsyncCall0);
            if(!realCall$AsyncCall0.getCall().getForWebSocket()) {
                AsyncCall realCall$AsyncCall1 = this.findExistingCallWithHost(realCall$AsyncCall0.getHost());
                if(realCall$AsyncCall1 != null) {
                    realCall$AsyncCall0.reuseCallsPerHostFrom(realCall$AsyncCall1);
                }
            }
        }
        this.promoteAndExecute();
    }

    public final void executed$okhttp(@NotNull RealCall realCall0) {
        synchronized(this) {
            q.g(realCall0, "call");
            this.runningSyncCalls.add(realCall0);
        }
    }

    @NotNull
    public final ExecutorService executorService() {
        synchronized(this) {
            if(this.executorServiceOrNull == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, 0x7FFFFFFF, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
            }
            ExecutorService executorService0 = this.executorServiceOrNull;
            q.d(executorService0);
            return executorService0;
        }
    }

    private final AsyncCall findExistingCallWithHost(String s) {
        for(Object object0: this.runningAsyncCalls) {
            AsyncCall realCall$AsyncCall0 = (AsyncCall)object0;
            if(q.b(realCall$AsyncCall0.getHost(), s)) {
                return realCall$AsyncCall0;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: this.readyAsyncCalls) {
            AsyncCall realCall$AsyncCall1 = (AsyncCall)object1;
            if(q.b(realCall$AsyncCall1.getHost(), s)) {
                return realCall$AsyncCall1;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    private final void finished(Deque deque0, Object object0) {
        synchronized(this) {
            if(deque0.remove(object0)) {
                Runnable runnable0 = this.idleCallback;
                if(!this.promoteAndExecute() && runnable0 != null) {
                    runnable0.run();
                }
                return;
            }
        }
        throw new AssertionError("Call wasn\'t in-flight!");
    }

    public final void finished$okhttp(@NotNull AsyncCall realCall$AsyncCall0) {
        q.g(realCall$AsyncCall0, "call");
        realCall$AsyncCall0.getCallsPerHost().decrementAndGet();
        this.finished(this.runningAsyncCalls, realCall$AsyncCall0);
    }

    public final void finished$okhttp(@NotNull RealCall realCall0) {
        q.g(realCall0, "call");
        this.finished(this.runningSyncCalls, realCall0);
    }

    @Nullable
    public final Runnable getIdleCallback() {
        synchronized(this) {
        }
        return this.idleCallback;
    }

    public final int getMaxRequests() {
        synchronized(this) {
        }
        return this.maxRequests;
    }

    public final int getMaxRequestsPerHost() {
        synchronized(this) {
        }
        return this.maxRequestsPerHost;
    }

    private final boolean promoteAndExecute() {
        boolean z;
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2531 MUST NOT hold lock on " + this);
        }
        ArrayList arrayList0 = new ArrayList();
        synchronized(this) {
            Iterator iterator0 = this.readyAsyncCalls.iterator();
            q.f(iterator0, "readyAsyncCalls.iterator()");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                AsyncCall realCall$AsyncCall0 = (AsyncCall)object0;
                if(this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if(realCall$AsyncCall0.getCallsPerHost().get() < this.maxRequestsPerHost) {
                    iterator0.remove();
                    realCall$AsyncCall0.getCallsPerHost().incrementAndGet();
                    arrayList0.add(realCall$AsyncCall0);
                    this.runningAsyncCalls.add(realCall$AsyncCall0);
                }
            }
            z = this.runningCallsCount() > 0;
        }
        int v2 = arrayList0.size();
        for(int v1 = 0; v1 < v2; ++v1) {
            ((AsyncCall)arrayList0.get(v1)).executeOn(this.executorService());
        }
        return z;
    }

    @NotNull
    public final List queuedCalls() {
        synchronized(this) {
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.readyAsyncCalls));
            for(Object object0: this.readyAsyncCalls) {
                arrayList0.add(((AsyncCall)object0).getCall());
            }
            List list0 = Collections.unmodifiableList(arrayList0);
            q.f(list0, "unmodifiableList(readyAsyncCalls.map { it.call })");
            return list0;
        }
    }

    public final int queuedCallsCount() {
        synchronized(this) {
        }
        return this.readyAsyncCalls.size();
    }

    @NotNull
    public final List runningCalls() {
        synchronized(this) {
            ArrayDeque arrayDeque0 = this.runningSyncCalls;
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.runningAsyncCalls));
            for(Object object0: this.runningAsyncCalls) {
                arrayList0.add(((AsyncCall)object0).getCall());
            }
            List list0 = Collections.unmodifiableList(p.A0(arrayDeque0, arrayList0));
            q.f(list0, "unmodifiableList(running…yncCalls.map { it.call })");
            return list0;
        }
    }

    public final int runningCallsCount() {
        synchronized(this) {
        }
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final void setIdleCallback(@Nullable Runnable runnable0) {
        synchronized(this) {
            this.idleCallback = runnable0;
        }
    }

    public final void setMaxRequests(int v) {
        if(v < 1) {
            throw new IllegalArgumentException(("max < 1: " + v).toString());
        }
        synchronized(this) {
            this.maxRequests = v;
        }
        this.promoteAndExecute();
    }

    public final void setMaxRequestsPerHost(int v) {
        if(v < 1) {
            throw new IllegalArgumentException(("max < 1: " + v).toString());
        }
        synchronized(this) {
            this.maxRequestsPerHost = v;
        }
        this.promoteAndExecute();
    }
}

