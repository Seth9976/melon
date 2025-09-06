package Q0;

public final class e extends a {
    public static e c;

    @Override  // Q0.a
    public final int[] f(int v) {
        int v1 = this.m().length();
        if(v1 > 0 && v < v1) {
            if(v < 0) {
                v = 0;
            }
            while(v < v1 && this.m().charAt(v) == 10 && (this.m().charAt(v) == 10 || v != 0 && this.m().charAt(v - 1) != 10)) {
                ++v;
            }
            if(v < v1) {
                int v2;
                for(v2 = v + 1; v2 < v1 && !this.y(v2); ++v2) {
                }
                return this.l(v, v2);
            }
        }
        return null;
    }

    @Override  // Q0.a
    public final int[] s(int v) {
        int v1 = this.m().length();
        if(v1 > 0 && v > 0) {
            if(v > v1) {
                v = v1;
            }
            while(v > 0 && this.m().charAt(v - 1) == 10 && !this.y(v)) {
                --v;
            }
            if(v > 0) {
                int v2;
                for(v2 = v - 1; v2 > 0 && (this.m().charAt(v2) == 10 || v2 != 0 && this.m().charAt(v2 - 1) != 10); --v2) {
                }
                return this.l(v2, v);
            }
        }
        return null;
    }

    public final boolean y(int v) {
        return v > 0 && this.m().charAt(v - 1) != 10 && (v == this.m().length() || this.m().charAt(v) == 10);
    }
}

