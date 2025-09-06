package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import e1.u;
import wa.a;

public final class z {
    public final TextView a;
    public final a b;

    public z(TextView textView0) {
        this.a = textView0;
        this.b = new a(textView0);
    }

    public final InputFilter[] a(InputFilter[] arr_inputFilter) {
        return ((u)this.b.a).t(arr_inputFilter);
    }

    public final void b(AttributeSet attributeSet0, int v) {
        boolean z = true;
        TypedArray typedArray0 = this.a.getContext().obtainStyledAttributes(attributeSet0, g.a.j, v, 0);
        try {
            if(typedArray0.hasValue(14)) {
                z = typedArray0.getBoolean(14, true);
            }
        }
        finally {
            typedArray0.recycle();
        }
        this.d(z);
    }

    public final void c(boolean z) {
        ((u)this.b.a).S(z);
    }

    public final void d(boolean z) {
        ((u)this.b.a).T(z);
    }
}

