package Hf;

import If.f;

public final class X extends m {
    public final String b;

    public X(String s) {
        this.b = s;
    }

    @Override  // Hf.m
    public final x H(f f0) {
        if(f0 != null) {
            return this;
        }
        X.j0(3);
        throw null;
    }

    @Override  // Hf.B
    public final a0 J(boolean z) {
        this.V(z);
        throw null;
    }

    @Override  // Hf.m
    public final a0 M(f f0) {
        if(f0 != null) {
            return this;
        }
        X.j0(3);
        throw null;
    }

    @Override  // Hf.B
    public final a0 S(I i0) {
        this.W(i0);
        throw null;
    }

    @Override  // Hf.B
    public final B V(boolean z) {
        throw new IllegalStateException(this.b);
    }

    @Override  // Hf.B
    public final B W(I i0) {
        if(i0 != null) {
            throw new IllegalStateException(this.b);
        }
        X.j0(0);
        throw null;
    }

    @Override  // Hf.m
    public final B Y() {
        throw new IllegalStateException(this.b);
    }

    @Override  // Hf.m
    public final B b0(f f0) {
        if(f0 != null) {
            return this;
        }
        X.j0(3);
        throw null;
    }

    @Override  // Hf.m
    public final m c0(B b0) {
        throw new IllegalStateException(this.b);
    }

    public static void j0(int v) {
        Object[] arr_object = new Object[(v == 1 || v == 4 ? 2 : 3)];
        switch(v) {
            case 2: {
                arr_object[0] = "delegate";
                break;
            }
            case 3: {
                arr_object[0] = "kotlinTypeRefiner";
                break;
            }
            case 1: 
            case 4: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                break;
            }
            default: {
                arr_object[0] = "newAttributes";
            }
        }
        switch(v) {
            case 1: {
                arr_object[1] = "toString";
                break;
            }
            case 4: {
                arr_object[1] = "refine";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
        }
        switch(v) {
            case 2: {
                arr_object[2] = "replaceDelegate";
                break;
            }
            case 3: {
                arr_object[2] = "refine";
                break;
            }
            case 1: 
            case 4: {
                break;
            }
            default: {
                arr_object[2] = "replaceAttributes";
            }
        }
        String s = String.format((v == 1 || v == 4 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 1 || v == 4 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    @Override  // Hf.B
    public final String toString() {
        String s = this.b;
        if(s != null) {
            return s;
        }
        X.j0(1);
        throw null;
    }
}

