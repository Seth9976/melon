package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookException;

public final class a implements OnCompleteListener {
    public final int a;
    public final FacebookDialogFragment b;

    public a(FacebookDialogFragment facebookDialogFragment0, int v) {
        this.a = v;
        this.b = facebookDialogFragment0;
        super();
    }

    @Override  // com.facebook.internal.WebDialog$OnCompleteListener
    public final void onComplete(Bundle bundle0, FacebookException facebookException0) {
        if(this.a != 0) {
            FacebookDialogFragment.initDialog$lambda$1(this.b, bundle0, facebookException0);
            return;
        }
        FacebookDialogFragment.initDialog$lambda$0(this.b, bundle0, facebookException0);
    }
}

