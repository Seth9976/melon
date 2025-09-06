package com.kakao.emoticon.cache.module;

import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.controller.EmoticonPreference;
import java.io.File;
import java.security.MessageDigest;
import java.util.HashMap;

public class EmoticonDiskCacheFactory implements Factory {
    private static final int DEFAULT_DISK_CACHE_SIZE = 0xA00000;
    private static final HashMap cacheMap;

    static {
        EmoticonDiskCacheFactory.cacheMap = new HashMap();
    }

    @Override  // com.kakao.emoticon.cache.module.DiskCache$Factory
    public DiskCache build(String s) {
        String s1 = new SafeKeyGenerator().getSafeKey(new a(s));
        File file0 = KakaoEmoticon.getApplication().getApplicationContext().getExternalCacheDir();
        if(file0 != null) {
            this.removeOldCacheDir(file0);
            File file1 = new File(file0.getAbsolutePath() + "/KakaoDI", s1);
            if(file1.mkdirs() || file1.exists() && file1.isDirectory()) {
                HashMap hashMap0 = EmoticonDiskCacheFactory.cacheMap;
                if(((DiskCache)hashMap0.get(s1)) == null) {
                    hashMap0.put(s1, new DiskLruCacheWrapper(file1, 0xA00000));
                }
                return (DiskCache)hashMap0.get(s1);
            }
        }
        return null;
    }

    private static void lambda$build$0(String s, MessageDigest messageDigest0) {
        messageDigest0.update(s.getBytes("UTF-8"));
    }

    private void removeOldCacheDir(File file0) {
        if(EmoticonPreference.getInstance().isNeedResetCacheDir()) {
            File file1 = new File(file0.getAbsolutePath() + "/KakaoEmoticon");
            if(!file1.exists()) {
                EmoticonPreference.getInstance().setNeedResetCacheDir(false);
            }
            else if(file1.delete()) {
                EmoticonPreference.getInstance().setNeedResetCacheDir(false);
            }
        }
    }
}

