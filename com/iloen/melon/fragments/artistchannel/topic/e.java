package com.iloen.melon.fragments.artistchannel.topic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICINFO;

public final class e implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    public e(TopicAdapter topicFragment$TopicAdapter0, TopicFragment topicFragment0) {
        this.a = 1;
        super();
        this.b = topicFragment0;
        this.c = topicFragment$TopicAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                HeaderViewHolder.c(((TOPICINFO)this.c), ((TopicFragment)this.b), view0);
                return;
            }
            case 1: {
                TopicCommentHeaderViewHolder.a(((TopicFragment)this.b), ((TopicAdapter)this.c), view0);
                return;
            }
            case 2: {
                TopicContentsImageViewHolder.bind$lambda$0(((TopicContentsImageViewHolder)this.c), ((TOPICCONTENTSLIST)this.b), view0);
                return;
            }
            default: {
                TopicContentsMvViewHolder.bind$lambda$0(((TopicContentsMvViewHolder)this.c), ((TOPICCONTENTSLIST)this.b), view0);
            }
        }
    }
}

