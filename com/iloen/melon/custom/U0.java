package com.iloen.melon.custom;

import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x8.f;

public final class u0 extends f {
    public ArrayList a;
    public String[] b;
    public final JSONObject c;
    public final v0 d;

    public u0(v0 v00, JSONObject jSONObject0) {
        this.d = v00;
        this.c = jSONObject0;
        super();
        this.a = null;
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        JSONObject jSONObject0 = (JSONObject)object0;
        try {
            JSONArray jSONArray0 = this.c.getJSONArray("song");
            int v = jSONArray0.length();
            this.b = new String[v];
        label_5:
            for(int v1 = 0; v1 < v; ++v1) {
                String[] arr_s = this.b;
                arr_s[v1] = jSONArray0.getJSONObject(v1).getString("id");
                LogU.d("MelonWebView", "ids_" + this.b[v1]);
            }
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            if(true) {
                goto label_14;
            }
            goto label_5;
        }
    label_14:
        ArrayList arrayList0 = MelonWebView.a(this.d.e.a.getContext(), "M20002");
        this.a = arrayList0;
        return arrayList0;
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        ArrayList arrayList0 = (ArrayList)object0;
        this.d.e.a.a.showProgress(false);
        try {
            this.d.e.showPopup(this.c, this.a, this.b, "addToDjList", this.d.c);
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    @Override  // x8.f
    public final void preTask() {
        this.d.e.a.a.showProgress(true);
    }
}

