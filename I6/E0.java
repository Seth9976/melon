package I6;

import java.util.NoSuchElementException;

public final class e0 extends G0 {
    public final Object a;
    public boolean b;

    public e0(Object object0) {
        this.a = object0;
    }

    @Override
    public final boolean hasNext() {
        return !this.b;
    }

    @Override
    public final Object next() {
        if(this.b) {
            throw new NoSuchElementException();
        }
        this.b = true;
        return this.a;
    }
}

