package Cb;

import a.a;
import android.widget.TextView;

public final class l implements Runnable {
    public final TextView a;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final int e;
    public final int f;
    public final boolean g;

    public l(TextView textView0, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, int v, int v1, boolean z) {
        this.a = textView0;
        this.b = charSequence0;
        this.c = charSequence1;
        this.d = charSequence2;
        this.e = v;
        this.f = v1;
        this.g = z;
    }

    @Override
    public final void run() {
        CharSequence charSequence2;
        CharSequence charSequence1;
        CharSequence charSequence0;
        TextView textView0;
        try {
            textView0 = this.a;
            charSequence0 = this.b;
            charSequence1 = this.c;
            charSequence2 = this.d;
            if(textView0.getLineCount() <= 0) {
                textView0.setMaxLines(1);
                textView0.setSingleLine(true);
                textView0.setText(charSequence0 + charSequence1 + charSequence2);
                textView0.setVisibility(0);
                return;
            }
            int v = textView0.getLineCount();
            int v1 = this.e;
            boolean z = this.g;
            if(v > v1) {
                int v2 = charSequence0.length();
                int v3 = charSequence2.length();
                int v4 = this.f;
                if(v4 > 0) {
                    int v5 = charSequence1.length() - 1;
                    if(v5 < 0) {
                        v5 = 0;
                    }
                    String s = charSequence1.subSequence(0, v5).toString();
                    textView0.setText(charSequence0 + s + "..." + charSequence2);
                    a.E(textView0, charSequence0, s, charSequence2, v1, v4 + 1, z);
                    return;
                }
                int v6 = textView0.getLayout().getLineEnd(v1 - 1) - (v2 + v3 + 3) / 2;
                if(v6 < 0) {
                    v6 = 0;
                }
                int v7 = charSequence1.length();
                if(v6 > v7) {
                    v6 = v7;
                }
                String s1 = charSequence1.subSequence(0, v6).toString();
                textView0.setText(charSequence0 + s1 + "..." + charSequence2);
                a.E(textView0, charSequence0, s1, charSequence2, v1, v4 + 1, z);
                return;
            }
            textView0.setMaxLines(v1);
            textView0.setVisibility(0);
            if(z) {
                a.F(textView0, charSequence0, charSequence1);
            }
        }
        catch(Exception unused_ex) {
            textView0.setText(charSequence0 + charSequence1 + charSequence2);
            textView0.setVisibility(0);
        }
    }
}

