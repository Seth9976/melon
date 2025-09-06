package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonTextView;

public final class i2 implements a {
    public final ConstraintLayout a;
    public final BorderImageView b;
    public final ImageView c;
    public final View d;
    public final MelonTextView e;
    public final View f;

    public i2(ConstraintLayout constraintLayout0, BorderImageView borderImageView0, ImageView imageView0, View view0, MelonTextView melonTextView0, View view1) {
        this.a = constraintLayout0;
        this.b = borderImageView0;
        this.c = imageView0;
        this.d = view0;
        this.e = melonTextView0;
        this.f = view1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

