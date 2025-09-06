package co.ab180.airbridge.internal.y;

import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.c0.f.a;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\r\u0010\f\u001A\u00020\b¢\u0006\u0004\b\f\u0010\nJ\r\u0010\u000E\u001A\u00020\u0004¢\u0006\u0004\b\u000E\u0010\u000FR\u001B\u0010\u0014\u001A\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R#\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001A\u0004\b\u0016\u0010\u001A¨\u0006\u001B"}, d2 = {"Lco/ab180/airbridge/internal/y/c;", "", "Lkotlin/Function1;", "", "Lie/H;", "onSuccess", "<init>", "(Lwe/k;)V", "", "d", "()Z", "pushToken", "a", "(Ljava/lang/String;)Z", "e", "()V", "Lco/ab180/airbridge/internal/c0/f/a;", "Lie/j;", "c", "()Lco/ab180/airbridge/internal/c0/f/a;", "preferences", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isWaiting", "Lwe/k;", "()Lwe/k;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c {
    private final j a;
    private final AtomicBoolean b;
    @NotNull
    private final k c;

    public c(@NotNull k k0) {
        this.c = k0;
        this.a = f.b(a.class);
        this.b = new AtomicBoolean(true);
    }

    public final boolean a() {
        this.b.set(false);
        return this.d();
    }

    public final boolean a(@NotNull String s) {
        if(s.length() == 0 || q.b(this.c().n(), s)) {
            return false;
        }
        b.e.d("Push token is registered", new Object[0]);
        this.c().i(s);
        this.c().a(true);
        this.d();
        return true;
    }

    @NotNull
    public final k b() {
        return this.c;
    }

    private final a c() {
        return (a)this.a.getValue();
    }

    private final boolean d() {
        if(!this.b.get() && this.c().C()) {
            String s = this.c().n();
            if(s != null && s.length() != 0) {
                String s1 = this.c().n();
                this.c.invoke(s1);
                return true;
            }
        }
        return false;
    }

    public final void e() {
        this.c().a(false);
    }
}

