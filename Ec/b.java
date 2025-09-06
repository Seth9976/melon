package ec;

import com.iloen.melon.playback.playlist.PlaylistId;

public abstract class b {
    public static final int[] a;

    static {
        int[] arr_v = new int[PlaylistId.values().length];
        try {
            arr_v[PlaylistId.SMART.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[PlaylistId.DRAWER.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        b.a = arr_v;
    }
}

