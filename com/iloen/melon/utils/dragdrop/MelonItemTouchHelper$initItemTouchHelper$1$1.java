package com.iloen.melon.utils.dragdrop;

import androidx.recyclerview.widget.l0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/iloen/melon/utils/dragdrop/MelonItemTouchHelper$initItemTouchHelper$1$1", "Landroidx/recyclerview/widget/l0;", "Lie/H;", "onChanged", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonItemTouchHelper.initItemTouchHelper.1.1 extends l0 {
    public final MelonItemTouchHelper a;

    public MelonItemTouchHelper.initItemTouchHelper.1.1(MelonItemTouchHelper melonItemTouchHelper0) {
        this.a = melonItemTouchHelper0;
    }

    @Override  // androidx.recyclerview.widget.l0
    public void onChanged() {
        this.a.cancel();
    }
}

