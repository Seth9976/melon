package com.iloen.melon.fragments.comments;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v3x.comments.InsertCmtRes;

public final class o implements ErrorListener, Listener {
    public final CommentListRenewalFragment a;
    public final String b;

    public o(CommentListRenewalFragment commentListRenewalFragment0, String s) {
        this.a = commentListRenewalFragment0;
        this.b = s;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        CommentListRenewalFragment.sendComment$lambda$22(this.a, this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        CommentListRenewalFragment.sendComment$lambda$21(this.a, this.b, ((InsertCmtRes)object0));
    }
}

