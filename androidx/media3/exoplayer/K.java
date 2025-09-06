package androidx.media3.exoplayer;

import e3.r;

public final class k implements L {
    public final j0 a;
    public final H b;
    public e c;
    public L d;
    public boolean e;
    public boolean f;

    public k(H h0, r r0) {
        this.b = h0;
        j0 j00 = new j0();  // 初始化器: Ljava/lang/Object;-><init>()V
        j00.d = r0;
        j00.e = b3.L.d;
        this.a = j00;
        this.e = true;
    }

    @Override  // androidx.media3.exoplayer.L
    public final void a(b3.L l0) {
        L l1 = this.d;
        if(l1 != null) {
            l1.a(l0);
            l0 = this.d.getPlaybackParameters();
        }
        this.a.a(l0);
    }

    @Override  // androidx.media3.exoplayer.L
    public final boolean b() {
        if(this.e) {
            this.a.getClass();
            return false;
        }
        L l0 = this.d;
        l0.getClass();
        return l0.b();
    }

    @Override  // androidx.media3.exoplayer.L
    public final b3.L getPlaybackParameters() {
        return this.d == null ? ((b3.L)this.a.e) : this.d.getPlaybackParameters();
    }

    @Override  // androidx.media3.exoplayer.L
    public final long getPositionUs() {
        if(this.e) {
            return this.a.getPositionUs();
        }
        L l0 = this.d;
        l0.getClass();
        return l0.getPositionUs();
    }
}

