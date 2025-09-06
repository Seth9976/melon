package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import com.iloen.melon.custom.MelonTextView;

public final class p0 implements a {
    public final FrameLayout a;

    public p0(FrameLayout frameLayout0, MelonTextView melonTextView0) {
        this.a = frameLayout0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

