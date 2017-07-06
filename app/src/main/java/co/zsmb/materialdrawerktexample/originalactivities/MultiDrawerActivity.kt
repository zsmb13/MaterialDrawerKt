package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badge
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerktexample.R
import co.zsmb.materialdrawerktexample.utils.toast
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.Badgeable
import com.mikepenz.materialdrawer.model.interfaces.Nameable
import kotlinx.android.synthetic.main.activity_sample.*

class MultiDrawerActivity : AppCompatActivity() {

    private lateinit var result: Drawer
    private lateinit var resultAppended: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            headerViewRes = R.layout.header
            savedInstance = savedInstanceState

            primaryItem(R.string.drawer_item_home) {
                iicon = FontAwesome.Icon.faw_home
                badge("99")
            }
            primaryItem(R.string.drawer_item_free_play) { iicon = FontAwesome.Icon.faw_gamepad }
            primaryItem(R.string.drawer_item_custom) {
                iicon = FontAwesome.Icon.faw_eye
                badge("6")
            }
            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_settings) { iicon = FontAwesome.Icon.faw_cog }
            secondaryItem(R.string.drawer_item_help) { iicon = FontAwesome.Icon.faw_question }
            secondaryItem(R.string.drawer_item_open_source) {
                iicon = FontAwesome.Icon.faw_github
                badge("12")
            }
            secondaryItem(R.string.drawer_item_contact) { iicon = FontAwesome.Icon.faw_bullhorn }

            fun logAndShow(message: String) {
                android.util.Log.d("DRAWER_EVENT", message)
                txtLabel.text = message
            }

            onOpened { drawerView ->
                when (drawerView) {
                    result.slider -> logAndShow("opened left")
                    resultAppended.slider -> logAndShow("opened right")
                }
            }
            onClosed { drawerView ->
                when (drawerView) {
                    result.slider -> logAndShow("closed left")
                    resultAppended.slider -> logAndShow("closed right")
                }
            }

            onItemClick { _, _, drawerItem ->
                if (drawerItem is Nameable<*>) {
                    toast(drawerItem.name.getText(this@MultiDrawerActivity))
                }
                if (drawerItem is Badgeable<*>) {
                    drawerItem.badge?.let {
                        drawerItem.withBadge("${it.toString().toInt() + 1}")
                        result.updateItem(drawerItem)
                    }
                }
                false
            }

            onItemLongClick { _, _, drawerItem ->
                if (drawerItem is SecondaryDrawerItem) {
                    toast(drawerItem.name.getText(this@MultiDrawerActivity))
                }
                false
            }
        }

        resultAppended = drawer {
            savedInstance = savedInstanceState
            footerViewRes = R.layout.footer
            displayBelowStatusBar = true

            // Specific things that are important for setting up multi drawer
            primaryDrawer = result
            gravity = Gravity.END

            primaryItem(R.string.drawer_item_custom) { iicon = FontAwesome.Icon.faw_eye }
            primaryItem(R.string.drawer_item_home) { iicon = FontAwesome.Icon.faw_home }
            primaryItem(R.string.drawer_item_free_play) { iicon = FontAwesome.Icon.faw_gamepad }
            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_open_source) { iicon = FontAwesome.Icon.faw_github }
            secondaryItem(R.string.drawer_item_help) { iicon = FontAwesome.Icon.faw_question }
            secondaryItem(R.string.drawer_item_settings) { iicon = FontAwesome.Icon.faw_cog }
            secondaryItem(R.string.drawer_item_contact) { iicon = FontAwesome.Icon.faw_bullhorn }

            onItemClick { _, _, drawerItem ->
                if (drawerItem is Nameable<*>) {
                    toast(drawerItem.name.getText(this@MultiDrawerActivity))
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
        resultAppended.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

}
