package com.iloen.melon.eventbus;

import com.iloen.melon.utils.log.LogU;
import java.util.HashSet;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusHelper {
    public static final String TAG = "EventBusHelper";
    private static final EventBusHelper sInst;
    private final Set subscribers;

    static {
        EventBusHelper.sInst = new EventBusHelper();
    }

    private EventBusHelper() {
        this.subscribers = new HashSet();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Object object0) {
        LogU.d("EventBusHelper", "onEvent: " + object0);
    }

    public static void post(Object object0) {
        LogU.v("EventBusHelper", "  post " + object0);
        EventBus.getDefault().post(object0);
    }

    public static void register(Object object0) {
        synchronized(EventBusHelper.class) {
            if(EventBusHelper.sInst.subscribers.add(object0)) {
                LogU.v("EventBusHelper", "  registered " + object0);
                EventBus.getDefault().register(object0);
            }
            else {
                LogU.v("EventBusHelper", "  !already registered " + object0);
            }
        }
    }

    public static void unregister(Object object0) {
        synchronized(EventBusHelper.class) {
            EventBusHelper eventBusHelper0 = EventBusHelper.sInst;
            if(eventBusHelper0.subscribers.remove(object0)) {
                EventBus.getDefault().unregister(object0);
                LogU.v("EventBusHelper", "  unregistered " + object0 + ", nSubscribers:" + eventBusHelper0.subscribers.size());
            }
            else {
                LogU.v("EventBusHelper", "  !already unregistered " + object0);
            }
        }
    }
}

