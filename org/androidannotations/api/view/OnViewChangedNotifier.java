package org.androidannotations.api.view;

import java.util.LinkedHashSet;
import java.util.Set;

public class OnViewChangedNotifier {
    private static OnViewChangedNotifier currentNotifier;
    private final Set listeners;

    public OnViewChangedNotifier() {
        this.listeners = new LinkedHashSet();
    }

    public void notifyViewChanged(HasViews hasViews0) {
        for(Object object0: this.listeners) {
            ((OnViewChangedListener)object0).onViewChanged(hasViews0);
        }
    }

    public static void registerOnViewChangedListener(OnViewChangedListener onViewChangedListener0) {
        OnViewChangedNotifier onViewChangedNotifier0 = OnViewChangedNotifier.currentNotifier;
        if(onViewChangedNotifier0 != null) {
            onViewChangedNotifier0.listeners.add(onViewChangedListener0);
        }
    }

    public static OnViewChangedNotifier replaceNotifier(OnViewChangedNotifier onViewChangedNotifier0) {
        OnViewChangedNotifier onViewChangedNotifier1 = OnViewChangedNotifier.currentNotifier;
        OnViewChangedNotifier.currentNotifier = onViewChangedNotifier0;
        return onViewChangedNotifier1;
    }
}

