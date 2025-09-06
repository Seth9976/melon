package androidx.appcompat.widget;

import android.text.StaticLayout.Builder;
import android.widget.TextView;

public abstract class a0 {
    public abstract void a(StaticLayout.Builder arg1, TextView arg2);

    public boolean b(TextView textView0) {
        return ((Boolean)b0.e(textView0, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
    }
}

