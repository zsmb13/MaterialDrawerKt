@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.ToggleDrawerItem

/**
 * Adds a new ToggleDrawerItem with the given [name] and [description].
 * @return The created ToggleDrawerItem instance
 */
public fun Builder.toggleItem(
        name: String = "",
        description: String? = null,
        setup: ToggleDrawerItemKt.() -> Unit = {}): ToggleDrawerItem {
    val item = ToggleDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new ToggleDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ToggleDrawerItem instance
 */
public fun Builder.toggleItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: ToggleDrawerItemKt.() -> Unit = {}): ToggleDrawerItem {
    val item = ToggleDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

public class ToggleDrawerItemKt : AbstractToggleableDrawerItemKt() {

    // region Builder basics

    private val item = ToggleDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

    //endregion

}
