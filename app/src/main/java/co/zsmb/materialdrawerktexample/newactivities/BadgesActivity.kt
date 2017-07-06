package co.zsmb.materialdrawerktexample.newactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badge
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.expandable.expandableBadgeItem
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import kotlinx.android.synthetic.main.activity_sample.*

class BadgesActivity : AppCompatActivity() {

    private lateinit var result: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            savedInstance = savedInstanceState
            toolbar = this@BadgesActivity.toolbar
            closeOnClick = false

            accountHeader { background = R.drawable.header }

            sectionHeader("Standard badges") { divider = false }
            primaryItem("Primary") {
                badge("111")
                iicon = FontAwesome.Icon.faw_heart
            }
            secondaryItem("Secondary") {
                badge("222")
                iicon = FontAwesome.Icon.faw_heart
            }
            expandableBadgeItem("Expandable badge") {
                badge("333")
                iicon = FontAwesome.Icon.faw_heart
                secondaryItem("Subitem 1") { level = 2 }
                secondaryItem("Subitem 2") { level = 2 }
            }

            sectionHeader("Customized badges")
            primaryItem("Custom 1") {
                badge("111") {
                    color = 0xFF0099FF
                    colorPressed = 0xFFCC99FF
                    cornersDp = 0
                    paddingHorizontalDp = 25
                }
                iicon = FontAwesome.Icon.faw_heart
                selectable = false
            }
            primaryItem("Custom 2") {
                badge("222") {
                    color = 0xFF66FF33
                    colorPressed = 0xFFFFFF99
                    cornersPx = 30
                    minWidthPx = 150
                    paddingVerticalPx = 20
                    textColor = 0xFFFF9900
                }
                iicon = FontAwesome.Icon.faw_heart
                selectable = false
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
