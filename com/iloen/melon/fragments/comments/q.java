package com.iloen.melon.fragments.comments;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;

public final class q implements View.OnClickListener {
    public final int a;
    public final cmtList b;
    public final CmtBaseViewHolder c;
    public final int d;
    public final int e;
    public final boolean f;

    public q(AdCommentListRenewalViewHolder adCommentListRenewalViewHolder0, boolean z, int v, int v1, cmtList cmtResViewModel$result$cmtList0) {
        this.a = 2;
        super();
        this.c = adCommentListRenewalViewHolder0;
        this.f = z;
        this.d = v;
        this.e = v1;
        this.b = cmtResViewModel$result$cmtList0;
    }

    public q(cmtList cmtResViewModel$result$cmtList0, CommentListRenewalViewHolder commentListRenewalViewHolder0, int v, int v1, boolean z, int v2) {
        this.a = v2;
        this.b = cmtResViewModel$result$cmtList0;
        this.c = commentListRenewalViewHolder0;
        this.d = v;
        this.e = v1;
        this.f = z;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                CommentListRenewalViewHolder.bindView$lambda$8(this.b, ((CommentListRenewalViewHolder)this.c), this.d, this.e, this.f, view0);
                return;
            }
            case 1: {
                CommentListRenewalViewHolder.bindView$lambda$9(this.b, ((CommentListRenewalViewHolder)this.c), this.d, this.e, this.f, view0);
                return;
            }
            default: {
                AdCommentListRenewalViewHolder.bindView$lambda$6(((AdCommentListRenewalViewHolder)this.c), this.f, this.d, this.e, this.b, view0);
            }
        }
    }
}

