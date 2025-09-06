package F8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class x extends T {
    public final int g;

    public x(int v) {
        this.g = v;
        super();
    }

    @Override  // F8.o
    public final View c(Context context0) {
        switch(this.g) {
            case 0: {
                View view1 = LayoutInflater.from(context0).inflate(0x7F0D0890, null);  // layout:titlebar_right_plus_button
                q.f(view1, "inflate(...)");
                return view1;
            }
            case 1: {
                View view2 = new ImageView(context0);
                view2.setPadding(0, 0, ScreenUtils.dipToPixel(context0, 16.0f), 0);
                ((ImageView)view2).setImageResource(0x7F080115);  // drawable:btn_comment_writing
                return view2;
            }
            case 2: {
                View view3 = new ImageView(context0);
                view3.setPadding(0, 0, ScreenUtils.dipToPixel(context0, 9.0f), 0);
                ((ImageView)view3).setImageResource(0x7F0801D5);  // drawable:btn_gnb_info
                return view3;
            }
            case 3: {
                View view4 = new ImageView(context0);
                view4.setPadding(0, 0, ScreenUtils.dipToPixel(context0, 20.0f), 0);
                ((ImageView)view4).setImageResource(0x7F0801C8);  // drawable:btn_gnb_add
                return view4;
            }
            case 4: {
                View view5 = LayoutInflater.from(context0).inflate(0x7F0D088F, null);  // layout:titlebar_right_music_dna_info_button
                q.f(view5, "inflate(...)");
                return view5;
            }
            case 5: {
                View view6 = LayoutInflater.from(context0).inflate(0x7F0D0889, null);  // layout:titlebar_right_button
                ((TextView)view6.findViewById(0x7F0A0C2E)).setText("등록");  // id:tv_button_name
                return view6;
            }
            default: {
                View view0 = LayoutInflater.from(context0).inflate(0x7F0D0892, null);  // layout:titlebar_right_searchmusic_record_button
                q.f(view0, "inflate(...)");
                return view0;
            }
        }
    }

    @Override  // F8.o
    public final View d(View view0) {
        switch(this.g) {
            case 0: {
                q.g(view0, "newView");
                View view1 = view0.findViewById(0x7F0A018F);  // id:btn_plus
                q.f(view1, "findViewById(...)");
                return view1;
            }
            case 1: {
                q.g(view0, "newView");
                return view0;
            }
            case 2: {
                q.g(view0, "newView");
                return view0;
            }
            case 3: {
                q.g(view0, "newView");
                return view0;
            }
            case 4: {
                q.g(view0, "newView");
                return view0.findViewById(0x7F0A0169);  // id:btn_info
            }
            case 5: {
                q.g(view0, "newView");
                return view0.findViewById(0x7F0A0143);  // id:btn_bg
            }
            default: {
                q.g(view0, "newView");
                return view0.findViewById(0x7F0A0143);  // id:btn_bg
            }
        }
    }

    @Override  // F8.o
    public final String e(Context context0) {
        switch(this.g) {
            case 0: {
                q.f("친구추가", "getString(...)");
                return "친구추가";
            }
            case 1: {
                q.f("댓글쓰기", "getString(...)");
                return "댓글쓰기";
            }
            case 2: {
                q.f("정보", "getString(...)");
                return "정보";
            }
            case 3: {
                q.f("플레이리스트 만들기", "getString(...)");
                return "플레이리스트 만들기";
            }
            case 4: {
                q.f("뮤직 DNA 서비스 안내", "getString(...)");
                return "뮤직 DNA 서비스 안내";
            }
            case 5: {
                q.f("등록", "getString(...)");
                return "등록";
            }
            default: {
                q.f("검색 기록 열기", "getString(...)");
                return "검색 기록 열기";
            }
        }
    }

    @Override  // F8.T
    public String f(Context context0) {
        if(this.g != 3) {
            return super.f(context0);
        }
        q.f("플레이리스트 만들기", "getString(...)");
        return "플레이리스트 만들기";
    }

    @Override  // F8.T
    public final int i() {
        switch(this.g) {
            case 0: {
                return 22;
            }
            case 1: {
                return 20;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 0;
            }
            case 4: {
                return 25;
            }
            case 5: {
                return 8;
            }
            default: {
                return 15;
            }
        }
    }
}

