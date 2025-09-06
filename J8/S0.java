package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.detail.ZoomButton;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class s0 implements a {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ZoomButton d;
    public final MelonTextView e;
    public final ImageView f;
    public final MainTabTitleView g;
    public final RelativeLayout h;
    public final RecyclerView i;
    public final RelativeLayout j;
    public final LinearLayout k;
    public final MelonTextView l;

    public s0(ConstraintLayout constraintLayout0, ImageView imageView0, ImageView imageView1, ZoomButton zoomButton0, MelonTextView melonTextView0, ImageView imageView2, MainTabTitleView mainTabTitleView0, RelativeLayout relativeLayout0, RecyclerView recyclerView0, RelativeLayout relativeLayout1, LinearLayout linearLayout0, MelonTextView melonTextView1) {
        this.a = constraintLayout0;
        this.b = imageView0;
        this.c = imageView1;
        this.d = zoomButton0;
        this.e = melonTextView0;
        this.f = imageView2;
        this.g = mainTabTitleView0;
        this.h = relativeLayout0;
        this.i = recyclerView0;
        this.j = relativeLayout1;
        this.k = linearLayout0;
        this.l = melonTextView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

