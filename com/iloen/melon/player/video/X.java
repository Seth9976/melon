package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv;
import kotlin.jvm.internal.q;

public final class x implements View.OnClickListener {
    public final int a;
    public final VideoInfoAdapter b;
    public final Mv c;

    public x(VideoInfoAdapter videoInfoAdapter0, Mv vodDetailRes$Response$RecmMv$Mv0, int v) {
        this.a = v;
        this.b = videoInfoAdapter0;
        this.c = vodDetailRes$Response$RecmMv$Mv0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener1 = this.b.b;
                if(videoInfoFragment$VideoInfoClickListener1 != null) {
                    String s3 = this.c.program.progSeq;
                    q.f(s3, "progSeq");
                    String s4 = this.c.program.progName;
                    q.f(s4, "progName");
                    videoInfoFragment$VideoInfoClickListener1.onProgram(s3, s4);
                }
                return;
            }
            case 1: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener2 = this.b.b;
                if(videoInfoFragment$VideoInfoClickListener2 != null) {
                    videoInfoFragment$VideoInfoClickListener2.onArtist(this.c.artistList, true, "FROM_RELATIVE_VIDEO", this.c.index);
                }
                return;
            }
            default: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = this.b.b;
                if(videoInfoFragment$VideoInfoClickListener0 != null) {
                    Mv vodDetailRes$Response$RecmMv$Mv0 = this.c;
                    String s = vodDetailRes$Response$RecmMv$Mv0.mvId;
                    String s1 = "";
                    if(s == null) {
                        s = "";
                    }
                    String s2 = vodDetailRes$Response$RecmMv$Mv0.mvName;
                    if(s2 != null) {
                        s1 = s2;
                    }
                    videoInfoFragment$VideoInfoClickListener0.onPlayMv(s, s1, vodDetailRes$Response$RecmMv$Mv0.index);
                }
            }
        }
    }
}

