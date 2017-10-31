package co.zsmb.materialdrawerktexample.newactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.profile.profile
import co.zsmb.materialdrawerkt.draweritems.profile.profileSetting
import co.zsmb.materialdrawerktexample.R
import co.zsmb.materialdrawerktexample.utils.toast
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.octicons_typeface_library.Octicons
import kotlinx.android.synthetic.main.activity_sample.*

class AccountHeaderActivity : AppCompatActivity() {

    private lateinit var result: Drawer
    private lateinit var headerResult: AccountHeader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            savedInstance = savedInstanceState
            toolbar = this@AccountHeaderActivity.toolbar
            closeOnClick = false

            headerResult = accountHeader {
                savedInstance = savedInstanceState
                background = R.drawable.header

                currentHidden = true
                heightDp = 300
                selectionSecondLine = "This is not an email!"
                threeSmallProfileImages = true

                profile("Profile 1", "user1@gmail.com") {
                    iconUrl = "http://i.pravatar.cc/300?img=1"
                    nameShown = true
                    textColor = 0xFFFF0000
                }
                profile("Profile 2", "user2@gmail.com") {
                    iconUrl = "http://i.pravatar.cc/300?img=2"
                    nameShown = true
                    textColor = 0xFFFF0000
                }
                profile("Profile 3", "user3@gmail.com") {
                    iconUrl = "http://i.pravatar.cc/300?img=3"
                    nameShown = true
                    textColor = 0xFFFF0000
                }
                profile("Profile 4", "user4@gmail.com") {
                    iconUrl = "http://i.pravatar.cc/300?img=4"
                    nameShown = true
                }
                profile("Profile 5", "user5@gmail.com") {
                    iconUrl = "http://i.pravatar.cc/300?img=5"
                    nameShown = true
                }
                profile("Profile 6", "user6@gmail.com") {
                    iconUrl = "http://i.pravatar.cc/300?img=6"
                    nameShown = true
                }
                profileSetting("Settings 1") {
                    iicon = MaterialDesignIconic.Icon.gmi_network_setting
                    iconColor = 0xFF00FF66
                }
                profileSetting("Settings 2") {
                    iicon = MaterialDesignIconic.Icon.gmi_power_setting
                    textColorRes = R.color.colorPrimary
                }

                onProfileChanged { _, profile, _ ->
                    toast("Selected ${profile.name}")
                    false
                }
                onProfileImageLongClick { _, profile, _ ->
                    toast("Long clicked ${profile.name}")
                    true
                }
            }

            for (i in 1..10) {
                primaryItem("Item $i") { iicon = Octicons.Icon.oct_ruby }
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
        headerResult.saveInstanceState(outState)
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
