package com.facebook.internal;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import java.util.concurrent.CountDownLatch;

public final class g implements Callback {
    public final String[] a;
    public final int b;
    public final UploadStagingResourcesTask c;
    public final CountDownLatch d;

    public g(String[] arr_s, int v, UploadStagingResourcesTask webDialog$UploadStagingResourcesTask0, CountDownLatch countDownLatch0) {
        this.a = arr_s;
        this.b = v;
        this.c = webDialog$UploadStagingResourcesTask0;
        this.d = countDownLatch0;
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        UploadStagingResourcesTask.doInBackground$lambda$0(this.a, this.b, this.c, this.d, graphResponse0);
    }
}

