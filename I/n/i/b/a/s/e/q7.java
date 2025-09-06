package i.n.i.b.a.s.e;

import Y0.d;
import android.media.AudioTrack;
import j3.k;

public final class Q7 {
    public int a;
    public long b;
    public long c;
    public long d;
    public long e;
    public final Object f;

    public Q7(AudioTrack audioTrack0, int v) {
        if(v != 1) {
            super();
            if(L7.a >= 19) {
                this.f = new d(audioTrack0);
                this.b();
                return;
            }
            this.f = null;
            this.a(3);
            return;
        }
        super();
        this.f = new k(audioTrack0);
        this.c();
    }

    public void a(int v) {
        this.a = v;
        switch(v) {
            case 0: {
                this.d = 0L;
                this.e = -1L;
                this.b = System.nanoTime() / 1000L;
                this.c = 10000L;
                return;
            }
            case 1: {
                this.c = 10000L;
                return;
            }
            case 2: 
            case 3: {
                this.c = 10000000L;
                return;
            }
            case 4: {
                this.c = 500000L;
                return;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    public void b() {
        if(((d)this.f) != null) {
            this.a(0);
        }
    }

    public void c() {
        if(((k)this.f) != null) {
            this.d(0);
        }
    }

    public void d(int v) {
        this.a = v;
        switch(v) {
            case 0: {
                this.d = 0L;
                this.e = -1L;
                this.b = System.nanoTime() / 1000L;
                this.c = 10000L;
                return;
            }
            case 1: {
                this.c = 10000L;
                return;
            }
            case 2: 
            case 3: {
                this.c = 10000000L;
                return;
            }
            case 4: {
                this.c = 500000L;
                return;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
}

