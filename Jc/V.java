package Jc;

import J8.K1;
import android.content.Context;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AtachListBase;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import v9.b;

public final class v extends View.AccessibilityDelegate {
    public final Context a;
    public final K b;
    public final K1 c;

    public v(Context context0, K k0, K1 k10) {
        this.a = context0;
        this.b = k0;
        this.c = k10;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        q.g(view0, "host");
        q.g(accessibilityNodeInfo0, "info");
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, "답글 상세보기 및 답글 달기"));
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F1302A0, "작성자 프로필로 이동"));  // string:ctx_menu_writer_page "작성자 프로필로 이동"
        K k0 = this.b;
        if(k0.f0 > 0) {
            List list0 = k0.s0;
            if(list0 != null) {
                for(Object object0: list0) {
                    AtachListBase cmtSharedTypeRes$AtachListBase0 = (AtachListBase)object0;
                    String s = cmtSharedTypeRes$AtachListBase0.atachtype;
                    if("image".equals(s) || "music_album".equals(s) || "music_artist".equals(s) || "music_song".equals(s) || "video".equals(s) || "link_video".equals(s) || "kakao_emoticon".equals(s) || "link_genrl".equals(s)) {
                        MediaAttachInfo mediaAttachInfo0 = b.a(cmtSharedTypeRes$AtachListBase0);
                        if(mediaAttachInfo0 != null) {
                            MediaAttachType mediaAttachType0 = mediaAttachInfo0.a;
                            if(q.b(mediaAttachType0, MediaAttachType.g) || q.b(mediaAttachType0, MediaAttachType.f)) {
                                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130294, "첨부된 이미지 크게보기"));  // string:ctx_menu_show_image_attachment "첨부된 이미지 크게보기"
                            }
                            else if(q.b(mediaAttachType0, MediaAttachType.c) || q.b(mediaAttachType0, MediaAttachType.d)) {
                                if(mediaAttachInfo0.Y) {
                                    continue;
                                }
                                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130278, "첨부된 음악 재생하기"));  // string:ctx_menu_play_music_attachment "첨부된 음악 재생하기"
                            }
                            else if(q.b(mediaAttachType0, MediaAttachType.h)) {
                                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13027A, "첨부된 뮤직비디오 재생하기"));  // string:ctx_menu_play_video_attachment "첨부된 뮤직비디오 재생하기"
                            }
                            else if(q.b(mediaAttachType0, MediaAttachType.i)) {
                                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130267, "첨부된 유튜브 링크로 이동하기"));  // string:ctx_menu_move_youtube_attachment "첨부된 유튜브 링크로 이동하기"
                            }
                            else {
                                if(q.b(mediaAttachType0, MediaAttachType.e)) {
                                    continue;
                                }
                                q.b(mediaAttachType0, MediaAttachType.k);
                            }
                        }
                    }
                }
            }
        }
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130288, "답글 상세보기 및 답글 달기"));  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
        if(k0.Z) {
            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13029C, "추천 해제하기"));  // string:ctx_menu_unrecommend "추천 해제하기"
        }
        else {
            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130285, "추천하기"));  // string:ctx_menu_recommend "추천하기"
        }
        if(k0.c0) {
            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13029A, "비추천 해제하기"));  // string:ctx_menu_unnonrecommend "비추천 해제하기"
        }
        else {
            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13026E, "비추천하기"));  // string:ctx_menu_nonrecommend "비추천하기"
        }
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130CA2, "더보기"));  // string:text_more "더보기"
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        q.g(view0, "host");
        K k0 = this.b;
        K1 k10 = this.c;
        switch(v) {
            case 0x7F130278: {  // string:ctx_menu_play_music_attachment "첨부된 음악 재생하기"
                List list1 = k10.b.getAttachInfos();
                q.f(list1, "getAttachInfos(...)");
                MediaAttachInfo mediaAttachInfo1 = (MediaAttachInfo)p.m0(list1);
                if(mediaAttachInfo1 != null) {
                    k0.m0.invoke(mediaAttachInfo1);
                    return true;
                }
                break;
            }
            case 16: 
            case 0x7F130288: {  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
                k10.s.performClick();
                return true;
            }
            case 0x7F130267:   // string:ctx_menu_move_youtube_attachment "첨부된 유튜브 링크로 이동하기"
            case 0x7F13027A:   // string:ctx_menu_play_video_attachment "첨부된 뮤직비디오 재생하기"
            case 0x7F130294: {  // string:ctx_menu_show_image_attachment "첨부된 이미지 크게보기"
                List list0 = k10.b.getAttachInfos();
                q.f(list0, "getAttachInfos(...)");
                MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)p.m0(list0);
                if(mediaAttachInfo0 != null) {
                    k0.l0.invoke(mediaAttachInfo0);
                    return true;
                }
                break;
            }
            case 0x7F13026E:   // string:ctx_menu_nonrecommend "비추천하기"
            case 0x7F13029A: {  // string:ctx_menu_unnonrecommend "비추천 해제하기"
                k10.w.performClick();
                return true;
            }
            case 0x7F130285:   // string:ctx_menu_recommend "추천하기"
            case 0x7F13029C: {  // string:ctx_menu_unrecommend "추천 해제하기"
                k10.z.performClick();
                return true;
            }
            case 0x7F1302A0: {  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                ((BorderImageView)k10.q.d).performClick();
                return true;
            }
            case 0x7F130CA2: {  // string:text_more "더보기"
                k10.c.performClick();
                return true;
            }
            default: {
                return super.performAccessibilityAction(view0, v, bundle0);
            }
        }
        return true;
    }
}

