package co.zsmb.materialdrawerktexample.customitems.overflow

import android.support.annotation.LayoutRes
import android.support.v7.widget.PopupMenu
import android.view.View
import android.widget.ImageButton
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.materialdrawer.model.BaseDescribeableDrawerItem
import com.mikepenz.materialdrawer.model.BaseViewHolder
import kotlinx.android.synthetic.main.material_drawer_item_overflow_menu_primary.view.*

// Regular class that overrides the base library item
class OverflowMenuDrawerItem : BaseDescribeableDrawerItem<OverflowMenuDrawerItem, OverflowMenuDrawerItem.ViewHolder>() {

    internal var menu: Int = 0
    internal var onMenuItemClickListener: PopupMenu.OnMenuItemClickListener? = null
    internal var onDismissListener: PopupMenu.OnDismissListener? = null

    @LayoutRes
    override fun getLayoutRes() = R.layout.material_drawer_item_overflow_menu_primary

    override fun getType() = R.id.material_drawer_item_overflow_menu

    override fun bindView(viewHolder: ViewHolder, payloads: List<*>?) {
        super.bindView(viewHolder, payloads)
        bindViewHelper(viewHolder)

        viewHolder.menu.setOnClickListener { view ->
            with(PopupMenu(view.context, view)) {
                menuInflater.inflate(this@OverflowMenuDrawerItem.menu, menu)

                onMenuItemClickListener?.let { setOnMenuItemClickListener(it) }
                onDismissListener?.let { setOnDismissListener(it) }

                show()
            }
        }

        val ctx = viewHolder.itemView.context
        viewHolder.menu.setImageDrawable(
                IconicsDrawable(ctx, GoogleMaterial.Icon.gmd_more_vert)
                        .sizeDp(12)
                        .color(getIconColor(ctx))
        )

        //call the onPostBindView method to trigger post bind view actions
        onPostBindView(this, viewHolder.itemView)
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : BaseViewHolder(view) {
        // Conventional lookup
        //internal val menu: ImageButton = view.findViewById(R.id.material_drawer_menu_overflow) as ImageButton

        // Kotlin Android Extensions
        internal val menu: ImageButton = view.material_drawer_menu_overflow
    }

}
