@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import com.mikepenz.materialdrawer.model.SecondaryToggleDrawerItem

/**
 * Adds a new SecondaryToggleDrawerItem with the given [name] and [description].
 * @return The created SecondaryToggleDrawerItem instance
 */
public fun Builder.secondaryToggleItem(
        name: String = "",
        description: String? = null,
        setup: SecondaryToggleDrawerItemKt.() -> Unit = {}): SecondaryToggleDrawerItem {
    return createItem(SecondaryToggleDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new SecondaryToggleDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SecondaryToggleDrawerItem instance
 */
public fun Builder.secondaryToggleItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SecondaryToggleDrawerItemKt.() -> Unit = {}): SecondaryToggleDrawerItem {
    return createItem(SecondaryToggleDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class SecondaryToggleDrawerItemKt :
        AbstractToggleableDrawerItemKt<SecondaryToggleDrawerItem>(SecondaryToggleDrawerItem())
