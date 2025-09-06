package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class u3 implements a {
    public final ConstraintLayout a;

    public u3(ConstraintLayout constraintLayout0) {
        this.a = constraintLayout0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

