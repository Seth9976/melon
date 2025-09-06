package y;

public final class c {
    public final Object a;
    public final String b;

    public c(Object object0, String s) {
        this.a = object0;
        this.b = s;
    }

    public final String a() {
        return "[" + this.b + ", " + f.i(this.a.getClass()) + "]";
    }

    @Override
    public final String toString() {
        return this.a();
    }
}

