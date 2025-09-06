package com.iloen.melon.fragments.musicmessage;

import android.view.View.OnClickListener;
import android.view.View;

public final class g implements View.OnClickListener {
    public final int a;
    public final String b;
    public final boolean c;

    public g(String s, boolean z, int v) {
        this.a = v;
        this.b = s;
        this.c = z;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MusicMessageListViewHolder.bindView$lambda$1(this.b, this.c, view0);
            return;
        }
        MusicMessageEditorYouViewHolder.bindView$lambda$0(this.b, this.c, view0);
    }
}

