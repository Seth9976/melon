package x2;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import v2.h;

public final class d implements InputFilter {
    public final TextView a;
    public c b;

    public d(TextView textView0) {
        this.a = textView0;
    }

    @Override  // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence0, int v, int v1, Spanned spanned0, int v2, int v3) {
        TextView textView0 = this.a;
        if(!textView0.isInEditMode()) {
            switch(h.a().c()) {
                case 1: {
                    if((v3 != 0 || v2 != 0 || spanned0.length() != 0 || charSequence0 != textView0.getText()) && charSequence0 != null) {
                        if(v != 0 || v1 != charSequence0.length()) {
                            charSequence0 = charSequence0.subSequence(v, v1);
                        }
                        return h.a().g(0, charSequence0.length(), 0, charSequence0);
                    }
                    break;
                }
                case 0: 
                case 3: {
                    h h0 = h.a();
                    if(this.b == null) {
                        this.b = new c(textView0, this);
                    }
                    h0.h(this.b);
                    return charSequence0;
                }
                default: {
                    return charSequence0;
                }
            }
        }
        return charSequence0;
    }
}

