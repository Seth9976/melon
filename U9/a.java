package u9;

import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.provider.DocumentsContract;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import e3.h;
import java.util.HashMap;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final LogU b;
    public static final h c;
    public static final HashMap d;

    static {
        a.c = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.d = new HashMap();
    }

    public a(String s) {
        this.a = s;
        this.b = Z.g("SafStorage", true);
    }

    public final r2.a a() {
        Uri uri0 = this.b();
        return uri0.equals(Uri.EMPTY) ? null : new r2.a(Y.a(MelonAppBase.Companion), DocumentsContract.buildDocumentUriUsingTree(uri0, DocumentsContract.getTreeDocumentId(uri0)));
    }

    public final Uri b() {
        MelonAppBase.Companion.getClass();
        String s = t.a().getContext().getSharedPreferences("preference_name_saf", 0).getString("preference_key_uri_" + this.a, "");
        LogU.debug$default(this.b, "getDocumentTreeUri() uri : " + s, null, false, 6, null);
        if(s != null && s.length() != 0) {
            Uri uri0 = Uri.parse(s);
            q.d(uri0);
            return uri0;
        }
        Uri uri1 = Uri.EMPTY;
        q.d(uri1);
        return uri1;
    }

    public final boolean c() {
        r2.a a0 = this.a();
        return a0 != null && a0.b() && a0.a();
    }

    public final void d(Uri uri0) {
        LogU.info$default(this.b, "setDocumentTreeUri() uri : " + uri0, null, false, 6, null);
        MelonAppBase.Companion.getClass();
        t.a().getContext().getContentResolver().takePersistableUriPermission(uri0, 3);
        MelonAppBase.Companion.getClass();
        SharedPreferences.Editor sharedPreferences$Editor0 = t.a().getContext().getSharedPreferences("preference_name_saf", 0).edit();
        sharedPreferences$Editor0.putString("preference_key_uri_" + this.a, uri0.toString());
        sharedPreferences$Editor0.commit();
    }
}

