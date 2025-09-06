package kotlinx.coroutines.selects;

import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import me.i;
import org.jetbrains.annotations.NotNull;
import we.o;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001A\u00020\t2\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0017\u0010\u0012\u001A\u00020\r8F¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/selects/OnTimeout;", "", "", "timeMillis", "<init>", "(J)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "ignoredParam", "Lie/H;", "register", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "J", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "selectClause", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long v) {
        this.timeMillis = v;
    }

    @NotNull
    public final SelectClause0 getSelectClause() {
        q.e(kotlinx.coroutines.selects.OnTimeout.selectClause.1.INSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        N.e(3, kotlinx.coroutines.selects.OnTimeout.selectClause.1.INSTANCE);
        return new SelectClause0Impl(this, kotlinx.coroutines.selects.OnTimeout.selectClause.1.INSTANCE, null, 4, null);

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.selects.OnTimeout.selectClause.1 extends n implements o {
            public static final kotlinx.coroutines.selects.OnTimeout.selectClause.1 INSTANCE;

            static {
                kotlinx.coroutines.selects.OnTimeout.selectClause.1.INSTANCE = new kotlinx.coroutines.selects.OnTimeout.selectClause.1();
            }

            public kotlinx.coroutines.selects.OnTimeout.selectClause.1() {
                super(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                this.invoke(((OnTimeout)object0), ((SelectInstance)object1), object2);
                return H.a;
            }

            public final void invoke(OnTimeout onTimeout0, SelectInstance selectInstance0, Object object0) {
                onTimeout0.register(selectInstance0, object0);
            }
        }

    }

    private final void register(SelectInstance selectInstance0, Object object0) {
        if(this.timeMillis <= 0L) {
            selectInstance0.selectInRegistrationPhase(H.a);
            return;
        }
        a a0 = new a(selectInstance0, this);
        q.e(selectInstance0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        i i0 = ((SelectImplementation)selectInstance0).getContext();
        ((SelectImplementation)selectInstance0).disposeOnCompletion(DelayKt.getDelay(i0).invokeOnTimeout(this.timeMillis, a0, i0));
    }

    private static final void register$lambda$0(SelectInstance selectInstance0, OnTimeout onTimeout0) {
        selectInstance0.trySelect(onTimeout0, H.a);
    }
}

