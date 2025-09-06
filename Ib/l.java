package ib;

import com.iloen.melon.sns.model.SharableMusicDna;
import ie.H;
import java.io.File;
import java.io.Serializable;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody.Companion;
import okhttp3.RequestBody;
import te.j;
import we.n;

public final class l extends i implements n {
    public final m B;
    public final SharableMusicDna D;
    public final String E;
    public int r;
    public final String w;

    public l(String s, m m0, SharableMusicDna sharableMusicDna0, String s1, Continuation continuation0) {
        this.w = s;
        this.B = m0;
        this.D = sharableMusicDna0;
        this.E = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                File file0 = new File(this.w);
                MediaType mediaType0 = MediaType.Companion.parse("image/*");
                byte[] arr_b = j.B(file0);
                RequestBody requestBody0 = Companion.create$default(RequestBody.Companion, arr_b, mediaType0, 0, 0, 6, null);
                String s = file0.getName();
                Part multipartBody$Part0 = Part.Companion.createFormData("imgFile", s, requestBody0);
                this.r = 1;
                Serializable serializable0 = this.B.a.e(multipartBody$Part0, (this.D.b == null ? "" : this.D.b), (this.D.k == null ? "" : this.D.k), (this.D.l == null ? "" : this.D.l), this.E, this);
                return serializable0 == a0 ? a0 : serializable0;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

