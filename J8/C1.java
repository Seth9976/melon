package J8;

import Q4.a;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.ui.platform.ComposeView;

public final class c1 implements a {
    public final LinearLayoutCompat a;
    public final ComposeView b;
    public final b c;
    public final b d;

    public c1(LinearLayoutCompat linearLayoutCompat0, ComposeView composeView0, b b0, b b1) {
        this.a = linearLayoutCompat0;
        this.b = composeView0;
        this.c = b0;
        this.d = b1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

