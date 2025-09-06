package J8;

import Q4.a;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.ui.platform.ComposeView;

public final class t implements a {
    public final LinearLayoutCompat a;
    public final u b;
    public final ComposeView c;
    public final b d;

    public t(LinearLayoutCompat linearLayoutCompat0, u u0, ComposeView composeView0, b b0) {
        this.a = linearLayoutCompat0;
        this.b = u0;
        this.c = composeView0;
        this.d = b0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

