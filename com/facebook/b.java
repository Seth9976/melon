package com.facebook;

public final class b implements Callback {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        switch(this.a) {
            case 0: {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$2(((RefreshResult)this.b), graphResponse0);
                return;
            }
            case 1: {
                GraphRequest._set_callback_$lambda$0(((Callback)this.b), graphResponse0);
                return;
            }
            case 2: {
                Companion.newPlacesSearchRequest$lambda$1(((GraphJSONArrayCallback)this.b), graphResponse0);
                return;
            }
            default: {
                Companion.newMeRequest$lambda$0(((GraphJSONObjectCallback)this.b), graphResponse0);
            }
        }
    }
}

