package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {
    static final class Entry {
        final ResourceEncoder encoder;
        private final Class resourceClass;

        public Entry(Class class0, ResourceEncoder resourceEncoder0) {
            this.resourceClass = class0;
            this.encoder = resourceEncoder0;
        }

        public boolean handles(Class class0) {
            return this.resourceClass.isAssignableFrom(class0);
        }
    }

    private final List encoders;

    public ResourceEncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public void append(Class class0, ResourceEncoder resourceEncoder0) {
        synchronized(this) {
            Entry resourceEncoderRegistry$Entry0 = new Entry(class0, resourceEncoder0);
            this.encoders.add(resourceEncoderRegistry$Entry0);
        }
    }

    public ResourceEncoder get(Class class0) {
        synchronized(this) {
            int v1 = this.encoders.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                Entry resourceEncoderRegistry$Entry0 = (Entry)this.encoders.get(v2);
                if(resourceEncoderRegistry$Entry0.handles(class0)) {
                    return resourceEncoderRegistry$Entry0.encoder;
                }
            }
            return null;
        }
    }

    public void prepend(Class class0, ResourceEncoder resourceEncoder0) {
        synchronized(this) {
            Entry resourceEncoderRegistry$Entry0 = new Entry(class0, resourceEncoder0);
            this.encoders.add(0, resourceEncoderRegistry$Entry0);
        }
    }
}

