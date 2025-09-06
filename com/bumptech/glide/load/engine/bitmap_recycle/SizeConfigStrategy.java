package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import k8.Y;

public class SizeConfigStrategy implements LruPoolStrategy {
    static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        int size;

        public Key(KeyPool sizeConfigStrategy$KeyPool0) {
            this.pool = sizeConfigStrategy$KeyPool0;
        }

        public Key(KeyPool sizeConfigStrategy$KeyPool0, int v, Bitmap.Config bitmap$Config0) {
            this(sizeConfigStrategy$KeyPool0);
            this.init(v, bitmap$Config0);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return object0 instanceof Key && this.size == ((Key)object0).size && Util.bothNullOrEqual(this.config, ((Key)object0).config);
        }

        @Override
        public int hashCode() {
            int v = this.size * 0x1F;
            return this.config == null ? v : v + this.config.hashCode();
        }

        public void init(int v, Bitmap.Config bitmap$Config0) {
            this.size = v;
            this.config = bitmap$Config0;
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        @Override
        public String toString() {
            return "[" + this.size + "](" + this.config + ")";
        }
    }

    static class KeyPool extends BaseKeyPool {
        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Poolable create() {
            return this.create();
        }

        public Key create() {
            return new Key(this);
        }

        public Key get(int v, Bitmap.Config bitmap$Config0) {
            Key sizeConfigStrategy$Key0 = (Key)this.get();
            sizeConfigStrategy$Key0.init(v, bitmap$Config0);
            return sizeConfigStrategy$Key0;
        }
    }

    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS = null;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS = null;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS = null;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGBA_F16_IN_CONFIGS;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS;
    private final GroupedLinkedMap groupedMap;
    private final KeyPool keyPool;
    private final Map sortedSizes;

    static {
        Bitmap.Config[] arr_bitmap$Config = (Bitmap.Config[])Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        arr_bitmap$Config[arr_bitmap$Config.length - 1] = Bitmap.Config.RGBA_F16;
        SizeConfigStrategy.ARGB_8888_IN_CONFIGS = arr_bitmap$Config;
        SizeConfigStrategy.RGBA_F16_IN_CONFIGS = arr_bitmap$Config;
        SizeConfigStrategy.RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        SizeConfigStrategy.ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        SizeConfigStrategy.ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public SizeConfigStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new HashMap();
    }

    private void decrementBitmapOfSize(Integer integer0, Bitmap bitmap0) {
        NavigableMap navigableMap0 = this.getSizesForConfig(bitmap0.getConfig());
        Integer integer1 = (Integer)navigableMap0.get(integer0);
        if(integer1 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + integer0 + ", removed: " + this.logBitmap(bitmap0) + ", this: " + this);
        }
        if(((int)integer1) == 1) {
            navigableMap0.remove(integer0);
            return;
        }
        navigableMap0.put(integer0, ((int)(((int)integer1) - 1)));
    }

    private Key findBestKey(int v, Bitmap.Config bitmap$Config0) {
        Key sizeConfigStrategy$Key0 = this.keyPool.get(v, bitmap$Config0);
        Bitmap.Config[] arr_bitmap$Config = SizeConfigStrategy.getInConfigs(bitmap$Config0);
        for(int v1 = 0; v1 < arr_bitmap$Config.length; ++v1) {
            Bitmap.Config bitmap$Config1 = arr_bitmap$Config[v1];
            Integer integer0 = (Integer)this.getSizesForConfig(bitmap$Config1).ceilingKey(v);
            if(integer0 != null && ((int)integer0) <= v * 8) {
                if(((int)integer0) == v) {
                    if(bitmap$Config1 != null) {
                        if(!bitmap$Config1.equals(bitmap$Config0)) {
                            this.keyPool.offer(sizeConfigStrategy$Key0);
                            return this.keyPool.get(((int)integer0), bitmap$Config1);
                        }
                        break;
                    }
                    else if(bitmap$Config0 == null) {
                        break;
                    }
                }
                this.keyPool.offer(sizeConfigStrategy$Key0);
                return this.keyPool.get(((int)integer0), bitmap$Config1);
            }
        }
        return sizeConfigStrategy$Key0;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int v, int v1, Bitmap.Config bitmap$Config0) {
        Key sizeConfigStrategy$Key0 = this.findBestKey(Util.getBitmapByteSize(v, v1, bitmap$Config0), bitmap$Config0);
        Bitmap bitmap0 = (Bitmap)this.groupedMap.get(sizeConfigStrategy$Key0);
        if(bitmap0 != null) {
            this.decrementBitmapOfSize(sizeConfigStrategy$Key0.size, bitmap0);
            bitmap0.reconfigure(v, v1, bitmap$Config0);
        }
        return bitmap0;
    }

    public static String getBitmapString(int v, Bitmap.Config bitmap$Config0) [...] // Inlined contents

    private static Bitmap.Config[] getInConfigs(Bitmap.Config bitmap$Config0) {
        if(Bitmap.Config.RGBA_F16.equals(bitmap$Config0)) {
            return SizeConfigStrategy.RGBA_F16_IN_CONFIGS;
        }
        switch(com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[bitmap$Config0.ordinal()]) {
            case 1: {
                return SizeConfigStrategy.ARGB_8888_IN_CONFIGS;
            }
            case 2: {
                return SizeConfigStrategy.RGB_565_IN_CONFIGS;
            }
            case 3: {
                return SizeConfigStrategy.ARGB_4444_IN_CONFIGS;
            }
            case 4: {
                return SizeConfigStrategy.ALPHA_8_IN_CONFIGS;
            }
            default: {
                return new Bitmap.Config[]{bitmap$Config0};
            }
        }
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap0) {
        return Util.getBitmapByteSize(bitmap0);
    }

    private NavigableMap getSizesForConfig(Bitmap.Config bitmap$Config0) {
        NavigableMap navigableMap0 = (NavigableMap)this.sortedSizes.get(bitmap$Config0);
        if(navigableMap0 == null) {
            navigableMap0 = new TreeMap();
            this.sortedSizes.put(bitmap$Config0, navigableMap0);
        }
        return navigableMap0;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int v, int v1, Bitmap.Config bitmap$Config0) {
        return SizeConfigStrategy.getBitmapString(Util.getBitmapByteSize(v, v1, bitmap$Config0), bitmap$Config0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap0) {
        return SizeConfigStrategy.getBitmapString(Util.getBitmapByteSize(bitmap0), bitmap0.getConfig());
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap0) {
        int v = Util.getBitmapByteSize(bitmap0);
        Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
        Key sizeConfigStrategy$Key0 = this.keyPool.get(v, bitmap$Config0);
        this.groupedMap.put(sizeConfigStrategy$Key0, bitmap0);
        NavigableMap navigableMap0 = this.getSizesForConfig(bitmap0.getConfig());
        Integer integer0 = (Integer)navigableMap0.get(sizeConfigStrategy$Key0.size);
        navigableMap0.put(sizeConfigStrategy$Key0.size, ((int)(integer0 == null ? 1 : ((int)integer0) + 1)));
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap bitmap0 = (Bitmap)this.groupedMap.removeLast();
        if(bitmap0 != null) {
            this.decrementBitmapOfSize(Util.getBitmapByteSize(bitmap0), bitmap0);
        }
        return bitmap0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Y.p("SizeConfigStrategy{groupedMap=");
        stringBuilder0.append(this.groupedMap);
        stringBuilder0.append(", sortedSizes=(");
        for(Object object0: this.sortedSizes.entrySet()) {
            stringBuilder0.append(((Map.Entry)object0).getKey());
            stringBuilder0.append('[');
            stringBuilder0.append(((Map.Entry)object0).getValue());
            stringBuilder0.append("], ");
        }
        if(!this.sortedSizes.isEmpty()) {
            stringBuilder0.replace(stringBuilder0.length() - 2, stringBuilder0.length(), "");
        }
        stringBuilder0.append(")}");
        return stringBuilder0.toString();
    }

    class com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1 {
        static final int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] arr_v = new int[Bitmap.Config.values().length];
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config = arr_v;
            try {
                arr_v[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

