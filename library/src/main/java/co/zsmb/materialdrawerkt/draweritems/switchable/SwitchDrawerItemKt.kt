@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import com.mikepenz.materialdrawer.model.SwitchDrawerItem

/**
 * Adds a new SwitchDrawerItem with the given [name] and [description].
 * @return The created SwitchDrawerItem instance
 */
public fun Builder.switchItem(
        name: String = "",
        description: String? = null,
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    return createItem(SwitchDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new SwitchDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SwitchDrawerItem instance
 */
public fun Builder.switchItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    return createItem(SwitchDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class SwitchDrawerItemKt : AbstractSwitchableDrawerItemKt<SwitchDrawerItem>(SwitchDrawerItem())
