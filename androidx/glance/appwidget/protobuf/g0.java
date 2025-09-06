package androidx.glance.appwidget.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class g0 extends h0 {
    @Override  // androidx.glance.appwidget.protobuf.h0
    public final boolean c(long v, Object object0) {
        return this.a.getBoolean(object0, v);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final double d(long v, Object object0) {
        return this.a.getDouble(object0, v);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final float e(long v, Object object0) {
        return this.a.getFloat(object0, v);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final void j(Object object0, long v, boolean z) {
        this.a.putBoolean(object0, v, z);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final void k(Object object0, long v, byte b) {
        this.a.putByte(object0, v, b);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final void l(Object object0, long v, double f) {
        this.a.putDouble(object0, v, f);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final void m(Object object0, long v, float f) {
        this.a.putFloat(object0, v, f);
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final boolean q() {
        Class class0 = Object.class;
        if(!super.q()) {
            return false;
        }
        try {
            Class class1 = this.a.getClass();
            Class class2 = Long.TYPE;
            class1.getMethod("getByte", class0, class2);
            class1.getMethod("putByte", class0, class2, Byte.TYPE);
            class1.getMethod("getBoolean", class0, class2);
            class1.getMethod("putBoolean", class0, class2, Boolean.TYPE);
            class1.getMethod("getFloat", class0, class2);
            class1.getMethod("putFloat", class0, class2, Float.TYPE);
            class1.getMethod("getDouble", class0, class2);
            class1.getMethod("putDouble", class0, class2, Double.TYPE);
            return true;
        }
        catch(Throwable throwable0) {
            i0.a(throwable0);
            return false;
        }
    }

    @Override  // androidx.glance.appwidget.protobuf.h0
    public final boolean r() {
        Class class2;
        Class class0 = Object.class;
        Unsafe unsafe0 = this.a;
        if(unsafe0 != null) {
            try {
                Class class1 = unsafe0.getClass();
                class1.getMethod("objectFieldOffset", Field.class);
                class2 = Long.TYPE;
                class1.getMethod("getLong", class0, class2);
                if(i0.g() != null) {
                    goto label_12;
                }
            }
            catch(Throwable throwable0) {
                i0.a(throwable0);
            }
            return false;
            try {
            label_12:
                Class class3 = this.a.getClass();
                class3.getMethod("getByte", class2);
                class3.getMethod("putByte", class2, Byte.TYPE);
                class3.getMethod("getInt", class2);
                class3.getMethod("putInt", class2, Integer.TYPE);
                class3.getMethod("getLong", class2);
                class3.getMethod("putLong", class2, class2);
                class3.getMethod("copyMemory", class2, class2, class2);
                class3.getMethod("copyMemory", class0, class2, class0, class2, class2);
                return true;
            }
            catch(Throwable throwable1) {
                i0.a(throwable1);
                return false;
            }
        }
        return false;
    }
}

