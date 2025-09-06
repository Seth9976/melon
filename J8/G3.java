package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import com.iloen.melon.custom.MelonImageView;

public final class g3 implements a {
    public final int a;
    public final FrameLayout b;
    public final MelonImageView c;
    public final View d;

    public g3(FrameLayout frameLayout0, MelonImageView melonImageView0, View view0, int v) {
        this.a = v;
        this.b = frameLayout0;
        this.c = melonImageView0;
        this.d = view0;
        super();
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.b;
    }
}

