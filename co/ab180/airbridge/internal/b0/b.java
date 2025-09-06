package co.ab180.airbridge.internal.b0;

import A7.d;
import U4.x;
import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0002\t\u0018J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u000F\u0010\n\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000F\u0010\u000B\u001A\u00020\u0002H&¢\u0006\u0004\b\u000B\u0010\u0004J\u000F\u0010\f\u001A\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000F\u0010\r\u001A\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000F\u0010\u000F\u001A\u00020\u000EH&¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000F\u0010\u0012\u001A\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u000F\u0010\u0013\u001A\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0004J\u000F\u0010\u0014\u001A\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000F\u0010\u0015\u001A\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0004J\u000F\u0010\u0016\u001A\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u000F\u0010\u0018\u001A\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001B\u001A\u0004\u0018\u00010\u001AH&¢\u0006\u0004\b\u001B\u0010\u001CJ\u0011\u0010\u001E\u001A\u0004\u0018\u00010\u001DH&¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u000F\u0010!\u001A\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000F\u0010\"\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004¨\u0006#"}, d2 = {"Lco/ab180/airbridge/internal/b0/b;", "", "", "a", "()Ljava/lang/String;", "h", "", "t", "()J", "b", "f", "q", "i", "k", "Lco/ab180/airbridge/internal/b0/b$c;", "m", "()Lco/ab180/airbridge/internal/b0/b$c;", "p", "r", "u", "n", "s", "o", "Lco/ab180/airbridge/internal/network/model/a;", "c", "()Lco/ab180/airbridge/internal/network/model/a;", "", "l", "()Ljava/lang/Boolean;", "Lco/ab180/airbridge/internal/b0/b$b;", "g", "()Lco/ab180/airbridge/internal/b0/b$b;", "e", "d", "j", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface b {
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    public static final class a {
        @NotNull
        public static String a(@NotNull b b0) {
            String s = b0.o();
            return s.length() != 0 && s.length() >= 5 ? s.substring(0, 3) : "";
        }

        @NotNull
        public static String b(@NotNull b b0) {
            String s = b0.o();
            return s.length() != 0 && s.length() >= 5 ? s.substring(3) : "";
        }

        @NotNull
        public static String c(@NotNull b b0) {
            c b$c0 = b0.m();
            return "Airbridge_Android_SDK/4.7.0 (" + ("Android " + Build.VERSION.RELEASE + "; ") + (b0.r() + "; ") + ("locale " + b0.f() + "; ") + ("timezone " + b0.k() + "; ") + ("width " + b$c0.h() + "; ") + ("height " + b$c0.f() + "; ") + b0.a() + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\n\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0002\u0012\b\b\u0002\u0010\f\u001A\u00020\u0002\u0012\b\b\u0002\u0010\r\u001A\u00020\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u0003\u001A\u00020\u000E2\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00022\b\b\u0002\u0010\r\u001A\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0003\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0018\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001A\u001A\u0004\b\u001B\u0010\u0004R\u0019\u0010\f\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001A\u001A\u0004\b\u001C\u0010\u0004R\u0019\u0010\u000B\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001A\u001A\u0004\b\u001D\u0010\u0004R\u0019\u0010\r\u001A\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001E\u001A\u0004\b\u001F\u0010\t¨\u0006\""}, d2 = {"co/ab180/airbridge/internal/b0/b$b", "", "", "a", "()D", "b", "c", "", "d", "()F", "latitude", "longitude", "altitude", "speed", "Lco/ab180/airbridge/internal/b0/b$b;", "(DDDF)Lco/ab180/airbridge/internal/b0/b$b;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", "f", "e", "g", "F", "h", "<init>", "(DDDF)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.b0.b.b {
        private final double a;
        private final double b;
        private final double c;
        private final float d;

        public co.ab180.airbridge.internal.b0.b.b() {
            this(0.0, 0.0, 0.0, 0.0f, 15, null);
        }

        public co.ab180.airbridge.internal.b0.b.b(double f, double f1, double f2, float f3) {
            this.a = f;
            this.b = f1;
            this.c = f2;
            this.d = f3;
        }

        public co.ab180.airbridge.internal.b0.b.b(double f, double f1, double f2, float f3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                f = 0.0;
            }
            if((v & 2) != 0) {
                f1 = 0.0;
            }
            if((v & 4) != 0) {
                f2 = 0.0;
            }
            if((v & 8) != 0) {
                f3 = 0.0f;
            }
            this(f, f1, f2, f3);
        }

        public static co.ab180.airbridge.internal.b0.b.b a(co.ab180.airbridge.internal.b0.b.b b$b0, double f, double f1, double f2, float f3, int v, Object object0) {
            if((v & 1) != 0) {
                f = b$b0.a;
            }
            if((v & 2) != 0) {
                f1 = b$b0.b;
            }
            if((v & 4) != 0) {
                f2 = b$b0.c;
            }
            if((v & 8) != 0) {
                f3 = b$b0.d;
            }
            return b$b0.a(f, f1, f2, f3);
        }

        public final double a() {
            return this.a;
        }

        @NotNull
        public final co.ab180.airbridge.internal.b0.b.b a(double f, double f1, double f2, float f3) {
            return new co.ab180.airbridge.internal.b0.b.b(f, f1, f2, f3);
        }

        public final double b() {
            return this.b;
        }

        public final double c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public final double e() {
            return this.c;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 || object0 instanceof co.ab180.airbridge.internal.b0.b.b && Double.compare(this.a, ((co.ab180.airbridge.internal.b0.b.b)object0).a) == 0 && Double.compare(this.b, ((co.ab180.airbridge.internal.b0.b.b)object0).b) == 0 && Double.compare(this.c, ((co.ab180.airbridge.internal.b0.b.b)object0).c) == 0 && Float.compare(this.d, ((co.ab180.airbridge.internal.b0.b.b)object0).d) == 0;
        }

        public final double f() {
            return this.a;
        }

        public final double g() {
            return this.b;
        }

        public final float h() {
            return this.d;
        }

        @Override
        public int hashCode() {
            return Float.hashCode(this.d) + (Double.hashCode(this.c) + (Double.hashCode(this.b) + Double.hashCode(this.a) * 0x1F) * 0x1F) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "LocationInfo(latitude=" + this.a + ", longitude=" + this.b + ", altitude=" + this.c + ", speed=" + this.d + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\u0006\u0010\u000B\u001A\u00020\u0002¢\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\u0003\u001A\u00020\f2\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0003\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001A\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000B\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001A\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001A\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001A\u0004\b\u001A\u0010\u0004¨\u0006\u001D"}, d2 = {"co/ab180/airbridge/internal/b0/b$c", "", "", "a", "()I", "b", "c", "d", "width", "height", "density", "orientation", "Lco/ab180/airbridge/internal/b0/b$c;", "(IIII)Lco/ab180/airbridge/internal/b0/b$c;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "f", "g", "h", "e", "<init>", "(IIII)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {
        private final int a;
        private final int b;
        private final int c;
        private final int d;

        public c(int v, int v1, int v2, int v3) {
            this.a = v;
            this.b = v1;
            this.c = v2;
            this.d = v3;
        }

        public static c a(c b$c0, int v, int v1, int v2, int v3, int v4, Object object0) {
            if((v4 & 1) != 0) {
                v = b$c0.a;
            }
            if((v4 & 2) != 0) {
                v1 = b$c0.b;
            }
            if((v4 & 4) != 0) {
                v2 = b$c0.c;
            }
            if((v4 & 8) != 0) {
                v3 = b$c0.d;
            }
            return b$c0.a(v, v1, v2, v3);
        }

        public final int a() {
            return this.a;
        }

        @NotNull
        public final c a(int v, int v1, int v2, int v3) {
            return new c(v, v1, v2, v3);
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.c;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 || object0 instanceof c && this.a == ((c)object0).a && this.b == ((c)object0).b && this.c == ((c)object0).c && this.d == ((c)object0).d;
        }

        public final int f() {
            return this.b;
        }

        public final int g() {
            return this.d;
        }

        public final int h() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.d + d.b(this.c, d.b(this.b, this.a * 0x1F, 0x1F), 0x1F);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("ScreenInfo(width=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", height=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", density=");
            stringBuilder0.append(this.c);
            stringBuilder0.append(", orientation=");
            return x.g(this.d, ")", stringBuilder0);
        }
    }

    @NotNull
    String a();

    long b();

    @NotNull
    co.ab180.airbridge.internal.network.model.a c();

    @NotNull
    String d();

    @NotNull
    String e();

    @NotNull
    String f();

    @Nullable
    co.ab180.airbridge.internal.b0.b.b g();

    @NotNull
    String h();

    @NotNull
    String i();

    @NotNull
    String j();

    @NotNull
    String k();

    @Nullable
    Boolean l();

    @NotNull
    c m();

    @NotNull
    String n();

    @NotNull
    String o();

    @NotNull
    String p();

    @NotNull
    String q();

    @NotNull
    String r();

    @NotNull
    String s();

    long t();

    @NotNull
    String u();
}

