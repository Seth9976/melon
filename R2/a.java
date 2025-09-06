package r2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import e1.G;
import java.util.ArrayList;
import k8.Y;

public final class a {
    public final int a;
    public Context b;
    public Uri c;

    public a() {
        this.a = 0;
        super();
    }

    public a(Context context0, Uri uri0) {
        this.a = 1;
        super();
        this.b = context0;
        this.c = uri0;
    }

    public final boolean a() {
        if(this.a != 0) {
            Context context0 = this.b;
            Uri uri0 = this.c;
            return context0.checkCallingOrSelfUriPermission(uri0, 1) == 0 && !TextUtils.isEmpty(G.z(context0, uri0, "mime_type"));
        }
        Context context1 = this.b;
        Uri uri1 = this.c;
        return context1.checkCallingOrSelfUriPermission(uri1, 1) == 0 && !TextUtils.isEmpty(G.z(context1, uri1, "mime_type"));
    }

    public final boolean b() {
        return G.f(this.b, this.c);
    }

    public final boolean c() {
        return G.n(this.b, this.c);
    }

    public static a d(Context context0, Uri uri0) {
        a a0 = new a();
        a0.b = context0;
        a0.c = uri0;
        return a0;
    }

    public final String e() {
        return G.z(this.b, this.c, "_display_name");
    }

    public final Uri f() {
        return this.c;
    }

    public final boolean g() {
        return "vnd.android.document/directory".equals(G.z(this.b, this.c, "mime_type"));
    }

    public final long h() {
        return G.y(this.b, this.c, "_size", 0L);
    }

    public final a[] i() {
        if(this.a != 0) {
            Context context0 = this.b;
            ContentResolver contentResolver0 = context0.getContentResolver();
            Uri uri0 = this.c;
            Uri uri1 = DocumentsContract.buildChildDocumentsUriUsingTree(uri0, DocumentsContract.getDocumentId(uri0));
            ArrayList arrayList0 = new ArrayList();
            Cursor cursor0 = null;
            try {
                try {
                    cursor0 = contentResolver0.query(uri1, new String[]{"document_id"}, null, null, null);
                    while(true) {
                        if(!cursor0.moveToNext()) {
                            goto label_26;
                        }
                        arrayList0.add(DocumentsContract.buildDocumentUriUsingTree(uri0, cursor0.getString(0)));
                    }
                }
                catch(Exception exception0) {
                }
                Log.w("DocumentFile", "Failed query: " + exception0);
                if(cursor0 != null) {
                    goto label_15;
                }
                goto label_30;
            }
            catch(Throwable throwable0) {
                goto label_20;
            }
            try {
            label_15:
                Y.s(cursor0);
                goto label_30;
            }
            catch(RuntimeException runtimeException0) {
                throw runtimeException0;
            label_20:
                if(cursor0 == null) {
                    throw throwable0;
                }
                try {
                    Y.s(cursor0);
                    throw throwable0;
                }
                catch(RuntimeException runtimeException1) {
                }
                catch(Exception unused_ex) {
                    throw throwable0;
                }
                throw runtimeException1;
                try {
                label_26:
                    Y.s(cursor0);
                    goto label_30;
                }
                catch(RuntimeException runtimeException2) {
                }
                catch(Exception unused_ex) {
                    goto label_30;
                }
                throw runtimeException2;
            }
            catch(Exception unused_ex) {
            label_30:
                Uri[] arr_uri = (Uri[])arrayList0.toArray(new Uri[arrayList0.size()]);
                a[] arr_a = new a[arr_uri.length];
                for(int v = 0; v < arr_uri.length; ++v) {
                    arr_a[v] = new a(context0, arr_uri[v]);
                }
                return arr_a;
            }
        }
        throw new UnsupportedOperationException();
    }
}

