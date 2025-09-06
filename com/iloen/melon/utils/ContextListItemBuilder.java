package com.iloen.melon.utils;

import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import java.util.ArrayList;

public class ContextListItemBuilder {
    public final ArrayList a;

    public ContextListItemBuilder() {
        this.a = new ArrayList();
    }

    public ContextListItemBuilder add(ContextItemInfo contextItemInfo0) {
        if(contextItemInfo0 != null) {
            this.a.add(contextItemInfo0);
        }
        return this;
    }

    public ArrayList build() {
        return this.a;
    }

    public void clear() {
        this.a.clear();
    }

    public ContextItemInfo get(ContextItemType contextItemType0) {
        for(Object object0: this.a) {
            ContextItemInfo contextItemInfo0 = (ContextItemInfo)object0;
            if(contextItemInfo0.a.equals(contextItemType0)) {
                return contextItemInfo0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public int getCount() {
        return this.a.size();
    }

    public static ContextListItemBuilder newInstance() {
        return new ContextListItemBuilder();
    }
}

