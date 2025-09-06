package Ac;

import A0.c;
import A9.a;
import E9.h;
import J8.d1;
import Ud.j;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.comment.CommentAttachPagerViewModel;
import com.melon.ui.j3;
import d3.g;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LAc/j0;", "Lcom/melon/ui/j3;", "Lcom/melon/ui/comment/CommentAttachPagerViewModel;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class j0 extends j3 {
    public final r h;
    public String i;
    public String j;
    public SearchBarView k;

    public j0() {
        super(0);
        new LogU("CommentAttachPagerFragment").setCategory(Category.UI);
        this.h = g.Q(new a(2));
        this.i = "";
        this.j = "";
    }

    @Override  // com.melon.ui.j3
    public final void buildTabIndicator() {
        FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getActivity());
        fixedTabLayout0.setViewPager(this.o());
        fixedTabLayout0.setOnTabEventListener(this);
        fixedTabLayout0.setOnPageChangeListener(new i0(this, 0));
        this.d = fixedTabLayout0;
        this.m().e(h.W(((CommentAttachPagerViewModel)this.getViewModel()).b()));
        this.n().addView(this.m(), -1, this.getResources().getDimensionPixelSize(0x7F07044F));  // dimen:tab_container_height
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return CommentAttachPagerViewModel.class;
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        SearchBarView searchBarView0 = this.k;
        if(searchBarView0 != null) {
            searchBarView0.a();
        }
    }

    @Override  // com.melon.ui.j3
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        d1 d10 = (d1)this.getBinding();
        if(d10 != null) {
            TitleBar titleBar0 = (TitleBar)d10.a.findViewById(0x7F0A0BAD);  // id:titlebar
            if(titleBar0 != null) {
                titleBar0.a(B.a.s(1));
                titleBar0.setTitle(this.getString(0x7F1301E8));  // string:cmt_music_attachment_title "음악첨부"
                j.a(((j)this.h.getValue()), titleBar0, new U(this, 1));
            }
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null) {
                this.k = (SearchBarView)LayoutInflater.from(fragmentActivity0).inflate(0x7F0D080A, d10.d, true).findViewById(0x7F0A0A36);  // layout:search_bar_view_layout
            }
            SearchBarView searchBarView0 = this.k;
            if(searchBarView0 != null) {
                searchBarView0.setOnSearchBarListener(new c(this, 3));
            }
            if(this.getCurrentFragment() instanceof S) {
                I i0 = this.getCurrentFragment();
                q.e(i0, "null cannot be cast to non-null type com.melon.ui.comment.CommentAttachFragment");
                S s0 = (S)i0;
            }
        }
    }

    @Override  // com.melon.ui.j3
    public final I p(TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        switch(v) {
            case 0: {
                q.f("song", "SONG");
                I i1 = new S();
                Bundle bundle1 = new Bundle();
                bundle1.putString("argMusicType", "song");
                i1.setArguments(bundle1);
                return i1;
            }
            case 1: {
                q.f("album", "ALBUM");
                I i2 = new S();
                Bundle bundle2 = new Bundle();
                bundle2.putString("argMusicType", "album");
                i2.setArguments(bundle2);
                return i2;
            }
            default: {
                q.f("artist", "ARTIST");
                I i0 = new S();
                Bundle bundle0 = new Bundle();
                bundle0.putString("argMusicType", "artist");
                i0.setArguments(bundle0);
                return i0;
            }
        }
    }

    public static final void q(j0 j00) {
        j00.i = j00.j;
        j00.r(j00.j);
        SearchBarView searchBarView0 = j00.k;
        if(searchBarView0 != null) {
            searchBarView0.setInputText(j00.i);
            searchBarView0.a();
        }
        if(j00.getCurrentFragment() instanceof S) {
            I i0 = j00.getCurrentFragment();
            q.e(i0, "null cannot be cast to non-null type com.melon.ui.comment.CommentAttachFragment");
            ((M0)((S)i0).getViewModel()).g("");
        }
    }

    public final void r(String s) {
        this.j = s == null ? "" : s;
        if(this.getCurrentFragment() instanceof S) {
            I i0 = this.getCurrentFragment();
            q.e(i0, "null cannot be cast to non-null type com.melon.ui.comment.CommentAttachFragment");
            ((M0)((S)i0).getViewModel()).c(s);
        }
    }
}

