package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.widget.NestedScrollView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.main.foru.MixMakerTagCollectionView;

public final class a1 implements a {
    public final FrameLayout a;
    public final MixMakerTagCollectionView b;
    public final ComposeView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final LinearLayoutCompat g;
    public final LinearLayoutCompat h;
    public final b i;
    public final NestedScrollView j;
    public final LinearLayoutCompat k;
    public final MixMakerTagCollectionView l;
    public final HorizontalScrollView m;
    public final MelonTextView n;

    public a1(FrameLayout frameLayout0, MixMakerTagCollectionView mixMakerTagCollectionView0, ComposeView composeView0, ImageView imageView0, ImageView imageView1, ImageView imageView2, LinearLayoutCompat linearLayoutCompat0, LinearLayoutCompat linearLayoutCompat1, b b0, NestedScrollView nestedScrollView0, LinearLayoutCompat linearLayoutCompat2, MixMakerTagCollectionView mixMakerTagCollectionView1, HorizontalScrollView horizontalScrollView0, MelonTextView melonTextView0) {
        this.a = frameLayout0;
        this.b = mixMakerTagCollectionView0;
        this.c = composeView0;
        this.d = imageView0;
        this.e = imageView1;
        this.f = imageView2;
        this.g = linearLayoutCompat0;
        this.h = linearLayoutCompat1;
        this.i = b0;
        this.j = nestedScrollView0;
        this.k = linearLayoutCompat2;
        this.l = mixMakerTagCollectionView1;
        this.m = horizontalScrollView0;
        this.n = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

