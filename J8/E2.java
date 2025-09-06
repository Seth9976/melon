package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class e2 implements a {
    public final ConstraintLayout a;
    public final ImageView b;
    public final MelonImageView c;
    public final MelonTextView d;

    public e2(ConstraintLayout constraintLayout0, ImageView imageView0, MelonImageView melonImageView0, MelonTextView melonTextView0) {
        this.a = constraintLayout0;
        this.b = imageView0;
        this.c = melonImageView0;
        this.d = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

