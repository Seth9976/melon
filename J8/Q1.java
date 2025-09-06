package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.melon.ui.playermusic.PlayerMoreView;

public final class q1 implements a {
    public final PlayerMoreView a;
    public final ImageView b;
    public final MelonTextView c;
    public final LinearLayout d;
    public final ImageView e;
    public final ImageView f;
    public final LinearLayout g;
    public final View h;
    public final MelonImageView i;
    public final RelativeLayout j;
    public final MelonTextView k;
    public final ConstraintLayout l;
    public final LinearLayout m;
    public final NestedScrollView n;
    public final MelonTextView o;
    public final ImageView p;
    public final LinearLayout q;

    public q1(PlayerMoreView playerMoreView0, ImageView imageView0, MelonTextView melonTextView0, LinearLayout linearLayout0, ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout1, RecyclerView recyclerView0, View view0, ComposeView composeView0, MelonImageView melonImageView0, RelativeLayout relativeLayout0, MelonTextView melonTextView1, ConstraintLayout constraintLayout0, LinearLayout linearLayout2, RelativeLayout relativeLayout1, NestedScrollView nestedScrollView0, MelonTextView melonTextView2, ImageView imageView6, LinearLayout linearLayout3) {
        this.a = playerMoreView0;
        this.b = imageView0;
        this.c = melonTextView0;
        this.d = linearLayout0;
        this.e = imageView2;
        this.f = imageView3;
        this.g = linearLayout1;
        this.h = view0;
        this.i = melonImageView0;
        this.j = relativeLayout0;
        this.k = melonTextView1;
        this.l = constraintLayout0;
        this.m = linearLayout2;
        this.n = nestedScrollView0;
        this.o = melonTextView2;
        this.p = imageView6;
        this.q = linearLayout3;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

