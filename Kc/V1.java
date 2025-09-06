package kc;

import ac.B;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.SpecialContentsKt;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.ContentsInfo;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.D;
import je.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import we.n;

public final class v1 extends i implements n {
    public final String B;
    public final B D;
    public Object r;
    public final A1 w;

    public v1(A1 a10, String s, B b0, Continuation continuation0) {
        this.w = a10;
        this.B = s;
        this.D = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new v1(this.w, this.B, this.D, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v1)this.create(((List)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0 = (List)this.r;
        d5.n.D(object0);
        A1 a10 = this.w;
        a10.getClass();
        Playable playable0 = A1.a(this.B, list0);
        if(playable0 != null) {
            Object object1 = null;
            boolean z = playable0.isTypeOfMv();
            B b0 = this.D;
            String s = b0.h;
            for(Object object2: b0.p) {
                if(q.b("", "")) {
                    object1 = object2;
                    break;
                }
            }
            playable0.setIsFlacSt(s.equals("FLAC16"));
            if(playable0.isOriginLocal()) {
                playable0.setOrigin(0);
                playable0.setUriString("");
                playable0.setData("");
            }
            playable0.setStreamPath(b0.b);
            playable0.setProtocolType(b0.d.a);
            playable0.setC(b0.e.b);
            playable0.setIsHttps(b0.l);
            playable0.setBitrate(b0.g);
            playable0.setMetatype(s);
            playable0.setLoggingToken(b0.c);
            playable0.setPInterval(b0.n);
            playable0.setPlayToken(b0.o);
            playable0.setLastGetPathTime(System.currentTimeMillis());
            if(((ContentsInfo)object1) != null) {
                playable0.setSongName("");
                playable0.setMvname("");
                Iterable iterable0 = ((ContentsInfo)object1).getArtists();
                int v = D.N(je.q.Q(10, iterable0));
                if(v < 16) {
                    v = 16;
                }
                LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
                Iterator iterator1 = iterable0.iterator();
                while(iterator1.hasNext()) {
                    iterator1.next();
                    linkedHashMap0.put("", "");
                }
                playable0.setArtists(linkedHashMap0);
                playable0.setAlbum("", "");
                playable0.setLyricType("");
                playable0.setLyricspath("");
                playable0.setLyricLastUpdated("");
                playable0.setAlbumImg("");
                playable0.setAlbumImgThumb("");
                playable0.setHasMv((z ? true : ((ContentsInfo)object1).isMv()));
                playable0.setIsDownload(((ContentsInfo)object1).isDownload());
                playable0.setAdult(((ContentsInfo)object1).isAdult());
                playable0.setService(((ContentsInfo)object1).isService());
                playable0.setIsPrivate("");
                playable0.setIssueDate("");
                playable0.setBookFile(((ContentsInfo)object1).isBookFile());
                Iterable iterable1 = ((ContentsInfo)object1).getAlbumImages();
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable1));
                Iterator iterator2 = iterable1.iterator();
                while(iterator2.hasNext()) {
                    iterator2.next();
                    arrayList0.add("");
                }
                playable0.setAlbumImgs(arrayList0);
                playable0.setFree(((ContentsInfo)object1).isFree());
                playable0.setBgVideo(SpecialContentsKt.getSpecialBgVideoFromBgVideo(((ContentsInfo)object1).getBgVideo()));
                playable0.setBgImgs(SpecialContentsKt.getSpecialBgImageListFromBgImageList(((ContentsInfo)object1).getBgImages()));
                playable0.setDuration(ProtocolUtils.parseLongFromPlayTime(""));
            }
            return k.z(playable0);
        }
        LogConstantsKt.errorOnlyDebugMode(a10.c, "updateDataFromGetStreamInfo() failed.");
        ToastManager.debug("updateDataFromGetStreamInfo() failed.");
        return w.a;
    }
}

