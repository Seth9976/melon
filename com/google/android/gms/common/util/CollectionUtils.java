package com.google.android.gms.common.util;

import androidx.collection.f;
import androidx.collection.g;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
    @KeepForSdk
    public static boolean isEmpty(Collection collection0) {
        return collection0 == null || collection0.isEmpty();
    }

    @KeepForSdk
    @Deprecated
    public static List listOf() {
        return Collections.EMPTY_LIST;
    }

    @KeepForSdk
    @Deprecated
    public static List listOf(Object object0) {
        return Collections.singletonList(object0);
    }

    @KeepForSdk
    @Deprecated
    public static List listOf(Object[] arr_object) {
        switch(arr_object.length) {
            case 0: {
                return Collections.EMPTY_LIST;
            }
            case 1: {
                return Collections.singletonList(arr_object[0]);
            }
            default: {
                return Collections.unmodifiableList(Arrays.asList(arr_object));
            }
        }
    }

    @KeepForSdk
    public static Map mapOf(Object object0, Object object1, Object object2, Object object3, Object object4, Object object5) {
        Map map0 = CollectionUtils.zzb(3, false);
        map0.put(object0, object1);
        map0.put(object2, object3);
        map0.put(object4, object5);
        return Collections.unmodifiableMap(map0);
    }

    @KeepForSdk
    public static Map mapOf(Object object0, Object object1, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11) {
        Map map0 = CollectionUtils.zzb(6, false);
        map0.put(object0, object1);
        map0.put(object2, object3);
        map0.put(object4, object5);
        map0.put(object6, object7);
        map0.put(object8, object9);
        map0.put(object10, object11);
        return Collections.unmodifiableMap(map0);
    }

    @KeepForSdk
    public static Map mapOfKeyValueArrays(Object[] arr_object, Object[] arr_object1) {
        if(arr_object.length == arr_object1.length) {
            switch(arr_object.length) {
                case 0: {
                    return Collections.EMPTY_MAP;
                }
                case 1: {
                    return Collections.singletonMap(arr_object[0], arr_object1[0]);
                }
                default: {
                    Map map0 = CollectionUtils.zzb(arr_object.length, false);
                    for(int v = 0; v < arr_object.length; ++v) {
                        map0.put(arr_object[v], arr_object1[v]);
                    }
                    return Collections.unmodifiableMap(map0);
                }
            }
        }
        throw new IllegalArgumentException("Key and values array lengths not equal: " + arr_object.length + " != " + arr_object1.length);
    }

    @KeepForSdk
    public static Set mutableSetOfWithSize(int v) {
        return v == 0 ? new g(0) : CollectionUtils.zza(v, true);
    }

    @KeepForSdk
    @Deprecated
    public static Set setOf(Object object0, Object object1, Object object2) {
        Set set0 = CollectionUtils.zza(3, false);
        set0.add(object0);
        set0.add(object1);
        set0.add(object2);
        return Collections.unmodifiableSet(set0);
    }

    @KeepForSdk
    @Deprecated
    public static Set setOf(Object[] arr_object) {
        switch(arr_object.length) {
            case 0: {
                return Collections.EMPTY_SET;
            }
            case 1: {
                return Collections.singleton(arr_object[0]);
            }
            case 2: {
                Object object0 = arr_object[0];
                Object object1 = arr_object[1];
                Set set1 = CollectionUtils.zza(2, false);
                set1.add(object0);
                set1.add(object1);
                return Collections.unmodifiableSet(set1);
            }
            case 3: {
                return CollectionUtils.setOf(arr_object[0], arr_object[1], arr_object[2]);
            }
            case 4: {
                Object object2 = arr_object[0];
                Object object3 = arr_object[1];
                Object object4 = arr_object[2];
                Object object5 = arr_object[3];
                Set set2 = CollectionUtils.zza(4, false);
                set2.add(object2);
                set2.add(object3);
                set2.add(object4);
                set2.add(object5);
                return Collections.unmodifiableSet(set2);
            }
            default: {
                Set set0 = CollectionUtils.zza(arr_object.length, false);
                Collections.addAll(set0, arr_object);
                return Collections.unmodifiableSet(set0);
            }
        }
    }

    private static Set zza(int v, boolean z) {
        if(v <= (z ? 0x80 : 0x100)) {
            return new g(v);
        }
        return z ? new HashSet(v, 0.75f) : new HashSet(v, 1.0f);
    }

    private static Map zzb(int v, boolean z) {
        return v <= 0x100 ? new f(v) : new HashMap(v, 1.0f);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }
}

