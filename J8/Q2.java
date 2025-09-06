package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class q2 implements a {
    public final RelativeLayout a;
    public final x b;
    public final MelonTextView c;

    public q2(RelativeLayout relativeLayout0, x x0, MelonTextView melonTextView0) {
        this.a = relativeLayout0;
        this.b = x0;
        this.c = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

