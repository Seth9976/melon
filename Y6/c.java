package Y6;

import B.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class c {
    public final String a;
    public final Set b;
    public final Set c;
    public final int d;
    public final int e;
    public final f f;
    public final Set g;

    public c(String s, Set set0, Set set1, int v, int v1, f f0, Set set2) {
        this.a = s;
        this.b = Collections.unmodifiableSet(set0);
        this.c = Collections.unmodifiableSet(set1);
        this.d = v;
        this.e = v1;
        this.f = f0;
        this.g = Collections.unmodifiableSet(set2);
    }

    public static b a(s s0) {
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.a = null;
        HashSet hashSet0 = new HashSet();
        b0.d = hashSet0;
        b0.e = new HashSet();
        b0.b = 0;
        b0.c = 0;
        b0.f = new HashSet();
        hashSet0.add(s0);
        Collections.addAll(((HashSet)b0.d), new s[0]);
        return b0;
    }

    public static b b(Class class0) {
        return new b(class0, new Class[0]);
    }

    public static c c(Object object0, Class class0, Class[] arr_class) {
        HashSet hashSet0 = new HashSet();
        HashSet hashSet1 = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet0.add(s.a(class0));
        for(int v = 0; v < arr_class.length; ++v) {
            Class class1 = arr_class[v];
            a.o(class1, "Null interface");
            hashSet0.add(s.a(class1));
        }
        Y6.a a0 = new Y6.a(object0);
        return new c(null, new HashSet(hashSet0), new HashSet(hashSet1), 0, 0, a0, hashSet2);
    }

    @Override
    public final String toString() {
        return "Component<" + Arrays.toString(this.b.toArray()) + ">{" + this.d + ", type=" + this.e + ", deps=" + Arrays.toString(this.c.toArray()) + "}";
    }
}

