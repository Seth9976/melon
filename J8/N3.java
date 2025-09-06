package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;

public final class n3 implements a {
    public final ConstraintLayout a;
    public final ImageView b;
    public final x c;
    public final MelonTextView d;

    public n3(ConstraintLayout constraintLayout0, ImageView imageView0, x x0, MelonTextView melonTextView0) {
        this.a = constraintLayout0;
        this.b = imageView0;
        this.c = x0;
        this.d = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

