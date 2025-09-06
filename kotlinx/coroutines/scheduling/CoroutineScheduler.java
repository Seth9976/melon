package kotlinx.coroutines.scheduling;

import U4.x;
import i.n.i.b.a.s.e.M3;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0003QRSB+\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ)\u0010\u0011\u001A\u00020\u00102\n\u0010\r\u001A\u00060\fR\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001A\u00020\u00132\n\u0010\r\u001A\u00060\fR\u00020\u0000\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001B\u0010\u0019\u001A\u00020\u00102\n\u0010\u0018\u001A\u00060\u0016j\u0002`\u0017H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u0006\u00A2\u0006\u0004\b\u001E\u0010\u001FJ1\u0010$\u001A\u00020\u00102\n\u0010 \u001A\u00060\u0016j\u0002`\u00172\f\b\u0002\u0010\"\u001A\u00060\u0013j\u0002`!2\b\b\u0002\u0010#\u001A\u00020\u0013\u00A2\u0006\u0004\b$\u0010%J%\u0010\'\u001A\u00020&2\n\u0010 \u001A\u00060\u0016j\u0002`\u00172\n\u0010\"\u001A\u00060\u0013j\u0002`!\u00A2\u0006\u0004\b\'\u0010(J\r\u0010)\u001A\u00020\u0010\u00A2\u0006\u0004\b)\u0010\u001CJ\u000F\u0010*\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b*\u0010+J\u0015\u0010-\u001A\u00020\u00102\u0006\u0010,\u001A\u00020&\u00A2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001A\u00020\u00132\u0006\u0010,\u001A\u00020&H\u0002\u00A2\u0006\u0004\b/\u00100J\u0015\u00101\u001A\b\u0018\u00010\fR\u00020\u0000H\u0002\u00A2\u0006\u0004\b1\u00102J\u001B\u00103\u001A\u00020\u00032\n\u0010\r\u001A\u00060\fR\u00020\u0000H\u0002\u00A2\u0006\u0004\b3\u00104J\u0017\u00106\u001A\u00020\u00102\u0006\u00105\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b6\u0010\u001FJ\u0019\u00108\u001A\u00020\u00132\b\b\u0002\u00107\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b8\u00109J\u000F\u0010:\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\b<\u0010=J+\u0010>\u001A\u0004\u0018\u00010&*\b\u0018\u00010\fR\u00020\u00002\u0006\u0010,\u001A\u00020&2\u0006\u0010#\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b>\u0010?J\u0015\u0010@\u001A\b\u0018\u00010\fR\u00020\u0000H\u0002\u00A2\u0006\u0004\b@\u00102R\u0014\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010AR\u0014\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010AR\u0014\u0010\u0007\u001A\u00020\u00068\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010BR\u0014\u0010\t\u001A\u00020\b8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010CR\u0014\u0010E\u001A\u00020D8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001A\u00020D8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010FR\u001E\u0010I\u001A\f\u0012\b\u0012\u00060\fR\u00020\u00000H8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0011\u0010K\u001A\u00020\u00138F\u00A2\u0006\u0006\u001A\u0004\bK\u0010;R\u000B\u0010M\u001A\u00020L8\u0002X\u0082\u0004R\u000B\u0010N\u001A\u00020L8\u0002X\u0082\u0004R\u000B\u0010P\u001A\u00020O8\u0002X\u0082\u0004\u00A8\u0006T"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "worker", "oldIndex", "newIndex", "Lie/H;", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "shutdown", "(J)V", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "fair", "dispatch", "(Ljava/lang/Runnable;ZZ)V", "Lkotlinx/coroutines/scheduling/Task;", "createTask", "(Ljava/lang/Runnable;Z)Lkotlinx/coroutines/scheduling/Task;", "signalCpuWork", "toString", "()Ljava/lang/String;", "task", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "parkedWorkersStackPop", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "stateSnapshot", "signalBlockingWork", "state", "tryCreateWorker", "(J)Z", "tryUnpark", "()Z", "createNewWorker", "()I", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "currentWorker", "I", "J", "Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "isTerminated", "Lkotlinx/atomicfu/AtomicLong;", "parkedWorkersStack", "controlState", "Lkotlinx/atomicfu/AtomicBoolean;", "_isTerminated", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class CoroutineScheduler implements Closeable, Executor {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "<init>", "()V", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "", "CLAIMED", "TERMINATED", "BLOCKING_SHIFT", "CREATED_MASK", "", "BLOCKING_MASK", "CPU_PERMITS_SHIFT", "CPU_PERMITS_MASK", "MIN_SUPPORTED_POOL_SIZE", "MAX_SUPPORTED_POOL_SIZE", "PARKED_INDEX_MASK", "PARKED_VERSION_MASK", "PARKED_VERSION_INC", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[WorkerState.values().length];
            try {
                arr_v[WorkerState.PARKING.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[WorkerState.BLOCKING.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[WorkerState.DORMANT.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[WorkerState.TERMINATED.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0002\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000E\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000E\u0010\tJ\u0017\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0013\u0010\fJ\u000F\u0010\u0014\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0014\u0010\fJ\u0011\u0010\u0015\u001A\u0004\u0018\u00010\u000FH\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0017\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u000FH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u0016J\u001D\u0010\u001D\u001A\u0004\u0018\u00010\u000F2\n\u0010\u001C\u001A\u00060\u0004j\u0002`\u001BH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010!\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b#\u0010\fJ\u0015\u0010%\u001A\u00020\u00042\u0006\u0010$\u001A\u00020\u0004\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\'\u001A\u00020\u0007\u00A2\u0006\u0004\b(\u0010\u0019R*\u0010)\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00048\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00100\u001A\u00020/8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b0\u00101R\u001C\u00103\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001A\u0002078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R$\u0010;\u001A\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010A\u001A\u0002078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010B\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010*R\u0016\u0010\'\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010CR\b\u0010E\u001A\u00020D8\u0006\u00A8\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "", "index", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "", "tryAcquireCpuPermit", "()Z", "Lie/H;", "runWorker", "()V", "tryPark", "inStack", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "park", "tryTerminateWorker", "findBlockingTask", "()Lkotlinx/coroutines/scheduling/Task;", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "pollGlobalQueues", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "trySteal", "(I)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "nextInt", "(I)I", "mayHaveLocalTasks", "findTask", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "Lkotlin/jvm/internal/H;", "stolenTask", "Lkotlin/jvm/internal/H;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "terminationDeadline", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public final class Worker extends Thread {
        private volatile int indexInArray;
        @NotNull
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        @Nullable
        private volatile Object nextParkedWorker;
        private int rngState;
        @NotNull
        public WorkerState state;
        @NotNull
        private final H stolenTask;
        private long terminationDeadline;
        private volatile int workerCtl$volatile;
        private static final AtomicIntegerFieldUpdater workerCtl$volatile$FU;

        static {
            Worker.workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        }

        private Worker() {
            this.setDaemon(true);
            this.setContextClassLoader(coroutineScheduler0.getClass().getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = ((int)System.nanoTime()) == 0 ? 42 : ((int)System.nanoTime());
        }

        public Worker(int v) {
            this.setIndexInArray(v);
        }

        public static final CoroutineScheduler access$getThis$0$p(Worker coroutineScheduler$Worker0) {
            return CoroutineScheduler.this;
        }

        private final void executeTask(Task task0) {
            this.terminationDeadline = 0L;
            if(this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
            if(task0.taskContext) {
                if(this.tryReleaseCpu(WorkerState.BLOCKING)) {
                    CoroutineScheduler.this.signalCpuWork();
                }
                CoroutineScheduler.this.runSafely(task0);
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, 0xFFFFFFFFFFE00000L);
                if(this.state != WorkerState.TERMINATED) {
                    this.state = WorkerState.DORMANT;
                }
                return;
            }
            CoroutineScheduler.this.runSafely(task0);
        }

        private final Task findAnyTask(boolean z) {
            if(z) {
                boolean z1 = this.nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if(z1) {
                    Task task0 = this.pollGlobalQueues();
                    if(task0 != null) {
                        return task0;
                    }
                }
                Task task1 = this.localQueue.poll();
                if(task1 != null) {
                    return task1;
                }
                if(!z1) {
                    Task task2 = this.pollGlobalQueues();
                    return task2 == null ? this.trySteal(3) : task2;
                }
                return this.trySteal(3);
            }
            Task task3 = this.pollGlobalQueues();
            return task3 == null ? this.trySteal(3) : task3;
        }

        private final Task findBlockingTask() {
            Task task0 = this.localQueue.pollBlocking();
            if(task0 == null) {
                task0 = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                return task0 == null ? this.trySteal(1) : task0;
            }
            return task0;
        }

        // 去混淆评级： 低(20)
        @Nullable
        public final Task findTask(boolean z) {
            return this.tryAcquireCpuPermit() ? this.findAnyTask(z) : this.findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        public final int nextInt(int v) {
            int v1 = this.rngState ^ this.rngState << 13;
            int v2 = v1 ^ v1 >> 17;
            int v3 = v2 ^ v2 << 5;
            this.rngState = v3;
            return (v - 1 & v) == 0 ? v3 & v - 1 : (v3 & 0x7FFFFFFF) % v;
        }

        private final void park() {
            if(this.terminationDeadline == 0L) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if(System.nanoTime() - this.terminationDeadline >= 0L) {
                this.terminationDeadline = 0L;
                this.tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if(this.nextInt(2) == 0) {
                Task task0 = (Task)CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                return task0 == null ? ((Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull()) : task0;
            }
            Task task1 = (Task)CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return task1 == null ? ((Task)CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull()) : task1;
        }

        @Override
        public void run() {
            this.runWorker();
        }

        private final void runWorker() {
        alab1:
            while(true) {
                boolean z = false;
                while(true) {
                    if(CoroutineScheduler.this.isTerminated() || this.state == WorkerState.TERMINATED) {
                        break alab1;
                    }
                    Task task0 = this.findTask(this.mayHaveLocalTasks);
                    if(task0 != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        this.executeTask(task0);
                        break;
                    }
                    this.mayHaveLocalTasks = false;
                    if(this.minDelayUntilStealableTaskNs == 0L) {
                        this.tryPark();
                    }
                    else {
                        if(z) {
                            this.tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                            break;
                        }
                        z = true;
                    }
                }
            }
            this.tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final void setIndexInArray(int v) {
            this.setName(CoroutineScheduler.this.schedulerName + "-worker-" + (v == 0 ? "TERMINATED" : String.valueOf(v)));
            this.indexInArray = v;
        }

        public final void setNextParkedWorker(@Nullable Object object0) {
            this.nextParkedWorker = object0;
        }

        private final boolean tryAcquireCpuPermit() {
            if(this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler0 = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater0 = CoroutineScheduler.controlState$volatile$FU;
            do {
                long v = atomicLongFieldUpdater0.get(coroutineScheduler0);
                if(((int)((0x7FFFFC0000000000L & v) >> 42)) == 0) {
                    return false;
                }
            }
            while(!CoroutineScheduler.controlState$volatile$FU.compareAndSet(coroutineScheduler0, v, v - 0x40000000000L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void tryPark() {
            if(!this.inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            Worker.workerCtl$volatile$FU.set(this, -1);
            while(this.inStack() && Worker.workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                this.tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                this.park();
            }
        }

        public final boolean tryReleaseCpu(@NotNull WorkerState coroutineScheduler$WorkerState0) {
            WorkerState coroutineScheduler$WorkerState1 = this.state;
            boolean z = coroutineScheduler$WorkerState1 == WorkerState.CPU_ACQUIRED;
            if(z) {
                CoroutineScheduler.controlState$volatile$FU.addAndGet(CoroutineScheduler.this, 0x40000000000L);
            }
            if(coroutineScheduler$WorkerState1 != coroutineScheduler$WorkerState0) {
                this.state = coroutineScheduler$WorkerState0;
            }
            return z;
        }

        private final Task trySteal(int v) {
            long v1 = CoroutineScheduler.controlState$volatile$FU.get(CoroutineScheduler.this);
            if(((int)(v1 & 0x1FFFFFL)) < 2) {
                return null;
            }
            int v2 = this.nextInt(((int)(v1 & 0x1FFFFFL)));
            CoroutineScheduler coroutineScheduler0 = CoroutineScheduler.this;
            long v4 = 0x7FFFFFFFFFFFFFFFL;
            for(int v3 = 0; v3 < ((int)(v1 & 0x1FFFFFL)); ++v3) {
                ++v2;
                v2 = v2 <= ((int)(v1 & 0x1FFFFFL)) ? v2 + 1 : 1;
                Worker coroutineScheduler$Worker0 = (Worker)coroutineScheduler0.workers.get(v2);
                if(coroutineScheduler$Worker0 != null && coroutineScheduler$Worker0 != this) {
                    long v5 = coroutineScheduler$Worker0.localQueue.trySteal(v, this.stolenTask);
                    if(v5 == -1L) {
                        Task task0 = (Task)this.stolenTask.a;
                        this.stolenTask.a = null;
                        return task0;
                    }
                    if(v5 > 0L) {
                        v4 = Math.min(v4, v5);
                    }
                }
            }
            if(v4 == 0x7FFFFFFFFFFFFFFFL) {
                v4 = 0L;
            }
            this.minDelayUntilStealableTaskNs = v4;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler0 = CoroutineScheduler.this;
            ResizableAtomicArray resizableAtomicArray0 = coroutineScheduler0.workers;
            __monitor_enter(resizableAtomicArray0);
            try {
                if(!coroutineScheduler0.isTerminated()) {
                    if(((int)(CoroutineScheduler.controlState$volatile$FU.get(coroutineScheduler0) & 0x1FFFFFL)) > coroutineScheduler0.corePoolSize) {
                        if(Worker.workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                            int v = this.indexInArray;
                            this.setIndexInArray(0);
                            coroutineScheduler0.parkedWorkersStackTopUpdate(this, v, 0);
                            long v1 = CoroutineScheduler.controlState$volatile$FU.getAndDecrement(coroutineScheduler0);
                            if(((int)(v1 & 0x1FFFFFL)) != v) {
                                Object object0 = coroutineScheduler0.workers.get(((int)(v1 & 0x1FFFFFL)));
                                q.d(object0);
                                coroutineScheduler0.workers.setSynchronized(v, ((Worker)object0));
                                ((Worker)object0).setIndexInArray(v);
                                coroutineScheduler0.parkedWorkersStackTopUpdate(((Worker)object0), ((int)(v1 & 0x1FFFFFL)), v);
                            }
                            coroutineScheduler0.workers.setSynchronized(((int)(v1 & 0x1FFFFFL)), null);
                            goto label_21;
                        }
                        goto label_24;
                    }
                    goto label_26;
                }
                goto label_28;
            }
            catch(Throwable throwable0) {
            }
            __monitor_exit(resizableAtomicArray0);
            throw throwable0;
        label_21:
            __monitor_exit(resizableAtomicArray0);
            this.state = WorkerState.TERMINATED;
            return;
        label_24:
            __monitor_exit(resizableAtomicArray0);
            return;
        label_26:
            __monitor_exit(resizableAtomicArray0);
            return;
        label_28:
            __monitor_exit(resizableAtomicArray0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        private static final a $ENTRIES;
        private static final WorkerState[] $VALUES;

        private static final WorkerState[] $values() [...] // Inlined contents

        static {
            WorkerState.$VALUES = arr_coroutineScheduler$WorkerState;
            q.g(arr_coroutineScheduler$WorkerState, "entries");
            WorkerState.$ENTRIES = new b(arr_coroutineScheduler$WorkerState);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final Symbol NOT_IN_STACK;
    private volatile int _isTerminated$volatile;
    private static final AtomicIntegerFieldUpdater _isTerminated$volatile$FU;
    private volatile long controlState$volatile;
    private static final AtomicLongFieldUpdater controlState$volatile$FU;
    public final int corePoolSize;
    @NotNull
    public final GlobalQueue globalBlockingQueue;
    @NotNull
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack$volatile;
    private static final AtomicLongFieldUpdater parkedWorkersStack$volatile$FU;
    @NotNull
    public final String schedulerName;
    @NotNull
    public final ResizableAtomicArray workers;

    static {
        CoroutineScheduler.Companion = new Companion(null);
        CoroutineScheduler.parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
        CoroutineScheduler.controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
        CoroutineScheduler._isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
        CoroutineScheduler.NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    }

    public CoroutineScheduler(int v, int v1, long v2, @NotNull String s) {
        this.corePoolSize = v;
        this.maxPoolSize = v1;
        this.idleWorkerKeepAliveNs = v2;
        this.schedulerName = s;
        if(v < 1) {
            throw new IllegalArgumentException(("Core pool size " + v + " should be at least 1").toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException(("Max pool size " + v1 + " should be greater than or equals to core pool size " + v).toString());
        }
        if(v1 > 0x1FFFFE) {
            throw new IllegalArgumentException(("Max pool size " + v1 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if(v2 <= 0L) {
            throw new IllegalArgumentException(H0.b.g(v2, "Idle worker keep alive time ", " must be positive").toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.workers = new ResizableAtomicArray((v + 1) * 2);
        this.controlState$volatile = ((long)v) << 42;
    }

    // 去混淆评级： 低(20)
    private final boolean addToGlobalQueue(Task task0) {
        return task0.taskContext ? this.globalBlockingQueue.addLast(task0) : this.globalCpuQueue.addLast(task0);
    }

    @Override
    public void close() {
        this.shutdown(10000L);
    }

    private final int createNewWorker() {
        Worker coroutineScheduler$Worker0;
        int v1;
        synchronized(this.workers) {
            if(!this.isTerminated()) {
                long v = CoroutineScheduler.controlState$volatile$FU.get(this);
                v1 = ((int)(v & 0x1FFFFFL)) - ((int)((v & 0x3FFFFE00000L) >> 21)) >= 0 ? ((int)(v & 0x1FFFFFL)) - ((int)((v & 0x3FFFFE00000L) >> 21)) : 0;
                if(v1 >= this.corePoolSize) {
                    return 0;
                }
                goto label_8;
            }
            return -1;
        }
        return 0;
    label_8:
        if(((int)(v & 0x1FFFFFL)) >= this.maxPoolSize) {
            return 0;
        }
        int v2 = ((int)(CoroutineScheduler.controlState$volatile$FU.get(this) & 0x1FFFFFL)) + 1;
        if(v2 <= 0 || this.workers.get(v2) != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        coroutineScheduler$Worker0 = new Worker(this, v2);
        this.workers.setSynchronized(v2, coroutineScheduler$Worker0);
        if(v2 != ((int)(0x1FFFFFL & CoroutineScheduler.controlState$volatile$FU.incrementAndGet(this)))) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        coroutineScheduler$Worker0.start();
        return v1 + 1;
    }

    @NotNull
    public final Task createTask(@NotNull Runnable runnable0, boolean z) {
        long v = TasksKt.schedulerTimeSource.nanoTime();
        if(runnable0 instanceof Task) {
            ((Task)runnable0).submissionTime = v;
            ((Task)runnable0).taskContext = z;
            return (Task)runnable0;
        }
        return TasksKt.asTask(runnable0, v, z);
    }

    private final Worker currentWorker() {
        Thread thread0 = Thread.currentThread();
        Worker coroutineScheduler$Worker0 = thread0 instanceof Worker ? ((Worker)thread0) : null;
        return coroutineScheduler$Worker0 == null || !q.b(Worker.access$getThis$0$p(coroutineScheduler$Worker0), this) ? null : coroutineScheduler$Worker0;
    }

    public final void dispatch(@NotNull Runnable runnable0, boolean z, boolean z1) {
        Task task0 = this.createTask(runnable0, z);
        boolean z2 = task0.taskContext;
        long v = z2 ? CoroutineScheduler.controlState$volatile$FU.addAndGet(this, 0x200000L) : 0L;
        Task task1 = this.submitToLocalQueue(this.currentWorker(), task0, z1);
        if(task1 != null && !this.addToGlobalQueue(task1)) {
            throw new RejectedExecutionException(x.m(new StringBuilder(), this.schedulerName, " was terminated"));
        }
        if(z2) {
            this.signalBlockingWork(v);
            return;
        }
        this.signalCpuWork();
    }

    public static void dispatch$default(CoroutineScheduler coroutineScheduler0, Runnable runnable0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        coroutineScheduler0.dispatch(runnable0, z, z1);
    }

    @Override
    public void execute(@NotNull Runnable runnable0) {
        CoroutineScheduler.dispatch$default(this, runnable0, false, false, 6, null);
    }

    public final boolean isTerminated() {
        return CoroutineScheduler._isTerminated$volatile$FU.get(this) == 1;
    }

    private final int parkedWorkersStackNextIndex(Worker coroutineScheduler$Worker0) {
        for(Object object0 = coroutineScheduler$Worker0.getNextParkedWorker(); true; object0 = ((Worker)object0).getNextParkedWorker()) {
            if(object0 == CoroutineScheduler.NOT_IN_STACK) {
                return -1;
            }
            if(object0 == null) {
                return 0;
            }
            int v = ((Worker)object0).getIndexInArray();
            if(v != 0) {
                return v;
            }
        }
    }

    private final Worker parkedWorkersStackPop() {
        Worker coroutineScheduler$Worker0;
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = CoroutineScheduler.parkedWorkersStack$volatile$FU;
        do {
            long v = atomicLongFieldUpdater0.get(this);
            coroutineScheduler$Worker0 = (Worker)this.workers.get(((int)(0x1FFFFFL & v)));
            if(coroutineScheduler$Worker0 == null) {
                return null;
            }
            int v1 = this.parkedWorkersStackNextIndex(coroutineScheduler$Worker0);
        }
        while(v1 < 0 || !CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(this, v, ((long)v1) | v + 0x200000L & 0xFFFFFFFFFFE00000L));
        coroutineScheduler$Worker0.setNextParkedWorker(CoroutineScheduler.NOT_IN_STACK);
        return coroutineScheduler$Worker0;
    }

    public final boolean parkedWorkersStackPush(@NotNull Worker coroutineScheduler$Worker0) {
        if(coroutineScheduler$Worker0.getNextParkedWorker() != CoroutineScheduler.NOT_IN_STACK) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = CoroutineScheduler.parkedWorkersStack$volatile$FU;
        do {
            long v = atomicLongFieldUpdater0.get(this);
            coroutineScheduler$Worker0.setNextParkedWorker(this.workers.get(((int)(0x1FFFFFL & v))));
        }
        while(!CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(this, v, v + 0x200000L & 0xFFFFFFFFFFE00000L | ((long)coroutineScheduler$Worker0.getIndexInArray())));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(@NotNull Worker coroutineScheduler$Worker0, int v, int v1) {
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = CoroutineScheduler.parkedWorkersStack$volatile$FU;
        do {
            long v2 = atomicLongFieldUpdater0.get(this);
            int v3 = (int)(0x1FFFFFL & v2);
            if(v3 == v) {
                v3 = v1 == 0 ? this.parkedWorkersStackNextIndex(coroutineScheduler$Worker0) : v1;
            }
        }
        while(v3 < 0 || !CoroutineScheduler.parkedWorkersStack$volatile$FU.compareAndSet(this, v2, v2 + 0x200000L & 0xFFFFFFFFFFE00000L | ((long)v3)));
    }

    public final void runSafely(@NotNull Task task0) {
        try {
            task0.run();
        }
        catch(Throwable throwable0) {
            Thread thread0 = Thread.currentThread();
            thread0.getUncaughtExceptionHandler().uncaughtException(thread0, throwable0);
        }
    }

    public final void shutdown(long v) {
        Task task1;
        if(!CoroutineScheduler._isTerminated$volatile$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker coroutineScheduler$Worker0 = this.currentWorker();
        synchronized(this.workers) {
            long v2 = CoroutineScheduler.controlState$volatile$FU.get(this);
        }
        if(1 <= ((int)(v2 & 0x1FFFFFL))) {
            for(int v3 = 1; true; ++v3) {
                Object object0 = this.workers.get(v3);
                q.d(object0);
                Worker coroutineScheduler$Worker1 = (Worker)object0;
                if(coroutineScheduler$Worker1 != coroutineScheduler$Worker0) {
                    while(coroutineScheduler$Worker1.getState() != Thread.State.TERMINATED) {
                        LockSupport.unpark(coroutineScheduler$Worker1);
                        coroutineScheduler$Worker1.join(v);
                    }
                    coroutineScheduler$Worker1.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if(v3 == ((int)(v2 & 0x1FFFFFL))) {
                    break;
                }
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while(true) {
            if(coroutineScheduler$Worker0 == null) {
                Task task2 = (Task)this.globalCpuQueue.removeFirstOrNull();
                if(task2 == null) {
                    task1 = (Task)this.globalBlockingQueue.removeFirstOrNull();
                    if(task1 != null) {
                        goto label_36;
                    }
                    break;
                }
                else {
                    task1 = task2;
                }
            }
            else {
                Task task0 = coroutineScheduler$Worker0.findTask(true);
                if(task0 != null) {
                    task1 = task0;
                }
            }
        label_36:
            this.runSafely(task1);
        }
        if(coroutineScheduler$Worker0 != null) {
            coroutineScheduler$Worker0.tryReleaseCpu(WorkerState.TERMINATED);
        }
        CoroutineScheduler.parkedWorkersStack$volatile$FU.set(this, 0L);
        CoroutineScheduler.controlState$volatile$FU.set(this, 0L);
    }

    private final void signalBlockingWork(long v) {
        if(this.tryUnpark() || this.tryCreateWorker(v)) {
            return;
        }
        this.tryUnpark();
    }

    public final void signalCpuWork() {
        if(this.tryUnpark() || CoroutineScheduler.tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        this.tryUnpark();
    }

    private final Task submitToLocalQueue(Worker coroutineScheduler$Worker0, Task task0, boolean z) {
        if(coroutineScheduler$Worker0 == null || (coroutineScheduler$Worker0.state == WorkerState.TERMINATED || !task0.taskContext && coroutineScheduler$Worker0.state == WorkerState.BLOCKING)) {
            return task0;
        }
        coroutineScheduler$Worker0.mayHaveLocalTasks = true;
        return coroutineScheduler$Worker0.localQueue.add(task0, z);
    }

    @Override
    @NotNull
    public String toString() {
        ArrayList arrayList0 = new ArrayList();
        int v = this.workers.currentLength();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        for(int v6 = 1; v6 < v; ++v6) {
            Worker coroutineScheduler$Worker0 = (Worker)this.workers.get(v6);
            if(coroutineScheduler$Worker0 != null) {
                int v7 = coroutineScheduler$Worker0.localQueue.getSize$kotlinx_coroutines_core();
                switch(WhenMappings.$EnumSwitchMapping$0[coroutineScheduler$Worker0.state.ordinal()]) {
                    case 1: {
                        ++v3;
                        break;
                    }
                    case 2: {
                        ++v2;
                        arrayList0.add(v7 + 'b');
                        break;
                    }
                    case 3: {
                        ++v1;
                        arrayList0.add(v7 + 'c');
                        break;
                    }
                    case 4: {
                        ++v4;
                        if(v7 > 0) {
                            arrayList0.add(v7 + 'd');
                        }
                        break;
                    }
                    case 5: {
                        ++v5;
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
        }
        long v8 = CoroutineScheduler.controlState$volatile$FU.get(this);
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.schedulerName);
        stringBuilder0.append('@');
        stringBuilder0.append(DebugStringsKt.getHexAddress(this));
        stringBuilder0.append("[Pool Size {core = ");
        stringBuilder0.append(this.corePoolSize);
        stringBuilder0.append(", max = ");
        x.x(stringBuilder0, this.maxPoolSize, "}, Worker States {CPU = ", v1, ", blocking = ");
        x.x(stringBuilder0, v2, ", parked = ", v3, ", dormant = ");
        x.x(stringBuilder0, v4, ", terminated = ", v5, "}, running workers queues = ");
        stringBuilder0.append(arrayList0);
        stringBuilder0.append(", global CPU queue size = ");
        stringBuilder0.append(this.globalCpuQueue.getSize());
        stringBuilder0.append(", global blocking queue size = ");
        stringBuilder0.append(this.globalBlockingQueue.getSize());
        stringBuilder0.append(", Control State {created workers= ");
        stringBuilder0.append(((int)(0x1FFFFFL & v8)));
        stringBuilder0.append(", blocking tasks = ");
        stringBuilder0.append(((int)((0x3FFFFE00000L & v8) >> 21)));
        stringBuilder0.append(", CPUs acquired = ");
        stringBuilder0.append(this.corePoolSize - ((int)((0x7FFFFC0000000000L & v8) >> 42)));
        stringBuilder0.append("}]");
        return stringBuilder0.toString();
    }

    private final boolean tryCreateWorker(long v) {
        if((((int)(0x1FFFFFL & v)) - ((int)((v & 0x3FFFFE00000L) >> 21)) >= 0 ? ((int)(0x1FFFFFL & v)) - ((int)((v & 0x3FFFFE00000L) >> 21)) : 0) < this.corePoolSize) {
            int v1 = this.createNewWorker();
            if(v1 == 1 && this.corePoolSize > 1) {
                this.createNewWorker();
            }
            return v1 > 0;
        }
        return false;
    }

    public static boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler0, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = CoroutineScheduler.controlState$volatile$FU.get(coroutineScheduler0);
        }
        return coroutineScheduler0.tryCreateWorker(v);
    }

    private final boolean tryUnpark() {
        Worker coroutineScheduler$Worker0;
        do {
            coroutineScheduler$Worker0 = this.parkedWorkersStackPop();
            if(coroutineScheduler$Worker0 == null) {
                return false;
            }
        }
        while(!Worker.getWorkerCtl$volatile$FU().compareAndSet(coroutineScheduler$Worker0, -1, 0));
        LockSupport.unpark(coroutineScheduler$Worker0);
        return true;
    }
}

