package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class Jobs {
    private final Map jobs;
    private final Map onlyCacheJobs;

    public Jobs() {
        this.jobs = new HashMap();
        this.onlyCacheJobs = new HashMap();
    }

    public EngineJob get(Key key0, boolean z) {
        return (EngineJob)this.getJobMap(z).get(key0);
    }

    public Map getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    // 去混淆评级： 低(20)
    private Map getJobMap(boolean z) {
        return z ? this.onlyCacheJobs : this.jobs;
    }

    public void put(Key key0, EngineJob engineJob0) {
        this.getJobMap(engineJob0.onlyRetrieveFromCache()).put(key0, engineJob0);
    }

    public void removeIfCurrent(Key key0, EngineJob engineJob0) {
        Map map0 = this.getJobMap(engineJob0.onlyRetrieveFromCache());
        if(engineJob0.equals(map0.get(key0))) {
            map0.remove(key0);
        }
    }
}

