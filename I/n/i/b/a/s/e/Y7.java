package i.n.i.b.a.s.e;

import android.os.SystemClock;
import android.text.TextUtils;

public final class y7 extends Exception {
    public final int a;
    public final String b;
    public final int c;
    public final u d;
    public final int e;
    public final long f;
    public final n1 g;
    public final boolean h;
    public final Throwable i;

    public y7(int v, Exception exception0) {
        this(v, exception0, null, -1, null, 4, false);
    }

    public y7(int v, Throwable throwable0, String s, int v1, u u0, int v2, boolean z) {
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
                    stringBuilder0.append(v1);
                    stringBuilder0.append(", format=");
                    stringBuilder0.append(u0);
                    stringBuilder0.append(", format_supported=");
                    switch(v2) {
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
                            if(v2 != 4) {
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
        this(s1, throwable0, v, s, v1, u0, v2, null, SystemClock.elapsedRealtime(), z);
    }

    public y7(String s, Throwable throwable0, int v, String s1, int v1, u u0, int v2, n1 n10, long v3, boolean z) {
        super(s, throwable0);
        M7.u(!z || v == 1);
        this.a = v;
        this.i = throwable0;
        this.b = s1;
        this.c = v1;
        this.d = u0;
        this.e = v2;
        this.g = n10;
        this.f = v3;
        this.h = z;
    }
}

