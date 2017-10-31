package co.zsmb.materialdrawerktexample

import android.app.Application
import co.zsmb.materialdrawerkt.imageloader.drawerImageLoader
import com.squareup.picasso.Picasso

class DrawerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        drawerImageLoader {
            set { imageView, uri, placeholder, _ ->
                Picasso.with(imageView.context)
                        .load(uri)
                        .placeholder(placeholder)
                        .into(imageView)
            }
            cancel { imageView ->
                Picasso.with(imageView.context)
                        .cancelRequest(imageView)
            }
        }
    }

}
