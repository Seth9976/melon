package com.iloen.melon.playback.playlist.smartplaylist;

import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.net.mcp.AddOptionServer;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0002*\u00020\u0001\u001A\n\u0010\u0004\u001A\u00020\u0005*\u00020\u0006\u001A\n\u0010\u0007\u001A\u00020\u0006*\u00020\u0005\u001A\n\u0010\b\u001A\u00020\u0005*\u00020\u0005\u001A\n\u0010\t\u001A\u00020\u0005*\u00020\u0005¨\u0006\n"}, d2 = {"asAddOptionServer", "Lcom/iloen/melon/net/mcp/AddOptionServer;", "Lcom/iloen/melon/constants/AddPosition;", "asAddPosition", "asIsDeleteExisting", "", "Lcom/iloen/melon/constants/ListKeepOption;", "asListKeepOption", "asRemoveDuplicated", "asIsAllowDuplicate", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MapperKt {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[AddPosition.values().length];
            try {
                arr_v[0] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[2] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[AddOptionServer.values().length];
            try {
                arr_v1[AddOptionServer.FIRST.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[AddOptionServer.LAST.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[AddOptionServer.AFTER_CURRENT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    @NotNull
    public static final AddOptionServer asAddOptionServer(@NotNull AddPosition addPosition0) {
        q.g(addPosition0, "<this>");
        switch(addPosition0.ordinal()) {
            case 0: {
                return AddOptionServer.FIRST;
            }
            case 1: {
                return AddOptionServer.LAST;
            }
            case 2: {
                return AddOptionServer.AFTER_CURRENT;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @NotNull
    public static final AddPosition asAddPosition(@NotNull AddOptionServer addOptionServer0) {
        q.g(addOptionServer0, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$1[addOptionServer0.ordinal()]) {
            case 1: {
                return AddPosition.b;
            }
            case 2: {
                return AddPosition.c;
            }
            case 3: {
                return AddPosition.d;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final boolean asIsAllowDuplicate(boolean z) [...] // Inlined contents

    public static final boolean asIsDeleteExisting(@NotNull ListKeepOption listKeepOption0) {
        q.g(listKeepOption0, "<this>");
        return listKeepOption0 != ListKeepOption.b;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final ListKeepOption asListKeepOption(boolean z) {
        return z ? ListKeepOption.c : ListKeepOption.b;
    }

    public static final boolean asRemoveDuplicated(boolean z) [...] // Inlined contents
}

