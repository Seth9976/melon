package kf;

import Bf.a;
import jf.l;

public final class b extends a {
    public final int b;
    public final l c;

    public b(l l0, int v) {
        this.b = v;
        this.c = l0;
        super(7);
    }

    @Override  // Bf.a
    public final void q1(String[] arr_s) {
        switch(this.b) {
            case 0: {
                if(arr_s == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'result\' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1.visitEnd must not be null");
                }
                ((c)this.c).b.d = arr_s;
                return;
            }
            case 1: {
                if(arr_s == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'result\' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2.visitEnd must not be null");
                }
                ((c)this.c).b.e = arr_s;
                return;
            }
            default: {
                if(arr_s == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'result\' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1.visitEnd must not be null");
                }
                ((c)this.c).b.h = arr_s;
            }
        }
    }
}

