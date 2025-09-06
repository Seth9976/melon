package co.ab180.airbridge.internal.w;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0003\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000B\u0010\u0004J\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lco/ab180/airbridge/internal/w/c;", "", "", "a", "()Ljava/lang/String;", "", "b", "()J", "id", "startTimestamp", "(Ljava/lang/String;J)Lco/ab180/airbridge/internal/w/c;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "J", "d", "<init>", "(Ljava/lang/String;J)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c {
    @NotNull
    private final String a;
    private final long b;

    public c(@NotNull String s, long v) {
        this.a = s;
        this.b = v;
    }

    public static c a(c c0, String s, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = c0.a;
        }
        if((v1 & 2) != 0) {
            v = c0.b;
        }
        return c0.a(s, v);
    }

    @NotNull
    public final c a(@NotNull String s, long v) {
        return new c(s, v);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    @NotNull
    public final String c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof c && q.b(this.a, ((c)object0).a) && this.b == ((c)object0).b;
    }

    @Override
    public int hashCode() {
        return this.a == null ? Long.hashCode(this.b) : Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EventSession(id=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", startTimestamp=");
        return x.h(this.b, ")", stringBuilder0);
    }
}

