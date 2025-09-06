package ld;

import Ac.i0;
import B.a;
import E9.h;
import J8.d1;
import Ud.j;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.newmusic.NewAlbumFragment;
import com.iloen.melon.fragments.newmusic.NewMvFragment;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.j3;
import d3.g;
import gd.r5;
import ie.r;
import jd.e3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lld/b;", "Lcom/melon/ui/j3;", "Lld/c;", "<init>", "()V", "e1/F", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class b extends j3 {
    public final LogU h;
    public final r i;

    static {
    }

    public b() {
        super(0);
        LogU logU0 = new LogU("NewMusicPagerFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.h = logU0;
        this.i = g.Q(new r5(26));
    }

    @Override  // com.melon.ui.j3
    public final void buildTabIndicator() {
        FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getActivity());
        fixedTabLayout0.setSelectedTabIndex(((c)this.getViewModel()).a);
        fixedTabLayout0.setViewPager(this.o());
        fixedTabLayout0.setOnTabEventListener(this);
        fixedTabLayout0.setOnPageChangeListener(new i0(this, 2));
        fixedTabLayout0.e(h.W(((c)this.getViewModel()).b()));
        this.d = fixedTabLayout0;
        this.n().addView(this.m(), -1, this.getResources().getDimensionPixelSize(0x7F0703F4));  // dimen:new_tab_container_height
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return c.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isTopLevelFragment() {
        return true;
    }

    @Override  // com.melon.ui.j3
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        c c0 = (c)this.getViewModel();
        c0.f = bundle0.getInt("argSongFilterType", 0);
        c c1 = (c)this.getViewModel();
        c1.g = bundle0.getInt("argAlbumSortType", 0);
    }

    @Override  // com.melon.ui.j3
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSongFilterType", ((c)this.getViewModel()).f);
        bundle0.putInt("argAlbumSortType", ((c)this.getViewModel()).g);
    }

    @Override  // com.melon.ui.j3
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        d1 d10 = (d1)this.getBinding();
        if(d10 != null) {
            TitleBar titleBar0 = (TitleBar)d10.a.findViewById(0x7F0A0BAD);  // id:titlebar
            if(titleBar0 != null) {
                titleBar0.a(a.s(1));
                titleBar0.setTitle(this.getString(0x7F130787));  // string:new_music_title "최신음악"
                j.a(((j)this.i.getValue()), titleBar0, new e3(this, 9));
            }
        }
    }

    @Override  // com.melon.ui.j3
    public final I p(TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        LogU.info$default(this.h, "makeFragment() position: " + v, null, false, 6, null);
        switch(v) {
            case 0: {
                int v1 = ((c)this.getViewModel()).f;
                I i0 = new m();
                Bundle bundle0 = new Bundle();
                bundle0.putInt("argFilterType", v1);
                i0.setArguments(bundle0);
                return i0;
            }
            case 1: {
                int v2 = ((c)this.getViewModel()).g;
                return NewAlbumFragment.Companion.newInstance(v2);
            }
            default: {
                return NewMvFragment.Companion.newInstance();
            }
        }
    }
}

