@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.imageloader

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader
import com.mikepenz.materialdrawer.util.DrawerImageLoader

/**
 * Initializes the MaterialDrawer library for image loading.
 *
 * Wraps the [DrawerImageLoader.init] method.
 *
 * @return The created IDrawerImageLoader instance
 */
public fun drawerImageLoader(actions: DrawerImageLoaderKt.() -> Unit): DrawerImageLoader.IDrawerImageLoader {
    val loaderImpl = DrawerImageLoaderKt().apply(actions).build()
    DrawerImageLoader.init(loaderImpl)
    return loaderImpl
}

public class DrawerImageLoaderKt {

    private var setFunc: ((ImageView, Uri, Drawable?, String?) -> Unit)? = null
    private var cancelFunc: ((ImageView) -> Unit)? = null
    private var placeholderFunc: ((Context, String?) -> Drawable)? = null

    internal fun build() = object : AbstractDrawerImageLoader() {

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

    /**
     * Describes how an image with a given [uri] can be loaded into the [imageView].
     *
     * Wraps the [DrawerImageLoader.IDrawerImageLoader.set] method.
     *
     * @param imageView The ImageView to load the image into
     * @param uri The URI of the image
     * @param placeholder The placeholder that can be used for the image
     * @param tag The tag of the image
     */
    public fun set(setFunction: (imageView: ImageView, uri: Uri, placeholder: Drawable?, tag: String?) -> Unit) {
        this.setFunc = setFunction
    }

    /**
     * Describes how to an image loading request can be cancelled for the [imageView].
     *
     * Wraps the [DrawerImageLoader.IDrawerImageLoader.cancel] method.
     *
     * @param imageView The ImageView to cancel the operation on
     */
    public fun cancel(cancelFunction: (imageView: ImageView) -> Unit) {
        this.cancelFunc = cancelFunction
    }

    /**
     * Describes the placeholder to be used for a given [tag].
     *
     * Wraps the [DrawerImageLoader.IDrawerImageLoader.placeholder] method.
     *
     * @param ctx The context of the image being loaded
     * @param tag The tag to get a placeholder for
     */
    public fun placeholder(placeholderFunction: (ctx: Context, tag: String?) -> Drawable) {
        this.placeholderFunc = placeholderFunction
    }

}
