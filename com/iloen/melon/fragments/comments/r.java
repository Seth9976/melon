package com.iloen.melon.fragments.comments;

import O.j;
import O.w;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import gd.M6;
import gd.y1;
import ie.H;
import java.util.List;
import jd.R2;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class r implements k {
    public final int a;
    public final boolean b;
    public final int c;
    public final int d;
    public final Object e;
    public final Object f;

    public r(List list0, boolean z, int v, int v1, k k0) {
        this.a = 1;
        super();
        this.e = list0;
        this.b = z;
        this.c = v;
        this.d = v1;
        this.f = k0;
    }

    public r(boolean z, CommentListRenewalViewHolder commentListRenewalViewHolder0, cmtList cmtResViewModel$result$cmtList0, int v, int v1) {
        this.a = 0;
        super();
        this.b = z;
        this.e = commentListRenewalViewHolder0;
        this.f = cmtResViewModel$result$cmtList0;
        this.c = v;
        this.d = v1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((w)object0), "$this$MelonLazyColumn");
            y1 y10 = new y1(20, new M6(13), ((List)this.e));
            hd.w w0 = new hd.w(((List)this.e), 6);
            b b0 = new b(0xBEF78951, new R2(((List)this.e), this.b, this.c, this.d, ((k)this.f)), true);
            ((j)(((w)object0))).u(((List)this.e).size(), y10, w0, b0);
            return H.a;
        }
        return CommentListRenewalViewHolder.f(((cmtList)this.f), ((CommentListRenewalViewHolder)this.e), this.c, this.d, this.b, ((View)object0));
    }
}

