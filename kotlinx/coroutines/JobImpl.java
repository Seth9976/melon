package kotlinx.coroutines;

import ie.H;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tR\u001A\u0010\b\u001A\u00020\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\b\u0010\u000B\u001A\u0004\b\f\u0010\tR\u0014\u0010\u000E\u001A\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\t¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "handlesException", "()Z", "complete", "Z", "getHandlesException$kotlinx_coroutines_core", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException;

    public JobImpl(@Nullable Job job0) {
        super(true);
        this.initParentJob(job0);
        this.handlesException = this.handlesException();
    }

    @Override  // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return this.makeCompleting$kotlinx_coroutines_core(H.a);
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    private final boolean handlesException() {
        ChildHandle childHandle0 = this.getParentHandle$kotlinx_coroutines_core();
        ChildHandleNode childHandleNode0 = childHandle0 instanceof ChildHandleNode ? ((ChildHandleNode)childHandle0) : null;
        if(childHandleNode0 != null) {
            JobSupport jobSupport0 = childHandleNode0.getJob();
            if(jobSupport0 != null) {
                while(true) {
                    if(jobSupport0.getHandlesException$kotlinx_coroutines_core()) {
                        return true;
                    }
                    ChildHandle childHandle1 = jobSupport0.getParentHandle$kotlinx_coroutines_core();
                    ChildHandleNode childHandleNode1 = childHandle1 instanceof ChildHandleNode ? ((ChildHandleNode)childHandle1) : null;
                    if(childHandleNode1 == null) {
                        break;
                    }
                    jobSupport0 = childHandleNode1.getJob();
                    if(jobSupport0 == null) {
                        break;
                    }
                }
            }
        }
        return false;
    }
}

