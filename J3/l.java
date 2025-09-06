package j3;

import E9.g;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.SystemClock;
import com.iloen.melon.utils.a;
import e3.b;
import e3.r;
import e3.x;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.Q7;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import k8.Y;

public final class l {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public boolean G;
    public long H;
    public r I;
    public final Ga a;
    public final long[] b;
    public AudioTrack c;
    public int d;
    public Q7 e;
    public int f;
    public boolean g;
    public long h;
    public float i;
    public boolean j;
    public long k;
    public long l;
    public Method m;
    public long n;
    public boolean o;
    public boolean p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public int v;
    public int w;
    public long x;
    public long y;
    public long z;

    public l(Ga ga0) {
        this.a = ga0;
        try {
            this.m = AudioTrack.class.getMethod("getLatency", null);
        }
        catch(NoSuchMethodException unused_ex) {
        }
        this.b = new long[10];
        this.I = r.a;
    }

    public final long a(boolean z) {
        long v15;
        AudioTimestamp audioTimestamp1;
        boolean z2;
        s s0 = (s)this.a.b;
        AudioTrack audioTrack0 = this.c;
        audioTrack0.getClass();
        boolean z1 = false;
        if(audioTrack0.getPlayState() == 3) {
            this.I.getClass();
            long v = System.nanoTime();
            if(v / 1000L - this.l >= 30000L) {
                long v1 = this.b();
                long v2 = x.R(this.f, v1);
                if(v2 != 0L) {
                    long[] arr_v = this.b;
                    arr_v[this.v] = x.B(v2, this.i) - v / 1000L;
                    this.v = (this.v + 1) % 10;
                    int v3 = this.w;
                    if(v3 < 10) {
                        this.w = v3 + 1;
                    }
                    this.l = v / 1000L;
                    this.k = 0L;
                    int v4 = 0;
                    while(true) {
                        int v5 = this.w;
                        if(v4 >= v5) {
                            goto label_25;
                        }
                        this.k = arr_v[v4] / ((long)v5) + this.k;
                        ++v4;
                    }
                }
            }
            else {
            label_25:
                if(!this.g) {
                    Q7 q70 = this.e;
                    q70.getClass();
                    k k0 = (k)q70.f;
                    if(k0 == null) {
                        z2 = false;
                    }
                    else {
                        AudioTimestamp audioTimestamp0 = k0.b;
                        if(v / 1000L - q70.d >= q70.c) {
                            q70.d = v / 1000L;
                            z2 = k0.a.getTimestamp(audioTimestamp0);
                            if(z2) {
                                long v6 = audioTimestamp0.framePosition;
                                long v7 = k0.d;
                                if(v7 <= v6) {
                                    audioTimestamp1 = audioTimestamp0;
                                }
                                else if(k0.f) {
                                    audioTimestamp1 = audioTimestamp0;
                                    k0.g += v7;
                                    k0.f = false;
                                }
                                else {
                                    audioTimestamp1 = audioTimestamp0;
                                    ++k0.c;
                                }
                                k0.d = v6;
                                k0.e = v6 + k0.g + (k0.c << 0x20);
                            }
                            else {
                                audioTimestamp1 = audioTimestamp0;
                            }
                            switch(q70.a) {
                                case 0: {
                                    if(!z2) {
                                        if(v / 1000L - q70.b > 500000L) {
                                            q70.d(3);
                                        }
                                    }
                                    else if(audioTimestamp1.nanoTime / 1000L >= q70.b) {
                                        q70.e = k0.e;
                                        q70.d(1);
                                    }
                                    else {
                                        z2 = false;
                                    }
                                    break;
                                }
                                case 1: {
                                    if(!z2) {
                                        q70.c();
                                    }
                                    else if(k0.e > q70.e) {
                                        q70.d(2);
                                    }
                                    break;
                                }
                                case 2: {
                                    if(!z2) {
                                        q70.c();
                                    }
                                    break;
                                }
                                case 3: {
                                    if(z2) {
                                        q70.c();
                                    }
                                    break;
                                }
                                case 4: {
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                        else {
                            z2 = false;
                        }
                    }
                    if(z2) {
                        long v8 = k0 == null ? 0x8000000000000001L : k0.b.nanoTime / 1000L;
                        long v9 = k0 == null ? -1L : k0.e;
                        long v10 = this.b();
                        long v11 = x.R(this.f, v10);
                        if(Long.compare(Math.abs(v8 - v / 1000L), 5000000L) > 0) {
                            StringBuilder stringBuilder0 = Y.o(v9, "Spurious audio timestamp (system clock mismatch): ", ", ");
                            stringBuilder0.append(v8);
                            a.s(v / 1000L, ", ", ", ", stringBuilder0);
                            stringBuilder0.append(v11);
                            stringBuilder0.append(", ");
                            stringBuilder0.append(s0.j());
                            stringBuilder0.append(", ");
                            stringBuilder0.append(s0.k());
                            b.D("DefaultAudioSink", stringBuilder0.toString());
                            q70.d(4);
                        }
                        else if(Math.abs(x.R(this.f, v9) - v11) > 5000000L) {
                            StringBuilder stringBuilder1 = Y.o(v9, "Spurious audio timestamp (frame position mismatch): ", ", ");
                            stringBuilder1.append(v8);
                            a.s(v / 1000L, ", ", ", ", stringBuilder1);
                            stringBuilder1.append(v11);
                            stringBuilder1.append(", ");
                            stringBuilder1.append(s0.j());
                            stringBuilder1.append(", ");
                            stringBuilder1.append(s0.k());
                            b.D("DefaultAudioSink", stringBuilder1.toString());
                            q70.d(4);
                        }
                        else if(q70.a == 4) {
                            q70.c();
                        }
                    }
                    if(this.p) {
                        Method method0 = this.m;
                        if(method0 != null && v / 1000L - this.q >= 500000L) {
                            try {
                                AudioTrack audioTrack1 = this.c;
                                audioTrack1.getClass();
                                long v12 = Math.max(((long)(((int)(((Integer)method0.invoke(audioTrack1, null)))))) * 1000L - this.h, 0L);
                                this.n = v12;
                                if(v12 > 5000000L) {
                                    b.D("DefaultAudioSink", "Ignoring impossibly large audio latency: " + v12);
                                    this.n = 0L;
                                }
                            }
                            catch(Exception unused_ex) {
                                this.m = null;
                            }
                            this.q = v / 1000L;
                        }
                    }
                }
            }
        }
        this.I.getClass();
        long v13 = System.nanoTime();
        Q7 q71 = this.e;
        q71.getClass();
        k k1 = (k)q71.f;
        if(q71.a == 2) {
            z1 = true;
            long v14 = x.R(this.f, (k1 == null ? -1L : k1.e));
            v15 = x.x(v13 / 1000L - (k1 == null ? 0x8000000000000001L : k1.b.nanoTime / 1000L), this.i) + v14;
        }
        else {
            if(this.w == 0) {
                long v16 = this.b();
                v15 = x.R(this.f, v16);
            }
            else {
                v15 = x.x(this.k + v13 / 1000L, this.i);
            }
            if(!z) {
                v15 = Math.max(0L, v15 - this.n);
            }
        }
        if(this.D != z1) {
            this.F = this.C;
            this.E = this.B;
        }
        long v17 = v13 / 1000L - this.F;
        if(v17 < 1000000L) {
            long v18 = v17 * 1000L / 1000000L;
            v15 = ((1000L - v18) * (x.x(v17, this.i) + this.E) + v15 * v18) / 1000L;
        }
        if(!this.j) {
            long v19 = this.B;
            if(v15 > v19) {
                this.j = true;
                long v20 = x.B(x.Z(v15 - v19), this.i);
                this.I.getClass();
                long v21 = System.currentTimeMillis();
                long v22 = x.Z(v20);
                Ga ga0 = s0.r;
                if(ga0 != null) {
                    g g0 = ((u)ga0.b).Z0;
                    Handler handler0 = (Handler)g0.a;
                    if(handler0 != null) {
                        handler0.post(new j3.g(g0, v21 - v22));
                    }
                }
            }
        }
        this.C = v13 / 1000L;
        this.B = v15;
        this.D = z1;
        return v15;
    }

    public final long b() {
        this.I.getClass();
        long v = SystemClock.elapsedRealtime();
        if(Long.compare(this.x, 0x8000000000000001L) != 0) {
            AudioTrack audioTrack0 = this.c;
            audioTrack0.getClass();
            if(audioTrack0.getPlayState() == 2) {
                return this.z;
            }
            long v1 = x.T(x.x(x.M(v) - this.x, this.i), this.f, 1000000L, RoundingMode.UP);
            return Math.min(this.A, this.z + v1);
        }
        if(v - this.r >= 5L) {
            AudioTrack audioTrack1 = this.c;
            audioTrack1.getClass();
            int v2 = audioTrack1.getPlayState();
            if(v2 != 1) {
                long v3 = ((long)audioTrack1.getPlaybackHeadPosition()) & 0xFFFFFFFFL;
                if(this.g) {
                    if(v2 == 2 && v3 == 0L) {
                        this.u = this.s;
                    }
                    v3 += this.u;
                }
                long v4 = this.s;
                if(v4 > v3) {
                    if(this.G) {
                        this.H += v4;
                        this.G = false;
                    }
                    else {
                        ++this.t;
                    }
                }
                this.s = v3;
            }
            this.r = v;
        }
        return this.s + this.H + (this.t << 0x20);
    }

    public final boolean c(long v) {
        if(v <= x.T(this.a(false), this.f, 1000000L, RoundingMode.UP)) {
            if(this.g) {
                AudioTrack audioTrack0 = this.c;
                audioTrack0.getClass();
                return audioTrack0.getPlayState() == 2 && this.b() == 0L;
            }
            return false;
        }
        return true;
    }

    public final void d() {
        this.k = 0L;
        this.w = 0;
        this.v = 0;
        this.l = 0L;
        this.C = 0L;
        this.F = 0L;
        this.j = false;
    }
}

