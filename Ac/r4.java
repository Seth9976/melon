package Ac;

import Md.j;
import Pc.e;
import Ua.N;
import Ua.O;
import Ua.P;
import androidx.lifecycle.c0;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.HsUploadJsonRes;
import com.melon.net.res.v3.MediaAttachHelper.AttachAlbumData;
import com.melon.net.res.v3.MediaAttachHelper.AttachArtistData;
import com.melon.net.res.v3.MediaAttachHelper.AttachImageData;
import com.melon.net.res.v3.MediaAttachHelper.AttachKakaoEmoticonData;
import com.melon.net.res.v3.MediaAttachHelper.AttachLinkVideoData;
import com.melon.net.res.v3.MediaAttachHelper.AttachPropertyData;
import com.melon.net.res.v3.MediaAttachHelper.AttachSongData;
import com.melon.net.res.v3.MediaAttachHelper.AttachVideoData;
import com.melon.ui.K4;
import com.melon.ui.Q;
import com.melon.ui.U0;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.q4;
import com.melon.ui.s4;
import com.melon.ui.t4;
import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.o;
import ie.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import va.e0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"LAc/r4;", "Lcom/melon/ui/k1;", "", "Ac/o4", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class r4 extends k1 {
    public final g2 a;
    public final c0 b;
    public final N c;
    public final StringProviderImpl d;
    public final Q e;
    public final LogU f;
    public static final int g;

    public r4(c0 c00, N n0, StringProviderImpl stringProviderImpl0, Q q0) {
        q.g(c00, "savedState");
        super();
        this.a = new g2(n0);
        this.b = c00;
        this.c = n0;
        this.d = stringProviderImpl0;
        this.e = q0;
        LogU logU0 = new LogU("CommentWriteViewModel");
        logU0.setCategory(Category.UI);
        this.f = logU0;
    }

    public static K4 c(Object object0, r4 r40, K4 k40) {
        c0 c00 = r40.b;
        q.g(k40, "it");
        j4 j40 = new j4(new U0(null, null, 0x1F));
        if(object0 instanceof o) {
            object0 = j40;
        }
        if(((K4)object0) instanceof l4) {
            c00.b(((l4)(((K4)object0))).a, "key_cmt_input_text");
            List list0 = ((l4)(((K4)object0))).e;
            if(list0 == null) {
                list0 = w.a;
            }
            c00.b(list0, "key_cmt_attach_contents");
        }
        return (K4)object0;
    }

    public final int d() {
        Integer integer0 = (Integer)this.b.a("key_channel_seq");
        return integer0 == null ? -1 : ((int)integer0);
    }

    public final int e() {
        Integer integer0 = (Integer)this.b.a("key_cmt_seq");
        return integer0 == null ? -1 : ((int)integer0);
    }

    public final CommentConfig f() {
        return (CommentConfig)this.b.a("key_cmt_config");
    }

    public final String g() {
        String s = (String)this.b.a("key_content_ref_value");
        return s == null ? "" : s;
    }

    public final String h() {
        String s = (String)this.b.a("key_cmt_input_text");
        return s == null ? "" : s;
    }

    public final Object i(c c0) {
        String s19;
        List list11;
        Ua.Q q1;
        L0 l02;
        String s18;
        String s17;
        AttachPropertyData mediaAttachHelper$AttachPropertyData8;
        AttachPropertyData mediaAttachHelper$AttachPropertyData7;
        List list10;
        int v49;
        List list9;
        StringProviderImpl stringProviderImpl7;
        Collection collection4;
        AttachPropertyData mediaAttachHelper$AttachPropertyData6;
        int v46;
        int v45;
        int v44;
        int v43;
        int v42;
        StringProviderImpl stringProviderImpl6;
        Iterator iterator7;
        AttachImageData mediaAttachHelper$AttachImageData3;
        p4 p45;
        String s10;
        G1 g11;
        AttachPropertyData mediaAttachHelper$AttachPropertyData5;
        StringProviderImpl stringProviderImpl5;
        Serializable serializable2;
        List list8;
        Collection collection3;
        String s9;
        Iterator iterator6;
        int v37;
        List list6;
        Ua.Q q0;
        Object object4;
        int v26;
        int v25;
        Object object3;
        StringProviderImpl stringProviderImpl4;
        String s3;
        AttachPropertyData mediaAttachHelper$AttachPropertyData3;
        AttachPropertyData mediaAttachHelper$AttachPropertyData2;
        AttachImageData mediaAttachHelper$AttachImageData1;
        Iterator iterator4;
        int v16;
        int v15;
        int v14;
        int v13;
        int v12;
        Collection collection1;
        com.melon.ui.p4 p43;
        c0 c01;
        int v11;
        List list2;
        int v10;
        Iterator iterator1;
        L0 l01;
        StringProviderImpl stringProviderImpl1;
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        Collection collection0;
        com.melon.ui.p4 p42;
        List list1;
        int v4;
        Iterator iterator0;
        int v3;
        String s;
        List list0;
        p4 p40;
        if(c0 instanceof p4) {
            p40 = (p4)c0;
            int v = p40.Z;
            if((v & 0x80000000) == 0) {
                p40 = new p4(this, c0);
            }
            else {
                p40.Z = v ^ 0x80000000;
            }
        }
        else {
            p40 = new p4(this, c0);
        }
        Object object0 = p40.X;
        a a0 = a.a;
        c0 c00 = this.b;
        com.melon.ui.p4 p41 = com.melon.ui.p4.a;
        G1 g10 = G1.a;
        N n0 = this.c;
        H h0 = H.a;
        StringProviderImpl stringProviderImpl0 = this.d;
        switch(p40.Z) {
            case 0: {
                n.D(object0);
                CommentConfig commentConfig0 = this.f();
                if(commentConfig0 == null) {
                    return h0;
                }
                if(!((e0)va.o.a()).m()) {
                    this.sendUiEvent(s4.a);
                    return h0;
                }
                int v1 = Tf.o.e1(this.h()).toString().length();
                int v2 = commentConfig0.getWriteMinLength() <= 0 ? 3 : commentConfig0.getWriteMinLength();
                if(v1 < v2) {
                    this.sendUiEvent(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.b(0x7F13084C, new Object[]{new Integer(v2)}), null, null));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                Object object1 = this.getUiState().getValue();
                l4 l40 = object1 instanceof l4 ? ((l4)object1) : null;
                if(l40 == null) {
                    list0 = w.a;
                }
                else {
                    list0 = l40.e;
                    if(list0 == null) {
                        list0 = w.a;
                    }
                }
                L0 l00 = this.getProgressUpdater();
                s = "CommentWriteViewModel";
                if(l00 == null) {
                    ArrayList arrayList0 = new ArrayList();
                    v3 = v2;
                    iterator0 = list0.iterator();
                    v4 = v1;
                    list1 = list0;
                    p42 = p41;
                    collection0 = arrayList0;
                    v5 = 0;
                    v6 = 0;
                    v7 = 0;
                    v8 = 0;
                    v9 = 0;
                    goto label_119;
                }
                stringProviderImpl1 = stringProviderImpl0;
                l00.a("CommentWriteViewModel true", true);
                try {
                    ArrayList arrayList1 = new ArrayList();
                    l01 = l00;
                    iterator1 = list0.iterator();
                    v10 = v1;
                    l01 = l00;
                    list2 = list0;
                    v11 = v2;
                    c01 = c00;
                    p43 = p41;
                    collection1 = arrayList1;
                    v12 = 0;
                    v13 = 0;
                    v14 = 0;
                    v15 = 0;
                    v16 = 0;
                    goto label_342;
                }
                catch(Throwable throwable0) {
                    s10 = s;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
            }
            case 1: {
                int v17 = p40.V;
                int v18 = p40.T;
                v5 = p40.S;
                int v19 = p40.N;
                int v20 = p40.M;
                int v21 = p40.W;
                int v22 = p40.I;
                AttachImageData mediaAttachHelper$AttachImageData0 = p40.G;
                Iterator iterator2 = p40.E;
                Collection collection2 = p40.D;
                List list3 = p40.r;
                n.D(object0);
                Serializable serializable0 = ((p)object0).a;
                AttachPropertyData mediaAttachHelper$AttachPropertyData0 = mediaAttachHelper$AttachImageData0;
                c0 c02 = c00;
                p4 p44 = p40;
                Iterator iterator3 = iterator2;
                int v23 = v20;
                v8 = v19;
                v7 = v18;
                v4 = v22;
                v9 = v17;
                p42 = p41;
                StringProviderImpl stringProviderImpl2 = stringProviderImpl0;
                v6 = v21;
                collection0 = collection2;
                list1 = list3;
                while(!(serializable0 instanceof o)) {
                    this.sendUiEvent(g10);
                    if(serializable0 instanceof o) {
                        serializable0 = null;
                    }
                    if(((HsUploadJsonRes)serializable0) == null) {
                        iterator4 = iterator3;
                        mediaAttachHelper$AttachImageData1 = null;
                    }
                    else {
                        iterator4 = iterator3;
                        mediaAttachHelper$AttachImageData1 = AttachImageData.copy$default(((AttachImageData)mediaAttachHelper$AttachPropertyData0), null, "null/", 1, null);
                    }
                    AttachPropertyData mediaAttachHelper$AttachPropertyData1 = mediaAttachHelper$AttachImageData1;
                    p40 = p44;
                    v3 = v23;
                    iterator0 = iterator4;
                    StringProviderImpl stringProviderImpl3 = stringProviderImpl2;
                    while(true) {
                        if(mediaAttachHelper$AttachPropertyData1 != null) {
                            collection0.add(mediaAttachHelper$AttachPropertyData1);
                        }
                        c00 = c02;
                        stringProviderImpl0 = stringProviderImpl3;
                    label_119:
                        if(!iterator0.hasNext()) {
                            goto label_161;
                        }
                        Object object2 = iterator0.next();
                        mediaAttachHelper$AttachPropertyData2 = (AttachPropertyData)object2;
                        c02 = c00;
                        if(mediaAttachHelper$AttachPropertyData2 instanceof AttachImageData && ((AttachImageData)mediaAttachHelper$AttachPropertyData2).getOriginalUrl().length() == 0) {
                            break;
                        }
                        stringProviderImpl3 = stringProviderImpl0;
                        mediaAttachHelper$AttachPropertyData1 = mediaAttachHelper$AttachPropertyData2;
                    }
                    String s1 = ((AttachImageData)mediaAttachHelper$AttachPropertyData2).getThumbUrl();
                    CommentConfig commentConfig1 = this.f();
                    if(commentConfig1 == null) {
                        mediaAttachHelper$AttachPropertyData3 = mediaAttachHelper$AttachPropertyData2;
                        s3 = "";
                    }
                    else {
                        String s2 = commentConfig1.getCmtImageUploadDomain();
                        if(s2 != null) {
                            mediaAttachHelper$AttachPropertyData3 = mediaAttachHelper$AttachPropertyData2;
                            s3 = s2;
                        }
                    }
                    p40.getClass();
                    stringProviderImpl2 = stringProviderImpl0;
                    p40.r = list1;
                    p40.w = null;
                    p40.B = null;
                    p40.D = collection0;
                    p40.E = iterator0;
                    p40.G = (AttachImageData)mediaAttachHelper$AttachPropertyData3;
                    p40.I = v4;
                    p40.M = v3;
                    p40.N = v8;
                    p40.S = v5;
                    p40.T = v7;
                    p40.V = v9;
                    p40.W = v6;
                    p40.Z = 1;
                    Serializable serializable1 = n0.t(s1, s3, p40);
                    if(serializable1 == a0) {
                        return a0;
                    }
                    serializable0 = serializable1;
                    v23 = v3;
                    p44 = p40;
                    iterator3 = iterator0;
                    mediaAttachHelper$AttachPropertyData0 = mediaAttachHelper$AttachPropertyData3;
                    continue;
                label_161:
                    stringProviderImpl4 = stringProviderImpl0;
                    o4 o40 = (o4)c00.a("key_cmt_mode");
                    if(o40 == null) {
                        o40 = o4.a;
                    }
                    if(o40 == o4.a) {
                        int v24 = this.d();
                        String s4 = this.g();
                        String s5 = Tf.o.e1(this.h()).toString();
                        p40.getClass();
                        p40.r = list1;
                        p40.w = null;
                        p40.B = null;
                        p40.D = null;
                        p40.E = null;
                        p40.G = null;
                        p40.I = v4;
                        p40.M = v3;
                        p40.N = v8;
                        p40.S = v5;
                        p40.Z = 2;
                        object3 = this.c.m(v24, s4, s5, ((List)collection0), p40);
                        if(object3 == a0) {
                            return a0;
                        }
                        v25 = v3;
                        v26 = v8;
                        q0 = (Ua.Q)object3;
                    }
                    else {
                        int v27 = this.d();
                        String s6 = this.g();
                        int v28 = this.e();
                        String s7 = Tf.o.e1(this.h()).toString();
                        p40.getClass();
                        p40.r = list1;
                        p40.w = null;
                        p40.B = null;
                        p40.D = null;
                        p40.E = null;
                        p40.G = null;
                        p40.I = v4;
                        p40.M = v3;
                        p40.N = v8;
                        p40.S = v5;
                        p40.Z = 3;
                        object4 = this.c.s(v27, s6, v28, s7, ((List)collection0), p40);
                        if(object4 == a0) {
                            return a0;
                        }
                        v25 = v3;
                        v26 = v8;
                        goto label_237;
                    }
                    goto label_238;
                }
                this.sendUiEvent(new t4(stringProviderImpl2.a(0x7F1301EA)));  // string:cmt_photo_upload_fail "이미지를 첨부하는데 문제가 발생하였습니다."
                return h0;
            }
            case 2: {
                int v29 = p40.S;
                v26 = p40.N;
                int v30 = p40.M;
                int v31 = p40.I;
                List list4 = p40.r;
                n.D(object0);
                v5 = v29;
                list1 = list4;
                p42 = p41;
                object3 = object0;
                v4 = v31;
                v25 = v30;
                stringProviderImpl4 = stringProviderImpl0;
                q0 = (Ua.Q)object3;
                goto label_238;
            }
            case 3: {
                int v32 = p40.S;
                v26 = p40.N;
                int v33 = p40.M;
                int v34 = p40.I;
                List list5 = p40.r;
                n.D(object0);
                v5 = v32;
                list1 = list5;
                p42 = p41;
                object4 = object0;
                v4 = v34;
                v25 = v33;
                stringProviderImpl4 = stringProviderImpl0;
            label_237:
                q0 = (Ua.Q)object4;
            label_238:
                if(q0 instanceof P) {
                    if(((CharSequence)((P)q0).a).length() > 0) {
                        this.sendUiEvent(new q4(28, stringProviderImpl4.a(0x7F1300D0), ((String)((P)q0).a), null, null));  // string:alert_dlg_title_info "안내"
                    }
                    else {
                        this.sendUiEvent(new t4(stringProviderImpl4.a(0x7F1301F2)));  // string:cmt_write_success "등록되었습니다."
                    }
                    R3 r30 = new R3(this.d(), this.g(), true);
                    p40.r = list1;
                    p40.w = null;
                    p40.B = null;
                    p40.I = v4;
                    p40.M = v25;
                    p40.N = v26;
                    p40.S = v5;
                    p40.Z = 4;
                    if(j.a(r30, p40) == a0) {
                        return a0;
                    }
                    list6 = list1;
                    goto label_265;
                }
                if(!(q0 instanceof O)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s8 = ((O)q0).b;
                if(s8 == null) {
                    s8 = stringProviderImpl4.a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
                this.sendUiEvent(new t4(s8));
                return h0;
            }
            case 4: {
                list6 = p40.r;
                n.D(object0);
                p42 = p41;
            label_265:
                this.sendUiEvent(new A1(new R3(this.d(), this.g(), true)));
                for(Object object5: list6) {
                    AttachPropertyData mediaAttachHelper$AttachPropertyData4 = (AttachPropertyData)object5;
                    if(mediaAttachHelper$AttachPropertyData4 instanceof AttachKakaoEmoticonData) {
                        EmoticonViewParam emoticonViewParam0 = EmoticonViewParam.get(((AttachKakaoEmoticonData)mediaAttachHelper$AttachPropertyData4).getKakaoEmoticonParam());
                        if(emoticonViewParam0 != null) {
                            KakaoEmoticon.pushLog(emoticonViewParam0);
                        }
                    }
                }
                this.sendUiEvent(p42);
                return h0;
            }
            case 5: {
                try {
                    int v35 = p40.W;
                    int v36 = p40.V;
                    v37 = p40.T;
                    int v38 = p40.S;
                    int v39 = p40.N;
                    int v40 = p40.M;
                    int v41 = p40.I;
                    AttachImageData mediaAttachHelper$AttachImageData2 = p40.G;
                    iterator6 = p40.E;
                    s9 = p40.B;
                    l01 = p40.w;
                    collection3 = p40.D;
                    List list7 = p40.r;
                    n.D(object0);
                    list8 = list7;
                    c01 = c00;
                    v12 = v36;
                    v10 = v41;
                    serializable2 = ((p)object0).a;
                    v13 = v38;
                    p43 = p41;
                    stringProviderImpl5 = stringProviderImpl0;
                    v16 = v39;
                    v11 = v40;
                    mediaAttachHelper$AttachPropertyData5 = mediaAttachHelper$AttachImageData2;
                    v14 = v35;
                    g11 = g10;
                }
                catch(Throwable throwable0) {
                    s10 = s9;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
                try {
                    while(true) {
                    label_308:
                        if(serializable2 instanceof o) {
                            goto label_440;
                        }
                        g10 = g11;
                        this.sendUiEvent(g10);
                        if(serializable2 instanceof o) {
                            serializable2 = null;
                        }
                        if(((HsUploadJsonRes)serializable2) == null) {
                            p45 = p40;
                            mediaAttachHelper$AttachImageData3 = null;
                        }
                        else {
                            p45 = p40;
                            mediaAttachHelper$AttachImageData3 = AttachImageData.copy$default(((AttachImageData)mediaAttachHelper$AttachPropertyData5), null, "null/", 1, null);
                        }
                        v15 = v37;
                        p40 = p45;
                        iterator7 = iterator6;
                        list2 = list8;
                        stringProviderImpl6 = stringProviderImpl5;
                        v42 = v10;
                        v43 = v14;
                        v44 = v11;
                        v45 = v13;
                        v46 = v12;
                        mediaAttachHelper$AttachPropertyData6 = mediaAttachHelper$AttachImageData3;
                        collection4 = collection3;
                    label_331:
                        if(mediaAttachHelper$AttachPropertyData6 != null) {
                            collection4.add(mediaAttachHelper$AttachPropertyData6);
                        }
                        collection1 = collection4;
                        iterator1 = iterator7;
                        stringProviderImpl1 = stringProviderImpl6;
                        v12 = v46;
                        v13 = v45;
                        v11 = v44;
                        v14 = v43;
                        v10 = v42;
                        s = s9;
                        break;
                    }
                }
                catch(Throwable throwable0) {
                    s10 = s9;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_342:
                    if(!iterator1.hasNext()) {
                        stringProviderImpl7 = stringProviderImpl1;
                        list9 = (List)collection1;
                        o4 o41 = (o4)c01.a("key_cmt_mode");
                        if(o41 == null) {
                            o41 = o4.a;
                        }
                        if(o41 != o4.a) {
                            int v47 = this.d();
                            String s11 = this.g();
                            int v48 = this.e();
                            String s12 = Tf.o.e1(this.h()).toString();
                            p40.getClass();
                            p40.r = list2;
                            p40.w = l01;
                            p40.B = s;
                            p40.D = null;
                            p40.E = null;
                            p40.G = null;
                            p40.I = v10;
                            p40.M = v11;
                            p40.N = v16;
                            p40.S = v13;
                            p40.Z = 7;
                            object0 = this.c.s(v47, s11, v48, s12, list9, p40);
                            if(object0 == a0) {
                                return a0;
                            }
                            v49 = v11;
                            list10 = list2;
                            goto label_482;
                        }
                        goto label_370;
                    }
                    goto label_390;
                }
                catch(Throwable throwable0) {
                    s10 = s;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_370:
                    int v50 = this.d();
                    String s13 = this.g();
                    String s14 = Tf.o.e1(this.h()).toString();
                    p40.getClass();
                    p40.r = list2;
                    p40.w = l01;
                    p40.B = s;
                    p40.D = null;
                    p40.E = null;
                    p40.G = null;
                    p40.I = v10;
                    p40.M = v11;
                    p40.N = v16;
                    p40.S = v13;
                    p40.Z = 6;
                    object0 = this.c.m(v50, s13, s14, list9, p40);
                    if(object0 == a0) {
                        return a0;
                    }
                    v49 = v11;
                    list10 = list2;
                    q1 = (Ua.Q)object0;
                    goto label_483;
                label_390:
                    Object object6 = iterator1.next();
                    stringProviderImpl5 = stringProviderImpl1;
                    mediaAttachHelper$AttachPropertyData7 = (AttachPropertyData)object6;
                    if(!(mediaAttachHelper$AttachPropertyData7 instanceof AttachImageData) || ((AttachImageData)mediaAttachHelper$AttachPropertyData7).getOriginalUrl().length() != 0) {
                        goto label_429;
                    }
                    String s15 = ((AttachImageData)mediaAttachHelper$AttachPropertyData7).getThumbUrl();
                    CommentConfig commentConfig2 = this.f();
                    if(commentConfig2 == null) {
                        mediaAttachHelper$AttachPropertyData8 = mediaAttachHelper$AttachPropertyData7;
                        s17 = "";
                    }
                    else {
                        String s16 = commentConfig2.getCmtImageUploadDomain();
                        if(s16 != null) {
                            mediaAttachHelper$AttachPropertyData8 = mediaAttachHelper$AttachPropertyData7;
                            s17 = s16;
                        }
                    }
                    p40.getClass();
                    g11 = g10;
                    p40.r = list2;
                    p40.w = l01;
                    p40.B = s;
                    p40.D = collection1;
                    p40.E = iterator1;
                    p40.G = (AttachImageData)mediaAttachHelper$AttachPropertyData8;
                    p40.I = v10;
                    p40.M = v11;
                    p40.N = v16;
                    p40.S = v13;
                    p40.T = v15;
                    p40.V = v12;
                    p40.W = v14;
                    p40.Z = 5;
                    serializable2 = n0.t(s15, s17, p40);
                    if(serializable2 == a0) {
                        return a0;
                    }
                    iterator6 = iterator1;
                    mediaAttachHelper$AttachPropertyData5 = mediaAttachHelper$AttachPropertyData8;
                    s9 = s;
                    v37 = v15;
                    list8 = list2;
                    collection3 = collection1;
                    goto label_308;
                }
                catch(Throwable throwable0) {
                    s10 = s;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_429:
                    stringProviderImpl6 = stringProviderImpl5;
                    iterator7 = iterator1;
                    collection4 = collection1;
                    s9 = s;
                    v42 = v10;
                    v43 = v14;
                    v44 = v11;
                    v45 = v13;
                    v46 = v12;
                    mediaAttachHelper$AttachPropertyData6 = mediaAttachHelper$AttachPropertyData7;
                    goto label_331;
                label_440:
                    this.sendUiEvent(new t4(stringProviderImpl5.a(0x7F1301EA)));  // string:cmt_photo_upload_fail "이미지를 첨부하는데 문제가 발생하였습니다."
                    break;
                }
                catch(Throwable throwable0) {
                    s10 = s9;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
            }
            case 6: {
                try {
                    int v51 = p40.S;
                    int v52 = p40.N;
                    v49 = p40.M;
                    int v53 = p40.I;
                    s18 = p40.B;
                    l02 = p40.w;
                    list10 = p40.r;
                    n.D(object0);
                    stringProviderImpl7 = stringProviderImpl0;
                    v16 = v52;
                    p43 = p41;
                    v10 = v53;
                    s = s18;
                    v13 = v51;
                    l01 = l02;
                }
                catch(Throwable throwable0) {
                    s10 = s18;
                    l01 = l02;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
                try {
                    q1 = (Ua.Q)object0;
                    goto label_483;
                }
                catch(Throwable throwable0) {
                    s10 = s;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
            }
            case 7: {
                try {
                    int v54 = p40.S;
                    int v55 = p40.N;
                    v49 = p40.M;
                    int v56 = p40.I;
                    s18 = p40.B;
                    l02 = p40.w;
                    list10 = p40.r;
                    n.D(object0);
                    stringProviderImpl7 = stringProviderImpl0;
                    v16 = v55;
                    p43 = p41;
                    v10 = v56;
                    s = s18;
                    v13 = v54;
                    l01 = l02;
                }
                catch(Throwable throwable0) {
                    s10 = s18;
                    l01 = l02;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_482:
                    q1 = (Ua.Q)object0;
                }
                catch(Throwable throwable0) {
                    s10 = s;
                    Y.v(s10, " false", l01, false);
                    throw throwable0;
                }
            label_483:
                if(q1 instanceof P) {
                    try {
                        if(((CharSequence)((P)q1).a).length() > 0) {
                            this.sendUiEvent(new q4(28, stringProviderImpl7.a(0x7F1300D0), ((String)((P)q1).a), null, null));  // string:alert_dlg_title_info "안내"
                        }
                        else {
                            this.sendUiEvent(new t4(stringProviderImpl7.a(0x7F1301F2)));  // string:cmt_write_success "등록되었습니다."
                        }
                        R3 r31 = new R3(this.d(), this.g(), true);
                        p40.r = list10;
                        p40.w = l01;
                        p40.B = s;
                        p40.I = v10;
                        p40.M = v49;
                        p40.N = v16;
                        p40.S = v13;
                        p40.Z = 8;
                        if(j.a(r31, p40) == a0) {
                            return a0;
                        }
                        s10 = s;
                        list11 = list10;
                        goto label_522;
                    }
                    catch(Throwable throwable0) {
                        s10 = s;
                        Y.v(s10, " false", l01, false);
                        throw throwable0;
                    }
                }
                else {
                    try {
                        if(!(q1 instanceof O)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        s19 = ((O)q1).b;
                        if(s19 == null) {
                            goto label_506;
                        }
                        goto label_511;
                    }
                    catch(Throwable throwable0) {
                        s10 = s;
                        Y.v(s10, " false", l01, false);
                        throw throwable0;
                    }
                    try {
                    label_506:
                        s19 = stringProviderImpl7.a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    }
                    catch(Throwable throwable0) {
                        s10 = s;
                        Y.v(s10, " false", l01, false);
                        throw throwable0;
                    }
                    try {
                    label_511:
                        this.sendUiEvent(new t4(s19));
                        s9 = s;
                    }
                    catch(Throwable throwable0) {
                        s10 = s;
                        Y.v(s10, " false", l01, false);
                        throw throwable0;
                    }
                }
                break;
            }
            case 8: {
                try {
                    s10 = p40.B;
                    l01 = p40.w;
                    list11 = p40.r;
                    n.D(object0);
                    p43 = p41;
                label_522:
                    this.sendUiEvent(new A1(new R3(this.d(), this.g(), true)));
                    for(Object object7: list11) {
                        AttachPropertyData mediaAttachHelper$AttachPropertyData9 = (AttachPropertyData)object7;
                        if(mediaAttachHelper$AttachPropertyData9 instanceof AttachKakaoEmoticonData) {
                            EmoticonViewParam emoticonViewParam1 = EmoticonViewParam.get(((AttachKakaoEmoticonData)mediaAttachHelper$AttachPropertyData9).getKakaoEmoticonParam());
                            if(emoticonViewParam1 != null) {
                                KakaoEmoticon.pushLog(emoticonViewParam1);
                            }
                        }
                    }
                    this.sendUiEvent(p43);
                    s9 = s10;
                    break;
                }
                catch(Throwable throwable0) {
                }
                Y.v(s10, " false", l01, false);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Y.v(s9, " false", l01, false);
        return h0;
    }

    public final void j(ActionKind actionKind0, String s, String s1, String s2) {
        q.g(actionKind0, "actionKind");
        E9.w.G(this.getTiaraProperty(), this.f(), this.d, s, actionKind0, s1, s2, false, null, null, null);
    }

    public final void k(AttachPropertyData mediaAttachHelper$AttachPropertyData0) {
        ArrayList arrayList0 = new ArrayList();
        if(mediaAttachHelper$AttachPropertyData0 instanceof AttachSongData) {
            LogU.debug$default(this.f, "updateAttachList: Song", null, false, 6, null);
            arrayList0.add(mediaAttachHelper$AttachPropertyData0);
        }
        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachAlbumData) {
            LogU.debug$default(this.f, "updateAttachList: Album", null, false, 6, null);
            arrayList0.add(mediaAttachHelper$AttachPropertyData0);
        }
        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachArtistData) {
            LogU.debug$default(this.f, "updateAttachList: Artist", null, false, 6, null);
            arrayList0.add(mediaAttachHelper$AttachPropertyData0);
        }
        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachVideoData) {
            LogU.debug$default(this.f, "updateAttachList: Video", null, false, 6, null);
            arrayList0.add(mediaAttachHelper$AttachPropertyData0);
        }
        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkVideoData) {
            LogU.debug$default(this.f, "updateAttachList: LinkVideo", null, false, 6, null);
            arrayList0.add(mediaAttachHelper$AttachPropertyData0);
        }
        this.b.b(arrayList0, "key_cmt_attach_contents");
        this.sendUiEvent(new t4(this.d.a(0x7F1301D9)));  // string:cmt_attachment_add_message "첨부 되었습니다."
        this.updateUiState(new b0(5, arrayList0));
    }

    public final void l(List list0) {
        LogU.debug$default(this.f, "updateAttachList: " + list0, null, false, 6, null);
        ArrayList arrayList0 = new ArrayList();
        Iterator iterator0 = list0.iterator();
        while(iterator0.hasNext()) {
            String s = "";
            Object object0 = iterator0.next();
            MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)object0;
            LogU.debug$default(this.f, "updateAttachList: " + mediaAttachInfo0.a, null, false, 6, null);
            MediaAttachType mediaAttachType0 = mediaAttachInfo0.a;
            if(q.b(mediaAttachType0, MediaAttachType.c)) {
                LogU.debug$default(this.f, "updateAttachList: SONG", null, false, 6, null);
                int v = mediaAttachInfo0.e;
                String s1 = mediaAttachInfo0.j;
                q.f(s1, "song");
                int v1 = mediaAttachInfo0.c;
                String s2 = mediaAttachInfo0.i;
                q.f(s2, "album");
                String s3 = mediaAttachInfo0.g;
                q.f(s3, "thumbnail");
                String s4 = mediaAttachInfo0.k;
                q.f(s4, "artist");
                int v2 = mediaAttachInfo0.d;
                String s5 = mediaAttachInfo0.B;
                q.f(s5, "issueDate");
                arrayList0.add(new AttachSongData(v, s1, v1, s2, s3, v2, s4, s5, ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.I)), ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.M)), ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.N)), !mediaAttachInfo0.Y));
            }
            else if(q.b(mediaAttachType0, MediaAttachType.g) || q.b(mediaAttachType0, MediaAttachType.f)) {
                LogU.debug$default(this.f, "updateAttachList: IMAGE", null, false, 6, null);
                String s23 = mediaAttachInfo0.g == null ? "" : mediaAttachInfo0.g;
                String s24 = mediaAttachInfo0.h;
                if(s24 != null) {
                    s = s24;
                }
                arrayList0.add(new AttachImageData(s23, s));
            }
            else if(q.b(mediaAttachType0, MediaAttachType.d)) {
                int v3 = mediaAttachInfo0.c;
                String s6 = mediaAttachInfo0.i;
                q.f(s6, "album");
                String s7 = mediaAttachInfo0.g;
                q.f(s7, "thumbnail");
                int v4 = mediaAttachInfo0.d;
                String s8 = mediaAttachInfo0.k;
                q.f(s8, "artist");
                String s9 = mediaAttachInfo0.B;
                q.f(s9, "issueDate");
                arrayList0.add(new AttachAlbumData(v3, s6, s7, v4, s8, s9, !mediaAttachInfo0.Y));
            }
            else if(q.b(mediaAttachType0, MediaAttachType.e)) {
                int v5 = mediaAttachInfo0.d;
                String s10 = mediaAttachInfo0.k;
                q.f(s10, "artist");
                String s11 = mediaAttachInfo0.g;
                q.f(s11, "thumbnail");
                String s12 = mediaAttachInfo0.l == null ? "" : mediaAttachInfo0.l;
                String s13 = mediaAttachInfo0.m;
                q.f(s13, "nationality");
                String s14 = mediaAttachInfo0.n;
                q.f(s14, "actType");
                String s15 = mediaAttachInfo0.o;
                q.f(s15, "sex");
                String s16 = mediaAttachInfo0.r;
                q.f(s16, "genre");
                arrayList0.add(new AttachArtistData(v5, s10, s11, s12, s13, s14, s15, s16, mediaAttachInfo0.w));
            }
            else if(q.b(mediaAttachType0, MediaAttachType.h)) {
                int v6 = mediaAttachInfo0.f;
                String s17 = mediaAttachInfo0.E;
                q.f(s17, "mvTitle");
                String s18 = mediaAttachInfo0.g == null ? "" : mediaAttachInfo0.g;
                String s19 = mediaAttachInfo0.B;
                q.f(s19, "issueDate");
                String s20 = mediaAttachInfo0.D;
                q.f(s20, "playtime");
                int v7 = mediaAttachInfo0.e;
                int v8 = mediaAttachInfo0.c;
                int v9 = mediaAttachInfo0.d;
                String s21 = mediaAttachInfo0.k;
                q.f(s21, "artist");
                arrayList0.add(new AttachVideoData(v6, s17, s18, s19, s20, v7, v8, v9, s21, mediaAttachInfo0.G, ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.I)), ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.M)), ProtocolUtils.parseBoolean(String.valueOf(mediaAttachInfo0.N)), (mediaAttachInfo0.S == null ? "" : mediaAttachInfo0.S)));
            }
            else {
                if(!q.b(mediaAttachType0, MediaAttachType.j)) {
                    continue;
                }
                String s22 = mediaAttachInfo0.X;
                q.f(s22, "kakaoEmoticonParam");
                arrayList0.add(new AttachKakaoEmoticonData(s22));
            }
        }
        this.b.b(arrayList0, "key_cmt_attach_contents");
        this.sendUiEvent(new t4(this.d.a(0x7F1301D9)));  // string:cmt_attachment_add_message "첨부 되었습니다."
        this.updateUiState(new b0(6, arrayList0));
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        String s2;
        L0 l01;
        Object object2;
        Object object1;
        Ac.q4 q40;
        if(continuation0 instanceof Ac.q4) {
            q40 = (Ac.q4)continuation0;
            int v = q40.E;
            if((v & 0x80000000) == 0) {
                q40 = new Ac.q4(this, ((c)continuation0));
            }
            else {
                q40.E = v ^ 0x80000000;
            }
        }
        else {
            q40 = new Ac.q4(this, ((c)continuation0));
        }
        Object object0 = q40.B;
        a a0 = a.a;
        StringProviderImpl stringProviderImpl0 = this.d;
        H h0 = H.a;
        switch(q40.E) {
            case 0: {
                n.D(object0);
                CommentConfig commentConfig0 = this.f();
                LogU.debug$default(this.f, "onFetchStart: " + commentConfig0, null, false, 6, null);
                if(this.f() == null) {
                    LogU.error$default(this.f, "commentConfig is null", null, false, 6, null);
                    return h0;
                }
                CommentConfig commentConfig1 = this.f();
                q.e(commentConfig1, "null cannot be cast to non-null type com.melon.net.res.v3.CommentConfig");
                o4 o40 = (o4)this.b.a("key_cmt_mode");
                if(o40 == null) {
                    o40 = o4.a;
                }
                if(o40 == o4.a) {
                    this.updateUiState(new D(12, this, commentConfig1));
                    return h0;
                }
                L0 l00 = this.getProgressUpdater();
                if(l00 == null) {
                    int v1 = this.d();
                    String s = this.g();
                    int v2 = this.e();
                    q40.r = null;
                    q40.w = null;
                    q40.E = 1;
                    object1 = this.c.e(v1, s, v2, commentConfig1, q40);
                    if(object1 == a0) {
                        return a0;
                    }
                    goto label_60;
                }
                l00.a("CommentWriteViewModel true", true);
                try {
                    int v3 = this.d();
                    String s1 = this.g();
                    int v4 = this.e();
                    q40.r = l00;
                    q40.w = "CommentWriteViewModel";
                    q40.E = 2;
                    object2 = this.c.e(v3, s1, v4, commentConfig1, q40);
                }
                catch(Throwable throwable0) {
                    l01 = l00;
                    s2 = "CommentWriteViewModel";
                    break;
                }
                if(object2 == a0) {
                    return a0;
                }
                l01 = l00;
                s2 = "CommentWriteViewModel";
                goto label_69;
            }
            case 1: {
                n.D(object0);
                object1 = ((p)object0).a;
            label_60:
                if(!(object1 instanceof o)) {
                    this.updateUiState(new D(13, object1, this));
                    return h0;
                }
                this.sendUiEvent(new t4(stringProviderImpl0.a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return h0;
            }
            case 2: {
                try {
                    s2 = q40.w;
                    l01 = q40.r;
                    n.D(object0);
                    object2 = ((p)object0).a;
                label_69:
                    if(object2 instanceof o) {
                        this.sendUiEvent(new t4(stringProviderImpl0.a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    }
                    else {
                        this.updateUiState(new D(13, object2, this));
                    }
                    goto label_77;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Y.v(s2, " false", l01, false);
        throw throwable0;
    label_77:
        Y.v(s2, " false", l01, false);
        return h0;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof C1) {
            boolean z = ((e0)va.o.a()).m();
            T2.a a0 = f0.h(this);
            o2 o20 = new o2(1, this, r4.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 21);
            n4 n40 = new n4(this, 1);
            W.p p0 = new W.p();  // 初始化器: Ljava/lang/Object;-><init>()V
            p0.a = this.getTiaraProperty();
            p0.b = this.d.a(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
            q.g(this.d, "stringProvider");
            q.g(this.e, "addPlayUserEventHelper");
            this.a.e(e0, z, this.d, this.e, null, a0, o20, n40, p0);
            return;
        }
        super.onUserEvent(e0);
    }
}

