package hd;

import A0.d;
import Ad.a;
import Ad.c;
import Ad.j;
import Cc.V3;
import Cc.W3;
import Jd.e;
import P0.K;
import X0.u;
import X0.x;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.fragments.r;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.EventPopupUiModel;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.GRAPHINFO.GRAPHDETAILINFO;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.GRAPHINFO;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYRECENTLIST.MYGNRLIST.GNRLIST;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.MonthlyInfo.GraphInfo.GraphDetailInfo;
import com.melon.ui.H1;
import com.melon.ui.K4;
import com.melon.ui.L1;
import com.melon.ui.N1;
import com.melon.ui.d1;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.i2;
import com.melon.ui.playback.VideoControllerHelper;
import com.melon.ui.playermusic.PlayerMoreView;
import com.melon.ui.popup.b;
import com.melon.ui.popup.context.more.ExtraProperties.Link;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import com.melon.ui.w1;
import com.melon.ui.x1;
import i.n.i.b.a.s.e.M3;
import id.B;
import id.E;
import id.F;
import id.f;
import id.w;
import ie.H;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import jd.A;
import jd.u1;
import je.g;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ld.m;
import ld.t;
import okio.ForwardingFileSystem;
import okio.Path;
import pc.l1;
import q8.h;
import td.F1;
import td.M;
import ud.L;
import ud.R0;
import ud.h0;
import vd.O;
import we.k;

public final class i implements k {
    public final int a;
    public final Object b;

    public i(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        e e0;
        Object object7;
        String s = "";
        boolean z = true;
        Link extraProperties$Link0 = null;
        H h0 = H.a;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                String s1 = ((GNRLIST)object1).gnrName;
                q.f(s1, "gnrName");
                u.h(((x)object0), s1);
                return h0;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                q.g(((GRAPHINFO)object1), "item");
                ArrayList arrayList0 = ((GRAPHINFO)object1).graphDetailInfo;
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append(((GRAPHINFO)object1).title);
                stringBuilder0.append(",");
                stringBuilder0.append(((GRAPHINFO)object1).subTitle);
                q.d(arrayList0);
                for(Object object2: arrayList0) {
                    stringBuilder0.append(((GRAPHDETAILINFO)object2).graph);
                    stringBuilder0.append(" ");
                    stringBuilder0.append(((GRAPHDETAILINFO)object2).graphDpCnt);
                    stringBuilder0.append(",");
                }
                String s2 = stringBuilder0.toString();
                q.f(s2, "toString(...)");
                u.h(((x)object0), s2);
                return h0;
            }
            case 2: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), ((GraphDetailInfo)object1).graph + ((GraphDetailInfo)object1).graphDpCnt);
                return h0;
            }
            case 3: {
                object7 = (X0)object1;
                break;
            }
            case 4: {
                q.g(((String)object0), "yearMonth");
                m1 m10 = (m1)((Y1)object1).getViewModel();
                m10.getClass();
                m10.h.setValue(((String)object0));
                m1 m11 = (m1)((Y1)object1).getViewModel();
                m11.getClass();
                BuildersKt__Builders_commonKt.launch$default(f0.h(m11), null, null, new k1(m11, null), 3, null);
                return h0;
            }
            case 5: {
                q.g(((B)object0), "it");
                F f0 = ((f)object1).f;
                if(f0 != null && (f0.a == E.c || f0.a == E.b)) {
                    ((f)object1).b(((B)object0), 2003, -1, 0L);
                }
                return h0;
            }
            case 6: {
                q.g(((String)object0), "it");
                LogU.debug$default(((id.k)object1).d, "The reason for the error is " + ((String)object0), null, false, 6, null);
                ((id.k)object1).q(false);
                FragmentActivity fragmentActivity0 = ((id.k)object1).getActivity();
                if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                    l0 l00 = ((id.k)object1).getChildFragmentManager();
                    String s3 = ((id.k)object1).getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    String s4 = ((id.k)object1).getString(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    b.d(b.a, l00, s3, s4, false, false, false, null, null, null, null, null, 2040);
                }
                return h0;
            }
            case 7: {
                return w.c(((Na.f)object1), ((K4)object0));
            }
            case 8: {
                q.g(((K4)object0), "it");
                return new jd.i(((EventPopupUiModel)object1));
            }
            case 9: {
                if(((j)object0) instanceof c) {
                    e.j j0 = e.k.c(f.f.a);
                    ((A)object1).f.b(j0);
                    return h0;
                }
                if(((j)object0) instanceof a) {
                    Context context0 = ((A)object1).getContext();
                    if(context0 != null) {
                        Intent intent0 = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent0.setFlags(2);
                        Uri uri0 = FileUtils.getFileUri(context0, FileUtils.createImageFile(context0));
                        ((A)object1).h = uri0;
                        intent0.putExtra("output", uri0);
                        ((A)object1).g.b(intent0);
                    }
                }
                return h0;
            }
            case 10: {
                return u1.c(((u1)object1), ((d1)object0));
            }
            case 11: {
                return object0 == ((je.a)object1) ? "(this Collection)" : String.valueOf(object0);
            }
            case 12: {
                q.g(((Map.Entry)object0), "it");
                StringBuilder stringBuilder1 = new StringBuilder();
                Object object3 = ((Map.Entry)object0).getKey();
                String s5 = "(this Map)";
                stringBuilder1.append((object3 == ((g)object1) ? "(this Map)" : String.valueOf(object3)));
                stringBuilder1.append('=');
                Object object4 = ((Map.Entry)object0).getValue();
                if(object4 != ((g)object1)) {
                    s5 = String.valueOf(object4);
                }
                stringBuilder1.append(s5);
                return stringBuilder1.toString();
            }
            case 13: {
                q.g(((d)object0), "$this$drawWithContent");
                ((K)(((d)object0))).a();
                A0.f.t(((d)object0), new y0.e(((Bitmap)object1)), null, 62);
                return h0;
            }
            case 14: {
                IOException iOException0 = (IOException)object0;
                ((l5.f)object1).k = true;
                return h0;
            }
            case 15: {
                return BaseActivity.initBigUserBlockedProgressDialog$lambda$2(((BaseActivity)object1), ((Throwable)object0));
            }
            case 16: {
                q.g(((h)object0), "$this$track");
                String s6 = ((ld.b)object1).getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                if(s6 != null) {
                    s = s6;
                }
                ((h)object0).a = s;
                return h0;
            }
            case 17: {
                ((m)object1).sendUserEvent(new ld.d(((int)(((Integer)object0)))));
                return h0;
            }
            case 18: {
                q.g(((W3)object0), "toolBarUserEvent");
                if(!(((W3)object0) instanceof V3)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                switch(((V3)(((W3)object0))).b) {
                    case 0: {
                        e0 = e.c;
                        break;
                    }
                    case 1: {
                        e0 = Jd.c.c;
                        break;
                    }
                    case 2: {
                        e0 = Jd.b.c;
                        break;
                    }
                    case 14: {
                        e0 = Jd.f.c;
                        break;
                    }
                    case 0x1F: {
                        e0 = Jd.d.c;
                        break;
                    }
                    default: {
                        e0 = null;
                    }
                }
                if(e0 != null) {
                    ld.q q0 = ((ld.x)object1).d();
                    if(q0 != null) {
                        ArrayList arrayList1 = new ArrayList();
                        for(Object object5: q0.e) {
                            if(((Kd.g)object5).N) {
                                arrayList1.add(object5);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
                        for(Object object6: arrayList1) {
                            arrayList2.add(Kd.h.b(((Kd.g)object6), ((ld.x)object1).getMenuId()));
                        }
                        BuildersKt__Builders_commonKt.launch$default(f0.h(((ld.x)object1)), null, null, new t(e0, ((ld.x)object1), arrayList2, null), 3, null);
                    }
                }
                return h0;
            }
            case 19: {
                q.g(((r1.c)object0), "$this$offset");
                return new r1.j(((long)ye.a.V(((md.h)object1).m)) & 0xFFFFFFFFL);
            }
            case 20: {
                return ForwardingFileSystem.c(((ForwardingFileSystem)object1), ((Path)object0));
            }
            case 21: {
                ((VideoControllerHelper)object1).f.z(((long)(((int)(((Integer)object0))))));
                return h0;
            }
            case 22: {
                q.g(((q8.f)object0), "$this$eventMeta");
                ((q8.f)object0).a = ((l1)object1).c;
                ((q8.f)object0).b = Y.i(ContsTypeCode.SONG_MIXUP, "code(...)");
                ((q8.f)object0).c = ((l1)object1).d;
                return h0;
            }
            case 23: {
                q.g(((MelonBottomSheetItem)object0), "type");
                LogU.debug$default(((PlayerMoreView)object1).w, "itemClickListener() type:" + ((MelonBottomSheetItem)object0), null, false, 6, null);
                Playable playable0 = ((PlayerMoreView)object1).N;
                if(playable0 == null) {
                    LogU.warn$default(((PlayerMoreView)object1).w, "itemClickListener() skipped because playable is null", null, false, 6, null);
                    return h0;
                }
                switch(((MelonBottomSheetItem)object0).a.ordinal()) {
                    case 9: {
                        F1 f10 = ((PlayerMoreView)object1).M;
                        if(f10 != null) {
                            q.f("", "getSongidString(...)");
                            ((M)f10).onEvent(new f2(playable0, ""));
                            return h0;
                        }
                        break;
                    }
                    case 10: {
                        F1 f11 = ((PlayerMoreView)object1).M;
                        if(f11 != null) {
                            ((M)f11).onEvent(new w1(playable0));
                            return h0;
                        }
                        break;
                    }
                    case 11: {
                        F1 f12 = ((PlayerMoreView)object1).M;
                        if(f12 != null) {
                            ((M)f12).onEvent(new x1(playable0, null, 2));
                            return h0;
                        }
                        break;
                    }
                    case 16: {
                        F1 f13 = ((PlayerMoreView)object1).M;
                        if(f13 != null) {
                            ((M)f13).onEvent(new N1(playable0));
                            return h0;
                        }
                        break;
                    }
                    case 19: {
                        F1 f14 = ((PlayerMoreView)object1).M;
                        if(f14 != null) {
                            ((M)f14).onEvent(new e2(""));
                            return h0;
                        }
                        break;
                    }
                    case 23: {
                        F1 f15 = ((PlayerMoreView)object1).M;
                        if(f15 != null) {
                            ((M)f15).onEvent(new L1(playable0));
                            return h0;
                        }
                        break;
                    }
                    case 37: {
                        ExtraProperties extraProperties0 = ((MelonBottomSheetItem)object0).f;
                        if(extraProperties0 instanceof Link) {
                            extraProperties$Link0 = (Link)extraProperties0;
                        }
                        if(extraProperties$Link0 != null) {
                            F1 f16 = ((PlayerMoreView)object1).M;
                            if(f16 != null) {
                                String s7 = extraProperties$Link0.a == null ? "" : extraProperties$Link0.a;
                                String s8 = extraProperties$Link0.b;
                                if(s8 != null) {
                                    s = s8;
                                }
                                ((M)f16).onEvent(new i2(s7, s));
                                return h0;
                            }
                        }
                        break;
                    }
                    case 76: {
                        F1 f17 = ((PlayerMoreView)object1).M;
                        if(f17 != null) {
                            ((M)f17).onEvent(new H1("", "", ((PlayerMoreView)object1).B));
                            return h0;
                        }
                        break;
                    }
                    default: {
                        return h0;
                    }
                }
                return h0;
            }
            case 24: {
                object7 = (L)object1;
                break;
            }
            case 25: {
                R0.c(((R0)object1), ((d1)object0));
                return null;
            }
            case 26: {
                object7 = (h0)object1;
                break;
            }
            case 27: {
                q.g(((I)object0), "fragment");
                if(!(((I)object0) instanceof vd.i) || !q.b(((vd.i)(((I)object0))).e, "안내") || !q.b(((vd.i)(((I)object0))).f, "로그인 후 이용해 주세요.")) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            case 28: {
                q.g(((I)object0), "fragment");
                if(!(((I)object0) instanceof vd.L) || ((vd.L)(((I)object0))).e != ((O)object1)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            default: {
                q.g(object0, "rating");
                ((r)object1).invoke(((float)(((float)(((int)(((Integer)object0))))) / 2.0f)));
                return h0;
            }
        }
        K4 k40 = (K4)object0;
        return object7;
    }
}

