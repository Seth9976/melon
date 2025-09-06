package s3;

import I6.Q;
import I6.V;
import I6.p0;
import androidx.media3.exoplayer.K;
import e3.b;
import java.util.List;

public final class m implements X {
    public final p0 a;
    public long b;

    public m(List list0, List list1) {
        Q q0 = V.o();
        b.c(list0.size() == list1.size());
        for(int v = 0; v < list0.size(); ++v) {
            q0.a(new l(((X)list0.get(v)), ((List)list1.get(v))));
        }
        this.a = q0.g();
        this.b = 0x8000000000000001L;
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        boolean z = false;
        do {
            long v = this.getNextLoadPositionUs();
            if(v == 0x8000000000000000L) {
                return z;
            }
            boolean z1 = false;
            for(int v1 = 0; true; ++v1) {
                p0 p00 = this.a;
                if(v1 >= p00.d) {
                    break;
                }
                long v2 = ((l)p00.get(v1)).a.getNextLoadPositionUs();
                if(v2 == v || v2 != 0x8000000000000000L && v2 <= k0.a) {
                    z1 |= ((l)p00.get(v1)).a.b(k0);
                }
            }
            z |= z1;
        }
        while(z1);
        return z;
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        for(int v = 0; true; ++v) {
            p0 p00 = this.a;
            if(v >= p00.d) {
                break;
            }
            l l0 = (l)p00.get(v);
            long v3 = l0.a.getBufferedPositionUs();
            if((l0.b.contains(1) || l0.b.contains(2) || l0.b.contains(4)) && v3 != 0x8000000000000000L) {
                v1 = Math.min(v1, v3);
            }
            if(v3 != 0x8000000000000000L) {
                v2 = Math.min(v2, v3);
            }
        }
        if(v1 != 0x7FFFFFFFFFFFFFFFL) {
            this.b = v1;
            return v1;
        }
        if(v2 != 0x7FFFFFFFFFFFFFFFL) {
            return this.b == 0x8000000000000001L ? v2 : this.b;
        }
        return 0x8000000000000000L;
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(int v = 0; true; ++v) {
            p0 p00 = this.a;
            if(v >= p00.d) {
                break;
            }
            long v2 = ((l)p00.get(v)).a.getNextLoadPositionUs();
            if(v2 != 0x8000000000000000L) {
                v1 = Math.min(v1, v2);
            }
        }
        return v1 == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000000L : v1;
    }

    @Override  // s3.X
    public final boolean isLoading() {
        for(int v = 0; true; ++v) {
            p0 p00 = this.a;
            if(v >= p00.d) {
                break;
            }
            if(((l)p00.get(v)).a.isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        for(int v1 = 0; true; ++v1) {
            p0 p00 = this.a;
            if(v1 >= p00.d) {
                break;
            }
            ((l)p00.get(v1)).reevaluateBuffer(v);
        }
    }
}

