package zd;

import kotlin.jvm.internal.q;
import pe.b;

public enum l {
    Square,
    PortraitRectangle,
    LandscapeRectangle,
    Circle;

    public static final l[] e;

    static {
        l.e = arr_l;
        q.g(arr_l, "entries");
        new b(arr_l);
    }
}

