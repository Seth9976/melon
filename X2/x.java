package X2;

import android.media.VolumeProvider;
import android.os.Build.VERSION;

public abstract class x {
    public final int a;
    public final int b;
    public final String c;
    public int d;
    public w e;
    public VolumeProvider f;

    public x(int v, int v1, int v2, String s) {
        this.a = v;
        this.b = v1;
        this.d = v2;
        this.c = s;
    }

    public final VolumeProvider a() {
        if(this.f == null) {
            if(Build.VERSION.SDK_INT >= 30) {
                this.f = new t(this.c, this.a, this.b, this.d, 0, this);
                return this.f;
            }
            this.f = new u(this, this.a, this.b, this.d, 0);
        }
        return this.f;
    }
}

