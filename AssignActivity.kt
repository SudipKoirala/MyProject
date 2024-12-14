package com.example.formexample

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFullName: EditText = findViewById(R.id.etFullName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val spCountry: Spinner = findViewById(R.id.spCountry)
        val actvCity: AutoCompleteTextView = findViewById(R.id.actvCity)
        val cbTerms: CheckBox = findViewById(R.id.cbTerms)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val tvWarning: TextView = findViewById(R.id.tvWarning)

        // Populate Country Dropdown
        val countries = arrayOf("Nepal", "India", "USA", "Canada", "UK")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)
        spCountry.adapter = countryAdapter

        // Populate Autocomplete City
        val cities = arrayOf("Kathmandu", "Pokhara", "Delhi", "New York", "Toronto")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        actvCity.setAdapter(cityAdapter)

        // Submit Button Listener
        btnSubmit.setOnClickListener {
            if (!cbTerms.isChecked) {
                tvWarning.visibility = View.VISIBLE
            } else {
                tvWarning.visibility = View.GONE
                val fullName = etFullName.text.toString()
                val email = etEmail.text.toString()
                val gender = if (rgGender.checkedRadioButtonId == R.id.rbMale) "Male" else "Female"
                val country = spCountry.selectedItem.toString()
                val city = actvCity.text.toString()

                // Display the user details (next screen simulation)
                Toast.makeText(
                    this,
                    "Welcome $fullName\nEmail: $email\nGender: $gender\nCountry: $country\nCity: $city",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
