package co.ab180.airbridge.internal.w;

import A7.d;
import co.ab180.airbridge.internal.network.model.GoalData;
import co.ab180.airbridge.internal.network.model.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0018\b\u0080\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0019\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u001A\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u001B\u001A\u00020\b\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010 \u001A\u00020\u0013\u0012\u0018\b\u0002\u0010!\u001A\u0012\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016\u00A2\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bH\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\rJ\u0012\u0010\u000F\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u000F\u0010\rJ\u0012\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001A\u0012\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0082\u0001\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\u0019\u001A\u00020\u00022\b\b\u0002\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\b2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010 \u001A\u00020\u00132\u0018\b\u0002\u0010!\u001A\u0012\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016H\u00C6\u0001\u00A2\u0006\u0004\b\u0003\u0010\"J\u0010\u0010#\u001A\u00020\u000BH\u00D6\u0001\u00A2\u0006\u0004\b#\u0010\rJ\u0010\u0010%\u001A\u00020$H\u00D6\u0001\u00A2\u0006\u0004\b%\u0010&J\u001A\u0010(\u001A\u00020\u00132\b\u0010\'\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b(\u0010)R\u001B\u0010\u001E\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u000F\u0010*\u001A\u0004\b+\u0010\rR)\u0010!\u001A\u0012\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00168\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0017\u0010,\u001A\u0004\b-\u0010\u0018R\u0019\u0010\u0019\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010.\u001A\u0004\b/\u0010\u0004R\u001B\u0010\u001D\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010*\u001A\u0004\b0\u0010\rR\u0019\u0010\u001B\u001A\u00020\b8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\t\u00101\u001A\u0004\b2\u0010\nR\u0019\u0010\u001A\u001A\u00020\u00058\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0006\u00103\u001A\u0004\b4\u0010\u0007R\u0019\u0010 \u001A\u00020\u00138\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0014\u00105\u001A\u0004\b6\u0010\u0015R\u001B\u0010\u001C\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\f\u0010*\u001A\u0004\b7\u0010\rR\u001B\u0010\u001F\u001A\u0004\u0018\u00010\u00108\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0011\u00108\u001A\u0004\b9\u0010\u0012\u00A8\u0006<"}, d2 = {"Lco/ab180/airbridge/internal/w/b;", "", "Lco/ab180/airbridge/internal/network/model/c;", "a", "()Lco/ab180/airbridge/internal/network/model/c;", "", "b", "()J", "Lco/ab180/airbridge/internal/network/model/b;", "c", "()Lco/ab180/airbridge/internal/network/model/b;", "", "d", "()Ljava/lang/String;", "e", "f", "Lco/ab180/airbridge/internal/network/model/GoalData;", "g", "()Lco/ab180/airbridge/internal/network/model/GoalData;", "", "h", "()Z", "", "i", "()Ljava/util/Map;", "eventType", "createdTimeMillis", "triggerType", "deeplink", "referrer", "pushToken", "goalData", "chkInstallReferrer", "sdkAttributes", "(Lco/ab180/airbridge/internal/network/model/c;JLco/ab180/airbridge/internal/network/model/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/GoalData;ZLjava/util/Map;)Lco/ab180/airbridge/internal/w/b;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "o", "Ljava/util/Map;", "q", "Lco/ab180/airbridge/internal/network/model/c;", "m", "p", "Lco/ab180/airbridge/internal/network/model/b;", "r", "J", "k", "Z", "j", "l", "Lco/ab180/airbridge/internal/network/model/GoalData;", "n", "<init>", "(Lco/ab180/airbridge/internal/network/model/c;JLco/ab180/airbridge/internal/network/model/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/ab180/airbridge/internal/network/model/GoalData;ZLjava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @NotNull
    private final c a;
    private final long b;
    @NotNull
    private final co.ab180.airbridge.internal.network.model.b c;
    @Nullable
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final String f;
    @Nullable
    private final GoalData g;
    private final boolean h;
    @Nullable
    private final Map i;

    public b(@NotNull c c0, long v, @NotNull co.ab180.airbridge.internal.network.model.b b0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable GoalData goalData0, boolean z, @Nullable Map map0) {
        this.a = c0;
        this.b = v;
        this.c = b0;
        this.d = s;
        this.e = s1;
        this.f = s2;
        this.g = goalData0;
        this.h = z;
        this.i = map0;
    }

    public b(c c0, long v, co.ab180.airbridge.internal.network.model.b b0, String s, String s1, String s2, GoalData goalData0, boolean z, Map map0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(c0, ((v1 & 2) == 0 ? v : System.currentTimeMillis()), ((v1 & 4) == 0 ? b0 : co.ab180.airbridge.internal.network.model.b.b), ((v1 & 8) == 0 ? s : null), ((v1 & 16) == 0 ? s1 : null), ((v1 & 0x20) == 0 ? s2 : null), ((v1 & 0x40) == 0 ? goalData0 : null), ((v1 & 0x80) == 0 ? z : false), ((v1 & 0x100) == 0 ? map0 : null));
    }

    public static b a(b b0, c c0, long v, co.ab180.airbridge.internal.network.model.b b1, String s, String s1, String s2, GoalData goalData0, boolean z, Map map0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            c0 = b0.a;
        }
        if((v1 & 2) != 0) {
            v = b0.b;
        }
        if((v1 & 4) != 0) {
            b1 = b0.c;
        }
        if((v1 & 8) != 0) {
            s = b0.d;
        }
        if((v1 & 16) != 0) {
            s1 = b0.e;
        }
        if((v1 & 0x20) != 0) {
            s2 = b0.f;
        }
        if((v1 & 0x40) != 0) {
            goalData0 = b0.g;
        }
        if((v1 & 0x80) != 0) {
            z = b0.h;
        }
        if((v1 & 0x100) != 0) {
            map0 = b0.i;
        }
        return b0.a(c0, v, b1, s, s1, s2, goalData0, z, map0);
    }

    @NotNull
    public final c a() {
        return this.a;
    }

    @NotNull
    public final b a(@NotNull c c0, long v, @NotNull co.ab180.airbridge.internal.network.model.b b0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable GoalData goalData0, boolean z, @Nullable Map map0) {
        return new b(c0, v, b0, s, s1, s2, goalData0, z, map0);
    }

    public final long b() {
        return this.b;
    }

    @NotNull
    public final co.ab180.airbridge.internal.network.model.b c() {
        return this.c;
    }

    @Nullable
    public final String d() {
        return this.d;
    }

    @Nullable
    public final String e() {
        return this.e;
    }

    // 去混淆评级： 中等(80)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof b && q.b(this.a, ((b)object0).a) && this.b == ((b)object0).b && q.b(this.c, ((b)object0).c) && q.b(this.d, ((b)object0).d) && q.b(this.e, ((b)object0).e) && q.b(this.f, ((b)object0).f) && q.b(this.g, ((b)object0).g) && this.h == ((b)object0).h && q.b(this.i, ((b)object0).i);
    }

    @Nullable
    public final String f() {
        return this.f;
    }

    @Nullable
    public final GoalData g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.c((this.a == null ? 0 : this.a.hashCode()) * 0x1F, 0x1F, this.b);
        int v2 = this.c == null ? 0 : this.c.hashCode();
        int v3 = this.d == null ? 0 : this.d.hashCode();
        int v4 = this.e == null ? 0 : this.e.hashCode();
        int v5 = this.f == null ? 0 : this.f.hashCode();
        int v6 = this.g == null ? 0 : this.g.hashCode();
        int v7 = this.h;
        if(v7) {
            v7 = 1;
        }
        Map map0 = this.i;
        if(map0 != null) {
            v = map0.hashCode();
        }
        return ((((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v;
    }

    @Nullable
    public final Map i() {
        return this.i;
    }

    public final boolean j() {
        return this.h;
    }

    public final long k() {
        return this.b;
    }

    @Nullable
    public final String l() {
        return this.d;
    }

    @NotNull
    public final c m() {
        return this.a;
    }

    @Nullable
    public final GoalData n() {
        return this.g;
    }

    @Nullable
    public final String o() {
        return this.f;
    }

    @Nullable
    public final String p() {
        return this.e;
    }

    @Nullable
    public final Map q() {
        return this.i;
    }

    @NotNull
    public final co.ab180.airbridge.internal.network.model.b r() {
        return this.c;
    }

    @Override
    @NotNull
    public String toString() {
        return "EventSeed(eventType=" + this.a + ", createdTimeMillis=" + this.b + ", triggerType=" + this.c + ", deeplink=" + this.d + ", referrer=" + this.e + ", pushToken=" + this.f + ", goalData=" + this.g + ", chkInstallReferrer=" + this.h + ", sdkAttributes=" + this.i + ")";
    }
}

