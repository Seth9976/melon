package co.ab180.airbridge.internal.v;

import co.ab180.airbridge.AirbridgeInAppPurchase;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.OnInAppPurchaseReceiveListener;
import co.ab180.airbridge.internal.e0.e0;
import co.ab180.airbridge.internal.e0.e;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import ie.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.DelayKt;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\'\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000F\u0010\u0013\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0010J#\u0010\f\u001A\u00020\u000B2\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000B0\u0014H\u0016¢\u0006\u0004\b\f\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0018\u0010\u0010R\u001B\u0010\u001D\u001A\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u001B\u0010\"\u001A\u00020\u001E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001F\u0010\u001A\u001A\u0004\b \u0010!R$\u0010%\u001A\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001A\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\'R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010)¨\u0006*"}, d2 = {"Lco/ab180/airbridge/internal/v/b;", "Lco/ab180/airbridge/internal/v/a;", "Lco/ab180/airbridge/internal/e0/e0;", "retryPolicy", "<init>", "(Lco/ab180/airbridge/internal/e0/e0;)V", "Lco/ab180/airbridge/internal/v/c;", "result", "", "Lco/ab180/airbridge/AirbridgeInAppPurchase;", "purchases", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/v/c;Ljava/util/List;)V", "(Lco/ab180/airbridge/internal/v/c;)V", "o", "()V", "p", "e", "d", "Lkotlin/Function1;", "Lco/ab180/airbridge/common/Event;", "listener", "(Lwe/k;)V", "close", "Lco/ab180/airbridge/AirbridgeOption;", "Lie/j;", "m", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/v/d;", "b", "h", "()Lco/ab180/airbridge/internal/v/d;", "billingClient", "c", "Lwe/k;", "onPurchasesUpdatedListener", "Lco/ab180/airbridge/internal/x/b;", "Lco/ab180/airbridge/internal/x/b;", "worker", "Lco/ab180/airbridge/internal/e0/e0;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b implements a {
    private final j a;
    private final j b;
    private k c;
    private final co.ab180.airbridge.internal.x.b d;
    private final e0 e;

    public b() {
        this(null, 1, null);
    }

    public b(@NotNull e0 e00) {
        this.e = e00;
        this.a = f.b(AirbridgeOption.class);
        this.b = f.b(d.class);
        this.d = new co.ab180.airbridge.internal.x.b("connector-runner");
    }

    public b(e0 e00, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            e00 = new e0(100L, 900000L, 0.0, 0, 12, null);
        }
        this(e00);
    }

    private final void a(c c0) {
        co.ab180.airbridge.internal.b.e.d("Billing client connector : on billing setup finished | responseCode={" + c0.d() + "}, debugMessage={" + c0.c() + '}', new Object[0]);
        if(c0.d() != 0) {
            this.p();
            return;
        }
        this.e.d();
    }

    private final void a(c c0, List list0) {
        co.ab180.airbridge.internal.b.e.d("Billing client connector : on purchases updated | responseCode={" + c0.d() + "}, debugMessage={" + c0.c() + '}', new Object[0]);
        if(c0.d() == 0 && list0 != null) {
            for(Object object0: list0) {
                AirbridgeInAppPurchase airbridgeInAppPurchase0 = (AirbridgeInAppPurchase)object0;
                OnInAppPurchaseReceiveListener onInAppPurchaseReceiveListener0 = this.m().getOnInAppPurchaseReceiveListener();
                if(onInAppPurchaseReceiveListener0 != null) {
                    onInAppPurchaseReceiveListener0.onInAppPurchaseReceived(airbridgeInAppPurchase0);
                }
                k k0 = this.c;
                if(k0 != null) {
                    H h0 = (H)k0.invoke(e.a(airbridgeInAppPurchase0, this.m().getInAppPurchaseEnvironment()));
                }
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.v.a
    public void a(@NotNull k k0) {
        this.c = k0;
    }

    @Override
    public void close() {
        this.d.a();
        this.d();
    }

    @Override  // co.ab180.airbridge.internal.v.a
    public void d() {
        co.ab180.airbridge.internal.b.e.d("Billing client connector : end connection", new Object[0]);
        this.h().d();
    }

    @Override  // co.ab180.airbridge.internal.v.a
    public void e() {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lco/ab180/airbridge/internal/v/c;", "result", "", "Lco/ab180/airbridge/AirbridgeInAppPurchase;", "purchases", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/v/c;Ljava/util/List;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.v.b.b extends r implements n {
            final b a;

            public co.ab180.airbridge.internal.v.b.b(b b0) {
                this.a = b0;
                super(2);
            }

            public final void a(@NotNull c c0, @Nullable List list0) {
                this.a.a(c0, list0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.a(((c)object0), ((List)object1));
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lco/ab180/airbridge/internal/v/c;", "it", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/v/c;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.v.b.c extends r implements k {
            final b a;

            public co.ab180.airbridge.internal.v.b.c(b b0) {
                this.a = b0;
                super(1);
            }

            public final void a(@NotNull c c0) {
                this.a.a(c0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((c)object0));
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.v.b.d extends r implements we.a {
            final b a;

            public co.ab180.airbridge.internal.v.b.d(b b0) {
                this.a = b0;
                super(0);
            }

            public final void a() {
                this.a.o();
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        co.ab180.airbridge.internal.b.e.d("Billing client connector : start connection", new Object[0]);
        this.h().a(new co.ab180.airbridge.internal.v.b.b(this));
        this.h().a(new co.ab180.airbridge.internal.v.b.c(this), new co.ab180.airbridge.internal.v.b.d(this));
    }

    private final d h() {
        return (d)this.b.getValue();
    }

    private final AirbridgeOption m() {
        return (AirbridgeOption)this.a.getValue();
    }

    private final void o() {
        co.ab180.airbridge.internal.b.e.d("Billing client connector : on billing service disconnected", new Object[0]);
        this.p();
    }

    private final void p() {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.billing.BillingClientConnectorImpl$retryBillingServiceConnection$1", f = "BillingClientConnector.kt", l = {103}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.v.b.a extends i implements n {
            int a;
            final b b;

            public co.ab180.airbridge.internal.v.b.a(b b0, Continuation continuation0) {
                this.b = b0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.v.b.a(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.v.b.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        Long long0 = new Long(this.b.e.c());
                        co.ab180.airbridge.internal.b.e.d(H0.b.g(long0.longValue(), "Billing client connector : retry billing service connection after {", "} milliseconds"), new Object[0]);
                        if(long0.longValue() <= 0L) {
                            long0 = null;
                        }
                        if(long0 != null) {
                            this.a = 1;
                            if(DelayKt.delay(long0.longValue(), this) == a0) {
                                return a0;
                            }
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                this.b.e();
                return H.a;
            }
        }

        this.e.b();
        if(this.e.a()) {
            this.d.c();
            co.ab180.airbridge.internal.v.b.a b$a0 = new co.ab180.airbridge.internal.v.b.a(this, null);
            this.d.a(b$a0);
            return;
        }
        co.ab180.airbridge.internal.b.e.d("Billing client connector : retry count exceeded", new Object[0]);
    }
}

