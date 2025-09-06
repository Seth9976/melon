package v2;

import Q1.c;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class r extends SpannableStringBuilder {
    public final Class a;
    public final ArrayList b;

    public r(Class class0, CharSequence charSequence0) {
        super(charSequence0);
        this.b = new ArrayList();
        c.o(class0, "watcherClass cannot be null");
        this.a = class0;
    }

    public r(Class class0, r r0, int v, int v1) {
        super(r0, v, v1);
        this.b = new ArrayList();
        c.o(class0, "watcherClass cannot be null");
        this.a = class0;
    }

    public final void a() {
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.b;
            if(v >= arrayList0.size()) {
                break;
            }
            ((q)arrayList0.get(v)).b.incrementAndGet();
        }
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable append(char c) {
        super.append(c);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable append(CharSequence charSequence0) {
        super.append(charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable append(CharSequence charSequence0, int v, int v1) {
        super.append(charSequence0, v, v1);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence0) {
        super.append(charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence0, int v, int v1) {
        super.append(charSequence0, v, v1);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence0, Object object0, int v) {
        super.append(charSequence0, object0, v);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Appendable append(char c) {
        super.append(c);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Appendable append(CharSequence charSequence0) {
        super.append(charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Appendable append(CharSequence charSequence0, int v, int v1) {
        super.append(charSequence0, v, v1);
        return this;
    }

    public final void b() {
        this.e();
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.b;
            if(v >= arrayList0.size()) {
                break;
            }
            ((q)arrayList0.get(v)).onTextChanged(this, 0, this.length(), this.length());
        }
    }

    public final q c(Object object0) {
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.b;
            if(v >= arrayList0.size()) {
                break;
            }
            q q0 = (q)arrayList0.get(v);
            if(q0.a == object0) {
                return q0;
            }
        }
        return null;
    }

    public final boolean d(Object object0) {
        if(object0 != null) {
            Class class0 = object0.getClass();
            return this.a == class0;
        }
        return false;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable delete(int v, int v1) {
        super.delete(v, v1);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder delete(int v, int v1) {
        super.delete(v, v1);
        return this;
    }

    public final void e() {
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.b;
            if(v >= arrayList0.size()) {
                break;
            }
            ((q)arrayList0.get(v)).b.decrementAndGet();
        }
    }

    @Override  // android.text.SpannableStringBuilder
    public final int getSpanEnd(Object object0) {
        if(this.d(object0)) {
            q q0 = this.c(object0);
            if(q0 != null) {
                object0 = q0;
            }
        }
        return super.getSpanEnd(object0);
    }

    @Override  // android.text.SpannableStringBuilder
    public final int getSpanFlags(Object object0) {
        if(this.d(object0)) {
            q q0 = this.c(object0);
            if(q0 != null) {
                object0 = q0;
            }
        }
        return super.getSpanFlags(object0);
    }

    @Override  // android.text.SpannableStringBuilder
    public final int getSpanStart(Object object0) {
        if(this.d(object0)) {
            q q0 = this.c(object0);
            if(q0 != null) {
                object0 = q0;
            }
        }
        return super.getSpanStart(object0);
    }

    @Override  // android.text.SpannableStringBuilder
    public final Object[] getSpans(int v, int v1, Class class0) {
        if(this.a == class0) {
            q[] arr_q = (q[])super.getSpans(v, v1, q.class);
            Object[] arr_object = (Object[])Array.newInstance(class0, arr_q.length);
            for(int v2 = 0; v2 < arr_q.length; ++v2) {
                arr_object[v2] = arr_q[v2].a;
            }
            return arr_object;
        }
        return super.getSpans(v, v1, class0);
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable insert(int v, CharSequence charSequence0) {
        super.insert(v, charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable insert(int v, CharSequence charSequence0, int v1, int v2) {
        super.insert(v, charSequence0, v1, v2);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder insert(int v, CharSequence charSequence0) {
        super.insert(v, charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder insert(int v, CharSequence charSequence0, int v1, int v2) {
        super.insert(v, charSequence0, v1, v2);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final int nextSpanTransition(int v, int v1, Class class0) {
        if(class0 == null || this.a == class0) {
            class0 = q.class;
        }
        return super.nextSpanTransition(v, v1, class0);
    }

    @Override  // android.text.SpannableStringBuilder
    public final void removeSpan(Object object0) {
        q q0;
        if(this.d(object0)) {
            q0 = this.c(object0);
            if(q0 != null) {
                object0 = q0;
            }
        }
        else {
            q0 = null;
        }
        super.removeSpan(object0);
        if(q0 != null) {
            this.b.remove(q0);
        }
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable replace(int v, int v1, CharSequence charSequence0) {
        this.replace(v, v1, charSequence0);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final Editable replace(int v, int v1, CharSequence charSequence0, int v2, int v3) {
        this.replace(v, v1, charSequence0, v2, v3);
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder replace(int v, int v1, CharSequence charSequence0) {
        this.a();
        super.replace(v, v1, charSequence0);
        this.e();
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final SpannableStringBuilder replace(int v, int v1, CharSequence charSequence0, int v2, int v3) {
        this.a();
        super.replace(v, v1, charSequence0, v2, v3);
        this.e();
        return this;
    }

    @Override  // android.text.SpannableStringBuilder
    public final void setSpan(Object object0, int v, int v1, int v2) {
        if(this.d(object0)) {
            q q0 = new q(object0);
            this.b.add(q0);
            object0 = q0;
        }
        super.setSpan(object0, v, v1, v2);
    }

    @Override  // android.text.SpannableStringBuilder
    public final CharSequence subSequence(int v, int v1) {
        return new r(this.a, this, v, v1);
    }
}

