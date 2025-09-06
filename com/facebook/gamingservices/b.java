package com.facebook.gamingservices;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.bolts.TaskCompletionSource;

public final class b implements Callback {
    public final int a;
    public final TaskCompletionSource b;

    public b(TaskCompletionSource taskCompletionSource0, int v) {
        this.a = v;
        this.b = taskCompletionSource0;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        if(this.a != 0) {
            TournamentUpdater.update$lambda$0(this.b, graphResponse0);
            return;
        }
        TournamentFetcher.fetchTournaments$lambda$1(this.b, graphResponse0);
    }
}

