package com.iloen.melon.fragments.searchandadd;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.sns.model.Sharable;
import java.util.List;

public abstract class SearchAndAddBaseAdapter extends p {
    public static class MarkedContsInfo implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        private String markedContsIds;
        private String markedContsTypeCodes;

        static {
            MarkedContsInfo.CREATOR = new Parcelable.Creator() {
                public MarkedContsInfo createFromParcel(Parcel parcel0) {
                    return new MarkedContsInfo(parcel0, 0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public MarkedContsInfo[] newArray(int v) {
                    return new MarkedContsInfo[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        private MarkedContsInfo(Parcel parcel0) {
            this.markedContsIds = parcel0.readString();
            this.markedContsTypeCodes = parcel0.readString();
        }

        public MarkedContsInfo(Parcel parcel0, int v) {
            this(parcel0);
        }

        public MarkedContsInfo(String s, String s1) {
            this.markedContsIds = s;
            this.markedContsTypeCodes = s1;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getMarkedContsIds() {
            return this.markedContsIds;
        }

        public String getMarkedContsTypeCodes() {
            return this.markedContsTypeCodes;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeString(this.markedContsIds);
            parcel0.writeString(this.markedContsTypeCodes);
        }
    }

    public interface OnItemEventListener {
        boolean onAdd(Sharable arg1);
    }

    public interface OnItemViewClickListener {
        void onItemViewClick(View arg1, int arg2);
    }

    public static final String TAG = "SearchAndAddBaseAdapter";
    protected OnItemEventListener mOnItemEventListener;
    public OnItemViewClickListener mOnItemViewClickListener;
    protected int mSearchViewType;

    public SearchAndAddBaseAdapter(Context context0) {
        this(context0, null, -1);
    }

    public SearchAndAddBaseAdapter(Context context0, List list0, int v) {
        super(context0, list0);
        this.mOnItemEventListener = null;
        this.mOnItemViewClickListener = null;
        this.mSearchViewType = v;
    }

    public String getMarkedContsIds() {
        List list0 = this.getMarkedItems();
        if(list0 != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < list0.size(); ++v) {
                if(v > 0) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(this.getSharable(((int)(((Integer)list0.get(v))))).getContentId());
            }
            return stringBuilder0.toString();
        }
        return null;
    }

    public String getMarkedContsTypeCodes() {
        List list0 = this.getMarkedItems();
        if(list0 != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < list0.size(); ++v) {
                if(v > 0) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(this.getSharable(((int)(((Integer)list0.get(v))))).getContsTypeCode().code());
            }
            return stringBuilder0.toString();
        }
        return null;
    }

    public abstract Sharable getSharable(int arg1);

    @Override  // com.iloen.melon.adapters.common.j
    public void setMarked(int v, boolean z) {
        if(this.mOnItemEventListener != null && z && !this.mOnItemEventListener.onAdd(this.getSharable(v))) {
            return;
        }
        super.setMarked(v, z);
    }

    public void setOnItemEventListener(OnItemEventListener searchAndAddBaseAdapter$OnItemEventListener0) {
        this.mOnItemEventListener = searchAndAddBaseAdapter$OnItemEventListener0;
    }

    public void setOnItemViewClickListener(OnItemViewClickListener searchAndAddBaseAdapter$OnItemViewClickListener0) {
        this.mOnItemViewClickListener = searchAndAddBaseAdapter$OnItemViewClickListener0;
    }
}

