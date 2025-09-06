package com.iloen.melon.popup;

import androidx.recyclerview.widget.v;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\b\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/iloen/melon/popup/RemoteConnectPopup$DeviceAdapter$Companion$diffUtilCallback$1", "Landroidx/recyclerview/widget/v;", "Lcom/iloen/melon/popup/DeviceInfoWrapper;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/iloen/melon/popup/DeviceInfoWrapper;Lcom/iloen/melon/popup/DeviceInfoWrapper;)Z", "areContentsTheSame", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RemoteConnectPopup.DeviceAdapter.Companion.diffUtilCallback.1 extends v {
    public boolean areContentsTheSame(DeviceInfoWrapper deviceInfoWrapper0, DeviceInfoWrapper deviceInfoWrapper1) {
        q.g(deviceInfoWrapper0, "oldItem");
        q.g(deviceInfoWrapper1, "newItem");
        return deviceInfoWrapper0.equals(deviceInfoWrapper1);
    }

    @Override  // androidx.recyclerview.widget.v
    public boolean areContentsTheSame(Object object0, Object object1) {
        return this.areContentsTheSame(((DeviceInfoWrapper)object0), ((DeviceInfoWrapper)object1));
    }

    public boolean areItemsTheSame(DeviceInfoWrapper deviceInfoWrapper0, DeviceInfoWrapper deviceInfoWrapper1) {
        q.g(deviceInfoWrapper0, "oldItem");
        q.g(deviceInfoWrapper1, "newItem");
        return deviceInfoWrapper0.equals(deviceInfoWrapper1);
    }

    @Override  // androidx.recyclerview.widget.v
    public boolean areItemsTheSame(Object object0, Object object1) {
        return this.areItemsTheSame(((DeviceInfoWrapper)object0), ((DeviceInfoWrapper)object1));
    }
}

