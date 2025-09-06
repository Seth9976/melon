package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.MelonTextView;

public final class n0 implements a {
    public final ConstraintLayout a;
    public final CheckableTextView b;
    public final ConstraintLayout c;
    public final View d;
    public final View e;
    public final RelativeLayout f;
    public final ConstraintLayout g;
    public final View h;
    public final MelonTextView i;
    public final MelonTextView j;

    public n0(ConstraintLayout constraintLayout0, CheckableTextView checkableTextView0, ConstraintLayout constraintLayout1, View view0, View view1, RelativeLayout relativeLayout0, ConstraintLayout constraintLayout2, View view2, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = constraintLayout0;
        this.b = checkableTextView0;
        this.c = constraintLayout1;
        this.d = view0;
        this.e = view1;
        this.f = relativeLayout0;
        this.g = constraintLayout2;
        this.h = view2;
        this.i = melonTextView0;
        this.j = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

