package v2;

import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

public final class q implements SpanWatcher, TextWatcher {
    public final Object a;
    public final AtomicInteger b;

    public q(Object object0) {
        this.b = new AtomicInteger(0);
        this.a = object0;
    }

    @Override  // android.text.TextWatcher
    public final void afterTextChanged(Editable editable0) {
        ((TextWatcher)this.a).afterTextChanged(editable0);
    }

    @Override  // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        ((TextWatcher)this.a).beforeTextChanged(charSequence0, v, v1, v2);
    }

    @Override  // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable0, Object object0, int v, int v1) {
        if(this.b.get() > 0 && object0 instanceof t) {
            return;
        }
        ((SpanWatcher)this.a).onSpanAdded(spannable0, object0, v, v1);
    }

    @Override  // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable0, Object object0, int v, int v1, int v2, int v3) {
        int v5;
        int v4;
        if(this.b.get() > 0 && object0 instanceof t) {
            return;
        }
        if(Build.VERSION.SDK_INT < 28) {
            if(v > v1) {
                v = 0;
            }
            if(v2 > v3) {
                v4 = v;
                v5 = 0;
            }
            else {
                v4 = v;
                v5 = v2;
            }
        }
        else {
            v4 = v;
            v5 = v2;
        }
        ((SpanWatcher)this.a).onSpanChanged(spannable0, object0, v4, v1, v5, v3);
    }

    @Override  // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable0, Object object0, int v, int v1) {
        if(this.b.get() > 0 && object0 instanceof t) {
            return;
        }
        ((SpanWatcher)this.a).onSpanRemoved(spannable0, object0, v, v1);
    }

    @Override  // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        ((TextWatcher)this.a).onTextChanged(charSequence0, v, v1, v2);
    }
}

