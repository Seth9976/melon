package com.iloen.melon.fragments.comments;

import B7.b;
import android.widget.TextView;
import com.android.volley.Response.Listener;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.net.v3x.comments.CancelRecmRes;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.InsertRecmRes;
import e3.e;
import java.io.IOException;
import s3.D;
import s3.q;
import s3.v;
import s3.z;

public final class i implements Listener, e {
    public final int a;
    public final Object b;
    public final Object c;
    public final boolean d;
    public final Object e;
    public final Object f;

    public i(b b0, q q0, v v0, IOException iOException0, boolean z) {
        this.a = 2;
        super();
        this.b = b0;
        this.c = q0;
        this.e = v0;
        this.f = iOException0;
        this.d = z;
    }

    public i(CommentActionImpl commentActionImpl0, cmtList cmtResViewModel$result$cmtList0, boolean z, TextView textView0, RecommenderView recommenderView0, int v) {
        this.a = v;
        this.b = commentActionImpl0;
        this.c = cmtResViewModel$result$cmtList0;
        this.d = z;
        this.e = textView0;
        this.f = recommenderView0;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((D)object0).c(((b)this.b).a, ((z)((b)this.b).b), ((q)this.c), ((v)this.e), ((IOException)this.f), this.d);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 0) {
            CommentActionImpl.requestCancelRecm$lambda$9(((CommentActionImpl)this.b), ((cmtList)this.c), this.d, ((TextView)this.e), ((RecommenderView)this.f), ((CancelRecmRes)object0));
            return;
        }
        CommentActionImpl.requestInsertRecm$lambda$11(((CommentActionImpl)this.b), ((cmtList)this.c), this.d, ((TextView)this.e), ((RecommenderView)this.f), ((InsertRecmRes)object0));
    }
}

