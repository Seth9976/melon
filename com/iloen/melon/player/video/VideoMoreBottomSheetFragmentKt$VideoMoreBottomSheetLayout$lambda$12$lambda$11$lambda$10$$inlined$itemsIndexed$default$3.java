package com.iloen.melon.player.video;

import A7.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import r0.n;
import we.k;
import we.p;
import zd.Q;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
public final class VideoMoreBottomSheetFragmentKt.VideoMoreBottomSheetLayout.lambda.12.lambda.11.lambda.10..inlined.itemsIndexed.default.3 extends r implements p {
    public final List f;
    public final Q g;
    public final k h;
    public final List i;

    public VideoMoreBottomSheetFragmentKt.VideoMoreBottomSheetLayout.lambda.12.lambda.11.lambda.10..inlined.itemsIndexed.default.3(List list0, Q q0, k k0, List list1) {
        this.f = list0;
        this.g = q0;
        this.h = k0;
        this.i = list1;
        super(4);
    }

    @Override  // we.p
    public Object invoke(Object object0, Object object1, Object object2, Object object3) {
        this.invoke(((a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
        return H.a;
    }

    public final void invoke(a a0, int v, l l0, int v1) {
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(a0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Object object0 = this.f.get(v);
            ((androidx.compose.runtime.p)l0).a0(-2017632826);
            VideoMoreBottomSheetFragmentKt.access$BodyLayout(v, this.g, ((MelonBottomSheetItem)object0), this.h, ((androidx.compose.runtime.p)l0), (v2 & 0x7E) >> 3 & 14);
            if(v == this.i.size() - 1) {
                ((androidx.compose.runtime.p)l0).a0(0x87BEB721);
                d.v(n.a, 10.0f, ((androidx.compose.runtime.p)l0), false);
            }
            else {
                ((androidx.compose.runtime.p)l0).a0(0x8646A027);
                ((androidx.compose.runtime.p)l0).p(false);
            }
            ((androidx.compose.runtime.p)l0).p(false);
            return;
        }
        ((androidx.compose.runtime.p)l0).T();
    }
}

