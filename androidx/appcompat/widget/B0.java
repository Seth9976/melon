package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public final class b0 {
    public int a;
    public boolean b;
    public float c;
    public float d;
    public float e;
    public int[] f;
    public boolean g;
    public TextPaint h;
    public final TextView i;
    public final Context j;
    public final Y k;
    public static final RectF l;
    public static final ConcurrentHashMap m;

    static {
        b0.l = new RectF();
        b0.m = new ConcurrentHashMap();
    }

    public b0(TextView textView0) {
        this.a = 0;
        this.b = false;
        this.c = -1.0f;
        this.d = -1.0f;
        this.e = -1.0f;
        this.f = new int[0];
        this.g = false;
        this.i = textView0;
        this.j = textView0.getContext();
        if(Build.VERSION.SDK_INT >= 29) {
            this.k = new Z();
            return;
        }
        this.k = new Y();
    }

    public final void a() {
        if(this.f()) {
            if(!this.b) {
                this.b = true;
                return;
            }
            if(this.i.getMeasuredHeight() > 0 && this.i.getMeasuredWidth() > 0) {
                int v = this.k.b(this.i) ? 0x100000 : this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft() - this.i.getTotalPaddingRight();
                int v1 = this.i.getHeight() - this.i.getCompoundPaddingBottom() - this.i.getCompoundPaddingTop();
                if(v > 0 && v1 > 0) {
                    RectF rectF0 = b0.l;
                    synchronized(rectF0) {
                        rectF0.setEmpty();
                        rectF0.right = (float)v;
                        rectF0.bottom = (float)v1;
                        float f = (float)this.c(rectF0);
                        if(f != this.i.getTextSize()) {
                            this.g(f, 0);
                        }
                    }
                    this.b = true;
                }
            }
        }
    }

    public static int[] b(int[] arr_v) {
        if(arr_v.length != 0) {
            Arrays.sort(arr_v);
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                int v2 = arr_v[v1];
                if(v2 > 0 && Collections.binarySearch(arrayList0, v2) < 0) {
                    arrayList0.add(v2);
                }
            }
            if(arr_v.length != arrayList0.size()) {
                int v3 = arrayList0.size();
                int[] arr_v1 = new int[v3];
                for(int v = 0; v < v3; ++v) {
                    arr_v1[v] = (int)(((Integer)arrayList0.get(v)));
                }
                return arr_v1;
            }
        }
        return arr_v;
    }

    public final int c(RectF rectF0) {
        int v = this.f.length;
        if(v == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int v1 = v - 1;
        int v2 = 0;
        int v3 = 1;
        while(v3 <= v1) {
            int v4 = (v3 + v1) / 2;
            int v5 = this.f[v4];
            TextView textView0 = this.i;
            CharSequence charSequence0 = textView0.getText();
            TransformationMethod transformationMethod0 = textView0.getTransformationMethod();
            if(transformationMethod0 != null) {
                CharSequence charSequence1 = transformationMethod0.getTransformation(charSequence0, textView0);
                if(charSequence1 != null) {
                    charSequence0 = charSequence1;
                }
            }
            int v6 = textView0.getMaxLines();
            TextPaint textPaint0 = this.h;
            if(textPaint0 == null) {
                this.h = new TextPaint();
            }
            else {
                textPaint0.reset();
            }
            this.h.set(textView0.getPaint());
            this.h.setTextSize(((float)v5));
            StaticLayout staticLayout0 = X.a(charSequence0, ((Layout.Alignment)b0.e(textView0, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL)), Math.round(rectF0.right), v6, textView0, this.h, this.k);
            if(v6 != -1 && (staticLayout0.getLineCount() > v6 || staticLayout0.getLineEnd(staticLayout0.getLineCount() - 1) != charSequence0.length()) || ((float)staticLayout0.getHeight()) > rectF0.bottom) {
                v2 = v4 - 1;
                v1 = v2;
            }
            else {
                v2 = v3;
                v3 = v4 + 1;
            }
        }
        return this.f[v2];
    }

    public static Method d(String s) {
        try {
            ConcurrentHashMap concurrentHashMap0 = b0.m;
            Method method0 = (Method)concurrentHashMap0.get(s);
            if(method0 == null) {
                method0 = TextView.class.getDeclaredMethod(s, null);
                if(method0 != null) {
                    method0.setAccessible(true);
                    concurrentHashMap0.put(s, method0);
                    return method0;
                }
            }
            return method0;
        }
        catch(Exception exception0) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + s + "() method", exception0);
            return null;
        }
    }

    public static Object e(Object object0, String s, Object object1) {
        try {
            return b0.d(s).invoke(object0, null);
        }
        catch(Exception exception0) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + s + "() method", exception0);
            return object1;
        }
    }

    public final boolean f() {
        return this.j() && this.a != 0;
    }

    public final void g(float f, int v) {
        float f1 = TypedValue.applyDimension(v, f, (this.j == null ? Resources.getSystem() : this.j.getResources()).getDisplayMetrics());
        TextView textView0 = this.i;
        if(f1 != textView0.getPaint().getTextSize()) {
            textView0.getPaint().setTextSize(f1);
            boolean z = textView0.isInLayout();
            if(textView0.getLayout() != null) {
                try {
                    this.b = false;
                    Method method0 = b0.d("nullLayouts");
                    if(method0 != null) {
                        method0.invoke(textView0, null);
                    }
                }
                catch(Exception exception0) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", exception0);
                }
                if(z) {
                    textView0.forceLayout();
                }
                else {
                    textView0.requestLayout();
                }
                textView0.invalidate();
            }
        }
    }

    public final boolean h() {
        if(this.j() && this.a == 1) {
            if(!this.g || this.f.length == 0) {
                int v1 = ((int)Math.floor((this.e - this.d) / this.c)) + 1;
                int[] arr_v = new int[v1];
                for(int v = 0; v < v1; ++v) {
                    arr_v[v] = Math.round(((float)v) * this.c + this.d);
                }
                this.f = b0.b(arr_v);
            }
            this.b = true;
            return true;
        }
        this.b = false;
        return false;
    }

    public final boolean i() {
        int[] arr_v = this.f;
        boolean z = arr_v.length > 0;
        this.g = z;
        if(z) {
            this.a = 1;
            this.d = (float)arr_v[0];
            this.e = (float)arr_v[arr_v.length - 1];
            this.c = -1.0f;
        }
        return z;
    }

    public final boolean j() {
        return !(this.i instanceof AppCompatEditText);
    }

    public final void k(float f, float f1, float f2) {
        if(Float.compare(f, 0.0f) <= 0) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if(f1 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f1 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if(f2 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f2 + "px) is less or equal to (0px)");
        }
        this.a = 1;
        this.d = f;
        this.e = f1;
        this.c = f2;
        this.g = false;
    }
}

