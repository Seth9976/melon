package org.androidannotations.api.builder;

import android.app.Activity;
import android.content.Context;

public final class PostActivityStarter {
    private Context context;

    public PostActivityStarter(Context context0) {
        this.context = context0;
    }

    public void withAnimation(int v, int v1) {
        Context context0 = this.context;
        if(context0 instanceof Activity) {
            ((Activity)context0).overridePendingTransition(v, v1);
        }
    }
}

