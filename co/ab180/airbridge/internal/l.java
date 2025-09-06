package co.ab180.airbridge.internal;

import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.network.model.c;
import co.ab180.airbridge.internal.v.a;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import ie.j;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000F\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001B\u0010\u000E\u001A\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001B\u0010\u0012\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u000B\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001A\u001A\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lco/ab180/airbridge/internal/l;", "Lco/ab180/airbridge/internal/k;", "<init>", "()V", "Lie/H;", "o", "p", "a", "b", "close", "Lco/ab180/airbridge/internal/r;", "Lie/j;", "m", "()Lco/ab180/airbridge/internal/r;", "tracker", "Lco/ab180/airbridge/internal/v/a;", "h", "()Lco/ab180/airbridge/internal/v/a;", "billingClientConnector", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "inAppPurchaseTrackingStarted", "", "l", "()Z", "isInAppPurchaseTrackingStarted", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class l implements k {
    private final j a;
    private final j b;
    private final AtomicBoolean c;

    public l() {
        this.a = f.b(r.class);
        this.b = f.b(a.class);
        this.c = new AtomicBoolean(false);
    }

    @Override  // co.ab180.airbridge.internal.k
    public void a() {
        if(this.c.getAndSet(true)) {
            b.e.f("Airbridge is already started in-app purchase tracking", new Object[0]);
            return;
        }
        b.e.d("registerPurchaseUpdateListener signal is received", new Object[0]);
        this.o();
    }

    @Override  // co.ab180.airbridge.internal.k
    public void b() {
        if(!this.c.getAndSet(false)) {
            b.e.f("Airbridge is already stopped in-app purchase tracking", new Object[0]);
            return;
        }
        b.e.d("unregisterPurchaseUpdateListener signal is received", new Object[0]);
        this.p();
    }

    @Override
    public void close() {
        this.b();
    }

    private final a h() {
        return (a)this.b.getValue();
    }

    @Override  // co.ab180.airbridge.internal.k
    public boolean l() {
        return this.c.get();
    }

    private final r m() {
        return (r)this.a.getValue();
    }

    private final void o() {
        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lco/ab180/airbridge/common/Event;", "purchaseEvent", "Lie/H;", "a", "(Lco/ab180/airbridge/common/Event;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.l.a extends kotlin.jvm.internal.r implements we.k {
            final l a;

            public co.ab180.airbridge.internal.l.a(l l0) {
                this.a = l0;
                super(1);
            }

            public final void a(@NotNull Event event0) {
                co.ab180.airbridge.internal.r.a.a(this.a.m(), c.k, co.ab180.airbridge.internal.network.model.b.b, event0, null, 8, null);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((Event)object0));
                return H.a;
            }
        }

        this.h().e();
        this.h().a(new co.ab180.airbridge.internal.l.a(this));
    }

    private final void p() {
        this.h().d();
    }
}

