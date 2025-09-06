package com.iloen.melon.utils;

import A8.M;
import Q1.c;
import Tf.a;
import Tf.v;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaybackScheme;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageListFragment;
import com.iloen.melon.fragments.news.FeedLogsListFragment;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.popup.H;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.cipher.Rijndael_Algorithm;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.ui.popup.b;
import e1.u;
import ie.d;
import java.net.URLEncoder;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\tJ#\u0010\u0005\u001A\u00020\u00042\b\u0010\n\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\u000BJ#\u0010\u000E\u001A\u00020\u00072\b\u0010\f\u001A\u0004\u0018\u00010\u00072\b\u0010\r\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\tJ+\u0010\u0013\u001A\u00020\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u00072\b\u0010\n\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0016\u001A\u00020\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u00072\b\u0010\u0015\u001A\u0004\u0018\u00010\u00072\b\u0010\r\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\u0014J)\u0010\u001A\u001A\u00020\u00042\b\u0010\u0017\u001A\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001A\u0010\u001BJ=\u0010\u001C\u001A\u00020\u00042\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0010\u001A\u00020\u00072\u0010\b\u0002\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001C\u0010\u001DJ\'\u0010 \u001A\u00020\u00042\u0006\u0010\u001F\u001A\u00020\u001E2\u0010\b\u0002\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/iloen/melon/utils/MelonLinkExecutor;", "", "Lcom/iloen/melon/types/MelonLinkInfo;", "linkInfo", "Lie/H;", "open", "(Lcom/iloen/melon/types/MelonLinkInfo;)V", "", "linkUrl", "(Ljava/lang/String;)V", "linkType", "(Ljava/lang/String;Ljava/lang/String;)V", "serviceCode", "contentId", "getCleanReportUrl", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "scheme", "openWithScheme", "titleName", "openWithTitleName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "targetView", "openInAppWithTitleName", "url", "Lkotlin/Function0;", "action", "openUrl", "(Ljava/lang/String;Lwe/a;)V", "openLinkInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lwe/a;)V", "Lcom/iloen/melon/net/v4x/common/BannerBase;", "banner", "openBannerLinkInfo", "(Lcom/iloen/melon/net/v4x/common/BannerBase;Lwe/a;)V", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonLinkExecutor {
    public static final int $stable = 0;
    @NotNull
    public static final MelonLinkExecutor INSTANCE = null;
    @NotNull
    public static final String TAG = "MelonLinkExecutor";

    static {
        MelonLinkExecutor.INSTANCE = new MelonLinkExecutor();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public static final String getCleanReportUrl(@Nullable String s, @Nullable String s1) {
        MelonAppBase.Companion.getClass();
        String s2 = M.K + "?cpId=" + t.a().getMelonCpId() + "&memberKey=" + u.v(((e0)o.a()).j()) + "&serviceCode=" + s + "&contentId=" + s1;
        q.f(s2, "toString(...)");
        return s2;
    }

    public static final void open(@Nullable MelonLinkInfo melonLinkInfo0) {
        if(melonLinkInfo0 == null) {
            LogU.Companion.w("MelonLinkExecutor", "open() invalid parameter");
            return;
        }
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.v("MelonLinkExecutor", "open() " + melonLinkInfo0);
        String s = melonLinkInfo0.a;
        String s1 = melonLinkInfo0.b;
        String s2 = melonLinkInfo0.c;
        String s3 = melonLinkInfo0.f;
        String s4 = melonLinkInfo0.g;
        String s5 = melonLinkInfo0.h;
        boolean z = melonLinkInfo0.r;
        if(!URLUtil.isNetworkUrl(s1) && (TextUtils.isEmpty(s) || "MA".equalsIgnoreCase(s))) {
            if(TextUtils.isEmpty(s4)) {
                goto label_70;
            }
            if("song".equalsIgnoreCase(s4)) {
                if(!TextUtils.isEmpty(s5)) {
                    q.d(s5);
                    Navigator.openSongInfo(s5);
                }
            }
            else if("album".equalsIgnoreCase(s4)) {
                if(!TextUtils.isEmpty(s5)) {
                    Navigator.openAlbumInfo(s5);
                }
            }
            else if("artist".equalsIgnoreCase(s4)) {
                if(!TextUtils.isEmpty(s5)) {
                    Navigator.openArtistInfo(s5);
                }
            }
            else if("vdo".equalsIgnoreCase(s4)) {
                if(!TextUtils.isEmpty(s5)) {
                    Navigator.openMvInfo$default(s5, "1000000550", null, false, 12, null);
                }
            }
            else if("gift".equalsIgnoreCase(s4)) {
                if(!TextUtils.isEmpty(s5)) {
                    Navigator.openGiftBoxDetailById(s5);
                }
            }
            else if("songmsg".equalsIgnoreCase(s4)) {
                if(!TextUtils.isEmpty(s5)) {
                    Navigator.open(MusicMessageListFragment.Companion.newInstance());
                }
            }
            else if(!"msg".equalsIgnoreCase(s4)) {
                if("djcol".equalsIgnoreCase(s4)) {
                    Navigator.openDjPlaylistDetail(s5);
                    return;
                }
                if("photo".equalsIgnoreCase(s4)) {
                    Navigator.openPhotoDetailView(s5);
                    return;
                }
                if("newmusic".equalsIgnoreCase(s4)) {
                    Navigator.openNewMusicMain();
                    return;
                }
                if("chart".equalsIgnoreCase(s4)) {
                    Navigator.openChartMain();
                    return;
                }
                if("tv".equalsIgnoreCase(s4)) {
                    Navigator.openMelonTvMain();
                    return;
                }
                if("news".equalsIgnoreCase(s4)) {
                    Navigator.open(FeedLogsListFragment.Companion.newInstance());
                    return;
                label_70:
                    if(TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2)) {
                        logU$Companion0.w("MelonLinkExecutor", "open() invalid linkUrl & scheme");
                        return;
                    }
                    if(TextUtils.isEmpty(s1)) {
                        s1 = s2;
                    }
                    logU$Companion0.v("MelonLinkExecutor", "open() uri: " + s1);
                    q.d(s1);
                    Uri uri0 = Uri.parse(s1);
                    if(9000 == f.c(uri0)) {
                        EventBusHelper.post(new EventPlaybackScheme(uri0));
                        return;
                    }
                    Intent intent1 = new Intent();
                    c.Y(intent1, "android.intent.action.VIEW", false);
                    intent1.setData(uri0);
                    intent1.addFlags(0x10000000);
                    intent1.putExtra("title", s3);
                    intent1.putExtra("fromInfoPusH", z);
                    try {
                        MelonAppBase.Companion.getClass();
                        t.a().getContext().startActivity(intent1);
                    }
                    catch(ActivityNotFoundException unused_ex) {
                        BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
                        if(baseActivity0 != null && !baseActivity0.isFinishing()) {
                            b.x(baseActivity0.getSupportFragmentManager(), "안내", "현재 버전에서 지원하지 않는 기능입니다. 앱 업데이트 후 사용해주세요.", true, false, null, null, new H(5), null, null, null, 0x800);
                        }
                    }
                }
            }
            else if(!TextUtils.isEmpty(s5)) {
                MelonAppBase.Companion.getClass();
                if(t.a().isMusicMessageTopStack()) {
                    Intent intent0 = new Intent();
                    c.Y(intent0, "com.iloen.melon.intent.action.music_message", true);
                    intent0.putExtra("com.iloen.melon.intent.action.music_message.inbox_seq", s5);
                    intent0.putExtra("com.iloen.melon.intent.action.music_message.need_reload", "Y");
                    intent0.putExtra("fromInfoPusH", z);
                    t.a().getContext().sendBroadcast(intent0);
                    return;
                }
                Navigator.open(MusicMessageEditorFragment.Companion.newInstance(null, s5, "N"));
            }
        }
        else if("ZA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.DefaultWebViewWithMiniPlayer);
            }
        }
        else if("YA".equalsIgnoreCase(s) || "XA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.DefaultWebView);
            }
        }
        else if("IA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FirstDepth);
            }
        }
        else if("GA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FirstDepthExtension);
            }
        }
        else if("PA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FullScreenWithBar);
            }
        }
        else if("CA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FullScreen);
            }
        }
        else if("BA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FullScreenBlank);
            }
        }
        else if("SA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FullScreenWithMiniPlayer);
            }
        }
        else if("EA".equalsIgnoreCase(s)) {
            MelonAppBase.Companion.getClass();
            if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                Navigator.openUrl(s1, OpenType.FullScreenWithBackButton);
            }
        }
        else if(!"OA".equalsIgnoreCase(s)) {
            if("FA".equalsIgnoreCase(s)) {
                Intent intent3 = new Intent();
                c.Y(intent3, "android.intent.action.VIEW", false);
                intent3.setFlags(0x10000000);
                intent3.putExtra("fromInfoPusH", z);
                try {
                    q.d(s2);
                    intent3.setData(Uri.parse(s2));
                    MelonAppBase.Companion.getClass();
                    t.a().getContext().startActivity(intent3);
                }
                catch(Exception exception0) {
                    LogU.Companion.w("MelonLinkExecutor", "open() FA - " + exception0);
                    MelonLinkExecutor.open("OA", s1);
                }
                return;
            }
            if(!"NA".equalsIgnoreCase(s)) {
                MelonAppBase.Companion.getClass();
                if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                    Navigator.openUrlFullScreenWithMiniPlayerView(s3, s1);
                }
            }
        }
        else if(!TextUtils.isEmpty(s1)) {
            q.d(s1);
            if((v.r0(s1, "http://", false) || v.r0(s1, "https://", false)) && Tf.o.v0(s1, ".melon.com", false) && ((e0)o.a()).m()) {
                MelonLinkExecutor.INSTANCE.getClass();
                try {
                    if(((e0)o.a()).m() && false && false) {
                        q.d("");
                        byte[] arr_b = "".getBytes(a.a);
                        q.f(arr_b, "getBytes(...)");
                        byte[] arr_b1 = "".getBytes(a.a);
                        q.f(arr_b1, "getBytes(...)");
                        byte[] arr_b2 = Rijndael_Algorithm.Encrypt_String(arr_b, arr_b1.length);
                        q.f(arr_b2, "Encrypt_String(...)");
                        q.d("20250906113327");
                        byte[] arr_b3 = "20250906113327".getBytes(a.a);
                        q.f(arr_b3, "getBytes(...)");
                        byte[] arr_b4 = "20250906113327".getBytes(a.a);
                        q.f(arr_b4, "getBytes(...)");
                        byte[] arr_b5 = Rijndael_Algorithm.Encrypt_String(arr_b3, arr_b4.length);
                        q.f(arr_b5, "Encrypt_String(...)");
                        StringBuilder stringBuilder0 = new StringBuilder();
                        stringBuilder0.append(M.O);
                        stringBuilder0.append("?forwardPage=");
                        stringBuilder0.append(URLEncoder.encode(s1, "utf-8"));
                        stringBuilder0.append("&mi=");
                        stringBuilder0.append(URLEncoder.encode(new String(arr_b2, a.a), "utf-8"));
                        stringBuilder0.append("&tkn=");
                        stringBuilder0.append("");
                        stringBuilder0.append("&time=");
                        stringBuilder0.append(URLEncoder.encode(new String(arr_b5, a.a), "utf-8"));
                        logU$Companion0.d("MelonLinkExecutor", "getURLWithUserInfo() URL : " + stringBuilder0);
                        s1 = stringBuilder0.toString();
                    }
                }
                catch(Exception unused_ex) {
                }
            }
            Intent intent2 = new Intent();
            c.Y(intent2, "android.intent.action.VIEW", false);
            q.d(s1);
            intent2.setData(Uri.parse(s1));
            intent2.addFlags(0x10000000);
            intent2.putExtra("fromInfoPusH", z);
            try {
                MelonAppBase.Companion.getClass();
                t.a().getContext().startActivity(intent2);
            }
            catch(ActivityNotFoundException activityNotFoundException0) {
                LogU.Companion.w("MelonLinkExecutor", "open() OA - " + activityNotFoundException0);
            }
        }
    }

    public static final void open(@Nullable String s) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.b = s;
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    public static final void open(@Nullable String s, @Nullable String s1) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.a = s;
        melonLinkInfo0.b = s1;
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    public final void openBannerLinkInfo(@NotNull BannerBase bannerBase0, @Nullable we.a a0) {
        q.g(bannerBase0, "banner");
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.a = bannerBase0.linktype;
        melonLinkInfo0.b = bannerBase0.linkurl;
        melonLinkInfo0.c = bannerBase0.scheme;
        melonLinkInfo0.n = bannerBase0.contsid;
        melonLinkInfo0.o = bannerBase0.contstypecode;
        MelonLinkExecutor.open(melonLinkInfo0);
        if(a0 != null) {
            a0.invoke();
        }
    }

    public static void openBannerLinkInfo$default(MelonLinkExecutor melonLinkExecutor0, BannerBase bannerBase0, we.a a0, int v, Object object0) {
        if((v & 2) != 0) {
            a0 = null;
        }
        melonLinkExecutor0.openBannerLinkInfo(bannerBase0, a0);
    }

    @d
    public final void openInAppWithTitleName(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.f = s;
        melonLinkInfo0.g = s1;
        melonLinkInfo0.h = s2;
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    public final void openLinkInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable we.a a0) {
        q.g(s, "linkType");
        q.g(s1, "linkUrl");
        q.g(s2, "scheme");
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.a = s;
        melonLinkInfo0.b = s1;
        melonLinkInfo0.c = s2;
        MelonLinkExecutor.open(melonLinkInfo0);
        if(a0 != null) {
            a0.invoke();
        }
    }

    public static void openLinkInfo$default(MelonLinkExecutor melonLinkExecutor0, String s, String s1, String s2, we.a a0, int v, Object object0) {
        if((v & 1) != 0) {
            s = "";
        }
        if((v & 2) != 0) {
            s1 = "";
        }
        if((v & 4) != 0) {
            s2 = "";
        }
        if((v & 8) != 0) {
            a0 = null;
        }
        melonLinkExecutor0.openLinkInfo(s, s1, s2, a0);
    }

    public final void openUrl(@Nullable String s, @Nullable we.a a0) {
        if(s != null && s.length() != 0) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.c = s;
            MelonLinkExecutor.open(melonLinkInfo0);
            if(a0 != null) {
                a0.invoke();
            }
        }
    }

    public static void openUrl$default(MelonLinkExecutor melonLinkExecutor0, String s, we.a a0, int v, Object object0) {
        if((v & 2) != 0) {
            a0 = null;
        }
        melonLinkExecutor0.openUrl(s, a0);
    }

    public final void openWithScheme(@Nullable String s) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.c = s;
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    public final void openWithTitleName(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.f = s;
        melonLinkInfo0.a = s1;
        melonLinkInfo0.b = s2;
        MelonLinkExecutor.open(melonLinkInfo0);
    }
}

