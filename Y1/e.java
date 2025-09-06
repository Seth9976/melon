package y1;

import d5.l;
import java.util.Arrays;

public final class e extends b {
    public f[] f;
    public f[] g;
    public int h;
    public l i;

    @Override  // y1.b
    public final f d(boolean[] arr_z) {
        int v1 = -1;
        for(int v = 0; v < this.h; ++v) {
            f[] arr_f = this.f;
            f f0 = arr_f[v];
            if(!arr_z[f0.b]) {
                l l0 = this.i;
                l0.b = f0;
                int v2 = 8;
                if(v1 == -1) {
                    while(v2 >= 0) {
                        float f1 = ((f)l0.b).h[v2];
                        if(f1 > 0.0f) {
                            break;
                        }
                        if(f1 < 0.0f) {
                            v1 = v;
                            break;
                        }
                        --v2;
                    }
                }
                else {
                    f f2 = arr_f[v1];
                    while(v2 >= 0) {
                        float f3 = f2.h[v2];
                        float f4 = ((f)l0.b).h[v2];
                        if(f4 != f3) {
                            if(f4 >= f3) {
                                break;
                            }
                            v1 = v;
                            break;
                        }
                        --v2;
                    }
                }
            }
        }
        return v1 == -1 ? null : this.f[v1];
    }

    @Override  // y1.b
    public final boolean e() {
        return this.h == 0;
    }

    @Override  // y1.b
    public final void i(c c0, b b0, boolean z) {
        f f0 = b0.a;
        if(f0 == null) {
            return;
        }
        float[] arr_f = f0.h;
        a a0 = b0.d;
        int v = a0.d();
        for(int v1 = 0; v1 < v; ++v1) {
            f f1 = a0.e(v1);
            float f2 = a0.f(v1);
            l l0 = this.i;
            l0.b = f1;
            if(f1.a) {
                boolean z1 = true;
                for(int v2 = 0; v2 < 9; ++v2) {
                    float[] arr_f1 = ((f)l0.b).h;
                    float f3 = arr_f[v2] * f2 + arr_f1[v2];
                    arr_f1[v2] = f3;
                    if(Math.abs(f3) < 0.0001f) {
                        ((f)l0.b).h[v2] = 0.0f;
                    }
                    else {
                        z1 = false;
                    }
                }
                if(z1) {
                    ((e)l0.c).k(((f)l0.b));
                }
            }
            else {
                for(int v3 = 0; v3 < 9; ++v3) {
                    float f4 = arr_f[v3];
                    if(f4 == 0.0f) {
                        ((f)l0.b).h[v3] = 0.0f;
                    }
                    else {
                        ((f)l0.b).h[v3] = Math.abs(f4 * f2) < 0.0001f ? 0.0f : f4 * f2;
                    }
                }
                this.j(f1);
            }
            this.b = b0.b * f2 + this.b;
        }
        this.k(f0);
    }

    public final void j(f f0) {
        int v3;
        f[] arr_f = this.f;
        if(this.h + 1 > arr_f.length) {
            f[] arr_f1 = (f[])Arrays.copyOf(arr_f, arr_f.length * 2);
            this.f = arr_f1;
            this.g = (f[])Arrays.copyOf(arr_f1, arr_f1.length * 2);
        }
        f[] arr_f2 = this.f;
        int v = this.h;
        arr_f2[v] = f0;
        this.h = v + 1;
        if(v + 1 > 1 && arr_f2[v].b > f0.b) {
            for(int v2 = 0; true; ++v2) {
                v3 = this.h;
                if(v2 >= v3) {
                    break;
                }
                this.g[v2] = this.f[v2];
            }
            Arrays.sort(this.g, 0, v3, new A1.f(16));
            for(int v1 = 0; v1 < this.h; ++v1) {
                this.f[v1] = this.g[v1];
            }
        }
        f0.a = true;
        f0.a(this);
    }

    public final void k(f f0) {
        int v1;
        for(int v = 0; v < this.h; ++v) {
            if(this.f[v] == f0) {
                while(true) {
                    v1 = this.h;
                    if(v >= v1 - 1) {
                        break;
                    }
                    this.f[v] = this.f[v + 1];
                    ++v;
                }
                this.h = v1 - 1;
                f0.a = false;
                return;
            }
        }
    }

    @Override  // y1.b
    public final String toString() {
        l l0 = this.i;
        String s = " goal -> (" + this.b + ") : ";
        for(int v = 0; v < this.h; ++v) {
            l0.b = this.f[v];
            s = s + l0 + " ";
        }
        return s;
    }
}

