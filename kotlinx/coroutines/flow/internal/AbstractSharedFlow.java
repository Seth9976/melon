package kotlinx.coroutines.flow.internal;

import ie.H;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000B2\u0006\u0010\n\u001A\u00020\tH$¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00028\u0000H\u0004¢\u0006\u0004\b\u000E\u0010\bJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012R8\u0010\u0014\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000B2\u0010\u0010\u0013\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000B8\u0004@BX\u0084\u000E¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\t8\u0004@BX\u0084\u000E¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u0019R\u0018\u0010\u001E\u001A\u0004\u0018\u00010\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0017\u0010#\u001A\b\u0012\u0004\u0012\u00020\t0 8F¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "slot", "Lie/H;", "freeSlot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "value", "slots", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "nCollectors", "I", "getNCollectors", "()I", "nextIndex", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class AbstractSharedFlow {
    @Nullable
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    @Nullable
    private AbstractSharedFlowSlot[] slots;

    @NotNull
    public final AbstractSharedFlowSlot allocateSlot() {
        SubscriptionCountStateFlow subscriptionCountStateFlow0;
        AbstractSharedFlowSlot abstractSharedFlowSlot0;
        synchronized(this) {
            AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot = this.slots;
            if(arr_abstractSharedFlowSlot == null) {
                arr_abstractSharedFlowSlot = this.createSlotArray(2);
                this.slots = arr_abstractSharedFlowSlot;
            }
            else if(this.nCollectors >= arr_abstractSharedFlowSlot.length) {
                Object[] arr_object = Arrays.copyOf(arr_abstractSharedFlowSlot, arr_abstractSharedFlowSlot.length * 2);
                q.f(arr_object, "copyOf(...)");
                this.slots = (AbstractSharedFlowSlot[])arr_object;
                arr_abstractSharedFlowSlot = (AbstractSharedFlowSlot[])arr_object;
            }
            int v1 = this.nextIndex;
            do {
                abstractSharedFlowSlot0 = arr_abstractSharedFlowSlot[v1];
                if(abstractSharedFlowSlot0 == null) {
                    abstractSharedFlowSlot0 = this.createSlot();
                    arr_abstractSharedFlowSlot[v1] = abstractSharedFlowSlot0;
                }
                ++v1;
                v1 = v1 < arr_abstractSharedFlowSlot.length ? v1 + 1 : 0;
                q.e(abstractSharedFlowSlot0, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
            while(!abstractSharedFlowSlot0.allocateLocked(this));
            this.nextIndex = v1;
            ++this.nCollectors;
            subscriptionCountStateFlow0 = this._subscriptionCount;
        }
        if(subscriptionCountStateFlow0 != null) {
            subscriptionCountStateFlow0.increment(1);
        }
        return abstractSharedFlowSlot0;
    }

    @NotNull
    public abstract AbstractSharedFlowSlot createSlot();

    @NotNull
    public abstract AbstractSharedFlowSlot[] createSlotArray(int arg1);

    public final void freeSlot(@NotNull AbstractSharedFlowSlot abstractSharedFlowSlot0) {
        Continuation[] arr_continuation;
        SubscriptionCountStateFlow subscriptionCountStateFlow0;
        synchronized(this) {
            int v1 = this.nCollectors - 1;
            this.nCollectors = v1;
            subscriptionCountStateFlow0 = this._subscriptionCount;
            if(v1 == 0) {
                this.nextIndex = 0;
            }
            q.e(abstractSharedFlowSlot0, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            arr_continuation = abstractSharedFlowSlot0.freeLocked(this);
        }
        for(int v2 = 0; v2 < arr_continuation.length; ++v2) {
            Continuation continuation0 = arr_continuation[v2];
            if(continuation0 != null) {
                continuation0.resumeWith(H.a);
            }
        }
        if(subscriptionCountStateFlow0 != null) {
            subscriptionCountStateFlow0.increment(-1);
        }
    }

    public final int getNCollectors() {
        return this.nCollectors;
    }

    @Nullable
    public final AbstractSharedFlowSlot[] getSlots() {
        return this.slots;
    }

    @NotNull
    public final StateFlow getSubscriptionCount() {
        synchronized(this) {
            SubscriptionCountStateFlow subscriptionCountStateFlow0 = this._subscriptionCount;
            if(subscriptionCountStateFlow0 == null) {
                subscriptionCountStateFlow0 = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = subscriptionCountStateFlow0;
            }
            return subscriptionCountStateFlow0;
        }
    }
}

