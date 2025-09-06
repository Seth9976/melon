package tg;

public final class h implements g {
    public final int a;
    public final j b;

    public h(j j0, int v) {
        this.a = v;
        this.b = j0;
        super();
    }

    @Override  // tg.g
    public final void onFailure(d d0, Throwable throwable0) {
        if(this.a != 0) {
            this.b.completeExceptionally(throwable0);
            return;
        }
        this.b.completeExceptionally(throwable0);
    }

    @Override  // tg.g
    public final void onResponse(d d0, Q q0) {
        if(this.a != 0) {
            this.b.complete(q0);
            return;
        }
        j j0 = this.b;
        if(q0.a.isSuccessful()) {
            j0.complete(q0.b);
            return;
        }
        j0.completeExceptionally(new p(q0));
    }
}

