package l5;

import kotlinx.coroutines.CoroutineDispatcher;
import okio.FileSystem;
import okio.Path;

public final class h implements a {
    public final FileSystem a;
    public final f b;

    public h(long v, CoroutineDispatcher coroutineDispatcher0, FileSystem fileSystem0, Path path0) {
        this.a = fileSystem0;
        this.b = new f(v, coroutineDispatcher0, fileSystem0, path0);
    }
}

