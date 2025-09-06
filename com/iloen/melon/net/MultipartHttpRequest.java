package com.iloen.melon.net;

import android.content.Context;

public abstract class MultipartHttpRequest extends HttpRequest {
    public MultipartHttpRequest(Context context0, Class class0) {
        this(context0, class0, true);
    }

    public MultipartHttpRequest(Context context0, Class class0, boolean z) {
        super(context0, -1, class0, z);
    }

    public MultipartHttpRequest(Context context0, String s, String s1, Class class0) {
        super(context0, s, s1, -1, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

