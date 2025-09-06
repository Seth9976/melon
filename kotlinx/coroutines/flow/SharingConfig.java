package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000ER\u0014\u0010\b\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000FR\u0014\u0010\n\u001A\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SharingConfig;", "T", "", "Lkotlinx/coroutines/flow/Flow;", "upstream", "", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lme/i;", "context", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;Lme/i;)V", "Lkotlinx/coroutines/flow/Flow;", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lme/i;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class SharingConfig {
    @NotNull
    public final i context;
    public final int extraBufferCapacity;
    @NotNull
    public final BufferOverflow onBufferOverflow;
    @NotNull
    public final Flow upstream;

    public SharingConfig(@NotNull Flow flow0, int v, @NotNull BufferOverflow bufferOverflow0, @NotNull i i0) {
        this.upstream = flow0;
        this.extraBufferCapacity = v;
        this.onBufferOverflow = bufferOverflow0;
        this.context = i0;
    }
}

