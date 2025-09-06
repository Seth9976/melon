package com.iloen.melon.fragments.comments;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;

public final class k implements TextView.OnEditorActionListener {
    public final CommentInputPopup a;
    public final Context b;

    public k(CommentInputPopup commentInputPopup0, Context context0) {
        this.a = commentInputPopup0;
        this.b = context0;
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public final boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        return CommentInputPopup.defaultEditorActionListener$lambda$5(this.a, this.b, textView0, v, keyEvent0);
    }
}

