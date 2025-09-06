package org.androidannotations.api.builder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract class ActivityIntentBuilder extends IntentBuilder implements ActivityStarter {
    protected Bundle lastOptions;

    public ActivityIntentBuilder(Context context0, Intent intent0) {
        super(context0, intent0);
    }

    public ActivityIntentBuilder(Context context0, Class class0) {
        super(context0, class0);
    }

    @Override  // org.androidannotations.api.builder.ActivityStarter
    public final PostActivityStarter start() {
        this.startForResult(-1);
        return new PostActivityStarter(this.context);
    }

    @Override  // org.androidannotations.api.builder.ActivityStarter
    public abstract PostActivityStarter startForResult(int arg1);

    public ActivityStarter withOptions(Bundle bundle0) {
        this.lastOptions = bundle0;
        return this;
    }
}

