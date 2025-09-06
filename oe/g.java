package oe;

import kotlin.coroutines.Continuation;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;

public abstract class g extends a {
    public g(Continuation continuation0) {
        super(continuation0);
        if(continuation0 != null && continuation0.getContext() != j.a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override  // kotlin.coroutines.Continuation
    @NotNull
    public i getContext() {
        return j.a;
    }
}

