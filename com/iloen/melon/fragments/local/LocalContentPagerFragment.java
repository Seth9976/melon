package com.iloen.melon.fragments.local;

import B.a;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import java.util.ArrayList;

public class LocalContentPagerFragment extends MelonPagerFragment {
    private static final int POSITION_ALBUM = 2;
    private static final int POSITION_ALL_SONGS = 0;
    private static final int POSITION_ARTIST = 1;
    private static final int POSITION_GENRE = 3;

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        switch(v) {
            case 0: {
                return this.mIsFlac ? LocalContentAllSongFragment.newInstance(true, "1000000357") : LocalContentAllSongFragment.newInstance(false, "1000000352");
            }
            case 1: {
                return this.mIsFlac ? LocalContentArtistListFragment.newInstance(true, "1000000358") : LocalContentArtistListFragment.newInstance(false, "1000000353");
            }
            case 2: {
                return this.mIsFlac ? LocalContentAlbumListFragment.newInstance(true, "1000000359") : LocalContentAlbumListFragment.newInstance(false, "1000000354");
            }
            case 3: {
                return this.mIsFlac ? LocalContentGenreListFragment.newInstance(true, "1000000360") : LocalContentGenreListFragment.newInstance(false, "1000000355");
            }
            default: {
                return null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F030013);  // array:local_content_song_tabs
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

    private static LocalContentPagerFragment newInstance(boolean z) {
        LocalContentPagerFragment localContentPagerFragment0 = new LocalContentPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("argIsFlac", z);
        bundle0.putBoolean("argSwipeDisabled", true);
        localContentPagerFragment0.setArguments(bundle0);
        return localContentPagerFragment0;
    }

    public static LocalContentPagerFragment newInstanceForFlac() {
        return LocalContentPagerFragment.newInstance(true);
    }

    public static LocalContentPagerFragment newInstanceForSong() {
        return LocalContentPagerFragment.newInstance(false);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getResources().getString((this.mIsFlac ? 0x7F1304FA : 0x7F1304FC)));  // string:local_content_flac "저장한 FLAC"
        }
    }
}

