package com.iloen.melon.player.playlist.tiara;

import A7.d;
import U4.x;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/ToolbarTiaraLogHelper;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ToolbarTiaraLogHelper {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J/\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\fR\u0014\u0010\u000E\u001A\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/ToolbarTiaraLogHelper$Companion;", "", "", "toolbarButtonType", "Lp8/s;", "tiaraProperty", "", "Lcom/iloen/melon/playback/Playable;", "songList", "Lie/H;", "sendClickLog", "(ILp8/s;Ljava/util/List;)V", "(I)V", "", "TAG", "Ljava/lang/String;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static String a(int v) {
            switch(v) {
                case 0: {
                    return "";
                }
                case 1: {
                    return "";
                }
                case 2: {
                    return "";
                }
                case 14: {
                    return "";
                }
                case 0x1F: {
                    return "";
                }
                default: {
                    return "";
                }
            }
        }

        public final void sendClickLog(int v) {
            MelonAppBase.Companion.getClass();
            t.a().getContext();
            ToolbarTiaraLogHelper.Companion.getClass();
            ActionKind actionKind0 = v == 0 || v == 0x1F ? ActionKind.PlayMusic : null;
            String s = Companion.a(v);
            StringBuilder stringBuilder0 = new StringBuilder("sendClickLog() - actionName: ");
            stringBuilder0.append("");
            stringBuilder0.append(", actionKind: ");
            stringBuilder0.append(actionKind0);
            stringBuilder0.append(", clickCopy: ");
            LogU.debug$default(ToolbarTiaraLogHelper.a, x.m(stringBuilder0, s, ", metaType: , section: , page: , songId: , songName:"), null, false, 6, null);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "";
            g0.b = "";
            g0.c = "";
            g0.y = "";
            g0.F = s;
            g0.e = "";
            g0.f = "";
            g0.g = "";
            g0.I = "";
            if(actionKind0 != null) {
                g0.d = actionKind0;
            }
            if(v == 0x1F) {
                g0.W = "1000003099";
            }
            g0.a().track();
        }

        public final void sendClickLog(int v, @NotNull s s0, @Nullable List list0) {
            String s5;
            q.g(s0, "tiaraProperty");
            String s1 = s0.c;
            String s2 = s0.b;
            String s3 = s0.a;
            MelonAppBase.Companion.getClass();
            t.a().getContext();
            ToolbarTiaraLogHelper.Companion.getClass();
            ActionKind actionKind0 = v == 0 || v == 0x1F ? ActionKind.PlayMusic : null;
            String s4 = Companion.a(v);
            if(v == 0x1F) {
                s5 = list0 == null || list0.isEmpty() || list0.size() <= 1 ? "N10099" : "N10106";
                q.d(s5);
            }
            else {
                s5 = "N10001";
                q.d("N10001");
            }
            if(list0 != null && !list0.isEmpty()) {
                q.f("", "getSongidString(...)");
            }
            if(list0 != null && !list0.isEmpty()) {
                q.f("", "getSongName(...)");
            }
            StringBuilder stringBuilder0 = new StringBuilder("sendClickLog() - actionName: ");
            stringBuilder0.append("");
            stringBuilder0.append(", actionKind: ");
            stringBuilder0.append(actionKind0);
            stringBuilder0.append(", clickCopy: ");
            d.u(stringBuilder0, s4, ", metaType: ", s5, ", section: ");
            d.u(stringBuilder0, s3, ", page: ", s2, ", songId: ");
            d.u(stringBuilder0, "", ", songName: ", "", ", menuId: ");
            stringBuilder0.append(s1);
            LogU.debug$default(ToolbarTiaraLogHelper.a, stringBuilder0.toString(), null, false, 6, null);
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = "";
            g0.b = s3;
            g0.c = s2;
            g0.y = "";
            g0.F = s4;
            g0.e = "";
            g0.f = s5;
            g0.g = "";
            g0.I = s1;
            if(actionKind0 != null) {
                g0.d = actionKind0;
            }
            if(v == 0x1F) {
                g0.W = "1000003099";
            }
            g0.a().track();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ToolbarTiaraLogHelper";
    public static final LogU a;

    static {
        ToolbarTiaraLogHelper.Companion = new Companion(null);
        LogU logU0 = new LogU("ToolbarTiaraLogHelper");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        ToolbarTiaraLogHelper.a = logU0;
    }

    public static final void sendClickLog(int v) {
        ToolbarTiaraLogHelper.Companion.sendClickLog(v);
    }

    public static final void sendClickLog(int v, @NotNull s s0, @Nullable List list0) {
        ToolbarTiaraLogHelper.Companion.sendClickLog(v, s0, list0);
    }
}

