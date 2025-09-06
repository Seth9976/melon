package J8;

import Q4.a;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;

public final class z implements a {
    public final ComposeView a;

    public z(ComposeView composeView0) {
        this.a = composeView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

