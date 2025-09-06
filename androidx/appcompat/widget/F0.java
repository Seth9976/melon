package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.drawable.Drawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class f0 {
    public static final boolean a;
    public static final Method b;
    public static final Field c;
    public static final Field d;
    public static final Field e;
    public static final Field f;

    static {
        boolean z;
        Field field3;
        Field field1;
        Field field0;
        Method method0;
        Class class0;
        try {
            class0 = Insets.class;
            method0 = null;
            method0 = Drawable.class.getMethod("getOpticalInsets", null);
        }
        catch(NoSuchMethodException unused_ex) {
            field0 = null;
            field1 = null;
            goto label_20;
        }
        catch(ClassNotFoundException unused_ex) {
            field0 = null;
            field1 = null;
            goto label_20;
        }
        catch(NoSuchFieldException unused_ex) {
            field0 = null;
            field1 = null;
            goto label_20;
        }
        try {
            field0 = null;
            field0 = class0.getField("left");
            field1 = null;
            field1 = class0.getField("top");
            goto label_22;
        }
        catch(NoSuchMethodException | ClassNotFoundException unused_ex) {
            field1 = null;
            goto label_20;
        }
        catch(NoSuchFieldException unused_ex) {
        }
        field1 = null;
        goto label_20;
        try {
            field1 = null;
            field1 = class0.getField("top");
            goto label_22;
        }
        catch(NoSuchMethodException | ClassNotFoundException | NoSuchFieldException unused_ex) {
        }
    label_20:
        Field field2 = null;
        goto label_29;
        try {
        label_22:
            field2 = class0.getField("right");
        }
        catch(NoSuchMethodException | ClassNotFoundException | NoSuchFieldException unused_ex) {
            field2 = null;
            goto label_29;
        }
        try {
            field3 = class0.getField("bottom");
            z = true;
            goto label_31;
        }
        catch(NoSuchMethodException | ClassNotFoundException | NoSuchFieldException unused_ex) {
        }
    label_29:
        field3 = null;
        z = false;
    label_31:
        if(z) {
            f0.b = method0;
            f0.c = field0;
            f0.d = field1;
            f0.e = field2;
            f0.f = field3;
            f0.a = true;
            return;
        }
        f0.b = null;
        f0.c = null;
        f0.d = null;
        f0.e = null;
        f0.f = null;
        f0.a = false;
    }
}

