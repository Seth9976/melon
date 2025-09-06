package d9;

import E9.h;
import E9.w;
import Ma.j;
import Ma.l;
import android.content.Context;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.net.v4x.response.GetSongLyricRes.RESPONSE;
import com.iloen.melon.net.v4x.response.GetSongLyricRes;
import com.iloen.melon.net.v6x.response.MusicWaveLyricRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import k8.Y;
import k8.o;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import okhttp3.Response;
import ta.L;
import tg.Q;
import tg.d;
import we.n;
import x8.f;

public final class b extends f {
    public final Playable a;
    public final boolean b;
    public final n c;
    public Exception d;
    public boolean e;
    public final ArrayList f;

    public b(Playable playable0, boolean z, n n0) {
        q.g(n0, "postAction");
        super();
        this.a = playable0;
        this.b = z;
        this.c = n0;
        this.f = new ArrayList();
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        return this.backgroundWork(((Void)object0), continuation0);
    }

    public final Object backgroundWork(Void void0, Continuation continuation0) {
        String s3;
        ArrayList arrayList2;
        Context context2;
        Playable playable2;
        long v1;
        Map.Entry map$Entry0;
        ArrayList arrayList1;
        ArrayList arrayList0;
        d d0;
        String s1;
        Playable playable1;
        Context context1;
        Context context0;
        a a0;
        if(continuation0 instanceof a) {
            a0 = (a)continuation0;
            int v = a0.E;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, continuation0);
            }
            else {
                a0.E = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, continuation0);
        }
        Object object0 = a0.B;
        ne.a a1 = ne.a.a;
        boolean z = this.b;
        H h0 = H.a;
        Playable playable0 = this.a;
        switch(a0.E) {
            case 0: {
                d5.n.D(object0);
                if(playable0 == null) {
                    LogU.Companion.w("FetchLyricTask", "backgroundWork() invalid playable");
                    return h0;
                }
                String s = "";
                context0 = Y.a(MelonAppBase.Companion);
                Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.d("FetchLyricTask", "backgroundWork() p:" + playable0);
                if(playable0.getIsMusicWaveSong()) {
                    L l0 = ((o)(((j)w.s(t.a().getContext(), j.class)))).q();
                    try {
                        logU$Companion0.d("FetchLyricTask", "backgroundWork() lyricPath : ");
                        q.f("", "getContentId(...)");
                        q.f("", "getLyricspath(...)");
                        a0.r = context0;
                        a0.w = playable0;
                        a0.E = 1;
                        object0 = l0.k("", "", a0);
                    }
                    catch(Exception exception0) {
                        context1 = context0;
                        playable1 = playable0;
                        arrayList0 = null;
                        LogU.Companion.e("FetchLyricTask", "backgroundWork() musicwave lyrics error", exception0);
                        context0 = context1;
                        break;
                    }
                    if(object0 == a1) {
                        return a1;
                    }
                    context1 = context0;
                    playable1 = playable0;
                    goto label_92;
                }
                else {
                    if(!playable0.isOriginLocal() || !z) {
                        goto label_82;
                    }
                    else {
                        if(StorageUtils.isScopedStorage()) {
                            Uri uri0 = Uri.parse("");
                            if(uri0 == null) {
                                s = null;
                                s1 = null;
                            }
                            else {
                                s1 = SongMetaParser.parseLyricCodeFromUri(uri0);
                                s = StorageUtils.getDisplayName(uri0, context0);
                            }
                        }
                        else if(Tf.o.H0("")) {
                            s = null;
                            s1 = null;
                        }
                        else {
                            s1 = SongMetaParser.parseLyricCodeFromFile("");
                        }
                        if(s1 != null && !Tf.o.H0(s1)) {
                            ToastManager.showShort(0x7F130372);  // string:download_lyrics_start "가사 다운로드를 시작합니다."
                            Ba.L l1 = ((o)(((l)com.google.firebase.b.B(t.a().getContext(), l.class)))).n();
                            try {
                                if(FilenameUtils.isMusic(s, true)) {
                                    q.f("", "getContentId(...)");
                                    d0 = l1.b(s1, "");
                                }
                                else {
                                    q.f("", "getContentId(...)");
                                    d0 = l1.e(s1, "");
                                }
                                Q q0 = d0.execute();
                                Response response0 = q0.a;
                                GetSongLyricRes getSongLyricRes0 = (GetSongLyricRes)q0.b;
                                RESPONSE getSongLyricRes$RESPONSE0 = getSongLyricRes0 == null ? null : getSongLyricRes0.getResponse();
                                if(!response0.isSuccessful() || getSongLyricRes$RESPONSE0 == null) {
                                    if(!response0.isSuccessful()) {
                                        throw new Exception("getLyricDownloadDcf : response is not successful");
                                    }
                                    if(q0.b == null) {
                                        throw new Exception("getLyricDownloadDcf : response is null");
                                    }
                                    if(getSongLyricRes$RESPONSE0 == null) {
                                        throw new Exception("getLyricDownloadDcf : response.response is null");
                                    }
                                }
                                else {
                                    String s2 = getSongLyricRes$RESPONSE0.getObjecturi();
                                    File file0 = SongMetaParser.getLyricFile(playable0);
                                    if(s2 != null && s2.length() > 0 && file0 != null && MusicUtils.downloadLyrics(context0, file0.getName(), URLDecoder.decode(s2, "utf-8")) == 1) {
                                        ToastManager.showShort(0x7F130604);  // string:melon_download_lyrics_success "가사 다운로드가 완료되었습니다."
                                    }
                                }
                            label_82:
                                playable1 = playable0;
                                arrayList0 = null;
                                break;
                            }
                            catch(Exception exception1) {
                            }
                        }
                    }
                    ToastManager.showShort(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                    this.d = exception1;
                    return h0;
                }
                break;
            }
            case 1: {
                try {
                    playable1 = a0.w;
                    context1 = a0.r;
                    d5.n.D(object0);
                label_92:
                    com.iloen.melon.net.v6x.response.MusicWaveLyricRes.RESPONSE musicWaveLyricRes$RESPONSE0 = ((MusicWaveLyricRes)object0).getResponse();
                    if(musicWaveLyricRes$RESPONSE0 == null) {
                        playable2 = playable1;
                        context2 = context1;
                        arrayList2 = null;
                    }
                    else {
                        Map map0 = musicWaveLyricRes$RESPONSE0.getLyric();
                        if(map0 == null) {
                            playable2 = playable1;
                            context2 = context1;
                            arrayList2 = null;
                        }
                        else {
                            arrayList1 = new ArrayList(map0.size());
                            Iterator iterator0 = map0.entrySet().iterator();
                            while(true) {
                            label_98:
                                if(!iterator0.hasNext()) {
                                    playable2 = playable1;
                                    context2 = context1;
                                    arrayList2 = h.W(arrayList1);
                                    break;
                                }
                                Object object1 = iterator0.next();
                                map$Entry0 = (Map.Entry)object1;
                                v1 = Long.parseLong(((String)map$Entry0.getKey()));
                                playable2 = playable1;
                                context2 = context1;
                                goto label_104;
                            }
                        }
                    }
                    goto label_123;
                }
                catch(Exception exception0) {
                    arrayList0 = null;
                    LogU.Companion.e("FetchLyricTask", "backgroundWork() musicwave lyrics error", exception0);
                    context0 = context1;
                    break;
                }
                try {
                label_104:
                    arrayList1.add(new LyricsInfo(v1 * 100L, ((String)map$Entry0.getValue())));
                    playable1 = playable2;
                    context1 = context2;
                    goto label_98;
                }
                catch(Exception exception0) {
                    playable1 = playable2;
                    context1 = context2;
                    arrayList0 = null;
                    LogU.Companion.e("FetchLyricTask", "backgroundWork() musicwave lyrics error", exception0);
                    context0 = context1;
                    break;
                }
                try {
                    playable2 = playable1;
                    context2 = context1;
                    arrayList2 = null;
                    goto label_123;
                }
                catch(Exception exception0) {
                }
                arrayList0 = null;
                LogU.Companion.e("FetchLyricTask", "backgroundWork() musicwave lyrics error", exception0);
                context0 = context1;
                break;
                try {
                label_123:
                    arrayList0 = arrayList2;
                    playable1 = playable2;
                    LogU.Companion.d("FetchLyricTask", "backgroundWork() musicwave lyrics size: " + (arrayList2 == null ? null : new Integer(arrayList2.size())));
                    arrayList0 = arrayList2;
                    playable1 = playable2;
                    context0 = context2;
                    break;
                }
                catch(Exception exception0) {
                    context1 = context2;
                }
                LogU.Companion.e("FetchLyricTask", "backgroundWork() musicwave lyrics error", exception0);
                context0 = context1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(playable0.getIsMusicWaveSong()) {
        label_171:
            LogU.Companion.d("FetchLyricTask", "oriLyricArray : " + arrayList0 + " size = " + (arrayList0 == null ? null : new Integer(arrayList0.size())));
            ArrayList arrayList3 = this.f;
            if(arrayList0 != null && arrayList0.size() > 0) {
                arrayList0.add(new LyricsInfo(1000000L, ""));
                Iterator iterator1 = arrayList0.iterator();
                q.f(iterator1, "iterator(...)");
                int v2 = 0;
                while(iterator1.hasNext()) {
                    Object object2 = iterator1.next();
                    q.f(object2, "next(...)");
                    LyricsInfo lyricsInfo0 = (LyricsInfo)object2;
                    if(v2 <= 0 || lyricsInfo0.a != 0L) {
                        arrayList3.add(lyricsInfo0);
                        ++v2;
                    }
                }
            }
            Y.t("backgroundWork() fetched lyric size:", arrayList3.size(), LogU.Companion, "FetchLyricTask");
            if(this.d != null) {
                ToastManager.show(0x7F130602);  // string:melon_download_lyrics_fail "가사 다운로드에 실패하였습니다."
            }
        }
        else if(!playable1.isOriginMelon() || !playable1.isTypeOfSong()) {
            if(StorageUtils.isScopedStorage()) {
                Uri uri1 = Uri.parse("");
                q.d(uri1);
                s3 = StorageUtils.getDisplayName(uri1, context0);
            }
            else {
                s3 = "";
            }
            switch(FilenameUtils.getFileType(s3)) {
                case 0x102: {
                    arrayList0 = MusicUtils.decodeSlfLyrics("");
                    if(arrayList0 == null) {
                        arrayList0 = MusicUtils.decodeMp3LyricsFromId3Tag("");
                        if(arrayList0 != null) {
                            this.e = true;
                        }
                    }
                    break;
                }
                case 0x202: {
                    arrayList0 = MusicUtils.decodeSlfLyrics("");
                    if(arrayList0 == null) {
                        arrayList0 = MusicUtils.decodeFlacLyricsFromFlacTag("");
                        if(arrayList0 != null) {
                            this.e = true;
                        }
                    }
                    break;
                }
                case 0x402: {
                    arrayList0 = MusicUtils.decodeDcfLyrics(context0, playable1);
                }
            }
            if(arrayList0 == null) {
                boolean z1 = playable1.hasCid();
                LogU.Companion.d("FetchLyricTask", "backgroundWork() check weblyric for local file. hasCid : " + z1);
                if(playable1.hasCid() && playable1.isTypeOfSong()) {
                    arrayList0 = MusicUtils.getWebLyrics(context0, "", playable1.getCtype().getValue());
                }
                if(arrayList0 != null) {
                    this.e = true;
                    goto label_171;
                }
                else if(z) {
                    ToastManager.showShort(0x7F130619);  // string:melon_prepare_lyrics "가사 준비 중입니다."
                    return h0;
                }
            }
            else {
                goto label_171;
            }
        }
        else if(playable1.hasSongId()) {
            arrayList0 = MusicUtils.decodeStreamLyrics(context0, playable1.getCtype().getValue(), "");
            goto label_171;
        }
        else {
            goto label_171;
        }
        return h0;
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        super.postTask(((H)object0));
        this.c.invoke(this.f, Boolean.valueOf(this.e));
    }
}

