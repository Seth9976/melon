package com.google.android.gms.auth.blockstore;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

public interface BlockstoreClient extends HasApiKey {
    public static final String DEFAULT_BYTES_DATA_KEY = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";
    public static final int MAX_ENTRY_COUNT = 16;
    public static final int MAX_SIZE = 0x1000;

    Task deleteBytes(DeleteBytesRequest arg1);

    Task isEndToEndEncryptionAvailable();

    @Deprecated
    Task retrieveBytes();

    Task retrieveBytes(RetrieveBytesRequest arg1);

    Task storeBytes(StoreBytesData arg1);
}

