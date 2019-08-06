package androidviakotlin.livedatainmainactivity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val counter = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        counter.value = 0

        // Add +1 when the button is clicked
        incrementButton.setOnClickListener {
            counter.value = counter.value!! +1
        }

        // Set up of the Observer to know when the value of the counter has changed
        counter.observe(this, Observer { newValue ->
            Log.i("MainActivityValue", "New Value is : $newValue")

            //  It changes the TextView with the newValue
            incrementTextView.text = "$newValue"
        })
    }
}
