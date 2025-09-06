package Cb;

import T2.a;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import we.n;
import we.o;
import we.p;

public abstract class h {
    public static final StateFlow a(StateFlow stateFlow0, StateFlow stateFlow1, StateFlow stateFlow2, a a0, SharingStarted sharingStarted0, o o0) {
        q.g(stateFlow0, "flow1");
        q.g(stateFlow1, "flow2");
        q.g(stateFlow2, "flow3");
        q.g(sharingStarted0, "sharingStarted");
        return FlowKt.stateIn(FlowKt.combine(stateFlow0, stateFlow1, stateFlow2, new b(o0, null)), a0, sharingStarted0, o0.invoke(stateFlow0.getValue(), stateFlow1.getValue(), stateFlow2.getValue()));
    }

    public static StateFlow b(StateFlow stateFlow0, StateFlow stateFlow1, CoroutineScope coroutineScope0, n n0) {
        SharingStarted sharingStarted0 = SharingStarted.Companion.getEagerly();
        q.g(stateFlow0, "flow1");
        q.g(stateFlow1, "flow2");
        q.g(coroutineScope0, "scope");
        q.g(sharingStarted0, "sharingStarted");
        return FlowKt.stateIn(FlowKt.combine(stateFlow0, stateFlow1, new Cb.a(n0, null, 0)), coroutineScope0, sharingStarted0, n0.invoke(stateFlow0.getValue(), stateFlow1.getValue()));
    }

    public static StateFlow c(StateFlow stateFlow0, StateFlow stateFlow1, MutableStateFlow mutableStateFlow0, MutableStateFlow mutableStateFlow1, a a0, p p0) {
        SharingStarted sharingStarted0 = SharingStarted.Companion.getEagerly();
        q.g(stateFlow0, "flow1");
        q.g(stateFlow1, "flow2");
        q.g(mutableStateFlow0, "flow3");
        q.g(mutableStateFlow1, "flow4");
        q.g(sharingStarted0, "sharingStarted");
        return FlowKt.stateIn(FlowKt.combine(stateFlow0, stateFlow1, mutableStateFlow0, mutableStateFlow1, new c(null, p0)), a0, sharingStarted0, p0.invoke(stateFlow0.getValue(), stateFlow1.getValue(), mutableStateFlow0.getValue(), mutableStateFlow1.getValue()));
    }

    public static StateFlow d(StateFlow stateFlow0, StateFlow stateFlow1, StateFlow stateFlow2, a a0, o o0) {
        return h.a(stateFlow0, stateFlow1, stateFlow2, a0, SharingStarted.Companion.getEagerly(), o0);
    }

    public static StateFlow e(StateFlow stateFlow0, StateFlow stateFlow1, StateFlow stateFlow2, StateFlow stateFlow3, StateFlow stateFlow4, a a0, we.q q0) {
        SharingStarted sharingStarted0 = SharingStarted.Companion.getEagerly();
        q.g(stateFlow0, "flow1");
        q.g(stateFlow1, "flow2");
        q.g(stateFlow2, "flow3");
        q.g(stateFlow3, "flow4");
        q.g(stateFlow4, "flow5");
        q.g(sharingStarted0, "sharingStarted");
        return FlowKt.stateIn(FlowKt.combine(stateFlow0, stateFlow1, stateFlow2, stateFlow3, stateFlow4, new d(null, q0)), a0, sharingStarted0, q0.invoke(stateFlow0.getValue(), stateFlow1.getValue(), stateFlow2.getValue(), stateFlow3.getValue(), stateFlow4.getValue()));
    }

    public static final Exception f(Throwable throwable0) {
        q.g(throwable0, "<this>");
        return throwable0 instanceof Exception ? ((Exception)throwable0) : new Exception(throwable0.getMessage());
    }
}

