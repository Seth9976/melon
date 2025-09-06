package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001A\u0010\n\u001A\u0004\u0018\u00018\u00002\u0006\u0010\t\u001A\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\u00032\b\u0010\f\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/ResizableAtomicArray;", "T", "", "", "initialLength", "<init>", "(I)V", "currentLength", "()I", "index", "get", "(I)Ljava/lang/Object;", "value", "Lie/H;", "setSynchronized", "(ILjava/lang/Object;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ResizableAtomicArray {
    @NotNull
    private volatile AtomicReferenceArray array;

    public ResizableAtomicArray(int v) {
        this.array = new AtomicReferenceArray(v);
    }

    public final int currentLength() {
        return this.array.length();
    }

    @Nullable
    public final Object get(int v) {
        AtomicReferenceArray atomicReferenceArray0 = this.array;
        return v >= atomicReferenceArray0.length() ? null : atomicReferenceArray0.get(v);
    }

    public final void setSynchronized(int v, @Nullable Object object0) {
        AtomicReferenceArray atomicReferenceArray0 = this.array;
        int v1 = atomicReferenceArray0.length();
        if(v < v1) {
            atomicReferenceArray0.set(v, object0);
            return;
        }
        AtomicReferenceArray atomicReferenceArray1 = new AtomicReferenceArray((v + 1 >= v1 * 2 ? v + 1 : v1 * 2));
        for(int v2 = 0; v2 < v1; ++v2) {
            atomicReferenceArray1.set(v2, atomicReferenceArray0.get(v2));
        }
        atomicReferenceArray1.set(v, object0);
        this.array = atomicReferenceArray1;
    }
}

