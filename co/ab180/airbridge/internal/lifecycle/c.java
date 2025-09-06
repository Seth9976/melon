package co.ab180.airbridge.internal.lifecycle;

import U4.x;
import android.content.Intent;
import android.net.Uri;
import co.ab180.airbridge.internal.e0.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001A\u00020\u0002\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001A\u00020\n\u00A2\u0006\u0004\b#\u0010$B)\b\u0016\u0012\u0006\u0010\r\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b#\u0010%B/\b\u0016\u0012\u0006\u0010\r\u001A\u00020\u0002\u0012\b\u0010\'\u001A\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001A\u00020\u0018\u0012\b\b\u0002\u0010\u0011\u001A\u00020\n\u00A2\u0006\u0004\b#\u0010)J\u0010\u0010\u0003\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u000B\u0010\fJH\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\r\u001A\u00020\u00022\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001A\u00020\nH\u00C6\u0001\u00A2\u0006\u0004\b\u0003\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0015\u001A\u00020\u0014H\u00D6\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001A\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AR\u001B\u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006\u00A2\u0006\f\n\u0004\b\t\u0010\u001B\u001A\u0004\b\u001C\u0010\u0007R\u001B\u0010\u000F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\u001B\u001A\u0004\b\u001D\u0010\u0007R\u0019\u0010\r\u001A\u00020\u00028\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001E\u001A\u0004\b\u001F\u0010\u0004R\u0019\u0010\u0011\u001A\u00020\n8\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010 \u001A\u0004\b!\u0010\fR\u001B\u0010\u000E\u001A\u0004\u0018\u00010\u00058\u0006@\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\u001B\u001A\u0004\b\"\u0010\u0007\u00A8\u0006*"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/c;", "", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "a", "()Lco/ab180/airbridge/internal/lifecycle/b$b;", "", "b", "()Ljava/lang/String;", "c", "d", "", "e", "()J", "type", "action", "dataString", "referrer", "timeInMillis", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lco/ab180/airbridge/internal/lifecycle/c;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "h", "g", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "j", "J", "i", "f", "<init>", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "intent", "checkReferrer", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Landroid/content/Intent;ZJ)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c {
    @NotNull
    private final b a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private final String d;
    private final long e;

    public c(@NotNull b b$b0, @Nullable Intent intent0, boolean z, long v) {
        String s = null;
        String s1 = intent0 == null ? null : intent0.getAction();
        String s2 = intent0 != null && l.e(intent0) || intent0 == null ? null : intent0.getDataString();
        if(z && intent0 != null) {
            Uri uri0 = l.c(intent0);
            if(uri0 != null) {
                s = uri0.getAuthority();
            }
        }
        this(b$b0, s1, s2, s, v);
    }

    public c(b b$b0, Intent intent0, boolean z, long v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            z = false;
        }
        if((v1 & 8) != 0) {
            v = System.currentTimeMillis();
        }
        this(b$b0, intent0, z, v);
    }

    public c(@NotNull b b$b0, @Nullable String s, @Nullable String s1) {
        this(b$b0, s, s1, null, System.currentTimeMillis());
    }

    public c(b b$b0, String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s = null;
        }
        if((v & 4) != 0) {
            s1 = null;
        }
        this(b$b0, s, s1);
    }

    public c(@NotNull b b$b0, @Nullable String s, @Nullable String s1, @Nullable String s2, long v) {
        this.a = b$b0;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = v;
    }

    public static c a(c c0, b b$b0, String s, String s1, String s2, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            b$b0 = c0.a;
        }
        if((v1 & 2) != 0) {
            s = c0.b;
        }
        if((v1 & 4) != 0) {
            s1 = c0.c;
        }
        if((v1 & 8) != 0) {
            s2 = c0.d;
        }
        if((v1 & 16) != 0) {
            v = c0.e;
        }
        return c0.a(b$b0, s, s1, s2, v);
    }

    @NotNull
    public final b a() {
        return this.a;
    }

    @NotNull
    public final c a(@NotNull b b$b0, @Nullable String s, @Nullable String s1, @Nullable String s2, long v) {
        return new c(b$b0, s, s1, s2, v);
    }

    @Nullable
    public final String b() {
        return this.b;
    }

    @Nullable
    public final String c() {
        return this.c;
    }

    @Nullable
    public final String d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof c && q.b(this.a, ((c)object0).a) && q.b(this.b, ((c)object0).b) && q.b(this.c, ((c)object0).c) && q.b(this.d, ((c)object0).d) && this.e == ((c)object0).e;
    }

    @Nullable
    public final String f() {
        return this.b;
    }

    @Nullable
    public final String g() {
        return this.c;
    }

    @Nullable
    public final String h() {
        return this.d;
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
        return Long.hashCode(this.e) + (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v) * 0x1F;
    }

    public final long i() {
        return this.e;
    }

    @NotNull
    public final b j() {
        return this.a;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LifecycleContext(type=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", action=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", dataString=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", referrer=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", timeInMillis=");
        return x.h(this.e, ")", stringBuilder0);
    }
}

