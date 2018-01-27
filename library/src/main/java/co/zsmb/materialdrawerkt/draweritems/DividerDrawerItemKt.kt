@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.base.AbstractDrawerItemKt
import com.mikepenz.materialdrawer.model.DividerDrawerItem

/**
 * Adds a new DividerDrawerItem.
 * @return The created DividerDrawerItem instance
 */
public fun Builder.divider(setup: DividerDrawerItemKt.() -> Unit = {}): DividerDrawerItem {
    val item = DividerDrawerItemKt()
    item.setup()
    return item.build().apply { attachItem(this) }
}

public class DividerDrawerItemKt : AbstractDrawerItemKt<DividerDrawerItem>(DividerDrawerItem())
