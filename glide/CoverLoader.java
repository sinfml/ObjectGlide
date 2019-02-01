import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

/**
 * Created by sin on 2018/8/24.
 */

public class CoverLoader implements ModelLoader<Object, InputStream>{

    private final ModelCache<Object, Object> mModelCache;
    CoverFetcher mCoverFetcher;
    public static class Factory implements ModelLoaderFactory<Object, InputStream> {
        private final ModelCache<Object, Object> mModelCache = new ModelCache(500);

        @Override
        public ModelLoader<Object, InputStream> build(Context context, GenericLoaderFactory
                factories) {
            return new CoverLoader(this.mModelCache);
        }

        @Override
        public void teardown() {

        }
    }

    public CoverLoader(ModelCache<Object, Object> mModelCache) {
        this.mModelCache = mModelCache;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(Object model, int width, int height) {
        Object object = model;
        if (this.mModelCache != null) {
            //若缓存中存在..先从还缓存中取
            object = this.mModelCache.get(model, 0, 0);
            if (object == null) {
                this.mModelCache.put(model, 0, 0, model);
                object = model;
            }
            this.mCoverFetcher = new CoverFetcher(object);
            return this.mCoverFetcher;
        }
        return null;
    }
}
