package co.zsmb.materialdrawerktexample

import android.app.Application
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader
import com.mikepenz.materialdrawer.util.DrawerImageLoader
import com.squareup.picasso.Picasso

class DrawerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DrawerImageLoader.init(object : AbstractDrawerImageLoader() {

            override fun set(imageView: ImageView?, uri: Uri?, placeholder: Drawable?) {
                if (imageView == null) return
                Picasso.with(imageView.context).load(uri).placeholder(placeholder).into(imageView)
            }

            override fun cancel(imageView: ImageView?) {
                if (imageView == null) return
                Picasso.with(imageView.context).cancelRequest(imageView)
            }

        })

/*
        drawerImageLoader {
            set { imageView, uri, placeholder ->
                Picasso.with(imageView)
                        .load(uri)
                        .placeholder(placeholder)
                        .into(imageView)
            }
            cancel {
                Picasso.with(it.context).cancelRequest(it)
            }
        }
*/
    }

}
