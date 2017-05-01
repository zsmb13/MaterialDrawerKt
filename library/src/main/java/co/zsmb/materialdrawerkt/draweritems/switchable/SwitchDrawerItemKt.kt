package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.SwitchDrawerItem

/**
 * Adds a new SwitchDrawerItem with the given [name] and [description].
 * @return The created SwitchDrawerItem instance
 */
fun Builder.switchItem(
        name: String = "",
        description: String? = null,
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    val item = SwitchDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new SwitchDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SwitchDrawerItem instance
 */
fun Builder.switchItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    val item = SwitchDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}


class SwitchDrawerItemKt : AbstractSwitchableDrawerItemKt() {

    /* Builder basics */

    private val item = SwitchDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
