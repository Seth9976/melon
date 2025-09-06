package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.internal.u.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\t\u001A\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0013\u0010\r\u001A\u0004\u0018\u00010\n8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u000E8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0019\u001A\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001A8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0013\u0010!\u001A\u0004\u0018\u00010\u001E8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0013\u0010%\u001A\u0004\u0018\u00010\"8F¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0013\u0010)\u001A\u0004\u0018\u00010&8F¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u0011\u0010-\u001A\u00020*8F¢\u0006\u0006\u001A\u0004\b+\u0010,¨\u0006."}, d2 = {"Lco/ab180/airbridge/internal/u/c/l;", "Lco/ab180/airbridge/internal/u/a;", "<init>", "()V", "Lie/H;", "c", "b", "Lco/ab180/airbridge/internal/u/c/m;", "Lco/ab180/airbridge/internal/u/c/m;", "_notification", "Lco/ab180/airbridge/internal/u/c/a;", "e", "()Lco/ab180/airbridge/internal/u/c/a;", "active", "Lco/ab180/airbridge/internal/u/c/s;", "l", "()Lco/ab180/airbridge/internal/u/c/s;", "user", "Lco/ab180/airbridge/internal/u/c/c;", "g", "()Lco/ab180/airbridge/internal/u/c/c;", "device", "Lco/ab180/airbridge/internal/u/c/t;", "m", "()Lco/ab180/airbridge/internal/u/c/t;", "web", "Lco/ab180/airbridge/internal/u/c/r;", "k", "()Lco/ab180/airbridge/internal/u/c/r;", "push", "Lco/ab180/airbridge/internal/u/c/d;", "h", "()Lco/ab180/airbridge/internal/u/c/d;", "event", "Lco/ab180/airbridge/internal/u/c/f;", "j", "()Lco/ab180/airbridge/internal/u/c/f;", "placement", "Lco/ab180/airbridge/internal/u/c/b;", "f", "()Lco/ab180/airbridge/internal/u/c/b;", "deeplink", "Lco/ab180/airbridge/internal/u/c/e;", "i", "()Lco/ab180/airbridge/internal/u/c/e;", "notification", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class l extends a {
    private final m b;

    public l() {
        this.b = new m();
    }

    @Override  // co.ab180.airbridge.internal.u.a
    public void b() {
        this.a();
    }

    @Override  // co.ab180.airbridge.internal.u.a
    public void c() {
        this.a(new Object[]{new h(), new p(), new j(), new q(), new o(), new k(), new n(), new i()});
    }

    @Nullable
    public final co.ab180.airbridge.internal.u.c.a e() {
        Object object0 = this.a.get("a");
        if(!(object0 instanceof co.ab180.airbridge.internal.u.c.a)) {
            object0 = null;
        }
        return object0 == null ? null : ((co.ab180.airbridge.internal.u.c.a)object0);
    }

    @Nullable
    public final b f() {
        Object object0 = this.a.get("b");
        if(!(object0 instanceof b)) {
            object0 = null;
        }
        return object0 == null ? null : ((b)object0);
    }

    @Nullable
    public final c g() {
        Object object0 = this.a.get("c");
        if(!(object0 instanceof c)) {
            object0 = null;
        }
        return object0 == null ? null : ((c)object0);
    }

    @Nullable
    public final d h() {
        Object object0 = this.a.get("d");
        if(!(object0 instanceof d)) {
            object0 = null;
        }
        return object0 == null ? null : ((d)object0);
    }

    @NotNull
    public final e i() {
        return this.b;
    }

    @Nullable
    public final f j() {
        Object object0 = this.a.get("f");
        if(!(object0 instanceof f)) {
            object0 = null;
        }
        return object0 == null ? null : ((f)object0);
    }

    @Nullable
    public final r k() {
        Object object0 = this.a.get("r");
        if(!(object0 instanceof r)) {
            object0 = null;
        }
        return object0 == null ? null : ((r)object0);
    }

    @Nullable
    public final s l() {
        Object object0 = this.a.get("s");
        if(!(object0 instanceof s)) {
            object0 = null;
        }
        return object0 == null ? null : ((s)object0);
    }

    @Nullable
    public final t m() {
        Object object0 = this.a.get("t");
        if(!(object0 instanceof t)) {
            object0 = null;
        }
        return object0 == null ? null : ((t)object0);
    }
}

