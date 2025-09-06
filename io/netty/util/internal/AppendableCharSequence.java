package io.netty.util.internal;

import U4.x;
import androidx.appcompat.app.o;
import java.util.Arrays;

public final class AppendableCharSequence implements Appendable, CharSequence {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int v) {
        this.chars = new char[ObjectUtil.checkPositive(v, "length")];
    }

    private AppendableCharSequence(char[] arr_c) {
        this.chars = ObjectUtil.checkNonEmpty(arr_c, "chars");
        this.pos = arr_c.length;
    }

    public AppendableCharSequence append(char c) {
        char[] arr_c = this.chars;
        if(this.pos == arr_c.length) {
            char[] arr_c1 = new char[arr_c.length << 1];
            this.chars = arr_c1;
            System.arraycopy(arr_c, 0, arr_c1, 0, arr_c.length);
        }
        int v = this.pos;
        this.pos = v + 1;
        this.chars[v] = c;
        return this;
    }

    public AppendableCharSequence append(CharSequence charSequence0) {
        return this.append(charSequence0, 0, charSequence0.length());
    }

    public AppendableCharSequence append(CharSequence charSequence0, int v, int v1) {
        if(charSequence0.length() >= v1) {
            int v2 = v1 - v;
            char[] arr_c = this.chars;
            int v3 = this.pos;
            if(v2 > arr_c.length - v3) {
                this.chars = AppendableCharSequence.expand(arr_c, v3 + v2, v3);
            }
            if(charSequence0 instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence)charSequence0).chars, v, this.chars, this.pos, v2);
                this.pos += v2;
                return this;
            }
            while(v < v1) {
                char[] arr_c1 = this.chars;
                int v4 = this.pos;
                this.pos = v4 + 1;
                arr_c1[v4] = charSequence0.charAt(v);
                ++v;
            }
            return this;
        }
        StringBuilder stringBuilder0 = x.n(v1, "expected: csq.length() >= (", "),but actual is (");
        stringBuilder0.append(charSequence0.length());
        stringBuilder0.append(")");
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    @Override
    public Appendable append(char c) {
        return this.append(c);
    }

    @Override
    public Appendable append(CharSequence charSequence0) {
        return this.append(charSequence0);
    }

    @Override
    public Appendable append(CharSequence charSequence0, int v, int v1) {
        return this.append(charSequence0, v, v1);
    }

    @Override
    public char charAt(int v) {
        if(v > this.pos) {
            throw new IndexOutOfBoundsException();
        }
        return this.chars[v];
    }

    public char charAtUnsafe(int v) {
        return this.chars[v];
    }

    private static char[] expand(char[] arr_c, int v, int v1) {
        int v2 = arr_c.length;
        while(true) {
            v2 <<= 1;
            if(v2 < 0) {
                break;
            }
            if(v <= v2) {
                char[] arr_c1 = new char[v2];
                System.arraycopy(arr_c, 0, arr_c1, 0, v1);
                return arr_c1;
            }
        }
        throw new IllegalStateException();
    }

    @Override
    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public void setLength(int v) {
        if(v < 0 || v > this.pos) {
            throw new IllegalArgumentException(o.q(x.n(v, "length: ", " (length: >= 0, <= "), this.pos, ')'));
        }
        this.pos = v;
    }

    public AppendableCharSequence subSequence(int v, int v1) {
        return v == v1 ? new AppendableCharSequence(Math.min(16, this.chars.length)) : new AppendableCharSequence(Arrays.copyOfRange(this.chars, v, v1));
    }

    @Override
    public CharSequence subSequence(int v, int v1) {
        return this.subSequence(v, v1);
    }

    public String subStringUnsafe(int v, int v1) {
        return new String(this.chars, v, v1 - v);
    }

    public String substring(int v, int v1) {
        int v2 = v1 - v;
        if(v <= this.pos && v2 <= this.pos) {
            return new String(this.chars, v, v2);
        }
        StringBuilder stringBuilder0 = new StringBuilder("expected: start and length <= (");
        throw new IndexOutOfBoundsException(x.g(this.pos, ")", stringBuilder0));
    }

    @Override
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }
}

