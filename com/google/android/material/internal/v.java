package com.google.android.material.internal;

import android.text.Layout.Alignment;
import android.text.StaticLayout.Builder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;

public final class v {
    public CharSequence a;
    public final TextPaint b;
    public final int c;
    public int d;
    public Layout.Alignment e;
    public int f;
    public float g;
    public float h;
    public int i;
    public boolean j;
    public boolean k;
    public TextUtils.TruncateAt l;

    public v(CharSequence charSequence0, TextPaint textPaint0, int v) {
        this.a = charSequence0;
        this.b = textPaint0;
        this.c = v;
        this.d = charSequence0.length();
        this.e = Layout.Alignment.ALIGN_NORMAL;
        this.f = 0x7FFFFFFF;
        this.g = 0.0f;
        this.h = 1.0f;
        this.i = 1;
        this.j = true;
        this.l = null;
    }

    public final StaticLayout a() {
        if(this.a == null) {
            this.a = "";
        }
        int v = Math.max(0, this.c);
        CharSequence charSequence0 = this.a;
        TextPaint textPaint0 = this.b;
        if(this.f == 1) {
            charSequence0 = TextUtils.ellipsize(charSequence0, textPaint0, ((float)v), this.l);
        }
        int v1 = Math.min(charSequence0.length(), this.d);
        this.d = v1;
        if(this.k && this.f == 1) {
            this.e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder staticLayout$Builder0 = StaticLayout.Builder.obtain(charSequence0, 0, v1, textPaint0, v);
        staticLayout$Builder0.setAlignment(this.e);
        staticLayout$Builder0.setIncludePad(this.j);
        staticLayout$Builder0.setTextDirection((this.k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR));
        TextUtils.TruncateAt textUtils$TruncateAt0 = this.l;
        if(textUtils$TruncateAt0 != null) {
            staticLayout$Builder0.setEllipsize(textUtils$TruncateAt0);
        }
        staticLayout$Builder0.setMaxLines(this.f);
        float f = this.g;
        if(f != 0.0f || this.h != 1.0f) {
            staticLayout$Builder0.setLineSpacing(f, this.h);
        }
        if(this.f > 1) {
            staticLayout$Builder0.setHyphenationFrequency(this.i);
        }
        return staticLayout$Builder0.build();
    }
}

