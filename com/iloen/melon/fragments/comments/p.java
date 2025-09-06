package com.iloen.melon.fragments.comments;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;

public final class p implements View.OnClickListener {
    public final CommentListRenewalViewHolder a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final int g;
    public final cmtList h;

    public p(CommentListRenewalViewHolder commentListRenewalViewHolder0, boolean z, boolean z1, boolean z2, boolean z3, int v, int v1, cmtList cmtResViewModel$result$cmtList0) {
        this.a = commentListRenewalViewHolder0;
        this.b = z;
        this.c = z1;
        this.d = z2;
        this.e = z3;
        this.f = v;
        this.g = v1;
        this.h = cmtResViewModel$result$cmtList0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        CommentListRenewalViewHolder.bindView$lambda$7(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
    }
}

