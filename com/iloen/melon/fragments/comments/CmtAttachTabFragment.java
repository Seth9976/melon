package com.iloen.melon.fragments.comments;

import B.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import b3.Z;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.V0;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import java.util.ArrayList;

public class CmtAttachTabFragment extends MelonPagerFragment {
    private static final int TAB_ALBUM = 1;
    private static final int TAB_ARTIST = 2;
    private static final int TAB_SONG;
    private String mKeyword;
    protected Param mParam;
    private String mPrevKeyword;
    private SearchBarView mSearchBarView;

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        super.buildTabIndicator();
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                CmtAttachTabFragment.this.setRestoreKeyword();
                if(CmtAttachTabFragment.this.mKeyword != null && !"".equals(CmtAttachTabFragment.this.mKeyword.trim())) {
                    CmtAttachTabFragment.this.searchKeyword();
                }
            }
        });
    }

    private void changeKeyword(String s) {
        Z.w("changeKeyword() keyword:", s, "MelonPagerFragment");
        this.mKeyword = s;
        if(this.getCurrentFragment() instanceof CmtAttachFragment) {
            ((CmtAttachFragment)this.getCurrentFragment()).changeKeyword(this.mKeyword);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        Param cmtAttachFragment$Param0 = new Param();
        Param cmtAttachFragment$Param1 = this.mParam;
        if(cmtAttachFragment$Param1 != null) {
            cmtAttachFragment$Param0.theme = cmtAttachFragment$Param1.theme;
            cmtAttachFragment$Param0.viewType = cmtAttachFragment$Param1.viewType;
        }
        switch(v) {
            case 0: {
                cmtAttachFragment$Param0.searchType = "song";
                return CmtAttachFragment.newInstance(cmtAttachFragment$Param0);
            }
            case 1: {
                cmtAttachFragment$Param0.searchType = "album";
                return CmtAttachFragment.newInstance(cmtAttachFragment$Param0);
            }
            case 2: {
                cmtAttachFragment$Param0.searchType = "artist";
                return CmtAttachFragment.newInstance(cmtAttachFragment$Param0);
            }
            default: {
                return CmtAttachFragment.newInstance(cmtAttachFragment$Param0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F030050);  // array:subtabs_detailattach
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = 0;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = 0x7F080820;  // drawable:selector_dot
            tabInfo0.j = -1.0f;
            tabInfo0.k = -1.0f;
            tabInfo0.l = -1.0f;
            tabInfo0.m = -1.0f;
            tabInfo0.n = 1.0f;
            tabInfo0.o = -1;
            arrayList0.add(tabInfo0);
        }
        return arrayList0;
    }

    public static CmtAttachTabFragment newInstance(Param cmtAttachFragment$Param0) {
        CmtAttachTabFragment cmtAttachTabFragment0 = new CmtAttachTabFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("argCmtParam", cmtAttachFragment$Param0);
        cmtAttachTabFragment0.setArguments(bundle0);
        return cmtAttachTabFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mParam = (Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
        SearchBarView searchBarView0 = this.mSearchBarView;
        if(searchBarView0 != null) {
            searchBarView0.a();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            this.mParam = (Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle("음악첨부");
        }
        LayoutInflater.from(this.getActivity()).inflate(0x7F0D080A, this.mFixedViewAboveTab, true);  // layout:search_bar_view_layout
        SearchBarView searchBarView0 = (SearchBarView)this.findViewById(0x7F0A0A36);  // id:search_bar
        this.mSearchBarView = searchBarView0;
        searchBarView0.setOnSearchBarListener(new V0() {
            @Override  // com.iloen.melon.custom.Y
            public void onActionClick(InputBarView inputBarView0) {
            }

            @Override  // com.iloen.melon.custom.Y
            public void onClearClick(InputBarView inputBarView0) {
                CmtAttachTabFragment.this.changeKeyword(CmtAttachTabFragment.this.mPrevKeyword);
            }

            @Override  // com.iloen.melon.custom.V0
            public void onClearKeyword(SearchBarView searchBarView0) {
                CmtAttachTabFragment.this.changeKeyword(CmtAttachTabFragment.this.mPrevKeyword);
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchClick(SearchBarView searchBarView0, String s) {
                CmtAttachTabFragment.this.searchKeyword();
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchKeyword(SearchBarView searchBarView0, String s) {
                CmtAttachTabFragment.this.changeKeyword(s);
            }
        });
        this.setRestoreKeyword();
    }

    private void searchKeyword() {
        LogU.d("MelonPagerFragment", "searchKeyword() keyword:" + this.mKeyword + " , getCurrentFragment() = " + this.getCurrentFragment());
        this.mPrevKeyword = this.mKeyword;
        this.changeKeyword(this.mKeyword);
        SearchBarView searchBarView0 = this.mSearchBarView;
        if(searchBarView0 != null) {
            searchBarView0.setInputText(this.mPrevKeyword);
            this.mSearchBarView.a();
        }
        if(this.getCurrentFragment() instanceof CmtAttachFragment) {
            ((CmtAttachFragment)this.getCurrentFragment()).startFetchWithKeyword();
        }
    }

    private void setRestoreKeyword() {
        if(this.getCurrentFragment() instanceof CmtAttachFragment) {
            ((CmtAttachFragment)this.getCurrentFragment()).setOnCmtSearchAttachListener(new OnCmtSearchAttachListener() {
                @Override  // com.iloen.melon.fragments.comments.CmtAttachFragment$OnCmtSearchAttachListener
                public void onSearch() {
                    if(CmtAttachTabFragment.this.mSearchBarView != null) {
                        CmtAttachTabFragment.this.mSearchBarView.setInputText(CmtAttachTabFragment.this.mKeyword);
                        CmtAttachTabFragment.this.mSearchBarView.a();
                    }
                }
            });
        }
    }
}

