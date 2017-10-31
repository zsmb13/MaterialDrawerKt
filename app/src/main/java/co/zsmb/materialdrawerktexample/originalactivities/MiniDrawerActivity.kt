package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.divider
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.profile.profileSetting
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerkt.draweritems.switchable.switchItem
import co.zsmb.materialdrawerkt.draweritems.toggleable.toggleItem
import co.zsmb.materialdrawerktexample.R
import co.zsmb.materialdrawerktexample.utils.CrossfadeWrapper
import co.zsmb.materialdrawerktexample.utils.toast
import com.mikepenz.crossfader.Crossfader
import com.mikepenz.crossfader.util.UIUtils
import com.mikepenz.crossfader.view.CrossFadeSlidingPaneLayout
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.google_material_typeface_library.GoogleMaterial
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.octicons_typeface_library.Octicons
import kotlinx.android.synthetic.main.activity_mini_drawer.*

class MiniDrawerActivity : AppCompatActivity() {

    private lateinit var headerResult: AccountHeader
    private lateinit var result: Drawer
    private lateinit var resultAppended: Drawer
    private lateinit var crossFader: Crossfader<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mini_drawer)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            savedInstance = savedInstanceState
            translucentStatusBar = false
            toolbar = this@MiniDrawerActivity.toolbar

            // Mini drawer specific things
            buildViewOnly = true
            generateMiniDrawer = true

            headerResult = accountHeader {
                savedInstance = savedInstanceState
                translucentStatusBar = false
                background = R.drawable.header

                profile("Mike Penz", "mikepenz@gmail.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/1476232?v=3&s=460"
                }
                profile("Bernat Borras", "alorma@github.com") {
                    iconUrl = "https://avatars3.githubusercontent.com/u/887462?v=3&s=460"
                }
                profile("Max Muster", "max.mustermann@gmail.com") { icon = R.drawable.profile2 }
                profile("Felix House", "felix.house@gmail.com") { icon = R.drawable.profile3 }
                profile("Mr. X", "mister.x.super@gmail.com") { icon = R.drawable.profile4 }
                profile("Batman", "batman@gmail.com") { icon = R.drawable.profile5 }
                profileSetting("Add account", "Add new GitHub Account") {
                    iicon = GoogleMaterial.Icon.gmd_add
                    onClick { _ ->
                        val newProfile = ProfileDrawerItem()
                                .withNameShown(true)
                                .withName("Batman")
                                .withEmail("batman@gmaill.com")
                                .withIcon(R.drawable.profile6)
                        headerResult.profiles?.let {
                            headerResult.addProfile(newProfile, it.size - 2)
                        }
                        false
                    }
                }
                profileSetting("Manage Account") { iicon = GoogleMaterial.Icon.gmd_settings }
            }

            primaryItem(R.string.drawer_item_home) { iicon = FontAwesome.Icon.faw_home }
            primaryItem(R.string.drawer_item_free_play) { iicon = FontAwesome.Icon.faw_gamepad }
            primaryItem(R.string.drawer_item_custom) { iicon = FontAwesome.Icon.faw_eye }
            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_settings) { iicon = FontAwesome.Icon.faw_cog }
            secondaryItem(R.string.drawer_item_help) { iicon = FontAwesome.Icon.faw_question }
            secondaryItem(R.string.drawer_item_open_source) { iicon = FontAwesome.Icon.faw_github }
            secondaryItem(R.string.drawer_item_contact) { iicon = FontAwesome.Icon.faw_bullhorn }
            divider()
            switchItem("Switch") {
                iicon = Octicons.Icon.oct_tools
                checked = true
                onToggled { state -> toast("Switch is now set to $state") }
            }
            toggleItem("Toggle") {
                iicon = Octicons.Icon.oct_tools
                checked = true
                onToggled { state -> toast("Toggle is now set to $state") }
            }
        }

        val miniResult = result.miniDrawer
        val firstWidth = UIUtils.convertDpToPixel(300f, this).toInt()
        val secondWidth = UIUtils.convertDpToPixel(72f, this).toInt()

        // Create and build our CrossFader
        crossFader = Crossfader<CrossFadeSlidingPaneLayout>()
                .withContent(findViewById(R.id.crossfade_content))
                .withFirst(result.slider, firstWidth)
                .withSecond(miniResult.build(this), secondWidth)
                .withSavedInstance(savedInstanceState)
                .build()

        // Define the CrossFader to be used with the miniDrawer. This is required to be able to automatically toggle
        // open / close.
        miniResult.withCrossFader(CrossfadeWrapper(crossFader))

        // Define a shadow (this is only for normal LTR layouts, if you have a RTL app you need to define the other one)
        crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed(); true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onSaveInstanceState(outState: Bundle?) {
        headerResult.saveInstanceState(outState)
        result.saveInstanceState(outState)
        resultAppended.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        when {
            crossFader.isCrossFaded() -> crossFader.crossFade()
            else -> super.onBackPressed()
        }
    }

}
