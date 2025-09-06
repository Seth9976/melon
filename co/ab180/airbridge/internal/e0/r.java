package co.ab180.airbridge.internal.e0;

import java.math.BigDecimal;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\u001A\u001B\u0010\u0002\u001A\n \u0001*\u0004\u0018\u00010\u00000\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0002\u001A\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljava/math/BigDecimal;", "kotlin.jvm.PlatformType", "b", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "", "(D)D", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class r {
    public static final double a(double f) {
        return r.b(f);
    }

    public static final BigDecimal a(BigDecimal bigDecimal0) {
        return r.b(bigDecimal0);
    }

    private static final double b(double f) {
        if(f == Infinity) {
            return 1.797693E+308;
        }
        return f == -Infinity ? 4.900000E-324 : f;
    }

    private static final BigDecimal b(BigDecimal bigDecimal0) {
        BigDecimal bigDecimal1 = BigDecimal.ZERO;
        return bigDecimal0.compareTo(bigDecimal1) >= 0 ? bigDecimal0 : bigDecimal1;
    }
}

