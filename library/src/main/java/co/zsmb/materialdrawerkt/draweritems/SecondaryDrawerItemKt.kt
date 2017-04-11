package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.base.AbstractBadgeableDrawerItemKt
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

class SecondaryDrawerItemKt(name: String, description: String) : AbstractBadgeableDrawerItemKt() {

    private val item = SecondaryDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}
