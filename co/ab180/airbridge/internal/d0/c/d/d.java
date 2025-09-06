package co.ab180.airbridge.internal.d0.c.d;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u001C\u0010\u001DJ\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u0003\u001A\u00020\u00002\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0003\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001B\u0010\r\u001A\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001A\u0004\b\u0017\u0010\nR\u001B\u0010\f\u001A\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001A\u0004\b\u0019\u0010\u0007R\u001B\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001A\u001A\u0004\b\u001B\u0010\u0004¨\u0006\u001E"}, d2 = {"Lco/ab180/airbridge/internal/d0/c/d/d;", "", "", "a", "()Ljava/lang/String;", "", "b", "()Ljava/lang/Long;", "", "c", "()Ljava/lang/Integer;", "installReferrer", "actualTimestampSeconds", "isCT", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)Lco/ab180/airbridge/internal/d0/c/d/d;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "f", "Ljava/lang/Long;", "d", "Ljava/lang/String;", "e", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d {
    @Nullable
    private final String a;
    @Nullable
    private final Long b;
    @Nullable
    private final Integer c;

    public d(@Nullable String s, @Nullable Long long0, @Nullable Integer integer0) {
        this.a = s;
        this.b = long0;
        this.c = integer0;
    }

    public static d a(d d0, String s, Long long0, Integer integer0, int v, Object object0) {
        if((v & 1) != 0) {
            s = d0.a;
        }
        if((v & 2) != 0) {
            long0 = d0.b;
        }
        if((v & 4) != 0) {
            integer0 = d0.c;
        }
        return d0.a(s, long0, integer0);
    }

    @NotNull
    public final d a(@Nullable String s, @Nullable Long long0, @Nullable Integer integer0) {
        return new d(s, long0, integer0);
    }

    @Nullable
    public final String a() {
        return this.a;
    }

    @Nullable
    public final Long b() {
        return this.b;
    }

    @Nullable
    public final Integer c() {
        return this.c;
    }

    @Nullable
    public final Long d() {
        return this.b;
    }

    @Nullable
    public final String e() {
        return this.a;
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof d && q.b(this.a, ((d)object0).a) && q.b(this.b, ((d)object0).b) && q.b(this.c, ((d)object0).c);
    }

    @Nullable
    public final Integer f() {
        return this.c;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        Integer integer0 = this.c;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "ReferrerDetails(installReferrer=" + this.a + ", actualTimestampSeconds=" + this.b + ", isCT=" + this.c + ")";
    }
}

