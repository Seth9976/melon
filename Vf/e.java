package vf;

import Hf.x;
import Je.i;
import Je.k;
import Me.z;
import java.util.Arrays;

public final class e extends q {
    @Override  // vf.g
    public final x a(z z0) {
        kotlin.jvm.internal.q.g(z0, "module");
        i i0 = z0.d();
        i0.getClass();
        return i0.t(k.g);
    }

    @Override  // vf.g
    public final String toString() {
        Integer integer0 = (int)((Character)this.a).charValue();
        int v = ((Character)this.a).charValue();
        switch(v) {
            case 8: {
                return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, "\\b"}, 2));
            }
            case 9: {
                return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, "\\t"}, 2));
            }
            case 10: {
                return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, "\\n"}, 2));
            }
            case 12: {
                return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, "\\f"}, 2));
            }
            case 13: {
                return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, "\\r"}, 2));
            }
            default: {
                switch(((byte)Character.getType(((char)v)))) {
                    case 0: 
                    case 13: 
                    case 14: 
                    case 15: 
                    case 16: 
                    case 18: 
                    case 19: {
                        return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, "?"}, 2));
                    }
                    default: {
                        return String.format("\\u%04X (\'%s\')", Arrays.copyOf(new Object[]{integer0, String.valueOf(((char)v))}, 2));
                    }
                }
            }
        }
    }
}

