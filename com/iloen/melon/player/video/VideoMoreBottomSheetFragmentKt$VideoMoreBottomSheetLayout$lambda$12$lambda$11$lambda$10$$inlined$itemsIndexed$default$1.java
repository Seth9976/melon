package com.iloen.melon.player.video;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
public final class VideoMoreBottomSheetFragmentKt.VideoMoreBottomSheetLayout.lambda.12.lambda.11.lambda.10..inlined.itemsIndexed.default.1 extends r implements k {
    public final n f;
    public final List g;

    public VideoMoreBottomSheetFragmentKt.VideoMoreBottomSheetLayout.lambda.12.lambda.11.lambda.10..inlined.itemsIndexed.default.1(n n0, List list0) {
        this.f = n0;
        this.g = list0;
        super(1);
    }

    public final Object invoke(int v) {
        Object object0 = this.g.get(v);
        return this.f.invoke(v, object0);
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        return this.invoke(((Number)object0).intValue());
    }
}

