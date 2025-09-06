package androidx.graphics.path;

import android.graphics.Path;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\b\u0000\u0018\u0000J(\u0010\b\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0005H\u0082 ¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0007H\u0082 ¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u0007H\u0083 ¢\u0006\u0004\b\u000F\u0010\u0010J(\u0010\u0014\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0003H\u0083 ¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0007H\u0083 ¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0007H\u0083 ¢\u0006\u0004\b\u0018\u0010\u0017J\u0018\u0010\u0019\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0007H\u0083 ¢\u0006\u0004\b\u0019\u0010\u0017¨\u0006\u001A"}, d2 = {"Landroidx/graphics/path/PathIteratorPreApi34Impl;", "Landroid/graphics/Path;", "path", "", "conicEvaluation", "", "tolerance", "", "createInternalPathIterator", "(Landroid/graphics/Path;IF)J", "internalPathIterator", "Lie/H;", "destroyInternalPathIterator", "(J)V", "", "internalPathIteratorHasNext", "(J)Z", "", "points", "offset", "internalPathIteratorNext", "(J[FI)I", "internalPathIteratorPeek", "(J)I", "internalPathIteratorRawSize", "internalPathIteratorSize", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PathIteratorPreApi34Impl {
    static {
        System.loadLibrary("androidx.graphics.path");
    }

    private final native long createInternalPathIterator(Path arg1, int arg2, float arg3) {
    }

    private final native void destroyInternalPathIterator(long arg1) {
    }

    @Override
    public final void finalize() {
        this.destroyInternalPathIterator(0L);
    }

    @FastNative
    private final native boolean internalPathIteratorHasNext(long arg1) {
    }

    @FastNative
    private final native int internalPathIteratorNext(long arg1, float[] arg2, int arg3) {
    }

    @FastNative
    private final native int internalPathIteratorPeek(long arg1) {
    }

    @FastNative
    private final native int internalPathIteratorRawSize(long arg1) {
    }

    @FastNative
    private final native int internalPathIteratorSize(long arg1) {
    }
}

