package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionMapper {
    public interface Collection {
        Object get(Object arg1);

        Iterator keyIterator();

        void set(Object arg1, Object arg2, OnErrorListener arg3);
    }

    public interface OnErrorListener {
        void onError(FacebookException arg1);
    }

    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object arg1);
    }

    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    public interface ValueMapper {
        void mapValue(Object arg1, OnMapValueCompleteListener arg2);
    }

    public static void iterate(Collection collectionMapper$Collection0, ValueMapper collectionMapper$ValueMapper0, OnMapperCompleteListener collectionMapper$OnMapperCompleteListener0) {
        Mutable mutable0 = new Mutable(Boolean.FALSE);
        Mutable mutable1 = new Mutable(1);
        com.facebook.internal.CollectionMapper.1 collectionMapper$10 = new OnMapperCompleteListener() {
            @Override  // com.facebook.internal.CollectionMapper$OnMapperCompleteListener
            public void onComplete() {
                if(!((Boolean)mutable0.value).booleanValue()) {
                    int v = (int)(((Integer)mutable1.value));
                    mutable1.value = (int)(v - 1);
                    if(v - 1 == 0) {
                        collectionMapper$OnMapperCompleteListener0.onComplete();
                    }
                }
            }

            @Override  // com.facebook.internal.CollectionMapper$OnErrorListener
            public void onError(FacebookException facebookException0) {
                if(((Boolean)mutable0.value).booleanValue()) {
                    return;
                }
                mutable0.value = Boolean.TRUE;
                collectionMapper$OnMapperCompleteListener0.onError(facebookException0);
            }
        };
        Iterator iterator0 = collectionMapper$Collection0.keyIterator();
        LinkedList linkedList0 = new LinkedList();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            linkedList0.add(object0);
        }
        for(Object object1: linkedList0) {
            Object object2 = collectionMapper$Collection0.get(object1);
            com.facebook.internal.CollectionMapper.2 collectionMapper$20 = new OnMapValueCompleteListener() {
                @Override  // com.facebook.internal.CollectionMapper$OnMapValueCompleteListener
                public void onComplete(Object object0) {
                    collectionMapper$Collection0.set(object1, object0, collectionMapper$10);
                    collectionMapper$10.onComplete();
                }

                @Override  // com.facebook.internal.CollectionMapper$OnErrorListener
                public void onError(FacebookException facebookException0) {
                    collectionMapper$10.onError(facebookException0);
                }
            };
            Object object3 = mutable1.value;
            Integer integer0 = (Integer)object3;
            mutable1.value = (int)(((int)(((Integer)object3))) + 1);
            collectionMapper$ValueMapper0.mapValue(object2, collectionMapper$20);
        }
        collectionMapper$10.onComplete();
    }
}

