package co.zsmb.materialdrawerkt.builders

import co.zsmb.materialdrawerkt.DrawerMarker
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
abstract class BuilderBase {

    /**
     * Attaches a drawer item (add as child or add to list, as applicable).
     */
    internal abstract fun attachItem(item: IDrawerItem<*, *>)

}
