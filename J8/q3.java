package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;

public final class q3 implements a {
    public final LinearLayout a;
    public final MelonTextView b;

    public q3(LinearLayout linearLayout0, MelonTextView melonTextView0) {
        this.a = linearLayout0;
        this.b = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

