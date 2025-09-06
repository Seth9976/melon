package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class m3 implements a {
    public final FrameLayout a;
    public final MelonTextView b;
    public final MelonTextView c;
    public final FrameLayout d;
    public final MelonImageView e;
    public final MelonTextView f;
    public final ConstraintLayout g;
    public final View h;
    public final MelonTextView i;

    public m3(FrameLayout frameLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1, FrameLayout frameLayout1, MelonImageView melonImageView0, MelonTextView melonTextView2, ConstraintLayout constraintLayout0, View view0, MelonTextView melonTextView3) {
        this.a = frameLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
        this.d = frameLayout1;
        this.e = melonImageView0;
        this.f = melonTextView2;
        this.g = constraintLayout0;
        this.h = view0;
        this.i = melonTextView3;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

