package co.ab180.airbridge.internal.b0;

import co.ab180.airbridge.internal.b0.m.a;
import co.ab180.airbridge.internal.b0.m.b;
import co.ab180.airbridge.internal.b0.m.c;
import co.ab180.airbridge.internal.b0.m.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0015\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u00C6\u0003\u00A2\u0006\u0004\b\u000F\u0010\u0010JL\u0010\u0003\u001A\u00020\u00002\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u000EH\u00C6\u0001\u00A2\u0006\u0004\b\u0003\u0010\u0016J\u0010\u0010\u0018\u001A\u00020\u0017H\u00D6\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001B\u001A\u00020\u001AH\u00D6\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001A\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u001F\u0010 R\u001B\u0010\u0011\u001A\u0004\u0018\u00010\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010!\u001A\u0004\b\"\u0010\u0004R\u001B\u0010\u0014\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\f\u0010#\u001A\u0004\b$\u0010\rR\u001B\u0010\u0015\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u000F\u0010%\u001A\u0004\b&\u0010\u0010R\u0015\u0010(\u001A\u0004\u0018\u00010\u000E8F@\u0006\u00A2\u0006\u0006\u001A\u0004\b\'\u0010\u0010R\u0015\u0010*\u001A\u0004\u0018\u00010\u000E8F@\u0006\u00A2\u0006\u0006\u001A\u0004\b)\u0010\u0010R\u001B\u0010\u0013\u001A\u0004\u0018\u00010\b8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\t\u0010+\u001A\u0004\b,\u0010\nR\u0015\u0010.\u001A\u0004\u0018\u00010\u00178F@\u0006\u00A2\u0006\u0006\u001A\u0004\b-\u0010\u0019R\u001B\u0010\u0012\u001A\u0004\u0018\u00010\u00058\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010/\u001A\u0004\b0\u0010\u0007\u00A8\u00063"}, d2 = {"Lco/ab180/airbridge/internal/b0/d;", "", "Lco/ab180/airbridge/internal/b0/m/b;", "a", "()Lco/ab180/airbridge/internal/b0/m/b;", "Lco/ab180/airbridge/internal/b0/m/c;", "b", "()Lco/ab180/airbridge/internal/b0/m/c;", "Lco/ab180/airbridge/internal/b0/m/a;", "c", "()Lco/ab180/airbridge/internal/b0/m/a;", "Lco/ab180/airbridge/internal/b0/m/e;", "d", "()Lco/ab180/airbridge/internal/b0/m/e;", "", "e", "()Ljava/lang/Long;", "googleInstallReferrer", "huaweiInstallReferrer", "galaxyStoreInstallReferrer", "metaInstallReferrer", "installTimestamp", "(Lco/ab180/airbridge/internal/b0/m/b;Lco/ab180/airbridge/internal/b0/m/c;Lco/ab180/airbridge/internal/b0/m/a;Lco/ab180/airbridge/internal/b0/m/e;Ljava/lang/Long;)Lco/ab180/airbridge/internal/b0/d;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/ab180/airbridge/internal/b0/m/b;", "g", "Lco/ab180/airbridge/internal/b0/m/e;", "k", "Ljava/lang/Long;", "j", "i", "installBeginTimestamp", "m", "referrerClickTimestamp", "Lco/ab180/airbridge/internal/b0/m/a;", "f", "l", "referrer", "Lco/ab180/airbridge/internal/b0/m/c;", "h", "<init>", "(Lco/ab180/airbridge/internal/b0/m/b;Lco/ab180/airbridge/internal/b0/m/c;Lco/ab180/airbridge/internal/b0/m/a;Lco/ab180/airbridge/internal/b0/m/e;Ljava/lang/Long;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d {
    @Nullable
    private final b a;
    @Nullable
    private final c b;
    @Nullable
    private final a c;
    @Nullable
    private final e d;
    @Nullable
    private final Long e;

    public d() {
        this(null, null, null, null, null, 0x1F, null);
    }

    public d(@Nullable b b0, @Nullable c c0, @Nullable a a0, @Nullable e e0, @Nullable Long long0) {
        this.a = b0;
        this.b = c0;
        this.c = a0;
        this.d = e0;
        this.e = long0;
    }

    public d(b b0, c c0, a a0, e e0, Long long0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            b0 = null;
        }
        if((v & 2) != 0) {
            c0 = null;
        }
        if((v & 4) != 0) {
            a0 = null;
        }
        if((v & 8) != 0) {
            e0 = null;
        }
        this(b0, c0, a0, e0, ((v & 16) == 0 ? long0 : null));
    }

    public static d a(d d0, b b0, c c0, a a0, e e0, Long long0, int v, Object object0) {
        if((v & 1) != 0) {
            b0 = d0.a;
        }
        if((v & 2) != 0) {
            c0 = d0.b;
        }
        if((v & 4) != 0) {
            a0 = d0.c;
        }
        if((v & 8) != 0) {
            e0 = d0.d;
        }
        if((v & 16) != 0) {
            long0 = d0.e;
        }
        return d0.a(b0, c0, a0, e0, long0);
    }

    @NotNull
    public final d a(@Nullable b b0, @Nullable c c0, @Nullable a a0, @Nullable e e0, @Nullable Long long0) {
        return new d(b0, c0, a0, e0, long0);
    }

    @Nullable
    public final b a() {
        return this.a;
    }

    @Nullable
    public final c b() {
        return this.b;
    }

    @Nullable
    public final a c() {
        return this.c;
    }

    @Nullable
    public final e d() {
        return this.d;
    }

    @Nullable
    public final Long e() {
        return this.e;
    }

    // 去混淆评级： 中等(60)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof d && q.b(this.a, ((d)object0).a) && q.b(this.b, ((d)object0).b) && q.b(this.c, ((d)object0).c) && q.b(this.d, ((d)object0).d) && q.b(this.e, ((d)object0).e);
    }

    @Nullable
    public final a f() {
        return this.c;
    }

    @Nullable
    public final b g() {
        return this.a;
    }

    @Nullable
    public final c h() {
        return this.b;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        Long long0 = this.e;
        if(long0 != null) {
            v = long0.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Nullable
    public final Long i() {
        return this.a == null ? null : ((long)(this.a.i() * 1000L));
    }

    @Nullable
    public final Long j() {
        return this.e;
    }

    @Nullable
    public final e k() {
        return this.d;
    }

    @Nullable
    public final String l() {
        return this.a == null ? null : this.a.l();
    }

    @Nullable
    public final Long m() {
        return this.a == null ? null : ((long)(this.a.m() * 1000L));
    }

    @Override
    @NotNull
    public String toString() {
        return "EventBodyPart(googleInstallReferrer=" + this.a + ", huaweiInstallReferrer=" + this.b + ", galaxyStoreInstallReferrer=" + this.c + ", metaInstallReferrer=" + this.d + ", installTimestamp=" + this.e + ")";
    }
}

