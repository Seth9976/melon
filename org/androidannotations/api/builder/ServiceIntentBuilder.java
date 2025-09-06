package org.androidannotations.api.builder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public abstract class ServiceIntentBuilder extends IntentBuilder {
    public ServiceIntentBuilder(Context context0, Intent intent0) {
        super(context0, intent0);
    }

    public ServiceIntentBuilder(Context context0, Class class0) {
        super(context0, class0);
    }

    public ComponentName start() {
        return this.context.startService(this.intent);
    }

    public boolean stop() {
        return this.context.stopService(this.intent);
    }
}

