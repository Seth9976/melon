package Ne;

import e.k;
import e1.m;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import je.C;
import je.p;
import je.y;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class n extends Enum {
    public static final enum n B;
    public static final enum n D;
    public static final enum n E;
    public static final enum n G;
    public static final enum n I;
    public static final enum n M;
    public static final enum n N;
    public static final enum n S;
    public static final enum n T;
    public static final enum n V;
    public static final enum n W;
    public static final enum n X;
    public static final enum n Y;
    public static final enum n Z;
    public final boolean a;
    public static final HashMap b;
    public static final enum n b0;
    public static final Set c;
    public static final enum n c0;
    public static final Set d;
    public static final enum n d0;
    public static final List e;
    public static final enum n e0;
    public static final List f;
    public static final enum n f0;
    public static final List g;
    public static final enum n g0;
    public static final List h;
    public static final enum n h0;
    public static final List i;
    public static final n[] i0;
    public static final List j;
    public static final b j0;
    public static final List k;
    public static final List l;
    public static final List m;
    public static final List n;
    public static final List o;
    public static final List r;
    public static final Object w;

    static {
        Set set6;
        int v3;
        Set set1;
        int v1;
        n.B = new n("CLASS", 0, true);
        n.D = new n("ANNOTATION_CLASS", 1, true);
        n.E = new n("TYPE_PARAMETER", 2, false);
        n.G = new n("PROPERTY", 3, true);
        n.I = new n("FIELD", 4, true);
        n.M = new n("LOCAL_VARIABLE", 5, true);
        n.N = new n("VALUE_PARAMETER", 6, true);
        n.S = new n("CONSTRUCTOR", 7, true);
        n.T = new n("FUNCTION", 8, true);
        n.V = new n("PROPERTY_GETTER", 9, true);
        n.W = new n("PROPERTY_SETTER", 10, true);
        n.X = new n("TYPE", 11, false);
        n n0 = new n("EXPRESSION", 12, false);
        n.Y = new n("FILE", 13, false);
        n n1 = new n("TYPEALIAS", 14, false);
        n n2 = new n("TYPE_PROJECTION", 15, false);
        n n3 = new n("STAR_PROJECTION", 16, false);
        n n4 = new n("PROPERTY_PARAMETER", 17, false);
        n.Z = new n("CLASS_ONLY", 18, false);
        n.b0 = new n("OBJECT", 19, false);
        n.c0 = new n("STANDALONE_OBJECT", 20, false);
        n.d0 = new n("COMPANION_OBJECT", 21, false);
        n.e0 = new n("INTERFACE", 22, false);
        n.f0 = new n("ENUM_CLASS", 23, false);
        n.g0 = new n("ENUM_ENTRY", 24, false);
        n.h0 = new n("LOCAL_CLASS", 25, false);
        n[] arr_n = {n.B, n.D, n.E, n.G, n.I, n.M, n.N, n.S, n.T, n.V, n.W, n.X, n0, n.Y, n1, n2, n3, n4, n.Z, n.b0, n.c0, n.d0, n.e0, n.f0, n.g0, n.h0, new n("LOCAL_FUNCTION", 26, false), new n("MEMBER_FUNCTION", 27, false), new n("TOP_LEVEL_FUNCTION", 28, false), new n("MEMBER_PROPERTY", 29, false), new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, false), new n("MEMBER_PROPERTY_WITH_DELEGATE", 0x1F, false), new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 0x20, false), new n("TOP_LEVEL_PROPERTY", 33, false), new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, false), new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, false), new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, false), new n("BACKING_FIELD", 37, true), new n("INITIALIZER", 38, false), new n("DESTRUCTURING_DECLARATION", 39, false), new n("LAMBDA_EXPRESSION", 40, false), new n("ANONYMOUS_FUNCTION", 41, false), new n("OBJECT_LITERAL", 42, false)};
        n.i0 = arr_n;
        b b0 = new b(arr_n);
        n.j0 = b0;
        n.b = new HashMap();
        for(Object object0: b0) {
            n.b.put(((n)object0).name(), ((n)object0));
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: n.j0) {
            if(((n)object1).a) {
                arrayList0.add(object1);
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
                    int v = arrayList0.size();
                    if(v < 0) {
                        v1 = v;
                    }
                    else if(v < 3) {
                        v1 = v + 1;
                    }
                    else {
                        v1 = v >= 0x40000000 ? 0x7FFFFFFF : ((int)(((float)v) / 0.75f + 1.0f));
                    }
                    Set set0 = new LinkedHashSet(v1);
                    q.g(arrayList0, "<this>");
                    for(Object object2: arrayList0) {
                        ((AbstractCollection)set0).add(object2);
                    }
                    set1 = set0;
                }
            }
        }
        else {
            Set set3 = new LinkedHashSet();
            q.g(arrayList0, "<this>");
            for(Object object3: arrayList0) {
                ((AbstractCollection)set3).add(object3);
            }
            switch(set3.size()) {
                case 0: {
                    set1 = y.a;
                    break;
                }
                case 1: {
                    Object object4 = set3.iterator().next();
                    Set set4 = Collections.singleton(object4);
                    q.f(set4, "singleton(...)");
                    set1 = set4;
                    break;
                }
                default: {
                    set1 = set3;
                }
            }
        }
        n.c = set1;
        Iterable iterable0 = n.j0;
        if(iterable0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException(q.i("<this>"));
            q.l(nullPointerException0, q.class.getName());
            throw nullPointerException0;
        }
        if(iterable0 instanceof Collection) {
            switch(((Collection)iterable0).size()) {
                case 0: {
                    set6 = y.a;
                    break;
                }
                case 1: {
                    set6 = m.E((iterable0 instanceof List ? ((List)iterable0).get(0) : ((Collection)iterable0).iterator().next()));
                    break;
                }
                default: {
                    int v2 = ((Collection)iterable0).size();
                    if(v2 < 0) {
                        v3 = v2;
                    }
                    else if(v2 < 3) {
                        v3 = v2 + 1;
                    }
                    else {
                        v3 = v2 >= 0x40000000 ? 0x7FFFFFFF : ((int)(((float)v2) / 0.75f + 1.0f));
                    }
                    Set set5 = new LinkedHashSet(v3);
                    q.g(iterable0, "<this>");
                    for(Object object5: iterable0) {
                        ((AbstractCollection)set5).add(object5);
                    }
                    set6 = set5;
                }
            }
        }
        else {
            Set set7 = new LinkedHashSet();
            p.M0(iterable0, ((AbstractCollection)set7));
            switch(set7.size()) {
                case 0: {
                    set6 = y.a;
                    break;
                }
                case 1: {
                    Object object6 = set7.iterator().next();
                    set6 = m.E(object6);
                    break;
                }
                default: {
                    set6 = set7;
                }
            }
        }
        n.d = set6;
        Object[] arr_object = {n.D, n.B};
        q.g(arr_object, "elements");
        n.e = je.n.N(arr_object);
        Object[] arr_object1 = {n.h0, n.B};
        q.g(arr_object1, "elements");
        n.f = je.n.N(arr_object1);
        Object[] arr_object2 = {n.Z, n.B};
        q.g(arr_object2, "elements");
        n.g = je.n.N(arr_object2);
        Object[] arr_object3 = {n.d0, n.b0, n.B};
        q.g(arr_object3, "elements");
        n.h = je.n.N(arr_object3);
        Object[] arr_object4 = {n.c0, n.b0, n.B};
        q.g(arr_object4, "elements");
        n.i = je.n.N(arr_object4);
        Object[] arr_object5 = {n.e0, n.B};
        q.g(arr_object5, "elements");
        n.j = je.n.N(arr_object5);
        Object[] arr_object6 = {n.f0, n.B};
        q.g(arr_object6, "elements");
        n.k = je.n.N(arr_object6);
        n.l = k.A(new n[]{n.g0, n.G, n.I});
        n.m = k.z(n.W);
        n.n = k.z(n.V);
        n.o = k.z(n.T);
        n.r = k.z(n.Y);
        n.w = C.S(new ie.m[]{new ie.m(d.h, n.N), new ie.m(d.b, n.I), new ie.m(d.d, n.G), new ie.m(d.c, n.Y), new ie.m(d.e, n.V), new ie.m(d.f, n.W), new ie.m(d.g, n.N), new ie.m(d.i, n.N), new ie.m(d.j, n.I)});
    }

    public n(String s, int v, boolean z) {
        super(s, v);
        this.a = z;
    }

    public static n valueOf(String s) {
        return (n)Enum.valueOf(n.class, s);
    }

    public static n[] values() {
        return (n[])n.i0.clone();
    }
}

