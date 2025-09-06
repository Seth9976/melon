package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class r2 implements a {
    public final RelativeLayout a;
    public final RelativeLayout b;
    public final LinearLayout c;
    public final MelonTextView d;
    public final CardView e;
    public final MelonImageView f;
    public final ImageView g;
    public final b h;
    public final x i;
    public final MelonTextView j;

    public r2(RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, LinearLayout linearLayout0, MelonTextView melonTextView0, CardView cardView0, MelonImageView melonImageView0, ImageView imageView0, b b0, x x0, MelonTextView melonTextView1) {
        this.a = relativeLayout0;
        this.b = relativeLayout1;
        this.c = linearLayout0;
        this.d = melonTextView0;
        this.e = cardView0;
        this.f = melonImageView0;
        this.g = imageView0;
        this.h = b0;
        this.i = x0;
        this.j = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

