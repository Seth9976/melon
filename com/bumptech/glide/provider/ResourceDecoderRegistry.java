package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {
    static class Entry {
        private final Class dataClass;
        final ResourceDecoder decoder;
        final Class resourceClass;

        public Entry(Class class0, Class class1, ResourceDecoder resourceDecoder0) {
            this.dataClass = class0;
            this.resourceClass = class1;
            this.decoder = resourceDecoder0;
        }

        // 去混淆评级： 低(20)
        public boolean handles(Class class0, Class class1) {
            return this.dataClass.isAssignableFrom(class0) && class1.isAssignableFrom(this.resourceClass);
        }
    }

    private final List bucketPriorityList;
    private final Map decoders;

    public ResourceDecoderRegistry() {
        this.bucketPriorityList = new ArrayList();
        this.decoders = new HashMap();
    }

    public void append(String s, ResourceDecoder resourceDecoder0, Class class0, Class class1) {
        synchronized(this) {
            this.getOrAddEntryList(s).add(new Entry(class0, class1, resourceDecoder0));
        }
    }

    public List getDecoders(Class class0, Class class1) {
        synchronized(this) {
            List list0 = new ArrayList();
            for(Object object0: this.bucketPriorityList) {
                List list1 = (List)this.decoders.get(((String)object0));
                if(list1 != null) {
                    for(Object object1: list1) {
                        Entry resourceDecoderRegistry$Entry0 = (Entry)object1;
                        if(resourceDecoderRegistry$Entry0.handles(class0, class1)) {
                            ((ArrayList)list0).add(resourceDecoderRegistry$Entry0.decoder);
                        }
                    }
                }
            }
            return list0;
        }
    }

    private List getOrAddEntryList(String s) {
        synchronized(this) {
            if(!this.bucketPriorityList.contains(s)) {
                this.bucketPriorityList.add(s);
            }
            List list0 = (List)this.decoders.get(s);
            if(list0 == null) {
                list0 = new ArrayList();
                this.decoders.put(s, list0);
            }
            return list0;
        }
    }

    public List getResourceClasses(Class class0, Class class1) {
        synchronized(this) {
            List list0 = new ArrayList();
            for(Object object0: this.bucketPriorityList) {
                List list1 = (List)this.decoders.get(((String)object0));
                if(list1 != null) {
                    for(Object object1: list1) {
                        Entry resourceDecoderRegistry$Entry0 = (Entry)object1;
                        if(resourceDecoderRegistry$Entry0.handles(class0, class1) && !((ArrayList)list0).contains(resourceDecoderRegistry$Entry0.resourceClass)) {
                            ((ArrayList)list0).add(resourceDecoderRegistry$Entry0.resourceClass);
                        }
                    }
                }
            }
            return list0;
        }
    }

    public void prepend(String s, ResourceDecoder resourceDecoder0, Class class0, Class class1) {
        synchronized(this) {
            this.getOrAddEntryList(s).add(0, new Entry(class0, class1, resourceDecoder0));
        }
    }

    public void setBucketPriorityList(List list0) {
        synchronized(this) {
            ArrayList arrayList0 = new ArrayList(this.bucketPriorityList);
            this.bucketPriorityList.clear();
            for(Object object0: list0) {
                this.bucketPriorityList.add(((String)object0));
            }
            for(Object object1: arrayList0) {
                String s = (String)object1;
                if(!list0.contains(s)) {
                    this.bucketPriorityList.add(s);
                }
            }
        }
    }
}

