package sf;

import e1.m;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import je.D;
import je.n;
import je.y;
import kotlin.jvm.internal.q;
import pe.b;

public enum h {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);

    public static final h[] B;
    public final boolean a;
    public static final Set b;
    public static final Set c;

    static {
        Set set6;
        Set set1;
        int v2;
        h.B = arr_h;
        new b(arr_h);
        h[] arr_h1 = (h[])h.B.clone();
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_h1.length; ++v) {
            h h0 = arr_h1[v];
            if(h0.a) {
                arrayList0.add(h0);
            }
        }
        if(arrayList0 instanceof Collection) {
            switch(arrayList0.size()) {
                case 0: {
                    set1 = y.a;
                    break;
                }
                case 1: {
                    Set set2 = Collections.singleton((arrayList0 instanceof List ? arrayList0.get(0) : arrayList0.iterator().next()));
                    q.f(set2, "singleton(...)");
                    set1 = set2;
                    break;
                }
                default: {
                    int v1 = arrayList0.size();
                    if(v1 < 0) {
                        v2 = v1;
                    }
                    else if(v1 < 3) {
                        v2 = v1 + 1;
                    }
                    else {
                        v2 = v1 >= 0x40000000 ? 0x7FFFFFFF : ((int)(((float)v1) / 0.75f + 1.0f));
                    }
                    Set set0 = new LinkedHashSet(v2);
                    q.g(arrayList0, "<this>");
                    for(Object object0: arrayList0) {
                        ((AbstractCollection)set0).add(object0);
                    }
                    set1 = set0;
                }
            }
        }
        else {
            Set set3 = new LinkedHashSet();
            q.g(arrayList0, "<this>");
            for(Object object1: arrayList0) {
                ((AbstractCollection)set3).add(object1);
            }
            switch(set3.size()) {
                case 0: {
                    set1 = y.a;
                    break;
                }
                case 1: {
                    Object object2 = set3.iterator().next();
                    Set set4 = Collections.singleton(object2);
                    q.f(set4, "singleton(...)");
                    set1 = set4;
                    break;
                }
                default: {
                    set1 = set3;
                }
            }
        }
        h.b = set1;
        Object[] arr_object = (h[])h.B.clone();
        q.g(arr_object, "<this>");
        switch(arr_object.length) {
            case 0: {
                set6 = y.a;
                break;
            }
            case 1: {
                set6 = m.E(arr_object[0]);
                break;
            }
            default: {
                Set set5 = new LinkedHashSet(D.N(arr_object.length));
                n.w0(arr_object, ((HashSet)set5));
                set6 = set5;
            }
        }
        h.c = set6;
    }

    public h(boolean z) {
        this.a = z;
    }
}

