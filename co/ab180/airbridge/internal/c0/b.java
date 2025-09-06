package co.ab180.airbridge.internal.c0;

import A7.d;
import co.ab180.airbridge.internal.network.body.LogData;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0080\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u0003\u001A\u00020\u00002\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b\u0003\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\f\u001A\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007R\u0019\u0010\u000B\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001A\u0004\b\u0018\u0010\u0004R\u0019\u0010\r\u001A\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001A\u0004\b\u001A\u0010\n¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/c0/b;", "", "", "a", "()Ljava/lang/String;", "", "b", "()I", "Lco/ab180/airbridge/internal/network/body/LogData;", "c", "()Lco/ab180/airbridge/internal/network/body/LogData;", "uuid", "priority", "log", "(Ljava/lang/String;ILco/ab180/airbridge/internal/network/body/LogData;)Lco/ab180/airbridge/internal/c0/b;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "e", "Ljava/lang/String;", "f", "Lco/ab180/airbridge/internal/network/body/LogData;", "d", "<init>", "(Ljava/lang/String;ILco/ab180/airbridge/internal/network/body/LogData;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @NotNull
    private final String a;
    private final int b;
    @NotNull
    private final LogData c;

    public b(@NotNull String s, int v, @NotNull LogData logData0) {
        this.a = s;
        this.b = v;
        this.c = logData0;
    }

    public static b a(b b0, String s, int v, LogData logData0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = b0.a;
        }
        if((v1 & 2) != 0) {
            v = b0.b;
        }
        if((v1 & 4) != 0) {
            logData0 = b0.c;
        }
        return b0.a(s, v, logData0);
    }

    @NotNull
    public final b a(@NotNull String s, int v, @NotNull LogData logData0) {
        return new b(s, v, logData0);
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @NotNull
    public final LogData c() {
        return this.c;
    }

    @NotNull
    public final LogData d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof b && q.b(this.a, ((b)object0).a) && this.b == ((b)object0).b && q.b(this.c, ((b)object0).c);
    }

    @NotNull
    public final String f() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.b(this.b, (this.a == null ? 0 : this.a.hashCode()) * 0x1F, 0x1F);
        LogData logData0 = this.c;
        if(logData0 != null) {
            v = logData0.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "LogEntityModel(uuid=" + this.a + ", priority=" + this.b + ", log=" + this.c + ")";
    }
}

