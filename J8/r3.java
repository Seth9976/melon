package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.MelonTextView;

public final class r3 implements a {
    public final ConstraintLayout a;
    public final MelonTextView b;
    public final MelonTextView c;
    public final MelonTextView d;
    public final AlphaControlCheckButton e;
    public final MelonTextView f;
    public final ImageView g;
    public final MelonTextView h;

    public r3(ConstraintLayout constraintLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2, AlphaControlCheckButton alphaControlCheckButton0, MelonTextView melonTextView3, ImageView imageView0, MelonTextView melonTextView4) {
        this.a = constraintLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
        this.d = melonTextView2;
        this.e = alphaControlCheckButton0;
        this.f = melonTextView3;
        this.g = imageView0;
        this.h = melonTextView4;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

