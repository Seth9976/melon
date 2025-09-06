package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

public final class m extends AnimatorListenerAdapter {
    public final int a;
    public final TextView b;
    public final int c;
    public final TextView d;
    public final o e;

    public m(o o0, int v, TextView textView0, int v1, TextView textView1) {
        this.e = o0;
        this.a = v;
        this.b = textView0;
        this.c = v1;
        this.d = textView1;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        o o0 = this.e;
        o0.n = this.a;
        o0.l = null;
        TextView textView0 = this.b;
        if(textView0 != null) {
            textView0.setVisibility(4);
            if(this.c == 1) {
                AppCompatTextView appCompatTextView0 = o0.r;
                if(appCompatTextView0 != null) {
                    appCompatTextView0.setText(null);
                }
            }
        }
        TextView textView1 = this.d;
        if(textView1 != null) {
            textView1.setTranslationY(0.0f);
            textView1.setAlpha(1.0f);
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        TextView textView0 = this.d;
        if(textView0 != null) {
            textView0.setVisibility(0);
            textView0.setAlpha(0.0f);
        }
    }
}

