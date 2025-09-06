package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;

public final class n implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        LayoutParams viewPager$LayoutParams0 = (LayoutParams)((View)object0).getLayoutParams();
        LayoutParams viewPager$LayoutParams1 = (LayoutParams)((View)object1).getLayoutParams();
        boolean z = viewPager$LayoutParams0.a;
        if(z != viewPager$LayoutParams1.a) {
            return z ? 1 : -1;
        }
        return viewPager$LayoutParams0.e - viewPager$LayoutParams1.e;
    }
}

