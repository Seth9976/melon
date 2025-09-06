package com.iloen.melon.fragments.news;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final FeedLogsListAdapter b;
    public final FeedLogsItemHolder c;

    public a(FeedLogsListAdapter feedLogsListAdapter0, FeedLogsItemHolder feedLogsItemHolder0, int v) {
        this.a = v;
        this.b = feedLogsListAdapter0;
        this.c = feedLogsItemHolder0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                FeedLogsListAdapter.onCreateViewHolderImpl$lambda$6$lambda$2(this.b, this.c, view0);
                return;
            }
            case 1: {
                FeedLogsListAdapter.onCreateViewHolderImpl$lambda$6$lambda$3(this.b, this.c, view0);
                return;
            }
            default: {
                FeedLogsListAdapter.onCreateViewHolderImpl$lambda$6$lambda$4(this.b, this.c, view0);
            }
        }
    }
}

