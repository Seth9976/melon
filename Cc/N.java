package Cc;

import A0.f;
import X0.u;
import X0.x;
import android.content.Context;
import androidx.fragment.app.I;
import com.iloen.melon.utils.color.ColorUtils;
import ie.H;
import kotlin.jvm.internal.q;
import q8.h;
import vd.i;
import we.k;
import y0.M;

public final class n implements k {
    public final int a;
    public final Context b;

    public n(Context context0, int v) {
        this.a = v;
        this.b = context0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                q.f("재생 버튼", "getString(...)");
                u.h(((x)object0), "재생 버튼");
                return H.a;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                q.f("앨범 상세로 이동", "getString(...)");
                u.h(((x)object0), "앨범 상세로 이동");
                return H.a;
            }
            case 2: {
                q.g(((x)object0), "$this$semantics");
                q.f("전체재생 버튼", "getString(...)");
                u.h(((x)object0), "전체재생 버튼");
                return H.a;
            }
            case 3: {
                q.g(((x)object0), "$this$semantics");
                q.f("셔플재생 버튼", "getString(...)");
                u.h(((x)object0), "셔플재생 버튼");
                return H.a;
            }
            case 4: {
                q.g(((x)object0), "$this$semantics");
                q.f("앨범 상세로 이동", "getString(...)");
                u.h(((x)object0), "앨범 상세로 이동");
                return H.a;
            }
            case 5: {
                q.g(((x)object0), "$this$semantics");
                q.f("재생", "getString(...)");
                u.h(((x)object0), "재생");
                return H.a;
            }
            case 6: {
                q.g(((x)object0), "$this$semantics");
                q.f("더보기", "getString(...)");
                u.h(((x)object0), "더보기");
                return H.a;
            }
            case 7: {
                q.g(((x)object0), "$this$semantics");
                q.d("선택 버튼");
                u.h(((x)object0), "선택 버튼");
                return H.a;
            }
            case 8: {
                q.g(((x)object0), "$this$semantics");
                q.f("맨 위로 이동", "getString(...)");
                u.h(((x)object0), "맨 위로 이동");
                return H.a;
            }
            case 9: {
                q.g(((x)object0), "$this$semantics");
                q.f("맨 위로 이동", "getString(...)");
                u.h(((x)object0), "맨 위로 이동");
                return H.a;
            }
            case 10: {
                q.g(((f)object0), "$this$drawBehind");
                f.d0(((f)object0), M.c(ColorUtils.getColor(this.b, 0x7F060038)), ((f)object0).c(), 0.0f, null, 0, 0x7A);  // color:black_20
                f.d0(((f)object0), M.c(ColorUtils.getColor(this.b, 0x7F060140)), ((f)object0).c(), 0.0f, null, 24, 58);  // color:gray001e_support_high_contrast
                return H.a;
            }
            case 11: {
                q.g(((x)object0), "$this$semantics");
                q.f("음악서랍 플레이리스트에 저장하기", "getString(...)");
                u.h(((x)object0), "음악서랍 플레이리스트에 저장하기");
                return H.a;
            }
            case 12: {
                q.g(((x)object0), "$this$semantics");
                q.f("앨범 상세로 이동", "getString(...)");
                u.h(((x)object0), "앨범 상세로 이동");
                return H.a;
            }
            case 13: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = "유입경로";
                return H.a;
            }
            case 14: {
                q.g(((I)object0), "it");
                return !(((I)object0) instanceof i) || !q.b(((i)(((I)object0))).e, "평점 주기") ? false : true;
            }
            case 15: {
                q.g(((I)object0), "fragment");
                return !(((I)object0) instanceof i) || (!q.b(((i)(((I)object0))).e, "안내") || !q.b(((i)(((I)object0))).f, "로그인이 필요한 서비스입니다.\n로그인하시겠습니까?")) ? false : true;
            }
            default: {
                q.g(((I)object0), "it");
                return !(((I)object0) instanceof i) || (!q.b(((i)(((I)object0))).e, "안내") || !q.b(((i)(((I)object0))).f, "반복재생 중입니다.\n\n반복재생 모드를 해제하시고 요청 작업을 진행하시겠습니까?")) ? false : true;
            }
        }
    }
}

