package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class g1 implements a {
    public final ConstraintLayout a;
    public final ComposeView b;
    public final ImageView c;

    public g1(ConstraintLayout constraintLayout0, ComposeView composeView0, ImageView imageView0) {
        this.a = constraintLayout0;
        this.b = composeView0;
        this.c = imageView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

