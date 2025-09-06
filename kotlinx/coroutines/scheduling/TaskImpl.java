package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\'\u0012\n\u0010\u0004\u001A\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\n\u0010\t\u001A\u00060\u0007j\u0002`\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001A\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "submissionTime", "", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "<init>", "(Ljava/lang/Runnable;JZ)V", "Lie/H;", "run", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class TaskImpl extends Task {
    @NotNull
    public final Runnable block;

    public TaskImpl(@NotNull Runnable runnable0, long v, boolean z) {
        super(v, z);
        this.block = runnable0;
    }

    @Override
    public void run() {
        this.block.run();
    }

    @Override
    @NotNull
    public String toString() {
        return "Task[" + DebugStringsKt.getClassSimpleName(this.block) + '@' + DebugStringsKt.getHexAddress(this.block) + ", " + this.submissionTime + ", " + TasksKt.taskContextString(this.taskContext) + ']';
    }
}

