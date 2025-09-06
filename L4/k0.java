package l4;

import df.B;
import java.util.List;
import java.util.Objects;

public final class k0 {
    public final List a;
    public final boolean b;

    public k0(B b0) {
        this.a = b0.b;
        this.b = b0.c;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k0 && this.a.equals(((k0)object0).a) && this.b == ((k0)object0).b;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, Boolean.valueOf(this.b), 0});
    }
}

