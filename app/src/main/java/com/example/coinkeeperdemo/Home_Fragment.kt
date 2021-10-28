package com.example.coinkeeperdemo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import com.example.coinkeeperdemo.databinding.FragmentHomeBinding

lateinit var binding: FragmentHomeBinding
class Home_Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switch: Switch = binding.switch2
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                switch.setText(R.string.switch_add)
                getActivity()?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_Holder, Add_fragment.newInstance())?.commit()
            }
            else{
                switch.setText(R.string.switch_expenses)
                getActivity()?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_Holder, Expenses_Fragment.newInstance())?.commit()
            }
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View?
    {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        fun newInstance() = Home_Fragment()
    }
}