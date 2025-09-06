package com.iloen.melon.utils;

import P1.d;
import Tf.a;
import Tf.o;
import Tf.v;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.FileProvider;
import androidx.loader.content.CursorLoader;
import c2.Y;
import com.iloen.melon.popup.H;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d3.g;
import e.k;
import ie.r;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jeb.synthetic.TWR;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0010\t\n\u0002\b\u0017\b\u00C7\u0002\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\t\u0010\u0006J\r\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\r\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\u00142\b\u0010\u0012\u001A\u0004\u0018\u00010\u00042\b\u0010\u0013\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0019\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\n\u00A2\u0006\u0004\b\u0019\u0010\u001AJ1\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\n\u00A2\u0006\u0004\b \u0010!J\u001F\u0010#\u001A\u00020\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\"\u001A\u00020\u001F\u00A2\u0006\u0004\b#\u0010$J!\u0010&\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010%\u001A\u00020\u001F\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010(\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b(\u0010\u0006J!\u0010+\u001A\u00020\u00142\b\u0010)\u001A\u0004\u0018\u00010\u000E2\u0006\u0010*\u001A\u00020\nH\u0007\u00A2\u0006\u0004\b+\u0010,J!\u0010.\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010-\u001A\u00020\u000EH\u0007\u00A2\u0006\u0004\b.\u0010/J\u0017\u00100\u001A\u00020\u00142\u0006\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b0\u00101J#\u00104\u001A\u00020\n2\b\u00102\u001A\u0004\u0018\u00010\u000E2\b\u00103\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b4\u00105J\u0011\u00106\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b8\u0010\u0006J3\u0010;\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0017\u001A\u00020\u000E2\b\u00109\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010:\u001A\u00020\nH\u0007\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010?\u001A\u00020>2\u0006\u0010=\u001A\u00020\u000EH\u0007\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010B\u001A\u00020\u001F2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010A\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001A\u00020\n2\u0006\u0010)\u001A\u00020\u000EH\u0007\u00A2\u0006\u0004\bD\u0010EJ!\u0010G\u001A\u00020\n2\b\u0010F\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001A\u00020\nH\u0007\u00A2\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001A\u00020\u000E2\b\u0010A\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\bI\u0010JR#\u0010P\u001A\u0004\u0018\u00010\u000E8FX\u0087\u0084\u0002\u00A2\u0006\u0012\n\u0004\bK\u0010L\u0012\u0004\bN\u0010O\u001A\u0004\bM\u00107R#\u0010T\u001A\u0004\u0018\u00010\u000E8FX\u0087\u0084\u0002\u00A2\u0006\u0012\n\u0004\bQ\u0010L\u0012\u0004\bS\u0010O\u001A\u0004\bR\u00107\u00A8\u0006U"}, d2 = {"Lcom/iloen/melon/utils/FileUtils;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "getImageCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "getCoilImageCacheDir", "getLegacyImageCacheDir", "getShareCacheDir", "", "isExternalStorageRemovable", "()Z", "getDiskCacheRootDir", "", "urlString", "makeSafeFileNameByMD5", "(Ljava/lang/String;)Ljava/lang/String;", "src", "dst", "Lie/H;", "copy", "(Ljava/io/File;Ljava/io/File;)V", "filename", "mkdirs", "createNewFile", "(Ljava/lang/String;Z)Ljava/io/File;", "Landroid/graphics/Bitmap;", "bitmap", "fileName", "usePrivateStorage", "Landroid/net/Uri;", "saveImageFile", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Z)Landroid/net/Uri;", "fileUri", "deleteFileFromUri", "(Landroid/content/Context;Landroid/net/Uri;)Z", "uri", "getImageFilePathForUri", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "getExoPlayerCacheDir", "path", "keepDir", "deleteSubFiles", "(Ljava/lang/String;Z)V", "uniqueName", "getDiskCacheDir", "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "exportUserDb", "(Landroid/content/Context;)V", "path1", "path2", "pathEquals", "(Ljava/lang/String;Ljava/lang/String;)Z", "getSecondaryExternalStorage", "()Ljava/lang/String;", "createImageFile", "str", "append", "writeOnFile", "(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;", "filePath", "", "getLastModifiedTime", "(Ljava/lang/String;)J", "file", "getFileUri", "(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;", "delete", "(Ljava/lang/String;)Z", "directory", "hideMediaDirectory", "(Ljava/io/File;Z)Z", "getSafetyPath", "(Ljava/io/File;)Ljava/lang/String;", "a", "Lie/j;", "getExternalAppDirPath", "getExternalAppDirPath$annotations", "()V", "externalAppDirPath", "b", "getExternalAppDirLogPath", "getExternalAppDirLogPath$annotations", "externalAppDirLogPath", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FileUtils {
    public static final int $stable;
    @NotNull
    public static final FileUtils INSTANCE;
    public static final r a;
    public static final r b;

    static {
        FileUtils.INSTANCE = new FileUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
        FileUtils.a = g.Q(new H(3));
        FileUtils.b = g.Q(new H(4));
        FileUtils.$stable = 8;
    }

    public final void copy(@Nullable File file0, @Nullable File file1) {
        FileInputStream fileInputStream0 = new FileInputStream(file0);
        FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
        byte[] arr_b = new byte[0x400];
        int v;
        while((v = fileInputStream0.read(arr_b)) > 0) {
            fileOutputStream0.write(arr_b, 0, v);
        }
        fileInputStream0.close();
        fileOutputStream0.close();
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final File createImageFile(@NotNull Context context0) {
        q.g(context0, "context");
        return FileUtils.getDiskCacheDir(context0, "JPEG_20250906_113327.jpg");
    }

    @Nullable
    public final File createNewFile(@NotNull String s, boolean z) {
        q.g(s, "filename");
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.w("FileUtils", "createNewFile() - invalid filename");
            return null;
        }
        File file0 = new File(s);
        if(z) {
            File file1 = file0.getParentFile();
            if(file1 != null && !file1.exists()) {
                file1.mkdirs();
            }
        }
        try {
            file0.createNewFile();
        }
        catch(IOException unused_ex) {
            LogU.Companion.e("FileUtils", "createNewFile() - invalid filename");
        }
        return file0;
    }

    public static final boolean delete(@NotNull String s) {
        q.g(s, "path");
        if(TextUtils.isEmpty(s)) {
            return false;
        }
        File file0 = new File(s);
        return !file0.exists() || !file0.isFile() ? false : file0.delete();
    }

    public final boolean deleteFileFromUri(@Nullable Context context0, @NotNull Uri uri0) {
        q.g(uri0, "fileUri");
        if(context0 != null) {
            String s = uri0.getPath();
            if(s != null && v.r0(s, "file://", false)) {
                return FileUtils.delete(s);
            }
            try {
                if(context0.getContentResolver().delete(uri0, null, null) > 0) {
                    return true;
                }
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static final void deleteSubFiles(@Nullable String s, boolean z) {
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("FileUtils", "deleteSubFiles - path:" + s + ", keepDir:" + z);
        if(s == null) {
            return;
        }
        else {
            File file0 = new File(s);
            if(!file0.exists()) {
                logU$Companion0.v("FileUtils", "deleteSubFiles(" + s + ") directory doesn\'t exist");
                return;
            }
            try {
                File[] arr_file = file0.listFiles();
                if(arr_file != null && arr_file.length != 0) {
                    Y y0 = q.j(arr_file);
                    while(y0.hasNext()) {
                        File file1 = (File)y0.next();
                        if(file1.isDirectory()) {
                            FileUtils.deleteSubFiles(file1.getCanonicalPath(), z);
                        }
                        else {
                            file1.delete();
                        }
                    }
                }
                if(!z) {
                    file0.delete();
                }
                return;
            }
            catch(IOException unused_ex) {
            }
        }
        LogU.Companion.e("FileUtils", "deleteSubFiles(" + s + ") IOExcpetion:" + s);
    }

    public static final void exportUserDb(@NotNull Context context0) {
        String s1;
        File file3;
        q.g(context0, "context");
        String[] arr_s = context0.databaseList();
        File file0 = new File(context0.getExternalCacheDir(), "database");
        if(!file0.exists()) {
            file0.mkdirs();
        }
        Y y0 = q.j(arr_s);
        while(y0.hasNext()) {
            String s = (String)y0.next();
            File file1 = context0.getDatabasePath(s);
            File file2 = null;
            try {
                file3 = new File(file0, s);
            }
            catch(IOException iOException0) {
                goto label_20;
            }
            try {
                FileUtils.INSTANCE.copy(file1, file3);
                s1 = "copying " + file1 + " to " + file3;
                LogU.Companion.d("FileUtils", s1);
                goto label_24;
            }
            catch(IOException iOException0) {
                file2 = file3;
            }
        label_20:
            String s2 = "copy " + file1 + " to " + file2 + ", error: " + iOException0;
            LogU.Companion.e("FileUtils", s2);
            iOException0.printStackTrace();
            s1 = s2;
        label_24:
            ToastManager.debug(s1);
        }
    }

    @NotNull
    public final File getCoilImageCacheDir(@NotNull Context context0) {
        q.g(context0, "context");
        return FileUtils.getDiskCacheDir(context0, "coil_image_cache");
    }

    @NotNull
    public static final File getDiskCacheDir(@Nullable Context context0, @NotNull String s) {
        q.g(s, "uniqueName");
        return new File(FileUtils.INSTANCE.getDiskCacheRootDir(context0), s);
    }

    @Nullable
    public final File getDiskCacheRootDir(@Nullable Context context0) {
        if(context0 == null) {
            return null;
        }
        return Environment.getExternalStorageState() == "mounted" || !this.isExternalStorageRemovable() ? context0.getExternalCacheDir() : context0.getCacheDir();
    }

    @NotNull
    public static final File getExoPlayerCacheDir(@NotNull Context context0) {
        q.g(context0, "context");
        return new File(context0.getCacheDir(), "videos");
    }

    @Nullable
    public static final String getExternalAppDirLogPath() {
        return (String)FileUtils.b.getValue();
    }

    public static void getExternalAppDirLogPath$annotations() {
    }

    @Nullable
    public static final String getExternalAppDirPath() {
        return (String)FileUtils.a.getValue();
    }

    public static void getExternalAppDirPath$annotations() {
    }

    @NotNull
    public static final Uri getFileUri(@NotNull Context context0, @NotNull File file0) {
        String s;
        q.g(context0, "context");
        q.g(file0, "file");
        d d0 = FileProvider.c(context0, "com.iloen.melon.fileprovider");
        try {
            s = file0.getCanonicalPath();
        }
        catch(IOException unused_ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file0);
        }
        Map.Entry map$Entry0 = null;
        for(Object object0: d0.b.entrySet()) {
            Map.Entry map$Entry1 = (Map.Entry)object0;
            String s1 = ((File)map$Entry1.getValue()).getPath();
            if(FileProvider.a(s).startsWith(FileProvider.a(s1) + '/') && (map$Entry0 == null || s1.length() > ((File)map$Entry0.getValue()).getPath().length())) {
                map$Entry0 = map$Entry1;
            }
        }
        if(map$Entry0 == null) {
            throw new IllegalArgumentException("Failed to find configured root that contains " + s);
        }
        String s2 = ((File)map$Entry0.getValue()).getPath();
        Uri uri0 = new Uri.Builder().scheme("content").authority(d0.a).encodedPath(Uri.encode(((String)map$Entry0.getKey())) + '/' + Uri.encode((s2.endsWith("/") ? s.substring(s2.length()) : s.substring(s2.length() + 1)), "/")).build();
        q.f(uri0, "getUriForFile(...)");
        return uri0;
    }

    @NotNull
    public final File getImageCacheDir(@NotNull Context context0) {
        q.g(context0, "context");
        return FileUtils.getDiskCacheDir(context0, "image_cache");
    }

    @Nullable
    public final String getImageFilePathForUri(@Nullable Context context0, @NotNull Uri uri0) {
        q.g(uri0, "uri");
        if(context0 != null) {
            if("file".equals(uri0.getScheme())) {
                return uri0.getPath();
            }
            Cursor cursor0 = new CursorLoader(context0, uri0, new String[]{"_data"}).b();
            if(cursor0 != null) {
                int v = cursor0.getColumnIndexOrThrow("_data");
                cursor0.moveToFirst();
                String s = cursor0.getString(v);
                cursor0.close();
                return s;
            }
        }
        return null;
    }

    public static final long getLastModifiedTime(@NotNull String s) {
        q.g(s, "filePath");
        if(TextUtils.isEmpty(s)) {
            return 0L;
        }
        File file0 = new File(s);
        return !file0.exists() || !file0.isFile() ? 0L : file0.lastModified();
    }

    @NotNull
    public final File getLegacyImageCacheDir(@NotNull Context context0) {
        q.g(context0, "context");
        return FileUtils.getDiskCacheDir(context0, "http");
    }

    @NotNull
    public static final String getSafetyPath(@Nullable File file0) {
        if(file0 == null) {
            return "";
        }
        try {
            String s = file0.getCanonicalPath();
            q.d(s);
            return s;
        }
        catch(Exception unused_ex) {
            String s1 = file0.getAbsolutePath();
            q.d(s1);
            return s1;
        }
    }

    @Nullable
    public static final String getSecondaryExternalStorage() {
        String[] arr_s;
        List list0;
        String s1;
        String s = Environment.getExternalStorageDirectory().getPath();
        try {
            FileReader fileReader0 = new FileReader(new File("/proc/mounts"));
            BufferedReader bufferedReader0 = new BufferedReader(fileReader0);
            do {
                do {
                    s1 = bufferedReader0.readLine();
                    q.d(s1);
                    LogU.Companion.v("FileUtils", "line:" + s1);
                }
                while(o.v0(s1, "secure", false) || o.v0(s1, "asec", false) || !o.v0(s1, "fat", false));
                Pattern pattern0 = Pattern.compile("\\s");
                q.f(pattern0, "compile(...)");
                o.P0(0);
                Matcher matcher0 = pattern0.matcher(s1);
                if(matcher0.find()) {
                    ArrayList arrayList0 = new ArrayList(10);
                    int v = 0;
                    do {
                        arrayList0.add(s1.subSequence(v, matcher0.start()).toString());
                        v = matcher0.end();
                    }
                    while(matcher0.find());
                    arrayList0.add(s1.subSequence(v, s1.length()).toString());
                    list0 = arrayList0;
                }
                else {
                    list0 = k.z(s1.toString());
                }
                arr_s = (String[])list0.toArray(new String[0]);
            }
            while(arr_s.length < 2 || q.b(arr_s[1], s) || o.v0(arr_s[1], "firmware", false));
            String s2 = arr_s[1];
            fileReader0.close();
            bufferedReader0.close();
            return s2;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final File getShareCacheDir(@NotNull Context context0) {
        q.g(context0, "context");
        return FileUtils.getDiskCacheDir(context0, "share");
    }

    public static final boolean hideMediaDirectory(@Nullable File file0, boolean z) {
        if(file0 == null) {
            return false;
        }
        if(z && !file0.exists()) {
            file0.mkdirs();
        }
        File file1 = new File(file0, ".nomedia");
        if(file1.exists()) {
            return true;
        }
        try {
            file1.createNewFile();
        }
        catch(IOException unused_ex) {
        }
        return file1.exists();
    }

    public final boolean isExternalStorageRemovable() {
        Boolean boolean0;
        try {
            boolean0 = Boolean.valueOf(Environment.isExternalStorageRemovable());
            return boolean0 instanceof Boolean ? boolean0.booleanValue() : true;
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            goto label_4;
        }
        try {
            try {
                return boolean0.booleanValue();
            }
            catch(IllegalArgumentException illegalArgumentException0) {
            label_4:
                LogU.Companion.e("FileUtils", "isExternalStorageRemovable - " + illegalArgumentException0);
                illegalArgumentException0.printStackTrace();
                return true;
            }
            catch(IllegalAccessException illegalAccessException0) {
                LogU.Companion.e("FileUtils", "isExternalStorageRemovable - " + illegalAccessException0);
                illegalAccessException0.printStackTrace();
                return true;
            }
            catch(InvocationTargetException invocationTargetException0) {
                LogU.Companion.e("FileUtils", "isExternalStorageRemovable - " + invocationTargetException0);
                invocationTargetException0.printStackTrace();
                return true;
            }
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            LogU.Companion.e("FileUtils", "isExternalStorageRemovable - " + noSuchMethodException0);
            noSuchMethodException0.printStackTrace();
        }
        return true;
    }

    @Nullable
    public final String makeSafeFileNameByMD5(@NotNull String s) {
        q.g(s, "urlString");
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
            byte[] arr_b = s.getBytes(a.a);
            q.f(arr_b, "getBytes(...)");
            return Base64.encodeToString(messageDigest0.digest(arr_b), 11);
        }
        catch(NoSuchAlgorithmException unused_ex) {
            try {
                Pattern pattern0 = Pattern.compile("://|[^\\d\\w]");
                q.f(pattern0, "compile(...)");
                String s1 = pattern0.matcher(s).replaceAll("_");
                q.f(s1, "replaceAll(...)");
                return URLEncoder.encode(s1, "utf-8");
            }
            catch(UnsupportedEncodingException unused_ex) {
                throw new IllegalStateException();
            }
        }
        catch(NullPointerException unused_ex) {
            return null;
        }
    }

    public static final boolean pathEquals(@Nullable String s, @Nullable String s1) {
        return s == null || s1 == null ? s == null && s1 == null : new File(s).equals(new File(s1));
    }

    @Nullable
    public final Uri saveImageFile(@NotNull Context context0, @NotNull Bitmap bitmap0, @NotNull String s, boolean z) {
        Uri uri0;
        q.g(context0, "context");
        q.g(bitmap0, "bitmap");
        q.g(s, "fileName");
        File file0 = z ? context0.getExternalCacheDir() : Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String s1 = s + "20250906_113327" + ".png";
        OutputStream outputStream0 = null;
        if(z) {
            uri0 = null;
            outputStream0 = new FileOutputStream(new File(file0, s1));
        }
        else {
            ContentResolver contentResolver0 = context0.getContentResolver();
            if(contentResolver0 == null) {
                uri0 = null;
            }
            else {
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("_display_name", s1);
                contentValues0.put("mime_type", "image/png");
                contentValues0.put("relative_path", Environment.DIRECTORY_PICTURES);
                uri0 = contentResolver0.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues0);
                if(uri0 != null) {
                    outputStream0 = contentResolver0.openOutputStream(uri0);
                }
            }
        }
        try {
            if(outputStream0 != null) {
                bitmap0.compress(Bitmap.CompressFormat.PNG, 90, outputStream0);
            }
            if(z) {
                uri0 = Uri.fromFile(new File(file0, s1));
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(outputStream0, throwable0);
            throw throwable0;
        }
        if(outputStream0 != null) {
            outputStream0.close();
        }
        return uri0;
    }

    public static Uri saveImageFile$default(FileUtils fileUtils0, Context context0, Bitmap bitmap0, String s, boolean z, int v, Object object0) {
        if((v & 8) != 0) {
            z = false;
        }
        return fileUtils0.saveImageFile(context0, bitmap0, s, z);
    }

    @Nullable
    public static final String writeOnFile(@NotNull String s, @Nullable String s1, boolean z, boolean z1) {
        BufferedOutputStream bufferedOutputStream1;
        BufferedOutputStream bufferedOutputStream0;
        q.g(s, "filename");
        if(s1 != null) {
            try {
                bufferedOutputStream0 = null;
                File file0 = FileUtils.INSTANCE.createNewFile(s, z);
                if(file0 == null) {
                    LogU.Companion.w("FileUtils", "writeOnFile() fail to create file");
                    return s1;
                }
                bufferedOutputStream1 = new BufferedOutputStream(new FileOutputStream(file0, z1), 0x19000);
            }
            catch(IOException iOException0) {
                goto label_32;
            }
            catch(SecurityException securityException0) {
                goto label_35;
            }
            catch(Exception exception0) {
                goto label_28;
            }
            catch(Throwable throwable0) {
                goto label_43;
            }
            try {
                Charset charset0 = Charset.forName("utf-8");
                q.f(charset0, "forName(...)");
                byte[] arr_b = s1.getBytes(charset0);
                q.f(arr_b, "getBytes(...)");
                bufferedOutputStream1.write(arr_b);
                bufferedOutputStream1.flush();
                goto label_46;
            }
            catch(IOException iOException0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                goto label_32;
            }
            catch(SecurityException securityException0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                goto label_35;
            }
            catch(Exception exception0) {
                bufferedOutputStream0 = bufferedOutputStream1;
                try {
                    while(true) {
                        LogU.Companion.w("FileUtils", "writeOnFile() " + exception0);
                        goto label_38;
                        try {
                            goto label_43;
                        label_28:
                            continue;
                        }
                        catch(IOException iOException0) {
                            break;
                        }
                        catch(SecurityException securityException0) {
                            goto label_35;
                        }
                        catch(Exception exception0) {
                        }
                    }
                label_32:
                    LogU.Companion.w("FileUtils", "writeOnFile() " + iOException0);
                    if(bufferedOutputStream0 != null) {
                        goto label_39;
                    label_35:
                        LogU.Companion.w("FileUtils", "writeOnFile() " + securityException0);
                        if(bufferedOutputStream0 != null) {
                            goto label_39;
                        }
                    }
                    return s1;
                }
                catch(Throwable throwable0) {
                    goto label_43;
                }
                goto label_39;
            label_38:
                if(bufferedOutputStream0 != null) {
                    try {
                    label_39:
                        bufferedOutputStream0.close();
                        return s1;
                    }
                    catch(IOException unused_ex) {
                    }
                }
                return s1;
            }
            catch(Throwable throwable0) {
                bufferedOutputStream0 = bufferedOutputStream1;
            }
        label_43:
            if(bufferedOutputStream0 != null) {
                try {
                    bufferedOutputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
            try {
            label_46:
                bufferedOutputStream1.close();
                return s1;
            }
            catch(IOException unused_ex) {
            }
        }
        return s1;
    }
}

