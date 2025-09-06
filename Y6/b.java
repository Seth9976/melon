package Y6;

import B.a;
import java.io.Serializable;
import java.util.HashSet;

public final class b {
    public String a;
    public int b;
    public int c;
    public Object d;
    public Serializable e;
    public Serializable f;
    public Object g;

    public b(Class class0, Class[] arr_class) {
        this.a = null;
        HashSet hashSet0 = new HashSet();
        this.d = hashSet0;
        this.e = new HashSet();
        this.b = 0;
        this.c = 0;
        this.f = new HashSet();
        hashSet0.add(s.a(class0));
        for(int v = 0; v < arr_class.length; ++v) {
            Class class1 = arr_class[v];
            a.o(class1, "Null interface");
            ((HashSet)this.d).add(s.a(class1));
        }
    }

    public void a(k k0) {
        if(((HashSet)this.d).contains(k0.a)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet)this.e).add(k0);
    }

    public c b() {
        if(((f)this.g) == null) {
            throw new IllegalStateException("Missing required property: factory.");
        }
        return new c(this.a, new HashSet(((HashSet)this.d)), new HashSet(((HashSet)this.e)), this.b, this.c, ((f)this.g), ((HashSet)this.f));
    }

    public void c(int v) {
        if(this.b != 0) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        this.b = v;
    }
}

