package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class ProfileDrawerItemKt(name: String, email: String) {

    private val item = ProfileDrawerItem()

    init {
        item.withName(name)
        item.withEmail(email)
    }

    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    internal fun build() = item

}

