package androidviakotlin.livedatainmainactivity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val compteur = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        compteur.value = 0

        // Add +1 when the button is clicked
        plusOneButton.setOnClickListener {
            compteur.value = compteur.value!! +1
        }

        // Set up of the Observer to know when the value of the compteur has changed
        compteur.observe(this, Observer { newValue ->
            Log.i("MainActivityValue", "New Value is : $newValue")

            //  It changes the TextView with the newValue
            resultTextView.text = "$newValue"
        })
    }
}
