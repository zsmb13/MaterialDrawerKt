@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

/**
 * Adds a new SecondaryDrawerItem with the given [name] and [description].
 * @return The created SecondaryDrawerItem instance
 */
public fun Builder.secondaryItem(
        name: String = "",
        description: String? = null,
        setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
    return createItem(SecondaryDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new SecondaryDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SecondaryDrawerItem instance
 */
public fun Builder.secondaryItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
    return createItem(SecondaryDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class SecondaryDrawerItemKt : AbstractBadgeableDrawerItemKt<SecondaryDrawerItem>(SecondaryDrawerItem())
