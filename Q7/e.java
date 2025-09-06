package Q7;

import ie.H;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map.Entry;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import org.json.JSONObject;
import we.n;

public final class e extends i implements n {
    public final Object B;
    public final b D;
    public final c E;
    public int r;
    public final f w;

    public e(f f0, Map map0, b b0, c c0, Continuation continuation0) {
        this.w = f0;
        this.B = map0;
        this.D = b0;
        this.E = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, ((Map)this.B), this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        c c0 = this.E;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                try {
                    URLConnection uRLConnection0 = f.a(this.w).openConnection();
                    q.e(uRLConnection0, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    ((HttpsURLConnection)uRLConnection0).setRequestMethod("GET");
                    ((HttpsURLConnection)uRLConnection0).setRequestProperty("Accept", "application/json");
                    for(Object object1: ((Map)this.B).entrySet()) {
                        ((HttpsURLConnection)uRLConnection0).setRequestProperty(((String)((Map.Entry)object1).getKey()), ((String)((Map.Entry)object1).getValue()));
                    }
                    int v = ((HttpsURLConnection)uRLConnection0).getResponseCode();
                    if(v == 200) {
                        InputStream inputStream0 = ((HttpsURLConnection)uRLConnection0).getInputStream();
                        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0));
                        StringBuilder stringBuilder0 = new StringBuilder();
                        String s;
                        while((s = bufferedReader0.readLine()) != null) {
                            stringBuilder0.append(s);
                        }
                        bufferedReader0.close();
                        inputStream0.close();
                        JSONObject jSONObject0 = new JSONObject(stringBuilder0.toString());
                        this.r = 1;
                        if(this.D.invoke(jSONObject0, this) == a0) {
                            return a0;
                        }
                    }
                    else {
                        this.r = 2;
                        c0.invoke("Bad response code: " + v, this);
                        return h0 == a0 ? a0 : h0;
                    }
                }
                catch(Exception exception0) {
                label_38:
                    this.r = 3;
                    c0.invoke((exception0.getMessage() == null ? exception0.toString() : exception0.getMessage()), this);
                    if(h0 == a0) {
                        return a0;
                    }
                }
                return h0;
            }
            case 1: 
            case 2: {
                try {
                    d5.n.D(object0);
                    return h0;
                }
                catch(Exception exception0) {
                    goto label_38;
                }
            }
            case 3: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

