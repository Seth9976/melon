package N4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

public final class y extends FrameLayout {
    public ViewGroup a;
    public boolean b;
    public static final int c;

    public static void a(View view0, ArrayList arrayList0) {
        ViewParent viewParent0 = view0.getParent();
        if(viewParent0 instanceof ViewGroup) {
            y.a(((View)viewParent0), arrayList0);
        }
        arrayList0.add(view0);
    }

    @Override  // android.view.ViewGroup
    public final void onViewAdded(View view0) {
        if(!this.b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view0);
    }

    @Override  // android.view.ViewGroup
    public final void onViewRemoved(View view0) {
        ViewGroup viewGroup0 = this.a;
        super.onViewRemoved(view0);
        if(this.getChildCount() == 1 && this.getChildAt(0) == view0 || this.getChildCount() == 0) {
            viewGroup0.setTag(0x7F0A04EF, null);  // id:ghost_view_holder
            viewGroup0.getOverlay().remove(this);
            this.b = false;
        }
    }
}

