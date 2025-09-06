package l3;

import B3.K;
import B3.L;
import M3.a;
import androidx.media3.common.b;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import b3.j;
import e3.p;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Objects;

public final class n implements L {
    public final L a;
    public final b b;
    public b c;
    public byte[] d;
    public int e;
    public static final b f;
    public static final b g;

    static {
        b3.n n0 = new b3.n();
        n0.m = "application/id3";
        n.f = new b(n0);
        b3.n n1 = new b3.n();
        n1.m = "application/x-emsg";
        n.g = new b(n1);
    }

    public n(L l0, int v) {
        this.a = l0;
        switch(v) {
            case 1: {
                this.b = n.f;
                break;
            }
            case 3: {
                this.b = n.g;
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown metadataType: " + v);
            }
        }
        this.d = new byte[0];
        this.e = 0;
    }

    @Override  // B3.L
    public final int a(j j0, int v, boolean z) {
        int v1 = this.e + v;
        byte[] arr_b = this.d;
        if(arr_b.length < v1) {
            this.d = Arrays.copyOf(arr_b, v1 / 2 + v1);
        }
        int v2 = j0.read(this.d, this.e, v);
        if(v2 == -1) {
            if(!z) {
                throw new EOFException();
            }
            return -1;
        }
        this.e += v2;
        return v2;
    }

    @Override  // B3.L
    public final void b(b b0) {
        this.c = b0;
        this.a.b(this.b);
    }

    @Override  // B3.L
    public final void c(long v, int v1, int v2, int v3, K k0) {
        this.c.getClass();
        int v4 = this.e - v3;
        p p0 = new p(Arrays.copyOfRange(this.d, v4 - v2, v4));
        System.arraycopy(this.d, v4, this.d, 0, v3);
        this.e = v3;
        String s = this.b.n;
        if(!Objects.equals(this.c.n, this.b.n)) {
            if("application/x-emsg".equals(this.c.n)) {
                EventMessage eventMessage0 = a.g0(p0);
                b b0 = eventMessage0.getWrappedMetadataFormat();
                if(b0 != null && Objects.equals(s, b0.n)) {
                    byte[] arr_b = eventMessage0.getWrappedMetadataBytes();
                    arr_b.getClass();
                    p0 = new p(arr_b);
                    goto label_19;
                }
                e3.b.D("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + s + " but actual wrapped format: " + eventMessage0.getWrappedMetadataFormat());
                return;
            }
            e3.b.D("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.c.n);
            return;
        }
    label_19:
        int v5 = p0.a();
        this.a.d(p0, v5, 0);
        this.a.c(v, v1, v5, 0, k0);
    }

    @Override  // B3.L
    public final void d(p p0, int v, int v1) {
        int v2 = this.e + v;
        byte[] arr_b = this.d;
        if(arr_b.length < v2) {
            this.d = Arrays.copyOf(arr_b, v2 / 2 + v2);
        }
        p0.e(this.d, this.e, v);
        this.e += v;
    }
}

