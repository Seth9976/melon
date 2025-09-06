package com.iloen.melon.fragments;

import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.View;

public final class k implements View.OnKeyListener {
    public final EditorBaseFragment a;

    public k(EditorBaseFragment editorBaseFragment0) {
        this.a = editorBaseFragment0;
    }

    @Override  // android.view.View$OnKeyListener
    public final boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        return this.a.lambda$onViewCreated$0(view0, v, keyEvent0);
    }
}

