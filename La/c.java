package La;

import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

public abstract class c {
    public static final MutableStateFlow a;
    public static final MutableStateFlow b;
    public static final MutableStateFlow c;
    public static final MutableStateFlow d;

    static {
        c.a = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        c.b = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        c.c = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        c.d = StateFlowKt.MutableStateFlow(Boolean.FALSE);
    }
}

