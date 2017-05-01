package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerktexample.R
import co.zsmb.materialdrawerktexample.R.layout.material_drawer_fits_not
import com.mikepenz.fontawesome_typeface_library.FontAwesome.Icon
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.Nameable

class ActionBarActivity : AppCompatActivity() {

    private lateinit var result: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_no_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            savedInstance = savedInstanceState
            displayBelowStatusBar = false
            translucentStatusBar = false
            drawerLayoutRes = material_drawer_fits_not

            primaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_home) { iicon = Icon.faw_home }
            primaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_free_play) { iicon = Icon.faw_gamepad }
            primaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_custom) { iicon = Icon.faw_eye }
            sectionHeader(co.zsmb.materialdrawerktexample.R.string.drawer_item_section_header)
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_settings) { iicon = Icon.faw_cog }
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_help) { iicon = Icon.faw_question }
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_open_source) { iicon = Icon.faw_github }
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_contact) { iicon = Icon.faw_bullhorn }

            onItemClick { _, _, drawerItem ->
                if (drawerItem is Nameable<*>) {
                    supportActionBar?.title = drawerItem.name.getText(this@ActionBarActivity)
                }
                false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed(); true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onSaveInstanceState(outState: Bundle?) {
        result.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

}
