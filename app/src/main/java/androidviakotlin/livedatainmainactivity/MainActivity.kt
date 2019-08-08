package androidviakotlin.livedatainmainactivity

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        // Créer la variable qui sera observée (MutableLiveData<>)
        // Creation in the Scope of the val "compteur" which is a MutableLivaData<Int>
    private val compteur = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Donner une première valeur a cette variable lors du passage dans le onCreate
        compteur.value = 0

        // Mettre un OnClickListener sur le Bouton
        // Incrémenter la variable observée de 1 à chaque clic
        // Add +1 when the button is clicked
        plusOneButton.setOnClickListener {
            compteur.value = compteur.value!! +1
        }

        // Observer cette variable dont la valeur a changé
        // Lors du changement, nous allons agir en conséquence et modifier l’UI pour afficher
        // la nouvelle valeur dans le textView
        // Set up of the Observer to know when the value of the compteur has changed
        compteur.observe(this, Observer { newValue ->
            Log.i("MainActivityValue", "New Value is : $newValue")

            // Remplace l'ancienne valeur par la nouvelle valeur dans l'UI textView: resultTextView
            //  It replaces the resultTextView value with the newValue
            resultTextView.text = "$newValue"
        })
    }
}
