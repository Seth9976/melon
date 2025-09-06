package v3;

import androidx.media3.common.b;
import b3.q0;
import java.util.List;
import t3.a;
import t3.c;

public interface o {
    boolean a(int arg1, long arg2);

    default boolean b(long v, a a0, List list0) {
        return false;
    }

    boolean c(int arg1, long arg2);

    void d(long arg1, long arg2, long arg3, List arg4, c[] arg5);

    void disable();

    void e(boolean arg1);

    void enable();

    int evaluateQueueSize(long arg1, List arg2);

    default void f() {
    }

    b getFormat(int arg1);

    int getIndexInTrackGroup(int arg1);

    b getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    q0 getTrackGroup();

    int indexOf(int arg1);

    int length();

    default void onDiscontinuity() {
    }

    void onPlaybackSpeed(float arg1);
}

