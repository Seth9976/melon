package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.iloen.melon.custom.MelonTextView;

public final class t3 implements a {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final MelonTextView d;

    public t3(ConstraintLayout constraintLayout0, f3 f30, Guideline guideline0, ImageView imageView0, ImageView imageView1, MelonTextView melonTextView0, LinearLayout linearLayout0) {
        this.a = constraintLayout0;
        this.b = imageView0;
        this.c = imageView1;
        this.d = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

