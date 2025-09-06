package com.iloen.melon.fragments.searchandadd;

import B.a;
import android.os.Bundle;
import android.support.v4.view.NonSwipeableViewPager;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;

public class SearchAndAddTabFragment extends MelonPagerFragment {
    public static final String ARG_CALLER_TYPE = "argCallerType";
    public static final String ARG_MAX_CONTENT_COUNT = "argMaxContentCount";
    public static final String ARG_SEARCH_RESULT_VALUES = "argSearchResultValues";
    public static final String ARG_SEARCH_VIEW_TYPE = "argSearchViewType";
    public static final int CALLER_DJ_PLAYLIST_INSERT = 3;
    public static final int CALLER_DJ_PLAYLIST_UPDATE = 4;
    public static final int CALLER_MUSIC_MESSAGE_ALBUM = 7;
    public static final int CALLER_MUSIC_MESSAGE_ARTIST = 8;
    public static final int CALLER_MUSIC_MESSAGE_MV = 6;
    public static final int CALLER_MUSIC_MESSAGE_PLAYLIST = 10;
    public static final int CALLER_MUSIC_MESSAGE_SONG = 5;
    public static final int CALLER_MY_MUSIC_PROFILE = 0;
    public static final int CALLER_NOWPLAYING_INSERT = 12;
    public static final int CALLER_NOWPLAYING_UPDATE = 13;
    public static final int CALLER_PLAYLIST_INSERT = 1;
    public static final int CALLER_PLAYLIST_UPDATE = 2;
    public static final int CALLER_PRESENT = 11;
    public static final int NONE_RESULT_COUNT = -1;
    private int mContentMaxCount;
    private int mSearchViewType;

    public SearchAndAddTabFragment() {
        this.mSearchViewType = -1;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        super.buildTabIndicator();
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
                if(v == 1) {
                    SearchAndAddTabFragment.this.clearMarkedItemsAndToast(SearchAndAddTabFragment.this.mTabIndicatorLayout.getCurrentItem());
                }
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
            }
        });
    }

    public boolean clearMarkedItemsAndToast(int v) {
        if(2 != this.mSearchViewType && 1 != this.mSearchViewType) {
            I i0 = this.getCurrentFragment();
            if(!(i0 instanceof SearchAndAddBaseFragment)) {
                return false;
            }
            if(((SearchAndAddBaseFragment)i0).existMarkedItem()) {
                ((SearchAndAddBaseFragment)i0).clearMarkedItems();
                ToastManager.show(0x7F1308FD);  // string:search_selected_clear_msg "메뉴를 이동하여 이전 선택 내역이 초기화 되었습니다."
            }
            return false;
        }
        return this.showConfirmPopup(this.getConfirmPopupAlertMsgRsId(), v, false);
    }

    private int getConfirmPopupAlertMsgRsId() {
        switch(this.mSearchViewType) {
            case 5: {
                return 0x7F130900;  // string:search_selected_video_alert_msg "선택하신 비디오를 보내지 않고 이동하실 경우 선택했던 내역이 사라집니다.\n이동하시겠습니까?"
            }
            case 6: {
                return 0x7F1308FB;  // string:search_selected_album_alert_msg "선택하신 앨범을 보내지 않고 이동하실 경우 선택했던 내역이 사라집니다.\n이동하시겠습니까?"
            }
            case 7: {
                return 0x7F1308FC;  // string:search_selected_artist_alert_msg "선택하신 아티스트를 보내지 않고 이동하실 경우 선택했던 내역이 사라집니다.\n이동하시겠습니까?"
            }
            case 9: {
                return 0x7F1308FE;  // string:search_selected_playlist_alert_msg "선택하신 플레이리스트를 보내지 않고 이동하실 경우 선택했던 내역이 
                                    // 사라집니다.\n이동하시겠습니까?"
            }
            default: {
                return 0x7F1308FF;  // string:search_selected_song_alert_msg "선택하신 곡을 추가하지 않고 이동하실 경우 선택했던 내역이 사라집니다.\n이동하시겠습니까?"
            }
        }
    }

    private int getStringArrayResId() {
        switch(this.mSearchViewType) {
            case 1: 
            case 2: {
                return 0x7F030029;  // array:search_and_add_playlist_make
            }
            case 5: {
                return 0x7F03002A;  // array:search_and_add_video
            }
            case 6: {
                return 0x7F030024;  // array:search_and_add_album
            }
            case 7: {
                return 0x7F030025;  // array:search_and_add_artist
            }
            case 9: {
                return 0x7F030028;  // array:search_and_add_playlist
            }
            case 0: 
            case 10: {
                return 0x7F030027;  // array:search_and_add_nowplaying
            }
            default: {
                return 0x7F030026;  // array:search_and_add_general
            }
        }
    }

    private int getTitleRsId() {
        switch(this.mSearchViewType) {
            case 0: {
                return 0x7F130902;  // string:search_song_profile_title "프로필 음악 편집"
            }
            case 1: 
            case 2: {
                return 0x7F130901;  // string:search_song_playlist_make_title "곡 추가"
            }
            case 5: {
                return 0x7F130919;  // string:select_video "비디오 선택하기"
            }
            case 6: {
                return 0x7F130913;  // string:select_album "앨범 선택하기"
            }
            case 7: {
                return 0x7F130915;  // string:select_artist "아티스트 선택하기"
            }
            case 9: {
                return 0x7F130917;  // string:select_playlist "플레이리스트 선택하기"
            }
            default: {
                return 0x7F130918;  // string:select_song "곡 선택하기"
            }
        }
    }

    private H lambda$showConfirmPopup$0(boolean z, int v) {
        if(z) {
            this.getActivity().finish();
            return null;
        }
        I i0 = this.getCurrentFragment();
        if(i0 instanceof SearchAndAddBaseFragment) {
            ((SearchAndAddBaseFragment)i0).clearMarkedItems();
        }
        this.selectTabByIndex(v);
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        int v1 = this.mSearchViewType;
        switch(v1) {
            case 1: 
            case 2: {
                if(v == 0) {
                    return SongNowPlayingSearchAndAddFragment.newInstance(v1, this.mContentMaxCount);
                }
                if(v == 1) {
                    return SongLikeSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                if(v == 2) {
                    return SongRecentSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                if(v == 3) {
                    return SongSearchSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                break;
            }
            case 3: 
            case 4: {
                if(v == 0) {
                    return SongRecentSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                if(v == 1) {
                    return SongLikeSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                if(v == 2) {
                    return SongSearchSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                break;
            }
            case 5: {
                if(v == 0) {
                    return MvRecentSearchAndAddFragment.newInstance(5, this.mCaller, this.mContentMaxCount);
                }
                if(v == 1) {
                    return MvLikeSearchAndAddFragment.newInstance(5, this.mCaller, this.mContentMaxCount);
                }
                if(v == 2) {
                    return MvSearchSearchAndAddFragment.newInstance(5, this.mCaller, this.mContentMaxCount);
                }
                break;
            }
            case 6: {
                if(v == 0) {
                    return AlbumLikeSearchAndAddFragment.newInstance(6, this.mCaller, this.mContentMaxCount);
                }
                if(v == 1) {
                    return AlbumSearchSearchAndAddFragment.newInstance(6, this.mCaller, this.mContentMaxCount);
                }
                break;
            }
            case 7: {
                if(v == 0) {
                    return ArtistFanSearchAndAddFragment.newInstance(7, this.mCaller, this.mContentMaxCount);
                }
                if(v == 1) {
                    return ArtistSearchSearchAndAddFragment.newInstance(7, this.mCaller, this.mContentMaxCount);
                }
                break;
            }
            case 9: {
                if(v == 0) {
                    return PlaylistMadeByMyselfSearchAndAddFragment.newInstance(9, this.mCaller, this.mContentMaxCount);
                }
                if(v == 1) {
                    return PlaylistLikeSearchAndAddFragment.newInstance(9, this.mCaller, this.mContentMaxCount);
                }
                if(v == 2) {
                    return PlaylistDjChartSearchAndAddFragment.newInstance(9, this.mCaller, this.mContentMaxCount);
                }
                break;
            }
            default: {
                if(v == 0) {
                    return SongNowPlayingSearchAndAddFragment.newInstance(v1, this.mContentMaxCount);
                }
                if(v == 1) {
                    return SongLikeSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
                if(v == 2) {
                    return SongSearchSearchAndAddFragment.newInstance(v1, this.mCaller, this.mContentMaxCount);
                }
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(this.getStringArrayResId());
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

    public static SearchAndAddTabFragment newInstance(int v, int v1, int v2) {
        if(v == -1) {
            throw new IllegalArgumentException("Invalid searchViewType - " + -1);
        }
        SearchAndAddTabFragment searchAndAddTabFragment0 = new SearchAndAddTabFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argSearchViewType", v);
        bundle0.putInt("argCaller", v1);
        bundle0.putInt("argMaxContentCount", v2);
        searchAndAddTabFragment0.setArguments(bundle0);
        return searchAndAddTabFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public boolean onBeforeSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return this.clearMarkedItemsAndToast(v);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mSearchViewType = bundle0.getInt("argSearchViewType");
            this.mContentMaxCount = bundle0.getInt("argMaxContentCount");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        View view0 = this.getActivity().getWindow().getCurrentFocus();
        if(view0 != null) {
            InputMethodUtils.hideInputMethod(this.getContext(), view0);
        }
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSearchViewType", this.mSearchViewType);
        bundle0.putInt("argMaxContentCount", this.mContentMaxCount);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getResources().getString(this.getTitleRsId()));
        }
        if(2 == this.mSearchViewType || 1 == this.mSearchViewType) {
            ViewPager viewPager0 = this.mPager;
            if(viewPager0 instanceof NonSwipeableViewPager) {
                ((NonSwipeableViewPager)viewPager0).enableSwipe(false, false);
            }
        }
    }

    private boolean showConfirmPopup(int v, int v1, boolean z) {
        I i0 = this.getCurrentFragment();
        if(i0 instanceof SearchAndAddBaseFragment && ((SearchAndAddBaseFragment)i0).existMarkedItem()) {
            b.v(this.getChildFragmentManager(), this.getString(0x7F1300CD), this.getString(v), false, null, null, new n(this, z, v1), null);  // string:alert_dlg_title_delete_confirm "안내"
            return true;
        }
        return false;
    }
}

