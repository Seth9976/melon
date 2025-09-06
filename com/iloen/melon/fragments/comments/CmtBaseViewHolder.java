package com.iloen.melon.fragments.comments;

import A7.d;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.ATACHLIST;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import v9.b;

public abstract class CmtBaseViewHolder extends O0 {
    private static final String TAG = "CmtBaseViewHolder";
    private Context mContext;
    private WeakReference mFragmentRef;
    private View mainContainer;

    public CmtBaseViewHolder(View view0) {
        this(view0, null);
    }

    public CmtBaseViewHolder(View view0, CmtBaseFragment cmtBaseFragment0) {
        super(view0);
        this.mContext = cmtBaseFragment0.getContext();
        this.mainContainer = view0;
        this.mFragmentRef = new WeakReference(cmtBaseFragment0);
        ViewUtils.hideWhen(this.mainContainer, true);
    }

    public abstract void bindView(Object arg1, int arg2, int arg3);

    private String getAccessibilityRegdate(cmtList cmtResViewModel$result$cmtList0) {
        String[] arr_s = cmtResViewModel$result$cmtList0.cmtinfo.dsplydate.split("\\.");
        return arr_s.length == 3 ? arr_s[0] + "년" + " " + StringUtils.getNumberFromString(arr_s[1]) + "월" + " " + arr_s[2] + "일" : cmtResViewModel$result$cmtList0.cmtinfo.dsplydate;
    }

    public Context getContext() {
        return this.mContext;
    }

    public CmtBaseFragment getFragment() {
        CmtBaseFragment cmtBaseFragment0 = this.mFragmentRef == null ? null : ((CmtBaseFragment)this.mFragmentRef.get());
        return cmtBaseFragment0 == null || !cmtBaseFragment0.isAdded() ? null : cmtBaseFragment0;
    }

    public View getMainContainer() {
        return this.mainContainer;
    }

    public boolean isCmtResViewModelValid(cmtList cmtResViewModel$result$cmtList0) {
        if(cmtResViewModel$result$cmtList0 != null && cmtResViewModel$result$cmtList0.cmtinfo != null && cmtResViewModel$result$cmtList0.memberinfo != null) {
            return true;
        }
        LogU.w("CmtBaseViewHolder", "Invalid CmtResViewModel dataset!");
        return false;
    }

    public boolean isFragmentValid(I i0) {
        if(i0 == null) {
            return false;
        }
        FragmentActivity fragmentActivity0 = i0.getActivity();
        return fragmentActivity0 != null && !fragmentActivity0.isFinishing() && i0.isAdded() && i0 instanceof CmtBaseFragment;
    }

    public boolean isListMusicResValid(MUSICLIST listMusicRes$result$MUSICLIST0) {
        if(listMusicRes$result$MUSICLIST0 == null) {
            LogU.w("CmtBaseViewHolder", "Invalid ListMusicRe dataset!");
            return false;
        }
        return true;
    }

    public void setContainerContentDescription(boolean z, String s, boolean z1, boolean z2, boolean z3, cmtList cmtResViewModel$result$cmtList0) {
        this.setContainerContentDescription(z, s, z1, z2, z3, cmtResViewModel$result$cmtList0, -1, -1);
    }

    // This method was un-flattened
    public void setContainerContentDescription(boolean z, String s, boolean z1, boolean z2, boolean z3, cmtList cmtResViewModel$result$cmtList0, int v, int v1) {
        int v2;
        String s3;
        StringBuilder stringBuilder0 = new StringBuilder();
        d.u(stringBuilder0, (z ? "아티스트" : "작성자"), " ", s, ", ");
        if(z1 && cmtResViewModel$result$cmtList0.memberinfo.artistTemperature > -1) {
            stringBuilder0.append("친밀도");
            stringBuilder0.append(" ");
            stringBuilder0.append(cmtResViewModel$result$cmtList0.memberinfo.artistTemperature);
            stringBuilder0.append("도");
            stringBuilder0.append(", ");
        }
        String s1 = this.getAccessibilityRegdate(cmtResViewModel$result$cmtList0);
        stringBuilder0.append("작성시간");
        stringBuilder0.append(" ");
        stringBuilder0.append(s1);
        stringBuilder0.append(", ");
        stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.cmtcont);
        stringBuilder0.append(", ");
        if(cmtResViewModel$result$cmtList0.cmtinfo.atachcnt > 0) {
            ArrayList arrayList0 = cmtResViewModel$result$cmtList0.atachlist;
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    ATACHLIST cmtSharedTypeRes$CmtListBase$ATACHLIST0 = (ATACHLIST)object0;
                    if("image".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "music_album".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "music_artist".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "music_song".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "video".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "link_video".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "kakao_emoticon".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype) || "link_genrl".equals(cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype)) {
                        String s2 = "";
                        MediaAttachInfo mediaAttachInfo0 = b.a(cmtSharedTypeRes$CmtListBase$ATACHLIST0);
                        if(mediaAttachInfo0 == null) {
                            LogU.w("CmtBaseViewHolder", "invalid MediaAttachInfo");
                        }
                        else {
                            if(MediaAttachType.g.equals(mediaAttachInfo0.a) || MediaAttachType.f.equals(mediaAttachInfo0.a)) {
                                v2 = 0x7F130B50;  // string:talkback_image "이미지"
                                s3 = "";
                            }
                            else if(MediaAttachType.c.equals(mediaAttachInfo0.a)) {
                                s2 = mediaAttachInfo0.j;
                                s3 = "아티스트, " + mediaAttachInfo0.k;
                                v2 = 0x7F130A63;  // string:song "곡"
                            }
                            else if(MediaAttachType.d.equals(mediaAttachInfo0.a)) {
                                s2 = mediaAttachInfo0.i;
                                s3 = "아티스트, " + mediaAttachInfo0.k;
                                v2 = 0x7F130053;  // string:album "앨범"
                            }
                            else if(MediaAttachType.h.equals(mediaAttachInfo0.a)) {
                                s2 = mediaAttachInfo0.E;
                                s3 = "아티스트, " + mediaAttachInfo0.k;
                                v2 = 0x7F1310EE;  // string:video "비디오"
                            }
                            else if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
                                v2 = 0x7F131106;  // string:youtube "Youtube"
                                s2 = mediaAttachInfo0.E + ", " + "YouTube에서";
                                s3 = "";
                            }
                            else if(MediaAttachType.e.equals(mediaAttachInfo0.a)) {
                                s2 = mediaAttachInfo0.k;
                                s3 = "";
                                v2 = 0x7F1300FC;  // string:artist "아티스트"
                            }
                            else {
                                if(MediaAttachType.j.equals(mediaAttachInfo0.a)) {
                                    v2 = 0x7F1302F2;  // string:desc_emoticon "Emoticon"
                                }
                                else {
                                    if(!MediaAttachType.k.equals(mediaAttachInfo0.a)) {
                                        continue;
                                    }
                                    v2 = 0x7F130B65;  // string:talkback_link "링크"
                                }
                                s3 = "";
                            }
                            stringBuilder0.append(this.getContext().getString(v2));
                            stringBuilder0.append(", ");
                            if(!s2.isEmpty()) {
                                stringBuilder0.append(s2);
                                stringBuilder0.append(", ");
                            }
                            if(!s3.isEmpty()) {
                                stringBuilder0.append(s3);
                                stringBuilder0.append(", ");
                            }
                            stringBuilder0.append("첨부");
                            stringBuilder0.append(", ");
                        }
                    }
                }
            }
        }
        if(z2) {
            stringBuilder0.append("답글");
            stringBuilder0.append(" ");
            stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.validadcmtcnt);
            stringBuilder0.append("개");
            stringBuilder0.append(", ");
        }
        if(z3) {
            if(cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag) {
                stringBuilder0.append("추천");
                stringBuilder0.append(" ");
                stringBuilder0.append("선택됨");
                stringBuilder0.append(", ");
            }
            if(cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag) {
                stringBuilder0.append("비추천");
                stringBuilder0.append(" ");
                stringBuilder0.append("선택됨");
                stringBuilder0.append(", ");
            }
            stringBuilder0.append("추천");
            stringBuilder0.append(" ");
            stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.recmcnt);
            stringBuilder0.append("개");
            stringBuilder0.append(", ");
            stringBuilder0.append("비추천");
            stringBuilder0.append(" ");
            stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt);
            stringBuilder0.append("개");
            if(v > 0) {
                stringBuilder0.append(", ");
                stringBuilder0.append("버튼");
            }
        }
        if(v > 0 && v1 > 0) {
            stringBuilder0.append(", ");
            stringBuilder0.append(this.getContext().getString(0x7F130AEC, new Object[]{v1, v}));  // string:talkback_comment_number_count "%1$d개 중 %2$d번째"
        }
        this.mainContainer.setContentDescription(stringBuilder0.toString());
    }
}

