package r8;

import Bd.x;
import Cc.n;
import Tf.v;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri.Builder;
import android.net.Uri;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq.Params.Builder;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.kakao.tiara.track.Event;
import java.util.HashMap;
import java.util.Locale;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;
import p8.O;
import q8.h;

public abstract class f {
    public static final String a;
    public static final UriMatcher b;
    public static final UriMatcher c;
    public static final Uri d;
    public static final Uri e;
    public static final Uri f;
    public static final Uri g;
    public static final Uri h;
    public static final Uri i;
    public static final Uri j;
    public static final Uri k;
    public static final Uri l;
    public static final Uri m;
    public static final Uri n;
    public static final Uri o;
    public static final Uri p;
    public static final Uri q;
    public static final Uri r;
    public static final Uri s;

    static {
        f.a = Z.m(MelonAppBase.Companion, 0x7F1304C6, "getString(...)");  // string:kakao_scheme "kakao5c2982b2ec377339ee67d3686f4813ac"
        UriMatcher uriMatcher0 = new UriMatcher(-1);
        f.b = uriMatcher0;
        UriMatcher uriMatcher1 = new UriMatcher(-1);
        f.c = uriMatcher1;
        uriMatcher0.addURI("home", null, 100);
        uriMatcher0.addURI("home", "shortcut", 1600);
        uriMatcher0.addURI("apphome", null, 104);
        uriMatcher0.addURI("back", null, 101);
        uriMatcher0.addURI("exit", null, 102);
        uriMatcher0.addURI("launch", null, 103);
        uriMatcher0.addURI("download", null, 105);
        uriMatcher0.addURI("download", "photo", 106);
        uriMatcher0.addURI("friend", null, 107);
        uriMatcher0.addURI("play", null, 10);
        uriMatcher0.addURI("play", "control/play", 0x8FD);
        uriMatcher0.addURI("play", "control/pause", 0x8FE);
        uriMatcher0.addURI("play", "control/prev", 0x8FF);
        uriMatcher0.addURI("play", "control/next", 0x900);
        uriMatcher0.addURI("play", "control/mode", 0x901);
        uriMatcher0.addURI("play", "clear/playlist", 0x902);
        uriMatcher0.addURI("play", "control/replay", 0x903);
        uriMatcher0.addURI("main", null, 400);
        uriMatcher0.addURI("main", "music", 403);
        uriMatcher0.addURI("main", "video", 404);
        uriMatcher0.addURI("main", "star", 405);
        uriMatcher0.addURI("main", "feed", 401);
        uriMatcher0.addURI("main", "foru", 402);
        uriMatcher0.addURI("main", "station", 407);
        uriMatcher0.addURI("main", "search", 408);
        uriMatcher0.addURI("nowplayinglist", "#", 108);
        uriMatcher0.addURI("webview", null, 109);
        uriMatcher0.addURI("smsrecv", null, 110);
        uriMatcher0.addURI("permission", null, 0x6F);
        uriMatcher0.addURI("autologin", null, 0x70);
        uriMatcher0.addURI("cookies", "set", 0x71);
        uriMatcher0.addURI("goods", null, 0x72);
        uriMatcher0.addURI("likesong", null, 0x73);
        uriMatcher0.addURI("like", "playingsong", 0x74);
        uriMatcher0.addURI("logout", null, 170);
        uriMatcher0.addURI("token", "expire", 0xAB);
        uriMatcher0.addURI("token", "login/error", 0xAC);
        uriMatcher0.addURI("kakao", "login", 0xAD);
        uriMatcher0.addURI("kakao", "logout", 0xAE);
        uriMatcher0.addURI("kakao", "connect", 0xAF);
        uriMatcher0.addURI("kakao", "connect/account", 0xB3);
        uriMatcher0.addURI("kakao", "disconnect", 0xB0);
        uriMatcher0.addURI("kakao", "sdklogin", 0xB1);
        uriMatcher0.addURI("login", null, 0xB2);
        uriMatcher0.addURI("kakao", "login/integration", 150);
        uriMatcher0.addURI("setting", null, 3000);
        uriMatcher0.addURI("setting", "login", 3001);
        uriMatcher0.addURI("setting", "melonlogin", 3002);
        uriMatcher0.addURI("setting", "melonlogin/manage", 3004);
        uriMatcher0.addURI("setting", "snslogin", 3003);
        uriMatcher0.addURI("setting", "myinfo", 3005);
        uriMatcher0.addURI("setting", "songbitrate", 3006);
        uriMatcher0.addURI("setting", "lab", 3007);
        uriMatcher0.addURI("setting", "stoptimer", 3008);
        uriMatcher0.addURI("setting", "push", 3009);
        uriMatcher0.addURI("alarm", "shortcut", 3010);
        uriMatcher0.addURI("setting", "optimization/battery", 3011);
        uriMatcher0.addURI("mymusic", null, 200);
        uriMatcher0.addURI("mymusic", "#", 201);
        uriMatcher0.addURI("mymusic", Y.j("getDefault(...)", "ManyListen", "toLowerCase(...)"), 202);
        uriMatcher0.addURI("mymusic", "mylog", 203);
        uriMatcher0.addURI("mymusic", "myorother", 204);
        uriMatcher0.addURI("melondj", null, 300);
        uriMatcher0.addURI("melondj", "apply", 304);
        uriMatcher0.addURI("melondj", "shortcut", 1603);
        uriMatcher0.addURI("melondj", "alldjplaylist", 1604);
        uriMatcher0.addURI("djbrand", null, 302);
        uriMatcher0.addURI("djbrand", "detail", 303);
        uriMatcher0.addURI("openalbum", "#", 500);
        uriMatcher0.addURI("openalbum", "view", 501);
        uriMatcher0.addURI("new", "album", 2400);
        uriMatcher0.addURI("charts", null, 550);
        uriMatcher0.addURI("charts", "current", 551);
        uriMatcher0.addURI("charts", "weekly", 552);
        uriMatcher0.addURI("charts", "album", 553);
        uriMatcher0.addURI("charts", "age", 554);
        uriMatcher0.addURI("charts", "genre", 555);
        uriMatcher0.addURI("charts", "realtime", 556);
        uriMatcher0.addURI("charts", "popular", 557);
        uriMatcher0.addURI("charts", "hottrack", 558);
        uriMatcher0.addURI("charts", "hottrackdetail", 0x22F);
        uriMatcher0.addURI("charts", "artist", 560);
        uriMatcher0.addURI("charts", "24hits", 561);
        uriMatcher0.addURI("charts", "shortcut", 562);
        uriMatcher0.addURI("charts", "top100", 563);
        uriMatcher0.addURI("charts", "latest", 564);
        uriMatcher0.addURI("charts", "my", 565);
        uriMatcher0.addURI("charts", "theme", 566);
        uriMatcher0.addURI("streamingcard", null, 3400);
        uriMatcher0.addURI("commentlist", null, 3550);
        uriMatcher0.addURI("mycomment", null, 3500);
        uriMatcher0.addURI("tiara", null, 3600);
        uriMatcher0.addURI("tiara", "updatemyinfo", 3601);
        uriMatcher0.addURI("genre", null, 610);
        uriMatcher0.addURI("genre", "detail", 611);
        uriMatcher0.addURI("genre", "hottrack", 612);
        uriMatcher0.addURI("genre", "masterpiece", 613);
        uriMatcher0.addURI("genre", "more/playlist", 614);
        uriMatcher0.addURI("genre", "more/newmusic", 615);
        uriMatcher0.addURI("genre", "label/detail", 616);
        uriMatcher0.addURI("genre", "majorartist", 617);
        uriMatcher0.addURI("genre", "selection", 618);
        uriMatcher0.addURI("newmusic", null, 620);
        uriMatcher0.addURI("artistplus", null, 630);
        uriMatcher0.addURI("playlist", null, 700);
        uriMatcher0.addURI("playlist", "add", 701);
        uriMatcher0.addURI("search", null, 900);
        uriMatcher0.addURI("recordandsearch", null, 910);
        uriMatcher0.addURI("recordandsearch", "shortcut", 1608);
        uriMatcher0.addURI("melgunspick", "#", 1050);
        uriMatcher0.addURI("djmelgun", null, 1051);
        uriMatcher0.addURI("melondj", "taghub", 1052);
        uriMatcher0.addURI("melondj", "tagsearch", 1053);
        uriMatcher0.addURI("topic", null, 1060);
        uriMatcher0.addURI("giftbox", null, 180);
        uriMatcher0.addURI("giftbox", "send", 0xB5);
        uriMatcher0.addURI("giftbox", "receive", 0xB6);
        uriMatcher0.addURI("melontv", "theme/#", 1101);
        uriMatcher0.addURI("melontv", "program", 1102);
        uriMatcher0.addURI("melontv", null, 1110);
        uriMatcher0.addURI("melontv", "todayshortcut", 1602);
        uriMatcher0.addURI("melontv", d.a.a(), 0x457);
        uriMatcher0.addURI("melontv", d.b.a(), 0x458);
        uriMatcher0.addURI("melontv", d.c.a(), 0x459);
        uriMatcher0.addURI("melontv", d.d.a(), 0x45A);
        uriMatcher0.addURI("melontv", d.e.a(), 0x45B);
        uriMatcher0.addURI("kakaolink", null, 1300);
        uriMatcher0.addURI("aztalk", null, 1500);
        uriMatcher0.addURI("education", null, 1700);
        uriMatcher0.addURI("education", "detail", 1701);
        uriMatcher0.addURI("keyboard", null, 1800);
        uriMatcher0.addURI("webview", "request/menuId", 0x709);
        uriMatcher0.addURI("webview", "send/menuId", 0x70A);
        uriMatcher0.addURI("webview", "bnrsgmt", 0x70B);
        uriMatcher0.addURI("kakaoemoticon", null, 0x70C);
        uriMatcher0.addURI("foru", "concernmusic", 2000);
        uriMatcher0.addURI("foru", "now", 2001);
        uriMatcher0.addURI("foru", "selfrecommend", 2002);
        uriMatcher0.addURI("foru", "selfdj", 2003);
        uriMatcher0.addURI("foru", "matchedsong", 2004);
        uriMatcher0.addURI("foru", "weatherrecommend", 2005);
        uriMatcher0.addURI("foru", "usertaste", 2006);
        uriMatcher0.addURI("foru", "mixmaker", 2007);
        uriMatcher0.addURI("musicdna", null, 2100);
        uriMatcher0.addURI("musicdna", "monthlylog", 2101);
        uriMatcher0.addURI("speechexecutor", null, 2500);
        uriMatcher0.addURI("speechexecutor", "shortcut", 1607);
        uriMatcher0.addURI("authority", null, 2600);
        uriMatcher0.addURI("authority", null, 2601);
        uriMatcher0.addURI("melonkids", null, 2700);
        uriMatcher0.addURI("melonkids", "home", 2701);
        uriMatcher0.addURI("melonkids", "song", 2702);
        uriMatcher0.addURI("melonkids", "character", 0xA8F);
        uriMatcher0.addURI("melonkids", "video", 0xA90);
        uriMatcher0.addURI("melonkids", "fairytale", 2705);
        uriMatcher0.addURI("melonkids", "classic", 2706);
        uriMatcher0.addURI("melonkids", "characterdetail", 2707);
        uriMatcher0.addURI("melonkids", "themedetail", 2708);
        uriMatcher0.addURI("melonkids", "genredetail", 2709);
        uriMatcher0.addURI("melonkids", "shortcut", 1609);
        uriMatcher0.addURI("sports", null, 2900);
        uriMatcher0.addURI("sports", "shortcut", 1610);
        uriMatcher0.addURI("sports", "detail/playlist", 0xB5F);
        uriMatcher0.addURI("sports", "detail/theme", 2910);
        uriMatcher0.addURI("sports", "play", 2920);
        uriMatcher0.addURI("player", null, 4000);
        uriMatcher0.addURI("player", "eq", 4100);
        uriMatcher0.addURI("player", "playlist", 4200);
        uriMatcher0.addURI("maintab", null, 5000);
        uriMatcher0.addURI("maintab", "delete", 5001);
        uriMatcher0.addURI("audiofocus", "request", 0xAF0);
        uriMatcher0.addURI("playback", null, 9000);
        uriMatcher0.addURI("inapppurchase", "google", 8001);
        uriMatcher0.addURI("inapppurchase", "onestore", 8002);
        uriMatcher0.addURI("playexternal", null, 9100);
        uriMatcher1.addURI("like", "playingsong", 0x74);
        uriMatcher1.addURI("playexternal", null, 9100);
        uriMatcher1.addURI("play", "control/play", 0x8FD);
        uriMatcher1.addURI("play", "control/pause", 0x8FE);
        uriMatcher1.addURI("play", "control/prev", 0x8FF);
        uriMatcher1.addURI("play", "control/next", 0x900);
        uriMatcher1.addURI("play", "control/mode", 0x901);
        uriMatcher1.addURI("play", "clear/playlist", 0x902);
        uriMatcher1.addURI("play", "control/replay", 0x903);
        uriMatcher1.addURI("setting", "stoptimer", 3008);
        uriMatcher0.addURI("station", null, 3100);
        uriMatcher0.addURI("station", "program", 3101);
        uriMatcher0.addURI("station", "listen", 3102);
        uriMatcher0.addURI("station", "popular", 0xC1F);
        uriMatcher0.addURI("station", "episode", 0xC20);
        uriMatcher0.addURI("rising31", null, 3200);
        uriMatcher0.addURI("trackzero", "home", 3300);
        uriMatcher0.addURI("trackzero", "detail", 3301);
        uriMatcher0.addURI("cashfriends", "offerwall", 9200);
        uriMatcher0.addURI("trend", "shortform", 9300);
        uriMatcher0.addURI("live", "play", 20000);
        uriMatcher0.addURI("artist", "topiclist", 21001);
        uriMatcher0.addURI("artist", "topiclist/topic", 21002);
        Uri uri0 = Uri.parse("melonapp://home/shortcut");
        q.f(uri0, "parse(...)");
        f.d = uri0;
        Uri uri1 = Uri.parse("melonapp://apphome");
        q.f(uri1, "parse(...)");
        f.e = uri1;
        Uri uri2 = Uri.parse("melonapp://back");
        q.f(uri2, "parse(...)");
        f.f = uri2;
        Uri uri3 = Uri.parse("melonapp://exit");
        q.f(uri3, "parse(...)");
        f.g = uri3;
        Uri uri4 = Uri.parse("melonapp://webview");
        q.f(uri4, "parse(...)");
        f.h = uri4;
        Uri uri5 = Uri.parse("melonapp://setting");
        q.f(uri5, "parse(...)");
        f.i = uri5;
        Uri uri6 = Uri.withAppendedPath(uri5, "melonlogin");
        q.f(uri6, "withAppendedPath(...)");
        f.j = uri6;
        Uri uri7 = Uri.parse("melonapp://friend");
        q.f(uri7, "parse(...)");
        f.k = uri7;
        Uri uri8 = Uri.parse("melonapp://token");
        q.f(uri8, "parse(...)");
        Uri uri9 = Uri.withAppendedPath(uri8, "expire");
        q.f(uri9, "withAppendedPath(...)");
        f.l = uri9;
        Uri uri10 = Uri.withAppendedPath(uri8, "login/error");
        q.f(uri10, "withAppendedPath(...)");
        f.m = uri10;
        Uri uri11 = Uri.parse("melonapp://play");
        q.f(uri11, "parse(...)");
        f.n = uri11;
        Uri uri12 = Uri.parse("melonapp://details");
        q.f(uri12, "parse(...)");
        f.o = uri12;
        Uri uri13 = Uri.parse("melonapp://giftbox");
        q.f(uri13, "parse(...)");
        q.f(Uri.withAppendedPath(uri13, "send"), "withAppendedPath(...)");
        q.f(Uri.withAppendedPath(uri13, "receive"), "withAppendedPath(...)");
        Uri uri14 = Uri.parse("melonapp://melondj/shortcut");
        q.f(uri14, "parse(...)");
        f.p = uri14;
        Uri uri15 = Uri.parse("melonapp://recordandsearch/shortcut");
        q.f(uri15, "parse(...)");
        f.q = uri15;
        Uri uri16 = Uri.parse("melonapp://charts/shortcut");
        q.f(uri16, "parse(...)");
        f.r = uri16;
        Uri uri17 = Uri.parse("melonapp://alarm/shortcut");
        q.f(uri17, "parse(...)");
        f.s = uri17;
        q.f(Uri.parse("melonapp://smartradio/listen"), "parse(...)");
        q.f(Uri.parse("melonapp://smartradiov2"), "parse(...)");
        q.f(Uri.parse("melonapp://smartradiov2/shortcut"), "parse(...)");
        q.f(Uri.parse("melonapp://smartradiov2/listen"), "parse(...)");
    }

    public static final void a(Uri uri0) {
        Intent intent0 = new Intent("android.intent.action.VIEW");
        intent0.setFlags(0x10000000);
        intent0.setData(uri0);
        try {
            MelonAppBase.Companion.getClass();
            t.a().getContext().startActivity(intent0);
        }
        catch(ActivityNotFoundException unused_ex) {
        }
    }

    public static final Uri b(c c0, String s, HashMap hashMap0) {
        Uri.Builder uri$Builder0 = f.o.buildUpon();
        Locale locale0 = Locale.getDefault();
        q.f(locale0, "getDefault(...)");
        String s1 = c0.name().toLowerCase(locale0);
        q.f(s1, "toLowerCase(...)");
        Uri.Builder uri$Builder1 = uri$Builder0.appendPath(s1).appendPath(s);
        if(hashMap0 != null) {
            for(Object object0: hashMap0.keySet()) {
                uri$Builder1.appendQueryParameter(((String)object0), ((String)hashMap0.get(((String)object0))));
            }
        }
        return uri$Builder1.build();
    }

    public static final int c(Uri uri0) {
        if(uri0 != null) {
            String s = uri0.getScheme();
            return !"melonapp".equalsIgnoreCase(s) && !v.j0(f.a, s, true) ? -1 : f.b.match(uri0);
        }
        return -1;
    }

    public static final void d(Uri uri0) {
        if(uri0 != null) {
            String s = uri0.getQueryParameter("launchedby");
            String s1 = uri0.getQueryParameter("ref");
            if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1)) {
                MelonAppBase.Companion.getClass();
                s1 = "unknown";
            }
            if(!TextUtils.isEmpty(s1)) {
                s = s1;
            }
            Builder inflowPvLogDummyReq$Params$Builder0 = new Builder(s).uri(uri0);
            O.a(new InflowPvLogDummyReq(Y.a(MelonAppBase.Companion), inflowPvLogDummyReq$Params$Builder0.build()));
            Reporter reportService$Reporter0 = Reporter.createReporter(Type.INFLOW, LogLevel.INFO);
            reportService$Reporter0.setMessage(uri0.toString());
            reportService$Reporter0.report();
            String s2 = uri0.getQueryParameter("t_src");
            String s3 = uri0.getQueryParameter("t_ch");
            String s4 = uri0.getQueryParameter("t_obj");
            String s5 = uri0.getQueryParameter("t_msg_id");
            if(s2 != null && s2.length() != 0 || s3 != null && s3.length() != 0 || s4 != null && s4.length() != 0 || s5 != null && s5.length() != 0) {
                Context context0 = t.a().getContext();
                q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
                new n(context0, 13).invoke(((h)d0.b));
                d0.c(new x(context0, s2, s3, s4, s5));
                ((Event)d0.p()).track();
            }
        }
    }
}

