package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.body.EventChunk;
import co.ab180.airbridge.internal.network.body.EventPiece;
import co.ab180.airbridge.internal.parser.a;
import co.ab180.airbridge.internal.parser.c;
import java.util.ArrayList;
import je.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/e;", "Lco/ab180/airbridge/internal/parser/e/y;", "Lco/ab180/airbridge/internal/network/body/EventChunk;", "Lorg/json/JSONObject;", "jsonObject", "b", "(Lorg/json/JSONObject;)Lco/ab180/airbridge/internal/network/body/EventChunk;", "src", "a", "(Lco/ab180/airbridge/internal/network/body/EventChunk;)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e extends y {
    @Override  // co.ab180.airbridge.internal.parser.e.y
    public Object a(JSONObject jSONObject0) {
        return this.b(jSONObject0);
    }

    @NotNull
    public JSONObject a(@NotNull EventChunk eventChunk0) {
        JSONObject jSONObject0 = this.a();
        jSONObject0.put("", b0.b(eventChunk0.getEvents()));
        return jSONObject0;
    }

    @Override  // co.ab180.airbridge.internal.parser.e.y
    public JSONObject a(Object object0) {
        return this.a(((EventChunk)object0));
    }

    @NotNull
    public EventChunk b(@NotNull JSONObject jSONObject0) {
        Object object0;
        JSONArray jSONArray0 = jSONObject0.optJSONArray("");
        w w0 = null;
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            ArrayList arrayList0 = new ArrayList();
            int v = jSONArray0.length();
            int v1 = 0;
            while(v1 < v) {
                try {
                    JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                    if(jSONObject1 != null) {
                        a a0 = c.b.a(EventPiece.class);
                        if(a0 == null) {
                            object0 = null;
                        }
                        else {
                            y y0 = a0.b();
                            if(y0 != null) {
                                object0 = y0.a(jSONObject1);
                            }
                        }
                        if(!(object0 instanceof EventPiece)) {
                            object0 = null;
                        }
                        if(((EventPiece)object0) != null) {
                            arrayList0.add(((EventPiece)object0));
                            goto label_22;
                        }
                        goto label_21;
                    }
                    goto label_22;
                }
                catch(Throwable unused_ex) {
                }
            label_21:
                b.e.b("Failed to parse JSONObject at index " + v1 + " in array \'" + "" + '\'', new Object[0]);
            label_22:
                ++v1;
            }
            w0 = arrayList0;
        }
        if(w0 == null) {
            w0 = w.a;
        }
        return new EventChunk(w0);
    }
}

