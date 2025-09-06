package je;

import Ce.g;
import Q0.W0;
import Sf.e;
import Sf.k;
import Sf.p;
import df.v;
import ie.B;
import ie.F;
import ie.m;
import ie.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.Symbol;
import y5.a;

public abstract class n extends v {
    public static Set A0(Object[] arr_object) [...] // Inlined contents

    public static ArrayList B0(Object[] arr_object, Object[] arr_object1) {
        q.g(arr_object, "<this>");
        q.g(arr_object1, "other");
        int v = Math.min(arr_object.length, arr_object1.length);
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(new m(arr_object[v1], arr_object1[v1]));
        }
        return arrayList0;
    }

    public static Iterable M(Object[] arr_object) {
        q.g(arr_object, "<this>");
        return arr_object.length == 0 ? w.a : new p(arr_object, 1);
    }

    public static List N(Object[] arr_object) {
        q.g(arr_object, "<this>");
        List list0 = Arrays.asList(arr_object);
        q.f(list0, "asList(...)");
        return list0;
    }

    public static k O(Object[] arr_object) {
        return arr_object.length == 0 ? e.a : new W0(arr_object, 6);
    }

    public static boolean P(int[] arr_v, int v) {
        q.g(arr_v, "<this>");
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= arr_v.length) {
                v1 = -1;
                break;
            }
            if(v == arr_v[v1]) {
                break;
            }
        }
        return v1 >= 0;
    }

    public static boolean Q(Object[] arr_object, Object object0) {
        q.g(arr_object, "<this>");
        return n.o0(arr_object, object0) >= 0;
    }

    public static boolean R(Object[] arr_object, Object[] arr_object1) {
        if(arr_object != arr_object1) {
            if(arr_object.length == arr_object1.length) {
                for(int v = 0; v < arr_object.length; ++v) {
                    byte[] arr_b = null;
                    Object object0 = arr_object[v];
                    Object object1 = arr_object1[v];
                    if(object0 != object1) {
                        if(object0 == null || object1 == null) {
                            return false;
                        }
                        if(object0 instanceof Object[] && object1 instanceof Object[]) {
                            if(!n.R(((Object[])object0), ((Object[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof byte[] && object1 instanceof byte[]) {
                            if(!Arrays.equals(((byte[])object0), ((byte[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof short[] && object1 instanceof short[]) {
                            if(!Arrays.equals(((short[])object0), ((short[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof int[] && object1 instanceof int[]) {
                            if(!Arrays.equals(((int[])object0), ((int[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof long[] && object1 instanceof long[]) {
                            if(!Arrays.equals(((long[])object0), ((long[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof float[] && object1 instanceof float[]) {
                            if(!Arrays.equals(((float[])object0), ((float[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof double[] && object1 instanceof double[]) {
                            if(!Arrays.equals(((double[])object0), ((double[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof char[] && object1 instanceof char[]) {
                            if(!Arrays.equals(((char[])object0), ((char[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof boolean[] && object1 instanceof boolean[]) {
                            if(!Arrays.equals(((boolean[])object0), ((boolean[])object1))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof ie.v && object1 instanceof ie.v) {
                            byte[] arr_b1 = ((ie.v)object0).a;
                            byte[] arr_b2 = ((ie.v)object1).a;
                            if(arr_b1 == null) {
                                arr_b1 = null;
                            }
                            if(arr_b2 != null) {
                                arr_b = arr_b2;
                            }
                            if(!Arrays.equals(arr_b1, arr_b)) {
                                return false;
                            }
                        }
                        else if(object0 instanceof F && object1 instanceof F) {
                            short[] arr_v = ((F)object0).a;
                            short[] arr_v1 = ((F)object1).a;
                            if(arr_v == null) {
                                arr_v = null;
                            }
                            if(arr_v1 != null) {
                                arr_b = arr_v1;
                            }
                            if(!Arrays.equals(arr_v, ((short[])arr_b))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof y && object1 instanceof y) {
                            int[] arr_v2 = ((y)object0).a;
                            int[] arr_v3 = ((y)object1).a;
                            if(arr_v2 == null) {
                                arr_v2 = null;
                            }
                            if(arr_v3 != null) {
                                arr_b = arr_v3;
                            }
                            if(!Arrays.equals(arr_v2, ((int[])arr_b))) {
                                return false;
                            }
                        }
                        else if(object0 instanceof B && object1 instanceof B) {
                            long[] arr_v4 = ((B)object0).a;
                            long[] arr_v5 = ((B)object1).a;
                            if(arr_v4 == null) {
                                arr_v4 = null;
                            }
                            if(arr_v5 != null) {
                                arr_b = arr_v5;
                            }
                            if(!Arrays.equals(arr_v4, ((long[])arr_b))) {
                                return false;
                            }
                        }
                        else {
                            if(object0.equals(object1)) {
                                continue;
                            }
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static void S(int v, int v1, int v2, int[] arr_v, int[] arr_v1) {
        q.g(arr_v, "<this>");
        q.g(arr_v1, "destination");
        System.arraycopy(arr_v, v1, arr_v1, v, v2 - v1);
    }

    public static void T(byte[] arr_b, int v, int v1, byte[] arr_b1, int v2) {
        q.g(arr_b, "<this>");
        q.g(arr_b1, "destination");
        System.arraycopy(arr_b, v1, arr_b1, v, v2 - v1);
    }

    public static void U(char[] arr_c, char[] arr_c1, int v, int v1, int v2) {
        q.g(arr_c, "<this>");
        System.arraycopy(arr_c, v1, arr_c1, v, v2 - v1);
    }

    public static void V(long[] arr_v, long[] arr_v1, int v, int v1, int v2) {
        q.g(arr_v, "<this>");
        q.g(arr_v1, "destination");
        System.arraycopy(arr_v, v1, arr_v1, v, v2 - v1);
    }

    public static void W(Object[] arr_object, int v, Object[] arr_object1, int v1, int v2) {
        q.g(arr_object, "<this>");
        q.g(arr_object1, "destination");
        System.arraycopy(arr_object, v1, arr_object1, v, v2 - v1);
    }

    public static void X(int v, int v1, int v2, int[] arr_v, int[] arr_v1) {
        if((v2 & 2) != 0) {
            v = 0;
        }
        if((v2 & 8) != 0) {
            v1 = arr_v.length;
        }
        n.S(v, 0, v1, arr_v, arr_v1);
    }

    public static void Y(Object[] arr_object, int v, Object[] arr_object1, int v1, int v2) {
        if((v2 & 4) != 0) {
            v = 0;
        }
        if((v2 & 8) != 0) {
            v1 = arr_object.length;
        }
        n.W(arr_object, 0, arr_object1, v, v1);
    }

    public static byte[] Z(byte[] arr_b, int v, int v1) {
        q.g(arr_b, "<this>");
        v.t(v1, arr_b.length);
        byte[] arr_b1 = Arrays.copyOfRange(arr_b, v, v1);
        q.f(arr_b1, "copyOfRange(...)");
        return arr_b1;
    }

    public static Object[] a0(Object[] arr_object, int v, int v1) {
        q.g(arr_object, "<this>");
        v.t(v1, arr_object.length);
        Object[] arr_object1 = Arrays.copyOfRange(arr_object, v, v1);
        q.f(arr_object1, "copyOfRange(...)");
        return arr_object1;
    }

    public static List b0(int v, Object[] arr_object) {
        if(v < 0) {
            throw new IllegalArgumentException(("Requested element count " + v + " is less than zero.").toString());
        }
        int v1 = arr_object.length - v >= 0 ? arr_object.length - v : 0;
        if(v1 == 0) {
            return w.a;
        }
        if(v1 >= arr_object.length) {
            return n.z0(arr_object);
        }
        if(v1 == 1) {
            return e.k.z(arr_object[arr_object.length - 1]);
        }
        List list0 = new ArrayList(v1);
        for(int v2 = arr_object.length - v1; v2 < arr_object.length; ++v2) {
            ((ArrayList)list0).add(arr_object[v2]);
        }
        return list0;
    }

    public static void c0(int v, int v1, Object object0, Object[] arr_object) {
        q.g(arr_object, "<this>");
        Arrays.fill(arr_object, v, v1, object0);
    }

    public static void d0(int v, int[] arr_v) {
        q.g(arr_v, "<this>");
        Arrays.fill(arr_v, 0, arr_v.length, v);
    }

    public static void e0(long[] arr_v, long v) {
        q.g(arr_v, "<this>");
        Arrays.fill(arr_v, 0, arr_v.length, v);
    }

    public static void f0(Object[] arr_object, Symbol symbol0) {
        n.c0(0, arr_object.length, symbol0, arr_object);
    }

    public static ArrayList g0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_object.length; ++v) {
            Object object0 = arr_object[v];
            if(object0 != null) {
                arrayList0.add(object0);
            }
        }
        return arrayList0;
    }

    public static Object h0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        if(arr_object.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return arr_object[0];
    }

    public static Object i0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        return arr_object.length == 0 ? null : arr_object[0];
    }

    public static g j0(int[] arr_v) {
        return new g(0, arr_v.length - 1, 1);  // 初始化器: LCe/e;-><init>(III)V
    }

    public static int k0(long[] arr_v) {
        q.g(arr_v, "<this>");
        return arr_v.length - 1;
    }

    public static int l0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        return arr_object.length - 1;
    }

    public static Integer m0(int v, int[] arr_v) {
        q.g(arr_v, "<this>");
        return v < 0 || v >= arr_v.length ? null : ((int)arr_v[v]);
    }

    public static Object n0(int v, Object[] arr_object) {
        q.g(arr_object, "<this>");
        return v < 0 || v >= arr_object.length ? null : arr_object[v];
    }

    public static int o0(Object[] arr_object, Object object0) {
        q.g(arr_object, "<this>");
        int v = 0;
        if(object0 == null) {
            while(v < arr_object.length) {
                if(arr_object[v] == null) {
                    return v;
                }
                ++v;
            }
            return -1;
        }
        while(v < arr_object.length) {
            if(object0.equals(arr_object[v])) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    public static final void p0(Object[] arr_object, StringBuilder stringBuilder0, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, CharSequence charSequence3, we.k k0) {
        q.g(arr_object, "<this>");
        stringBuilder0.append(charSequence1);
        int v1 = 0;
        for(int v = 0; v < arr_object.length; ++v) {
            Object object0 = arr_object[v];
            ++v1;
            if(v1 > 1) {
                stringBuilder0.append(charSequence0);
            }
            a.i(stringBuilder0, object0, k0);
        }
        stringBuilder0.append(charSequence2);
    }

    public static String q0(byte[] arr_b, String s, we.k k0, int v) {
        if((v & 0x20) != 0) {
            k0 = null;
        }
        q.g(arr_b, "<this>");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(((v & 2) == 0 ? "[" : ""));
        int v2 = 0;
        for(int v1 = 0; v1 < arr_b.length; ++v1) {
            int v3 = arr_b[v1];
            ++v2;
            if(v2 > 1) {
                stringBuilder0.append(s);
            }
            if(k0 == null) {
                stringBuilder0.append(String.valueOf(v3));
            }
            else {
                stringBuilder0.append(((CharSequence)k0.invoke(((byte)v3))));
            }
        }
        stringBuilder0.append(((v & 4) == 0 ? "]" : ""));
        return stringBuilder0.toString();
    }

    public static String r0(Object[] arr_object, String s, String s1, String s2, we.k k0, int v) {
        if((v & 1) != 0) {
            s = ", ";
        }
        if((v & 0x20) != 0) {
            k0 = null;
        }
        q.g(arr_object, "<this>");
        StringBuilder stringBuilder0 = new StringBuilder();
        n.p0(arr_object, stringBuilder0, s, ((v & 2) == 0 ? s1 : ""), ((v & 4) == 0 ? s2 : ""), "...", k0);
        return stringBuilder0.toString();
    }

    public static Object s0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        if(arr_object.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return arr_object[arr_object.length - 1];
    }

    public static char t0(char[] arr_c) {
        switch(arr_c.length) {
            case 0: {
                throw new NoSuchElementException("Array is empty.");
            }
            case 1: {
                return arr_c[0];
            }
            default: {
                throw new IllegalArgumentException("Array has more than one element.");
            }
        }
    }

    public static Object u0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        switch(arr_object.length) {
            case 0: {
                throw new NoSuchElementException("Array is empty.");
            }
            case 1: {
                return arr_object[0];
            }
            default: {
                throw new IllegalArgumentException("Array has more than one element.");
            }
        }
    }

    public static List v0(Object[] arr_object, Comparator comparator0) {
        q.g(arr_object, "<this>");
        if(arr_object.length != 0) {
            arr_object = Arrays.copyOf(arr_object, arr_object.length);
            q.f(arr_object, "copyOf(...)");
            if(arr_object.length > 1) {
                Arrays.sort(arr_object, comparator0);
            }
        }
        return n.N(arr_object);
    }

    public static final void w0(Object[] arr_object, HashSet hashSet0) {
        q.g(arr_object, "<this>");
        for(int v = 0; v < arr_object.length; ++v) {
            hashSet0.add(arr_object[v]);
        }
    }

    public static List x0(float[] arr_f) {
        q.g(arr_f, "<this>");
        switch(arr_f.length) {
            case 0: {
                return w.a;
            }
            case 1: {
                return e.k.z(((float)arr_f[0]));
            }
            default: {
                List list0 = new ArrayList(arr_f.length);
                for(int v = 0; v < arr_f.length; ++v) {
                    ((ArrayList)list0).add(((float)arr_f[v]));
                }
                return list0;
            }
        }
    }

    public static List y0(int[] arr_v) {
        q.g(arr_v, "<this>");
        switch(arr_v.length) {
            case 0: {
                return w.a;
            }
            case 1: {
                return e.k.z(((int)arr_v[0]));
            }
            default: {
                List list0 = new ArrayList(arr_v.length);
                for(int v = 0; v < arr_v.length; v = com.iloen.melon.utils.a.d(arr_v[v], v, 1, ((ArrayList)list0))) {
                }
                return list0;
            }
        }
    }

    public static List z0(Object[] arr_object) {
        q.g(arr_object, "<this>");
        switch(arr_object.length) {
            case 0: {
                return w.a;
            }
            case 1: {
                return e.k.z(arr_object[0]);
            }
            default: {
                return new ArrayList(new l(arr_object, false));
            }
        }
    }
}

