package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {
    static final class Entry {
        private final Class dataClass;
        final Encoder encoder;

        public Entry(Class class0, Encoder encoder0) {
            this.dataClass = class0;
            this.encoder = encoder0;
        }

        public boolean handles(Class class0) {
            return this.dataClass.isAssignableFrom(class0);
        }
    }

    private final List encoders;

    public EncoderRegistry() {
        this.encoders = new ArrayList();
    }

    public void append(Class class0, Encoder encoder0) {
        synchronized(this) {
            Entry encoderRegistry$Entry0 = new Entry(class0, encoder0);
            this.encoders.add(encoderRegistry$Entry0);
        }
    }

    public Encoder getEncoder(Class class0) {
        synchronized(this) {
            for(Object object0: this.encoders) {
                Entry encoderRegistry$Entry0 = (Entry)object0;
                if(encoderRegistry$Entry0.handles(class0)) {
                    return encoderRegistry$Entry0.encoder;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
    }

    public void prepend(Class class0, Encoder encoder0) {
        synchronized(this) {
            Entry encoderRegistry$Entry0 = new Entry(class0, encoder0);
            this.encoders.add(0, encoderRegistry$Entry0);
        }
    }
}

