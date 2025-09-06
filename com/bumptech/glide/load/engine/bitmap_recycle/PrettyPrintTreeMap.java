package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Map.Entry;
import java.util.TreeMap;
import k8.Y;

class PrettyPrintTreeMap extends TreeMap {
    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Y.p("( ");
        for(Object object0: this.entrySet()) {
            stringBuilder0.append('{');
            stringBuilder0.append(((Map.Entry)object0).getKey());
            stringBuilder0.append(':');
            stringBuilder0.append(((Map.Entry)object0).getValue());
            stringBuilder0.append("}, ");
        }
        if(!this.isEmpty()) {
            stringBuilder0.replace(stringBuilder0.length() - 2, stringBuilder0.length(), "");
        }
        stringBuilder0.append(" )");
        return stringBuilder0.toString();
    }
}

