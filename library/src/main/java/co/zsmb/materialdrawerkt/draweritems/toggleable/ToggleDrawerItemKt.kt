@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import com.mikepenz.materialdrawer.model.ToggleDrawerItem

/**
 * Adds a new ToggleDrawerItem with the given [name] and [description].
 * @return The created ToggleDrawerItem instance
 */
public fun Builder.toggleItem(
        name: String = "",
        description: String? = null,
        setup: ToggleDrawerItemKt.() -> Unit = {}): ToggleDrawerItem {
    return createItem(ToggleDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new ToggleDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ToggleDrawerItem instance
 */
public fun Builder.toggleItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: ToggleDrawerItemKt.() -> Unit = {}): ToggleDrawerItem {
    return createItem(ToggleDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class ToggleDrawerItemKt : AbstractToggleableDrawerItemKt<ToggleDrawerItem>(ToggleDrawerItem())
