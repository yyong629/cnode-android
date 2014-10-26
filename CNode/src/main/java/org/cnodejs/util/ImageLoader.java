package org.cnodejs.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.cnodejs.BuildConfig;

public class ImageLoader {

    public static void load(ImageView view, String url) {
        if (url.startsWith("//")) {
            url = "https:" + url;
        }

        // TODO: 暂时的 workaround， 未做仔细处理
        // 将 Gravatar 默认的 48x48 替换成 120x120（按我们的 ImageView 大小是 40dp，xxhdpi 分辨率计算）
        if (url.contains("gravatar.com") && url.contains("size=48")) {
            url = url.replace("size=48", "size=120");
        }

        Picasso picasso = Picasso.with(view.getContext());
        picasso.setLoggingEnabled(BuildConfig.DEBUG);
        picasso.load(url).into(view);
    }

}
