package co.ab180.airbridge.internal.z;

import d5.n;
import e.k;
import ie.o;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000B\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u000B\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000B\u0010\tJ\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\fJ\u001B\u0010\r\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\r\u0010\tJ\u000F\u0010\u000E\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000E\u0010\u0003J\u001C\u0010\u0011\u001A\u00028\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000FH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u000B\u001A\u00028\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000F2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u000B\u0010\u0015J\u001E\u0010\u0016\u001A\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000FH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0012J\'\u0010\r\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000F2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\r\u0010\u0015J\"\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000FH\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0010*\u00020\u000F2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\b\u0010\u0019R\u0014\u0010\u001C\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u001B¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/z/a;", "Ljava/io/Closeable;", "<init>", "()V", "", "Lco/ab180/airbridge/internal/z/j;", "modules", "Lie/H;", "b", "(Ljava/util/List;)V", "module", "a", "(Lco/ab180/airbridge/internal/z/j;)V", "c", "close", "", "T", "h", "()Ljava/lang/Object;", "Ljava/lang/Class;", "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "o", "m", "()Ljava/util/List;", "(Ljava/lang/Class;)Ljava/util/List;", "Lco/ab180/airbridge/internal/z/l;", "Lco/ab180/airbridge/internal/z/l;", "scopeRegistry", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a implements Closeable {
    private final l a;

    public a() {
        this.a = new l();
    }

    public static final l a(a a0) {
        return a0.a;
    }

    @NotNull
    public final Object a(@NotNull Class class0) {
        return this.a.a(class0);
    }

    public final void a(@NotNull j j0) {
        List list0 = k.z(j0);
        this.a.a(list0);
    }

    public final void a(@NotNull List list0) {
        this.a.a(list0);
    }

    @NotNull
    public final List b(@NotNull Class class0) {
        return this.a.b(class0);
    }

    public final void b(@NotNull j j0) {
        List list0 = k.z(j0);
        this.a.c(list0);
    }

    public final void b(@NotNull List list0) {
        this.a.b(list0);
    }

    @Nullable
    public final Object c(@NotNull Class class0) {
        o o0;
        try {
            o0 = this.a(class0);
        }
        catch(Throwable throwable0) {
            o0 = n.t(throwable0);
        }
        return o0 instanceof o ? null : o0;
    }

    public final void c(@NotNull List list0) {
        this.a.c(list0);
    }

    @Override
    public void close() {
        this.a.close();
    }

    public final Object h() {
        q.k();
        throw null;
    }

    public final List m() {
        q.k();
        throw null;
    }

    public final Object o() {
        try {
            q.k();
            throw null;
        }
        catch(Throwable throwable0) {
            n.t(throwable0);
            return null;
        }
    }
}

