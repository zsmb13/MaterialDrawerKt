package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.base.AbstractBadgeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

fun BuilderBase.primaryItem(
        name: String = "",
        description: String = "",
        setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
    val item = PrimaryDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class PrimaryDrawerItemKt(name: String, description: String) : AbstractBadgeableDrawerItemKt() {

    private val item = PrimaryDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}