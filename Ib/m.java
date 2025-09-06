package ib;

import A8.H;
import A8.I;
import Na.e;
import T2.a;
import U4.x;
import android.content.Context;
import android.net.Uri;
import b3.Z;
import com.iloen.melon.net.v6x.response.MusicDnaUploadRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicDnaUploadRes;
import com.iloen.melon.sns.model.SharableMusicDna;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.n;
import hd.S;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import oe.c;
import w7.d;

public final class m {
    public final f a;
    public final StringProviderImpl b;
    public final LogU c;

    public m(f f0, StringProviderImpl stringProviderImpl0) {
        this.a = f0;
        this.b = stringProviderImpl0;
        this.c = Z.g("ShareImageUseCase", true);
    }

    public final Object a(Context context0, Uri uri0, String s, S s1, a a0, c c0) {
        SharableMusicDna sharableMusicDna1;
        String s9;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.w;
        ne.a a1 = ne.a.a;
        String s2 = "";
        switch(k0.D) {
            case 0: {
                n.D(object0);
                if(uri0 != null) {
                    H h0 = s1.a;
                    String s3 = h0.a;
                    I.c.getClass();
                    String s4 = d.e(s3).a;
                    if(s4.length() == 0) {
                        s4 = s3;
                    }
                    String s5 = d.e(s3).b;
                    String s6 = h0.b;
                    String s7 = h0.c;
                    String s8 = h0.d;
                    if(s.length() == 6) {
                        String s10 = s.substring(2, 4);
                        q.f(s10, "substring(...)");
                        String s11 = s.substring(4, 6);
                        q.f(s11, "substring(...)");
                        s9 = x.l(s10, this.b.a(0x7F131105), " ", s11, this.b.a(0x7F1306AD));  // string:year "년"
                    }
                    else {
                        s9 = "";
                    }
                    SharableMusicDna sharableMusicDna0 = new SharableMusicDna();  // 初始化器: Ljava/lang/Object;-><init>()V
                    sharableMusicDna0.a = s5;
                    sharableMusicDna0.b = s4;
                    sharableMusicDna0.d = s6;
                    sharableMusicDna0.e = s6;
                    sharableMusicDna0.f = s6;
                    sharableMusicDna0.g = s6;
                    sharableMusicDna0.h = s6;
                    sharableMusicDna0.i = null;
                    sharableMusicDna0.j = null;
                    sharableMusicDna0.k = s7;
                    sharableMusicDna0.l = s8;
                    sharableMusicDna0.m = s9;
                    sharableMusicDna0.n = null;
                    sharableMusicDna0.o = null;
                    sharableMusicDna0.r = null;
                    sharableMusicDna0.w = h0.e;
                    String s12 = FileUtils.INSTANCE.getImageFilePathForUri(context0, uri0);
                    LogU.debug$default(this.c, "shareImage() - type: " + s4 + ", shareType: " + s5, null, false, 6, null);
                    if(s12 != null) {
                        Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(a0, null, null, new l(s12, this, sharableMusicDna0, s, null), 3, null);
                        k0.r = sharableMusicDna0;
                        k0.D = 1;
                        object0 = deferred0.await(k0);
                        if(object0 == a1) {
                            return a1;
                        }
                        sharableMusicDna1 = sharableMusicDna0;
                        goto label_65;
                    }
                    return new Na.d(new Exception("path is null"));
                }
                break;
            }
            case 1: {
                sharableMusicDna1 = k0.r;
                n.D(object0);
            label_65:
                if(((MusicDnaUploadRes)object0) != null) {
                    RESPONSE musicDnaUploadRes$RESPONSE0 = ((MusicDnaUploadRes)object0).getResponse();
                    if(musicDnaUploadRes$RESPONSE0 != null) {
                        String s13 = musicDnaUploadRes$RESPONSE0.getImgUrl();
                        if(s13 == null) {
                            s13 = "";
                        }
                        sharableMusicDna1.j = s13;
                        sharableMusicDna1.n = musicDnaUploadRes$RESPONSE0.getLongUrl() == null ? "" : musicDnaUploadRes$RESPONSE0.getLongUrl();
                        sharableMusicDna1.o = musicDnaUploadRes$RESPONSE0.getShortenUrl() == null ? "" : musicDnaUploadRes$RESPONSE0.getShortenUrl();
                        String s14 = musicDnaUploadRes$RESPONSE0.getPostImage();
                        if(s14 != null) {
                            s2 = s14;
                        }
                        try {
                            sharableMusicDna1.r = s2;
                            return new e(sharableMusicDna1);
                        }
                        catch(Exception exception0) {
                            return new Na.d(exception0);
                        }
                    }
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(new Exception("uri is null"));
    }
}

