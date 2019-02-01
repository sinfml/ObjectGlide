import android.content.Context;
import android.os.Environment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;
import java.io.File;
import java.io.InputStream;

/**
 * Created by sin on 2018/8/24.
 */

public class CustomGlideModule implements GlideModule {

    class DiskCacheFactory implements DiskLruCacheFactory.CacheDirectoryGetter {
        DiskCacheFactory() {
        }

        public File getCacheDirectory() {
            //创建缓空间 package 名字 自定义 , AlbumArt名字自定义
            File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "package" + File.separator + "AlbumArt");
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        }
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDiskCache(new DiskLruCacheFactory(new DiskCacheFactory(), 70000000));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        glide.register(Object.class, InputStream.class, new CoverLoader.Factory());
    }
}
