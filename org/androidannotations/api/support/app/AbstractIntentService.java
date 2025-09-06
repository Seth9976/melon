package org.androidannotations.api.support.app;

import android.app.IntentService;
import android.content.Intent;

public abstract class AbstractIntentService extends IntentService {
    public AbstractIntentService(String s) {
        super(s);
    }

    @Override  // android.app.IntentService
    public void onHandleIntent(Intent intent0) {
    }
}

