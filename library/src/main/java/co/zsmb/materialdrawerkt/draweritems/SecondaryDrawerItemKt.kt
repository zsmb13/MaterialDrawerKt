package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

fun BuilderBase.secondaryItem(
        name: String = "",
        description: String = "",
        setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
    val item = SecondaryDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

@DrawerMarker
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
