package kotlinx.coroutines;

import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;
import we.n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\r\u001A\u00020\f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\"\u0010\t\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\n\u001A\u00028\u00002\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0087\u0002¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u000F8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0010\u0010\u0011j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "<init>", "(Ljava/lang/String;I)V", "R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "receiver", "completion", "Lie/H;", "invoke", "(Lwe/n;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public enum CoroutineStart {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[CoroutineStart.values().length];
            try {
                arr_v[CoroutineStart.DEFAULT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[CoroutineStart.ATOMIC.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[CoroutineStart.LAZY.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    private static final a $ENTRIES;
    private static final CoroutineStart[] $VALUES;

    private static final CoroutineStart[] $values() [...] // Inlined contents

    static {
        CoroutineStart.$VALUES = arr_coroutineStart;
        q.g(arr_coroutineStart, "entries");
        CoroutineStart.$ENTRIES = new b(arr_coroutineStart);
    }

    public final void invoke(@NotNull n n0, Object object0, @NotNull Continuation continuation0) {
        switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                CancellableKt.startCoroutineCancellable(n0, object0, continuation0);
                return;
            }
            case 2: {
                q.g(n0, "<this>");
                q.g(continuation0, "completion");
                u.D(u.q(n0, object0, continuation0)).resumeWith(H.a);
                return;
            }
            case 3: {
                UndispatchedKt.startCoroutineUndispatched(n0, object0, continuation0);
                return;
            }
            case 4: {
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public final boolean isLazy() [...] // 潜在的解密器
}

