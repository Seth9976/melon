package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0082\u0010¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\r\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0082\u0010¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000EH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001AJ\u0011\u0010\u001B\u001A\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001B\u0010\u0015J\u0017\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u001C\u001A\u00020\bH\u0001¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00028\u0000H\u0001¢\u0006\u0004\b\u001F\u0010 R \u0010!\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010\'\u001A\u00020\b2\u0006\u0010#\u001A\u00020\b8F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\fR\u0011\u0010(\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b(\u0010)R\u000B\u0010+\u001A\u00020*8\u0002X\u0082\u0004¨\u0006,"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "", "i", "Lie/H;", "siftUpFrom", "(I)V", "siftDownFrom", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "j", "swap", "(II)V", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "node", "", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "value", "getSize", "()I", "setSize", "size", "isEmpty", "()Z", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class ThreadSafeHeap {
    private volatile int _size$volatile;
    private static final AtomicIntegerFieldUpdater _size$volatile$FU;
    @Nullable
    private ThreadSafeHeapNode[] a;

    static {
        ThreadSafeHeap._size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    }

    public final void addImpl(@NotNull ThreadSafeHeapNode threadSafeHeapNode0) {
        threadSafeHeapNode0.setHeap(this);
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.realloc();
        int v = this.getSize();
        this.setSize(v + 1);
        arr_threadSafeHeapNode[v] = threadSafeHeapNode0;
        threadSafeHeapNode0.setIndex(v);
        this.siftUpFrom(v);
    }

    @Nullable
    public final ThreadSafeHeapNode firstImpl() {
        return this.a == null ? null : this.a[0];
    }

    public final int getSize() {
        return ThreadSafeHeap._size$volatile$FU.get(this);
    }

    public final boolean isEmpty() {
        return this.getSize() == 0;
    }

    @Nullable
    public final ThreadSafeHeapNode peek() {
        synchronized(this) {
            return this.firstImpl();
        }
    }

    private final ThreadSafeHeapNode[] realloc() {
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
        if(arr_threadSafeHeapNode == null) {
            ThreadSafeHeapNode[] arr_threadSafeHeapNode1 = new ThreadSafeHeapNode[4];
            this.a = arr_threadSafeHeapNode1;
            return arr_threadSafeHeapNode1;
        }
        if(this.getSize() >= arr_threadSafeHeapNode.length) {
            Object[] arr_object = Arrays.copyOf(arr_threadSafeHeapNode, this.getSize() * 2);
            q.f(arr_object, "copyOf(...)");
            arr_threadSafeHeapNode = (ThreadSafeHeapNode[])arr_object;
            this.a = arr_threadSafeHeapNode;
        }
        return arr_threadSafeHeapNode;
    }

    public final boolean remove(@NotNull ThreadSafeHeapNode threadSafeHeapNode0) {
        boolean z;
        synchronized(this) {
            if(threadSafeHeapNode0.getHeap() == null) {
                z = false;
            }
            else {
                this.removeAtImpl(threadSafeHeapNode0.getIndex());
                z = true;
            }
            return z;
        }
    }

    @NotNull
    public final ThreadSafeHeapNode removeAtImpl(int v) {
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
        q.d(arr_threadSafeHeapNode);
        this.setSize(this.getSize() - 1);
        if(v < this.getSize()) {
            this.swap(v, this.getSize());
            int v1 = (v - 1) / 2;
            if(v > 0) {
                ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v];
                q.d(threadSafeHeapNode0);
                ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v1];
                q.d(threadSafeHeapNode1);
                if(((Comparable)threadSafeHeapNode0).compareTo(threadSafeHeapNode1) < 0) {
                    this.swap(v, v1);
                    this.siftUpFrom(v1);
                }
                else {
                    this.siftDownFrom(v);
                }
            }
            else {
                this.siftDownFrom(v);
            }
        }
        ThreadSafeHeapNode threadSafeHeapNode2 = arr_threadSafeHeapNode[this.getSize()];
        q.d(threadSafeHeapNode2);
        threadSafeHeapNode2.setHeap(null);
        threadSafeHeapNode2.setIndex(-1);
        arr_threadSafeHeapNode[this.getSize()] = null;
        return threadSafeHeapNode2;
    }

    @Nullable
    public final ThreadSafeHeapNode removeFirstOrNull() {
        synchronized(this) {
            return this.getSize() <= 0 ? null : this.removeAtImpl(0);
        }
    }

    private final void setSize(int v) {
        ThreadSafeHeap._size$volatile$FU.set(this, v);
    }

    private final void siftDownFrom(int v) {
        int v1;
        while((v1 = v * 2 + 1) < this.getSize()) {
            ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
            q.d(arr_threadSafeHeapNode);
            int v2 = v * 2 + 2;
            if(v2 < this.getSize()) {
                ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v2];
                q.d(threadSafeHeapNode0);
                ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v1];
                q.d(threadSafeHeapNode1);
                if(((Comparable)threadSafeHeapNode0).compareTo(threadSafeHeapNode1) >= 0) {
                    v2 = v1;
                }
            }
            else {
                v2 = v1;
            }
            ThreadSafeHeapNode threadSafeHeapNode2 = arr_threadSafeHeapNode[v];
            q.d(threadSafeHeapNode2);
            ThreadSafeHeapNode threadSafeHeapNode3 = arr_threadSafeHeapNode[v2];
            q.d(threadSafeHeapNode3);
            if(((Comparable)threadSafeHeapNode2).compareTo(threadSafeHeapNode3) <= 0) {
                break;
            }
            this.swap(v, v2);
            v = v2;
        }
    }

    private final void siftUpFrom(int v) {
        while(v > 0) {
            ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
            q.d(arr_threadSafeHeapNode);
            int v1 = (v - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v1];
            q.d(threadSafeHeapNode0);
            ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v];
            q.d(threadSafeHeapNode1);
            if(((Comparable)threadSafeHeapNode0).compareTo(threadSafeHeapNode1) <= 0) {
                break;
            }
            this.swap(v, v1);
            v = v1;
        }
    }

    private final void swap(int v, int v1) {
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
        q.d(arr_threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v1];
        q.d(threadSafeHeapNode0);
        ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v];
        q.d(threadSafeHeapNode1);
        arr_threadSafeHeapNode[v] = threadSafeHeapNode0;
        arr_threadSafeHeapNode[v1] = threadSafeHeapNode1;
        threadSafeHeapNode0.setIndex(v);
        threadSafeHeapNode1.setIndex(v1);
    }
}

