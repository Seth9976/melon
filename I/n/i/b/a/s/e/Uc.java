package i.n.i.b.a.s.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class uc {
    public final tc a;
    public static final Pattern b;

    static {
        uc.b = Pattern.compile("[a-zA-Z0-9_-]*");
    }

    public uc(Context context0) {
        this.a = new tc(context0, "ibisofflinelicensestore.db", null, 1);  // 初始化器: Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    }

    public final byte[] a(String s, byte[] arr_b) {
        if(!uc.b.matcher(s).matches()) {
            throw new IllegalArgumentException("Key storage name is not valid");
        }
        ArrayList arrayList0 = new ArrayList(1);
        ArrayList arrayList1 = new ArrayList();
        String s1 = "";
        if(s != null) {
            s1 = " storage_name = ?";
            arrayList1.add(s);
        }
        if(!TextUtils.isEmpty(s1)) {
            s1 = s1 + " AND";
        }
        arrayList1.add(Base64.encodeToString(arr_b, 2));
        SQLiteDatabase sQLiteDatabase0 = this.a.getReadableDatabase();
        String[] arr_s = (String[])arrayList1.toArray(new String[0]);
        try(Cursor cursor0 = sQLiteDatabase0.query("keys", new String[]{"storage_name", "uri", "init_data", "key_set_id", "timestamp"}, s1 + " init_data = ?", arr_s, null, null, null, null)) {
            if(cursor0.moveToNext()) {
                cursor0.getString(cursor0.getColumnIndexOrThrow("storage_name"));
                cursor0.getString(cursor0.getColumnIndexOrThrow("uri"));
                cursor0.getString(cursor0.getColumnIndexOrThrow("init_data"));
                String s2 = cursor0.getString(cursor0.getColumnIndexOrThrow("key_set_id"));
                cursor0.getLong(cursor0.getColumnIndexOrThrow("timestamp"));
                arrayList0.add(Base64.decode(s2, 0));
                return arrayList0.size() <= 0 ? null : ((byte[])arrayList0.get(0));
            }
        }
        return arrayList0.size() <= 0 ? null : ((byte[])arrayList0.get(0));
    }
}

