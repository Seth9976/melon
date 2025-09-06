package com.iloen.melon.fragments.artistchannel.topic;

import android.view.View.OnClickListener;
import android.view.View;

public final class g implements View.OnClickListener {
    public final int a;
    public final TopicFragment b;

    public g(TopicFragment topicFragment0, int v) {
        this.a = v;
        this.b = topicFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                HeaderViewHolder.b(this.b, view0);
                return;
            }
            case 1: {
                TopicCommentHeaderViewHolder.b(this.b, view0);
                return;
            }
            default: {
                TopicFragment.x0(this.b, view0);
            }
        }
    }
}

