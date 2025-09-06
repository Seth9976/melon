package com.kakao.emoticon.ui.tab;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final EmoticonTabAdapter a;
    public final TabViewHolder b;
    public final EmoticonTabItem c;

    public a(EmoticonTabAdapter emoticonTabAdapter0, TabViewHolder emoticonTabAdapter$TabViewHolder0, EmoticonTabItem emoticonTabItem0) {
        this.a = emoticonTabAdapter0;
        this.b = emoticonTabAdapter$TabViewHolder0;
        this.c = emoticonTabItem0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        this.a.lambda$onBindViewHolder$0(this.b, this.c, view0);
    }
}

