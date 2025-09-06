package Nb;

import com.iloen.melon.playback.Actor;

public abstract class j {
    public static final int[] a;

    static {
        int[] arr_v = new int[Actor.values().length];
        try {
            arr_v[Actor.Widget_2x1.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget_2x2.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget_4x1.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        j.a = arr_v;
    }
}

