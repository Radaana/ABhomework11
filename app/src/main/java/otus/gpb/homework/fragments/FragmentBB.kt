package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentBB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonFragmentBB).setOnClickListener {
            val orientation =  resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                val activityB = requireActivity() as ActivityB
                parentFragmentManager.beginTransaction()
                    .hide(activityB.fragmentBB)
                    .show(activityB.fragmentBA)
                    .commit()
            }

            val result = Bundle()
            result.putInt("color", ColorGenerator.generateColor())
            parentFragmentManager.setFragmentResult("result", result)
        }
    }
}