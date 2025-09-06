package com.iloen.melon.fragments.tabs;

import androidx.lifecycle.m0;
import com.iloen.melon.custom.C;
import com.iloen.melon.custom.E;
import com.iloen.melon.custom.L0;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u000F\u001A\u00020\n8\u0016@\u0016X\u0096\u000F¢\u0006\f\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00050\u00108\u0016X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/tabs/TabBaseFragmentViewModel;", "Landroidx/lifecycle/m0;", "Lcom/iloen/melon/custom/C;", "<init>", "()V", "", "isProgressing", "Lie/H;", "updateProgressCnt", "(Z)V", "Ljava/util/concurrent/atomic/AtomicInteger;", "getProgressCnt", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setProgressCnt", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "progressCnt", "Lkotlinx/coroutines/flow/StateFlow;", "isProgressVisible", "()Lkotlinx/coroutines/flow/StateFlow;", "Lcom/iloen/melon/custom/L0;", "getProgressUpdater", "()Lcom/iloen/melon/custom/L0;", "progressUpdater", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TabBaseFragmentViewModel extends m0 implements C {
    private final E $$delegate_0;
    public static final int $stable = 8;

    public TabBaseFragmentViewModel() {
        this.$$delegate_0 = new E();
    }

    @NotNull
    public AtomicInteger getProgressCnt() {
        return this.$$delegate_0.b;
    }

    @Override  // com.iloen.melon.custom.C
    @NotNull
    public L0 getProgressUpdater() {
        return this.$$delegate_0.e;
    }

    @Override  // com.iloen.melon.custom.C
    @NotNull
    public StateFlow isProgressVisible() {
        return this.$$delegate_0.d;
    }

    public void setProgressCnt(@NotNull AtomicInteger atomicInteger0) {
        q.g(atomicInteger0, "<set-?>");
        this.$$delegate_0.getClass();
        this.$$delegate_0.b = atomicInteger0;
    }

    public void updateProgressCnt(boolean z) {
        this.$$delegate_0.a(z);
    }
}

