package co.ab180.airbridge.internal.z;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0007\u001A\u00020\t¢\u0006\u0004\b\u0007\u0010\nJ%\u0010\u0007\u001A\u00020\t2\u0016\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000Bj\u0002`\f¢\u0006\u0004\b\u0007\u0010\u000EJ\r\u0010\u000F\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\u0003J\u001B\u0010\u0007\u001A\u00020\u00062\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0007\u0010\u0013J\u001B\u0010\u000F\u001A\u00020\u00062\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u000F\u0010\u0013R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/z/h;", "", "<init>", "()V", "Lco/ab180/airbridge/internal/z/b;", "debrisApplication", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/z/b;)V", "Lco/ab180/airbridge/internal/z/a;", "()Lco/ab180/airbridge/internal/z/a;", "Lkotlin/Function1;", "Lco/ab180/airbridge/internal/di/DebrisAppDeclaration;", "debrisAppDeclaration", "(Lwe/k;)Lco/ab180/airbridge/internal/z/a;", "b", "", "Lco/ab180/airbridge/internal/z/j;", "modules", "(Ljava/util/List;)V", "Lco/ab180/airbridge/internal/z/a;", "instance", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class h {
    private static a a;
    @NotNull
    public static final h b;

    static {
        h.b = new h();
    }

    private final void a(b b0) {
        if(h.a != null) {
            throw new IllegalStateException("A Debris Application has already been started");
        }
        h.a = b0.b();
    }

    @NotNull
    public final a a() {
        a a0 = h.a;
        if(a0 == null) {
            throw new IllegalStateException("DebrisContext has not been started");
        }
        return a0;
    }

    @NotNull
    public final a a(@NotNull k k0) {
        synchronized(this) {
            b b0 = b.a.a();
            h.b.a(b0);
            k0.invoke(b0);
            return h.b.a();
        }
    }

    public final void a(@NotNull List list0) {
        this.a().a(list0);
    }

    public final void b() {
        a a0 = h.a;
        if(a0 != null) {
            a0.close();
        }
        h.a = null;
    }

    public final void b(@NotNull List list0) {
        this.a().c(list0);
    }
}

