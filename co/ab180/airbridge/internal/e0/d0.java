package co.ab180.airbridge.internal.e0;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0003\u0010\fJ\u0010\u0010\r\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0004J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0004R\u0019\u0010\n\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007R\u0019\u0010\u000B\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/e0/d0;", "", "", "a", "()I", "", "b", "()Ljava/lang/String;", "c", "responseCode", "responseMessage", "responseBody", "(ILjava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/internal/e0/d0;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "e", "Ljava/lang/String;", "f", "d", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d0 {
    private final int a;
    @NotNull
    private final String b;
    @NotNull
    private final String c;

    public d0(int v, @NotNull String s, @NotNull String s1) {
        this.a = v;
        this.b = s;
        this.c = s1;
    }

    public static d0 a(d0 d00, int v, String s, String s1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = d00.a;
        }
        if((v1 & 2) != 0) {
            s = d00.b;
        }
        if((v1 & 4) != 0) {
            s1 = d00.c;
        }
        return d00.a(v, s, s1);
    }

    public final int a() {
        return this.a;
    }

    @NotNull
    public final d0 a(int v, @NotNull String s, @NotNull String s1) {
        return new d0(v, s, s1);
    }

    @NotNull
    public final String b() {
        return this.b;
    }

    @NotNull
    public final String c() {
        return this.c;
    }

    @NotNull
    public final String d() {
        return this.c;
    }

    public final int e() {
        return this.a;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof d0 && this.a == ((d0)object0).a && q.b(this.b, ((d0)object0).b) && q.b(this.c, ((d0)object0).c);
    }

    @NotNull
    public final String f() {
        return this.b;
    }

    @Override
    public int hashCode() {
        int v = this.a;
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v * 0x1F + v2) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Response(responseCode=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", responseMessage=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", responseBody=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

