package com.iloen.melon.fragments.melontv;

import com.iloen.melon.adapters.MelonTvAdapter.OnInfoBtnClick;
import com.iloen.melon.playback.Playable;

public final class c implements OnInfoBtnClick, OnClickListener {
    public final MelonTvMusicVideoFragment a;

    public c(MelonTvMusicVideoFragment melonTvMusicVideoFragment0) {
        this.a = melonTvMusicVideoFragment0;
        super();
    }

    @Override  // com.iloen.melon.adapters.MelonTvAdapter$OnInfoBtnClick
    public void a(Playable playable0) {
        this.a.lambda$createRecyclerViewAdapter$1(playable0);
    }

    @Override  // com.iloen.melon.fragments.melontv.MelonTvMusicVideoFragment$MusicVideoAdapter$OnClickListener
    public void onSortBarClick(String s) {
        this.a.lambda$createRecyclerViewAdapter$2(s);
    }
}

