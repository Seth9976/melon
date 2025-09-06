package B9;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class l extends O0 {
    public TextView artistTv;
    public ImageView checkIv;
    public ImageView defaultThumbnailIv;
    public ImageView gradeIv;
    public TextView issueTv;
    public ImageView moreIv;
    public TextView playtimeTv;
    public TextView roundTv;
    public View thumbContainer;
    public ImageView thumbnailIv;
    public TextView titleTv;
    public View underline;
    public TextView viewCountTv;
    public View wrapperLayout;

    public l(View view0) {
        super(view0);
        Context context0 = view0.getContext();
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.thumbContainer = view1;
        this.thumbnailIv = (ImageView)view1.findViewById(0x7F0A069A);  // id:iv_thumb
        ImageView imageView0 = (ImageView)this.thumbContainer.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.defaultThumbnailIv = imageView0;
        if(context0 != null) {
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(context0, 92.0f));
        }
        this.roundTv = (TextView)view0.findViewById(0x7F0A0CFF);  // id:tv_round
        this.titleTv = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.artistTv = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.issueTv = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        this.viewCountTv = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
        this.moreIv = (ImageView)view0.findViewById(0x7F0A081B);  // id:more_iv
        this.playtimeTv = (TextView)view0.findViewById(0x7F0A0CE5);  // id:tv_playtime
        this.gradeIv = (ImageView)view0.findViewById(0x7F0A0633);  // id:iv_grade
        this.checkIv = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
        this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
    }
}

