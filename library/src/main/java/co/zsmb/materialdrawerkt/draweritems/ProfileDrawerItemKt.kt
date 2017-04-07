package co.zsmb.materialdrawerkt.draweritems

import android.graphics.drawable.Drawable
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class ProfileDrawerItemKt(name: String, email: String) {

    private val item = ProfileDrawerItem()

    init {
        item.withName(name)
        item.withEmail(email)
    }

    var icon: Int?
        get() = null
        set(value) {
            if (value == null) {
                item.withIcon(null as Drawable?)
                return
            }
            item.withIcon(value)
        }

    internal fun build() = item

}

