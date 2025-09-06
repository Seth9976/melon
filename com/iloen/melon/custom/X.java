package com.iloen.melon.custom;

import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public final class x extends NumberKeyListener {
    public final int a;
    public final LinearLayout b;

    public x(LinearLayout linearLayout0, int v) {
        this.a = v;
        this.b = linearLayout0;
        super();
    }

    @Override  // android.text.method.NumberKeyListener
    public final CharSequence filter(CharSequence charSequence0, int v, int v1, Spanned spanned0, int v2, int v3) {
        int v7;
        LinearLayout linearLayout0 = this.b;
        if(this.a != 0) {
            C0 c00 = ((NumberPicker)linearLayout0).g0;
            if(c00 != null && c00.d) {
                ((EditText)c00.e).removeCallbacks(c00);
                c00.d = false;
            }
            if(((NumberPicker)linearLayout0).w == null) {
                CharSequence charSequence1 = super.filter(charSequence0, v, v1, spanned0, v2, v3);
                if(charSequence1 == null) {
                    charSequence1 = charSequence0.subSequence(v, v1);
                }
                String s = String.valueOf(spanned0.subSequence(0, v2)) + charSequence1 + spanned0.subSequence(v3, spanned0.length());
                if("".equals(s)) {
                    return s;
                }
                if(((NumberPicker)linearLayout0).e(s) <= ((NumberPicker)linearLayout0).D && s.length() <= String.valueOf(((NumberPicker)linearLayout0).D).length()) {
                    return charSequence1;
                }
            }
            else {
                String s1 = String.valueOf(charSequence0.subSequence(v, v1));
                if(!TextUtils.isEmpty(s1)) {
                    String s2 = spanned0.subSequence(0, v2) + s1 + spanned0.subSequence(v3, spanned0.length());
                    String s3 = String.valueOf(s2).toLowerCase();
                    String[] arr_s = ((NumberPicker)linearLayout0).w;
                    for(int v4 = 0; v4 < arr_s.length; ++v4) {
                        String s4 = arr_s[v4];
                        if(s4.toLowerCase().startsWith(s3)) {
                            int v5 = s2.length();
                            int v6 = s4.length();
                            C0 c01 = ((NumberPicker)linearLayout0).g0;
                            if(c01 == null) {
                                ((NumberPicker)linearLayout0).g0 = new C0(((NumberPicker)linearLayout0).a);
                                return s4.subSequence(v2, s4.length());
                            }
                            c01.b = v5;
                            c01.c = v6;
                            if(!c01.d) {
                                ((EditText)c01.e).post(c01);
                                c01.d = true;
                            }
                            return s4.subSequence(v2, s4.length());
                        }
                    }
                }
            }
            return "";
        }
        CharSequence charSequence2 = super.filter(charSequence0, v, v1, spanned0, v2, v3);
        if(charSequence2 == null) {
            charSequence2 = charSequence0.subSequence(v, v1);
        }
        String s5 = String.valueOf(spanned0.subSequence(0, v2)) + charSequence2 + spanned0.subSequence(v3, spanned0.length());
        if("".equals(s5)) {
            return s5;
        }
        try {
            v7 = Integer.parseInt(s5);
        }
        catch(NumberFormatException unused_ex) {
            v7 = ((CustomNumberPicker)linearLayout0).c;
        }
        return v7 <= ((CustomNumberPicker)linearLayout0).d && s5.length() <= String.valueOf(((CustomNumberPicker)linearLayout0).d).length() ? charSequence2 : "";
    }

    @Override  // android.text.method.NumberKeyListener
    public final char[] getAcceptedChars() {
        return this.a == 0 ? CustomNumberPicker.f : NumberPicker.P0;
    }

    @Override  // android.text.method.KeyListener
    public final int getInputType() {
        return 1;
    }
}

