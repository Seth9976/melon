package co.ab180.airbridge.internal.u.c;

import co.ab180.airbridge.internal.o;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\f\u001A\u00020\u00062\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\bJ!\u0010\u0010\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0010\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J!\u0010\u0010\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\u0013\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\u001B\u0010\u0017\u001A\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001A\u0004\b\f\u0010\u0016¨\u0006\u0018"}, d2 = {"Lco/ab180/airbridge/internal/u/c/p;", "Lco/ab180/airbridge/internal/u/c/s;", "<init>", "()V", "", "id", "Lie/H;", "d", "(Ljava/lang/String;)V", "email", "c", "phone", "b", "key", "", "value", "a", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "e", "Lco/ab180/airbridge/internal/o;", "Lie/j;", "()Lco/ab180/airbridge/internal/o;", "repository", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class p implements s {
    private final j a;

    public p() {
        this.a = f.b(o.class);
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void a() {
        this.b().a();
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void a(@NotNull String s, @Nullable Object object0) {
        this.b().a(s, object0);
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void a(@NotNull String s, @Nullable String s1) {
        this.b().a(s, s1);
    }

    private final o b() {
        return (o)this.a.getValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void b(@Nullable String s) {
        this.b().b(s);
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void c(@Nullable String s) {
        this.b().c(s);
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void d() {
        this.b().d();
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void d(@Nullable String s) {
        this.b().d(s);
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void e() {
        this.b().e();
    }
}

