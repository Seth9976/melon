package yb;

import Ga.c;
import Na.d;
import Na.e;
import com.iloen.melon.net.v6x.response.ChartStreamingCardUploadRes;
import d5.n;
import java.io.Serializable;
import okhttp3.MultipartBody.Part;

public final class b {
    public final c a;

    public b(c c0) {
        this.a = c0;
    }

    public final Object a(Part multipartBody$Part0, String s, oe.c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Serializable serializable0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    a0.B = 1;
                    serializable0 = this.a.a(multipartBody$Part0, s, a0);
                    if(serializable0 == a1) {
                        return a1;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((ChartStreamingCardUploadRes)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }
}

