package b3;

import java.util.Arrays;

public final class b {
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final a[] e;
    public static final b f;
    public static final a g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;

    static {
        b.f = new b(new a[0], 0L, 0x8000000000000001L, 0);
        a a0 = new a(0L, -1, -1, new int[0], new E[0], new long[0], 0L, false);
        int v = Math.max(0, a0.f.length);
        int[] arr_v = Arrays.copyOf(a0.f, v);
        Arrays.fill(arr_v, a0.f.length, v, 0);
        int v1 = Math.max(0, a0.g.length);
        long[] arr_v1 = Arrays.copyOf(a0.g, v1);
        Arrays.fill(arr_v1, a0.g.length, v1, 0x8000000000000001L);
        Object[] arr_object = Arrays.copyOf(a0.e, 0);
        b.g = new a(a0.a, 0, a0.c, arr_v, ((E[])arr_object), arr_v1, a0.h, a0.i);
        b.h = "1";
        b.i = "2";
        b.j = "3";
        b.k = "4";
    }

    public b(a[] arr_a, long v, long v1, int v2) {
        this.b = v;
        this.c = v1;
        this.a = arr_a.length + v2;
        this.e = arr_a;
        this.d = v2;
    }

    public final a a(int v) {
        return v >= this.d ? this.e[v - this.d] : b.g;
    }

    public final boolean b(int v) {
        if(v == this.a - 1) {
            a a0 = this.a(v);
            return a0.i && a0.a == 0x8000000000000000L && a0.b == -1;
        }
        return false;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return b.class == class0 && this.a == ((b)object0).a && this.b == ((b)object0).b && this.c == ((b)object0).c && this.d == ((b)object0).d && Arrays.equals(this.e, ((b)object0).e);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.e) + (((this.a * 961 + ((int)this.b)) * 0x1F + ((int)this.c)) * 0x1F + this.d) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", adGroups=[");
        for(int v = 0; true; ++v) {
            a[] arr_a = this.e;
            if(v >= arr_a.length) {
                break;
            }
            stringBuilder0.append("adGroup(timeUs=");
            stringBuilder0.append(arr_a[v].a);
            stringBuilder0.append(", ads=[");
            for(int v1 = 0; v1 < arr_a[v].f.length; ++v1) {
                stringBuilder0.append("ad(state=");
                switch(arr_a[v].f[v1]) {
                    case 0: {
                        stringBuilder0.append('_');
                        break;
                    }
                    case 1: {
                        stringBuilder0.append('R');
                        break;
                    }
                    case 2: {
                        stringBuilder0.append('S');
                        break;
                    }
                    case 3: {
                        stringBuilder0.append('P');
                        break;
                    }
                    case 4: {
                        stringBuilder0.append('!');
                        break;
                    }
                    default: {
                        stringBuilder0.append('?');
                    }
                }
                stringBuilder0.append(", durationUs=");
                stringBuilder0.append(arr_a[v].g[v1]);
                stringBuilder0.append(')');
                if(v1 < arr_a[v].f.length - 1) {
                    stringBuilder0.append(", ");
                }
            }
            stringBuilder0.append("])");
            if(v < arr_a.length - 1) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("])");
        return stringBuilder0.toString();
    }
}

