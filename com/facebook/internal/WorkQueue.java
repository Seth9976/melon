package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B\u001D\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\r\u001A\u00020\b2\f\u0010\f\u001A\b\u0018\u00010\u000BR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001B\u0010\u0010\u001A\u00020\b2\n\u0010\u000F\u001A\u00060\u000BR\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u000EJ!\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001A\u00020\b¢\u0006\u0004\b\u0018\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u001C\u0010\u001E\u001A\b\u0018\u00010\u000BR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u001C\u0010 \u001A\b\u0018\u00010\u000BR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010\u001FR\u0016\u0010!\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\u0019¨\u0006%"}, d2 = {"Lcom/facebook/internal/WorkQueue;", "", "", "maxConcurrent", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(ILjava/util/concurrent/Executor;)V", "Lie/H;", "startItem", "()V", "Lcom/facebook/internal/WorkQueue$WorkNode;", "finished", "finishItemAndStartNew", "(Lcom/facebook/internal/WorkQueue$WorkNode;)V", "node", "execute", "Ljava/lang/Runnable;", "callback", "", "addToFront", "Lcom/facebook/internal/WorkQueue$WorkItem;", "addActiveWorkItem", "(Ljava/lang/Runnable;Z)Lcom/facebook/internal/WorkQueue$WorkItem;", "validate", "I", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/locks/ReentrantLock;", "workLock", "Ljava/util/concurrent/locks/ReentrantLock;", "pendingJobs", "Lcom/facebook/internal/WorkQueue$WorkNode;", "runningJobs", "runningCount", "Companion", "WorkItem", "WorkNode", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WorkQueue {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001A\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/facebook/internal/WorkQueue$Companion;", "", "<init>", "()V", "", "condition", "Lie/H;", "assert", "(Z)V", "", "DEFAULT_MAX_CONCURRENT", "I", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final void assert(boolean z) {
            if(!z) {
                throw new FacebookException("Validation failed");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00028&X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkItem;", "", "", "cancel", "()Z", "Lie/H;", "moveToFront", "()V", "isRunning", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u000F\u001A\u00060\u0000R\u00020\f2\f\u0010\r\u001A\b\u0018\u00010\u0000R\u00020\f2\u0006\u0010\u000E\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0011\u001A\b\u0018\u00010\u0000R\u00020\f2\f\u0010\r\u001A\b\u0018\u00010\u0000R\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R0\u0010\u001A\u001A\b\u0018\u00010\u0000R\u00020\f2\f\u0010\u0019\u001A\b\u0018\u00010\u0000R\u00020\f8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u001C\u0010\u001E\u001A\b\u0018\u00010\u0000R\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001BR\"\u0010\u001F\u001A\u00020\u00068\u0016@\u0016X\u0096\u000E¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b\u001F\u0010\b\"\u0004\b!\u0010\u0015¨\u0006\""}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkNode;", "Lcom/facebook/internal/WorkQueue$WorkItem;", "Ljava/lang/Runnable;", "callback", "<init>", "(Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "", "cancel", "()Z", "Lie/H;", "moveToFront", "()V", "Lcom/facebook/internal/WorkQueue;", "list", "addToFront", "addToList", "(Lcom/facebook/internal/WorkQueue$WorkNode;Z)Lcom/facebook/internal/WorkQueue$WorkNode;", "removeFromList", "(Lcom/facebook/internal/WorkQueue$WorkNode;)Lcom/facebook/internal/WorkQueue$WorkNode;", "shouldBeRunning", "verify", "(Z)V", "Ljava/lang/Runnable;", "getCallback", "()Ljava/lang/Runnable;", "<set-?>", "next", "Lcom/facebook/internal/WorkQueue$WorkNode;", "getNext", "()Lcom/facebook/internal/WorkQueue$WorkNode;", "prev", "isRunning", "Z", "setRunning", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class WorkNode implements WorkItem {
        @NotNull
        private final Runnable callback;
        private boolean isRunning;
        @Nullable
        private WorkNode next;
        @Nullable
        private WorkNode prev;

        public WorkNode(@NotNull Runnable runnable0) {
            q.g(runnable0, "callback");
            WorkQueue.this = workQueue0;
            super();
            this.callback = runnable0;
        }

        @NotNull
        public final WorkNode addToList(@Nullable WorkNode workQueue$WorkNode0, boolean z) {
            Companion workQueue$Companion0 = WorkQueue.Companion;
            boolean z1 = false;
            workQueue$Companion0.assert(this.next == null);
            if(this.prev == null) {
                z1 = true;
            }
            workQueue$Companion0.assert(z1);
            if(workQueue$WorkNode0 == null) {
                this.prev = this;
                this.next = this;
                return this;
            }
            this.next = workQueue$WorkNode0;
            WorkNode workQueue$WorkNode1 = workQueue$WorkNode0.prev;
            this.prev = workQueue$WorkNode1;
            if(workQueue$WorkNode1 != null) {
                workQueue$WorkNode1.next = this;
            }
            WorkNode workQueue$WorkNode2 = this.next;
            if(workQueue$WorkNode2 != null) {
                workQueue$WorkNode2.prev = workQueue$WorkNode1 == null ? null : workQueue$WorkNode1.next;
            }
            return z ? this : workQueue$WorkNode0;
        }

        @Override  // com.facebook.internal.WorkQueue$WorkItem
        public boolean cancel() {
            ReentrantLock reentrantLock0 = WorkQueue.this.workLock;
            WorkQueue workQueue0 = WorkQueue.this;
            reentrantLock0.lock();
            try {
                if(!this.isRunning()) {
                    workQueue0.pendingJobs = this.removeFromList(workQueue0.pendingJobs);
                    return true;
                }
                return false;
            }
            finally {
                reentrantLock0.unlock();
            }
        }

        @NotNull
        public final Runnable getCallback() {
            return this.callback;
        }

        @Nullable
        public final WorkNode getNext() {
            return this.next;
        }

        @Override  // com.facebook.internal.WorkQueue$WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        @Override  // com.facebook.internal.WorkQueue$WorkItem
        public void moveToFront() {
            ReentrantLock reentrantLock0 = WorkQueue.this.workLock;
            WorkQueue workQueue0 = WorkQueue.this;
            reentrantLock0.lock();
            try {
                if(!this.isRunning()) {
                    workQueue0.pendingJobs = this.removeFromList(workQueue0.pendingJobs);
                    workQueue0.pendingJobs = this.addToList(workQueue0.pendingJobs, true);
                }
            }
            finally {
                reentrantLock0.unlock();
            }
        }

        @Nullable
        public final WorkNode removeFromList(@Nullable WorkNode workQueue$WorkNode0) {
            Companion workQueue$Companion0 = WorkQueue.Companion;
            boolean z = false;
            workQueue$Companion0.assert(this.next != null);
            if(this.prev != null) {
                z = true;
            }
            workQueue$Companion0.assert(z);
            if(workQueue$WorkNode0 == this) {
                workQueue$WorkNode0 = this.next;
                if(workQueue$WorkNode0 == this) {
                    workQueue$WorkNode0 = null;
                }
            }
            WorkNode workQueue$WorkNode1 = this.next;
            if(workQueue$WorkNode1 != null) {
                workQueue$WorkNode1.prev = this.prev;
            }
            WorkNode workQueue$WorkNode2 = this.prev;
            if(workQueue$WorkNode2 != null) {
                workQueue$WorkNode2.next = workQueue$WorkNode1;
            }
            this.prev = null;
            this.next = null;
            return workQueue$WorkNode0;
        }

        public void setRunning(boolean z) {
            this.isRunning = z;
        }

        public final void verify(boolean z) {
            WorkNode workQueue$WorkNode3;
            WorkNode workQueue$WorkNode1;
            Companion workQueue$Companion0 = WorkQueue.Companion;
            WorkNode workQueue$WorkNode0 = this.prev;
            if(workQueue$WorkNode0 == null) {
                workQueue$WorkNode1 = this;
            }
            else {
                workQueue$WorkNode1 = workQueue$WorkNode0.next;
                if(workQueue$WorkNode1 == null) {
                    workQueue$WorkNode1 = this;
                }
            }
            boolean z1 = false;
            workQueue$Companion0.assert(workQueue$WorkNode1 == this);
            WorkNode workQueue$WorkNode2 = this.next;
            if(workQueue$WorkNode2 == null) {
                workQueue$WorkNode3 = this;
            }
            else {
                workQueue$WorkNode3 = workQueue$WorkNode2.prev;
                if(workQueue$WorkNode3 == null) {
                    workQueue$WorkNode3 = this;
                }
            }
            workQueue$Companion0.assert(workQueue$WorkNode3 == this);
            if(this.isRunning() == z) {
                z1 = true;
            }
            workQueue$Companion0.assert(z1);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    @NotNull
    private final Executor executor;
    private final int maxConcurrent;
    @Nullable
    private WorkNode pendingJobs;
    private int runningCount;
    @Nullable
    private WorkNode runningJobs;
    @NotNull
    private final ReentrantLock workLock;

    static {
        WorkQueue.Companion = new Companion(null);
    }

    public WorkQueue() {
        this(0, null, 3, null);
    }

    public WorkQueue(int v) {
        this(v, null, 2, null);
    }

    public WorkQueue(int v, @NotNull Executor executor0) {
        q.g(executor0, "executor");
        super();
        this.maxConcurrent = v;
        this.executor = executor0;
        this.workLock = new ReentrantLock();
    }

    public WorkQueue(int v, Executor executor0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            v = 8;
        }
        if((v1 & 2) != 0) {
            executor0 = FacebookSdk.getExecutor();
        }
        this(v, executor0);
    }

    @NotNull
    public final WorkItem addActiveWorkItem(@NotNull Runnable runnable0) {
        q.g(runnable0, "callback");
        return WorkQueue.addActiveWorkItem$default(this, runnable0, false, 2, null);
    }

    @NotNull
    public final WorkItem addActiveWorkItem(@NotNull Runnable runnable0, boolean z) {
        q.g(runnable0, "callback");
        WorkItem workQueue$WorkItem0 = new WorkNode(this, runnable0);
        this.workLock.lock();
        try {
            this.pendingJobs = ((WorkNode)workQueue$WorkItem0).addToList(this.pendingJobs, z);
        }
        finally {
            this.workLock.unlock();
        }
        this.startItem();
        return workQueue$WorkItem0;
    }

    public static WorkItem addActiveWorkItem$default(WorkQueue workQueue0, Runnable runnable0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = true;
        }
        return workQueue0.addActiveWorkItem(runnable0, z);
    }

    private final void execute(WorkNode workQueue$WorkNode0) {
        h h0 = new h(0, workQueue$WorkNode0, this);
        this.executor.execute(h0);
    }

    private static final void execute$lambda$2(WorkNode workQueue$WorkNode0, WorkQueue workQueue0) {
        q.g(workQueue$WorkNode0, "$node");
        q.g(workQueue0, "this$0");
        try {
            workQueue$WorkNode0.getCallback().run();
        }
        finally {
            workQueue0.finishItemAndStartNew(workQueue$WorkNode0);
        }
    }

    private final void finishItemAndStartNew(WorkNode workQueue$WorkNode0) {
        WorkNode workQueue$WorkNode1;
        this.workLock.lock();
        if(workQueue$WorkNode0 != null) {
            this.runningJobs = workQueue$WorkNode0.removeFromList(this.runningJobs);
            --this.runningCount;
        }
        if(this.runningCount < this.maxConcurrent) {
            workQueue$WorkNode1 = this.pendingJobs;
            if(workQueue$WorkNode1 != null) {
                this.pendingJobs = workQueue$WorkNode1.removeFromList(workQueue$WorkNode1);
                this.runningJobs = workQueue$WorkNode1.addToList(this.runningJobs, false);
                ++this.runningCount;
                workQueue$WorkNode1.setRunning(true);
            }
        }
        else {
            workQueue$WorkNode1 = null;
        }
        this.workLock.unlock();
        if(workQueue$WorkNode1 != null) {
            this.execute(workQueue$WorkNode1);
        }
    }

    private final void startItem() {
        this.finishItemAndStartNew(null);
    }

    public final void validate() {
        ReentrantLock reentrantLock0 = this.workLock;
        reentrantLock0.lock();
        try {
            WorkNode workQueue$WorkNode0 = this.runningJobs;
            boolean z = false;
            int v1 = 0;
            if(workQueue$WorkNode0 != null) {
                while(workQueue$WorkNode0 != null) {
                    workQueue$WorkNode0.verify(true);
                    ++v1;
                    workQueue$WorkNode0 = workQueue$WorkNode0.getNext();
                    if(workQueue$WorkNode0 != this.runningJobs) {
                        continue;
                    }
                    goto label_15;
                }
                throw new IllegalStateException("Required value was null.");
            }
        label_15:
            Companion workQueue$Companion0 = WorkQueue.Companion;
            if(this.runningCount == v1) {
                z = true;
            }
            workQueue$Companion0.assert(z);
        }
        finally {
            reentrantLock0.unlock();
        }
    }
}

