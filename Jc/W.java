package Jc;

import A7.d;
import Ad.s;
import J8.K1;
import J8.x;
import Tf.o;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MediaAttachmentLayout;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.fragments.comments.CmtResourceUtils;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AtachListBase;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.q;
import v9.b;
import v9.c;
import va.e;
import y5.a;

public final class w extends O0 {
    public final K1 a;
    public static final int b;

    public w(K1 k10) {
        super(k10.a);
        this.a = k10;
        ((BorderImageView)k10.q.d).setImageDrawable(null);
        k10.v.setText("");
    }

    // This method was un-flattened
    public final void a(K k0) {
        String s15;
        String s14;
        int v11;
        String s12;
        String s9;
        String s5;
        String s = k0.S;
        String s1 = k0.E;
        int v = k0.I;
        int v1 = k0.D;
        int v2 = k0.f0;
        boolean z = k0.j;
        String s2 = k0.W;
        boolean z1 = k0.g;
        int v3 = k0.N;
        List list0 = k0.s0;
        c c0 = k0.o;
        int v4 = k0.b0;
        Context context0 = a.B(this);
        int v5 = k0.Y;
        K1 k10 = this.a;
        int v6 = k0.d0;
        String s3 = k0.e0;
        MelonTextView melonTextView0 = k10.r;
        boolean z2 = k0.c0;
        Group group0 = k10.l;
        boolean z3 = k0.Z;
        MelonTextView melonTextView1 = k10.v;
        MediaAttachmentLayout mediaAttachmentLayout0 = k10.b;
        ConstraintLayout constraintLayout0 = k10.a;
        int v7 = ScreenUtils.dipToPixel(context0, 28.0f);
        boolean z4 = k0.X;
        ViewUtils.setDefaultImage(((ImageView)k10.q.c), v7, true);
        RequestBuilder requestBuilder0 = Glide.with(this.itemView.getContext()).load(k0.h).apply(RequestOptions.circleCropTransform());
        x x0 = k10.q;
        requestBuilder0.into(((BorderImageView)x0.d));
        k10.A.setVisibility((k0.B ? 8 : 0));
        ((BorderImageView)x0.d).setImportantForAccessibility(2);
        MelonTextView melonTextView2 = k10.y;
        if(v1 > -1) {
            melonTextView2.setText((z1 ? "ARTIST" : "DJ"));
            melonTextView2.setTextColor(ColorUtils.getColor(context0, v1));
            melonTextView2.setVisibility(0);
        }
        else {
            melonTextView2.setVisibility(8);
        }
        melonTextView1.setOnClickListener(new t(k0, 0));
        t t0 = new t(k0, 1);
        ((BorderImageView)x0.d).setOnClickListener(t0);
        ImageView imageView0 = k10.m;
        if(v == 0) {
            imageView0.setVisibility(8);
        }
        else {
            imageView0.setVisibility(0);
            imageView0.setImageResource(v);
        }
        melonTextView1.setText(s1);
        melonTextView1.setTextColor(ColorUtils.getColor(context0, CmtResourceUtils.getCmtNicknameColorResId(c0, k0.e)));
        k10.e.setVisibility((k0.M ? 0 : 8));
        if(v3 > -1) {
            k10.g.setText(String.valueOf(v3));
            int v8 = ResourceUtils.getFriendlyColorId(context0, v3);
            k10.g.setTextColor(v8);
            k10.h.setImageResource(ResourceUtils.get4dpDegreeImageResId(v3));
            group0.setVisibility(0);
        }
        else {
            group0.setVisibility(8);
        }
        k10.f.setVisibility((k0.r ? 0 : 8));
        k10.t.setText(s);
        if(z) {
            String s4 = k0.T;
            if(s4 != null) {
                k10.o.setText(s4);
                t t1 = new t(k0, 2);
                k10.p.setOnClickListener(t1);
            }
        }
        k10.i.setVisibility((z ? 0 : 8));
        if(s2 == null || s2.length() == 0) {
            s5 = s2;
        }
        else {
            Pattern pattern0 = Pattern.compile("\n");
            q.f(pattern0, "compile(...)");
            s5 = pattern0.matcher(s2).replaceAll("<br>");
            q.f(s5, "replaceAll(...)");
        }
        k10.u.setVisibility((z ? 8 : 0));
        k10.u.setText(Html.fromHtml(s5, 0));
        k10.u.setMaxLines((z4 ? 1000 : 5));
        k10.u.setEllipsize((z4 ? null : TextUtils.TruncateAt.END));
        k10.u.setOnClickListener(new s(11, k0, k10.u));
        if(mediaAttachmentLayout0.getCount() > 1) {
            mediaAttachmentLayout0.setExpand(z4);
        }
        k10.c.setEnabled(k0.k || k0.l);
        x1.a.N(k10.c, new t(k0, 3));
        String s6 = StringUtils.getCountString(String.valueOf(v5), 0xF423F);
        k10.z.setText(s6);
        k10.z.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtRecomCountIconResId(c0, z3), 0, 0, 0);
        int v9 = ColorUtils.getColor(context0, CmtResourceUtils.getCmtRecomCountColorResId(c0, z3));
        k10.z.setTextColor(v9);
        t t2 = new t(k0, 4);
        k10.z.setOnClickListener(t2);
        k10.k.setVisibility((k0.n ? 0 : 8));
        String s7 = StringUtils.getCountString(String.valueOf(v4), 0xF423F);
        k10.w.setText(s7);
        k10.w.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtNonRecomCountIconResId(c0, z2), 0, 0, 0);
        int v10 = ColorUtils.getColor(context0, CmtResourceUtils.getCmtNonRecomCountColorResId(c0, z2));
        k10.w.setTextColor(v10);
        t t3 = new t(k0, 5);
        k10.w.setOnClickListener(t3);
        melonTextView0.setText(StringUtils.getCountString(String.valueOf(v6), 0xF423F));
        k10.j.setVisibility((k0.m ? 0 : 8));
        melonTextView0.setOnClickListener(new t(k0, 6));
        t t4 = new t(k0, 7);
        k10.s.setOnClickListener(t4);
        RecommenderView recommenderView0 = k10.n;
        if(s3 == null || s3.length() == 0) {
            recommenderView0.setVisibility(8);
        }
        else {
            recommenderView0.setVisibility(0);
            recommenderView0.setProfileImage(s3);
        }
        mediaAttachmentLayout0.removeAllViews();
        if(v2 <= 0 || list0 == null || list0.isEmpty()) {
            s9 = "link_genrl";
            mediaAttachmentLayout0.setVisibility(8);
        }
        else {
            ViewUtils.setEnable(mediaAttachmentLayout0, true);
            for(Object object0: list0) {
                AtachListBase cmtSharedTypeRes$AtachListBase0 = (AtachListBase)object0;
                if(mediaAttachmentLayout0.getCount() >= 999) {
                    break;
                }
                String s8 = cmtSharedTypeRes$AtachListBase0.atachtype;
                if(!q.b(s8, "image") && !q.b(s8, "music_album") && !q.b(s8, "music_artist") && !q.b(s8, "music_song") && !q.b(s8, "video") && !q.b(s8, "link_video") && !q.b(s8, "kakao_emoticon") && !q.b(s8, "link_genrl")) {
                    com.iloen.melon.utils.a.v("not supported attachType:", cmtSharedTypeRes$AtachListBase0.atachtype, LogU.Companion, "DetailCommentHolder");
                }
                else {
                    MediaAttachInfo mediaAttachInfo0 = b.a(cmtSharedTypeRes$AtachListBase0);
                    if(mediaAttachInfo0 != null) {
                        mediaAttachInfo0.b = 1;
                        mediaAttachInfo0.W = c0;
                        mediaAttachmentLayout0.a(mediaAttachInfo0);
                        if(MediaAttachType.c.equals(mediaAttachInfo0.a) || MediaAttachType.d.equals(mediaAttachInfo0.a)) {
                            ViewUtils.setEnable(mediaAttachmentLayout0, !mediaAttachInfo0.Y);
                        }
                        mediaAttachmentLayout0.setOnAttachmentClickListener(new u(mediaAttachInfo0, k0));
                    }
                }
            }
            s9 = "link_genrl";
            if(mediaAttachmentLayout0.getCount() > 0) {
                mediaAttachmentLayout0.setVisibility(0);
                mediaAttachmentLayout0.setExpand(false);
            }
        }
        q.f(constraintLayout0, "getRoot(...)");
        Context context1 = constraintLayout0.getContext();
        StringBuilder stringBuilder0 = new StringBuilder();
        d.u(stringBuilder0, (z1 ? "아티스트" : "작성자"), " ", s1, ", ");
        if(k0.w) {
            stringBuilder0.append("친밀도");
            stringBuilder0.append(" ");
            stringBuilder0.append(v3);
            stringBuilder0.append("도");
            stringBuilder0.append(", ");
        }
        q.d(context1);
        String s10 = s == null ? "" : s;
        List list1 = o.R0(s10, new String[]{"."}, 0, 6);
        if(list1.size() == 3) {
            s10 = ((String)list1.get(0)) + "년" + " " + StringUtils.getNumberFromString(((String)list1.get(1))) + "월" + " " + ((String)list1.get(2)) + "일";
            q.d(s10);
        }
        stringBuilder0.append("작성시간");
        stringBuilder0.append(" ");
        stringBuilder0.append(s10);
        e.g(stringBuilder0, ", ", s2, ", ");
        if(v2 > 0 && list0 != null) {
            for(Object object1: list0) {
                AtachListBase cmtSharedTypeRes$AtachListBase1 = (AtachListBase)object1;
                String s11 = cmtSharedTypeRes$AtachListBase1.atachtype;
                if("image".equals(s11) || "music_album".equals(s11) || "music_artist".equals(s11) || "music_song".equals(s11) || "video".equals(s11) || "link_video".equals(s11) || "kakao_emoticon".equals(s11)) {
                    s12 = s9;
                }
                else {
                    s12 = s9;
                    if(!s12.equals(s11)) {
                        goto label_229;
                    }
                }
                MediaAttachInfo mediaAttachInfo1 = b.a(cmtSharedTypeRes$AtachListBase1);
                if(mediaAttachInfo1 == null) {
                }
                else if(MediaAttachType.g.equals(mediaAttachInfo1.a) || MediaAttachType.f.equals(mediaAttachInfo1.a)) {
                    v11 = 0x7F130B50;  // string:talkback_image "이미지"
                    s15 = "";
                    s14 = "";
                label_217:
                    stringBuilder0.append(context1.getString(v11));
                    stringBuilder0.append(", ");
                    if(s15.length() > 0) {
                        stringBuilder0.append(s15);
                        stringBuilder0.append(", ");
                    }
                    if(s14.length() > 0) {
                        stringBuilder0.append(s14);
                        stringBuilder0.append(", ");
                    }
                    stringBuilder0.append("첨부");
                    stringBuilder0.append(", ");
                }
                else if(MediaAttachType.c.equals(mediaAttachInfo1.a)) {
                    String s13 = mediaAttachInfo1.j;
                    q.f(s13, "song");
                    v11 = 0x7F130A63;  // string:song "곡"
                    s14 = "아티스트, " + mediaAttachInfo1.k;
                    s15 = s13;
                    goto label_217;
                }
                else if(MediaAttachType.d.equals(mediaAttachInfo1.a)) {
                    String s16 = mediaAttachInfo1.i;
                    q.f(s16, "album");
                    v11 = 0x7F130053;  // string:album "앨범"
                    s14 = "아티스트, " + mediaAttachInfo1.k;
                    s15 = s16;
                    goto label_217;
                }
                else if(MediaAttachType.h.equals(mediaAttachInfo1.a)) {
                    String s17 = mediaAttachInfo1.E;
                    q.f(s17, "mvTitle");
                    v11 = 0x7F1310EE;  // string:video "비디오"
                    s14 = "아티스트, " + mediaAttachInfo1.k;
                    s15 = s17;
                    goto label_217;
                }
                else if(MediaAttachType.i.equals(mediaAttachInfo1.a)) {
                    s15 = mediaAttachInfo1.E + ", " + "YouTube에서";
                    v11 = 0x7F131106;  // string:youtube "Youtube"
                    s14 = "";
                    goto label_217;
                }
                else if(MediaAttachType.e.equals(mediaAttachInfo1.a)) {
                    s15 = mediaAttachInfo1.k;
                    q.f(s15, "artist");
                    s14 = "";
                    v11 = 0x7F1300FC;  // string:artist "아티스트"
                    goto label_217;
                }
                else if(MediaAttachType.j.equals(mediaAttachInfo1.a)) {
                    v11 = 0x7F1302F2;  // string:desc_emoticon "Emoticon"
                    s15 = "";
                    s14 = "";
                    goto label_217;
                }
                else if(MediaAttachType.k.equals(mediaAttachInfo1.a)) {
                    v11 = 0x7F130B65;  // string:talkback_link "링크"
                    s15 = "";
                    s14 = "";
                    goto label_217;
                }
            label_229:
                s9 = s12;
            }
        }
        stringBuilder0.append("답글");
        stringBuilder0.append(" ");
        stringBuilder0.append(v6);
        stringBuilder0.append("개");
        stringBuilder0.append(", ");
        if(z3) {
            stringBuilder0.append("추천");
            stringBuilder0.append(" ");
            stringBuilder0.append("선택됨");
            stringBuilder0.append(", ");
        }
        if(z2) {
            stringBuilder0.append("비추천");
            stringBuilder0.append(" ");
            stringBuilder0.append("선택됨");
            stringBuilder0.append(", ");
        }
        stringBuilder0.append("추천");
        stringBuilder0.append(" ");
        stringBuilder0.append(v5);
        stringBuilder0.append("개");
        stringBuilder0.append(", ");
        stringBuilder0.append("비추천");
        stringBuilder0.append(" ");
        stringBuilder0.append(v4);
        stringBuilder0.append("개");
        stringBuilder0.append(", ");
        stringBuilder0.append("버튼");
        constraintLayout0.setContentDescription(stringBuilder0.toString());
        constraintLayout0.setAccessibilityDelegate(new v(constraintLayout0.getContext(), k0, k10));
    }
}

