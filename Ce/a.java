package Ce;

import java.util.Iterator;

public abstract class a implements Iterable, xe.a {
    public final char a;
    public final char b;
    public final int c;

    public a(char c, char c1) {
        this.a = c;
        this.b = (char)e2.a.G(c, c1, 1);
        this.c = 1;
    }

    @Override
    public final Iterator iterator() {
        return new b(this.a, this.b, this.c);
    }
}

