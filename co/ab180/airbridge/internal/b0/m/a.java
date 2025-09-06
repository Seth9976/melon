package co.ab180.airbridge.internal.b0.m;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0003\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000B\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007R\u0019\u0010\n\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001A\u0004\b\u0017\u0010\u0007R\u0019\u0010\t\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001A\u0004\b\u0019\u0010\u0004¨\u0006\u001C"}, d2 = {"Lco/ab180/airbridge/internal/b0/m/a;", "", "", "a", "()Ljava/lang/String;", "", "b", "()J", "c", "referrer", "referrerClickTimestampSeconds", "installBeginTimestampSeconds", "(Ljava/lang/String;JJ)Lco/ab180/airbridge/internal/b0/m/a;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "d", "f", "Ljava/lang/String;", "e", "<init>", "(Ljava/lang/String;JJ)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    @NotNull
    private final String a;
    private final long b;
    private final long c;

    public a(@NotNull String s, long v, long v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    public static a a(a a0, String s, long v, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = a0.a;
        }
        if((v2 & 2) != 0) {
            v = a0.b;
        }
        if((v2 & 4) != 0) {
            v1 = a0.c;
        }
        return a0.a(s, v, v1);
    }

    @NotNull
    public final a a(@NotNull String s, long v, long v1) {
        return new a(s, v, v1);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.c;
    }

    @NotNull
    public final String e() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof a && q.b(this.a, ((a)object0).a) && this.b == ((a)object0).b && this.c == ((a)object0).c;
    }

    public final long f() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.a == null ? Long.hashCode(this.c) + d.c(0, 0x1F, this.b) : Long.hashCode(this.c) + d.c(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GalaxyStoreReferrerInfo(referrer=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", referrerClickTimestampSeconds=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", installBeginTimestampSeconds=");
        return x.h(this.c, ")", stringBuilder0);
    }
}

