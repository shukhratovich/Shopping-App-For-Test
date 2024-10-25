package uz.gita.shoppingappwithgithub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.gita.shoppingappwithgithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        binding.bottomNavigationView.setupWithNavController(navController)
//
//        binding.bottomNavigationView.let { bottomNav ->
//            navController.addOnDestinationChangedListener { _, destination, _ ->
//                when (destination.id) {
//                    R.id.main, R.id.basket, R.id.favorite -> bottomNav.visibility =
//                        View.VISIBLE
//
//                    else -> bottomNav.visibility = View.GONE
//                }
//            }
//        }
    }
}