package i6;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import zd.h;

public final class b extends a {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void b(View view0, float f) {
    }

    private final void c(View view0, float f) {
    }

    private final void d(View view0, float f) {
    }

    @Override  // i6.a
    public final void onSlide(View view0, float f) {
    }

    @Override  // i6.a
    public final void onStateChanged(View view0, int v) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                if(v == 5) {
                    ((BottomSheetDialog)object0).cancel();
                }
                return;
            }
            case 1: {
                ((BottomSheetDragHandleView)object0).d(v);
                return;
            }
            default: {
                if(v == 3 && ((h)object0).d > ((h)object0).g) {
                    BottomSheetBehavior bottomSheetBehavior0 = ((h)object0).e;
                    if(bottomSheetBehavior0 != null) {
                        bottomSheetBehavior0.M(4);
                    }
                }
            }
        }
    }
}

