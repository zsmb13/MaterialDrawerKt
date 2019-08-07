package co.zsmb.materialdrawerktexample

import android.app.Application
import co.zsmb.materialdrawerkt.imageloader.drawerImageLoader
import com.squareup.picasso.Picasso

class DrawerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        drawerImageLoader {
            set { imageView, uri, placeholder, _ ->
                Picasso.get()
                        .load(uri)
                        .placeholder(placeholder)
                        .into(imageView)
            }
            cancel { imageView ->
                Picasso.get()
                        .cancelRequest(imageView)
            }
        }
    }

}
