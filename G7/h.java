package g7;

import android.util.Log;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import e7.f;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public final FileStore a;
    public static final Charset b;

    static {
        h.b = Charset.forName("UTF-8");
    }

    public h(FileStore fileStore0) {
        this.a = fileStore0;
    }

    public static HashMap a(String s) {
        JSONObject jSONObject0 = new JSONObject(s);
        HashMap hashMap0 = new HashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s1 = (String)object0;
            hashMap0.put(s1, (jSONObject0.isNull(s1) ? null : jSONObject0.optString(s1, null)));
        }
        return hashMap0;
    }

    public static ArrayList b(String s) {
        JSONArray jSONArray0 = new JSONObject(s).getJSONArray("rolloutsState");
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < jSONArray0.length(); ++v) {
            String s1 = jSONArray0.getString(v);
            try {
                JSONObject jSONObject0 = new JSONObject(s1);
                String s2 = jSONObject0.getString("rolloutId");
                String s3 = jSONObject0.getString("parameterKey");
                String s4 = jSONObject0.getString("parameterValue");
                String s5 = jSONObject0.getString("variantId");
                long v1 = jSONObject0.getLong("templateVersion");
                if(s4.length() > 0x100) {
                    s4 = s4.substring(0, 0x100);
                }
                arrayList0.add(new b(v1, s2, s3, s4, s5));
            }
            catch(Exception exception0) {
                Log.w("FirebaseCrashlytics", "Failed de-serializing rollouts state. " + s1, exception0);
            }
        }
        return arrayList0;
    }

    public final Map c(String s, boolean z) {
        Map map0;
        Throwable throwable1;
        Exception exception1;
        FileInputStream fileInputStream0;
        File file0 = z ? this.a.b(s, "internal-keys") : this.a.b(s, "keys");
        if(file0.exists() && file0.length() != 0L) {
            try {
                fileInputStream0 = null;
                fileInputStream0 = new FileInputStream(file0);
            }
            catch(Exception exception0) {
                exception1 = exception0;
                goto label_14;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                f.b(fileInputStream0, "Failed to close user metadata file.");
                throw throwable1;
            }
            try {
                map0 = h.a(f.i(fileInputStream0));
                goto label_21;
            }
            catch(Exception exception1) {
                try {
                label_14:
                    Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", exception1);
                    h.f(file0);
                }
                catch(Throwable throwable1) {
                    f.b(fileInputStream0, "Failed to close user metadata file.");
                    throw throwable1;
                }
                f.b(fileInputStream0, "Failed to close user metadata file.");
                return Collections.EMPTY_MAP;
            }
            catch(Throwable throwable1) {
            }
            f.b(fileInputStream0, "Failed to close user metadata file.");
            throw throwable1;
        label_21:
            f.b(fileInputStream0, "Failed to close user metadata file.");
            return map0;
        }
        h.g(file0, "The file has a length of zero for session: " + s);
        return Collections.EMPTY_MAP;
    }

    public final String d(String s) {
        String s1;
        FileInputStream fileInputStream0;
        File file0 = this.a.b(s, "user-data");
        Closeable closeable0 = null;
        if(file0.exists() && file0.length() != 0L) {
            try {
                fileInputStream0 = null;
                fileInputStream0 = new FileInputStream(file0);
                goto label_8;
            }
            catch(Exception exception0) {
                goto label_14;
            }
            catch(Throwable throwable0) {
            }
            f.b(closeable0, "Failed to close user metadata file.");
            throw throwable0;
            try {
                try {
                label_8:
                    JSONObject jSONObject0 = new JSONObject(f.i(fileInputStream0));
                    s1 = jSONObject0.isNull("userId") ? null : jSONObject0.optString("userId", null);
                    if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Loaded userId " + s1 + " for session " + s, null);
                    }
                    goto label_22;
                }
                catch(Exception exception0) {
                }
            label_14:
                Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", exception0);
                h.f(file0);
            }
            catch(Throwable throwable0) {
                closeable0 = fileInputStream0;
                f.b(closeable0, "Failed to close user metadata file.");
                throw throwable0;
            }
            f.b(fileInputStream0, "Failed to close user metadata file.");
            return null;
        label_22:
            f.b(fileInputStream0, "Failed to close user metadata file.");
            return s1;
        }
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "No userId set for session " + s, null);
        }
        h.f(file0);
        return null;
    }

    public static String e(List list0) {
        HashMap hashMap0 = new HashMap();
        JSONArray jSONArray0 = new JSONArray();
        for(int v = 0; v < list0.size(); ++v) {
            Object object0 = list0.get(v);
            String s = o.a.o(object0);
            try {
                jSONArray0.put(new JSONObject(s));
            }
            catch(JSONException jSONException0) {
                Log.w("FirebaseCrashlytics", "Exception parsing rollout assignment!", jSONException0);
            }
        }
        hashMap0.put("rolloutsState", jSONArray0);
        return new JSONObject(hashMap0).toString();
    }

    public static void f(File file0) {
        if(file0.exists() && file0.delete()) {
            Log.i("FirebaseCrashlytics", "Deleted corrupt file: " + file0.getAbsolutePath(), null);
        }
    }

    public static void g(File file0, String s) {
        if(file0.exists() && file0.delete()) {
            Log.i("FirebaseCrashlytics", androidx.appcompat.app.o.o("Deleted corrupt file: ", file0.getAbsolutePath(), "\nReason: ", s), null);
        }
    }

    public final void h(String s, Map map0, boolean z) {
        BufferedWriter bufferedWriter1;
        String s1;
        BufferedWriter bufferedWriter0;
        File file0 = z ? this.a.b(s, "internal-keys") : this.a.b(s, "keys");
        try {
            bufferedWriter0 = null;
            s1 = new JSONObject(map0).toString();
            bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file0), h.b));
            goto label_7;
        }
        catch(Exception exception0) {
            goto label_12;
            try {
            label_7:
                bufferedWriter1.write(s1);
                bufferedWriter1.flush();
                goto label_23;
            }
            catch(Exception exception0) {
            }
            catch(Throwable throwable0) {
                bufferedWriter0 = bufferedWriter1;
                f.b(bufferedWriter0, "Failed to close key/value metadata file.");
                throw throwable0;
            }
            bufferedWriter0 = bufferedWriter1;
            try {
            label_12:
                Log.w("FirebaseCrashlytics", "Error serializing key/value metadata.", exception0);
                h.f(file0);
                goto label_17;
            }
            catch(Throwable throwable0) {
            }
            f.b(bufferedWriter0, "Failed to close key/value metadata file.");
            throw throwable0;
        }
        catch(Throwable throwable0) {
            f.b(bufferedWriter0, "Failed to close key/value metadata file.");
            throw throwable0;
        }
    label_17:
        f.b(bufferedWriter0, "Failed to close key/value metadata file.");
        return;
    label_23:
        f.b(bufferedWriter1, "Failed to close key/value metadata file.");
    }

    public final void i(String s, List list0) {
        Throwable throwable1;
        Exception exception1;
        BufferedWriter bufferedWriter0;
        String s1;
        File file0 = this.a.b(s, "rollouts-state");
        if(list0.isEmpty()) {
            h.g(file0, "Rollout state is empty for session: " + s);
            return;
        }
        try {
            s1 = h.e(list0);
            bufferedWriter0 = null;
            bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file0), h.b));
        }
        catch(Exception exception0) {
            bufferedWriter0 = null;
            exception1 = exception0;
            goto label_19;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            f.b(bufferedWriter0, "Failed to close rollouts state file.");
            throw throwable1;
        }
        try {
            bufferedWriter0.write(s1);
            bufferedWriter0.flush();
            goto label_26;
        }
        catch(Exception exception1) {
            try {
            label_19:
                Log.w("FirebaseCrashlytics", "Error serializing rollouts state.", exception1);
                h.f(file0);
            }
            catch(Throwable throwable1) {
                f.b(bufferedWriter0, "Failed to close rollouts state file.");
                throw throwable1;
            }
            f.b(bufferedWriter0, "Failed to close rollouts state file.");
            return;
        }
        catch(Throwable throwable1) {
        }
        f.b(bufferedWriter0, "Failed to close rollouts state file.");
        throw throwable1;
    label_26:
        f.b(bufferedWriter0, "Failed to close rollouts state file.");
    }

    public final void j(String s, String s1) {
        BufferedWriter bufferedWriter1;
        g g0;
        File file0 = this.a.b(s, "user-data");
        BufferedWriter bufferedWriter0 = null;
        try {
            g0 = new g();  // 初始化器: Lorg/json/JSONObject;-><init>()V
            g0.put("userId", s1);
            bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file0), h.b));
            goto label_8;
        }
        catch(Exception exception0) {
            goto label_13;
            try {
            label_8:
                bufferedWriter1.write(g0.toString());
                bufferedWriter1.flush();
                goto label_23;
            }
            catch(Exception exception0) {
            }
            catch(Throwable throwable0) {
                bufferedWriter0 = bufferedWriter1;
                f.b(bufferedWriter0, "Failed to close user metadata file.");
                throw throwable0;
            }
            bufferedWriter0 = bufferedWriter1;
            try {
            label_13:
                Log.w("FirebaseCrashlytics", "Error serializing user metadata.", exception0);
                goto label_17;
            }
            catch(Throwable throwable0) {
            }
            f.b(bufferedWriter0, "Failed to close user metadata file.");
            throw throwable0;
        }
        catch(Throwable throwable0) {
            f.b(bufferedWriter0, "Failed to close user metadata file.");
            throw throwable0;
        }
    label_17:
        f.b(bufferedWriter0, "Failed to close user metadata file.");
        return;
    label_23:
        f.b(bufferedWriter1, "Failed to close user metadata file.");
    }
}

