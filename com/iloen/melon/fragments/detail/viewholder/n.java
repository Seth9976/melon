package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.fragments.news.FeedLogsItemHolder;
import com.iloen.melon.fragments.news.FeedLogsListAdapter;

public final class n implements View.OnLongClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public n(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return this.a == 0 ? DetailContentsSongHolder.bind$lambda$7$lambda$3(((DetailContentsSongHolder)this.b), ((DetailContentsSong)this.c), view0) : FeedLogsListAdapter.a(((FeedLogsListAdapter)this.b), ((FeedLogsItemHolder)this.c), view0);
    }
}

