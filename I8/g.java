package I8;

import com.iloen.melon.utils.FilenameUtils;
import java.io.File;
import java.io.FileFilter;

public final class g implements FileFilter {
    // 去混淆评级： 低(30)
    @Override
    public final boolean accept(File file0) {
        return file0.isDirectory() || file0.isFile() && FilenameUtils.isDcf(file0.getName());
    }
}

