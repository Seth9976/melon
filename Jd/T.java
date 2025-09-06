package jd;

import Ba.B;
import N9.a;
import N9.d;
import O9.c;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.MusicWaveChatSyncRes.ArtistCmt;
import com.melon.net.res.MusicWaveChatSyncRes.Cmt;
import com.melon.net.res.MusicWaveChatSyncRes.ImageInfo;
import com.melon.net.res.MusicWaveChatSyncRes.Notice;
import com.melon.net.res.MusicWaveChatSyncRes.ReloadInfo;
import com.melon.net.res.MusicWaveChatSyncRes.Response;
import com.melon.net.res.MusicWaveChatSyncRes;
import d5.n;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public final class t implements a {
    public final B a;
    public String b;
    public String c;
    public String d;

    public t(B b0) {
        q.g(b0, "api");
        super();
        this.a = b0;
        this.d = "";
    }

    public final Object a(c c0, oe.c c1) {
        String s25;
        String s24;
        String s23;
        String s22;
        String s21;
        String s20;
        G2 g20;
        ArrayList arrayList2;
        w w1;
        s s0;
        if(c1 instanceof s) {
            s0 = (s)c1;
            int v = s0.B;
            if((v & 0x80000000) == 0) {
                s0 = new s(this, c1);
            }
            else {
                s0.B = v ^ 0x80000000;
            }
        }
        else {
            s0 = new s(this, c1);
        }
        Object object0 = s0.r;
        ne.a a0 = ne.a.a;
        String s1 = null;
        switch(s0.B) {
            case 0: {
                n.D(object0);
                if(this.d.length() == 0 || c0 == null) {
                    this.d = "1757130017";
                }
                String s2 = this.b;
                if(s2 == null) {
                    q.m("type");
                    throw null;
                }
                String s3 = this.c;
                if(s3 == null) {
                    q.m("id");
                    throw null;
                }
                s0.B = 1;
                object0 = this.a.q(s2, s3, (c0 == null ? null : c0.b), (c0 == null ? null : c0.a), this.d, s0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MusicWaveChatSyncRes musicWaveChatSyncRes0 = (MusicWaveChatSyncRes)ApiResultKt.getOrThrow(((ApiResult)object0));
        Response musicWaveChatSyncRes$Response0 = musicWaveChatSyncRes0.getResponse();
        w w0 = w.a;
        String s4 = "";
        if(musicWaveChatSyncRes$Response0 == null) {
            w1 = w0;
        }
        else {
            List list0 = musicWaveChatSyncRes$Response0.getCmtList();
            if(list0 == null) {
                w1 = w0;
            }
            else {
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                for(Object object1: list0) {
                    String s5 = ((Cmt)object1).getCmtSeq();
                    String s6 = ((Cmt)object1).getCmtSeq() + "_" + System.currentTimeMillis();
                    String s7 = ((Cmt)object1).getMemberKey();
                    String s8 = ((Cmt)object1).getComment();
                    String s9 = ((Cmt)object1).getMessageType();
                    if(s9 == null) {
                        s9 = "user";
                    }
                    String s10 = ((Cmt)object1).getImageUrl();
                    String s11 = ((Cmt)object1).getName();
                    Boolean boolean0 = ((Cmt)object1).getTempActFlag();
                    arrayList0.add(new x2(s6, (s7 == null ? "" : s7), (s8 == null ? "" : s8), s9, (s5 == null ? "" : s5), s10, s11, null, null, (boolean0 == null ? false : boolean0.booleanValue()), 0x100));
                }
                w1 = arrayList0;
            }
        }
        Response musicWaveChatSyncRes$Response1 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response1 != null) {
            List list1 = musicWaveChatSyncRes$Response1.getArtistCmtList();
            if(list1 != null) {
                w0 = new ArrayList(je.q.Q(10, list1));
                for(Object object2: list1) {
                    String s12 = ((ArtistCmt)object2).getCmtSeq() + "_" + System.currentTimeMillis();
                    String s13 = ((ArtistCmt)object2).getCmtSeq();
                    String s14 = ((ArtistCmt)object2).getComment();
                    String s15 = ((ArtistCmt)object2).getMessageType();
                    if(s15 == null) {
                        s15 = "artist";
                    }
                    String s16 = ((ArtistCmt)object2).getImgUrl();
                    String s17 = ((ArtistCmt)object2).getName();
                    List list2 = ((ArtistCmt)object2).getAttachImages();
                    if(list2 == null) {
                        arrayList2 = null;
                    }
                    else {
                        ArrayList arrayList1 = new ArrayList(je.q.Q(10, list2));
                        for(Object object3: list2) {
                            arrayList1.add(new p(((ImageInfo)object3).getImageUrl(), ((ImageInfo)object3).getImageSeq()));
                        }
                        arrayList2 = arrayList1;
                    }
                    ((ArrayList)w0).add(new x2(s12, "un_used", (s14 == null ? "" : s14), s15, (s13 == null ? "" : s13), s16, s17, arrayList2, ((ArtistCmt)object2).getRegDate(), false, 0x200));
                }
            }
        }
        Response musicWaveChatSyncRes$Response2 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response2 == null) {
            g20 = null;
        }
        else {
            Notice musicWaveChatSyncRes$Notice0 = musicWaveChatSyncRes$Response2.getNotice();
            g20 = musicWaveChatSyncRes$Notice0 == null ? null : new G2(musicWaveChatSyncRes$Notice0.getText(), musicWaveChatSyncRes$Notice0.getButtonText(), musicWaveChatSyncRes$Notice0.getLink());
        }
        Response musicWaveChatSyncRes$Response3 = musicWaveChatSyncRes0.getResponse();
        String s18 = musicWaveChatSyncRes$Response3 == null ? null : musicWaveChatSyncRes$Response3.getInterval();
        long v1 = s18 == null || s18.length() == 0 ? 1L : Long.parseLong(s18);
        Response musicWaveChatSyncRes$Response4 = musicWaveChatSyncRes0.getResponse();
        String s19 = musicWaveChatSyncRes$Response4 == null ? null : musicWaveChatSyncRes$Response4.getChatBanTime();
        Response musicWaveChatSyncRes$Response5 = musicWaveChatSyncRes0.getResponse();
        List list3 = musicWaveChatSyncRes$Response5 == null ? null : musicWaveChatSyncRes$Response5.getArtistMemberKeys();
        int v2 = 5;
        int v3 = s19 == null || s19.length() == 0 ? 5 : Integer.parseInt(s19);
        Response musicWaveChatSyncRes$Response6 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response6 == null) {
            s20 = null;
        }
        else {
            ReloadInfo musicWaveChatSyncRes$ReloadInfo0 = musicWaveChatSyncRes$Response6.getArtistChatReloadInfo();
            s20 = musicWaveChatSyncRes$ReloadInfo0 == null ? null : musicWaveChatSyncRes$ReloadInfo0.getReloadDate();
        }
        Response musicWaveChatSyncRes$Response7 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response7 == null) {
            s21 = null;
        }
        else {
            ReloadInfo musicWaveChatSyncRes$ReloadInfo1 = musicWaveChatSyncRes$Response7.getArtistChatReloadInfo();
            s21 = musicWaveChatSyncRes$ReloadInfo1 == null ? null : musicWaveChatSyncRes$ReloadInfo1.getMessage();
        }
        d d0 = new d(s20, s21);
        Response musicWaveChatSyncRes$Response8 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response8 == null) {
            s22 = null;
        }
        else {
            ReloadInfo musicWaveChatSyncRes$ReloadInfo2 = musicWaveChatSyncRes$Response8.getChannelReloadInfo();
            s22 = musicWaveChatSyncRes$ReloadInfo2 == null ? null : musicWaveChatSyncRes$ReloadInfo2.getReloadDate();
        }
        Response musicWaveChatSyncRes$Response9 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response9 == null) {
            s23 = null;
        }
        else {
            ReloadInfo musicWaveChatSyncRes$ReloadInfo3 = musicWaveChatSyncRes$Response9.getChannelReloadInfo();
            s23 = musicWaveChatSyncRes$ReloadInfo3 == null ? null : musicWaveChatSyncRes$ReloadInfo3.getMessage();
        }
        d d1 = new d(s22, s23);
        Response musicWaveChatSyncRes$Response10 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response10 == null) {
            s24 = null;
        }
        else {
            ReloadInfo musicWaveChatSyncRes$ReloadInfo4 = musicWaveChatSyncRes$Response10.getSongReloadInfo();
            s24 = musicWaveChatSyncRes$ReloadInfo4 == null ? null : musicWaveChatSyncRes$ReloadInfo4.getReloadDate();
        }
        Response musicWaveChatSyncRes$Response11 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response11 == null) {
            s25 = null;
        }
        else {
            ReloadInfo musicWaveChatSyncRes$ReloadInfo5 = musicWaveChatSyncRes$Response11.getSongReloadInfo();
            s25 = musicWaveChatSyncRes$ReloadInfo5 == null ? null : musicWaveChatSyncRes$ReloadInfo5.getMessage();
        }
        d d2 = new d(s24, s25);
        Response musicWaveChatSyncRes$Response12 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response12 != null) {
            s1 = musicWaveChatSyncRes$Response12.getRetryCount();
        }
        if(s1 != null && s1.length() != 0) {
            Response musicWaveChatSyncRes$Response13 = musicWaveChatSyncRes0.getResponse();
            if(musicWaveChatSyncRes$Response13 != null) {
                String s26 = musicWaveChatSyncRes$Response13.getRetryCount();
                if(s26 != null) {
                    v2 = Integer.parseInt(s26);
                }
            }
        }
        Response musicWaveChatSyncRes$Response14 = musicWaveChatSyncRes0.getResponse();
        if(musicWaveChatSyncRes$Response14 != null) {
            String s27 = musicWaveChatSyncRes$Response14.getNowSec();
            if(s27 != null) {
                s4 = s27;
            }
        }
        this.d = s4;
        return new N9.c(w1, w0, v1, d0, v2, new A2(g20, v3, list3, d2, d1));
    }
}

