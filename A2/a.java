package a2;

public final class a {
    public final CharSequence a;
    public final int b;
    public int c;
    public char d;
    public static final byte[] e;

    static {
        a.e = new byte[0x700];
        for(int v = 0; v < 0x700; ++v) {
            a.e[v] = Character.getDirectionality(v);
        }
    }

    public a(CharSequence charSequence0) {
        this.a = charSequence0;
        this.b = charSequence0.length();
    }

    public final byte a() {
        CharSequence charSequence0 = this.a;
        char c = charSequence0.charAt(this.c - 1);
        this.d = c;
        if(Character.isLowSurrogate(c)) {
            int v = Character.codePointBefore(charSequence0, this.c);
            this.c -= Character.charCount(v);
            return Character.getDirectionality(v);
        }
        --this.c;
        return this.d >= 0x700 ? Character.getDirectionality(this.d) : a.e[this.d];
    }
}

