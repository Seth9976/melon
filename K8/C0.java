package k8;

import com.iloen.melon.custom.f1;
import com.iloen.melon.playback.Actor;

public abstract class c0 {
    public static final int[] a;

    static {
        int[] arr_v = new int[Actor.values().length];
        try {
            arr_v[Actor.Widget_cover.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget_2x1.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget_2x2.ordinal()] = 4;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget_4x1.ordinal()] = 5;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            arr_v[Actor.Widget_4x2.ordinal()] = 6;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        c0.a = arr_v;
        new int[f1.values().length];
    }
}

