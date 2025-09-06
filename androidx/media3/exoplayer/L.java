package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.b;
import b3.K;
import java.util.Objects;
import s3.z;

public final class l extends K {
    public static final String B;
    public static final String D;
    public static final String E;
    public static final String G;
    public static final String I;
    public final int j;
    public final String k;
    public final int l;
    public final b m;
    public final int n;
    public final z o;
    public final boolean r;
    public static final String w;

    static {
        l.w = "rt";
        l.B = "ru";
        l.D = "rv";
        l.E = "rw";
        l.G = "rx";
        l.I = "ry";
    }

    public l(int v, Exception exception0, int v1) {
        this(v, exception0, v1, null, -1, null, 4, false);
    }

    public l(int v, Exception exception0, int v1, String s, int v2, b b0, int v3, boolean z) {
        String s1;
        String s2;
        if(v == 0) {
            s1 = "Source error";
        }
        else {
            switch(v) {
                case 1: {
                    StringBuilder stringBuilder0 = new StringBuilder();
                    stringBuilder0.append(s);
                    stringBuilder0.append(" error, index=");
                    stringBuilder0.append(v2);
                    stringBuilder0.append(", format=");
                    stringBuilder0.append(b0);
                    stringBuilder0.append(", format_supported=");
                    switch(v3) {
                        case 0: {
                            s2 = "NO";
                            break;
                        }
                        case 1: {
                            s2 = "NO_UNSUPPORTED_TYPE";
                            break;
                        }
                        case 2: {
                            s2 = "NO_UNSUPPORTED_DRM";
                            break;
                        }
                        case 3: {
                            s2 = "NO_EXCEEDS_CAPABILITIES";
                            break;
                        }
                        default: {
                            if(v3 != 4) {
                                throw new IllegalStateException();
                            }
                            s2 = "YES";
                            break;
                        }
                    }
                    stringBuilder0.append(s2);
                    s1 = stringBuilder0.toString();
                    break;
                }
                case 3: {
                    s1 = "Remote error";
                    break;
                }
                default: {
                    s1 = "Unexpected runtime error";
                }
            }
        }
        if(!TextUtils.isEmpty(null)) {
            s1 = s1 + ": null";
        }
        this(s1, exception0, v1, v, s, v2, b0, v3, null, SystemClock.elapsedRealtime(), z);
    }

    public l(String s, Throwable throwable0, int v, int v1, String s1, int v2, b b0, int v3, z z0, long v4, boolean z1) {
        super(s, throwable0, v, Bundle.EMPTY, v4);
        boolean z2 = false;
        e3.b.c(!z1 || v1 == 1);
        if(throwable0 != null || v1 == 3) {
            z2 = true;
        }
        e3.b.c(z2);
        this.j = v1;
        this.k = s1;
        this.l = v2;
        this.m = b0;
        this.n = v3;
        this.o = z0;
        this.r = z1;
    }

    // 去混淆评级： 低(40)
    @Override  // b3.K
    public final boolean a(K k0) {
        return super.a(k0) && this.j == ((l)k0).j && Objects.equals(this.k, ((l)k0).k) && this.l == ((l)k0).l && Objects.equals(this.m, ((l)k0).m) && this.n == ((l)k0).n && Objects.equals(this.o, ((l)k0).o) && this.r == ((l)k0).r;
    }

    @Override  // b3.K
    public final Bundle c() {
        Bundle bundle0 = super.c();
        bundle0.putInt(l.w, this.j);
        bundle0.putString(l.B, this.k);
        bundle0.putInt(l.D, this.l);
        b b0 = this.m;
        if(b0 != null) {
            Bundle bundle1 = b0.c(false);
            bundle0.putBundle(l.E, bundle1);
        }
        bundle0.putInt(l.G, this.n);
        bundle0.putBoolean(l.I, this.r);
        return bundle0;
    }

    public final l d(z z0) {
        return new l(this.getMessage(), this.getCause(), this.a, this.j, this.k, this.l, this.m, this.n, z0, this.b, this.r);
    }
}

