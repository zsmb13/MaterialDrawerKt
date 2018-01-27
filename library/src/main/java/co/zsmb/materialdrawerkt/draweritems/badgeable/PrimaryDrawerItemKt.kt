@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

/**
 * Adds a new PrimaryDrawerItem with the given [name] and [description].
 * @return The created PrimaryDrawerItem instance
 */
public fun Builder.primaryItem(
        name: String = "",
        description: String? = null,
        setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
    return createItem(PrimaryDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new PrimaryDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created PrimaryDrawerItem instance
 */
public fun Builder.primaryItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
    return createItem(PrimaryDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class PrimaryDrawerItemKt : AbstractBadgeableDrawerItemKt<PrimaryDrawerItem>(PrimaryDrawerItem())