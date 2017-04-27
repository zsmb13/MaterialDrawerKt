package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

/**
 * Adds a new SecondaryDrawerItem with the given [name] and [description].
 * @return The created SecondaryDrawerItem instance
 */
fun Builder.secondaryItem(
        name: String = "",
        description: String? = null,
        setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
    val item = SecondaryDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new SecondaryDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SecondaryDrawerItem instance
 */
fun Builder.secondaryItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
    val item = SecondaryDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondaryDrawerItemKt : AbstractBadgeableDrawerItemKt() {

    /* Builder basics */

    private val item = SecondaryDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
