package com.dakusuno.zawarudo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //        set the custom toolbar and configure it with nav host fragment
        val nav = findNavController()
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.loginFragment,
            R.id.registerFragment).build()
        toolbar.setupWithNavController(nav,appBarConfiguration)
//        inflate custom extra menu to the toolbar
        toolbar.inflateMenu(R.menu.menu_love)


        toolbar.setOnMenuItemClickListener {
            when(it.itemId)
            {
                R.id.item_android -> {
                    Toast.makeText(activity,"android", Toast.LENGTH_LONG).show()
                    true
                }
                R.id.item_bug ->{
                    Toast.makeText(activity,"android", Toast.LENGTH_LONG).show()
                    true
                }
                else -> {super.onOptionsItemSelected(it)}
            }
        }
         bottom_nav.setupWithNavController(nav)

        super.onViewCreated(view, savedInstanceState)
////        navigate to fragment register and passing data "halo"
//        val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment("halo")
//        to_main_menu.setOnClickListener {
//            findNavController().navigate(action)
//        }

//        navigate to main_menu_graph
        to_main_menu2.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_main_menu_graph)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
