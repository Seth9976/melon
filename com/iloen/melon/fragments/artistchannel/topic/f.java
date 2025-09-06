package com.iloen.melon.fragments.artistchannel.topic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICINFO;

public final class f implements View.OnClickListener {
    public final TopicFragment a;
    public final TOPICINFO b;
    public final TopicAdapter c;

    public f(TopicFragment topicFragment0, TOPICINFO artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0, TopicAdapter topicFragment$TopicAdapter0) {
        this.a = topicFragment0;
        this.b = artistContentsArtistTopicInfoRes$RESPONSE$TOPICINFO0;
        this.c = topicFragment$TopicAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        HeaderViewHolder.a(this.a, this.b, this.c, view0);
    }
}

