package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001B\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0001H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\u00038&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/sync/Mutex;", "", "owner", "", "tryLock", "(Ljava/lang/Object;)Z", "Lie/H;", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Mutex {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static Object lock$default(Mutex mutex0, Object object0, Continuation continuation0, int v, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if((v & 1) != 0) {
                object0 = null;
            }
            return mutex0.lock(object0, continuation0);
        }

        public static boolean tryLock$default(Mutex mutex0, Object object0, int v, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if((v & 1) != 0) {
                object0 = null;
            }
            return mutex0.tryLock(object0);
        }

        public static void unlock$default(Mutex mutex0, Object object0, int v, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if((v & 1) != 0) {
                object0 = null;
            }
            mutex0.unlock(object0);
        }
    }

    boolean isLocked();

    @Nullable
    Object lock(@Nullable Object arg1, @NotNull Continuation arg2);

    boolean tryLock(@Nullable Object arg1);

    void unlock(@Nullable Object arg1);
}

