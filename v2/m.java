package v2;

public final class m implements l {
    public final int a;
    public int b;
    public int c;

    public m(int v) {
        this.b = -1;
        this.c = -1;
        this.a = v;
    }

    @Override  // v2.l
    public final boolean e(CharSequence charSequence0, int v, int v1, s s0) {
        int v2 = this.a;
        if(v <= v2 && v2 < v1) {
            this.b = v;
            this.c = v1;
            return false;
        }
        return v1 <= v2;
    }

    @Override  // v2.l
    public final Object getResult() {
        return this;
    }
}

