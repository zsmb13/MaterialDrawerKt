package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem

/**
 * Adds a new SecondarySwitchDrawerItem with the given [name] and [description].
 * @return The created SecondarySwitchDrawerItem instance
 */
fun BuilderBase.secondarySwitchItem(
        name: String = "",
        description: String? = null,
        setup: SecondarySwitchDrawerItemKt.() -> Unit = {}): SecondarySwitchDrawerItem {
    val item = SecondarySwitchDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondarySwitchDrawerItemKt : AbstractSwitchableDrawerItemKt() {

    /* Builder basics */

    private val item = SecondarySwitchDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
