package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.Arrays;

public final class Ud {
    public final int a;
    public final long[] b;
    public final Td[] c;
    public final long d;
    public static final Ud e;

    static {
        Ud.e = new Ud(new long[0], null, 0x8000000000000001L);
    }

    public Ud(long[] arr_v, Td[] arr_td, long v) {
        M7.u(arr_td == null || arr_td.length == arr_v.length);
        this.b = arr_v;
        this.d = v;
        this.a = arr_v.length;
        if(arr_td == null) {
            arr_td = new Td[arr_v.length];
            for(int v1 = 0; v1 < this.a; ++v1) {
                arr_td[v1] = new Td(-1, new int[0], new Uri[0], new long[0]);
            }
        }
        this.c = arr_td;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return Ud.class == class0 && this.a == ((Ud)object0).a && this.d == ((Ud)object0).d && Arrays.equals(this.b, ((Ud)object0).b) && Arrays.equals(this.c, ((Ud)object0).c);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.b);
        return Arrays.hashCode(this.c) + (v + (this.a * 0x745F + ((int)this.d)) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[");
        for(int v = 0; true; ++v) {
            Td[] arr_td = this.c;
            if(v >= arr_td.length) {
                break;
            }
            stringBuilder0.append("adGroup(timeUs=");
            stringBuilder0.append(this.b[v]);
            stringBuilder0.append(", ads=[");
            for(int v1 = 0; v1 < arr_td[v].c.length; ++v1) {
                stringBuilder0.append("ad(state=");
                switch(arr_td[v].c[v1]) {
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
                stringBuilder0.append(arr_td[v].d[v1]);
                stringBuilder0.append(')');
                if(v1 < arr_td[v].c.length - 1) {
                    stringBuilder0.append(", ");
                }
            }
            stringBuilder0.append("])");
            if(v < arr_td.length - 1) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("])");
        return stringBuilder0.toString();
    }
}

