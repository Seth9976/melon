package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.iloen.melon.custom.MelonTextView;

public final class v3 implements a {
    public final ConstraintLayout a;
    public final View b;
    public final View c;
    public final MelonTextView d;
    public final Group e;

    public v3(ConstraintLayout constraintLayout0, View view0, View view1, MelonTextView melonTextView0, Group group0) {
        this.a = constraintLayout0;
        this.b = view0;
        this.c = view1;
        this.d = melonTextView0;
        this.e = group0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

