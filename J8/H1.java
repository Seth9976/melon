package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewpager.widget.ViewPager;
import com.melon.ui.playermusic.PlayerMoreView;

public final class h1 implements a {
    public final FrameLayout a;
    public final View b;
    public final ComposeView c;
    public final ViewPager d;
    public final PlayerMoreView e;
    public final ComposeView f;

    public h1(FrameLayout frameLayout0, View view0, ComposeView composeView0, ViewPager viewPager0, PlayerMoreView playerMoreView0, ComposeView composeView1) {
        this.a = frameLayout0;
        this.b = view0;
        this.c = composeView0;
        this.d = viewPager0;
        this.e = playerMoreView0;
        this.f = composeView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

