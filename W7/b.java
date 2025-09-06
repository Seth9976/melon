package w7;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import jeb.synthetic.TWR;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements Callable {
    public final int a;
    public final c b;

    public b(c c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override
    public final Object call() {
        if(this.a != 0) {
            synchronized(this.b) {
                ((g)this.b.a.get()).h(System.currentTimeMillis(), ((G7.b)this.b.c.get()).a());
                return null;
            }
        }
        c c0 = this.b;
        synchronized(c0) {
            g g0 = (g)c0.a.get();
            ArrayList arrayList0 = g0.c();
            g0.b();
            JSONArray jSONArray0 = new JSONArray();
            for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
                a a0 = (a)arrayList0.get(v2);
                JSONObject jSONObject0 = new JSONObject();
                jSONObject0.put("agent", a0.a);
                jSONObject0.put("dates", new JSONArray(a0.b));
                jSONArray0.put(jSONObject0);
            }
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.put("heartbeats", jSONArray0);
            jSONObject1.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream0 = new Base64OutputStream(byteArrayOutputStream0, 11);
            try(GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(base64OutputStream0)) {
                gZIPOutputStream0.write(jSONObject1.toString().getBytes("UTF-8"));
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(base64OutputStream0, throwable0);
                throw throwable0;
            }
            base64OutputStream0.close();
            return byteArrayOutputStream0.toString("UTF-8");
        }
    }
}

