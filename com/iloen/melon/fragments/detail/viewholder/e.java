package com.iloen.melon.fragments.detail.viewholder;

import O.j;
import O.w;
import android.view.View;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class e implements k {
    public final int a;
    public final int b;
    public final boolean c;
    public final Object d;
    public final Object e;

    public e(List list0, int v, boolean z, k k0) {
        this.a = 1;
        super();
        this.d = list0;
        this.b = v;
        this.c = z;
        this.e = k0;
    }

    public e(boolean z, DetailCommentItemHolder detailCommentItemHolder0, cmtList cmtResViewModel$result$cmtList0, int v) {
        this.a = 0;
        super();
        this.c = z;
        this.d = detailCommentItemHolder0;
        this.e = cmtResViewModel$result$cmtList0;
        this.b = v;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((w)object0), "$this$LazyColumn");
            com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.2 commonFilterPopupKt$CommonFilterList$lambda$70$lambda$68$lambda$67$$inlined$itemsIndexed$default$20 = new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.2(((List)this.d));
            b b0 = new b(0xBEF78951, new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.3(((List)this.d), this.b, this.c, ((k)this.e)), true);
            ((j)(((w)object0))).u(((List)this.d).size(), null, commonFilterPopupKt$CommonFilterList$lambda$70$lambda$68$lambda$67$$inlined$itemsIndexed$default$20, b0);
            return H.a;
        }
        return DetailCommentItemHolder.bindItem$lambda$13(this.c, ((DetailCommentItemHolder)this.d), ((cmtList)this.e), this.b, ((View)object0));
    }
}

