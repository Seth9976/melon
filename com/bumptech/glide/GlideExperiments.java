package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GlideExperiments {
    static final class Builder {
        private final Map experiments;

        public Builder() {
            this.experiments = new HashMap();
        }

        public static Map access$000(Builder glideExperiments$Builder0) {
            return glideExperiments$Builder0.experiments;
        }

        public Builder add(Experiment glideExperiments$Experiment0) {
            Class class0 = glideExperiments$Experiment0.getClass();
            this.experiments.put(class0, glideExperiments$Experiment0);
            return this;
        }

        public GlideExperiments build() {
            return new GlideExperiments(this);
        }

        public Builder update(Experiment glideExperiments$Experiment0, boolean z) {
            if(z) {
                this.add(glideExperiments$Experiment0);
                return this;
            }
            Class class0 = glideExperiments$Experiment0.getClass();
            this.experiments.remove(class0);
            return this;
        }
    }

    interface Experiment {
    }

    private final Map experiments;

    public GlideExperiments(Builder glideExperiments$Builder0) {
        this.experiments = Collections.unmodifiableMap(new HashMap(Builder.access$000(glideExperiments$Builder0)));
    }

    public Experiment get(Class class0) {
        return (Experiment)this.experiments.get(class0);
    }

    public boolean isEnabled(Class class0) {
        return this.experiments.containsKey(class0);
    }
}

