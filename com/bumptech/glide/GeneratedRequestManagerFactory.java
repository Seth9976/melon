package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.integration.okhttp3.GlideRequests;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.manager.RequestManagerTreeNode;

final class GeneratedRequestManagerFactory implements RequestManagerFactory {
    @Override  // com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
    public RequestManager build(Glide glide0, Lifecycle lifecycle0, RequestManagerTreeNode requestManagerTreeNode0, Context context0) {
        return new GlideRequests(glide0, lifecycle0, requestManagerTreeNode0, context0);
    }
}

