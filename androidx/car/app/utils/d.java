package androidx.car.app.utils;

public final class d implements a {
    public final int a;
    public final RemoteUtils.SurfaceCallbackStub b;
    public final float c;
    public final float d;

    public d(RemoteUtils.SurfaceCallbackStub remoteUtils$SurfaceCallbackStub0, float f, float f1, int v) {
        this.a = v;
        this.b = remoteUtils$SurfaceCallbackStub0;
        this.c = f;
        this.d = f1;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        switch(this.a) {
            case 0: {
                return this.b.lambda$onClick$7(this.c, this.d);
            }
            case 1: {
                return this.b.lambda$onScroll$4(this.c, this.d);
            }
            default: {
                return this.b.lambda$onFling$5(this.c, this.d);
            }
        }
    }
}

