package nf;

import f0.I;
import rf.n;

public final class c extends I {
    public final n[] d;

    public c(int v, n[] arr_n) {
        if(arr_n == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'enumEntries\' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
        }
        int v1 = 1;
        int v2 = arr_n.length - 1;
        if(v2 != 0) {
            for(int v3 = 0x1F; v3 >= 0; --v3) {
                if((1 << v3 & v2) != 0) {
                    v1 = v3 + 1;
                    super(v, v1, 1, 0);
                    this.d = arr_n;
                    return;
                }
            }
            throw new IllegalStateException("Empty enum: " + arr_n.getClass());
        }
        super(v, v1, 1, 0);
        this.d = arr_n;
    }

    @Override  // f0.I
    public final Object d(int v) {
        int v1 = (v & (1 << this.c) - 1 << this.b) >> this.b;
        n[] arr_n = this.d;
        for(int v2 = 0; v2 < arr_n.length; ++v2) {
            n n0 = arr_n[v2];
            if(n0.a() == v1) {
                return n0;
            }
        }
        return null;
    }
}

