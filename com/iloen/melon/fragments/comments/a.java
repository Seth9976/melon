package com.iloen.melon.fragments.comments;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;

public final class a implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final cmtList d;
    public final int e;
    public final int f;
    public final CmtBaseViewHolder g;

    public a(boolean z, CmtBaseViewHolder cmtBaseViewHolder0, boolean z1, cmtList cmtResViewModel$result$cmtList0, int v, int v1, int v2) {
        this.a = v2;
        this.b = z;
        this.g = cmtBaseViewHolder0;
        this.c = z1;
        this.d = cmtResViewModel$result$cmtList0;
        this.e = v;
        this.f = v1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            CommentListRenewalViewHolder.bindView$lambda$1(this.b, ((CommentListRenewalViewHolder)this.g), this.c, this.d, this.e, this.f, view0);
            return;
        }
        AdCommentListRenewalViewHolder.bindView$lambda$1(this.b, ((AdCommentListRenewalViewHolder)this.g), this.c, this.d, this.e, this.f, view0);
    }
}

