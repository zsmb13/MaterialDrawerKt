package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.SecondaryToggleDrawerItem

/**
 * Adds a new SecondaryToggleDrawerItem with the given [name] and [description].
 * @return The created SecondaryToggleDrawerItem instance
 */
fun Builder.secondaryToggleItem(
        name: String = "",
        description: String? = null,
        setup: SecondaryToggleDrawerItemKt.() -> Unit = {}): SecondaryToggleDrawerItem {
    val item = SecondaryToggleDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new SecondaryToggleDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SecondaryToggleDrawerItem instance
 */
fun Builder.secondaryToggleItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SecondaryToggleDrawerItemKt.() -> Unit = {}): SecondaryToggleDrawerItem {
    val item = SecondaryToggleDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondaryToggleDrawerItemKt : AbstractToggleableDrawerItemKt() {

    /* Builder basics */

    private val item = SecondaryToggleDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
