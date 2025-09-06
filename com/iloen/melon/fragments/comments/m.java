package com.iloen.melon.fragments.comments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnCreateContextMenuListener;
import we.n;

public final class m implements n {
    public final int a;
    public final View.OnCreateContextMenuListener b;

    public m(View.OnCreateContextMenuListener view$OnCreateContextMenuListener0, int v) {
        this.a = v;
        this.b = view$OnCreateContextMenuListener0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return this.a == 0 ? CommentInputPopup.initView$lambda$3(((CommentInputPopup)this.b), ((int)(((Integer)object0))), ((KeyEvent)object1)) : CommentListRenewalFragment.onViewCreated$lambda$1(((CommentListRenewalFragment)this.b), ((String)object0), ((Bundle)object1));
    }
}

