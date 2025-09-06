package com.iloen.melon.task;

import android.os.Binder;

public abstract class LocalServiceBinder extends Binder {
    public abstract Object getService();
}

