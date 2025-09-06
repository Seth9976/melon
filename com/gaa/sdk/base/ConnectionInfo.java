package com.gaa.sdk.base;

import R3.e;
import W.p;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y5.a;

public class ConnectionInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public p a;

    static {
        ConnectionInfo.CREATOR = new e(5);
    }

    public ConnectionInfo(Context context0) {
        p p0;
        try {
            String s = ConnectionInfo.b(context0, "global-services.json");
            if(s != null && s.length() != 0) {
                a.X("ConnectionInfo", "json v2 file: " + s);
                JSONObject jSONObject0 = new JSONObject(s);
                p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                p0.a = jSONObject0.getString("package_name");
                p0.b = jSONObject0.getString("store_download_url");
                this.a = p0;
                a.X("ConnectionInfo", "Json parsing is done.");
                return;
            }
            a.X("ConnectionInfo", "global-services.json file is null");
            String s1 = ConnectionInfo.b(context0, "global-appstores.json");
            if(s1 != null && s1.length() != 0) {
                a.X("ConnectionInfo", "json v1 file: " + s1);
                JSONArray jSONArray0 = new JSONArray(s1);
                p p1 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                JSONObject jSONObject1 = jSONArray0.getJSONObject(0);
                p1.a = jSONObject1.getJSONObject("store_service_info").getString("package_name");
                p1.b = jSONObject1.getString("store_download_url");
                p0 = p1;
                this.a = p0;
                a.X("ConnectionInfo", "Json parsing is done.");
                return;
            }
            a.X("ConnectionInfo", "global-appstores.json file is null");
        }
        catch(Exception unused_ex) {
        }
        try {
            a.X("ConnectionInfo", "json default file: {\"package_name\":\"com.skt.skaf.OA00018282\",\"store_download_url\":\"https:\\/\\/m.onestore.co.kr\\/mobilepoc\\/etc\\/downloadGuide.omp\"}");
            JSONObject jSONObject2 = new JSONObject("{\"package_name\":\"com.skt.skaf.OA00018282\",\"store_download_url\":\"https:\\/\\/m.onestore.co.kr\\/mobilepoc\\/etc\\/downloadGuide.omp\"}");
            p p2 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
            p2.a = "com.skt.skaf.OA00018282";
            p2.b = jSONObject2.getString("store_download_url");
            this.a = p2;
            a.X("ConnectionInfo", "Json parsing is done.");
        }
        catch(JSONException jSONException0) {
            throw new RuntimeException("An error occurred while parsing the json file.", jSONException0);
        }
    }

    public static String a() [...] // 潜在的解密器

    public static String b(Context context0, String s) {
        try {
            InputStream inputStream0 = context0.getAssets().open(s);
            StringBuilder stringBuilder0 = new StringBuilder();
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0, "UTF-8"));
            String s1;
            while((s1 = bufferedReader0.readLine()) != null) {
                stringBuilder0.append(s1);
            }
            bufferedReader0.close();
            return stringBuilder0.toString();
        }
        catch(IOException unused_ex) {
            a.Y("ConnectionInfo", s + " file could not be loaded.");
            return null;
        }
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        p p0 = this.a;
        parcel0.writeString(((String)p0.a));
        parcel0.writeString(((String)p0.b));
    }
}

