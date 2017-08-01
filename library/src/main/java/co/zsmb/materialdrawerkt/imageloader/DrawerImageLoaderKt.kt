package co.zsmb.materialdrawerkt.imageloader

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader
import com.mikepenz.materialdrawer.util.DrawerImageLoader

fun drawerImageLoader(actions: DrawerImageLoaderKt.() -> Unit) =
        DrawerImageLoaderKt().apply(actions).build().run(DrawerImageLoader::init)

class DrawerImageLoaderKt {

    private var setFunc: ((ImageView, Uri, Drawable?, String?) -> Unit)? = null
    private var cancelFunc: ((ImageView) -> Unit)? = null
    private var placeholderFunc: ((Context, String?) -> Drawable)? = null

    fun build() = object : AbstractDrawerImageLoader() {

        private val setFunction: (ImageView, Uri, Drawable?, String?) -> Unit = setFunc
                ?: throw IllegalStateException("DrawerImageLoader has to have a set function")

        private val cancelFunction: (ImageView) -> Unit = cancelFunc
                ?: throw IllegalStateException("DrawerImageLoader has to have a cancel function")

        private val placeholderFunction = placeholderFunc
                ?: { ctx, tag -> super.placeholder(ctx, tag) }

        override fun set(imageView: ImageView, uri: Uri, placeholder: Drawable?, tag: String?) = setFunction(imageView, uri, placeholder, tag)

        override fun cancel(imageView: ImageView) = cancelFunction(imageView)

        override fun placeholder(ctx: Context, tag: String?) = placeholderFunction(ctx, tag)

    }

    fun set(setFunction: (imageView: ImageView, uri: Uri, placeholder: Drawable?, tag: String?) -> Unit) {
        this.setFunc = setFunction
    }

    fun placeholder(placeholderFunction: (ctx: Context, tag: String?) -> Drawable) {
        this.placeholderFunc = placeholderFunction
    }

    fun cancel(cancelFunction: (imageView: ImageView) -> Unit) {
        this.cancelFunc = cancelFunction
    }

}
