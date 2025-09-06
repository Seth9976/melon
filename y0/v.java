package y0;

import java.util.function.DoubleUnaryOperator;
import we.k;

public final class v implements DoubleUnaryOperator {
    public final int a;
    public final k b;

    public v(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override
    public final double applyAsDouble(double f) {
        return ((Number)this.b.invoke(f)).doubleValue();
    }
}

