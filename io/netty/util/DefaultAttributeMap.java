package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultAttributeMap implements AttributeMap {
    static final class DefaultAttribute extends AtomicReference implements Attribute {
        private static final AtomicReferenceFieldUpdater MAP_UPDATER = null;
        private volatile DefaultAttributeMap attributeMap;
        private final AttributeKey key;
        private static final long serialVersionUID = 0xDB10C4603A66307DL;

        static {
            DefaultAttribute.MAP_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttribute.class, DefaultAttributeMap.class, "attributeMap");
        }

        public DefaultAttribute(DefaultAttributeMap defaultAttributeMap0, AttributeKey attributeKey0) {
            this.attributeMap = defaultAttributeMap0;
            this.key = attributeKey0;
        }

        public static AttributeKey access$000(DefaultAttribute defaultAttributeMap$DefaultAttribute0) {
            return defaultAttributeMap$DefaultAttribute0.key;
        }

        public static boolean access$100(DefaultAttribute defaultAttributeMap$DefaultAttribute0) {
            return defaultAttributeMap$DefaultAttribute0.isRemoved();
        }

        @Override  // io.netty.util.Attribute
        public Object getAndRemove() {
            boolean z;
            DefaultAttributeMap defaultAttributeMap0 = this.attributeMap;
            if(defaultAttributeMap0 != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultAttribute.MAP_UPDATER;
                while(true) {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, defaultAttributeMap0, null)) {
                        z = true;
                        goto label_8;
                    }
                    if(atomicReferenceFieldUpdater0.get(this) != defaultAttributeMap0) {
                        break;
                    }
                }
            }
            z = false;
        label_8:
            Object object0 = this.getAndSet(null);
            if(z) {
                defaultAttributeMap0.removeAttributeIfMatch(this.key, this);
            }
            return object0;
        }

        private boolean isRemoved() {
            return this.attributeMap == null;
        }

        @Override  // io.netty.util.Attribute
        public AttributeKey key() {
            return this.key;
        }

        @Override  // io.netty.util.Attribute
        public void remove() {
            boolean z;
            DefaultAttributeMap defaultAttributeMap0 = this.attributeMap;
            if(defaultAttributeMap0 != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultAttribute.MAP_UPDATER;
                while(true) {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, defaultAttributeMap0, null)) {
                        z = true;
                        goto label_8;
                    }
                    if(atomicReferenceFieldUpdater0.get(this) != defaultAttributeMap0) {
                        break;
                    }
                }
            }
            z = false;
        label_8:
            this.set(null);
            if(z) {
                defaultAttributeMap0.removeAttributeIfMatch(this.key, this);
            }
        }

        @Override  // io.netty.util.Attribute
        public Object setIfAbsent(Object object0) {
            Object object1;
            while(!this.compareAndSet(null, object0)) {
                object1 = this.get();
                if(object1 != null) {
                    break;
                }
            }
            return object1;
        }
    }

    static final boolean $assertionsDisabled;
    private static final AtomicReferenceFieldUpdater ATTRIBUTES_UPDATER;
    private static final DefaultAttribute[] EMPTY_ATTRIBUTES;
    private volatile DefaultAttribute[] attributes;

    static {
        DefaultAttributeMap.ATTRIBUTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, DefaultAttribute[].class, "attributes");
        DefaultAttributeMap.EMPTY_ATTRIBUTES = new DefaultAttribute[0];
    }

    public DefaultAttributeMap() {
        this.attributes = DefaultAttributeMap.EMPTY_ATTRIBUTES;
    }

    @Override  // io.netty.util.AttributeMap
    public Attribute attr(AttributeKey attributeKey0) {
        DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute1;
        ObjectUtil.checkNotNull(attributeKey0, "key");
        DefaultAttribute defaultAttributeMap$DefaultAttribute0 = null;
        while(true) {
            DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute = this.attributes;
            int v = DefaultAttributeMap.searchAttributeByKey(arr_defaultAttributeMap$DefaultAttribute, attributeKey0);
            if(v >= 0) {
                Attribute attribute0 = arr_defaultAttributeMap$DefaultAttribute[v];
                if(!DefaultAttribute.access$100(((DefaultAttribute)attribute0))) {
                    return attribute0;
                }
                if(defaultAttributeMap$DefaultAttribute0 == null) {
                    defaultAttributeMap$DefaultAttribute0 = new DefaultAttribute(this, attributeKey0);
                }
                arr_defaultAttributeMap$DefaultAttribute1 = (DefaultAttribute[])Arrays.copyOf(arr_defaultAttributeMap$DefaultAttribute, arr_defaultAttributeMap$DefaultAttribute.length);
                arr_defaultAttributeMap$DefaultAttribute1[v] = defaultAttributeMap$DefaultAttribute0;
            }
            else {
                if(defaultAttributeMap$DefaultAttribute0 == null) {
                    defaultAttributeMap$DefaultAttribute0 = new DefaultAttribute(this, attributeKey0);
                }
                arr_defaultAttributeMap$DefaultAttribute1 = new DefaultAttribute[arr_defaultAttributeMap$DefaultAttribute.length + 1];
                DefaultAttributeMap.orderedCopyOnInsert(arr_defaultAttributeMap$DefaultAttribute, arr_defaultAttributeMap$DefaultAttribute.length, arr_defaultAttributeMap$DefaultAttribute1, defaultAttributeMap$DefaultAttribute0);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultAttributeMap.ATTRIBUTES_UPDATER;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, arr_defaultAttributeMap$DefaultAttribute, arr_defaultAttributeMap$DefaultAttribute1)) {
                    return defaultAttributeMap$DefaultAttribute0;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == arr_defaultAttributeMap$DefaultAttribute);
        }
    }

    @Override  // io.netty.util.AttributeMap
    public boolean hasAttr(AttributeKey attributeKey0) {
        ObjectUtil.checkNotNull(attributeKey0, "key");
        return DefaultAttributeMap.searchAttributeByKey(this.attributes, attributeKey0) >= 0;
    }

    private static void orderedCopyOnInsert(DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute, int v, DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute1, DefaultAttribute defaultAttributeMap$DefaultAttribute0) {
        int v1 = DefaultAttribute.access$000(defaultAttributeMap$DefaultAttribute0).id();
        int v2;
        for(v2 = v - 1; v2 >= 0 && DefaultAttribute.access$000(arr_defaultAttributeMap$DefaultAttribute[v2]).id() >= v1; --v2) {
            arr_defaultAttributeMap$DefaultAttribute1[v2 + 1] = arr_defaultAttributeMap$DefaultAttribute[v2];
        }
        arr_defaultAttributeMap$DefaultAttribute1[v2 + 1] = defaultAttributeMap$DefaultAttribute0;
        if(v2 + 1 > 0) {
            System.arraycopy(arr_defaultAttributeMap$DefaultAttribute, 0, arr_defaultAttributeMap$DefaultAttribute1, 0, v2 + 1);
        }
    }

    private void removeAttributeIfMatch(AttributeKey attributeKey0, DefaultAttribute defaultAttributeMap$DefaultAttribute0) {
        while(true) {
            DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute = this.attributes;
            int v = DefaultAttributeMap.searchAttributeByKey(arr_defaultAttributeMap$DefaultAttribute, attributeKey0);
            if(v < 0 || arr_defaultAttributeMap$DefaultAttribute[v] != defaultAttributeMap$DefaultAttribute0) {
                return;
            }
            int v1 = arr_defaultAttributeMap$DefaultAttribute.length - 1;
            DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute1 = v1 == 0 ? DefaultAttributeMap.EMPTY_ATTRIBUTES : new DefaultAttribute[v1];
            System.arraycopy(arr_defaultAttributeMap$DefaultAttribute, 0, arr_defaultAttributeMap$DefaultAttribute1, 0, v);
            int v2 = arr_defaultAttributeMap$DefaultAttribute.length - v - 1;
            if(v2 > 0) {
                System.arraycopy(arr_defaultAttributeMap$DefaultAttribute, v + 1, arr_defaultAttributeMap$DefaultAttribute1, v, v2);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultAttributeMap.ATTRIBUTES_UPDATER;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, arr_defaultAttributeMap$DefaultAttribute, arr_defaultAttributeMap$DefaultAttribute1)) {
                    return;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == arr_defaultAttributeMap$DefaultAttribute);
        }
    }

    private static int searchAttributeByKey(DefaultAttribute[] arr_defaultAttributeMap$DefaultAttribute, AttributeKey attributeKey0) {
        int v = arr_defaultAttributeMap$DefaultAttribute.length - 1;
        int v1 = 0;
        while(v1 <= v) {
            int v2 = v1 + v >>> 1;
            AttributeKey attributeKey1 = DefaultAttribute.access$000(arr_defaultAttributeMap$DefaultAttribute[v2]);
            if(attributeKey1 == attributeKey0) {
                return v2;
            }
            if(attributeKey1.id() < attributeKey0.id()) {
                v1 = v2 + 1;
            }
            else {
                v = v2 - 1;
            }
        }
        return -(v1 + 1);
    }
}

