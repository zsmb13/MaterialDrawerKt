@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.builders

import co.zsmb.materialdrawerkt.DrawerMarker
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
interface Builder {

    /**
     * Attaches a drawer item (add as child or add to list, as applicable).
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Only for use with custom drawer items.")
    fun attachItem(item: IDrawerItem<*, *>)

}
