package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger.Default;

public class ExceptionToResourceMapping {
    public final Map throwableToMsgIdMap;

    public ExceptionToResourceMapping() {
        this.throwableToMsgIdMap = new HashMap();
    }

    public ExceptionToResourceMapping addMapping(Class class0, int v) {
        this.throwableToMsgIdMap.put(class0, v);
        return this;
    }

    public Integer mapThrowable(Throwable throwable0) {
        int v = 20;
        Throwable throwable1 = throwable0;
        do {
            Integer integer0 = this.mapThrowableFlat(throwable1);
            if(integer0 != null) {
                return integer0;
            }
            throwable1 = throwable1.getCause();
            --v;
        }
        while(v > 0 && throwable1 != throwable0 && throwable1 != null);
        Default.get().log(Level.FINE, "No specific message resource ID found for " + throwable0);
        return null;
    }

    public Integer mapThrowableFlat(Throwable throwable0) {
        Class class0 = throwable0.getClass();
        Integer integer0 = (Integer)this.throwableToMsgIdMap.get(class0);
        if(integer0 == null) {
            Class class1 = null;
            for(Object object0: this.throwableToMsgIdMap.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                Class class2 = (Class)map$Entry0.getKey();
                if(class2.isAssignableFrom(class0) && (class1 == null || class1.isAssignableFrom(class2))) {
                    integer0 = (Integer)map$Entry0.getValue();
                    class1 = class2;
                }
            }
        }
        return integer0;
    }
}

