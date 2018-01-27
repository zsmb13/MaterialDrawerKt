@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem

/**
 * Adds a new SecondarySwitchDrawerItem with the given [name] and [description].
 * @return The created SecondarySwitchDrawerItem instance
 */
public fun Builder.secondarySwitchItem(
        name: String = "",
        description: String? = null,
        setup: SecondarySwitchDrawerItemKt.() -> Unit = {}): SecondarySwitchDrawerItem {
    return createItem(SecondarySwitchDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new SecondarySwitchDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created SecondarySwitchDrawerItem instance
 */
public fun Builder.secondarySwitchItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: SecondarySwitchDrawerItemKt.() -> Unit = {}): SecondarySwitchDrawerItem {
    return createItem(SecondarySwitchDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class SecondarySwitchDrawerItemKt :
        AbstractSwitchableDrawerItemKt<SecondarySwitchDrawerItem>(SecondarySwitchDrawerItem())
