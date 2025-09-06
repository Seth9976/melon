package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class d2 implements a {
    public final ConstraintLayout a;

    public d2(ConstraintLayout constraintLayout0, ImageView imageView0, MelonImageView melonImageView0, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2) {
        this.a = constraintLayout0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

