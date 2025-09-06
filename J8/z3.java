package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonImageView;

public final class z3 implements a {
    public final ConstraintLayout a;
    public final MelonImageView b;

    public z3(ConstraintLayout constraintLayout0, MelonImageView melonImageView0) {
        this.a = constraintLayout0;
        this.b = melonImageView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

