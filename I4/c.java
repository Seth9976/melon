package i4;

import B3.L;
import B3.r;
import B3.s;
import B3.t;
import B3.v;
import V3.d;
import android.util.Pair;
import androidx.media3.session.N;
import b3.I;
import e3.p;
import e3.x;
import g3.i;

public final class c implements r {
    public t a;
    public L b;
    public int c;
    public long d;
    public b e;
    public int f;
    public long g;

    static {
    }

    public c() {
        this.c = 0;
        this.d = -1L;
        this.f = -1;
        this.g = -1L;
    }

    @Override  // B3.r
    public final int a(s s0, v v0) {
        int v9;
        byte[] arr_b;
        long v1 = -1L;
        e3.b.k(this.b);
        boolean z = true;
        switch(this.c) {
            case 0: {
                e3.b.j(s0.getPosition() == 0L);
                int v2 = this.f;
                if(v2 != -1) {
                    s0.skipFully(v2);
                    this.c = 4;
                    return 0;
                }
                if(!e1.b.p(s0)) {
                    throw I.a(null, "Unsupported or unrecognized wav file type.");
                }
                s0.skipFully(((int)(s0.getPeekPosition() - s0.getPosition())));
                this.c = 1;
                return 0;
            }
            case 1: {
                p p0 = new p(8);
                N n0 = N.a(s0, p0);
                if(n0.a == 0x64733634) {
                    s0.advancePeekPosition(8);
                    p0.G(0);
                    s0.peekFully(p0.a, 0, 8);
                    v1 = p0.j();
                    s0.skipFully(((int)n0.b) + 8);
                }
                else {
                    s0.resetPeekPosition();
                }
                this.d = v1;
                this.c = 2;
                return 0;
            }
            case 2: {
                p p1 = new p(16);
                long v3 = e1.b.L(0x666D7420, s0, p1).b;
                e3.b.j(v3 >= 16L);
                s0.peekFully(p1.a, 0, 16);
                p1.G(0);
                int v4 = p1.n();
                int v5 = p1.n();
                int v6 = p1.m();
                p1.m();
                int v7 = p1.n();
                int v8 = p1.n();
                if(((int)v3) - 16 > 0) {
                    arr_b = new byte[((int)v3) - 16];
                    s0.peekFully(arr_b, 0, ((int)v3) - 16);
                }
                else {
                    arr_b = x.f;
                }
                s0.skipFully(((int)(s0.getPeekPosition() - s0.getPosition())));
                d d0 = new d(v4, v5, v6, v7, v8, arr_b);
                if(v4 == 17) {
                    this.e = new a(this.a, this.b, d0);
                }
                else {
                    switch(v4) {
                        case 1: {
                            v9 = x.z(v8);
                            goto label_59;
                        }
                        case 3: {
                            v9 = v8 == 0x20 ? 4 : 0;
                        label_59:
                            if(v9 == 0) {
                                throw I.c(("Unsupported WAV format type: " + v4));
                            }
                            this.e = new i(this.a, this.b, d0, "audio/raw", v9);
                            break;
                        }
                        case 6: {
                            this.e = new i(this.a, this.b, d0, "audio/g711-alaw", -1);
                            break;
                        }
                        case 7: {
                            this.e = new i(this.a, this.b, d0, "audio/g711-mlaw", -1);
                            break;
                        }
                        default: {
                            v9 = v4 == 0xFFFE ? x.z(v8) : 0;
                            goto label_59;
                        }
                    }
                }
                this.c = 3;
                return 0;
            }
            case 3: {
                s0.resetPeekPosition();
                N n1 = e1.b.L(1684108385, s0, new p(8));
                s0.skipFully(8);
                Pair pair0 = Pair.create(s0.getPosition(), n1.b);
                this.f = ((Long)pair0.first).intValue();
                long v10 = (long)(((Long)pair0.second));
                long v11 = this.d;
                if(v11 != -1L && v10 == 0xFFFFFFFFL) {
                    v10 = v11;
                }
                this.g = ((long)this.f) + v10;
                long v12 = s0.getLength();
                if(v12 != -1L && this.g > v12) {
                    e3.b.D("WavExtractor", "Data exceeds input length: " + this.g + ", " + v12);
                    this.g = v12;
                }
                b b0 = this.e;
                b0.getClass();
                b0.init(this.f, this.g);
                this.c = 4;
                return 0;
            }
            case 4: {
                if(this.g == -1L) {
                    z = false;
                }
                e3.b.j(z);
                long v13 = this.g;
                long v14 = s0.getPosition();
                b b1 = this.e;
                b1.getClass();
                return b1.a(s0, v13 - v14) ? -1 : 0;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    @Override  // B3.r
    public final boolean c(s s0) {
        return e1.b.p(s0);
    }

    @Override  // B3.r
    public final void d(t t0) {
        this.a = t0;
        this.b = t0.track(0, 1);
        t0.endTracks();
    }

    @Override  // B3.r
    public final void release() {
    }

    @Override  // B3.r
    public final void seek(long v, long v1) {
        this.c = v == 0L ? 0 : 4;
        b b0 = this.e;
        if(b0 != null) {
            b0.reset(v1);
        }
    }
}

