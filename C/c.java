package c;

import a.a;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.tooling.PreviewActivity;
import androidx.lifecycle.f0;
import m0.b;

public abstract class c {
    public static final ViewGroup.LayoutParams a;

    static {
        c.a = new ViewGroup.LayoutParams(-2, -2);
    }

    public static void a(PreviewActivity previewActivity0, b b0) {
        View view0 = ((ViewGroup)previewActivity0.getWindow().getDecorView().findViewById(0x1020002)).getChildAt(0);
        ComposeView composeView0 = view0 instanceof ComposeView ? ((ComposeView)view0) : null;
        if(composeView0 != null) {
            composeView0.setParentCompositionContext(null);
            composeView0.setContent(b0);
            return;
        }
        ComposeView composeView1 = new ComposeView(previewActivity0, null, 6, 0);
        composeView1.setParentCompositionContext(null);
        composeView1.setContent(b0);
        View view1 = previewActivity0.getWindow().getDecorView();
        if(f0.d(view1) == null) {
            f0.k(view1, previewActivity0);
        }
        if(f0.e(view1) == null) {
            f0.l(view1, previewActivity0);
        }
        if(a.v(view1) == null) {
            a.M(view1, previewActivity0);
        }
        previewActivity0.setContentView(composeView1, c.a);
    }
}

