package Z1;

import E1.a;
import P.z;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import androidx.collection.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class c {
    public static final u a;
    public static final a b;

    static {
        c.a = new u(2);
        c.b = new a(5);
    }

    public static z a(Context context0, List list0) {
        Trace.beginSection("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                d d0 = (d)list0.get(v1);
                ProviderInfo providerInfo0 = c.b(context0.getPackageManager(), d0, context0.getResources());
                if(providerInfo0 == null) {
                    z z0 = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
                    z0.a = 1;
                    z0.b = Collections.singletonList(null);
                    return z0;
                }
                arrayList0.add(c.c(context0, d0, providerInfo0.authority));
            }
            z z1 = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
            z1.a = 0;
            z1.b = arrayList0;
            return z1;
        }
        finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager0, d d0, Resources resources0) {
        String s;
        a a0 = c.b;
        u u0 = c.a;
        Trace.beginSection("FontProvider.getProvider");
        try {
            List list0 = d0.d;
            s = d0.a;
            String s1 = d0.b;
            if(list0 == null) {
                list0 = R1.a.m(resources0, 0);
            }
            b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            b0.a = s;
            b0.b = s1;
            b0.c = list0;
            ProviderInfo providerInfo0 = (ProviderInfo)u0.get(b0);
            if(providerInfo0 != null) {
                return providerInfo0;
            }
            ProviderInfo providerInfo1 = packageManager0.resolveContentProvider(s, 0);
            if(providerInfo1 != null) {
                if(!providerInfo1.packageName.equals(s1)) {
                    throw new PackageManager.NameNotFoundException("Found content provider " + s + ", but package was not " + s1);
                }
                Signature[] arr_signature = packageManager0.getPackageInfo(providerInfo1.packageName, 0x40).signatures;
                ArrayList arrayList0 = new ArrayList();
                for(int v1 = 0; v1 < arr_signature.length; ++v1) {
                    arrayList0.add(arr_signature[v1].toByteArray());
                }
                Collections.sort(arrayList0, a0);
            alab1:
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    ArrayList arrayList1 = new ArrayList(((Collection)list0.get(v2)));
                    Collections.sort(arrayList1, a0);
                    if(arrayList0.size() == arrayList1.size()) {
                        int v3 = 0;
                        while(v3 < arrayList0.size()) {
                            if(!Arrays.equals(((byte[])arrayList0.get(v3)), ((byte[])arrayList1.get(v3)))) {
                                continue alab1;
                            }
                            ++v3;
                        }
                        u0.put(b0, providerInfo1);
                        return providerInfo1;
                    }
                }
                return null;
            }
        }
        finally {
            Trace.endSection();
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + s);
    }

    public static i[] c(Context context0, d d0, String s) {
        Trace.beginSection("FontProvider.query");
        try {
            ArrayList arrayList0 = new ArrayList();
            Uri uri0 = new Uri.Builder().scheme("content").authority(s).build();
            Uri uri1 = new Uri.Builder().scheme("content").authority(s).appendPath("file").build();
            ContentProviderClient contentProviderClient0 = context0.getContentResolver().acquireUnstableContentProviderClient(uri0);
            Cursor cursor0 = null;
            try {
                Trace.beginSection("ContentQueryWrapper.query");
                String[] arr_s = {d0.c};
                if(contentProviderClient0 != null) {
                    try {
                        try {
                            cursor0 = contentProviderClient0.query(uri0, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", arr_s, null, null);
                        }
                        catch(RemoteException remoteException0) {
                            Log.w("FontsProvider", "Unable to query the content provider", remoteException0);
                        }
                    }
                    catch(Throwable throwable0) {
                        Trace.endSection();
                        throw throwable0;
                    }
                }
                Trace.endSection();
                if(cursor0 != null && cursor0.getCount() > 0) {
                    int v2 = cursor0.getColumnIndex("result_code");
                    ArrayList arrayList1 = new ArrayList();
                    int v3 = cursor0.getColumnIndex("_id");
                    int v4 = cursor0.getColumnIndex("file_id");
                    int v5 = cursor0.getColumnIndex("font_ttc_index");
                    int v6 = cursor0.getColumnIndex("font_weight");
                    int v7 = cursor0.getColumnIndex("font_italic");
                    while(cursor0.moveToNext()) {
                        int v8 = v2 == -1 ? 0 : cursor0.getInt(v2);
                        int v9 = v5 == -1 ? 0 : cursor0.getInt(v5);
                        arrayList1.add(new i((v4 == -1 ? ContentUris.withAppendedId(uri0, cursor0.getLong(v3)) : ContentUris.withAppendedId(uri1, cursor0.getLong(v4))), v9, (v6 == -1 ? 400 : cursor0.getInt(v6)), v7 != -1 && cursor0.getInt(v7) == 1, v8));
                    }
                    arrayList0 = arrayList1;
                }
            }
            finally {
                if(cursor0 != null) {
                    cursor0.close();
                }
                if(contentProviderClient0 != null) {
                    contentProviderClient0.close();
                }
            }
            return (i[])arrayList0.toArray(new i[0]);
        }
        finally {
            Trace.endSection();
        }
    }
}

