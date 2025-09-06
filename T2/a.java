package t2;

import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

public final class a implements View.OnApplyWindowInsetsListener {
    @Override  // android.view.View$OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
        boolean z = false;
        boolean z1 = windowInsets0.getSystemWindowInsetTop() > 0;
        ((DrawerLayout)view0).N = windowInsets0;
        ((DrawerLayout)view0).S = z1;
        if(!z1 && ((DrawerLayout)view0).getBackground() == null) {
            z = true;
        }
        ((DrawerLayout)view0).setWillNotDraw(z);
        ((DrawerLayout)view0).requestLayout();
        return windowInsets0.consumeSystemWindowInsets();
    }
}

