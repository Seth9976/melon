package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class PreFillQueue {
    private final Map bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List keyList;

    public PreFillQueue(Map map0) {
        this.bitmapsPerType = map0;
        this.keyList = new ArrayList(map0.keySet());
        for(Object object0: map0.values()) {
            this.bitmapsRemaining = ((int)(((Integer)object0))) + this.bitmapsRemaining;
        }
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }

    public PreFillType remove() {
        PreFillType preFillType0 = (PreFillType)this.keyList.get(this.keyIndex);
        Integer integer0 = (Integer)this.bitmapsPerType.get(preFillType0);
        if(((int)integer0) == 1) {
            this.bitmapsPerType.remove(preFillType0);
            this.keyList.remove(this.keyIndex);
        }
        else {
            this.bitmapsPerType.put(preFillType0, ((int)(((int)integer0) - 1)));
        }
        --this.bitmapsRemaining;
        this.keyIndex = this.keyList.isEmpty() ? 0 : (this.keyIndex + 1) % this.keyList.size();
        return preFillType0;
    }
}

