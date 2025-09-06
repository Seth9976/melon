package androidx.car.app.utils;

import android.graphics.Rect;

public final class e implements a {
    public final int a;
    public final RemoteUtils.SurfaceCallbackStub b;
    public final Rect c;

    public e(RemoteUtils.SurfaceCallbackStub remoteUtils$SurfaceCallbackStub0, Rect rect0, int v) {
        this.a = v;
        this.b = remoteUtils$SurfaceCallbackStub0;
        this.c = rect0;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a == 0 ? this.b.lambda$onVisibleAreaChanged$1(this.c) : this.b.lambda$onStableAreaChanged$2(this.c);
    }
}

