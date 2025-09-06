package i.n.i.b.a.s.e;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

public final class G8 {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public final Ga a;
    public final long[] b;
    public AudioTrack c;
    public int d;
    public int e;
    public Q7 f;
    public int g;
    public boolean h;
    public long i;
    public float j;
    public boolean k;
    public long l;
    public long m;
    public Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public long u;
    public int v;
    public int w;
    public long x;
    public long y;
    public long z;

    public G8(Ga ga0) {
        this.a = ga0;
        if(L7.a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            }
            catch(NoSuchMethodException unused_ex) {
            }
        }
        this.b = new long[10];
    }

    public final long a() {
        AudioTrack audioTrack0 = this.c;
        audioTrack0.getClass();
        if(this.x != 0x8000000000000001L) {
            long v = SystemClock.elapsedRealtime();
            return Math.min(this.A, this.z + (v * 1000L - this.x) * ((long)this.g) / 1000000L);
        }
        int v1 = audioTrack0.getPlayState();
        if(v1 == 1) {
            return 0L;
        }
        long v2 = ((long)audioTrack0.getPlaybackHeadPosition()) & 0xFFFFFFFFL;
        if(this.h) {
            if(v1 == 2 && v2 == 0L) {
                this.u = this.s;
            }
            v2 += this.u;
        }
        if(L7.a <= 29) {
            if(v2 == 0L && this.s > 0L && v1 == 3) {
                if(this.y == 0x8000000000000001L) {
                    this.y = SystemClock.elapsedRealtime();
                }
                return this.s;
            }
            this.y = 0x8000000000000001L;
        }
        if(this.s > v2) {
            ++this.t;
        }
        this.s = v2;
        return v2 + (this.t << 0x20);
    }

    public final boolean b(long v) {
        if(v <= this.a()) {
            if(this.h) {
                AudioTrack audioTrack0 = this.c;
                audioTrack0.getClass();
                return audioTrack0.getPlayState() == 2 && this.a() == 0L;
            }
            return false;
        }
        return true;
    }
}

