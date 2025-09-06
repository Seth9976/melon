package com.airbnb.lottie;

import V4.e;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.iloen.melon.utils.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.JSONObject;

public class LottieCompositionFactory {
    private static final byte[] GZIP_MAGIC;
    private static final byte[] ZIP_MAGIC;
    private static final Map taskCache;
    private static final Set taskIdleListeners;

    static {
        LottieCompositionFactory.taskCache = new HashMap();
        LottieCompositionFactory.taskIdleListeners = new HashSet();
        LottieCompositionFactory.ZIP_MAGIC = new byte[]{80, 75, 3, 4};
        LottieCompositionFactory.GZIP_MAGIC = new byte[]{0x1F, (byte)0x8B, 8};
    }

    private static LottieTask cache(String s, Callable callable0, Runnable runnable0) {
        LottieTask lottieTask0 = null;
        LottieComposition lottieComposition0 = s == null ? null : LottieCompositionCache.getInstance().get(s);
        if(lottieComposition0 != null) {
            lottieTask0 = new LottieTask(lottieComposition0);
        }
        if(s != null) {
            Map map0 = LottieCompositionFactory.taskCache;
            if(map0.containsKey(s)) {
                lottieTask0 = (LottieTask)map0.get(s);
            }
        }
        if(lottieTask0 != null) {
            if(runnable0 != null) {
                runnable0.run();
            }
            return lottieTask0;
        }
        LottieTask lottieTask1 = new LottieTask(callable0);
        if(s != null) {
            AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
            lottieTask1.addListener(new i(s, atomicBoolean0, 0));
            lottieTask1.addFailureListener(new i(s, atomicBoolean0, 1));
            if(!atomicBoolean0.get()) {
                LottieCompositionFactory.taskCache.put(s, lottieTask1);
                if(LottieCompositionFactory.taskCache.size() == 1) {
                    LottieCompositionFactory.notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask1;
    }

    public static void clearCache(Context context0) {
        LottieCompositionFactory.clearCache(context0, true);
    }

    public static void clearCache(Context context0, boolean z) {
        LottieCompositionFactory.taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        if(z) {
            NetworkCache networkCache0 = L.networkCache(context0);
            if(networkCache0 != null) {
                networkCache0.clear();
            }
        }
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition0, String s) {
        for(Object object0: lottieComposition0.getImages().values()) {
            LottieImageAsset lottieImageAsset0 = (LottieImageAsset)object0;
            if(lottieImageAsset0.getFileName().equals(s)) {
                return lottieImageAsset0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public static LottieTask fromAsset(Context context0, String s) {
        return LottieCompositionFactory.fromAsset(context0, s, "asset_" + s);
    }

    public static LottieTask fromAsset(Context context0, String s, String s1) {
        return LottieCompositionFactory.cache(s1, new f(context0.getApplicationContext(), s, s1, 0), null);
    }

    public static LottieResult fromAssetSync(Context context0, String s) {
        return LottieCompositionFactory.fromAssetSync(context0, s, "asset_" + s);
    }

    public static LottieResult fromAssetSync(Context context0, String s, String s1) {
        LottieComposition lottieComposition0 = s1 == null ? null : LottieCompositionCache.getInstance().get(s1);
        if(lottieComposition0 != null) {
            return new LottieResult(lottieComposition0);
        }
        try {
            return LottieCompositionFactory.fromInputStreamSync(context0, context0.getAssets().open(s), s1);
        }
        catch(IOException iOException0) {
            return new LottieResult(iOException0);
        }
    }

    public static LottieTask fromInputStream(Context context0, InputStream inputStream0, String s) {
        return context0 == null ? LottieCompositionFactory.cache(s, new e(null, inputStream0, s, 2), null) : LottieCompositionFactory.cache(s, new e(context0.getApplicationContext(), inputStream0, s, 2), null);
    }

    public static LottieResult fromInputStreamSync(Context context0, InputStream inputStream0, String s) {
        LottieComposition lottieComposition0 = s == null ? null : LottieCompositionCache.getInstance().get(s);
        if(lottieComposition0 != null) {
            return new LottieResult(lottieComposition0);
        }
        try {
            BufferedSource bufferedSource0 = Okio.buffer(Okio.source(inputStream0));
            if(LottieCompositionFactory.isZipCompressed(bufferedSource0).booleanValue()) {
                return LottieCompositionFactory.fromZipStreamSync(context0, new ZipInputStream(bufferedSource0.inputStream()), s);
            }
            return LottieCompositionFactory.isGzipCompressed(bufferedSource0).booleanValue() ? LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(bufferedSource0.inputStream()), s) : LottieCompositionFactory.fromJsonReaderSync(JsonReader.of(bufferedSource0), s);
        }
        catch(IOException iOException0) {
            return new LottieResult(iOException0);
        }
    }

    @Deprecated
    public static LottieTask fromJson(JSONObject jSONObject0, String s) {
        return LottieCompositionFactory.cache(s, new b(5, jSONObject0, s), null);
    }

    public static LottieTask fromJsonInputStream(InputStream inputStream0, String s) {
        return LottieCompositionFactory.cache(s, new b(4, inputStream0, s), new com.airbnb.lottie.e(inputStream0, 2));
    }

    public static LottieTask fromJsonInputStream(InputStream inputStream0, String s, boolean z) {
        return LottieCompositionFactory.cache(s, new k(inputStream0, s, z), new I9.b(z, inputStream0));
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream0, String s) {
        return LottieCompositionFactory.fromJsonInputStreamSync(inputStream0, s, true);
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream0, String s, boolean z) {
        return LottieCompositionFactory.fromJsonSourceSync(Okio.source(inputStream0), s, z);
    }

    public static LottieTask fromJsonReader(JsonReader jsonReader0, String s) {
        return LottieCompositionFactory.cache(s, new b(3, jsonReader0, s), new com.airbnb.lottie.e(jsonReader0, 0));
    }

    public static LottieResult fromJsonReaderSync(JsonReader jsonReader0, String s) {
        return LottieCompositionFactory.fromJsonReaderSync(jsonReader0, s, true);
    }

    public static LottieResult fromJsonReaderSync(JsonReader jsonReader0, String s, boolean z) {
        return LottieCompositionFactory.fromJsonReaderSyncInternal(jsonReader0, s, z);
    }

    private static LottieResult fromJsonReaderSyncInternal(JsonReader jsonReader0, String s, boolean z) {
        LottieResult lottieResult2;
        LottieResult lottieResult1;
        LottieResult lottieResult0;
        LottieComposition lottieComposition0;
        if(s == null) {
            lottieComposition0 = null;
        }
        else {
            try {
                lottieComposition0 = LottieCompositionCache.getInstance().get(s);
            label_4:
                if(lottieComposition0 == null) {
                    LottieComposition lottieComposition1 = LottieCompositionMoshiParser.parse(jsonReader0);
                    if(s != null) {
                        LottieCompositionCache.getInstance().put(s, lottieComposition1);
                    }
                    lottieResult0 = new LottieResult(lottieComposition1);
                    if(z) {
                        goto label_10;
                    }
                    return lottieResult0;
                }
                lottieResult1 = new LottieResult(lottieComposition0);
                goto label_23;
            }
            catch(Exception exception0) {
                goto label_15;
            }
            catch(Throwable throwable0) {
                goto label_20;
            }
        }
        goto label_4;
    label_10:
        Utils.closeQuietly(jsonReader0);
        return lottieResult0;
        try {
            try {
                lottieResult1 = new LottieResult(lottieComposition0);
                goto label_23;
            }
            catch(Exception exception0) {
            }
        label_15:
            lottieResult2 = new LottieResult(exception0);
            if(z) {
                goto label_17;
            }
            return lottieResult2;
        }
        catch(Throwable throwable0) {
            goto label_20;
        }
    label_17:
        Utils.closeQuietly(jsonReader0);
        return lottieResult2;
    label_20:
        if(z) {
            Utils.closeQuietly(jsonReader0);
        }
        throw throwable0;
    label_23:
        if(z) {
            Utils.closeQuietly(jsonReader0);
        }
        return lottieResult1;
    }

    public static LottieTask fromJsonSource(Source source0, String s) {
        return LottieCompositionFactory.cache(s, new b(1, source0, s), new com.airbnb.lottie.e(source0, 1));
    }

    public static LottieResult fromJsonSourceSync(Source source0, String s) {
        return LottieCompositionFactory.fromJsonSourceSync(source0, s, true);
    }

    public static LottieResult fromJsonSourceSync(Source source0, String s, boolean z) {
        return LottieCompositionFactory.fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(source0)), s, z);
    }

    public static LottieTask fromJsonString(String s, String s1) {
        return LottieCompositionFactory.cache(s1, new b(s, s1), null);
    }

    public static LottieResult fromJsonStringSync(String s, String s1) {
        return LottieCompositionFactory.fromJsonSourceSync(Okio.source(new ByteArrayInputStream(s.getBytes())), s1);
    }

    @Deprecated
    public static LottieResult fromJsonSync(JSONObject jSONObject0, String s) {
        return LottieCompositionFactory.fromJsonStringSync(jSONObject0.toString(), s);
    }

    public static LottieTask fromRawRes(Context context0, int v) {
        return LottieCompositionFactory.fromRawRes(context0, v, LottieCompositionFactory.rawResCacheKey(context0, v));
    }

    public static LottieTask fromRawRes(Context context0, int v, String s) {
        return LottieCompositionFactory.cache(s, new j(new WeakReference(context0), context0.getApplicationContext(), v, s), null);
    }

    public static LottieResult fromRawResSync(Context context0, int v) {
        return LottieCompositionFactory.fromRawResSync(context0, v, LottieCompositionFactory.rawResCacheKey(context0, v));
    }

    public static LottieResult fromRawResSync(Context context0, int v, String s) {
        LottieComposition lottieComposition0 = s == null ? null : LottieCompositionCache.getInstance().get(s);
        if(lottieComposition0 != null) {
            return new LottieResult(lottieComposition0);
        }
        try {
            BufferedSource bufferedSource0 = Okio.buffer(Okio.source(context0.getResources().openRawResource(v)));
            if(LottieCompositionFactory.isZipCompressed(bufferedSource0).booleanValue()) {
                return LottieCompositionFactory.fromZipStreamSync(context0, new ZipInputStream(bufferedSource0.inputStream()), s);
            }
            if(!LottieCompositionFactory.isGzipCompressed(bufferedSource0).booleanValue()) {
                return LottieCompositionFactory.fromJsonReaderSync(JsonReader.of(bufferedSource0), s);
            }
            try {
                return LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(bufferedSource0.inputStream()), s);
            }
            catch(IOException iOException0) {
                return new LottieResult(iOException0);
            }
        }
        catch(Resources.NotFoundException resources$NotFoundException0) {
            return new LottieResult(resources$NotFoundException0);
        }
    }

    public static LottieTask fromUrl(Context context0, String s) {
        return LottieCompositionFactory.fromUrl(context0, s, "url_" + s);
    }

    public static LottieTask fromUrl(Context context0, String s, String s1) {
        return LottieCompositionFactory.cache(s1, new f(context0, s, s1, 1), null);
    }

    public static LottieResult fromUrlSync(Context context0, String s) {
        return LottieCompositionFactory.fromUrlSync(context0, s, s);
    }

    public static LottieResult fromUrlSync(Context context0, String s, String s1) {
        LottieComposition lottieComposition0 = s1 == null ? null : LottieCompositionCache.getInstance().get(s1);
        if(lottieComposition0 != null) {
            return new LottieResult(lottieComposition0);
        }
        LottieResult lottieResult0 = L.networkFetcher(context0).fetchSync(context0, s, s1);
        if(s1 != null && lottieResult0.getValue() != null) {
            LottieCompositionCache.getInstance().put(s1, ((LottieComposition)lottieResult0.getValue()));
        }
        return lottieResult0;
    }

    public static LottieTask fromZipStream(Context context0, ZipInputStream zipInputStream0, String s) {
        return LottieCompositionFactory.cache(s, new g(context0, zipInputStream0, s, 0), new h(zipInputStream0, 0));
    }

    public static LottieTask fromZipStream(Context context0, ZipInputStream zipInputStream0, String s, boolean z) {
        g g0 = new g(context0, zipInputStream0, s, 1);
        return z ? LottieCompositionFactory.cache(s, g0, new h(zipInputStream0, 1)) : LottieCompositionFactory.cache(s, g0, null);
    }

    public static LottieTask fromZipStream(ZipInputStream zipInputStream0, String s) {
        return LottieCompositionFactory.fromZipStream(null, zipInputStream0, s);
    }

    public static LottieTask fromZipStream(ZipInputStream zipInputStream0, String s, boolean z) {
        return LottieCompositionFactory.fromZipStream(null, zipInputStream0, s, z);
    }

    public static LottieResult fromZipStreamSync(Context context0, ZipInputStream zipInputStream0, String s) {
        return LottieCompositionFactory.fromZipStreamSync(context0, zipInputStream0, s, true);
    }

    public static LottieResult fromZipStreamSync(Context context0, ZipInputStream zipInputStream0, String s, boolean z) {
        LottieResult lottieResult0;
        try {
            lottieResult0 = LottieCompositionFactory.fromZipStreamSyncInternal(context0, zipInputStream0, s);
        }
        catch(Throwable throwable0) {
            if(z) {
                Utils.closeQuietly(zipInputStream0);
            }
            throw throwable0;
        }
        if(z) {
            Utils.closeQuietly(zipInputStream0);
        }
        return lottieResult0;
    }

    public static LottieResult fromZipStreamSync(ZipInputStream zipInputStream0, String s) {
        return LottieCompositionFactory.fromZipStreamSync(zipInputStream0, s, true);
    }

    public static LottieResult fromZipStreamSync(ZipInputStream zipInputStream0, String s, boolean z) {
        return LottieCompositionFactory.fromZipStreamSync(null, zipInputStream0, s, z);
    }

    private static LottieResult fromZipStreamSyncInternal(Context context0, ZipInputStream zipInputStream0, String s) {
        byte[] arr_b1;
        LottieComposition lottieComposition1;
        LottieComposition lottieComposition0;
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        if(s == null) {
            lottieComposition0 = null;
        }
        else {
            try {
                lottieComposition0 = LottieCompositionCache.getInstance().get(s);
            label_6:
                if(lottieComposition0 != null) {
                    return new LottieResult(lottieComposition0);
                }
                ZipEntry zipEntry0 = zipInputStream0.getNextEntry();
                lottieComposition1 = null;
                while(true) {
                    if(zipEntry0 == null) {
                        goto label_65;
                    }
                    String s1 = zipEntry0.getName();
                    if(s1.contains("__MACOSX")) {
                        zipInputStream0.closeEntry();
                    }
                    else if(zipEntry0.getName().equalsIgnoreCase("manifest.json")) {
                        zipInputStream0.closeEntry();
                    }
                    else if(zipEntry0.getName().contains(".json")) {
                        lottieComposition1 = (LottieComposition)LottieCompositionFactory.fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream0))), null, false).getValue();
                    }
                    else if(s1.contains(".png") || (s1.contains(".webp") || s1.contains(".jpg") || s1.contains(".jpeg"))) {
                        String[] arr_s1 = s1.split("/");
                        hashMap0.put(arr_s1[arr_s1.length - 1], BitmapFactory.decodeStream(zipInputStream0));
                    }
                    else if(s1.contains(".ttf") || s1.contains(".otf")) {
                        String[] arr_s = s1.split("/");
                        String s2 = arr_s[arr_s.length - 1];
                        String s3 = s2.split("\\.")[0];
                        if(context0 == null) {
                            return new LottieResult(new IllegalStateException("Unable to extract font " + s3 + " please pass a non-null Context parameter"));
                        }
                        File file0 = new File(context0.getCacheDir(), s2);
                        try(FileOutputStream fileOutputStream0 = new FileOutputStream(file0); FileOutputStream fileOutputStream1 = new FileOutputStream(file0)) {
                            byte[] arr_b = new byte[0x1000];
                            int v;
                            while((v = zipInputStream0.read(arr_b)) != -1) {
                                fileOutputStream1.write(arr_b, 0, v);
                            }
                            fileOutputStream1.flush();
                        }
                        catch(Throwable throwable0) {
                            Logger.warning(("Unable to save font " + s3 + " to the temporary file: " + s2 + ". "), throwable0);
                        }
                        Typeface typeface0 = Typeface.createFromFile(file0);
                        if(!file0.delete()) {
                            Logger.warning(("Failed to delete temp font file " + file0.getAbsolutePath() + "."));
                        }
                        hashMap1.put(s3, typeface0);
                    }
                    else {
                        zipInputStream0.closeEntry();
                    }
                    zipEntry0 = zipInputStream0.getNextEntry();
                }
            }
            catch(IOException iOException0) {
                return new LottieResult(iOException0);
            }
        }
        goto label_6;
    label_65:
        if(lottieComposition1 == null) {
            return new LottieResult(new IllegalArgumentException("Unable to parse composition"));
        }
        for(Object object0: hashMap0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            LottieImageAsset lottieImageAsset0 = LottieCompositionFactory.findImageAssetForFileName(lottieComposition1, ((String)map$Entry0.getKey()));
            if(lottieImageAsset0 != null) {
                lottieImageAsset0.setBitmap(Utils.resizeBitmapIfNeeded(((Bitmap)map$Entry0.getValue()), lottieImageAsset0.getWidth(), lottieImageAsset0.getHeight()));
            }
        }
        for(Object object1: hashMap1.entrySet()) {
            Map.Entry map$Entry1 = (Map.Entry)object1;
            boolean z = false;
            for(Object object2: lottieComposition1.getFonts().values()) {
                Font font0 = (Font)object2;
                if(font0.getFamily().equals(map$Entry1.getKey())) {
                    font0.setTypeface(((Typeface)map$Entry1.getValue()));
                    z = true;
                }
            }
            if(!z) {
                Logger.warning(("Parsed font for " + ((String)map$Entry1.getKey()) + " however it was not found in the animation."));
            }
        }
        if(hashMap0.isEmpty()) {
            for(Object object3: lottieComposition1.getImages().entrySet()) {
                LottieImageAsset lottieImageAsset1 = (LottieImageAsset)((Map.Entry)object3).getValue();
                if(lottieImageAsset1 == null) {
                    return null;
                }
                String s4 = lottieImageAsset1.getFileName();
                BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                bitmapFactory$Options0.inScaled = true;
                bitmapFactory$Options0.inDensity = 0xA0;
                if(s4.startsWith("data:") && s4.indexOf("base64,") > 0) {
                    try {
                        arr_b1 = Base64.decode(s4.substring(s4.indexOf(44) + 1), 0);
                    }
                    catch(IllegalArgumentException illegalArgumentException0) {
                        Logger.warning("data URL did not have correct base64 format.", illegalArgumentException0);
                        return null;
                    }
                    Bitmap bitmap0 = BitmapFactory.decodeByteArray(arr_b1, 0, arr_b1.length, bitmapFactory$Options0);
                    if(bitmap0 != null) {
                        lottieImageAsset1.setBitmap(Utils.resizeBitmapIfNeeded(bitmap0, lottieImageAsset1.getWidth(), lottieImageAsset1.getHeight()));
                    }
                }
            }
        }
        if(s != null) {
            LottieCompositionCache.getInstance().put(s, lottieComposition1);
        }
        return new LottieResult(lottieComposition1);
    }

    private static Boolean isGzipCompressed(BufferedSource bufferedSource0) {
        return LottieCompositionFactory.matchesMagicBytes(bufferedSource0, LottieCompositionFactory.GZIP_MAGIC);
    }

    private static boolean isNightMode(Context context0) {
        return (context0.getResources().getConfiguration().uiMode & 0x30) == 0x20;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource0) {
        return LottieCompositionFactory.matchesMagicBytes(bufferedSource0, LottieCompositionFactory.ZIP_MAGIC);
    }

    private static void lambda$cache$18(String s, AtomicBoolean atomicBoolean0, LottieComposition lottieComposition0) {
        LottieCompositionFactory.taskCache.remove(s);
        atomicBoolean0.set(true);
        if(LottieCompositionFactory.taskCache.size() == 0) {
            LottieCompositionFactory.notifyTaskCacheIdleListeners(true);
        }
    }

    private static void lambda$cache$19(String s, AtomicBoolean atomicBoolean0, Throwable throwable0) {
        LottieCompositionFactory.taskCache.remove(s);
        atomicBoolean0.set(true);
        if(LottieCompositionFactory.taskCache.size() == 0) {
            LottieCompositionFactory.notifyTaskCacheIdleListeners(true);
        }
    }

    private static void lambda$fromJsonInputStream$7(boolean z, InputStream inputStream0) {
        if(z) {
            Utils.closeQuietly(inputStream0);
        }
    }

    private static LottieResult lambda$fromRawRes$3(WeakReference weakReference0, Context context0, int v, String s) {
        Context context1 = (Context)weakReference0.get();
        if(context1 != null) {
            context0 = context1;
        }
        return LottieCompositionFactory.fromRawResSync(context0, v, s);
    }

    private static LottieResult lambda$fromUrl$0(Context context0, String s, String s1) {
        LottieResult lottieResult0 = L.networkFetcher(context0).fetchSync(context0, s, s1);
        if(s1 != null && lottieResult0.getValue() != null) {
            LottieCompositionCache.getInstance().put(s1, ((LottieComposition)lottieResult0.getValue()));
        }
        return lottieResult0;
    }

    private static Boolean matchesMagicBytes(BufferedSource bufferedSource0, byte[] arr_b) {
        try {
            BufferedSource bufferedSource1 = bufferedSource0.peek();
            for(int v = 0; v < arr_b.length; ++v) {
                int v1 = arr_b[v];
                if(bufferedSource1.readByte() != v1) {
                    return false;
                }
            }
            bufferedSource1.close();
            return true;
        }
        catch(NoSuchMethodError unused_ex) {
            return false;
        }
        catch(Exception exception0) {
            Logger.error("Failed to check zip file header", exception0);
            return false;
        }
    }

    private static void notifyTaskCacheIdleListeners(boolean z) {
        ArrayList arrayList0 = new ArrayList(LottieCompositionFactory.taskIdleListeners);
        for(int v = 0; v < arrayList0.size(); ++v) {
            ((LottieTaskIdleListener)arrayList0.get(v)).onIdleChanged(z);
        }
    }

    private static String rawResCacheKey(Context context0, int v) {
        StringBuilder stringBuilder0 = new StringBuilder("rawRes");
        return LottieCompositionFactory.isNightMode(context0) ? a.k(v, "_night_", stringBuilder0) : a.k(v, "_day_", stringBuilder0);
    }

    public static void registerLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener0) {
        LottieCompositionFactory.taskIdleListeners.add(lottieTaskIdleListener0);
        lottieTaskIdleListener0.onIdleChanged(LottieCompositionFactory.taskCache.size() == 0);
    }

    public static void setMaxCacheSize(int v) {
        LottieCompositionCache.getInstance().resize(v);
    }

    public static LottieResult t(String s, JSONObject jSONObject0) {
        return LottieCompositionFactory.fromJsonSync(jSONObject0, s);
    }

    public static void unregisterLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener0) {
        LottieCompositionFactory.taskIdleListeners.remove(lottieTaskIdleListener0);
    }
}

