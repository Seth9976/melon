package co.ab180.airbridge.internal.c0;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000E\u001A\u00020\u0002\u0012\u0006\u0010\u000F\u001A\u00020\u0005\u0012\u0006\u0010\u0010\u001A\u00020\b\u0012\u0006\u0010\u0011\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000B\u0010\u0004J\u0012\u0010\f\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\r\u0010\u0004JP\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\u000E\u001A\u00020\u00022\b\b\u0002\u0010\u000F\u001A\u00020\u00052\b\b\u0002\u0010\u0010\u001A\u00020\b2\b\b\u0002\u0010\u0011\u001A\u00020\u00022\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u0003\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0007J\u001A\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AR\u0019\u0010\u000F\u001A\u00020\u00058\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\u001B\u001A\u0004\b\u001C\u0010\u0007R\u0019\u0010\u000E\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001D\u001A\u0004\b\u001E\u0010\u0004R\u001B\u0010\u0013\u001A\u0004\u0018\u00010\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\r\u0010\u001D\u001A\u0004\b\u001F\u0010\u0004R\u001B\u0010\u0012\u001A\u0004\u0018\u00010\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\f\u0010\u001D\u001A\u0004\b \u0010\u0004R\u0019\u0010\u0010\u001A\u00020\b8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\t\u0010!\u001A\u0004\b\"\u0010\nR\u0019\u0010\u0011\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010\u001D\u001A\u0004\b#\u0010\u0004\u00A8\u0006&"}, d2 = {"Lco/ab180/airbridge/internal/c0/a;", "", "", "a", "()Ljava/lang/String;", "", "b", "()I", "", "c", "()J", "d", "e", "f", "eventUUID", "eventType", "createdAt", "bodyString", "secretId", "signature", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/internal/c0/a;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "i", "Ljava/lang/String;", "j", "l", "k", "J", "h", "g", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    @NotNull
    private final String a;
    private final int b;
    private final long c;
    @NotNull
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final String f;

    public a(@NotNull String s, int v, long v1, @NotNull String s1, @Nullable String s2, @Nullable String s3) {
        this.a = s;
        this.b = v;
        this.c = v1;
        this.d = s1;
        this.e = s2;
        this.f = s3;
    }

    public a(String s, int v, long v1, String s1, String s2, String s3, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 16) != 0) {
            s2 = null;
        }
        this(s, v, v1, s1, s2, ((v2 & 0x20) == 0 ? s3 : null));
    }

    public static a a(a a0, String s, int v, long v1, String s1, String s2, String s3, int v2, Object object0) {
        if((v2 & 1) != 0) {
            s = a0.a;
        }
        if((v2 & 2) != 0) {
            v = a0.b;
        }
        if((v2 & 4) != 0) {
            v1 = a0.c;
        }
        if((v2 & 8) != 0) {
            s1 = a0.d;
        }
        if((v2 & 16) != 0) {
            s2 = a0.e;
        }
        if((v2 & 0x20) != 0) {
            s3 = a0.f;
        }
        return a0.a(s, v, v1, s1, s2, s3);
    }

    @NotNull
    public final a a(@NotNull String s, int v, long v1, @NotNull String s1, @Nullable String s2, @Nullable String s3) {
        return new a(s, v, v1, s1, s2, s3);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    @NotNull
    public final String d() {
        return this.d;
    }

    @Nullable
    public final String e() {
        return this.e;
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof a && q.b(this.a, ((a)object0).a) && this.b == ((a)object0).b && this.c == ((a)object0).c && q.b(this.d, ((a)object0).d) && q.b(this.e, ((a)object0).e) && q.b(this.f, ((a)object0).f);
    }

    @Nullable
    public final String f() {
        return this.f;
    }

    @NotNull
    public final String g() {
        return this.d;
    }

    public final long h() {
        return this.c;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.c(d.b(this.b, (this.a == null ? 0 : this.a.hashCode()) * 0x1F, 0x1F), 0x1F, this.c);
        int v2 = this.d == null ? 0 : this.d.hashCode();
        int v3 = this.e == null ? 0 : this.e.hashCode();
        String s = this.f;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + v2) * 0x1F + v3) * 0x1F + v;
    }

    public final int i() {
        return this.b;
    }

    @NotNull
    public final String j() {
        return this.a;
    }

    @Nullable
    public final String k() {
        return this.e;
    }

    @Nullable
    public final String l() {
        return this.f;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EventEntityModel(eventUUID=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", eventType=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", createdAt=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", bodyString=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", secretId=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", signature=");
        return x.m(stringBuilder0, this.f, ")");
    }
}

