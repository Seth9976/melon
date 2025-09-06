package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.iloen.melon.custom.MelonImageView;

public final class b2 implements a {
    public final FrameLayout a;
    public final MelonImageView b;
    public final CardView c;
    public final MelonImageView d;

    public b2(FrameLayout frameLayout0, MelonImageView melonImageView0, CardView cardView0, MelonImageView melonImageView1) {
        this.a = frameLayout0;
        this.b = melonImageView0;
        this.c = cardView0;
        this.d = melonImageView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

