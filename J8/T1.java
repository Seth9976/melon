package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;

public final class t1 implements a {
    public final ConstraintLayout a;
    public final MelonTextView b;

    public t1(ConstraintLayout constraintLayout0, MelonTextView melonTextView0) {
        this.a = constraintLayout0;
        this.b = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

