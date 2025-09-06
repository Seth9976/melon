package androidx.car.app.utils;

public final class f implements a {
    public final RemoteUtils.SurfaceCallbackStub a;
    public final float b;
    public final float c;
    public final float d;

    public f(RemoteUtils.SurfaceCallbackStub remoteUtils$SurfaceCallbackStub0, float f, float f1, float f2) {
        this.a = remoteUtils$SurfaceCallbackStub0;
        this.b = f;
        this.c = f1;
        this.d = f2;
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a.lambda$onScale$6(this.b, this.c, this.d);
    }
}

