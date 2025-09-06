package org.greenrobot.eventbus;

import com.iloen.melon.utils.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import va.e;

class SubscriberMethodFinder {
    static class FindState {
        final Map anyMethodByEventType;
        Class clazz;
        final StringBuilder methodKeyBuilder;
        boolean skipSuperClasses;
        Class subscriberClass;
        final Map subscriberClassByMethodKey;
        SubscriberInfo subscriberInfo;
        final List subscriberMethods;

        public FindState() {
            this.subscriberMethods = new ArrayList();
            this.anyMethodByEventType = new HashMap();
            this.subscriberClassByMethodKey = new HashMap();
            this.methodKeyBuilder = new StringBuilder(0x80);
        }

        public boolean checkAdd(Method method0, Class class0) {
            Object object0 = this.anyMethodByEventType.put(class0, method0);
            if(object0 == null) {
                return true;
            }
            if(object0 instanceof Method) {
                if(!this.checkAddWithMethodSignature(((Method)object0), class0)) {
                    throw new IllegalStateException();
                }
                this.anyMethodByEventType.put(class0, this);
                return this.checkAddWithMethodSignature(method0, class0);
            }
            return this.checkAddWithMethodSignature(method0, class0);
        }

        private boolean checkAddWithMethodSignature(Method method0, Class class0) {
            this.methodKeyBuilder.setLength(0);
            String s = method0.getName();
            this.methodKeyBuilder.append(s);
            this.methodKeyBuilder.append('>');
            this.methodKeyBuilder.append(class0.getName());
            String s1 = this.methodKeyBuilder.toString();
            Class class1 = method0.getDeclaringClass();
            Class class2 = (Class)this.subscriberClassByMethodKey.put(s1, class1);
            if(class2 != null && !class2.isAssignableFrom(class1)) {
                this.subscriberClassByMethodKey.put(s1, class2);
                return false;
            }
            return true;
        }

        public void initForSubscriber(Class class0) {
            this.clazz = class0;
            this.subscriberClass = class0;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        public void moveToSuperclass() {
            if(this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            Class class0 = this.clazz.getSuperclass();
            this.clazz = class0;
            String s = class0.getName();
            if(!s.startsWith("java.") && !s.startsWith("javax.") && !s.startsWith("android.") && !s.startsWith("androidx.")) {
                return;
            }
            this.clazz = null;
        }

        public void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }
    }

    private static final int BRIDGE = 0x40;
    private static final FindState[] FIND_STATE_POOL = null;
    private static final Map METHOD_CACHE = null;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 0x1000;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List subscriberInfoIndexes;

    static {
        SubscriberMethodFinder.METHOD_CACHE = new ConcurrentHashMap();
        SubscriberMethodFinder.FIND_STATE_POOL = new FindState[4];
    }

    public SubscriberMethodFinder(List list0, boolean z, boolean z1) {
        this.subscriberInfoIndexes = list0;
        this.strictMethodVerification = z;
        this.ignoreGeneratedIndex = z1;
    }

    public static void clearCaches() {
        SubscriberMethodFinder.METHOD_CACHE.clear();
    }

    public List findSubscriberMethods(Class class0) {
        Map map0 = SubscriberMethodFinder.METHOD_CACHE;
        List list0 = (List)map0.get(class0);
        if(list0 != null) {
            return list0;
        }
        List list1 = this.ignoreGeneratedIndex ? this.findUsingReflection(class0) : this.findUsingInfo(class0);
        if(list1.isEmpty()) {
            throw new EventBusException("Subscriber " + class0 + " and its super classes have no public methods with the @Subscribe annotation");
        }
        map0.put(class0, list1);
        return list1;
    }

    private List findUsingInfo(Class class0) {
        FindState subscriberMethodFinder$FindState0 = this.prepareFindState();
        subscriberMethodFinder$FindState0.initForSubscriber(class0);
        while(subscriberMethodFinder$FindState0.clazz != null) {
            SubscriberInfo subscriberInfo0 = this.getSubscriberInfo(subscriberMethodFinder$FindState0);
            subscriberMethodFinder$FindState0.subscriberInfo = subscriberInfo0;
            if(subscriberInfo0 == null) {
                this.findUsingReflectionInSingleClass(subscriberMethodFinder$FindState0);
            }
            else {
                SubscriberMethod[] arr_subscriberMethod = subscriberInfo0.getSubscriberMethods();
                for(int v = 0; v < arr_subscriberMethod.length; ++v) {
                    SubscriberMethod subscriberMethod0 = arr_subscriberMethod[v];
                    if(subscriberMethodFinder$FindState0.checkAdd(subscriberMethod0.method, subscriberMethod0.eventType)) {
                        subscriberMethodFinder$FindState0.subscriberMethods.add(subscriberMethod0);
                    }
                }
            }
            subscriberMethodFinder$FindState0.moveToSuperclass();
        }
        return this.getMethodsAndRelease(subscriberMethodFinder$FindState0);
    }

    private List findUsingReflection(Class class0) {
        FindState subscriberMethodFinder$FindState0 = this.prepareFindState();
        subscriberMethodFinder$FindState0.initForSubscriber(class0);
        while(subscriberMethodFinder$FindState0.clazz != null) {
            this.findUsingReflectionInSingleClass(subscriberMethodFinder$FindState0);
            subscriberMethodFinder$FindState0.moveToSuperclass();
        }
        return this.getMethodsAndRelease(subscriberMethodFinder$FindState0);
    }

    private void findUsingReflectionInSingleClass(FindState subscriberMethodFinder$FindState0) {
        Method[] arr_method;
        try {
            arr_method = subscriberMethodFinder$FindState0.clazz.getDeclaredMethods();
        }
        catch(Throwable unused_ex) {
            try {
                arr_method = subscriberMethodFinder$FindState0.clazz.getMethods();
                subscriberMethodFinder$FindState0.skipSuperClasses = true;
            }
            catch(LinkageError linkageError0) {
                String s = "Could not inspect methods of " + subscriberMethodFinder$FindState0.clazz.getName();
                throw new EventBusException((this.ignoreGeneratedIndex ? s + ". Please consider using EventBus annotation processor to avoid reflection." : s + ". Please make this class visible to EventBus annotation processor to avoid reflection."), linkageError0);
            }
        }
        for(int v = 0; v < arr_method.length; ++v) {
            Method method0 = arr_method[v];
            int v1 = method0.getModifiers();
            Class class0 = Subscribe.class;
            if((v1 & 1) != 0 && (v1 & 5192) == 0) {
                Class[] arr_class = method0.getParameterTypes();
                if(arr_class.length == 1) {
                    Subscribe subscribe0 = (Subscribe)method0.getAnnotation(class0);
                    if(subscribe0 != null) {
                        Class class1 = arr_class[0];
                        if(subscriberMethodFinder$FindState0.checkAdd(method0, class1)) {
                            SubscriberMethod subscriberMethod0 = new SubscriberMethod(method0, class1, subscribe0.threadMode(), subscribe0.priority(), subscribe0.sticky());
                            subscriberMethodFinder$FindState0.subscriberMethods.add(subscriberMethod0);
                        }
                    }
                }
                else if(this.strictMethodVerification && method0.isAnnotationPresent(class0)) {
                    StringBuilder stringBuilder0 = a.n("@Subscribe method ", method0.getDeclaringClass().getName() + "." + method0.getName(), "must have exactly 1 parameter but has ");
                    stringBuilder0.append(arr_class.length);
                    throw new EventBusException(stringBuilder0.toString());
                }
            }
            else if(this.strictMethodVerification && method0.isAnnotationPresent(class0)) {
                throw new EventBusException(e.h((method0.getDeclaringClass().getName() + "." + method0.getName()), " is a illegal @Subscribe method: must be public, non-static, and non-abstract"));
            }
        }
    }

    private List getMethodsAndRelease(FindState subscriberMethodFinder$FindState0) {
        List list0 = new ArrayList(subscriberMethodFinder$FindState0.subscriberMethods);
        subscriberMethodFinder$FindState0.recycle();
        synchronized(SubscriberMethodFinder.FIND_STATE_POOL) {
            for(int v1 = 0; v1 < 4; ++v1) {
                FindState[] arr_subscriberMethodFinder$FindState1 = SubscriberMethodFinder.FIND_STATE_POOL;
                if(arr_subscriberMethodFinder$FindState1[v1] == null) {
                    arr_subscriberMethodFinder$FindState1[v1] = subscriberMethodFinder$FindState0;
                    break;
                }
            }
            return list0;
        }
    }

    private SubscriberInfo getSubscriberInfo(FindState subscriberMethodFinder$FindState0) {
        if(subscriberMethodFinder$FindState0.subscriberInfo != null && subscriberMethodFinder$FindState0.subscriberInfo.getSuperSubscriberInfo() != null) {
            SubscriberInfo subscriberInfo0 = subscriberMethodFinder$FindState0.subscriberInfo.getSuperSubscriberInfo();
            if(subscriberMethodFinder$FindState0.clazz == subscriberInfo0.getSubscriberClass()) {
                return subscriberInfo0;
            }
        }
        List list0 = this.subscriberInfoIndexes;
        if(list0 != null) {
            for(Object object0: list0) {
                SubscriberInfo subscriberInfo1 = ((SubscriberInfoIndex)object0).getSubscriberInfo(subscriberMethodFinder$FindState0.clazz);
                if(subscriberInfo1 != null) {
                    return subscriberInfo1;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    private FindState prepareFindState() {
        synchronized(SubscriberMethodFinder.FIND_STATE_POOL) {
            for(int v1 = 0; v1 < 4; ++v1) {
                FindState[] arr_subscriberMethodFinder$FindState1 = SubscriberMethodFinder.FIND_STATE_POOL;
                FindState subscriberMethodFinder$FindState0 = arr_subscriberMethodFinder$FindState1[v1];
                if(subscriberMethodFinder$FindState0 != null) {
                    arr_subscriberMethodFinder$FindState1[v1] = null;
                    return subscriberMethodFinder$FindState0;
                }
            }
        }
        return new FindState();
    }
}

