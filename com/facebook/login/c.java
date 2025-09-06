package com.facebook.login;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;

public final class c implements Callback {
    public final int a;
    public final DeviceAuthDialog b;

    public c(DeviceAuthDialog deviceAuthDialog0, int v) {
        this.a = v;
        this.b = deviceAuthDialog0;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        if(this.a != 0) {
            DeviceAuthDialog.startLogin$lambda$1(this.b, graphResponse0);
            return;
        }
        DeviceAuthDialog._get_pollRequest_$lambda$5(this.b, graphResponse0);
    }
}

