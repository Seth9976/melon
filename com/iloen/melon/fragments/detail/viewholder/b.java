package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;

public final class b implements View.OnClickListener {
    public final int a;
    public final DetailCommentItemHolder b;
    public final cmtList c;
    public final int d;
    public final boolean e;
    public final boolean f;

    public b(DetailCommentItemHolder detailCommentItemHolder0, cmtList cmtResViewModel$result$cmtList0, int v, boolean z, boolean z1) {
        this.a = 1;
        super();
        this.b = detailCommentItemHolder0;
        this.c = cmtResViewModel$result$cmtList0;
        this.d = v;
        this.e = z;
        this.f = z1;
    }

    public b(boolean z, DetailCommentItemHolder detailCommentItemHolder0, boolean z1, cmtList cmtResViewModel$result$cmtList0, int v) {
        this.a = 0;
        super();
        this.e = z;
        this.b = detailCommentItemHolder0;
        this.f = z1;
        this.c = cmtResViewModel$result$cmtList0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            DetailCommentItemHolder.bindItem$lambda$10(this.b, this.c, this.d, this.e, this.f, view0);
            return;
        }
        DetailCommentItemHolder.c(this.b, this.c, this.d, this.e, this.f, view0);
    }
}

