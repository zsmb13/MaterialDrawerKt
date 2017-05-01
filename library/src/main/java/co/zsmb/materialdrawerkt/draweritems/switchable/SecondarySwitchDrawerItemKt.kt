package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem

/**
 * Adds a new SecondarySwitchDrawerItem with the given [name] and [description].
 * @return The created SecondarySwitchDrawerItem instance
 */
fun Builder.secondarySwitchItem(
        name: String = "",
        description: String? = null,
        setup: SecondarySwitchDrawerItemKt.() -> Unit = {}): SecondarySwitchDrawerItem {
    val item = SecondarySwitchDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new SecondarySwitchDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SecondarySwitchDrawerItem instance
 */
fun Builder.secondarySwitchItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SecondarySwitchDrawerItemKt.() -> Unit = {}): SecondarySwitchDrawerItem {
    val item = SecondarySwitchDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
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
