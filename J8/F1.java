package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class f1 implements a {
    public final ConstraintLayout a;
    public final ComposeView b;
    public final ComposeView c;
    public final ComposeView d;
    public final ImageView e;
    public final r1 f;

    public f1(ConstraintLayout constraintLayout0, ComposeView composeView0, ComposeView composeView1, ComposeView composeView2, ImageView imageView0, r1 r10) {
        this.a = constraintLayout0;
        this.b = composeView0;
        this.c = composeView1;
        this.d = composeView2;
        this.e = imageView0;
        this.f = r10;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

