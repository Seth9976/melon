package zd;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class M extends Enum {
    public static final enum M A0;
    public static final enum M A1;
    public static final enum M B;
    public static final enum M B0;
    public static final enum M B1;
    public static final enum M C0;
    public static final enum M C1;
    public static final enum M D;
    public static final enum M D0;
    public static final enum M D1;
    public static final enum M E;
    public static final enum M E0;
    public static final enum M E1;
    public static final enum M F0;
    public static final enum M F1;
    public static final enum M G;
    public static final enum M G0;
    public static final enum M G1;
    public static final enum M H0;
    public static final M[] H1;
    public static final enum M I;
    public static final enum M I0;
    public static final enum M J0;
    public static final enum M K0;
    public static final enum M L0;
    public static final enum M M;
    public static final enum M M0;
    public static final enum M N;
    public static final enum M N0;
    public static final enum M O0;
    public static final enum M P0;
    public static final enum M Q0;
    public static final enum M R0;
    public static final enum M S;
    public static final enum M S0;
    public static final enum M T;
    public static final enum M T0;
    public static final enum M U0;
    public static final enum M V;
    public static final enum M V0;
    public static final enum M W;
    public static final enum M W0;
    public static final enum M X;
    public static final enum M X0;
    public static final enum M Y;
    public static final enum M Y0;
    public static final enum M Z;
    public static final enum M Z0;
    public static final enum M a;
    public static final enum M a1;
    public static final enum M b;
    public static final enum M b0;
    public static final enum M b1;
    public static final enum M c;
    public static final enum M c0;
    public static final enum M c1;
    public static final enum M d;
    public static final enum M d0;
    public static final enum M d1;
    public static final enum M e;
    public static final enum M e0;
    public static final enum M e1;
    public static final enum M f;
    public static final enum M f0;
    public static final enum M f1;
    public static final enum M g;
    public static final enum M g0;
    public static final enum M g1;
    public static final enum M h;
    public static final enum M h0;
    public static final enum M h1;
    public static final enum M i;
    public static final enum M i0;
    public static final enum M i1;
    public static final enum M j;
    public static final enum M j0;
    public static final enum M j1;
    public static final enum M k;
    public static final enum M k0;
    public static final enum M k1;
    public static final enum M l;
    public static final enum M l0;
    public static final enum M l1;
    public static final enum M m;
    public static final enum M m0;
    public static final enum M m1;
    public static final enum M n;
    public static final enum M n0;
    public static final enum M n1;
    public static final enum M o;
    public static final enum M o0;
    public static final enum M o1;
    public static final enum M p0;
    public static final enum M p1;
    public static final enum M q0;
    public static final enum M q1;
    public static final enum M r;
    public static final enum M r0;
    public static final enum M r1;
    public static final enum M s0;
    public static final enum M s1;
    public static final enum M t0;
    public static final enum M t1;
    public static final enum M u0;
    public static final enum M u1;
    public static final enum M v0;
    public static final enum M v1;
    public static final enum M w;
    public static final enum M w0;
    public static final enum M w1;
    public static final enum M x0;
    public static final enum M x1;
    public static final enum M y0;
    public static final enum M y1;
    public static final enum M z0;
    public static final enum M z1;

    static {
        M.a = new M("LISTEN", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.b = new M("PLAY_ALL", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.c = new M("DOWNLOAD_FLAC", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.d = new M("PLAY_SHUFFLE", 3);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.e = new M("PLAY_MIX_UP", 4);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.f = new M("DOWNLOAD", 5);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.g = new M("DOWNLOAD_ALL", 6);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.h = new M("PUT", 7);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.i = new M("PUT_ALL", 8);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.j = new M("SONG_INFO", 9);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.k = new M("ALBUM_INFO", 10);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.l = new M("ARTIST_INFO", 11);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.m = new M("MV_INFO", 12);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.n = new M("DJ_PROFILE", 13);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.o = new M("DJ_PLAYLIST_INFO", 14);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.r = new M("PLAYLIST_INFO", 15);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.w = new M("MV", 16);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.B = new M("LIKE_WITH", 17);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.D = new M("SIMILAR_SONG", 18);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.E = new M("SIMILAR_SONG_FOR_PLAYER", 19);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.G = new M("NOW_PLAYING", 20);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.I = new M("VIEW", 21);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.M = new M("DELETE", 22);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.N = new M("LYRIC_DOWNLOAD", 23);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.S = new M("ADD_TO_NOW_PLAYING", 24);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.T = new M("ADD_TO_PLAYLIST", 25);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.V = new M("ADD_TO_LOCAL_PLAYLIST", 26);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.W = new M("ADD_TO_DJ_COLLECTION", 27);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.X = new M("PHOTO_ALBUM", 28);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.Y = new M("CAMERA", 29);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.Z = new M("DEFALUT_IMAGE", 30);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.b0 = new M("VIDEO", 0x1F);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.c0 = new M("PHOTO", 0x20);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.d0 = new M("MAKE_PLAYLIST", 33);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.e0 = new M("MAKE_DJ_PLAYLIST", 34);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.f0 = new M("MAKE_SERIES_PLAYLIST", 35);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.g0 = new M("RECOMMEND_TO_FRIEND", 36);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.h0 = new M("TIKTOK", 37);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.i0 = new M("SHARE", 38);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.j0 = new M("SHARE_INSTAGRAM", 39);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.k0 = new M("SHARE_FACEBOOK", 40);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.l0 = new M("SHARE_FACEBOOK_NEWSFEED", 41);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.m0 = new M("SHARE_FACEBOOK_STORY", 42);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.n0 = new M("SHARE_URL_COPY", 43);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.o0 = new M("SHARE_X", 44);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.p0 = new M("SHARE_KAKAO", 45);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.q0 = new M("GO_KAKAO_CHANNEL", 46);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.r0 = new M("GO_INSTAGRAM_CHANNEL", 0x2F);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.s0 = new M("GO_X_CHANNEL", 0x30);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.t0 = new M("GO_FACEBOOK_CHANNEL", 49);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.u0 = new M("GO_TIKTOK_CHANNEL", 50);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.v0 = new M("GO_YOUTUBE_CHANNEL", 51);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.w0 = new M("SHARE_OTHER", 52);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.x0 = new M("SERIES_FOLDER_EDIT", 53);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.y0 = new M("SERIES_FOLDER_DELETE", 54);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.z0 = new M("EDIT", 55);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.A0 = new M("OPEN", 56);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.B0 = new M("CREATORS_MUSIC_NO_ICON", 57);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.C0 = new M("PRESENT", 58);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.D0 = new M("PRESENT_VIEW", 59);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.E0 = new M("POWER_DJ_APPLY", 60);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.F0 = new M("ADD_SHORTCUT_ICON_TO_HOME", 61);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.G0 = new M("DCF_EXPIRY", 62);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.H0 = new M("NOWPLAYLIST_PLAYLIST_BASE", 0x3F);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.I0 = new M("PLAYER_SETTING_STOP_TIMER", 0x40);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.J0 = new M("PLAYER_SETTING_AUTO_PLAYER", 65);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.K0 = new M("PLAYER_SETTING_EQ", 66);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.L0 = new M("PLAYER_SETTING_ADD_POSITION", 67);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.M0 = new M("PLAYER_SETTING_SONG", 68);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.N0 = new M("PLAYER_SETTING_OFFLINE_PLAYBACK", 69);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.O0 = new M("PLAYER_SETTING_MV", 70);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.P0 = new M("ALBUM_LIKE", 71);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.Q0 = new M("DJPLAYLIST_LIKE", 72);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.R0 = new M("NOT_RECOMMEND", 73);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.S0 = new M("MYLOG_DELETE", 74);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.T0 = new M("KAKAO_TALK_WITH_LISTEN_WITHOUT_ICON", 75);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.U0 = new M("KAKAO_TALK_SET_PROFIlE_MUSIC", 76);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.V0 = new M("STREAMING_CARD", 77);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.W0 = new M("CHART_REPORT", 78);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.X0 = new M("EQ_MELON_10_BAND", 0x4F);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.Y0 = new M("EQ_MELON_SOUND_ALIVE", 80);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.Z0 = new M("EDIT_PLAYLIST", 81);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.a1 = new M("DELETE_PLAYLIST", 82);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.b1 = new M("REPORT", 83);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.c1 = new M("DO_EDIT", 84);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.d1 = new M("DO_DELETE", 85);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.e1 = new M("PROGRAM_SUBSCRIPTION_ON", 86);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.f1 = new M("PROGRAM_SUBSCRIPTION_OFF", 87);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.g1 = new M("PROGRAM_INFO", 88);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.h1 = new M("MIX_UP_WITH_THIS_SONG", 89);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.i1 = new M("MUSIC_WAVE_DELETE", 90);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.j1 = new M("MUSIC_WAVE_EDIT", 91);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.k1 = new M("COMMENT_EDIT", 92);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.l1 = new M("COMMENT_DELETE", 93);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.m1 = new M("ARTIST_CANCEL_EXCLUDE_THIS_ARTIST", 94);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.n1 = new M("ARTIST_EXCLUDE_THIS_ARTIST", 0x5F);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.o1 = new M("CREATOR_INFO", 0x60);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.p1 = new M("MULTI_ARTIST_POPUP_ITEM", 97);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.q1 = new M("ADD_POSITION_FIRST", 98);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.r1 = new M("ADD_POSITION_LAST", 99);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.s1 = new M("ADD_POSITION_AFTER_CURRENT", 100);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.t1 = new M("REPEAT", 101);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.u1 = new M("BLOCK_MESSAGE", 102);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.v1 = new M("CANCEL_BLOCK_MESSAGE", 103);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.w1 = new M("PIN_COMMENT", 104);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.x1 = new M("UNPIN_COMMENT", 105);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.y1 = new M("SETTING_QUALITY", 106);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.z1 = new M("CAST_SHORTCUT", 107);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.A1 = new M("PROGRAM_SHORTCUT", 108);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.B1 = new M("AUTO_QUALITY", 109);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.C1 = new M("LIVE_ALARM", 110);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.D1 = new M("MUSIC_WAVE_INSERT_HOST_MESSAGE", 0x6F);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.E1 = new M("MUSIC_WAVE_REPORT_PROFILE", 0x70);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.F1 = new M("MUSIC_WAVE_REPORT_CHAT", 0x71);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.G1 = new M("VIDEO_RESOLUTION_VALUE", 0x72);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M[] arr_m = {M.a, M.b, M.c, M.d, M.e, M.f, M.g, M.h, M.i, M.j, M.k, M.l, M.m, M.n, M.o, M.r, M.w, M.B, M.D, M.E, M.G, M.I, M.M, M.N, M.S, M.T, M.V, M.W, M.X, M.Y, M.Z, M.b0, M.c0, M.d0, M.e0, M.f0, M.g0, M.h0, M.i0, M.j0, M.k0, M.l0, M.m0, M.n0, M.o0, M.p0, M.q0, M.r0, M.s0, M.t0, M.u0, M.v0, M.w0, M.x0, M.y0, M.z0, M.A0, M.B0, M.C0, M.D0, M.E0, M.F0, M.G0, M.H0, M.I0, M.J0, M.K0, M.L0, M.M0, M.N0, M.O0, M.P0, M.Q0, M.R0, M.S0, M.T0, M.U0, M.V0, M.W0, M.X0, M.Y0, M.Z0, M.a1, M.b1, M.c1, M.d1, M.e1, M.f1, M.g1, M.h1, M.i1, M.j1, M.k1, M.l1, M.m1, M.n1, M.o1, M.p1, M.q1, M.r1, M.s1, M.t1, M.u1, M.v1, M.w1, M.x1, M.y1, M.z1, M.A1, M.B1, M.C1, M.D1, M.E1, M.F1, M.G1, new M("CUSTOM_ITEM", 0x73)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        M.H1 = arr_m;
        q.g(arr_m, "entries");
        new b(arr_m);
    }

    public static M valueOf(String s) {
        return (M)Enum.valueOf(M.class, s);
    }

    public static M[] values() {
        return (M[])M.H1.clone();
    }
}

