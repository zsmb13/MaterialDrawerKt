package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

/**
 * Adds a new PrimaryDrawerItem with the given [name] and [description].
 * @return The created PrimaryDrawerItem instance
 */
fun Builder.primaryItem(
        name: String = "",
        description: String? = null,
        setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
    val item = PrimaryDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new PrimaryDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created PrimaryDrawerItem instance
 */
fun Builder.primaryItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
    val item = PrimaryDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class PrimaryDrawerItemKt : AbstractBadgeableDrawerItemKt() {

    /* Builder basics */

    private val item = PrimaryDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
