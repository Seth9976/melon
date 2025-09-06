package androidx.appcompat.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class o {
    public final ComponentName a;
    public final long b;
    public final float c;

    public o(ComponentName componentName0, long v, float f) {
        this.a = componentName0;
        this.b = v;
        this.c = f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        Class class0 = object0.getClass();
        if(o.class != class0) {
            return false;
        }
        ComponentName componentName0 = ((o)object0).a;
        ComponentName componentName1 = this.a;
        if(componentName1 == null) {
            if(componentName0 != null) {
                return false;
            }
        }
        else if(!componentName1.equals(componentName0)) {
            return false;
        }
        return this.b == ((o)object0).b ? Float.floatToIntBits(this.c) == Float.floatToIntBits(((o)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? Float.floatToIntBits(this.c) + (961 + ((int)(this.b ^ this.b >>> 0x20))) * 0x1F : Float.floatToIntBits(this.c) + ((this.a.hashCode() + 0x1F) * 0x1F + ((int)(this.b ^ this.b >>> 0x20))) * 0x1F;
    }

    @Override
    public final String toString() {
        return "[; activity:" + this.a + "; time:" + this.b + "; weight:" + new BigDecimal(((double)this.c)) + "]";
    }
}

