package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class b implements Parcelable.Creator {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                return new BackStackRecordState(parcel0);
            }
            case 1: {
                return new BackStackState(parcel0);
            }
            case 2: {
                FragmentManager.LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo0 = new FragmentManager.LaunchedFragmentInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                fragmentManager$LaunchedFragmentInfo0.a = parcel0.readString();
                fragmentManager$LaunchedFragmentInfo0.b = parcel0.readInt();
                return fragmentManager$LaunchedFragmentInfo0;
            }
            case 3: {
                FragmentManagerState fragmentManagerState0 = new FragmentManagerState();  // 初始化器: Ljava/lang/Object;-><init>()V
                fragmentManagerState0.e = null;
                fragmentManagerState0.f = new ArrayList();
                fragmentManagerState0.g = new ArrayList();
                fragmentManagerState0.a = parcel0.createStringArrayList();
                fragmentManagerState0.b = parcel0.createStringArrayList();
                fragmentManagerState0.c = (BackStackRecordState[])parcel0.createTypedArray(BackStackRecordState.CREATOR);
                fragmentManagerState0.d = parcel0.readInt();
                fragmentManagerState0.e = parcel0.readString();
                fragmentManagerState0.f = parcel0.createStringArrayList();
                fragmentManagerState0.g = parcel0.createTypedArrayList(BackStackState.CREATOR);
                fragmentManagerState0.h = parcel0.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
                return fragmentManagerState0;
            }
            default: {
                return new FragmentState(parcel0);
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new BackStackRecordState[v];
            }
            case 1: {
                return new BackStackState[v];
            }
            case 2: {
                return new FragmentManager.LaunchedFragmentInfo[v];
            }
            case 3: {
                return new FragmentManagerState[v];
            }
            default: {
                return new FragmentState[v];
            }
        }
    }
}

