package com.iloen.melon.fragments.main.foru;

import android.view.View;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.main.common.TagCollectionView.OnTagClickListener;
import com.iloen.melon.net.v6x.response.ForuTasteSongRes;
import java.util.ArrayList;
import v9.i;

public final class f implements Listener, OnTagClickListener {
    public final MetaContentBaseFragment a;
    public final Object b;
    public final Object c;

    public f(MetaContentBaseFragment metaContentBaseFragment0, Object object0, Object object1) {
        this.a = metaContentBaseFragment0;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // com.iloen.melon.fragments.main.common.TagCollectionView$OnTagClickListener
    public void onClick(View view0, int v) {
        MixMakerKeywordSelectAdapter.onBindViewImpl$lambda$5$lambda$4(((ForUMixMakerKeywordSelectFragment)this.a), ((ArrayList)this.b), ((MixMakerKeywordSelectAdapter)this.c), view0, v);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        ForUTasteSongFragment.onFetchStart$lambda$7(((ForUTasteSongFragment)this.a), ((ForUTasteSongAdapter)this.b), ((i)this.c), ((ForuTasteSongRes)object0));
    }
}

