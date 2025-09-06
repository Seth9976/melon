package co.ab180.airbridge.internal.b0.m;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001F\u0010 J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000B\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\u0004J@\u0010\u0003\u001A\u00020\u00002\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0003\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001B\u0010\u000F\u001A\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000B\u0010\u0018\u001A\u0004\b\u0019\u0010\u0004R\u001B\u0010\u000E\u001A\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001A\u001A\u0004\b\u001B\u0010\nR\u001B\u0010\f\u001A\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001A\u0004\b\u001C\u0010\u0004R\u001B\u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001D\u001A\u0004\b\u001E\u0010\u0007¨\u0006!"}, d2 = {"Lco/ab180/airbridge/internal/b0/m/e;", "", "", "a", "()Ljava/lang/String;", "", "b", "()Ljava/lang/Long;", "", "c", "()Ljava/lang/Integer;", "d", "referrer", "actualTimestampSeconds", "isCT", "error", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lco/ab180/airbridge/internal/b0/m/e;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "Ljava/lang/Integer;", "h", "g", "Ljava/lang/Long;", "e", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e {
    @Nullable
    private final String a;
    @Nullable
    private final Long b;
    @Nullable
    private final Integer c;
    @Nullable
    private final String d;

    public e() {
        this(null, null, null, null, 15, null);
    }

    public e(@Nullable String s, @Nullable Long long0, @Nullable Integer integer0, @Nullable String s1) {
        this.a = s;
        this.b = long0;
        this.c = integer0;
        this.d = s1;
    }

    public e(String s, Long long0, Integer integer0, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            long0 = null;
        }
        if((v & 4) != 0) {
            integer0 = null;
        }
        if((v & 8) != 0) {
            s1 = null;
        }
        this(s, long0, integer0, s1);
    }

    public static e a(e e0, String s, Long long0, Integer integer0, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = e0.a;
        }
        if((v & 2) != 0) {
            long0 = e0.b;
        }
        if((v & 4) != 0) {
            integer0 = e0.c;
        }
        if((v & 8) != 0) {
            s1 = e0.d;
        }
        return e0.a(s, long0, integer0, s1);
    }

    @NotNull
    public final e a(@Nullable String s, @Nullable Long long0, @Nullable Integer integer0, @Nullable String s1) {
        return new e(s, long0, integer0, s1);
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
    public final String d() {
        return this.d;
    }

    @Nullable
    public final Long e() {
        return this.b;
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof e && q.b(this.a, ((e)object0).a) && q.b(this.b, ((e)object0).b) && q.b(this.c, ((e)object0).c) && q.b(this.d, ((e)object0).d);
    }

    @Nullable
    public final String f() {
        return this.d;
    }

    @Nullable
    public final String g() {
        return this.a;
    }

    @Nullable
    public final Integer h() {
        return this.c;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MetaReferrerInfo(referrer=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", actualTimestampSeconds=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isCT=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", error=");
        return x.m(stringBuilder0, this.d, ")");
    }
}

