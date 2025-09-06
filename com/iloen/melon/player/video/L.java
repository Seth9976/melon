package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v6x.response.LiveTimedMetaNoticeRes.NOTICE.TIARALOG;
import com.iloen.melon.net.v6x.response.LiveTimedMetaNoticeRes.NOTICE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Concert.Ticket;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class l implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public l(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        String s4;
        String s = null;
        String s1 = "";
        Object object0 = this.c;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                MelonLinkExecutor.open(MelonLinkInfo.b((((NOTICE)object1) == null ? null : ((NOTICE)object1).link)));
                String s3 = ((VideoChatFragment)object0).getString(0x7F130D44);  // string:tiara_click_copy_live_action_type_notice "공지링크"
                if(((NOTICE)object1) == null) {
                    s4 = null;
                }
                else {
                    TIARALOG liveTimedMetaNoticeRes$NOTICE$TIARALOG0 = ((NOTICE)object1).tiaraLog;
                    s4 = liveTimedMetaNoticeRes$NOTICE$TIARALOG0 == null ? null : liveTimedMetaNoticeRes$NOTICE$TIARALOG0.id;
                }
                if(((NOTICE)object1) != null) {
                    TIARALOG liveTimedMetaNoticeRes$NOTICE$TIARALOG1 = ((NOTICE)object1).tiaraLog;
                    if(liveTimedMetaNoticeRes$NOTICE$TIARALOG1 != null) {
                        s = liveTimedMetaNoticeRes$NOTICE$TIARALOG1.text;
                    }
                }
                VideoChatFragment.j0(((VideoChatFragment)object0), null, s3, s4, null, s, null, 41);
                return;
            }
            case 1: {
                q.d(view0);
                String s5 = ((SONG)object0).songId;
                if(s5 != null) {
                    s1 = s5;
                }
                ((j)object1).invoke(view0, s1);
                return;
            }
            case 2: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = ((VideoInfoAdapter)object1).b;
                if(videoInfoFragment$VideoInfoClickListener0 != null) {
                    String s6 = ((Mv)object0).program.progSeq;
                    q.f(s6, "progSeq");
                    String s7 = ((Mv)object0).program.progName;
                    q.f(s7, "progName");
                    videoInfoFragment$VideoInfoClickListener0.onProgram(s6, s7);
                }
                return;
            }
            case 3: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = ((VideoInfoAdapter)object1).b;
                if(videoInfoFragment$VideoInfoClickListener1 != null) {
                    videoInfoFragment$VideoInfoClickListener1.onConcertItem(((Ticket)object0));
                }
                return;
            }
            case 4: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener2 = ((VideoInfoAdapter)object1).b;
                if(videoInfoFragment$VideoInfoClickListener2 != null) {
                    CommonClickListener.onArtist$default(videoInfoFragment$VideoInfoClickListener2, ((ArrayList)object0), false, "FROM_INFO", 0, 10, null);
                }
                return;
            }
            case 5: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener3 = ((VideoInfoAdapter)object1).b;
                if(videoInfoFragment$VideoInfoClickListener3 != null) {
                    videoInfoFragment$VideoInfoClickListener3.onInfoComment(((result)object0));
                }
                return;
            }
            default: {
                q.d(view0);
                String s2 = ((SONG)object0).songId;
                if(s2 != null) {
                    s1 = s2;
                }
                ((VideoPlayerLiveFragment)object1).updateLikeInfo(view0, s1);
            }
        }
    }
}

