package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;

public final class h3 implements a {
    public final LinearLayout a;
    public final MelonTextView b;
    public final MelonTextView c;

    public h3(LinearLayout linearLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = linearLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

