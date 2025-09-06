package B7;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Tasks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import jeb.synthetic.FIN;
import org.json.JSONException;
import org.json.JSONObject;
import w7.c;
import y7.b;

public final class d {
    public final Context a;
    public final b b;
    public final e c;
    public static final Pattern d;
    public static final Charset e;

    static {
        d.d = Pattern.compile("[0-9]+s");
        d.e = Charset.forName("UTF-8");
    }

    public d(Context context0, b b0) {
        this.a = context0;
        this.b = b0;
        this.c = new e();
    }

    public static URL a(String s) {
        try {
            return new URL("https://firebaseinstallations.googleapis.com/v1/" + s);
        }
        catch(MalformedURLException malformedURLException0) {
            throw new z7.e(malformedURLException0.getMessage());  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
        }
    }

    public static void b(HttpURLConnection httpURLConnection0, String s, String s1, String s2) {
        InputStream inputStream0 = httpURLConnection0.getErrorStream();
        CharSequence charSequence0 = null;
        if(inputStream0 != null) {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0, d.e));
            try {
                StringBuilder stringBuilder0 = new StringBuilder();
                String s3;
                while((s3 = bufferedReader0.readLine()) != null) {
                    stringBuilder0.append(s3);
                    stringBuilder0.append('\n');
                }
                charSequence0 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", httpURLConnection0.getResponseCode(), httpURLConnection0.getResponseMessage(), stringBuilder0);
            }
            catch(IOException unused_ex) {
            }
            finally {
                bufferedReader0.close();
            }
            try {
            }
            catch(IOException unused_ex) {
            }
        }
        if(!TextUtils.isEmpty(charSequence0)) {
            Log.w("Firebase-Installations", ((String)charSequence0));
            Log.w("Firebase-Installations", "Firebase options used while communicating with Firebase server APIs: " + s1 + ", " + s2 + (TextUtils.isEmpty(s) ? "" : ", " + s));
        }
    }

    public final HttpURLConnection c(URL uRL0, String s) {
        String s1;
        HttpURLConnection httpURLConnection0;
        try {
            httpURLConnection0 = (HttpURLConnection)uRL0.openConnection();
        }
        catch(IOException unused_ex) {
            throw new z7.e("Firebase Installations Service is unavailable. Please try again later.");  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;)V
        }
        httpURLConnection0.setConnectTimeout(10000);
        httpURLConnection0.setUseCaches(false);
        httpURLConnection0.setReadTimeout(10000);
        httpURLConnection0.addRequestProperty("Content-Type", "application/json");
        httpURLConnection0.addRequestProperty("Accept", "application/json");
        httpURLConnection0.addRequestProperty("Content-Encoding", "gzip");
        httpURLConnection0.addRequestProperty("Cache-Control", "no-cache");
        Context context0 = this.a;
        httpURLConnection0.addRequestProperty("X-Android-Package", "com.iloen.melon");
        w7.e e0 = (w7.e)this.b.get();
        if(e0 != null) {
            try {
                httpURLConnection0.addRequestProperty("x-firebase-client", ((String)Tasks.await(((c)e0).a())));
            }
            catch(ExecutionException executionException0) {
                Log.w("ContentValues", "Failed to get heartbeats header", executionException0);
            }
            catch(InterruptedException interruptedException0) {
                Thread.currentThread().interrupt();
                Log.w("ContentValues", "Failed to get heartbeats header", interruptedException0);
            }
        }
        try {
            s1 = null;
            byte[] arr_b = AndroidUtilsLight.getPackageCertificateHashBytes(context0, "com.iloen.melon");
            if(arr_b == null) {
                Log.e("ContentValues", "Could not get fingerprint hash for package: com.iloen.melon");
            }
            else {
                s1 = Hex.bytesToStringUppercase(arr_b, false);
            }
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Log.e("ContentValues", "No such package: com.iloen.melon", packageManager$NameNotFoundException0);
        }
        httpURLConnection0.addRequestProperty("X-Android-Cert", s1);
        httpURLConnection0.addRequestProperty("x-goog-api-key", s);
        return httpURLConnection0;
    }

    public static long d(String s) {
        Preconditions.checkArgument(d.d.matcher(s).matches(), "Invalid Expiration Timestamp.");
        return s == null || s.length() == 0 ? 0L : Long.parseLong(s.substring(0, s.length() - 1));
    }

    public static a e(HttpURLConnection httpURLConnection0) {
        InputStream inputStream0 = httpURLConnection0.getInputStream();
        JsonReader jsonReader0 = new JsonReader(new InputStreamReader(inputStream0, d.e));
        B7.b b0 = B7.c.a();
        jsonReader0.beginObject();
        String s = null;
        String s1 = null;
        String s2 = null;
        B7.c c0 = null;
        while(jsonReader0.hasNext()) {
            String s3 = jsonReader0.nextName();
            if(s3.equals("name")) {
                s = jsonReader0.nextString();
            }
            else if(s3.equals("fid")) {
                s1 = jsonReader0.nextString();
            }
            else if(s3.equals("refreshToken")) {
                s2 = jsonReader0.nextString();
            }
            else if(s3.equals("authToken")) {
                jsonReader0.beginObject();
                while(jsonReader0.hasNext()) {
                    String s4 = jsonReader0.nextName();
                    if(s4.equals("token")) {
                        b0.b = jsonReader0.nextString();
                    }
                    else if(s4.equals("expiresIn")) {
                        b0.c = d.d(jsonReader0.nextString());
                    }
                    else {
                        jsonReader0.skipValue();
                    }
                }
                B7.c c1 = b0.f();
                jsonReader0.endObject();
                c0 = c1;
            }
            else {
                jsonReader0.skipValue();
            }
        }
        jsonReader0.endObject();
        jsonReader0.close();
        inputStream0.close();
        return new a(s, s1, s2, c0, 1);
    }

    public static B7.c f(HttpURLConnection httpURLConnection0) {
        InputStream inputStream0 = httpURLConnection0.getInputStream();
        JsonReader jsonReader0 = new JsonReader(new InputStreamReader(inputStream0, d.e));
        B7.b b0 = B7.c.a();
        jsonReader0.beginObject();
        while(jsonReader0.hasNext()) {
            String s = jsonReader0.nextName();
            if(s.equals("token")) {
                b0.b = jsonReader0.nextString();
            }
            else if(s.equals("expiresIn")) {
                b0.c = d.d(jsonReader0.nextString());
            }
            else {
                jsonReader0.skipValue();
            }
        }
        jsonReader0.endObject();
        jsonReader0.close();
        inputStream0.close();
        b0.a = 1;
        return b0.f();
    }

    public static void g(HttpURLConnection httpURLConnection0, String s, String s1) {
        JSONObject jSONObject0;
        try {
            jSONObject0 = new JSONObject();
            jSONObject0.put("fid", s);
            jSONObject0.put("appId", s1);
            jSONObject0.put("authVersion", "FIS_v2");
            jSONObject0.put("sdkVersion", "a:18.0.0");
        }
        catch(JSONException jSONException0) {
            throw new IllegalStateException(jSONException0);
        }
        d.i(httpURLConnection0, jSONObject0.toString().getBytes("UTF-8"));
    }

    public static void h(HttpURLConnection httpURLConnection0) {
        JSONObject jSONObject1;
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("sdkVersion", "a:18.0.0");
            jSONObject1 = new JSONObject();
            jSONObject1.put("installation", jSONObject0);
        }
        catch(JSONException jSONException0) {
            throw new IllegalStateException(jSONException0);
        }
        d.i(httpURLConnection0, jSONObject1.toString().getBytes("UTF-8"));
    }

    public static void i(HttpURLConnection httpURLConnection0, byte[] arr_b) {
        OutputStream outputStream0 = httpURLConnection0.getOutputStream();
        if(outputStream0 == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(outputStream0);
        int v = FIN.finallyOpen$NT();
        gZIPOutputStream0.write(arr_b);
        try {
            FIN.finallyCodeBegin$NT(v);
            gZIPOutputStream0.close();
            outputStream0.close();
            FIN.finallyCodeEnd$NT(v);
        }
        catch(IOException unused_ex) {
        }
    }
}

