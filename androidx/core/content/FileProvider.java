package androidx.core.content;

import H0.b;
import P1.c;
import P1.d;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    public final Object a;
    public String b;
    public d c;
    public static final String[] d;
    public static final File e;
    public static final HashMap f;

    static {
        FileProvider.d = new String[]{"_display_name", "_size"};
        FileProvider.e = new File("/");
        FileProvider.f = new HashMap();
    }

    public FileProvider() {
        this.a = new Object();
    }

    public static String a(String s) {
        return s.length() <= 0 || s.charAt(s.length() - 1) != 0x2F ? s : b.d(1, 0, s);
    }

    @Override  // android.content.ContentProvider
    public final void attachInfo(Context context0, ProviderInfo providerInfo0) {
        super.attachInfo(context0, providerInfo0);
        if(providerInfo0.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if(!providerInfo0.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        if(providerInfo0.authority == null || providerInfo0.authority.trim().isEmpty()) {
            throw new SecurityException("Provider must have a non-empty authority");
        }
        String s = providerInfo0.authority.split(";")[0];
        synchronized(this.a) {
            this.b = s;
        }
        synchronized(FileProvider.f) {
            FileProvider.f.remove(s);
        }
    }

    public final d b() {
        synchronized(this.a) {
            if(this.b != null) {
                if(this.c == null) {
                    this.c = FileProvider.c(this.getContext(), this.b);
                }
                return this.c;
            }
        }
        throw new NullPointerException("mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
    }

    public static d c(Context context0, String s) {
        HashMap hashMap0 = FileProvider.f;
        synchronized(hashMap0) {
            d d0 = (d)hashMap0.get(s);
            if(d0 == null) {
                try {
                    d0 = FileProvider.d(context0, s);
                }
                catch(IOException iOException0) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", iOException0);
                }
                catch(XmlPullParserException xmlPullParserException0) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", xmlPullParserException0);
                }
                hashMap0.put(s, d0);
            }
            return d0;
        }
    }

    public static d d(Context context0, String s) {
        File file1;
        String s2;
        d d0 = new d(s);
        ProviderInfo providerInfo0 = context0.getPackageManager().resolveContentProvider(s, 0x80);
        if(providerInfo0 == null) {
            throw new IllegalArgumentException("Couldn\'t find meta-data for provider with authority " + s);
        }
        XmlResourceParser xmlResourceParser0 = providerInfo0.loadXmlMetaData(context0.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if(xmlResourceParser0 == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    alab1:
        while(true) {
            switch(xmlResourceParser0.next()) {
                case 1: {
                    return d0;
                }
                case 2: {
                    String s1 = xmlResourceParser0.getName();
                    File file0 = null;
                    s2 = xmlResourceParser0.getAttributeValue(null, "name");
                    String s3 = xmlResourceParser0.getAttributeValue(null, "path");
                    if("root-path".equals(s1)) {
                        file0 = FileProvider.e;
                    }
                    else if("files-path".equals(s1)) {
                        file0 = context0.getFilesDir();
                    }
                    else if("cache-path".equals(s1)) {
                        file0 = context0.getCacheDir();
                    }
                    else if("external-path".equals(s1)) {
                        file0 = Environment.getExternalStorageDirectory();
                    }
                    else if("external-files-path".equals(s1)) {
                        File[] arr_file = c.getExternalFilesDirs(context0, null);
                        if(arr_file.length > 0) {
                            file0 = arr_file[0];
                        }
                    }
                    else if("external-cache-path".equals(s1)) {
                        File[] arr_file1 = c.getExternalCacheDirs(context0);
                        if(arr_file1.length > 0) {
                            file0 = arr_file1[0];
                        }
                    }
                    else if("external-media-path".equals(s1)) {
                        File[] arr_file2 = context0.getExternalMediaDirs();
                        if(arr_file2.length > 0) {
                            file0 = arr_file2[0];
                        }
                    }
                    if(file0 == null) {
                        continue;
                    }
                    if(s3 != null) {
                        file0 = new File(file0, s3);
                    }
                    if(TextUtils.isEmpty(s2)) {
                        break alab1;
                    }
                    try {
                        file1 = file0.getCanonicalFile();
                        break;
                    }
                    catch(IOException iOException0) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + file0, iOException0);
                    }
                }
                default: {
                    continue;
                }
            }
            d0.b.put(s2, file1);
        }
        throw new IllegalArgumentException("Name must not be empty");
    }

    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        return this.b().a(uri0).delete();
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        File file0 = this.b().a(uri0);
        int v = file0.getName().lastIndexOf(46);
        if(v >= 0) {
            String s = file0.getName().substring(v + 1);
            String s1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
            return s1 == null ? "application/octet-stream" : s1;
        }
        return "application/octet-stream";
    }

    @Override  // android.content.ContentProvider
    public final String getTypeAnonymous(Uri uri0) {
        return "application/octet-stream";
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override  // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri0, String s) {
        File file0 = this.b().a(uri0);
        if("r".equals(s)) {
            return ParcelFileDescriptor.open(file0, 0x10000000);
        }
        if(!"w".equals(s) && !"wt".equals(s)) {
            if("wa".equals(s)) {
                return ParcelFileDescriptor.open(file0, 0x2A000000);
            }
            if("rw".equals(s)) {
                return ParcelFileDescriptor.open(file0, 0x38000000);
            }
            if(!"rwt".equals(s)) {
                throw new IllegalArgumentException("Invalid mode: " + s);
            }
            return ParcelFileDescriptor.open(file0, 0x3C000000);
        }
        return ParcelFileDescriptor.open(file0, 0x2C000000);
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        File file0 = this.b().a(uri0);
        String s2 = uri0.getQueryParameter("displayName");
        if(arr_s == null) {
            arr_s = FileProvider.d;
        }
        String[] arr_s2 = new String[arr_s.length];
        Object[] arr_object = new Object[arr_s.length];
        int v1 = 0;
        for(int v = 0; v < arr_s.length; ++v) {
            String s3 = arr_s[v];
            if("_display_name".equals(s3)) {
                arr_s2[v1] = "_display_name";
                arr_object[v1] = s2 == null ? file0.getName() : s2;
                ++v1;
            }
            else if("_size".equals(s3)) {
                arr_s2[v1] = "_size";
                arr_object[v1] = file0.length();
                ++v1;
            }
        }
        String[] arr_s3 = new String[v1];
        System.arraycopy(arr_s2, 0, arr_s3, 0, v1);
        Object[] arr_object1 = new Object[v1];
        System.arraycopy(arr_object, 0, arr_object1, 0, v1);
        Cursor cursor0 = new MatrixCursor(arr_s3, 1);
        ((MatrixCursor)cursor0).addRow(arr_object1);
        return cursor0;
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        throw new UnsupportedOperationException("No external updates");
    }
}

