package androidx.car.app.utils;

import android.graphics.Rect;
import androidx.car.app.IOnDoneCallback;
import androidx.car.app.ISurfaceCallback.Stub;
import androidx.car.app.SurfaceContainer;
import androidx.car.app.k;
import androidx.car.app.serialization.Bundleable;
import androidx.lifecycle.t;

class RemoteUtils.SurfaceCallbackStub extends Stub {
    private final t mLifecycle;
    private final k mSurfaceCallback;

    public RemoteUtils.SurfaceCallbackStub(t t0, k k0) {
        this.mLifecycle = t0;
    }

    private Object lambda$onClick$7(float f, float f1) {
        throw null;
    }

    private Object lambda$onFling$5(float f, float f1) {
        throw null;
    }

    // 检测为 Lambda 实现
    private Object lambda$onScale$6(float f, float f1, float f2) [...]

    private Object lambda$onScroll$4(float f, float f1) {
        throw null;
    }

    private Object lambda$onStableAreaChanged$2(Rect rect0) {
        throw null;
    }

    private Object lambda$onSurfaceAvailable$0(Bundleable bundleable0) {
        SurfaceContainer surfaceContainer0 = (SurfaceContainer)bundleable0.a();
        throw null;
    }

    private Object lambda$onSurfaceDestroyed$3(Bundleable bundleable0) {
        SurfaceContainer surfaceContainer0 = (SurfaceContainer)bundleable0.a();
        throw null;
    }

    private Object lambda$onVisibleAreaChanged$1(Rect rect0) {
        throw null;
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onClick(float f, float f1) {
        d d0 = new d(this, f, f1, 0);
        h.a(new I7.k(this.mLifecycle, d0, "onClick", 6));
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onFling(float f, float f1) {
        d d0 = new d(this, f, f1, 2);
        h.a(new I7.k(this.mLifecycle, d0, "onFling", 6));
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onScale(float f, float f1, float f2) {
        f f3 = () -> throw null;
        h.a(new I7.k(this.mLifecycle, f3, "onScale", 6));
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onScroll(float f, float f1) {
        d d0 = new d(this, f, f1, 1);
        h.a(new I7.k(this.mLifecycle, d0, "onScroll", 6));
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onStableAreaChanged(Rect rect0, IOnDoneCallback iOnDoneCallback0) {
        e e0 = new e(this, rect0, 1);
        g.c(this.mLifecycle, iOnDoneCallback0, "onStableAreaChanged", e0);
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onSurfaceAvailable(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
        c c0 = new c(this, bundleable0, 1);
        g.c(this.mLifecycle, iOnDoneCallback0, "onSurfaceAvailable", c0);
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onSurfaceDestroyed(Bundleable bundleable0, IOnDoneCallback iOnDoneCallback0) {
        c c0 = new c(this, bundleable0, 0);
        g.c(this.mLifecycle, iOnDoneCallback0, "onSurfaceDestroyed", c0);
    }

    @Override  // androidx.car.app.ISurfaceCallback
    public void onVisibleAreaChanged(Rect rect0, IOnDoneCallback iOnDoneCallback0) {
        e e0 = new e(this, rect0, 0);
        g.c(this.mLifecycle, iOnDoneCallback0, "onVisibleAreaChanged", e0);
    }
}

