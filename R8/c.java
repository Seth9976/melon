package r8;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class c extends Enum {
    public static final enum c a;
    public static final enum c b;
    public static final c[] c;

    static {
        c c0 = new c("Song", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.a = new c("Album", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.b = new c("Artist", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c[] arr_c = {c0, c.a, c.b, new c("Video", 3), new c("Playlist", 4), new c("DjCollection", 5), new c("DjMagazine", 6), new c("ArtistPlaylist", 7), new c("Photo", 8), new c("Show", 9), new c("MelgunsPick", 10), new c("ThanksMsg", 11), new c("Theme", 12), new c("Story", 13), new c("Maestro", 14), new c("Nowplaying", 15), new c("SearchPhoto", 16), new c("ArtistFriendship", 17), new c("ForUMix", 18)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.c = arr_c;
        q.g(arr_c, "entries");
        new b(arr_c);
    }

    public static c valueOf(String s) {
        return (c)Enum.valueOf(c.class, s);
    }

    public static c[] values() {
        return (c[])c.c.clone();
    }
}

