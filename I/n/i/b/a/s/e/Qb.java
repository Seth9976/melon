package i.n.i.b.a.s.e;

import A3.g;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack.Builder;
import android.media.AudioTrack;
import java.io.InputStream;
import java.util.ArrayList;
import rf.a;
import rf.d;
import rf.f;
import rf.o;
import rf.p;
import rf.s;

public final class qb {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final Object h;
    public final Object i;

    public qb(u u0, int v, int v1, int v2, int v3, int v4, int v5, boolean z, A6[] arr_a6) {
        int v6;
        this.h = u0;
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
        this.f = v5;
        this.i = arr_a6;
        boolean z1 = true;
        switch(v1) {
            case 0: {
                int v7 = AudioTrack.getMinBufferSize(v3, v4, v5);
                if(v7 == -2) {
                    z1 = false;
                }
                M7.J(z1);
                v6 = L7.d(v7 * 4, ((int)(250000L * ((long)v3) / 1000000L)) * v2, Math.max(v7, ((int)(750000L * ((long)v3) / 1000000L)) * v2));
                if((z ? 8.0f : 1.0f) != 1.0f) {
                    v6 = Math.round(((float)v6) * (z ? 8.0f : 1.0f));
                }
                break;
            }
            case 1: {
                v6 = this.c(50000000L);
                break;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                v6 = this.c(250000L);
                break;
            }
        }
        this.g = v6;
    }

    public qb(InputStream inputStream0) {
        this.f = 0x7FFFFFFF;
        this.h = new byte[0x1000];
        this.a = 0;
        this.c = 0;
        this.e = 0;
        this.i = inputStream0;
    }

    public AudioTrack a(boolean z, I4 i40, int v) {
        AudioTrack audioTrack0;
        int v1;
        try {
            v1 = this.b;
            audioTrack0 = this.b(z, i40, v);
        }
        catch(UnsupportedOperationException | IllegalArgumentException unsupportedOperationException0) {
            throw new t7(0, this.d, this.e, this.g, ((u)this.h), v1 == 1, unsupportedOperationException0);
        }
        int v2 = audioTrack0.getState();
        if(v2 == 1) {
            return audioTrack0;
        }
        try {
            audioTrack0.release();
        }
        catch(Exception unused_ex) {
        }
        throw new t7(v2, this.d, this.e, this.g, ((u)this.h), v1 == 1, null);
    }

    public AudioTrack b(boolean z, I4 i40, int v) {
        int v1 = this.f;
        int v2 = this.e;
        int v3 = this.d;
        int v4 = L7.a;
        boolean z1 = true;
        if(v4 >= 29) {
            AudioFormat audioFormat0 = ub.k(v3, v2, v1);
            AudioAttributes audioAttributes0 = z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : i40.a();
            AudioTrack.Builder audioTrack$Builder0 = new AudioTrack.Builder().setAudioAttributes(audioAttributes0).setAudioFormat(audioFormat0).setTransferMode(1).setBufferSizeInBytes(this.g).setSessionId(v);
            if(this.b != 1) {
                z1 = false;
            }
            return audioTrack$Builder0.setOffloadedPlayback(z1).build();
        }
        if(v4 >= 21) {
            return z ? new AudioTrack(new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build(), ub.k(v3, v2, v1), this.g, 1, v) : new AudioTrack(i40.a(), ub.k(v3, v2, v1), this.g, 1, v);
        }
        i40.getClass();
        return v == 0 ? new AudioTrack(3, this.d, this.e, this.f, this.g, 1) : new AudioTrack(3, this.d, this.e, this.f, this.g, 1, v);
    }

    public int c(long v) {
        int v2;
        int v1 = this.f;
        switch(v1) {
            case 5: {
                v2 = 80000;
                break;
            }
            case 7: {
                v2 = 192000;
                break;
            }
            case 8: {
                v2 = 2250000;
                break;
            }
            case 9: {
                v2 = 40000;
                break;
            }
            case 10: {
                v2 = 100000;
                break;
            }
            case 11: {
                v2 = 16000;
                break;
            }
            case 12: {
                v2 = 7000;
                break;
            }
            case 14: {
                v2 = 3062500;
                break;
            }
            case 15: {
                v2 = 8000;
                break;
            }
            case 16: {
                v2 = 256000;
                break;
            }
            case 17: {
                v2 = 336000;
                break;
            }
            case 6: 
            case 18: {
                v2 = 768000;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        if(v1 == 5) {
            v2 *= 2;
        }
        return (int)(v * ((long)v2) / 1000000L);
    }

    public void d(int v) {
        if(this.d != v) {
            throw new p("Protocol message end-group tag did not match expected tag.");
        }
    }

    public int e() {
        return this.f == 0x7FFFFFFF ? -1 : this.f - (this.e + this.c);
    }

    public void f(int v) {
        this.f = v;
        this.r();
    }

    public int g(int v) {
        if(v < 0) {
            throw new p("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int v1 = this.e + this.c + v;
        int v2 = this.f;
        if(v1 > v2) {
            throw p.b();
        }
        this.f = v1;
        this.r();
        return v2;
    }

    public s h() {
        int v = this.n();
        int v1 = this.c;
        if(v <= this.a - v1 && v > 0) {
            byte[] arr_b = new byte[v];
            System.arraycopy(((byte[])this.h), v1, arr_b, 0, v);
            s s0 = new s(arr_b);
            this.c += v;
            return s0;
        }
        return v == 0 ? d.a : new s(this.k(v));
    }

    public int i() {
        return this.n();
    }

    public a j(rf.u u0, f f0) {
        int v = this.n();
        if(this.g >= 0x40) {
            throw new p("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int v1 = this.g(v);
        ++this.g;
        a a0 = (a)u0.a(this, f0);
        this.d(0);
        --this.g;
        this.f(v1);
        return a0;
    }

    public byte[] k(int v) {
        byte[] arr_b = (byte[])this.h;
        if(v <= 0) {
            if(v != 0) {
                throw new p("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            return o.a;
        }
        int v1 = this.e;
        int v2 = this.c;
        int v3 = this.f;
        if(v1 + v2 + v <= v3) {
            if(v < 0x1000) {
                byte[] arr_b1 = new byte[v];
                int v4 = this.a - v2;
                System.arraycopy(arr_b, v2, arr_b1, 0, v4);
                this.c = this.a;
                int v5 = v - v4;
                if(v5 > 0) {
                    this.s(v5);
                }
                System.arraycopy(arr_b, 0, arr_b1, v4, v5);
                this.c = v5;
                return arr_b1;
            }
            int v6 = this.a;
            this.e = v1 + v6;
            this.c = 0;
            this.a = 0;
            int v7 = v6 - v2;
            int v8 = v - v7;
            ArrayList arrayList0 = new ArrayList();
            while(v8 > 0) {
                int v9 = Math.min(v8, 0x1000);
                byte[] arr_b2 = new byte[v9];
                for(int v10 = 0; v10 < v9; v10 += v11) {
                    int v11 = ((InputStream)this.i).read(arr_b2, v10, v9 - v10);
                    if(v11 == -1) {
                        throw p.b();
                    }
                    this.e += v11;
                }
                v8 -= v9;
                arrayList0.add(arr_b2);
            }
            byte[] arr_b3 = new byte[v];
            System.arraycopy(arr_b, v2, arr_b3, 0, v7);
            for(Object object0: arrayList0) {
                System.arraycopy(((byte[])object0), 0, arr_b3, v7, ((byte[])object0).length);
                v7 += ((byte[])object0).length;
            }
            return arr_b3;
        }
        this.u(v3 - v1 - v2);
        throw p.b();
    }

    public int l() {
        int v = this.c;
        if(this.a - v < 4) {
            this.s(4);
            v = this.c;
        }
        this.c = v + 4;
        return (((byte[])this.h)[v + 3] & 0xFF) << 24 | (((byte[])this.h)[v] & 0xFF | (((byte[])this.h)[v + 1] & 0xFF) << 8 | (((byte[])this.h)[v + 2] & 0xFF) << 16);
    }

    public long m() {
        int v = this.c;
        if(this.a - v < 8) {
            this.s(8);
            v = this.c;
        }
        this.c = v + 8;
        return (((long)((byte[])this.h)[v + 7]) & 0xFFL) << 56 | (((long)((byte[])this.h)[v]) & 0xFFL | (((long)((byte[])this.h)[v + 1]) & 0xFFL) << 8 | (((long)((byte[])this.h)[v + 2]) & 0xFFL) << 16 | (((long)((byte[])this.h)[v + 3]) & 0xFFL) << 24 | (((long)((byte[])this.h)[v + 4]) & 0xFFL) << 0x20 | (((long)((byte[])this.h)[v + 5]) & 0xFFL) << 40 | (((long)((byte[])this.h)[v + 6]) & 0xFFL) << 0x30);
    }

    public int n() {
        int v5;
        int v = this.c;
        int v1 = this.a;
        if(v1 != v) {
            byte[] arr_b = (byte[])this.h;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.c = v + 1;
                return v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                int v4 = arr_b[v + 1] << 7 ^ v2;
                if(((long)v4) < 0L) {
                    v5 = (int)(0xFFFFFFFFFFFFFF80L ^ ((long)v4));
                    this.c = v3;
                    return v5;
                }
                int v6 = v + 3;
                int v7 = arr_b[v3] << 14 ^ v4;
                if(((long)v7) >= 0L) {
                    v5 = (int)(0x3F80L ^ ((long)v7));
                    v3 = v6;
                    this.c = v3;
                    return v5;
                }
                int v8 = v + 4;
                int v9 = v7 ^ arr_b[v6] << 21;
                if(((long)v9) < 0L) {
                    v5 = (int)(0xFFFFFFFFFFE03F80L ^ ((long)v9));
                    v3 = v8;
                    this.c = v3;
                    return v5;
                }
                v6 = v + 5;
                int v10 = arr_b[v8];
                int v11 = (int)(((long)(v9 ^ v10 << 28)) ^ 0xFE03F80L);
                if(v10 >= 0) {
                    v3 = v6;
                    this.c = v3;
                    return v11;
                }
                v8 = v + 6;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.c = v3;
                    return v11;
                }
                v6 = v + 7;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.c = v3;
                    return v11;
                }
                v8 = v + 8;
                if(arr_b[v6] >= 0) {
                    v3 = v8;
                    this.c = v3;
                    return v11;
                }
                v6 = v + 9;
                if(arr_b[v8] >= 0) {
                    v3 = v6;
                    this.c = v3;
                    return v11;
                }
                else if(arr_b[v6] >= 0) {
                    v3 = v + 10;
                    this.c = v3;
                    return v11;
                }
            }
        }
        return (int)this.p();
    }

    public long o() {
        long v9;
        long v8;
        long v5;
        int v = this.c;
        int v1 = this.a;
        if(v1 != v) {
            byte[] arr_b = (byte[])this.h;
            int v2 = arr_b[v];
            if(v2 >= 0) {
                this.c = v + 1;
                return (long)v2;
            }
            if(v1 - (v + 1) >= 9) {
                int v3 = v + 2;
                long v4 = (long)(arr_b[v + 1] << 7 ^ v2);
                if(v4 < 0L) {
                    v5 = 0xFFFFFFFFFFFFFF80L;
                    v9 = v4 ^ v5;
                    this.c = v3;
                    return v9;
                }
                int v6 = v + 3;
                long v7 = v4 ^ ((long)(arr_b[v3] << 14));
                if(v7 >= 0L) {
                    v8 = 0x3F80L;
                    v9 = v7 ^ v8;
                    v3 = v6;
                    this.c = v3;
                    return v9;
                }
                v3 = v + 4;
                v4 = v7 ^ ((long)(arr_b[v6] << 21));
                if(v4 < 0L) {
                    v5 = 0xFFFFFFFFFFE03F80L;
                    v9 = v4 ^ v5;
                    this.c = v3;
                    return v9;
                }
                v6 = v + 5;
                v7 = v4 ^ ((long)arr_b[v3]) << 28;
                if(v7 >= 0L) {
                    v8 = 0xFE03F80L;
                    v9 = v7 ^ v8;
                    v3 = v6;
                    this.c = v3;
                    return v9;
                }
                v3 = v + 6;
                v4 = v7 ^ ((long)arr_b[v6]) << 35;
                if(v4 < 0L) {
                    v5 = 0xFFFFFFF80FE03F80L;
                    v9 = v4 ^ v5;
                    this.c = v3;
                    return v9;
                }
                v6 = v + 7;
                v7 = v4 ^ ((long)arr_b[v3]) << 42;
                if(v7 >= 0L) {
                    v8 = 0x3F80FE03F80L;
                    v9 = v7 ^ v8;
                    v3 = v6;
                    this.c = v3;
                    return v9;
                }
                v3 = v + 8;
                v4 = v7 ^ ((long)arr_b[v6]) << 49;
                if(v4 < 0L) {
                    v5 = 0xFFFE03F80FE03F80L;
                    v9 = v4 ^ v5;
                    this.c = v3;
                    return v9;
                }
                v6 = v + 9;
                long v10 = v4 ^ ((long)arr_b[v3]) << 56 ^ 0xFE03F80FE03F80L;
                if(v10 >= 0L) {
                    v3 = v6;
                    this.c = v3;
                    return v10;
                }
                v3 = v + 10;
                if(((long)arr_b[v6]) >= 0L) {
                    this.c = v3;
                    return v10;
                }
            }
        }
        return this.p();
    }

    public long p() {
        long v = 0L;
        for(int v1 = 0; v1 < 0x40; v1 += 7) {
            if(this.c == this.a) {
                this.s(1);
            }
            int v2 = this.c;
            this.c = v2 + 1;
            int v3 = ((byte[])this.h)[v2];
            v |= ((long)(v3 & 0x7F)) << v1;
            if((v3 & 0x80) == 0) {
                return v;
            }
        }
        throw new p("CodedInputStream encountered a malformed varint.");
    }

    public int q() {
        if(this.c == this.a && !this.v(1)) {
            this.d = 0;
            return 0;
        }
        int v = this.n();
        this.d = v;
        if(v >>> 3 == 0) {
            throw new p("Protocol message contained an invalid tag (zero).");
        }
        return v;
    }

    public void r() {
        int v = this.a + this.b;
        this.a = v;
        int v1 = this.e + v;
        int v2 = this.f;
        if(v1 > v2) {
            int v3 = v1 - v2;
            this.b = v3;
            this.a = v - v3;
            return;
        }
        this.b = 0;
    }

    public void s(int v) {
        if(!this.v(v)) {
            throw p.b();
        }
    }

    public boolean t(int v, g g0) {
        switch(v & 7) {
            case 0: {
                long v4 = this.o();
                g0.M(v);
                g0.N(v4);
                return true;
            }
            case 1: {
                long v5 = this.m();
                g0.M(v);
                g0.L(v5);
                return true;
            }
            default: {
                if((v & 7) != 2) {
                    switch(v & 7) {
                        case 3: {
                            g0.M(v);
                            do {
                                int v2 = this.q();
                            }
                            while(v2 != 0 && this.t(v2, g0));
                            int v3 = v >>> 3 << 3 | 4;
                            this.d(v3);
                            g0.M(v3);
                            return true;
                        }
                        case 4: {
                            return false;
                        }
                        default: {
                            if((v & 7) != 5) {
                                throw new p("Protocol message tag had invalid wire type.");
                            }
                            int v1 = this.l();
                            g0.M(v);
                            g0.K(v1);
                            return true;
                        }
                    }
                }
                s s0 = this.h();
                g0.M(v);
                g0.M(s0.size());
                g0.I(s0);
                return true;
            }
        }
    }

    public void u(int v) {
        int v6;
        int v1 = this.a;
        int v2 = this.c;
        int v3 = v1 - v2;
        if(v <= v3 && v >= 0) {
            this.c = v2 + v;
            return;
        }
        if(v < 0) {
            throw new p("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int v4 = this.e;
        int v5 = this.f;
        if(v4 + v2 + v <= v5) {
            this.c = v1;
            this.s(1);
            while(true) {
                v6 = v - v3;
                int v7 = this.a;
                if(v6 <= v7) {
                    break;
                }
                v3 += v7;
                this.c = v7;
                this.s(1);
            }
            this.c = v6;
            return;
        }
        this.u(v5 - v4 - v2);
        throw p.b();
    }

    public boolean v(int v) {
        InputStream inputStream0 = (InputStream)this.i;
        byte[] arr_b = (byte[])this.h;
        int v1 = this.c;
        int v2 = this.a;
        if(v1 + v <= v2) {
            throw new IllegalStateException("refillBuffer() called when " + v + " bytes were already available in buffer");
        }
        if(this.e + v1 + v > this.f) {
            return false;
        }
        if(inputStream0 != null) {
            if(v1 > 0) {
                if(v2 > v1) {
                    System.arraycopy(arr_b, v1, arr_b, 0, v2 - v1);
                }
                this.e += v1;
                this.a -= v1;
                this.c = 0;
            }
            int v3 = inputStream0.read(arr_b, this.a, arr_b.length - this.a);
            if(v3 == 0 || v3 < -1 || v3 > arr_b.length) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + v3 + "\nThe InputStream implementation is buggy.");
            }
            if(v3 > 0) {
                this.a += v3;
                if(this.e + v - 0x4000000 > 0) {
                    throw new p("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                this.r();
                return this.a < v ? this.v(v) : true;
            }
        }
        return false;
    }
}

