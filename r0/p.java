package r0;

import G.S;
import P0.f;
import P0.j0;
import P0.m;
import P0.o0;
import Q0.u;
import androidx.collection.G;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

public abstract class p implements m {
    public static final int $stable = 8;
    private int aggregateChildKindSet;
    @Nullable
    private p child;
    @Nullable
    private j0 coordinator;
    @Nullable
    private a detachedListener;
    private boolean insertedNodeAwaitingAttachForInvalidation;
    private boolean isAttached;
    private int kindSet;
    @NotNull
    private p node;
    private boolean onAttachRunExpected;
    private boolean onDetachRunExpected;
    @Nullable
    private o0 ownerScope;
    @Nullable
    private p parent;
    @Nullable
    private CoroutineScope scope;
    private boolean updatedNodeAwaitingAttachForInvalidation;

    public p() {
        this.node = this;
        this.aggregateChildKindSet = -1;
    }

    public boolean G() {
        return this.isAttached();
    }

    public final int getAggregateChildKindSet$ui_release() {
        return this.aggregateChildKindSet;
    }

    @Nullable
    public final p getChild$ui_release() {
        return this.child;
    }

    @Nullable
    public final j0 getCoordinator$ui_release() {
        return this.coordinator;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope0 = this.scope;
        if(coroutineScope0 == null) {
            coroutineScope0 = CoroutineScopeKt.CoroutineScope(((u)f.w(this)).getCoroutineContext().plus(JobKt.Job(((Job)((u)f.w(this)).getCoroutineContext().get(Job.Key)))));
            this.scope = coroutineScope0;
        }
        return coroutineScope0;
    }

    @Nullable
    public final a getDetachedListener$ui_release() {
        return this.detachedListener;
    }

    public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
        return this.insertedNodeAwaitingAttachForInvalidation;
    }

    public final int getKindSet$ui_release() {
        return this.kindSet;
    }

    @Override  // P0.m
    @NotNull
    public final p getNode() {
        return this.node;
    }

    public static void getNode$annotations() {
    }

    @Nullable
    public final o0 getOwnerScope$ui_release() {
        return this.ownerScope;
    }

    @Nullable
    public final p getParent$ui_release() {
        return this.parent;
    }

    public boolean getShouldAutoInvalidate() {
        return true;
    }

    public static void getShouldAutoInvalidate$annotations() {
    }

    public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
        return this.updatedNodeAwaitingAttachForInvalidation;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public final boolean isKind-H91voCI$ui_release(int v) {
        return (v & this.getKindSet$ui_release()) != 0;
    }

    public void markAsAttached$ui_release() {
        if(this.isAttached) {
            M0.a.b("node attached multiple times");
        }
        if(this.coordinator == null) {
            M0.a.b("attach invoked on a node without a coordinator");
        }
        this.isAttached = true;
        this.onAttachRunExpected = true;
    }

    public void markAsDetached$ui_release() {
        if(!this.isAttached) {
            M0.a.b("Cannot detach a node that is not attached");
        }
        if(this.onAttachRunExpected) {
            M0.a.b("Must run runAttachLifecycle() before markAsDetached()");
        }
        if(this.onDetachRunExpected) {
            M0.a.b("Must run runDetachLifecycle() before markAsDetached()");
        }
        this.isAttached = false;
        CoroutineScope coroutineScope0 = this.scope;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel(coroutineScope0, new S("The Modifier.Node was detached", 6));
            this.scope = null;
        }
    }

    public void onAttach() {
    }

    public void onDetach() {
    }

    public void onReset() {
    }

    public void reset$ui_release() {
        if(!this.isAttached) {
            M0.a.b("reset() called on an unattached node");
        }
        this.onReset();
    }

    public void runAttachLifecycle$ui_release() {
        if(!this.isAttached) {
            M0.a.b("Must run markAsAttached() prior to runAttachLifecycle");
        }
        if(!this.onAttachRunExpected) {
            M0.a.b("Must run runAttachLifecycle() only once after markAsAttached()");
        }
        this.onAttachRunExpected = false;
        this.onAttach();
        this.onDetachRunExpected = true;
    }

    public void runDetachLifecycle$ui_release() {
        if(!this.isAttached) {
            M0.a.b("node detached multiple times");
        }
        if(this.coordinator == null) {
            M0.a.b("detach invoked on a node without a coordinator");
        }
        if(!this.onDetachRunExpected) {
            M0.a.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
        }
        this.onDetachRunExpected = false;
        a a0 = this.detachedListener;
        if(a0 != null) {
            a0.invoke();
        }
        this.onDetach();
    }

    public final void setAggregateChildKindSet$ui_release(int v) {
        this.aggregateChildKindSet = v;
    }

    public void setAsDelegateTo$ui_release(@NotNull p p0) {
        this.node = p0;
    }

    public final void setChild$ui_release(@Nullable p p0) {
        this.child = p0;
    }

    public final void setDetachedListener$ui_release(@Nullable a a0) {
        this.detachedListener = a0;
    }

    public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
        this.insertedNodeAwaitingAttachForInvalidation = z;
    }

    public final void setKindSet$ui_release(int v) {
        this.kindSet = v;
    }

    public final void setOwnerScope$ui_release(@Nullable o0 o00) {
        this.ownerScope = o00;
    }

    public final void setParent$ui_release(@Nullable p p0) {
        this.parent = p0;
    }

    public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean z) {
        this.updatedNodeAwaitingAttachForInvalidation = z;
    }

    public final void sideEffect(@NotNull a a0) {
        G g0 = ((u)f.w(this)).Q0;
        if(g0.f(a0) >= 0) {
            return;
        }
        g0.a(a0);
    }

    public void updateCoordinator$ui_release(@Nullable j0 j00) {
        this.coordinator = j00;
    }
}

