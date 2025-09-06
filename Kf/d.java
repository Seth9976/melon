package kf;

import Bf.a;

public final class d extends a {
    public final int b;
    public final c c;

    public d(c c0, int v) {
        this.b = v;
        this.c = c0;
        super(7);
    }

    @Override  // Bf.a
    public final void q1(String[] arr_s) {
        if(this.b != 0) {
            if(arr_s == null) {
                throw new IllegalArgumentException("Argument for @NotNull parameter \'data\' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2.visitEnd must not be null");
            }
            this.c.b.e = arr_s;
            return;
        }
        if(arr_s == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'data\' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1.visitEnd must not be null");
        }
        this.c.b.d = arr_s;
    }
}

