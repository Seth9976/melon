package com.iloen.melon.player.video;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import e1.m;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class v implements View.OnClickListener {
    public final int a;
    public final Object b;

    public v(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((ArtistViewHolder)object0).getBinding().a.performClick();
                return;
            }
            case 1: {
                ((k)object0).invoke();
                return;
            }
            case 2: {
                VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0 = ((VideoInfoAdapter)object0).b;
                if(videoInfoFragment$VideoInfoClickListener0 != null) {
                    videoInfoFragment$VideoInfoClickListener0.onContentsMore();
                }
                return;
            }
            case 3: {
                VideoInfoFragment.d0(((VideoInfoFragment)object0));
                return;
            }
            default: {
                ArrayList arrayList0 = new ArrayList();
                RESPONSE liveTimedMetaSongRes$RESPONSE0 = ((SongListFragment)object0).c;
                if(liveTimedMetaSongRes$RESPONSE0 != null) {
                    ArrayList arrayList1 = liveTimedMetaSongRes$RESPONSE0.songList;
                    if(arrayList1 != null) {
                        for(Object object1: arrayList1) {
                            arrayList0.add(((SONG)object1));
                        }
                    }
                }
                ArrayList arrayList2 = ((SongListFragment)object0).d;
                arrayList2.clear();
                if(!arrayList0.isEmpty()) {
                    arrayList2.addAll(arrayList0);
                }
                ((SongListFragment)object0).showContextMenuAddTo();
                String s = ((SongListFragment)object0).getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                q.f(s, "getString(...)");
                ActionKind actionKind0 = ActionKind.ClickContent;
                String s1 = ((SongListFragment)object0).getString(0x7F130CF8);  // string:tiara_click_copy_all_add "전체담기"
                q.f(s1, "getString(...)");
                Object object2 = ((SongListFragment)object0).a.getCurrentVideoPlayable().getValue();
                if(((Playable)object2) != null) {
                    m.F(new n0(null, s, actionKind0, ((SongListFragment)object0), s1, ((Playable)object2))).track();
                }
            }
        }
    }
}

