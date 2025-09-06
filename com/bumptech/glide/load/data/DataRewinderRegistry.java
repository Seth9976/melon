package com.bumptech.glide.load.data;

import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class DataRewinderRegistry {
    static final class DefaultRewinder implements DataRewinder {
        private final Object data;

        public DefaultRewinder(Object object0) {
            this.data = object0;
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder
        public Object rewindAndGet() {
            return this.data;
        }
    }

    private static final Factory DEFAULT_FACTORY;
    private final Map rewinders;

    static {
        DataRewinderRegistry.DEFAULT_FACTORY = new Factory() {
            @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
            public DataRewinder build(Object object0) {
                return new DefaultRewinder(object0);
            }

            @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
            public Class getDataClass() {
                throw new UnsupportedOperationException("Not implemented");
            }
        };
    }

    public DataRewinderRegistry() {
        this.rewinders = new HashMap();
    }

    public DataRewinder build(Object object0) {
        synchronized(this) {
            Preconditions.checkNotNull(object0);
            Class class0 = object0.getClass();
            Factory dataRewinder$Factory0 = (Factory)this.rewinders.get(class0);
            if(dataRewinder$Factory0 == null) {
                for(Object object1: this.rewinders.values()) {
                    Factory dataRewinder$Factory1 = (Factory)object1;
                    if(dataRewinder$Factory1.getDataClass().isAssignableFrom(object0.getClass())) {
                        dataRewinder$Factory0 = dataRewinder$Factory1;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            if(dataRewinder$Factory0 == null) {
                dataRewinder$Factory0 = DataRewinderRegistry.DEFAULT_FACTORY;
            }
            return dataRewinder$Factory0.build(object0);
        }
    }

    public void register(Factory dataRewinder$Factory0) {
        synchronized(this) {
            Class class0 = dataRewinder$Factory0.getDataClass();
            this.rewinders.put(class0, dataRewinder$Factory0);
        }
    }
}

