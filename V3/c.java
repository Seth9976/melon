package v3;

import E1.a;
import android.os.SystemClock;
import androidx.media3.common.b;
import b3.q0;
import java.util.Arrays;
import java.util.List;

public abstract class c implements o {
    public final q0 a;
    public final int b;
    public final int[] c;
    public final b[] d;
    public final long[] e;
    public int f;

    public c(q0 q00, int[] arr_v) {
        e3.b.j(arr_v.length > 0);
        int v2;
        q00.getClass();
        this.a = q00;
        this.b = arr_v.length;
        this.d = new b[arr_v.length];
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            this.d[v1] = q00.d[arr_v[v1]];
        }
        a a0 = new a(17);
        Arrays.sort(this.d, a0);
        this.c = new int[this.b];
        for(int v = 0; true; ++v) {
            v2 = this.b;
            if(v >= v2) {
                break;
            }
            this.c[v] = q00.b(this.d[v]);
        }
        this.e = new long[v2];
    }

    @Override  // v3.o
    public final boolean a(int v, long v1) {
        return this.e[v] > v1;
    }

    @Override  // v3.o
    public final boolean c(int v, long v1) {
        long v2 = SystemClock.elapsedRealtime();
        boolean z = this.a(v, v2);
        for(int v3 = 0; v3 < this.b && !z; ++v3) {
            z = v3 != v && !this.a(v3, v2);
        }
        if(!z) {
            return false;
        }
        long v4 = v2 + v1;
        this.e[v] = Math.max(this.e[v], (((v1 ^ v4) & (v2 ^ v4)) >= 0L ? v2 + v1 : 0x7FFFFFFFFFFFFFFFL));
        return true;
    }

    @Override  // v3.o
    public void disable() {
    }

    @Override  // v3.o
    public final void e(boolean z) {
    }

    @Override  // v3.o
    public void enable() {
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.a.equals(((c)object0).a) && Arrays.equals(this.c, ((c)object0).c);
    }

    @Override  // v3.o
    public int evaluateQueueSize(long v, List list0) {
        return list0.size();
    }

    @Override  // v3.o
    public final b getFormat(int v) {
        return this.d[v];
    }

    @Override  // v3.o
    public final int getIndexInTrackGroup(int v) {
        return this.c[v];
    }

    @Override  // v3.o
    public final b getSelectedFormat() {
        return this.d[this.getSelectedIndex()];
    }

    @Override  // v3.o
    public final int getSelectedIndexInTrackGroup() {
        return this.c[this.getSelectedIndex()];
    }

    @Override  // v3.o
    public final q0 getTrackGroup() {
        return this.a;
    }

    @Override
    public final int hashCode() {
        if(this.f == 0) {
            this.f = Arrays.hashCode(this.c) + System.identityHashCode(this.a) * 0x1F;
        }
        return this.f;
    }

    @Override  // v3.o
    public final int indexOf(int v) {
        for(int v1 = 0; v1 < this.b; ++v1) {
            if(this.c[v1] == v) {
                return v1;
            }
        }
        return -1;
    }

    @Override  // v3.o
    public final int length() {
        return this.c.length;
    }

    @Override  // v3.o
    public void onPlaybackSpeed(float f) {
    }
}

