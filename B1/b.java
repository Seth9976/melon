package b1;

import java.text.CharacterIterator;

public final class b implements CharacterIterator {
    public final CharSequence a;
    public final int b;
    public int c;

    public b(CharSequence charSequence0, int v) {
        this.a = charSequence0;
        this.b = v;
        this.c = 0;
    }

    @Override
    public final Object clone() {
        try {
            return super.clone();
        }
        catch(CloneNotSupportedException unused_ex) {
            throw new InternalError();
        }
    }

    @Override
    public final char current() {
        return this.c == this.b ? '\uFFFF' : this.a.charAt(this.c);
    }

    @Override
    public final char first() {
        this.c = 0;
        return this.current();
    }

    @Override
    public final int getBeginIndex() {
        return 0;
    }

    @Override
    public final int getEndIndex() {
        return this.b;
    }

    @Override
    public final int getIndex() {
        return this.c;
    }

    @Override
    public final char last() {
        int v = this.b;
        if(v == 0) {
            this.c = 0;
            return '\uFFFF';
        }
        this.c = v - 1;
        return this.a.charAt(v - 1);
    }

    @Override
    public final char next() {
        int v = this.c + 1;
        this.c = v;
        int v1 = this.b;
        if(v >= v1) {
            this.c = v1;
            return '\uFFFF';
        }
        return this.a.charAt(v);
    }

    @Override
    public final char previous() {
        int v = this.c;
        if(v <= 0) {
            return '\uFFFF';
        }
        this.c = v - 1;
        return this.a.charAt(v - 1);
    }

    @Override
    public final char setIndex(int v) {
        if(v > this.b || v < 0) {
            throw new IllegalArgumentException("invalid position");
        }
        this.c = v;
        return this.current();
    }
}

