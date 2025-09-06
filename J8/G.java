package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonImageView;

public final class g implements a {
    public final LinearLayout a;
    public final MelonImageView b;

    public g(LinearLayout linearLayout0, MelonImageView melonImageView0) {
        this.a = linearLayout0;
        this.b = melonImageView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

