package ze;

import De.w;
import kotlin.jvm.internal.q;

public abstract class a implements c {
    public Object a;

    public a(Object object0) {
        this.a = object0;
    }

    public void a(w w0, Object object0, Object object1) {
        q.g(w0, "property");
    }

    public void b(w w0) {
        q.g(w0, "property");
    }

    @Override  // ze.b
    public final Object getValue(Object object0, w w0) {
        q.g(w0, "property");
        return this.a;
    }

    @Override  // ze.c
    public final void setValue(Object object0, w w0, Object object1) {
        q.g(w0, "property");
        Object object2 = this.a;
        this.b(w0);
        this.a = object1;
        this.a(w0, object2, object1);
    }

    @Override
    public final String toString() {
        return "ObservableProperty(value=" + this.a + ')';
    }
}

