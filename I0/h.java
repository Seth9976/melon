package i0;

import androidx.fragment.app.p;
import e2.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.ListIterator;
import je.n;
import kotlin.jvm.internal.q;

public final class h extends b {
    public final Object[] a;
    public static final h b;

    static {
        h.b = new h(new Object[0]);
    }

    public h(Object[] arr_object) {
        this.a = arr_object;
    }

    @Override  // i0.b
    public final b a(int v, Object object0) {
        a.t(v, this.size());
        if(v == this.size()) {
            return this.b(object0);
        }
        Object[] arr_object = this.a;
        if(this.size() < 0x20) {
            Object[] arr_object1 = new Object[this.size() + 1];
            n.Y(arr_object, 0, arr_object1, v, 6);
            n.W(arr_object, v + 1, arr_object1, v, this.size());
            arr_object1[v] = object0;
            return new h(arr_object1);
        }
        Object[] arr_object2 = Arrays.copyOf(arr_object, arr_object.length);
        q.f(arr_object2, "copyOf(...)");
        n.W(arr_object, v + 1, arr_object2, v, this.size() - 1);
        arr_object2[v] = object0;
        Object[] arr_object3 = new Object[0x20];
        arr_object3[0] = arr_object[0x1F];
        return new d(arr_object2, arr_object3, this.size() + 1, 0);
    }

    @Override  // i0.b
    public final b b(Object object0) {
        Object[] arr_object = this.a;
        if(this.size() < 0x20) {
            Object[] arr_object1 = Arrays.copyOf(arr_object, this.size() + 1);
            q.f(arr_object1, "copyOf(...)");
            arr_object1[this.size()] = object0;
            return new h(arr_object1);
        }
        Object[] arr_object2 = new Object[0x20];
        arr_object2[0] = object0;
        return new d(arr_object, arr_object2, this.size() + 1, 0);
    }

    @Override  // i0.b
    public final b d(Collection collection0) {
        if(collection0.size() + this.size() <= 0x20) {
            Object[] arr_object = Arrays.copyOf(this.a, collection0.size() + this.size());
            q.f(arr_object, "copyOf(...)");
            int v = this.size();
            for(Object object0: collection0) {
                arr_object[v] = object0;
                ++v;
            }
            return new h(arr_object);
        }
        e e0 = this.e();
        e0.addAll(collection0);
        return e0.e();
    }

    @Override  // i0.b
    public final e e() {
        return new e(this, null, this.a, 0);
    }

    @Override  // i0.b
    public final b g(p p0) {
        int v = this.size();
        int v1 = this.size();
        Object[] arr_object = this.a;
        Object[] arr_object1 = arr_object;
        boolean z = false;
        for(int v2 = 0; v2 < v1; ++v2) {
            Object object0 = arr_object[v2];
            if(!((Boolean)p0.invoke(object0)).booleanValue()) {
                if(z) {
                    arr_object1[v] = object0;
                    ++v;
                }
            }
            else if(!z) {
                arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
                q.f(arr_object1, "copyOf(...)");
                z = true;
                v = v2;
            }
        }
        if(v == this.size()) {
            return this;
        }
        return v == 0 ? h.b : new h(n.a0(arr_object1, 0, v));
    }

    @Override
    public final Object get(int v) {
        a.s(v, this.size());
        return this.a[v];
    }

    @Override  // je.a
    public final int getSize() {
        return this.a.length;
    }

    @Override  // i0.b
    public final b i(int v) {
        a.s(v, this.size());
        if(this.size() == 1) {
            return h.b;
        }
        Object[] arr_object = Arrays.copyOf(this.a, this.size() - 1);
        q.f(arr_object, "copyOf(...)");
        n.W(this.a, v, arr_object, v + 1, this.size());
        return new h(arr_object);
    }

    @Override  // je.f
    public final int indexOf(Object object0) {
        return n.o0(this.a, object0);
    }

    @Override  // i0.b
    public final b k(int v, Object object0) {
        a.s(v, this.size());
        Object[] arr_object = Arrays.copyOf(this.a, this.a.length);
        q.f(arr_object, "copyOf(...)");
        arr_object[v] = object0;
        return new h(arr_object);
    }

    @Override  // je.f
    public final int lastIndexOf(Object object0) {
        Object[] arr_object = this.a;
        q.g(arr_object, "<this>");
        if(object0 == null) {
            int v = arr_object.length - 1;
            if(v >= 0) {
                while(true) {
                    if(arr_object[v] == null) {
                        return v;
                    }
                    if(v - 1 < 0) {
                        break;
                    }
                    --v;
                }
            }
        }
        else {
            int v1 = arr_object.length - 1;
            if(v1 >= 0) {
                while(true) {
                    if(object0.equals(arr_object[v1])) {
                        return v1;
                    }
                    if(v1 - 1 < 0) {
                        break;
                    }
                    --v1;
                }
            }
        }
        return -1;
    }

    @Override  // je.f
    public final ListIterator listIterator(int v) {
        a.t(v, this.size());
        return new c(this.a, v, this.size());
    }
}

