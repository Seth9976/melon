package com.iloen.melon.fragments.detail.viewholder;

import J8.K1;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;

public final class c implements View.OnClickListener {
    public final boolean a;
    public final DetailCommentItemHolder b;
    public final K1 c;
    public final cmtList d;

    public c(boolean z, DetailCommentItemHolder detailCommentItemHolder0, K1 k10, cmtList cmtResViewModel$result$cmtList0) {
        this.a = z;
        this.b = detailCommentItemHolder0;
        this.c = k10;
        this.d = cmtResViewModel$result$cmtList0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        DetailCommentItemHolder.bindItem$lambda$9(this.a, this.b, this.c, this.d, view0);
    }
}

