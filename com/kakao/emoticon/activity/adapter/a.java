package com.kakao.emoticon.activity.adapter;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import androidx.recyclerview.widget.O0;

public final class a implements View.OnTouchListener {
    public final EmoticonEditAdapter a;
    public final O0 b;

    public a(EmoticonEditAdapter emoticonEditAdapter0, EmoticonSetViewHolder emoticonEditAdapter$EmoticonSetViewHolder0) {
        this.a = emoticonEditAdapter0;
        this.b = emoticonEditAdapter$EmoticonSetViewHolder0;
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        return this.a.lambda$onBindViewHolder$1(this.b, view0, motionEvent0);
    }
}

