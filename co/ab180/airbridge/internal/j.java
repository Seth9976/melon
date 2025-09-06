package co.ab180.airbridge.internal;

import co.ab180.airbridge.internal.e0.p;
import co.ab180.airbridge.internal.e0.x;
import co.ab180.airbridge.internal.x.b;
import co.ab180.airbridge.internal.z.f;
import d5.n;
import ie.H;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u001B\u0010\u0007\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\fJ\u000F\u0010\r\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003R\u001B\u0010\u0012\u001A\u00020\u000E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\u0019\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001D\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010!\u001A\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lco/ab180/airbridge/internal/j;", "Lco/ab180/airbridge/internal/i;", "<init>", "()V", "Lie/H;", "o", "m", "a", "b", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "", "(Lco/ab180/airbridge/internal/w/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "Lco/ab180/airbridge/internal/o;", "Lie/j;", "h", "()Lco/ab180/airbridge/internal/o;", "repository", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "Lco/ab180/airbridge/internal/x/b;", "c", "Lco/ab180/airbridge/internal/x/b;", "worker", "Lco/ab180/airbridge/internal/e0/x;", "d", "Lco/ab180/airbridge/internal/e0/x;", "networkRetryPolicy", "Lkotlinx/coroutines/sync/Mutex;", "e", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class j implements i {
    private final ie.j a;
    private final AtomicBoolean b;
    private final b c;
    private final x d;
    private final Mutex e;

    public j() {
        this.a = f.b(o.class);
        this.b = new AtomicBoolean(false);
        this.c = new b("event-runner");
        this.d = new x();
        this.e = MutexKt.Mutex$default(false, 1, null);
    }

    @Override  // co.ab180.airbridge.internal.i
    @Nullable
    public Object a(@NotNull co.ab180.airbridge.internal.w.b b0, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lco/ab180/airbridge/internal/w/b;", "eventSeed", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "queue", "(Lco/ab180/airbridge/internal/w/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.EventHandlerImpl", f = "EventHandler.kt", l = {50}, m = "queue")
        static final class a extends c {
            Object a;
            int b;
            final j c;
            Object d;

            public a(j j0, Continuation continuation0) {
                this.c = j0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, this);
            }
        }

        j j0;
        a j$a0;
        if(continuation0 instanceof a) {
            j$a0 = (a)continuation0;
            int v = j$a0.b;
            if((v & 0x80000000) == 0) {
                j$a0 = new a(this, continuation0);
            }
            else {
                j$a0.b = v ^ 0x80000000;
            }
        }
        else {
            j$a0 = new a(this, continuation0);
        }
        Object object0 = j$a0.a;
        ne.a a0 = ne.a.a;
        switch(j$a0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.b.e.e("EventHandler(" + p.a(this) + ")#queue : " + b0.m(), new Object[0]);
                o o0 = this.h();
                j$a0.d = this;
                j$a0.b = 1;
                object0 = o0.a(b0, j$a0);
                if(object0 == a0) {
                    return a0;
                }
                j0 = this;
                break;
            }
            case 1: {
                j0 = (j)j$a0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j0.o();
        return (String)object0;
    }

    @Override  // co.ab180.airbridge.internal.i
    public void a() {
        co.ab180.airbridge.internal.b.e.e("EventHandler(" + p.a(this) + ")#start", new Object[0]);
        this.o();
    }

    @Override  // co.ab180.airbridge.internal.i
    public void b() {
        co.ab180.airbridge.internal.b.e.e("EventHandler(" + p.a(this) + ")#stop", new Object[0]);
        this.c.c();
    }

    @Override
    public void close() {
        this.b.set(true);
        this.c.a();
    }

    private final o h() {
        return (o)this.a.getValue();
    }

    private final void m() {
        co.ab180.airbridge.internal.b.e.e("EventHandler(" + p.a(this) + ")#retry", new Object[0]);
        this.c.c();
        co.ab180.airbridge.internal.o.a.b(this.h(), 0L, 1, null);
        this.o();
    }

    private final void o() {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.EventHandlerImpl$run$1", f = "EventHandler.kt", l = {106, 68, 0x4F}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.j.b extends oe.i implements we.n {
            Object a;
            int b;
            final j c;

            public co.ab180.airbridge.internal.j.b(j j0, Continuation continuation0) {
                this.c = j0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.j.b(this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.j.b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Mutex mutex1;
                Mutex mutex0;
                ne.a a0 = ne.a.a;
                switch(this.b) {
                    case 0: {
                        n.D(object0);
                        try {
                            mutex0 = this.c.e;
                            this.a = mutex0;
                            this.b = 1;
                            if(mutex0.lock(null, this) != a0) {
                                mutex1 = mutex0;
                                goto label_12;
                            }
                            return a0;
                        }
                        catch(Throwable throwable0) {
                            goto label_27;
                        }
                        mutex1 = mutex0;
                        goto label_12;
                    }
                    case 1: {
                        mutex1 = (Mutex)this.a;
                        try {
                            n.D(object0);
                        }
                        catch(Throwable throwable0) {
                            goto label_27;
                        }
                        try {
                        label_12:
                            o o0 = this.c.h();
                            this.a = mutex1;
                            this.b = 2;
                            if(o0.c(this) != a0) {
                                goto label_23;
                            }
                            return a0;
                        }
                        catch(Throwable throwable1) {
                            goto label_21;
                        }
                        goto label_23;
                    }
                    case 2: {
                        mutex1 = (Mutex)this.a;
                        try {
                            n.D(object0);
                            goto label_23;
                        }
                        catch(Throwable throwable1) {
                            try {
                            label_21:
                                mutex1.unlock(null);
                                throw throwable1;
                            label_23:
                                mutex1.unlock(null);
                                this.c.d.d();
                                return H.a;
                            }
                            catch(Throwable throwable0) {
                            }
                        }
                    label_27:
                        if(!this.c.d.a(throwable0)) {
                            goto label_39;
                        }
                        this.c.d.b();
                        Long long0 = new Long(this.c.d.c());
                        if(long0.longValue() <= 0L) {
                            long0 = null;
                        }
                        if(long0 != null) {
                            long v = long0.longValue();
                            co.ab180.airbridge.internal.b.e.f(H0.b.g(v, "delay ", "ms"), new Object[0]);
                            this.a = null;
                            this.b = 3;
                            if(DelayKt.delay(v, this) == a0) {
                                return a0;
                            label_39:
                                if(throwable0 instanceof CancellationException) {
                                    co.ab180.airbridge.internal.b.e.a("Flushing queue job was cancelled", new Object[0]);
                                    return H.a;
                                }
                                co.ab180.airbridge.internal.b.e.e(throwable0, "Something went wrong while flushing queue", new Object[0]);
                                return H.a;
                            }
                        }
                        this.c.m();
                        return H.a;
                    }
                    case 3: {
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                n.D(object0);
                this.c.m();
                return H.a;
            }
        }

        if(this.b.get()) {
            return;
        }
        co.ab180.airbridge.internal.j.b j$b0 = new co.ab180.airbridge.internal.j.b(this, null);
        this.c.a(j$b0);
    }
}

