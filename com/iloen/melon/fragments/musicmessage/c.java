package com.iloen.melon.fragments.musicmessage;

import android.view.View.OnClickListener;
import android.view.View;

public final class c implements View.OnClickListener {
    public final int a;
    public final MusicMessageEditorFragment b;

    public c(MusicMessageEditorFragment musicMessageEditorFragment0, int v) {
        this.a = v;
        this.b = musicMessageEditorFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MusicMessageEditorFragment.v0(this.b, view0);
                return;
            }
            case 1: {
                MusicMessageEditorFragment.t0(this.b, view0);
                return;
            }
            case 2: {
                MusicMessageEditorFragment.u0(this.b, view0);
                return;
            }
            case 3: {
                MusicMessageEditorFragment.w0(this.b, view0);
                return;
            }
            case 4: {
                MusicMessageEditorFragment.onViewCreated$lambda$14(this.b, view0);
                return;
            }
            case 5: {
                MusicMessageEditorFragment.onViewCreated$lambda$16(this.b, view0);
                return;
            }
            case 6: {
                MusicMessageEditorFragment.m0(this.b, view0);
                return;
            }
            case 7: {
                MusicMessageEditorFragment.r0(this.b, view0);
                return;
            }
            default: {
                MusicMessageEditorFragment.k0(this.b, view0);
            }
        }
    }
}

