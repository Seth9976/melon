package v9;

import java.util.Objects;

public final class l {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public static final l f;
    public static final l g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;
    public static final l l;
    public static final l m;
    public static final l n;
    public static final l o;
    public static final l p;
    public static final l q;
    public static final l r;
    public static final l s;

    // 去混淆评级： 低(33)
    static {
        l.f = new l(0, 100, 0x7F130515, 0x7F080581, true);  // string:locker_purchase_list "구매목록"
        l.g = new l(1, 100, 0x7F130517, -1, false);  // string:locker_song "곡"
        l.h = new l(1, 100, 0x7F130518, -1, false);  // string:locker_streaming_list "스트리밍 차감목록"
        l.i = new l(1, 100, 0x7F13050E, -1, false);  // string:locker_album "앨범"
        l.j = new l(1, 100, 0x7F130514, -1, false);  // string:locker_mv "뮤직비디오"
        l.k = new l(0, 101, 0x7F130516, 0x7F080589, true);  // string:locker_save_content "저장한 콘텐츠"
        l.l = new l(1, 101, 0x7F130513, -1, false);  // string:locker_local_playlist "로컬 플레이리스트"
        l.m = new l(1, 101, 0x7F130517, -1, false);  // string:locker_song "곡"
        l.n = new l(1, 101, 0x7F130511, -1, false);  // string:locker_flac "FLAC"
        l.o = new l(1, 101, 0x7F130514, -1, false);  // string:locker_mv "뮤직비디오"
        l.p = new l(1, 101, 0x7F130512, -1, false);  // string:locker_folder "폴더"
        l.q = new l(0, -1, 0x7F130510, 0x7F080584, false);  // string:locker_download_manager "다운로드 관리자"
        l.r = new l(0, -1, 0x7F13050F, 0x7F080582, false);  // string:locker_dcf_extension "DCF 기간연장"
        l.s = new l(3, -1, -1, -1, false);
    }

    public l(int v, int v1, int v2, int v3, boolean z) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = z;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 != null && object0 instanceof l && ((l)object0).a == this.a && ((l)object0).b == this.b && ((l)object0).c == this.c && ((l)object0).d == this.d && ((l)object0).e == this.e;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.c, this.d, Boolean.valueOf(this.e)});
    }
}

