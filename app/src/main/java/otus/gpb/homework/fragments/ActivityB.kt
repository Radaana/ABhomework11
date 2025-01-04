package otus.gpb.homework.fragments

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ActivityB : AppCompatActivity() {
    var fragmentBA = FragmentBA()
    var fragmentBB = FragmentBB()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b)

        val transaction =
            supportFragmentManager.beginTransaction().replace(R.id.fragmentBA, fragmentBA)
                .replace(R.id.fragmentBB, fragmentBB)
        val orientation = resources.configuration.orientation

        Log.d("TAG", orientation.toString())
        Log.d("TAG", (orientation == ORIENTATION_PORTRAIT).toString())

        if (orientation == ORIENTATION_PORTRAIT) {
            transaction.hide(fragmentBB)
        }
        transaction.commit()
    }
}