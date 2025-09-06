package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;

public final class s3 implements a {
    public final ConstraintLayout a;
    public final f3 b;
    public final f3 c;

    public s3(ConstraintLayout constraintLayout0, f3 f30, MelonTextView melonTextView0, f3 f31, MelonTextView melonTextView1, MelonTextView melonTextView2) {
        this.a = constraintLayout0;
        this.b = f30;
        this.c = f31;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

