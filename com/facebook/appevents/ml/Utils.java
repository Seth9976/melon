package com.facebook.appevents.ml;

import Tf.a;
import Tf.o;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007J\u000E\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0004J\u001E\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n2\u0006\u0010\f\u001A\u00020\u0006H\u0007J\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0011R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ml/Utils;", "", "()V", "DIR_NAME", "", "getMlDir", "Ljava/io/File;", "normalizeString", "str", "parseModelWeights", "", "Lcom/facebook/appevents/ml/MTensor;", "file", "vectorize", "", "texts", "maxLen", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Utils {
    @NotNull
    private static final String DIR_NAME = "facebook_ml/";
    @NotNull
    public static final Utils INSTANCE;

    static {
        Utils.INSTANCE = new Utils();
    }

    @Nullable
    public static final File getMlDir() {
        Class class0 = Utils.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            File file0 = new File(FacebookSdk.getApplicationContext().getFilesDir(), "facebook_ml/");
            return !file0.exists() && !file0.mkdirs() ? null : file0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public final String normalizeString(@NotNull String s) {
        List list0;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(s, "str");
            int v = s.length() - 1;
            int v1 = 0;
            boolean z = false;
            while(v1 <= v) {
                boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
                if(z) {
                    if(!z1) {
                        break;
                    }
                    --v;
                }
                else if(z1) {
                    ++v1;
                }
                else {
                    z = true;
                }
            }
            String s1 = s.subSequence(v1, v + 1).toString();
            Pattern pattern0 = Pattern.compile("\\s+");
            q.f(pattern0, "compile(...)");
            q.g(s1, "input");
            o.P0(0);
            Matcher matcher0 = pattern0.matcher(s1);
            if(matcher0.find()) {
                ArrayList arrayList0 = new ArrayList(10);
                int v2 = 0;
                do {
                    arrayList0.add(s1.subSequence(v2, matcher0.start()).toString());
                    v2 = matcher0.end();
                }
                while(matcher0.find());
                arrayList0.add(s1.subSequence(v2, s1.length()).toString());
                list0 = arrayList0;
            }
            else {
                list0 = k.z(s1.toString());
            }
            String s2 = TextUtils.join(" ", ((String[])list0.toArray(new String[0])));
            q.f(s2, "join(\" \", strArray)");
            return s2;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    @Nullable
    public static final Map parseModelWeights(@NotNull File file0) {
        int v5;
        Class class0 = Utils.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(file0, "file");
                try {
                    FileInputStream fileInputStream0 = new FileInputStream(file0);
                    int v = fileInputStream0.available();
                    DataInputStream dataInputStream0 = new DataInputStream(fileInputStream0);
                    byte[] arr_b = new byte[v];
                    dataInputStream0.readFully(arr_b);
                    dataInputStream0.close();
                    if(v >= 4) {
                        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b, 0, 4);
                        byteBuffer0.order(ByteOrder.LITTLE_ENDIAN);
                        int v1 = byteBuffer0.getInt();
                        int v2 = v1 + 4;
                        if(v >= v2) {
                            JSONObject jSONObject0 = new JSONObject(new String(arr_b, 4, v1, a.a));
                            JSONArray jSONArray0 = jSONObject0.names();
                            int v3 = jSONArray0.length();
                            String[] arr_s = new String[v3];
                            for(int v4 = 0; true; ++v4) {
                                v5 = 1;
                                if(v4 >= v3) {
                                    break;
                                }
                                arr_s[v4] = jSONArray0.getString(v4);
                            }
                            if(v3 > 1) {
                                Arrays.sort(arr_s);
                            }
                            Map map0 = new HashMap();
                            int v6 = 0;
                            while(v6 < v3) {
                                String s = arr_s[v6];
                                if(s == null) {
                                    goto label_50;
                                }
                                JSONArray jSONArray1 = jSONObject0.getJSONArray(s);
                                int v7 = jSONArray1.length();
                                int[] arr_v = new int[v7];
                                for(int v8 = 0; v8 < v7; ++v8) {
                                    int v9 = jSONArray1.getInt(v8);
                                    arr_v[v8] = v9;
                                    v5 *= v9;
                                }
                                int v10 = v2 + v5 * 4;
                                if(v10 <= v) {
                                    ByteBuffer byteBuffer1 = ByteBuffer.wrap(arr_b, v2, v5 * 4);
                                    byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
                                    MTensor mTensor0 = new MTensor(arr_v);
                                    byteBuffer1.asFloatBuffer().get(mTensor0.getData(), 0, v5);
                                    ((HashMap)map0).put(s, mTensor0);
                                    v2 = v10;
                                label_50:
                                    ++v6;
                                    v5 = 1;
                                    continue;
                                }
                                return null;
                            }
                            return map0;
                        }
                    }
                    return null;
                }
                catch(Exception unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
                return null;
            }
        }
        return null;
    }

    @NotNull
    public final int[] vectorize(@NotNull String s, int v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(s, "texts");
            int[] arr_v = new int[v];
            String s1 = this.normalizeString(s);
            Charset charset0 = Charset.forName("UTF-8");
            q.f(charset0, "forName(\"UTF-8\")");
            byte[] arr_b = s1.getBytes(charset0);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            for(int v1 = 0; v1 < v; ++v1) {
                arr_v[v1] = v1 < arr_b.length ? arr_b[v1] & 0xFF : 0;
            }
            return arr_v;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }
}

