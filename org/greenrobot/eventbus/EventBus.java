package org.greenrobot.eventbus;

import androidx.appcompat.app.o;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidDependenciesDetector;

public class EventBus {
    interface PostCallback {
        void onPostCompleted(List arg1);
    }

    static final class PostingThreadState {
        boolean canceled;
        Object event;
        final List eventQueue;
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        public PostingThreadState() {
            this.eventQueue = new ArrayList();
        }
    }

    private static final EventBusBuilder DEFAULT_BUILDER = null;
    public static String TAG = "EventBus";
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal currentPostingThreadState;
    static volatile EventBus defaultInstance;
    private final boolean eventInheritance;
    private static final Map eventTypesCache;
    private final ExecutorService executorService;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final Logger logger;
    private final Poster mainThreadPoster;
    private final MainThreadSupport mainThreadSupport;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map typesBySubscriber;

    static {
        EventBus.DEFAULT_BUILDER = new EventBusBuilder();
        EventBus.eventTypesCache = new HashMap();
    }

    public EventBus() {
        this(EventBus.DEFAULT_BUILDER);
    }

    public EventBus(EventBusBuilder eventBusBuilder0) {
        this.currentPostingThreadState = new ThreadLocal() {
            @Override
            public Object initialValue() {
                return this.initialValue();
            }

            public PostingThreadState initialValue() {
                return new PostingThreadState();
            }
        };
        this.logger = eventBusBuilder0.getLogger();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        MainThreadSupport mainThreadSupport0 = eventBusBuilder0.getMainThreadSupport();
        this.mainThreadSupport = mainThreadSupport0;
        this.mainThreadPoster = mainThreadSupport0 == null ? null : mainThreadSupport0.createPoster(this);
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        this.indexCount = eventBusBuilder0.subscriberInfoIndexes == null ? 0 : eventBusBuilder0.subscriberInfoIndexes.size();
        this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder0.subscriberInfoIndexes, eventBusBuilder0.strictMethodVerification, eventBusBuilder0.ignoreGeneratedIndex);
        this.logSubscriberExceptions = eventBusBuilder0.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder0.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder0.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder0.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder0.throwSubscriberException;
        this.eventInheritance = eventBusBuilder0.eventInheritance;
        this.executorService = eventBusBuilder0.executorService;
    }

    public static void addInterfaces(List list0, Class[] arr_class) {
        for(int v = 0; v < arr_class.length; ++v) {
            Class class0 = arr_class[v];
            if(!list0.contains(class0)) {
                list0.add(class0);
                EventBus.addInterfaces(list0, class0.getInterfaces());
            }
        }
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    public void cancelEventDelivery(Object object0) {
        PostingThreadState eventBus$PostingThreadState0 = (PostingThreadState)this.currentPostingThreadState.get();
        if(!eventBus$PostingThreadState0.isPosting) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if(object0 == null) {
            throw new EventBusException("Event may not be null");
        }
        if(eventBus$PostingThreadState0.event != object0) {
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        if(eventBus$PostingThreadState0.subscription.subscriberMethod.threadMode != ThreadMode.POSTING) {
            throw new EventBusException(" event handlers may only abort the incoming event");
        }
        eventBus$PostingThreadState0.canceled = true;
    }

    private void checkPostStickyEventToSubscription(Subscription subscription0, Object object0) {
        if(object0 != null) {
            this.postToSubscription(subscription0, object0, this.isMainThread());
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        EventBus.eventTypesCache.clear();
    }

    public static EventBus getDefault() {
        EventBus eventBus0 = EventBus.defaultInstance;
        if(eventBus0 == null) {
            synchronized(EventBus.class) {
                EventBus eventBus1 = EventBus.defaultInstance;
                if(eventBus1 == null) {
                    eventBus1 = new EventBus();
                    EventBus.defaultInstance = eventBus1;
                }
                return eventBus1;
            }
        }
        return eventBus0;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public Object getStickyEvent(Class class0) {
        synchronized(this.stickyEvents) {
        }
        return class0.cast(this.stickyEvents.get(class0));
    }

    private void handleSubscriberException(Subscription subscription0, Object object0, Throwable throwable0) {
        if(object0 instanceof SubscriberExceptionEvent) {
            if(!this.logSubscriberExceptions) {
                return;
            }
            Level level0 = Level.SEVERE;
            this.logger.log(level0, "SubscriberExceptionEvent subscriber " + subscription0.subscriber.getClass() + " threw an exception", throwable0);
            this.logger.log(level0, "Initial event " + ((SubscriberExceptionEvent)object0).causingEvent + " caused exception in " + ((SubscriberExceptionEvent)object0).causingSubscriber, ((SubscriberExceptionEvent)object0).throwable);
            return;
        }
        if(this.throwSubscriberException) {
            throw new EventBusException("Invoking subscriber failed", throwable0);
        }
        if(this.logSubscriberExceptions) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + object0.getClass() + " to subscribing class " + subscription0.subscriber.getClass(), throwable0);
        }
        if(this.sendSubscriberExceptionEvent) {
            this.post(new SubscriberExceptionEvent(this, throwable0, object0, subscription0.subscriber));
        }
    }

    public boolean hasSubscriberForEvent(Class class0) {
        List list0 = EventBus.lookupAllEventTypes(class0);
        if(list0 != null) {
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                Class class1 = (Class)list0.get(v1);
                synchronized(this) {
                    CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(class1);
                }
                if(copyOnWriteArrayList0 != null && !copyOnWriteArrayList0.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void invokeSubscriber(PendingPost pendingPost0) {
        Object object0 = pendingPost0.event;
        Subscription subscription0 = pendingPost0.subscription;
        PendingPost.releasePendingPost(pendingPost0);
        if(subscription0.active) {
            this.invokeSubscriber(subscription0, object0);
        }
    }

    public void invokeSubscriber(Subscription subscription0, Object object0) {
        try {
            subscription0.subscriberMethod.method.invoke(subscription0.subscriber, object0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            this.handleSubscriberException(subscription0, object0, invocationTargetException0.getCause());
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new IllegalStateException("Unexpected exception", illegalAccessException0);
        }
    }

    private boolean isMainThread() {
        return this.mainThreadSupport == null || this.mainThreadSupport.isMainThread();
    }

    public boolean isRegistered(Object object0) {
        synchronized(this) {
            return this.typesBySubscriber.containsKey(object0);
        }
    }

    private static List lookupAllEventTypes(Class class0) {
        Map map0 = EventBus.eventTypesCache;
        synchronized(map0) {
            List list0 = (List)map0.get(class0);
            if(list0 == null) {
                list0 = new ArrayList();
                for(Class class1 = class0; class1 != null; class1 = class1.getSuperclass()) {
                    ((ArrayList)list0).add(class1);
                    EventBus.addInterfaces(list0, class1.getInterfaces());
                }
                EventBus.eventTypesCache.put(class0, list0);
            }
            return list0;
        }
    }

    public void post(Object object0) {
        PostingThreadState eventBus$PostingThreadState0 = (PostingThreadState)this.currentPostingThreadState.get();
        List list0 = eventBus$PostingThreadState0.eventQueue;
        list0.add(object0);
        if(!eventBus$PostingThreadState0.isPosting) {
            eventBus$PostingThreadState0.isMainThread = this.isMainThread();
            eventBus$PostingThreadState0.isPosting = true;
            if(eventBus$PostingThreadState0.canceled) {
                throw new EventBusException("Internal error. Abort state was not reset");
            }
            try {
                while(!list0.isEmpty()) {
                    this.postSingleEvent(list0.remove(0), eventBus$PostingThreadState0);
                }
            }
            finally {
                eventBus$PostingThreadState0.isPosting = false;
                eventBus$PostingThreadState0.isMainThread = false;
            }
        }
    }

    private void postSingleEvent(Object object0, PostingThreadState eventBus$PostingThreadState0) {
        boolean z;
        Class class0 = object0.getClass();
        if(this.eventInheritance) {
            List list0 = EventBus.lookupAllEventTypes(class0);
            int v = list0.size();
            z = false;
            for(int v1 = 0; v1 < v; ++v1) {
                z |= this.postSingleEventForEventType(object0, eventBus$PostingThreadState0, ((Class)list0.get(v1)));
            }
        }
        else {
            z = this.postSingleEventForEventType(object0, eventBus$PostingThreadState0, class0);
        }
        if(!z) {
            if(this.logNoSubscriberMessages) {
                this.logger.log(Level.FINE, "No subscribers registered for event " + class0);
            }
            if(this.sendNoSubscriberEvent && class0 != NoSubscriberEvent.class && class0 != SubscriberExceptionEvent.class) {
                this.post(new NoSubscriberEvent(this, object0));
            }
        }
    }

    private boolean postSingleEventForEventType(Object object0, PostingThreadState eventBus$PostingThreadState0, Class class0) {
        synchronized(this) {
            CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(class0);
        }
        if(copyOnWriteArrayList0 != null && !copyOnWriteArrayList0.isEmpty()) {
            for(Object object1: copyOnWriteArrayList0) {
                Subscription subscription0 = (Subscription)object1;
                eventBus$PostingThreadState0.event = object0;
                eventBus$PostingThreadState0.subscription = subscription0;
                try {
                    this.postToSubscription(subscription0, object0, eventBus$PostingThreadState0.isMainThread);
                    boolean z = eventBus$PostingThreadState0.canceled;
                    eventBus$PostingThreadState0.event = null;
                    eventBus$PostingThreadState0.subscription = null;
                    eventBus$PostingThreadState0.canceled = false;
                    if(z) {
                        return true;
                    }
                }
                catch(Throwable throwable0) {
                    eventBus$PostingThreadState0.event = null;
                    eventBus$PostingThreadState0.subscription = null;
                    eventBus$PostingThreadState0.canceled = false;
                    throw throwable0;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public void postSticky(Object object0) {
        synchronized(this.stickyEvents) {
            Class class0 = object0.getClass();
            this.stickyEvents.put(class0, object0);
        }
        this.post(object0);
    }

    private void postToSubscription(Subscription subscription0, Object object0, boolean z) {
        switch(org.greenrobot.eventbus.EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[subscription0.subscriberMethod.threadMode.ordinal()]) {
            case 1: {
                this.invokeSubscriber(subscription0, object0);
                return;
            }
            case 2: {
                if(z) {
                    this.invokeSubscriber(subscription0, object0);
                    return;
                }
                this.mainThreadPoster.enqueue(subscription0, object0);
                return;
            }
            case 3: {
                Poster poster0 = this.mainThreadPoster;
                if(poster0 != null) {
                    poster0.enqueue(subscription0, object0);
                    return;
                }
                this.invokeSubscriber(subscription0, object0);
                return;
            }
            case 4: {
                if(z) {
                    this.backgroundPoster.enqueue(subscription0, object0);
                    return;
                }
                this.invokeSubscriber(subscription0, object0);
                return;
            }
            case 5: {
                this.asyncPoster.enqueue(subscription0, object0);
                return;
            }
            default: {
                throw new IllegalStateException("Unknown thread mode: " + subscription0.subscriberMethod.threadMode);
            }
        }
    }

    public void register(Object object0) {
        boolean z = !AndroidDependenciesDetector.isAndroidSDKAvailable();
        Class class0 = object0.getClass();
        List list0 = this.subscriberMethodFinder.findSubscriberMethods(class0);
        synchronized(this) {
            for(Object object1: list0) {
                this.subscribe(object0, ((SubscriberMethod)object1));
            }
        }
    }

    public void removeAllStickyEvents() {
        synchronized(this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public Object removeStickyEvent(Class class0) {
        synchronized(this.stickyEvents) {
        }
        return class0.cast(this.stickyEvents.remove(class0));
    }

    public boolean removeStickyEvent(Object object0) {
        synchronized(this.stickyEvents) {
            Class class0 = object0.getClass();
            if(object0.equals(this.stickyEvents.get(class0))) {
                this.stickyEvents.remove(class0);
                return true;
            }
            return false;
        }
    }

    private void subscribe(Object object0, SubscriberMethod subscriberMethod0) {
        Class class0 = subscriberMethod0.eventType;
        Subscription subscription0 = new Subscription(object0, subscriberMethod0);
        CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(class0);
        if(copyOnWriteArrayList0 == null) {
            copyOnWriteArrayList0 = new CopyOnWriteArrayList();
            this.subscriptionsByEventType.put(class0, copyOnWriteArrayList0);
        }
        else if(!copyOnWriteArrayList0.contains(subscription0)) {
        }
        else {
            throw new EventBusException("Subscriber " + object0.getClass() + " already registered to event " + class0);
        }
        int v = copyOnWriteArrayList0.size();
        int v1 = 0;
        while(v1 <= v) {
            if(v1 != v) {
                int v2 = ((Subscription)copyOnWriteArrayList0.get(v1)).subscriberMethod.priority;
                if(subscriberMethod0.priority <= v2) {
                    ++v1;
                    continue;
                }
            }
            copyOnWriteArrayList0.add(v1, subscription0);
            if(true) {
                break;
            }
        }
        List list0 = (List)this.typesBySubscriber.get(object0);
        if(list0 == null) {
            list0 = new ArrayList();
            this.typesBySubscriber.put(object0, list0);
        }
        list0.add(class0);
        if(subscriberMethod0.sticky) {
            if(this.eventInheritance) {
                for(Object object1: this.stickyEvents.entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object1;
                    if(class0.isAssignableFrom(((Class)map$Entry0.getKey()))) {
                        this.checkPostStickyEventToSubscription(subscription0, map$Entry0.getValue());
                    }
                }
                return;
            }
            this.checkPostStickyEventToSubscription(subscription0, this.stickyEvents.get(class0));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EventBus[indexCount=");
        stringBuilder0.append(this.indexCount);
        stringBuilder0.append(", eventInheritance=");
        return o.s(stringBuilder0, this.eventInheritance, "]");
    }

    public void unregister(Object object0) {
        synchronized(this) {
            List list0 = (List)this.typesBySubscriber.get(object0);
            if(list0 == null) {
                this.logger.log(Level.WARNING, "Subscriber to unregister was not registered before: " + object0.getClass());
            }
            else {
                for(Object object1: list0) {
                    this.unsubscribeByEventType(object0, ((Class)object1));
                }
                this.typesBySubscriber.remove(object0);
            }
        }
    }

    private void unsubscribeByEventType(Object object0, Class class0) {
        List list0 = (List)this.subscriptionsByEventType.get(class0);
        if(list0 != null) {
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                Subscription subscription0 = (Subscription)list0.get(v1);
                if(subscription0.subscriber == object0) {
                    subscription0.active = false;
                    list0.remove(v1);
                    --v1;
                    --v;
                }
            }
        }
    }

    class org.greenrobot.eventbus.EventBus.2 {
        static final int[] $SwitchMap$org$greenrobot$eventbus$ThreadMode;

        static {
            int[] arr_v = new int[ThreadMode.values().length];
            org.greenrobot.eventbus.EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode = arr_v;
            try {
                arr_v[ThreadMode.POSTING.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                org.greenrobot.eventbus.EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                org.greenrobot.eventbus.EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                org.greenrobot.eventbus.EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                org.greenrobot.eventbus.EventBus.2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

