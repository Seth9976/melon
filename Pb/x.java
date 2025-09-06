package pb;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.task.request.TaskGetSongInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.SongInfoBase;
import d5.n;
import ie.o;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;

public final class x {
    public final Object a(Playable playable0, c c0) {
        List list0;
        w w0;
        if(c0 instanceof w) {
            w0 = (w)c0;
            int v = w0.D;
            if((v & 0x80000000) == 0) {
                w0 = new w(this, c0);
            }
            else {
                w0.D = v ^ 0x80000000;
            }
        }
        else {
            w0 = new w(this, c0);
        }
        Object object0 = w0.w;
        a a0 = a.a;
        switch(w0.D) {
            case 0: {
                n.D(object0);
                if(playable0 == null) {
                    return null;
                }
                String s = playable0.getArtistid();
                if(s == null || s.length() == 0) {
                    if(playable0.hasSongId()) {
                        try {
                            q.f("", "getSongidString(...)");
                            TaskGetSongInfo taskGetSongInfo0 = new TaskGetSongInfo("", playable0.getCtype());
                            w0.r = playable0;
                            w0.D = 1;
                            object0 = taskGetSongInfo0.execute(w0);
                            if(object0 == a0) {
                                return a0;
                            }
                            list0 = (List)object0;
                            goto label_37;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    LogU.Companion.d("PlayableExtensions", "getUpdatedArtistInfo() invalid songId");
                }
                String s1 = playable0.getArtistid();
                if(s1 == null) {
                    s1 = "";
                }
                return new pb.a(s1, "");
            }
            case 1: {
                try {
                    playable0 = w0.r;
                    n.D(object0);
                    list0 = (List)object0;
                    goto label_37;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        list0 = n.t(throwable0);
    label_37:
        if(!(list0 instanceof o)) {
            playable0.updateFrom(((SongInfoBase)p.m0(list0)));
        }
        String s2 = playable0.getArtistid();
        if(s2 == null) {
            s2 = "";
        }
        return new pb.a(s2, "");
    }
}

