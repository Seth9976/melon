package ob;

import com.iloen.melon.playback.playlist.PlaylistId;
import oc.M;

public abstract class b {
    public static final int[] a;

    static {
        new int[M.values().length];
        int[] arr_v = new int[PlaylistId.values().length];
        try {
            arr_v[PlaylistId.VOD.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        b.a = arr_v;
    }
}

