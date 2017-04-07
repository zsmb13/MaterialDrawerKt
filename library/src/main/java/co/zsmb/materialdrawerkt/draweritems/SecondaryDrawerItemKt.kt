package co.zsmb.materialdrawerkt.draweritems

import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

class SecondaryDrawerItemKt(name: String, description: String) {

    private val item = SecondaryDrawerItem()

    init {
        item.withName(name)
                .withDescription(description)
    }

    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    var iconTintingEnabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withIconTintingEnabled(value)
        }

    internal fun build() = item

}
