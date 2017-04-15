package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

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