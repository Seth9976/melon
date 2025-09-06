package oe;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public abstract class i extends c implements l {
    private final int arity;

    public i(int v, Continuation continuation0) {
        super(continuation0);
        this.arity = v;
    }

    @Override  // kotlin.jvm.internal.l
    public int getArity() {
        return this.arity;
    }

    @Override  // oe.a
    @NotNull
    public String toString() {
        if(this.getCompletion() == null) {
            String s = I.a.i(this);
            q.f(s, "renderLambdaToString(...)");
            return s;
        }
        return super.toString();
    }
}

