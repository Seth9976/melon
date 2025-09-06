package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class h implements Runnable {
    public final EnhancedIntentService a;
    public final Intent b;
    public final TaskCompletionSource c;

    public h(EnhancedIntentService enhancedIntentService0, Intent intent0, TaskCompletionSource taskCompletionSource0) {
        this.a = enhancedIntentService0;
        this.b = intent0;
        this.c = taskCompletionSource0;
    }

    @Override
    public final void run() {
        try {
            this.a.c(this.b);
        }
        finally {
            this.c.setResult(null);
        }
    }
}

