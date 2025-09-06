package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public abstract class r implements Serializable, l {
    private final int arity;

    public r(int v) {
        this.arity = v;
    }

    @Override  // kotlin.jvm.internal.l
    public int getArity() {
        return this.arity;
    }

    @Override
    @NotNull
    public String toString() {
        String s = I.a.j(this);
        q.f(s, "renderLambdaToString(...)");
        return s;
    }
}

