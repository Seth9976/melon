package kotlinx.coroutines;

import df.v;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 !2\u00020\u0001:\u0001!J\u0013\u0010\u0004\u001A\u00060\u0002j\u0002`\u0003H\'¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\n2\u0010\b\u0002\u0010\t\u001A\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\rH\'¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\nH¦@¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001A\u00020\u00182\u0018\u0010\u0017\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u0014j\u0002`\u0016H&¢\u0006\u0004\b\u0019\u0010\u001AJ=\u0010\u0019\u001A\u00020\u00182\b\b\u0002\u0010\u001B\u001A\u00020\u00062\b\b\u0002\u0010\u001C\u001A\u00020\u00062\u0018\u0010\u0017\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\n0\u0014j\u0002`\u0016H\'¢\u0006\u0004\b\u0019\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00068&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\bR\u0014\u0010\u001F\u001A\u00020\u00068&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\bR\u0014\u0010 \u001A\u00020\u00068&X¦\u0004¢\u0006\u0006\u001A\u0004\b \u0010\b¨\u0006\""}, d2 = {"Lkotlinx/coroutines/Job;", "Lme/g;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "start", "()Z", "cause", "Lie/H;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lwe/k;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLwe/k;)Lkotlinx/coroutines/DisposableHandle;", "isActive", "isCompleted", "isCancelled", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Job extends g {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static void cancel$default(Job job0, CancellationException cancellationException0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if((v & 1) != 0) {
                cancellationException0 = null;
            }
            job0.cancel(cancellationException0);
        }

        public static Object fold(@NotNull Job job0, Object object0, @NotNull n n0) {
            return v.v(job0, object0, n0);
        }

        @Nullable
        public static g get(@NotNull Job job0, @NotNull h h0) {
            return v.w(job0, h0);
        }

        public static DisposableHandle invokeOnCompletion$default(Job job0, boolean z, boolean z1, k k0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if((v & 1) != 0) {
                z = false;
            }
            if((v & 2) != 0) {
                z1 = true;
            }
            return job0.invokeOnCompletion(z, z1, k0);
        }

        @NotNull
        public static i minusKey(@NotNull Job job0, @NotNull h h0) {
            return v.E(job0, h0);
        }

        @NotNull
        public static i plus(@NotNull Job job0, @NotNull i i0) {
            return v.F(i0, job0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/Job$Key;", "Lme/h;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Key implements h {
        static final Key $$INSTANCE;

        static {
            Key.$$INSTANCE = new Key();
        }
    }

    @NotNull
    public static final Key Key;

    static {
        Job.Key = Key.$$INSTANCE;
    }

    @NotNull
    ChildHandle attachChild(@NotNull ChildJob arg1);

    void cancel(@Nullable CancellationException arg1);

    @NotNull
    CancellationException getCancellationException();

    @NotNull
    DisposableHandle invokeOnCompletion(@NotNull k arg1);

    @NotNull
    DisposableHandle invokeOnCompletion(boolean arg1, boolean arg2, @NotNull k arg3);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @Nullable
    Object join(@NotNull Continuation arg1);

    boolean start();
}

