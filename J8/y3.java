package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class y3 implements a {
    public final RelativeLayout a;
    public final ImageView b;
    public final e3 c;
    public final MelonTextView d;

    public y3(RelativeLayout relativeLayout0, ImageView imageView0, e3 e30, MelonTextView melonTextView0) {
        this.a = relativeLayout0;
        this.b = imageView0;
        this.c = e30;
        this.d = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

