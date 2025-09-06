package Fc;

import com.iloen.melon.playback.playlist.PlaylistId;

public abstract class y {
    public static final int[] a;

    static {
        int[] arr_v = new int[PlaylistId.values().length];
        try {
            arr_v[PlaylistId.MUSIC.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[PlaylistId.SMART.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[PlaylistId.DRAWER.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[PlaylistId.MIX_UP.ordinal()] = 4;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[PlaylistId.STATION.ordinal()] = 5;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        y.a = arr_v;
    }
}

