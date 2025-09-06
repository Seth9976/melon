package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J3\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/flow/internal/FusibleFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "fuse", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface FusibleFlow extends Flow {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static Flow fuse$default(FusibleFlow fusibleFlow0, i i0, int v, BufferOverflow bufferOverflow0, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if((v1 & 1) != 0) {
                i0 = j.a;
            }
            if((v1 & 2) != 0) {
                v = -3;
            }
            if((v1 & 4) != 0) {
                bufferOverflow0 = BufferOverflow.SUSPEND;
            }
            return fusibleFlow0.fuse(i0, v, bufferOverflow0);
        }
    }

    @NotNull
    Flow fuse(@NotNull i arg1, int arg2, @NotNull BufferOverflow arg3);
}

