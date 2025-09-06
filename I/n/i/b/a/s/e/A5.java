package i.n.i.b.a.s.e;

public final class a5 extends A1 {
    public final Object a;
    public int b;
    public final b5 c;

    public a5(b5 b50, int v) {
        this.c = b50;
        this.a = b50.c[v];
        this.b = v;
    }

    public final void a() {
        Object object0 = this.a;
        b5 b50 = this.c;
        if(this.b != -1 && this.b < b50.h && M7.v(object0, b50.c[this.b])) {
            return;
        }
        this.b = b50.a(object0);
    }

    @Override
    public final Object getKey() {
        return this.a;
    }

    @Override
    public final Object getValue() {
        this.a();
        return this.b == -1 ? null : this.c.d[this.b];
    }

    @Override
    public final Object setValue(Object object0) {
        this.a();
        int v = this.b;
        b5 b50 = this.c;
        if(v == -1) {
            b50.put(this.a, object0);
            return null;
        }
        Object[] arr_object = b50.d;
        Object object1 = arr_object[v];
        arr_object[v] = object0;
        return object1;
    }
}

