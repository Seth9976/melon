package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.flow.FlowCollector;
import we.o;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
final class SafeCollectorKt.emitFun.1 extends n implements o {
    public static final SafeCollectorKt.emitFun.1 INSTANCE;

    static {
        SafeCollectorKt.emitFun.1.INSTANCE = new SafeCollectorKt.emitFun.1();
    }

    public SafeCollectorKt.emitFun.1() {
        super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override  // we.o
    public Object invoke(Object object0, Object object1, Object object2) {
        return this.invoke(((FlowCollector)object0), object1, ((Continuation)object2));
    }

    public final Object invoke(FlowCollector flowCollector0, Object object0, Continuation continuation0) {
        return flowCollector0.emit(object0, continuation0);
    }
}

