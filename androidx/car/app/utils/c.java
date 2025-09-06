package androidx.car.app.utils;

import androidx.car.app.serialization.Bundleable;

public final class c implements a {
    public final int a;
    public final RemoteUtils.SurfaceCallbackStub b;
    public final Bundleable c;

    public c(RemoteUtils.SurfaceCallbackStub remoteUtils$SurfaceCallbackStub0, Bundleable bundleable0, int v) {
        this.a = v;
        this.b = remoteUtils$SurfaceCallbackStub0;
        this.c = bundleable0;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a == 0 ? this.b.lambda$onSurfaceDestroyed$3(this.c) : this.b.lambda$onSurfaceAvailable$0(this.c);
    }
}

