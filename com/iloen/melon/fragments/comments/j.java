package com.iloen.melon.fragments.comments;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public final class j implements ErrorListener {
    public final int a;
    public final CommentActionImpl b;

    public j(CommentActionImpl commentActionImpl0, int v) {
        this.a = v;
        this.b = commentActionImpl0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public final void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 0: {
                CommentActionImpl.requestInsertRecm$lambda$12(this.b, volleyError0);
                return;
            }
            case 1: {
                CommentActionImpl.removeCmt$lambda$5$lambda$4(this.b, volleyError0);
                return;
            }
            default: {
                CommentActionImpl.requestCancelRecm$lambda$10(this.b, volleyError0);
            }
        }
    }
}

