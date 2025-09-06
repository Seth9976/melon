package com.iloen.melon.fragments.detail.viewholder;

import J8.K1;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;

public final class d implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final cmtList c;
    public final DetailCommentItemHolder d;
    public final int e;
    public final K1 f;

    public d(boolean z, cmtList cmtResViewModel$result$cmtList0, DetailCommentItemHolder detailCommentItemHolder0, int v, K1 k10, int v1) {
        this.a = v1;
        this.b = z;
        this.c = cmtResViewModel$result$cmtList0;
        this.d = detailCommentItemHolder0;
        this.e = v;
        this.f = k10;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            DetailCommentItemHolder.bindItem$lambda$12(this.b, this.c, this.d, this.e, this.f, view0);
            return;
        }
        DetailCommentItemHolder.bindItem$lambda$11(this.b, this.c, this.d, this.e, this.f, view0);
    }
}

