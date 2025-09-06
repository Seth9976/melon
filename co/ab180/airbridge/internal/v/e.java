package co.ab180.airbridge.internal.v;

import android.content.Context;
import co.ab180.airbridge.AirbridgeInAppPurchase;
import co.ab180.airbridge.common.Purchase;
import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.d0.a.a;
import co.ab180.airbridge.internal.d0.a.c;
import co.ab180.airbridge.internal.e0.c0;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import je.q;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ1\u0010\n\u001A\u00020\t2 \u0010\u000F\u001A\u001C\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\fH\u0016\u00A2\u0006\u0004\b\n\u0010\u0010J5\u0010\n\u001A\u00020\t2\u0014\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u000E\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H\u0016\u00A2\u0006\u0004\b\n\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0003J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003R\u001B\u0010\u001F\u001A\u00020\u001B8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\n\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010#\u001A\u00020 8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\'\u001A\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b%\u0010&R2\u0010\u000F\u001A\u001E\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0016\u0010(R$\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u001E\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001A\u00020-8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b.\u0010/\u00A8\u00061"}, d2 = {"Lco/ab180/airbridge/internal/v/e;", "Lco/ab180/airbridge/internal/v/d;", "<init>", "()V", "Lco/ab180/airbridge/internal/d0/a/c;", "billingResult", "", "Lco/ab180/airbridge/internal/d0/a/d;", "purchases", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/d0/a/c;Ljava/util/List;)V", "Lkotlin/Function2;", "Lco/ab180/airbridge/internal/v/c;", "Lco/ab180/airbridge/AirbridgeInAppPurchase;", "onPurchasesUpdatedListener", "(Lwe/n;)V", "Lkotlin/Function1;", "onBillingSetupFinished", "Lkotlin/Function0;", "onBillingServiceDisconnected", "(Lwe/k;Lwe/a;)V", "d", "", "n", "()Z", "close", "Landroid/content/Context;", "Lie/j;", "m", "()Landroid/content/Context;", "context", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoaded", "Lco/ab180/airbridge/internal/d0/a/a;", "c", "Lco/ab180/airbridge/internal/d0/a/a;", "billingClient", "Lwe/n;", "e", "Lwe/k;", "f", "Lwe/a;", "Lco/ab180/airbridge/internal/d0/a/b;", "h", "()Lco/ab180/airbridge/internal/d0/a/b;", "billingClientStateListener", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e implements d {
    private final j a;
    private final AtomicBoolean b;
    private a c;
    private n d;
    private k e;
    private we.a f;

    public e() {
        this.a = f.b(Context.class);
        this.b = new AtomicBoolean(false);
    }

    private final void a(c c0, List list0) {
        ArrayList arrayList1;
        n n0 = this.d;
        if(n0 != null) {
            co.ab180.airbridge.internal.v.c c1 = new co.ab180.airbridge.internal.v.c(c0.d(), c0.c());
            if(list0 == null) {
                arrayList1 = null;
            }
            else {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    Purchase purchase0 = c0.a(((co.ab180.airbridge.internal.d0.a.d)object0));
                    if(purchase0 != null) {
                        arrayList0.add(purchase0);
                    }
                }
                arrayList1 = new ArrayList(q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    arrayList1.add(new AirbridgeInAppPurchase(((Purchase)object1)));
                }
            }
            H h0 = (H)n0.invoke(c1, arrayList1);
        }
    }

    public static final void a(e e0, we.a a0) {
        e0.f = a0;
    }

    public static final void a(e e0, k k0) {
        e0.e = k0;
    }

    @Override  // co.ab180.airbridge.internal.v.d
    public void a(@Nullable k k0, @Nullable we.a a0) {
        if(this.b.get()) {
            try {
                if(this.c == null || !this.c.d()) {
                    b.e.a("Billing client : start connection...", new Object[0]);
                    this.e = k0;
                    this.f = a0;
                    a a1 = this.c;
                    if(a1 != null) {
                        a1.a(this.h());
                    }
                }
            }
            catch(Throwable unused_ex) {
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.v.d
    public void a(@NotNull n n0) {
        @Metadata(d1 = {"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\'\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"co/ab180/airbridge/internal/v/e$b", "Lco/ab180/airbridge/internal/d0/a/e;", "Lco/ab180/airbridge/internal/d0/a/c;", "billingResult", "", "Lco/ab180/airbridge/internal/d0/a/d;", "purchases", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/d0/a/c;Ljava/util/List;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class co.ab180.airbridge.internal.v.e.b extends co.ab180.airbridge.internal.d0.a.e {
            final e b;

            public co.ab180.airbridge.internal.v.e.b(e e0) {
                this.b = e0;
                super();
            }

            @Override  // co.ab180.airbridge.internal.d0.a.e
            public void a(@NotNull c c0, @Nullable List list0) {
                this.b.a(c0, list0);
            }
        }

        if(this.b.get()) {
            return;
        }
        try {
            this.c = a.a(this.m()).a(new co.ab180.airbridge.internal.v.e.b(this)).d().c();
            this.d = n0;
            b.e.a("Billing client : library is successfully loaded", new Object[0]);
            this.b.set(true);
        }
        catch(Throwable unused_ex) {
            b.e.a("Billing client : library is not implemented", new Object[0]);
            this.b.set(false);
        }
    }

    @Override
    public void close() {
        this.d();
    }

    @Override  // co.ab180.airbridge.internal.v.d
    public void d() {
        if(!this.b.get()) {
            return;
        }
        try {
            b.e.a("Billing client : can only be used once -- closing connection", new Object[0]);
            a a0 = this.c;
            if(a0 != null) {
                a0.c();
            }
        }
        catch(Throwable unused_ex) {
        }
        this.b.set(false);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    private final co.ab180.airbridge.internal.d0.a.b h() {
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"co/ab180/airbridge/internal/v/e$a", "Lco/ab180/airbridge/internal/d0/a/b;", "Lco/ab180/airbridge/internal/d0/a/c;", "billingResult", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/d0/a/c;)V", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class co.ab180.airbridge.internal.v.e.a extends co.ab180.airbridge.internal.d0.a.b {
            final e d;

            public co.ab180.airbridge.internal.v.e.a(e e0) {
                this.d = e0;
                super();
            }

            @Override  // co.ab180.airbridge.internal.d0.a.b
            public void a() {
                we.a a0 = this.d.f;
                if(a0 != null) {
                    H h0 = (H)a0.invoke();
                }
            }

            @Override  // co.ab180.airbridge.internal.d0.a.b
            public void a(@NotNull c c0) {
                b.e.d("Billing client : on billing setup finished | responseCode={" + c0.d() + "}, debugMessage={" + c0.c() + '}', new Object[0]);
                k k0 = this.d.e;
                if(k0 != null) {
                    H h0 = (H)k0.invoke(new co.ab180.airbridge.internal.v.c(c0.d(), c0.c()));
                }
            }
        }

        return new co.ab180.airbridge.internal.v.e.a(this);
    }

    private final Context m() {
        return (Context)this.a.getValue();
    }

    @Override  // co.ab180.airbridge.internal.v.d
    public boolean n() {
        try {
            if(this.b.get()) {
                return this.c == null ? false : this.c.d();
            }
        }
        catch(Throwable unused_ex) {
        }
        return false;
    }
}

