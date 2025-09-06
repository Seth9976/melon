package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.iloen.melon.custom.MelonImageView;

public final class z1 implements a {
    public final LinearLayout a;
    public final CardView b;
    public final MelonImageView c;
    public final MelonImageView d;
    public final ImageView e;

    public z1(LinearLayout linearLayout0, CardView cardView0, MelonImageView melonImageView0, MelonImageView melonImageView1, ImageView imageView0) {
        this.a = linearLayout0;
        this.b = cardView0;
        this.c = melonImageView0;
        this.d = melonImageView1;
        this.e = imageView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

