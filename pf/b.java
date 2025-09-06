package pf;

import Tf.v;
import e.k;
import e2.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;

public abstract class b {
    public static final String a;
    public static final LinkedHashMap b;

    static {
        b.a = "kotlin";
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        int v1 = a.G(0, k.A(new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"}).size() - 1, 2);
        if(v1 >= 0) {
            for(int v2 = 0; true; v2 += 2) {
                linkedHashMap0.put("kotlin" + '/' + "Double", "D");
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("kotlin");
                stringBuilder0.append('/');
                new StringBuilder("[").append("D");
                linkedHashMap0.put("kotlin/DoubleArray", "[D");
                if(v2 == v1) {
                    break;
                }
            }
        }
        linkedHashMap0.put("kotlin/Unit", "V");
        b.a(linkedHashMap0, "Any", "java/lang/Object");
        b.a(linkedHashMap0, "Nothing", "java/lang/Void");
        b.a(linkedHashMap0, "Annotation", "java/lang/annotation/Annotation");
        Iterator iterator0 = k.A(new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"}).iterator();
        while(iterator0.hasNext()) {
            b.a(linkedHashMap0, "Enum", "java/lang/Enum");
        }
        Iterator iterator1 = k.A(new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"}).iterator();
        while(iterator1.hasNext()) {
            b.a(linkedHashMap0, "collections/ListIterator", "java/util/ListIterator");
            b.a(linkedHashMap0, "collections/MutableListIterator", "java/util/ListIterator");
        }
        b.a(linkedHashMap0, "collections/Iterable", "java/lang/Iterable");
        b.a(linkedHashMap0, "collections/MutableIterable", "java/lang/Iterable");
        b.a(linkedHashMap0, "collections/Map.Entry", "java/util/Map$Entry");
        b.a(linkedHashMap0, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for(int v = 0; v < 23; ++v) {
            b.a(linkedHashMap0, "Function" + v, "kotlin/jvm/functions/Function" + v);
            b.a(linkedHashMap0, "reflect/KFunction" + v, "kotlin/reflect/KFunction");
        }
        Iterator iterator2 = k.A(new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"}).iterator();
        while(iterator2.hasNext()) {
            b.a(linkedHashMap0, "Enum.Companion", "kotlin/jvm/internal/EnumCompanionObject");
        }
        b.b = linkedHashMap0;
    }

    public static final void a(LinkedHashMap linkedHashMap0, String s, String s1) {
        linkedHashMap0.put("kotlin" + '/' + s, "L" + s1 + ';');
    }

    public static final String b(String s) {
        q.g(s, "classId");
        String s1 = (String)b.b.get(s);
        return s1 == null ? "L" + v.o0(s, '.', '$') + ';' : s1;
    }
}

