package co.ab180.airbridge.internal.b0.m;

import U4.x;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@d
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u0006\u0012\u0006\u0010\r\u001A\u00020\u0006¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0003\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0004J\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001A\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001A\u0004\b\u0018\u0010\bR\u0019\u0010\f\u001A\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001A\u0004\b\u0019\u0010\bR\u0019\u0010\u000B\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001A\u001A\u0004\b\u001B\u0010\u0004R\u0019\u0010\n\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001A\u001A\u0004\b\u001C\u0010\u0004¨\u0006\u001F"}, d2 = {"Lco/ab180/airbridge/internal/b0/m/f;", "", "", "a", "()Ljava/lang/String;", "b", "", "c", "()J", "d", "pid", "referrer", "referrerClickTimestampSeconds", "installBeginTimestampSeconds", "(Ljava/lang/String;Ljava/lang/String;JJ)Lco/ab180/airbridge/internal/b0/m/f;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "e", "h", "Ljava/lang/String;", "g", "f", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class f {
    @NotNull
    private final String a;
    @NotNull
    private final String b;
    private final long c;
    private final long d;

    public f(@NotNull String s, @NotNull String s1, long v, long v1) {
        this.a = s;
        this.b = s1;
        this.c = v;
        this.d = v1;
    }

    public static f a(f f0, String s, String s1, long v, long v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = f0.a;
        }
        if((v2 & 2) != 0) {
            s1 = f0.b;
        }
        if((v2 & 4) != 0) {
            v = f0.c;
        }
        if((v2 & 8) != 0) {
            v1 = f0.d;
        }
        return f0.a(s, s1, v, v1);
    }

    @NotNull
    public final f a(@NotNull String s, @NotNull String s1, long v, long v1) {
        return new f(s, s1, v, v1);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    @NotNull
    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.d;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof f && q.b(this.a, ((f)object0).a) && q.b(this.b, ((f)object0).b) && this.c == ((f)object0).c && this.d == ((f)object0).d;
    }

    @NotNull
    public final String f() {
        return this.a;
    }

    @NotNull
    public final String g() {
        return this.b;
    }

    public final long h() {
        return this.c;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return Long.hashCode(this.d) + A7.d.c((v1 * 0x1F + v) * 0x1F, 0x1F, this.c);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OneStoreReferrerInfo(pid=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", referrer=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", referrerClickTimestampSeconds=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", installBeginTimestampSeconds=");
        return x.h(this.d, ")", stringBuilder0);
    }
}

