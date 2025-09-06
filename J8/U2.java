package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class u2 implements a {
    public final RelativeLayout a;
    public final MelonTextView b;
    public final MelonTextView c;

    public u2(RelativeLayout relativeLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = relativeLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

