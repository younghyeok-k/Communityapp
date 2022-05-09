package com.example.communityapp
//startday03-03
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.communityapp.auth.LoginActivity
import com.example.communityapp.utills.FBauth
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val drawer_navi = findViewById<DrawerLayout>(R.id.layout_drawer)
        val menu_navi = findViewById<ImageView>(R.id.menu_navi)
        val naviview = findViewById<NavigationView>(R.id.naviview)
        val logout = findViewById<TextView>(R.id.logout)
        val nav_header_view=naviview.getHeaderView(0)
        val close =nav_header_view.findViewById<ImageView>(R.id.close)
        auth = Firebase.auth
        val username=nav_header_view.findViewById<TextView>(R.id.username_header)

//이메일 가져오기
        username.setText(FBauth.getemail())
        Log.d("email:",auth.currentUser?.email.toString())

        menu_navi.setOnClickListener {
            drawer_navi.openDrawer(GravityCompat.START)
        }

        naviview.setNavigationItemSelectedListener(this)
        logout.setOnClickListener {
            Toast.makeText(this, "로그아웃", Toast.LENGTH_SHORT).show()

            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        close.setOnClickListener{
            onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {


        }
        val drawer_navi = findViewById<DrawerLayout>(R.id.layout_drawer)
        drawer_navi.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        val drawer_navi = findViewById<DrawerLayout>(R.id.layout_drawer)
        if (drawer_navi.isDrawerOpen(GravityCompat.START)) {
            drawer_navi.closeDrawers()
        } else {
            super.onBackPressed() //일반 백버튼 기능 실행
        }

    }
}