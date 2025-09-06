package kotlinx.coroutines;

import ie.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@d
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\'¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface ParentJob extends Job {
    @NotNull
    CancellationException getChildJobCancellationCause();
}

