package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;

public final class s1 implements a {
    public final ConstraintLayout a;
    public final MelonTextView b;
    public final MelonTextView c;

    public s1(ConstraintLayout constraintLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = constraintLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

