package com.iloen.melon.player.video;

import O.j;
import O.w;
import android.content.Context;
import android.view.View;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.melon.net.res.common.LinkInfoBase;
import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import q8.a;
import q8.f;
import we.k;
import zd.Q;

public final class n implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public n(VideoLivePreviewFragment videoLivePreviewFragment0, String s, LinkInfoBase linkInfoBase0) {
        this.a = 2;
        super();
        this.c = videoLivePreviewFragment0;
        this.b = s;
        this.d = linkInfoBase0;
    }

    public n(VideoLivePreviewFragment videoLivePreviewFragment0, String s, String s1) {
        this.a = 1;
        super();
        this.b = s;
        this.d = videoLivePreviewFragment0;
        this.c = s1;
    }

    public n(VideoPlayerFragmentBase videoPlayerFragmentBase0, String s, String s1) {
        this.a = 4;
        super();
        this.d = videoPlayerFragmentBase0;
        this.b = s;
        this.c = s1;
    }

    public n(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Live liveDetailRes$Response$Live0;
        String s = null;
        H h0 = H.a;
        Object object1 = this.d;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).b = (String)object3;
                ((f)object0).a = (String)object2;
                ((f)object0).c = (String)object1;
                return h0;
            }
            case 1: {
                String s2 = (String)object2;
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = (String)object3;
                ((f)object0).b = ((VideoLivePreviewFragment)object1).getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                if(s2 == null) {
                    s2 = "";
                }
                ((f)object0).c = s2;
                return h0;
            }
            case 2: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = ((VideoLivePreviewFragment)object2).getString(0x7F130E23);  // string:tiara_common_layer1_video_info "영상Info"
                ((a)object0).g = (String)object3;
                String s3 = ((LinkInfoBase)object1) == null ? null : ((LinkInfoBase)object1).linkurl;
                if(s3 == null || s3.length() == 0) {
                    if(((LinkInfoBase)object1) != null) {
                        s = ((LinkInfoBase)object1).scheme;
                    }
                }
                else if(((LinkInfoBase)object1) != null) {
                    s = ((LinkInfoBase)object1).linkurl;
                }
                ((a)object0).c = s;
                return h0;
            }
            case 3: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                w.c(((w)object0), new b(0x940B3959, new f0(((Q)object2), ((k)object1)), true));
                ((j)(((w)object0))).u(((List)object3).size(), null, new VideoMoreBottomSheetFragmentKt.VideoMoreBottomSheetLayout.lambda.12.lambda.11.lambda.10..inlined.itemsIndexed.default.2(((List)object3)), new b(0xBEF78951, new VideoMoreBottomSheetFragmentKt.VideoMoreBottomSheetLayout.lambda.12.lambda.11.lambda.10..inlined.itemsIndexed.default.3(((List)object3), ((Q)object2), ((k)object1), ((List)object3)), true));
                return h0;
            }
            case 4: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).b = ((VideoPlayerFragmentBase)object1).getString(0x7F130EFE);  // string:tiara_meta_type_mv "영상"
                ((f)object0).a = (String)object3;
                ((f)object0).c = (String)object2;
                return h0;
            }
            case 5: {
                String s4 = (String)object0;
                VideoPlayerLiveFragment.q0(((VideoPlayerLiveFragment)object3), null, ((String)((VideoPlayerLiveFragment)object3).getLiveViewModel().getLikeCnt().getValue()), ((View)object2), ((MelonTextView)object1), 1);
                return h0;
            }
            default: {
                if(((LiveDetailRes)object0) == null) {
                    liveDetailRes$Response$Live0 = null;
                }
                else {
                    Response liveDetailRes$Response0 = ((LiveDetailRes)object0).response;
                    liveDetailRes$Response$Live0 = liveDetailRes$Response0 == null ? null : liveDetailRes$Response0.live;
                }
                String s1 = liveDetailRes$Response$Live0 == null ? null : liveDetailRes$Response$Live0.liveTitle;
                if(liveDetailRes$Response$Live0 != null) {
                    s = liveDetailRes$Response$Live0.artistList;
                }
                if(s1 == null || s1.length() == 0) {
                    ((MelonTextView)object3).setVisibility(8);
                }
                else {
                    ((MelonTextView)object3).setVisibility(0);
                    ((MelonTextView)object3).setText(s1);
                }
                if(s != null && !((Collection)s).isEmpty()) {
                    ((MelonTextView)object2).setVisibility(0);
                    Context context0 = ((VideoPlayerLivePreviewFragment)object1).getContext();
                    ((MelonTextView)object2).setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(context0, ((List)s), 2));
                    return h0;
                }
                ((MelonTextView)object2).setVisibility(8);
                return h0;
            }
        }
    }
}

