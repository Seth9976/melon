package co.ab180.airbridge.internal.lifecycle;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel.DefaultImpls;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import me.j;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000E2\u00020\u0001:\u0002\t\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001A\u00020\u00072\"\u0010\b\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u000B\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u000E\u0010\u0003R\u001E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000B\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00050\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/b;", "", "<init>", "()V", "Lkotlin/Function2;", "Lco/ab180/airbridge/internal/lifecycle/c;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "block", "a", "(Lwe/n;)V", "c", "lifecycleContext", "(Lco/ab180/airbridge/internal/lifecycle/c;)V", "b", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lco/ab180/airbridge/internal/x/b;", "d", "Lco/ab180/airbridge/internal/x/b;", "worker", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "e", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "flow", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\u0007\u001A\u00020\u00062\"\u0010\u000B\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\fJ\r\u0010\r\u001A\u00020\u0006¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000E\u001A\u00020\u0006¢\u0006\u0004\b\u000E\u0010\u0003R\u0014\u0010\u0011\u001A\u00020\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0010R\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"co/ab180/airbridge/internal/lifecycle/b$a", "", "<init>", "()V", "Lco/ab180/airbridge/internal/lifecycle/c;", "lifecycleContext", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/lifecycle/c;)V", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "(Lwe/n;)V", "c", "b", "Lco/ab180/airbridge/internal/lifecycle/b;", "()Lco/ab180/airbridge/internal/lifecycle/b;", "instance", "_instance", "Lco/ab180/airbridge/internal/lifecycle/b;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final b a() {
            if(b.a == null) {
                b b0 = new b();
                b.a = b0;
                return b0;
            }
            return b.a;
        }

        public final void a(@NotNull c c0) {
            this.a().a(c0);
        }

        public final void a(@NotNull n n0) {
            this.a().a(n0);
        }

        public final void b() {
            b b0 = b.a;
            if(b0 != null) {
                b0.b();
            }
            b.a = null;
        }

        public final void c() {
            this.a().c();
        }
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"co/ab180/airbridge/internal/lifecycle/b$b", "", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "<init>", "(Ljava/lang/String;I)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static enum co.ab180.airbridge.internal.lifecycle.b.b {
        LAUNCHED,
        BACKGROUNDED,
        FOREGROUNDED,
        STOPPED;

    }

    private static b a;
    @NotNull
    public static final a b;
    private Channel c;
    private final co.ab180.airbridge.internal.x.b d;
    private final MutableSharedFlow e;

    static {
        b.b = new a(null);
    }

    public b() {
        this.c = ChannelKt.Channel$default(0, null, null, 7, null);
        this.d = new co.ab180.airbridge.internal.x.b("lifecycle-runner");
        this.e = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static final void a(b b0, Channel channel0) {
        b0.c = channel0;
    }

    private final void a(c c0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "co/ab180/airbridge/internal/lifecycle/Lifecycle$emit$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.Lifecycle$emit$1$1", f = "Lifecycle.kt", l = {84}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.lifecycle.b.c extends i implements n {
            int a;
            final Channel b;
            final c c;

            public co.ab180.airbridge.internal.lifecycle.b.c(Channel channel0, Continuation continuation0, c c0) {
                this.b = channel0;
                this.c = c0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.lifecycle.b.c(this.b, continuation0, this.c);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.lifecycle.b.c)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        this.a = 1;
                        return this.b.send(this.c, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

        Channel channel0 = this.c;
        if(channel0 != null) {
            co.ab180.airbridge.internal.lifecycle.b.c b$c0 = new co.ab180.airbridge.internal.lifecycle.b.c(channel0, null, c0);
            BuildersKt__Builders_commonKt.launch$default(() -> j.a, null, null, b$c0, 3, null);
        }
    }

    private final void a(n n0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.Lifecycle$register$1", f = "Lifecycle.kt", l = {0x40, 0x40, 69}, m = "invokeSuspend")
        static final class d extends i implements n {
            int a;
            final b b;
            final n c;

            public d(b b0, n n0, Continuation continuation0) {
                this.b = b0;
                this.c = n0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new d(this.b, this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((d)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0;
                try {
                    a0 = ne.a.a;
                    switch(this.a) {
                        case 1: {
                            goto label_5;
                        }
                        case 2: {
                            goto label_7;
                        }
                        case 0: 
                        case 3: {
                            goto label_3;
                        }
                    }
                }
                catch(Throwable throwable0) {
                    goto label_20;
                }
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            label_3:
                d5.n.D(object0);
                goto label_10;
                try {
                label_5:
                    d5.n.D(object0);
                    goto label_15;
                label_7:
                    d5.n.D(object0);
                }
                catch(Throwable throwable0) {
                    goto label_20;
                }
                while(true) {
                    this.a = 3;
                    if(DelayKt.delay(1L, this) == a0) {
                        return a0;
                    }
                label_10:
                    Channel channel0 = this.b.c;
                    if(channel0 == null) {
                        return H.a;
                    }
                    try {
                        this.a = 1;
                        object0 = channel0.receive(this);
                        if(object0 == a0) {
                            return a0;
                        }
                    label_15:
                        if(((c)object0) == null) {
                            return H.a;
                        }
                        this.a = 2;
                        if(this.c.invoke(((c)object0), this) != a0) {
                            continue;
                        }
                        break;
                    }
                    catch(Throwable throwable0) {
                    }
                label_20:
                    co.ab180.airbridge.internal.b.e.b(throwable0);
                }
                return a0;
            }
        }

        if(this.c == null) {
            this.c = ChannelKt.Channel$default(0, null, null, 7, null);
        }
        d b$d0 = new d(this, n0, null);
        this.d.a(b$d0);
    }

    private final void b() {
        this.c();
    }

    private final void c() {
        this.d.a();
        Channel channel0 = this.c;
        if(channel0 != null) {
            DefaultImpls.close$default(channel0, null, 1, null);
        }
        this.c = null;
    }
}

