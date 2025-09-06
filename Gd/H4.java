package gd;

import B.a;
import E9.h;
import F8.o;
import F8.x;
import J8.d1;
import Ud.j;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.j3;
import com.melon.ui.popup.b;
import com.melon.ui.q4;
import d3.g;
import dd.v;
import e.k;
import ed.f;
import ie.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lgd/h4;", "Lcom/melon/ui/j3;", "Lgd/i4;", "<init>", "()V", "d8/d", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class h4 extends j3 {
    public final List h;
    public final r i;
    public static final LogU j;

    static {
        LogU logU0 = new LogU("MelonDjPopularPagerFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        h4.j = logU0;
    }

    public h4() {
        super(0);
        this.h = k.A(new String[]{"D", "W", "M"});
        this.i = g.Q(new v(27));
    }

    @Override  // com.melon.ui.j3
    public final void buildTabIndicator() {
        LogU.info$default(h4.j, "buildTabIndicator()", null, false, 6, null);
        FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getContext());
        fixedTabLayout0.setViewPager(this.o());
        fixedTabLayout0.setOnPageChangeListener(new g4(this, fixedTabLayout0));
        this.d = fixedTabLayout0;
        this.m().e(h.W(((i4)this.getViewModel()).b()));
        this.n().addView(this.m(), -1, this.getResources().getDimensionPixelSize(0x7F0703F4));  // dimen:new_tab_container_height
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return i4.class;
    }

    @Override  // com.melon.ui.j3
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            i4 i40 = (i4)this.getViewModel();
            i40.a = bundle0.getInt("argSortIndex", 0);
        }
    }

    @Override  // com.melon.ui.j3
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSortIndex", ((i4)this.getViewModel()).a);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof q4) {
            l0 l00 = this.getChildFragmentManager();
            b.d(b.a, l00, ((q4)i40).a, ((q4)i40).b, false, false, false, null, null, null, null, null, 1960);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.j3
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        d1 d10 = (d1)this.getBinding();
        if(d10 != null) {
            TitleBar titleBar0 = (TitleBar)d10.a.findViewById(0x7F0A0BAD);  // id:titlebar
            if(titleBar0 != null) {
                x x0 = new x(2);
                x0.c = new p(this, 13);
                o o0 = a.s(1);
                o0.g(x0);
                titleBar0.a(o0);
                titleBar0.setTitle(this.getString(0x7F13066E));  // string:melondj_title_popular_playlist "인기 플레이리스트"
                j.a(((j)this.i.getValue()), titleBar0, new f(this, 14));
            }
        }
    }

    @Override  // com.melon.ui.j3
    public final I p(TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        LogU.info$default(h4.j, "makeFragment() position: " + v, null, false, 6, null);
        String s = (String)je.p.n0(v, this.h);
        if(s == null) {
            s = "D";
        }
        I i0 = new l4();
        Bundle bundle0 = new Bundle();
        LogU.debug$default(i0.g, "newInstance() sortType: " + s, null, false, 6, null);
        bundle0.putString("argSortType", s);
        i0.setArguments(bundle0);
        return i0;
    }
}

