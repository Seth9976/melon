package kotlin.jvm.internal;

import ie.f;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import we.g;
import we.h;
import we.i;
import we.j;
import we.k;
import we.m;
import we.n;
import we.o;
import we.p;
import we.r;
import we.s;
import we.t;
import we.u;
import xe.a;
import xe.b;
import xe.c;
import xe.d;
import xe.e;

public abstract class N {
    public static Collection a(Object object0) {
        if(object0 instanceof a && !(object0 instanceof b)) {
            N.i(object0, "kotlin.collections.MutableCollection");
            throw null;
        }
        try {
            return (Collection)object0;
        }
        catch(ClassCastException classCastException0) {
            q.l(classCastException0, "kotlin.jvm.internal.N");
            throw classCastException0;
        }
    }

    public static List b(Collection collection0) {
        if(collection0 instanceof a && !(collection0 instanceof c)) {
            N.i(collection0, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List)collection0;
        }
        catch(ClassCastException classCastException0) {
            q.l(classCastException0, "kotlin.jvm.internal.N");
            throw classCastException0;
        }
    }

    public static Map c(Object object0) {
        if(object0 instanceof a && !(object0 instanceof d)) {
            N.i(object0, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return (Map)object0;
        }
        catch(ClassCastException classCastException0) {
            q.l(classCastException0, "kotlin.jvm.internal.N");
            throw classCastException0;
        }
    }

    public static Set d(Object object0) {
        if(object0 instanceof a && !(object0 instanceof e)) {
            N.i(object0, "kotlin.collections.MutableSet");
            throw null;
        }
        try {
            return (Set)object0;
        }
        catch(ClassCastException classCastException0) {
            q.l(classCastException0, "kotlin.jvm.internal.N");
            throw classCastException0;
        }
    }

    public static void e(int v, Object object0) {
        if(object0 != null && !N.g(v, object0)) {
            N.i(object0, "kotlin.jvm.functions.Function" + v);
            throw null;
        }
    }

    public static String f(String s) {
        switch(s) {
            case "boolean": 
            case "java.lang.Boolean": {
                return "kotlin.Boolean";
            }
            case "byte": 
            case "java.lang.Byte": {
                return "kotlin.Byte";
            }
            case "char": 
            case "java.lang.Character": {
                return "kotlin.Char";
            }
            case "double": 
            case "java.lang.Double": {
                return "kotlin.Double";
            }
            case "float": 
            case "java.lang.Float": {
                return "kotlin.Float";
            }
            case "int": 
            case "java.lang.Integer": {
                return "kotlin.Int";
            }
            case "java.lang.CharSequence": {
                return "kotlin.CharSequence";
            }
            case "java.lang.Cloneable": {
                return "kotlin.Cloneable";
            }
            case "java.lang.Comparable": {
                return "kotlin.Comparable";
            }
            case "java.lang.Enum": {
                return "kotlin.Enum";
            }
            case "java.lang.Iterable": {
                return "kotlin.collections.Iterable";
            }
            case "java.lang.Long": 
            case "long": {
                return "kotlin.Long";
            }
            case "java.lang.Number": {
                return "kotlin.Number";
            }
            case "java.lang.Object": {
                return "kotlin.Any";
            }
            case "java.lang.Short": 
            case "short": {
                return "kotlin.Short";
            }
            case "java.lang.String": {
                return "kotlin.String";
            }
            case "java.lang.Throwable": {
                return "kotlin.Throwable";
            }
            case "java.lang.annotation.Annotation": {
                return "kotlin.Annotation";
            }
            case "java.util.Collection": {
                return "kotlin.collections.Collection";
            }
            case "java.util.Iterator": {
                return "kotlin.collections.Iterator";
            }
            case "java.util.List": {
                return "kotlin.collections.List";
            }
            case "java.util.ListIterator": {
                return "kotlin.collections.ListIterator";
            }
            case "java.util.Map": {
                return "kotlin.collections.Map";
            }
            case "java.util.Map$Entry": {
                return "kotlin.collections.Map.Entry";
            }
            case "java.util.Set": {
                return "kotlin.collections.Set";
            }
            case "kotlin.jvm.functions.Function0": {
                return "kotlin.Function0";
            }
            case "kotlin.jvm.functions.Function1": {
                return "kotlin.Function1";
            }
            case "kotlin.jvm.functions.Function10": {
                return "kotlin.Function10";
            }
            case "kotlin.jvm.functions.Function11": {
                return "kotlin.Function11";
            }
            case "kotlin.jvm.functions.Function12": {
                return "kotlin.Function12";
            }
            case "kotlin.jvm.functions.Function13": {
                return "kotlin.Function13";
            }
            case "kotlin.jvm.functions.Function14": {
                return "kotlin.Function14";
            }
            case "kotlin.jvm.functions.Function15": {
                return "kotlin.Function15";
            }
            case "kotlin.jvm.functions.Function16": {
                return "kotlin.Function16";
            }
            case "kotlin.jvm.functions.Function17": {
                return "kotlin.Function17";
            }
            case "kotlin.jvm.functions.Function18": {
                return "kotlin.Function18";
            }
            case "kotlin.jvm.functions.Function19": {
                return "kotlin.Function19";
            }
            case "kotlin.jvm.functions.Function2": {
                return "kotlin.Function2";
            }
            case "kotlin.jvm.functions.Function20": {
                return "kotlin.Function20";
            }
            case "kotlin.jvm.functions.Function21": {
                return "kotlin.Function21";
            }
            case "kotlin.jvm.functions.Function22": {
                return "kotlin.Function22";
            }
            case "kotlin.jvm.functions.Function3": {
                return "kotlin.Function3";
            }
            case "kotlin.jvm.functions.Function4": {
                return "kotlin.Function4";
            }
            case "kotlin.jvm.functions.Function5": {
                return "kotlin.Function5";
            }
            case "kotlin.jvm.functions.Function6": {
                return "kotlin.Function6";
            }
            case "kotlin.jvm.functions.Function7": {
                return "kotlin.Function7";
            }
            case "kotlin.jvm.functions.Function8": {
                return "kotlin.Function8";
            }
            case "kotlin.jvm.functions.Function9": {
                return "kotlin.Function9";
            }
            case "kotlin.jvm.internal.BooleanCompanionObject": {
                return "kotlin.Boolean.Companion";
            }
            case "kotlin.jvm.internal.ByteCompanionObject": {
                return "kotlin.Byte.Companion";
            }
            case "kotlin.jvm.internal.CharCompanionObject": {
                return "kotlin.Char.Companion";
            }
            case "kotlin.jvm.internal.DoubleCompanionObject": {
                return "kotlin.Double.Companion";
            }
            case "kotlin.jvm.internal.EnumCompanionObject": {
                return "kotlin.Enum.Companion";
            }
            case "kotlin.jvm.internal.FloatCompanionObject": {
                return "kotlin.Float.Companion";
            }
            case "kotlin.jvm.internal.IntCompanionObject": {
                return "kotlin.Int.Companion";
            }
            case "kotlin.jvm.internal.LongCompanionObject": {
                return "kotlin.Long.Companion";
            }
            case "kotlin.jvm.internal.ShortCompanionObject": {
                return "kotlin.Short.Companion";
            }
            case "kotlin.jvm.internal.StringCompanionObject": {
                return "kotlin.String.Companion";
            }
            default: {
                return null;
            }
        }
    }

    public static boolean g(int v, Object object0) {
        if(object0 instanceof f) {
            if(object0 instanceof l) {
                return ((l)object0).getArity() == v;
            }
            if(object0 instanceof we.a) {
                return 0 == v;
            }
            if(object0 instanceof k) {
                return 1 == v;
            }
            if(object0 instanceof n) {
                return 2 == v;
            }
            if(object0 instanceof o) {
                return 3 == v;
            }
            if(object0 instanceof p) {
                return 4 == v;
            }
            if(object0 instanceof we.q) {
                return 5 == v;
            }
            if(object0 instanceof r) {
                return 6 == v;
            }
            if(object0 instanceof s) {
                return 7 == v;
            }
            if(object0 instanceof t) {
                return 8 == v;
            }
            if(object0 instanceof u) {
                return 9 == v;
            }
            if(object0 instanceof we.b) {
                return 10 == v;
            }
            if(object0 instanceof we.c) {
                return 11 == v;
            }
            if(object0 instanceof Ge.e) {
                return 12 == v;
            }
            if(object0 instanceof we.d) {
                return 13 == v;
            }
            if(object0 instanceof we.e) {
                return 14 == v;
            }
            if(object0 instanceof we.f) {
                return 15 == v;
            }
            if(object0 instanceof g) {
                return 16 == v;
            }
            if(object0 instanceof h) {
                return 17 == v;
            }
            if(object0 instanceof i) {
                return 18 == v;
            }
            if(object0 instanceof j) {
                return 19 == v;
            }
            if(object0 instanceof we.l) {
                return 20 == v;
            }
            return object0 instanceof m ? 21 == v : (object0 instanceof Ge.e ? 22 : -1) == v;
        }
        return false;
    }

    public static String h(String s) {
        switch(s) {
            case "boolean": 
            case "java.lang.Boolean": {
                return "Boolean";
            }
            case "byte": 
            case "java.lang.Byte": {
                return "Byte";
            }
            case "char": 
            case "java.lang.Character": {
                return "Char";
            }
            case "double": 
            case "java.lang.Double": {
                return "Double";
            }
            case "float": 
            case "java.lang.Float": {
                return "Float";
            }
            case "int": 
            case "java.lang.Integer": {
                return "Int";
            }
            case "java.lang.CharSequence": {
                return "CharSequence";
            }
            case "java.lang.Cloneable": {
                return "Cloneable";
            }
            case "java.lang.Comparable": {
                return "Comparable";
            }
            case "java.lang.Enum": {
                return "Enum";
            }
            case "java.lang.Iterable": {
                return "Iterable";
            }
            case "java.lang.Long": 
            case "long": {
                return "Long";
            }
            case "java.lang.Number": {
                return "Number";
            }
            case "java.lang.Object": {
                return "Any";
            }
            case "java.lang.Short": 
            case "short": {
                return "Short";
            }
            case "java.lang.String": {
                return "String";
            }
            case "java.lang.Throwable": {
                return "Throwable";
            }
            case "java.lang.annotation.Annotation": {
                return "Annotation";
            }
            case "java.util.Collection": {
                return "Collection";
            }
            case "java.util.Iterator": {
                return "Iterator";
            }
            case "java.util.List": {
                return "List";
            }
            case "java.util.ListIterator": {
                return "ListIterator";
            }
            case "java.util.Map": {
                return "Map";
            }
            case "java.util.Map$Entry": {
                return "Entry";
            }
            case "java.util.Set": {
                return "Set";
            }
            case "kotlin.jvm.functions.Function0": {
                return "Function0";
            }
            case "kotlin.jvm.functions.Function1": {
                return "Function1";
            }
            case "kotlin.jvm.functions.Function10": {
                return "Function10";
            }
            case "kotlin.jvm.functions.Function11": {
                return "Function11";
            }
            case "kotlin.jvm.functions.Function12": {
                return "Function12";
            }
            case "kotlin.jvm.functions.Function13": {
                return "Function13";
            }
            case "kotlin.jvm.functions.Function14": {
                return "Function14";
            }
            case "kotlin.jvm.functions.Function15": {
                return "Function15";
            }
            case "kotlin.jvm.functions.Function16": {
                return "Function16";
            }
            case "kotlin.jvm.functions.Function17": {
                return "Function17";
            }
            case "kotlin.jvm.functions.Function18": {
                return "Function18";
            }
            case "kotlin.jvm.functions.Function19": {
                return "Function19";
            }
            case "kotlin.jvm.functions.Function2": {
                return "Function2";
            }
            case "kotlin.jvm.functions.Function20": {
                return "Function20";
            }
            case "kotlin.jvm.functions.Function21": {
                return "Function21";
            }
            case "kotlin.jvm.functions.Function22": {
                return "Function22";
            }
            case "kotlin.jvm.functions.Function3": {
                return "Function3";
            }
            case "kotlin.jvm.functions.Function4": {
                return "Function4";
            }
            case "kotlin.jvm.functions.Function5": {
                return "Function5";
            }
            case "kotlin.jvm.functions.Function6": {
                return "Function6";
            }
            case "kotlin.jvm.functions.Function7": {
                return "Function7";
            }
            case "kotlin.jvm.functions.Function8": {
                return "Function8";
            }
            case "kotlin.jvm.functions.Function9": {
                return "Function9";
            }
            case "kotlin.jvm.internal.BooleanCompanionObject": 
            case "kotlin.jvm.internal.ByteCompanionObject": 
            case "kotlin.jvm.internal.CharCompanionObject": 
            case "kotlin.jvm.internal.DoubleCompanionObject": 
            case "kotlin.jvm.internal.EnumCompanionObject": 
            case "kotlin.jvm.internal.FloatCompanionObject": 
            case "kotlin.jvm.internal.IntCompanionObject": 
            case "kotlin.jvm.internal.LongCompanionObject": 
            case "kotlin.jvm.internal.ShortCompanionObject": 
            case "kotlin.jvm.internal.StringCompanionObject": {
                return "Companion";
            }
            default: {
                return null;
            }
        }
    }

    public static void i(Object object0, String s) {
        ClassCastException classCastException0 = new ClassCastException((object0 == null ? "null" : object0.getClass().getName()) + " cannot be cast to " + s);
        q.l(classCastException0, "kotlin.jvm.internal.N");
        throw classCastException0;
    }
}

