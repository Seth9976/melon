package zb;

import Ia.c;
import Na.d;
import Na.e;
import com.melon.net.res.MyMusicOrcRes;
import d5.n;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody.Companion;
import okhttp3.RequestBody;

public final class b {
    public final c a;

    public b(c c0) {
        this.a = c0;
    }

    public final Object a(List list0, oe.c c0) {
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
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                ArrayList arrayList0 = H0.b.m(object0);
                int v1 = list0.size();
                if(v1 == 0) {
                    return new d(new Exception("No media selected"));
                }
                int v2 = 0;
                while(v2 < v1) {
                    MediaType mediaType0 = MediaType.Companion.parse("image/*");
                    Object object1 = list0.get(v2);
                    RequestBody requestBody0 = Companion.create$default(RequestBody.Companion, ((byte[])object1), mediaType0, 0, 0, 6, null);
                    ++v2;
                    arrayList0.add(Part.Companion.createFormData("imgFiles", v2 + ".jpg", requestBody0));
                }
                try {
                    a0.B = 1;
                    object0 = this.a.a(arrayList0, a0);
                    if(object0 == a1) {
                        return a1;
                    label_29:
                        n.D(object0);
                    }
                    return new e(((MyMusicOrcRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_29;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }
}

