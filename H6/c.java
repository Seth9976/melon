package H6;

public final class c extends b {
    public final char a;

    public c(char c) {
        this.a = c;
    }

    @Override  // H6.b
    public final boolean a(char c) {
        return c == this.a;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CharMatcher.is(\'");
        char[] arr_c = {'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        int v = this.a;
        for(int v1 = 0; v1 < 4; ++v1) {
            arr_c[5 - v1] = "0123456789ABCDEF".charAt(v & 15);
            v = (char)(v >> 4);
        }
        stringBuilder0.append(String.copyValueOf(arr_c));
        stringBuilder0.append("\')");
        return stringBuilder0.toString();
    }
}

