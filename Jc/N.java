package jc;

import java.util.ArrayList;
import je.w;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

public final class n {
    public static final MutableStateFlow a;
    public static final StateFlow b;

    static {
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(new m(w.a, false));
        n.a = mutableStateFlow0;
        n.b = FlowKt.asStateFlow(mutableStateFlow0);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new l(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public static void a(int v, String s, ArrayList arrayList0) {
        if((v & 1) != 0) {
            arrayList0 = ((m)n.b.getValue()).a;
        }
        if((v & 2) != 0) {
            s = "";
            q.f("", "getMemberKey(...)");
        }
        do {
            Object object0 = n.a.getValue();
            boolean z = arrayList0.contains(s);
            ((m)object0).getClass();
            m m0 = new m(arrayList0, z);
        }
        while(!n.a.compareAndSet(object0, m0));
    }
}

