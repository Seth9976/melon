import com.iloen.melon.net.v5x.response.FlexibleRes.LogoType;

public abstract class c {
    public static final int[] a;

    static {
        int[] arr_v = new int[LogoType.values().length];
        try {
            arr_v[LogoType.STATION.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[LogoType.MAGAZINE.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[LogoType.MELON.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[LogoType.MELON_ONLY.ordinal()] = 4;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[LogoType.MUSIC_WAVE.ordinal()] = 5;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        c.a = arr_v;
    }
}

