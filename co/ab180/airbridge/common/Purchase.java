package co.ab180.airbridge.common;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001E\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001A\u0004\b\u001A\u0010\u0004R\'\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\b¨\u0006 "}, d2 = {"Lco/ab180/airbridge/common/Purchase;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "originalJson", "signature", "info", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lco/ab180/airbridge/common/Purchase;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "getSignature", "a", "getOriginalJson", "c", "Ljava/util/Map;", "getInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class Purchase {
    @NotNull
    private final String a;
    @NotNull
    private final String b;
    @NotNull
    private final Map c;

    public Purchase(@NotNull String s, @NotNull String s1, @NotNull Map map0) {
        this.a = s;
        this.b = s1;
        this.c = map0;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final Map component3() {
        return this.c;
    }

    @NotNull
    public final Purchase copy(@NotNull String s, @NotNull String s1, @NotNull Map map0) {
        return new Purchase(s, s1, map0);
    }

    public static Purchase copy$default(Purchase purchase0, String s, String s1, Map map0, int v, Object object0) {
        if((v & 1) != 0) {
            s = purchase0.a;
        }
        if((v & 2) != 0) {
            s1 = purchase0.b;
        }
        if((v & 4) != 0) {
            map0 = purchase0.c;
        }
        return purchase0.copy(s, s1, map0);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof Purchase && q.b(this.a, ((Purchase)object0).a) && q.b(this.b, ((Purchase)object0).b) && q.b(this.c, ((Purchase)object0).c);
    }

    @NotNull
    public final Map getInfo() {
        return this.c;
    }

    @NotNull
    public final String getOriginalJson() {
        return this.a;
    }

    @NotNull
    public final String getSignature() {
        return this.b;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        Map map0 = this.c;
        if(map0 != null) {
            v = map0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "Purchase(originalJson=" + this.a + ", signature=" + this.b + ", info=" + this.c + ")";
    }
}

