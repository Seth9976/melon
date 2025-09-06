package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import e0.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public final class a {
    public boolean a;
    public String b;
    public int c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    public a(a a0, Object object0) {
        this.a = false;
        this.b = a0.b;
        this.c = a0.c;
        this.f(object0);
    }

    public final float a() {
        switch(b.b(this.c)) {
            case 0: {
                return (float)this.d;
            }
            case 2: 
            case 3: {
                throw new RuntimeException("Color does not have a single color to interpolate");
            }
            case 4: {
                throw new RuntimeException("Cannot interpolate String");
            }
            case 5: {
                return this.g ? 1.0f : 0.0f;
            }
            case 1: 
            case 6: {
                return this.e;
            }
            default: {
                return NaNf;
            }
        }
    }

    public final void b(float[] arr_f) {
        switch(b.b(this.c)) {
            case 0: {
                arr_f[0] = (float)this.d;
                return;
            }
            case 1: {
                arr_f[0] = this.e;
                return;
            }
            case 2: 
            case 3: {
                int v = this.h >> 24 & 0xFF;
                float f = (float)Math.pow(((float)(this.h >> 8 & 0xFF)) / 255.0f, 2.2);
                float f1 = (float)Math.pow(((float)(this.h & 0xFF)) / 255.0f, 2.2);
                arr_f[0] = (float)Math.pow(((float)(this.h >> 16 & 0xFF)) / 255.0f, 2.2);
                arr_f[1] = f;
                arr_f[2] = f1;
                arr_f[3] = ((float)v) / 255.0f;
                return;
            }
            case 4: {
                throw new RuntimeException("Color does not have a single color to interpolate");
            }
            case 5: {
                arr_f[0] = this.g ? 1.0f : 0.0f;
                return;
            }
            case 6: {
                arr_f[0] = this.e;
            }
        }
    }

    public final int c() {
        switch(b.b(this.c)) {
            case 2: 
            case 3: {
                return 4;
            }
            default: {
                return 1;
            }
        }
    }

    public static void d(Context context0, XmlResourceParser xmlResourceParser0, HashMap hashMap0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser0), q.h);
        int v = typedArray0.getIndexCount();
        String s = null;
        int v2 = 0;
        boolean z = false;
        Object object0 = null;
        for(int v1 = 0; v1 < v; ++v1) {
            int v3 = typedArray0.getIndex(v1);
            if(v3 == 0) {
                s = typedArray0.getString(0);
                if(s != null && s.length() > 0) {
                    s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
                }
            }
            else {
                switch(v3) {
                    case 1: {
                        object0 = Boolean.valueOf(typedArray0.getBoolean(1, false));
                        v2 = 6;
                        break;
                    }
                    case 2: {
                        object0 = typedArray0.getColor(2, 0);
                        v2 = 4;
                        break;
                    }
                    case 3: {
                        object0 = typedArray0.getColor(3, 0);
                        v2 = 3;
                        break;
                    }
                    case 4: {
                        object0 = typedArray0.getDimension(4, 0.0f);
                        v2 = 7;
                        break;
                    }
                    case 5: {
                        object0 = typedArray0.getFloat(5, NaNf);
                        v2 = 2;
                        break;
                    }
                    case 6: {
                        object0 = typedArray0.getInteger(6, -1);
                        v2 = 1;
                        break;
                    }
                    case 7: {
                        object0 = TypedValue.applyDimension(1, typedArray0.getDimension(7, 0.0f), context0.getResources().getDisplayMetrics());
                        v2 = 7;
                        break;
                    }
                    case 8: {
                        int v4 = typedArray0.getResourceId(8, -1);
                        if(v4 == -1) {
                            v4 = typedArray0.getInt(8, -1);
                        }
                        object0 = v4;
                        v2 = 8;
                        break;
                    }
                    case 9: {
                        object0 = typedArray0.getString(9);
                        v2 = 4;
                        break;
                    }
                    case 10: {
                        s = typedArray0.getString(10);
                        z = true;
                    }
                }
            }
        }
        if(s != null && object0 != null) {
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.b = s;
            a0.c = v2;
            a0.a = z;
            a0.f(object0);
            hashMap0.put(s, a0);
        }
        typedArray0.recycle();
    }

    public static void e(View view0, HashMap hashMap0) {
        Class class0 = view0.getClass();
        for(Object object0: hashMap0.keySet()) {
            String s = (String)object0;
            a a0 = (a)hashMap0.get(s);
            String s1 = a0.a ? s : "set" + s;
            try {
                int v = b.b(a0.c);
                Class class1 = Float.TYPE;
                Class class2 = Integer.TYPE;
                switch(v) {
                    case 0: {
                        class0.getMethod(s1, class2).invoke(view0, a0.d);
                        continue;
                    }
                    case 1: {
                        class0.getMethod(s1, class1).invoke(view0, a0.e);
                        continue;
                    }
                    case 2: {
                        class0.getMethod(s1, class2).invoke(view0, a0.h);
                        continue;
                    }
                    case 3: {
                        Method method0 = class0.getMethod(s1, Drawable.class);
                        ColorDrawable colorDrawable0 = new ColorDrawable();
                        colorDrawable0.setColor(a0.h);
                        method0.invoke(view0, colorDrawable0);
                        continue;
                    }
                    case 4: {
                        class0.getMethod(s1, CharSequence.class).invoke(view0, a0.f);
                        continue;
                    }
                    case 5: {
                        class0.getMethod(s1, Boolean.TYPE).invoke(view0, Boolean.valueOf(a0.g));
                        continue;
                    }
                    case 6: {
                        class0.getMethod(s1, class1).invoke(view0, a0.e);
                        continue;
                    }
                    case 7: {
                        class0.getMethod(s1, class2).invoke(view0, a0.d);
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
            catch(NoSuchMethodException noSuchMethodException0) {
            }
            catch(IllegalAccessException illegalAccessException0) {
                goto label_38;
            }
            catch(InvocationTargetException invocationTargetException0) {
                goto label_43;
            }
            Log.e("TransitionLayout", class0.getName() + " must have a method " + s1, noSuchMethodException0);
            continue;
        label_38:
            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n(" Custom Attribute \"", s, "\" not found on ");
            stringBuilder0.append(class0.getName());
            Log.e("TransitionLayout", stringBuilder0.toString(), illegalAccessException0);
            continue;
        label_43:
            StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n(" Custom Attribute \"", s, "\" not found on ");
            stringBuilder1.append(class0.getName());
            Log.e("TransitionLayout", stringBuilder1.toString(), invocationTargetException0);
        }
    }

    public final void f(Object object0) {
        switch(b.b(this.c)) {
            case 1: {
                this.e = (float)(((Float)object0));
                return;
            }
            case 2: 
            case 3: {
                this.h = (int)(((Integer)object0));
                return;
            }
            case 4: {
                this.f = (String)object0;
                return;
            }
            case 5: {
                this.g = ((Boolean)object0).booleanValue();
                return;
            }
            case 6: {
                this.e = (float)(((Float)object0));
                return;
            }
            case 0: 
            case 7: {
                this.d = (int)(((Integer)object0));
            }
        }
    }
}

