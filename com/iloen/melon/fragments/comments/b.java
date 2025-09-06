package com.iloen.melon.fragments.comments;

import android.view.View.OnClickListener;
import android.view.View;
import we.k;

public final class b implements View.OnClickListener {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AdCommentListRenewalViewHolder.bindView$lambda$5(((AdCommentListRenewalViewHolder)this.b), view0);
                return;
            }
            case 1: {
                CommentInputPopup.initView$lambda$4(((CommentInputPopup)this.b), view0);
                return;
            }
            case 2: {
                CommentListRenewalViewHolder.bindView$lambda$5(((CommentListRenewalViewHolder)this.b), view0);
                return;
            }
            default: {
                CommentListRenewalViewHolderKt.setAllOnClickListener$lambda$1$lambda$0(((k)this.b), view0);
            }
        }
    }
}

