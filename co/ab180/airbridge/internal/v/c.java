package co.ab180.airbridge.internal.v;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0003\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000B\u0010\u0007J\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u001A\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\t\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001A\u0004\b\u0012\u0010\u0007R\u0019\u0010\b\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/v/c;", "", "", "a", "()I", "", "b", "()Ljava/lang/String;", "responseCode", "debugMessage", "(ILjava/lang/String;)Lco/ab180/airbridge/internal/v/c;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "I", "d", "<init>", "(ILjava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c {
    private final int a;
    @NotNull
    private final String b;

    public c(int v, @NotNull String s) {
        this.a = v;
        this.b = s;
    }

    public static c a(c c0, int v, String s, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = c0.a;
        }
        if((v1 & 2) != 0) {
            s = c0.b;
        }
        return c0.a(v, s);
    }

    public final int a() {
        return this.a;
    }

    @NotNull
    public final c a(int v, @NotNull String s) {
        return new c(v, s);
    }

    @NotNull
    public final String b() {
        return this.b;
    }

    @NotNull
    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof c && this.a == ((c)object0).a && q.b(this.b, ((c)object0).b);
    }

    @Override
    public int hashCode() {
        return this.b == null ? this.a * 0x1F : this.a * 0x1F + this.b.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BillingClientResult(responseCode=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", debugMessage=");
        return x.m(stringBuilder0, this.b, ")");
    }
}

