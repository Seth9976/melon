package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.internal.k;
import co.ab180.airbridge.internal.r;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000F\u0010\u000B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000F\u0010\r\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000F\u0010\u000E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u0003R\u001B\u0010\u0013\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0010\u0010\u0012R\u001B\u0010\u0018\u001A\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001A\u0004\b\u0016\u0010\u0017R\u001B\u0010\u001B\u001A\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0011\u001A\u0004\b\u0015\u0010\u001A¨\u0006\u001C"}, d2 = {"Lco/ab180/airbridge/internal/u/c/h;", "Lco/ab180/airbridge/internal/u/c/a;", "<init>", "()V", "Lie/H;", "j", "l", "", "i", "()Z", "f", "g", "c", "h", "k", "Lco/ab180/airbridge/AirbridgeOption;", "a", "Lie/j;", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/r;", "b", "d", "()Lco/ab180/airbridge/internal/r;", "tracker", "Lco/ab180/airbridge/internal/k;", "()Lco/ab180/airbridge/internal/k;", "purchaseConnector", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class h implements a {
    private final j a;
    private final j b;
    private final j c;

    public h() {
        this.a = f.b(AirbridgeOption.class);
        this.b = f.b(r.class);
        this.c = f.b(k.class);
    }

    private final AirbridgeOption a() {
        return (AirbridgeOption)this.a.getValue();
    }

    private final k b() {
        return (k)this.c.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public boolean c() {
        return this.b().l();
    }

    private final r d() {
        return (r)this.b.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void f() {
        this.d().f();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void g() {
        this.d().g();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void h() {
        this.b().a();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public boolean i() {
        return this.d().j();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void j() {
        if(this.a().isAutoStartTrackingEnabled()) {
            this.f();
        }
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void k() {
        this.b().b();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void l() {
    }
}

