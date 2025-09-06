package e3;

import android.util.Pair;
import b3.i;
import com.iloen.melon.utils.a;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class c {
    public static final byte[] a;
    public static final String[] b;
    public static final Pattern c;

    static {
        c.a = new byte[]{0, 0, 0, 1};
        c.b = new String[]{"", "A", "B", "C"};
        c.c = Pattern.compile("^\\D?(\\d+)$");
    }

    public static String a(int v, boolean z, int v1, int v2, int[] arr_v, int v3) {
        StringBuilder stringBuilder0 = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", c.b[v], v1, v2, Character.valueOf(((char)(z ? 72 : 76))), v3));
        int v4;
        for(v4 = arr_v.length; v4 > 0 && arr_v[v4 - 1] == 0; --v4) {
        }
        for(int v5 = 0; v5 < v4; ++v5) {
            stringBuilder0.append(String.format(".%02X", ((int)arr_v[v5])));
        }
        return stringBuilder0.toString();
    }

    public static Pair b(String s, String[] arr_s, i i0) {
        Integer integer0;
        int v;
        if(arr_s.length < 4) {
            a.w("Ignoring malformed HEVC codec string: ", s, "CodecSpecificDataUtil");
            return null;
        }
        Matcher matcher0 = c.c.matcher(arr_s[1]);
        if(!matcher0.matches()) {
            a.w("Ignoring malformed HEVC codec string: ", s, "CodecSpecificDataUtil");
            return null;
        }
        String s1 = matcher0.group(1);
        if("1".equals(s1)) {
            v = 1;
            goto label_19;
        }
        boolean z = false;
        if("2".equals(s1)) {
            z = true;
            if(i0 != null && i0.c == 6) {
                v = 0x1000;
                goto label_19;
            }
            v = 2;
        }
        else if("6".equals(s1)) {
            z = true;
            v = 6;
        }
        if(z) {
        label_19:
            String s2 = arr_s[3];
            if(s2 == null) {
                integer0 = null;
            }
            else {
                switch(s2) {
                    case "H120": {
                        return new Pair(v, 0x800);
                    }
                    case "H123": {
                        return new Pair(v, 0x2000);
                    }
                    case "H150": {
                        return new Pair(v, 0x8000);
                    }
                    case "H153": {
                        return new Pair(v, 0x20000);
                    }
                    case "H156": {
                        return new Pair(v, 0x80000);
                    }
                    case "H180": {
                        return new Pair(v, 0x200000);
                    }
                    case "H183": {
                        return new Pair(v, 0x800000);
                    }
                    case "H186": {
                        return new Pair(v, 0x2000000);
                    }
                    case "H30": {
                        integer0 = 2;
                        break;
                    }
                    case "H60": {
                        return new Pair(v, 8);
                    }
                    case "H63": {
                        return new Pair(v, 0x20);
                    }
                    case "H90": {
                        return new Pair(v, 0x80);
                    }
                    case "H93": {
                        return new Pair(v, 0x200);
                    }
                    case "L120": {
                        return new Pair(v, 0x400);
                    }
                    case "L123": {
                        return new Pair(v, 0x1000);
                    }
                    case "L150": {
                        return new Pair(v, 0x4000);
                    }
                    case "L153": {
                        return new Pair(v, 0x10000);
                    }
                    case "L156": {
                        return new Pair(v, 0x40000);
                    }
                    case "L180": {
                        return new Pair(v, 0x100000);
                    }
                    case "L183": {
                        return new Pair(v, 0x400000);
                    }
                    case "L186": {
                        return new Pair(v, 0x1000000);
                    }
                    case "L30": {
                        return new Pair(v, 1);
                    }
                    case "L60": {
                        return new Pair(v, 4);
                    }
                    case "L63": {
                        return new Pair(v, 16);
                    }
                    case "L90": {
                        return new Pair(v, 0x40);
                    }
                    case "L93": {
                        return new Pair(v, 0x100);
                    }
                    default: {
                        integer0 = null;
                        break;
                    }
                }
            }
            if(integer0 == null) {
                a.w("Unknown HEVC level string: ", s2, "CodecSpecificDataUtil");
                return null;
            }
            return new Pair(v, integer0);
        }
        a.w("Unknown HEVC profile string: ", s1, "CodecSpecificDataUtil");
        return null;
    }
}

