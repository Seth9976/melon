package je;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.q;

public abstract class t extends s {
    public static void R(List list0) {
        if(list0.size() > 1) {
            Collections.sort(list0);
        }
    }

    public static void S(List list0, Comparator comparator0) {
        q.g(list0, "<this>");
        q.g(comparator0, "comparator");
        if(list0.size() > 1) {
            Collections.sort(list0, comparator0);
        }
    }
}

