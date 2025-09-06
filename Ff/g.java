package Ff;

import Me.c;
import Pe.t;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.q;
import tf.k;
import tf.m;

public final class g extends m {
    public final int c;
    public final AbstractCollection d;

    public g(AbstractCollection abstractCollection0, int v) {
        this.c = v;
        this.d = abstractCollection0;
        super();
    }

    @Override  // tf.m
    public static void a(int v) {
        Object[] arr_object = new Object[3];
        switch(v) {
            case 1: {
                arr_object[0] = "fromSuper";
                break;
            }
            case 2: {
                arr_object[0] = "fromCurrent";
                break;
            }
            default: {
                arr_object[0] = "fakeOverride";
            }
        }
        arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
        arr_object[2] = v == 1 || v == 2 ? "conflict" : "addFakeOverride";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", arr_object));
    }

    @Override  // tf.m
    public final void b(c c0) {
        if(this.c != 0) {
            if(c0 != null) {
                k.r(c0, null);
                ((LinkedHashSet)this.d).add(c0);
                return;
            }
            g.a(0);
            throw null;
        }
        q.g(c0, "fakeOverride");
        k.r(c0, null);
        ((ArrayList)this.d).add(c0);
    }

    @Override  // tf.m
    public final void d(c c0, c c1) {
        if(this.c != 0) {
            if(c1 != null) {
                return;
            }
            g.a(2);
            throw null;
        }
        q.g(c1, "fromCurrent");
        if(c1 instanceof t) {
            ((t)c1).A1(Me.q.a, c0);
        }
    }
}

