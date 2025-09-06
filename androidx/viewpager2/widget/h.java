package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.x0;

public final class h implements x0 {
    @Override  // androidx.recyclerview.widget.x0
    public final void a(View view0) {
    }

    @Override  // androidx.recyclerview.widget.x0
    public final void b(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        if(recyclerView$LayoutParams0.width != -1 || recyclerView$LayoutParams0.height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }
}

