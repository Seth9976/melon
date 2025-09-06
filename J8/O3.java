package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;

public final class o3 implements a {
    public final ConstraintLayout a;
    public final MelonTextView b;
    public final f3 c;
    public final f3 d;
    public final ImageView e;
    public final MelonTextView f;

    public o3(ConstraintLayout constraintLayout0, MelonTextView melonTextView0, f3 f30, f3 f31, ImageView imageView0, MelonTextView melonTextView1) {
        this.a = constraintLayout0;
        this.b = melonTextView0;
        this.c = f30;
        this.d = f31;
        this.e = imageView0;
        this.f = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

