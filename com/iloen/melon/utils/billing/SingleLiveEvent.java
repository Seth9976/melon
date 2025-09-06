package com.iloen.melon.utils.billing;

import Vb.p0;
import androidx.lifecycle.D;
import androidx.lifecycle.L;
import androidx.lifecycle.M;
import com.iloen.melon.utils.log.LogU;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u000E\u0010\b\u001A\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\r\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\tH\u0007¢\u0006\u0004\b\u000F\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/utils/billing/SingleLiveEvent;", "T", "Landroidx/lifecycle/L;", "<init>", "()V", "Landroidx/lifecycle/D;", "owner", "Landroidx/lifecycle/M;", "observer", "Lie/H;", "observe", "(Landroidx/lifecycle/D;Landroidx/lifecycle/M;)V", "t", "setValue", "(Ljava/lang/Object;)V", "call", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SingleLiveEvent extends L {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/billing/SingleLiveEvent$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final AtomicBoolean l;

    static {
        SingleLiveEvent.Companion = new Companion(null);
        SingleLiveEvent.$stable = 8;
    }

    public SingleLiveEvent() {
        this.l = new AtomicBoolean(false);
    }

    public final void call() {
        this.setValue(null);
    }

    @Override  // androidx.lifecycle.K
    public void observe(@NotNull D d0, @NotNull M m0) {
        q.g(d0, "owner");
        q.g(m0, "observer");
        if(this.hasActiveObservers()) {
            LogU.Companion.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(d0, new SingleLiveEvent.sam.androidx_lifecycle_Observer.0(new p0(14, this, m0)));
    }

    @Override  // androidx.lifecycle.K
    public void setValue(@Nullable Object object0) {
        this.l.set(true);
        super.setValue(object0);
    }
}

