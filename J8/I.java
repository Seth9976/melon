package J8;

import Q4.a;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;

public final class i implements a {
    public final ComposeView a;
    public final ComposeView b;

    public i(ComposeView composeView0, ComposeView composeView1) {
        this.a = composeView0;
        this.b = composeView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

