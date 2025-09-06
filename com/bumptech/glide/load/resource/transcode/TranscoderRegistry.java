package com.bumptech.glide.load.resource.transcode;

import java.util.ArrayList;
import java.util.List;

public class TranscoderRegistry {
    static final class Entry {
        final Class fromClass;
        final Class toClass;
        final ResourceTranscoder transcoder;

        public Entry(Class class0, Class class1, ResourceTranscoder resourceTranscoder0) {
            this.fromClass = class0;
            this.toClass = class1;
            this.transcoder = resourceTranscoder0;
        }

        // 去混淆评级： 低(20)
        public boolean handles(Class class0, Class class1) {
            return this.fromClass.isAssignableFrom(class0) && class1.isAssignableFrom(this.toClass);
        }
    }

    private final List transcoders;

    public TranscoderRegistry() {
        this.transcoders = new ArrayList();
    }

    public ResourceTranscoder get(Class class0, Class class1) {
        synchronized(this) {
            if(class1.isAssignableFrom(class0)) {
                return UnitTranscoder.get();
            }
            for(Object object0: this.transcoders) {
                Entry transcoderRegistry$Entry0 = (Entry)object0;
                if(transcoderRegistry$Entry0.handles(class0, class1)) {
                    return transcoderRegistry$Entry0.transcoder;
                }
                if(false) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + class0 + " to " + class1);
    }

    public List getTranscodeClasses(Class class0, Class class1) {
        synchronized(this) {
            List list0 = new ArrayList();
            if(class1.isAssignableFrom(class0)) {
                ((ArrayList)list0).add(class1);
                return list0;
            }
            for(Object object0: this.transcoders) {
                Entry transcoderRegistry$Entry0 = (Entry)object0;
                if(transcoderRegistry$Entry0.handles(class0, class1) && !((ArrayList)list0).contains(transcoderRegistry$Entry0.toClass)) {
                    ((ArrayList)list0).add(transcoderRegistry$Entry0.toClass);
                }
            }
            return list0;
        }
    }

    public void register(Class class0, Class class1, ResourceTranscoder resourceTranscoder0) {
        synchronized(this) {
            Entry transcoderRegistry$Entry0 = new Entry(class0, class1, resourceTranscoder0);
            this.transcoders.add(transcoderRegistry$Entry0);
        }
    }
}

