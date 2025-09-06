package com.iloen.melon.fragments.comments;

import android.view.View.OnClickListener;
import android.view.View;

public final class n implements View.OnClickListener {
    public final int a;
    public final CommentListRenewalFragment b;

    public n(CommentListRenewalFragment commentListRenewalFragment0, int v) {
        this.a = v;
        this.b = commentListRenewalFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                CommentListRenewalFragment.buildParallaxHeaderView$lambda$7(this.b, view0);
                return;
            }
            case 1: {
                CommentListRenewalFragment.initTitleBarType$lambda$3$lambda$2(this.b, view0);
                return;
            }
            case 2: {
                CommentListRenewalFragment.initInputType$lambda$4(this.b, view0);
                return;
            }
            default: {
                CommentListRenewalFragment.initInputType$lambda$5(this.b, view0);
            }
        }
    }
}

