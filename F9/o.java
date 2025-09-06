package f9;

import com.iloen.melon.mcache.CachingJNI;
import h9.f;
import java.io.FilterInputStream;
import java.io.InputStream;

public final class o extends FilterInputStream {
    public final CachingJNI a;
    public final byte[] b;
    public int c;
    public byte[] d;
    public boolean e;

    public o(String s, long v, InputStream inputStream0) {
        super(inputStream0);
        this.b = new byte[0x2000];
        this.a = new CachingJNI(s, v);
    }

    @Override
    public final void close() {
        f.b("CryptoSkipInputStream", "Close CryptoSkipInputStream.");
        if(this.in != null) {
            this.in.close();
        }
        CachingJNI cachingJNI0 = this.a;
        if(cachingJNI0 != null) {
            cachingJNI0.close();
        }
    }

    @Override
    public final int read() {
        if(this.e) {
            byte[] arr_b = this.d;
            if(arr_b != null) {
                int v = this.c;
                if(v != arr_b.length) {
                    this.c = v + 1;
                    return arr_b[v] & 0xFF;
                }
            }
            return -1;
        }
        byte[] arr_b1 = this.d;
        if(arr_b1 != null) {
            int v1 = this.c;
            if(v1 < arr_b1.length) {
                this.c = v1 + 1;
                return arr_b1[v1] & 0xFF;
            }
        }
        this.c = 0;
        this.d = null;
        while(this.d == null) {
            int v2 = this.in.read(this.b);
            if(v2 == -1) {
                this.e = true;
                return this.read();
            }
            byte[] arr_b2 = this.a.f(this.b, v2);
            this.d = arr_b2;
            if(arr_b2 == null) {
                throw new NullPointerException("outputBuffer is null.");
            }
            if(false) {
                break;
            }
        }
        return this.read();
    }

    @Override
    public final int read(byte[] arr_b) {
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        if(this.in == null) {
            throw new NullPointerException("InputStream is null");
        }
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            int v3 = this.read();
            if(v3 == -1) {
                return v2 == 0 ? -1 : v2;
            }
            if(arr_b != null) {
                arr_b[v + v2] = (byte)v3;
            }
        }
        return v2;
    }

    @Override
    public final long skip(long v) {
        if(v > 0L && this.in != null) {
            int v1 = (int)Math.min(0x2000L, v);
            byte[] arr_b = new byte[v1];
            long v2;
            for(v2 = v; v2 > 0L; v2 -= (long)v3) {
                int v3 = this.in.read(arr_b, 0, ((int)Math.min(v1, v2)));
                if(v3 < 0) {
                    break;
                }
            }
            return v - v2;
        }
        return 0L;
    }
}

