package co.ab180.airbridge.internal.b0.m;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0003\u001A\u00020\u00002\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0003\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000B\u0010\u0004J\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u0010\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001B\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0004R\u0019\u0010\t\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lco/ab180/airbridge/internal/b0/m/d;", "", "", "a", "()Ljava/lang/String;", "", "b", "()Z", "uuid", "limitAdTracking", "(Ljava/lang/String;Z)Lco/ab180/airbridge/internal/b0/m/d;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "d", "Z", "c", "<init>", "(Ljava/lang/String;Z)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d {
    @Nullable
    private final String a;
    private final boolean b;

    public d(@Nullable String s, boolean z) {
        this.a = s;
        this.b = z;
    }

    public static d a(d d0, String s, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            s = d0.a;
        }
        if((v & 2) != 0) {
            z = d0.b;
        }
        return d0.a(s, z);
    }

    @NotNull
    public final d a(@Nullable String s, boolean z) {
        return new d(s, z);
    }

    @Nullable
    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.b;
    }

    @Nullable
    public final String d() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof d && q.b(this.a, ((d)object0).a) && this.b == ((d)object0).b;
    }

    @Override
    public int hashCode() {
        int v = this.a == null ? 0 : this.a.hashCode();
        int v1 = this.b;
        if(v1) {
            v1 = 1;
        }
        return v * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("IdentifierInfo(uuid=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", limitAdTracking=");
        return o.s(stringBuilder0, this.b, ")");
    }
}

