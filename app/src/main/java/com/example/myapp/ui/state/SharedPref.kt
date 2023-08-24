package com.example.myapp.ui.state

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.SharedPrefBinding

/*заводим глобальну. переменную для sharedPreferences */
const val APP_PREFERENCES = "APP_PREFERENCES"

/*ткт в sharedPreferences данные сохраняюся по параметрам ключ знаниче, заводим ключ */
const val KEY_NAME = "KEY_NAME"

/* сохранение данных с помощью SharedPreferences
под капотом она использует xml файл, в который данные и записываются.*/
class SharedPrefActivity : AppCompatActivity() {

    private lateinit var binding: SharedPrefBinding

    /* заводим переменную для sharedPreferences */
    private lateinit var preferences: SharedPreferences

    /*так же у sharedPreferences есть метод подписатсья на обновление переменной, который срабатывает кадлый раз,
     когда срабатывает аплай
      для этого нужно*/

    /*заводим переменную , подписываемся на изменение переменной
    * указываем нашу переменную sharedPreferences и делаем првоерку на ключ.
    * если пришёл нужный ключ, то сохраняем значение в нужном лоя нас места, указав ключ,
    * так же вторым значением можно передать значение по умолчанию */
    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { preferences, key ->
        if (key == KEY_NAME) {
            binding.textView.text = preferences.getString(KEY_NAME, "")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SharedPrefBinding.inflate(layoutInflater).also { setContentView(it.root) }
        /*прямо указывает что в переменной будет храниться sharedPreferences */
        preferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        /*через биндинг обращаемся к текстовому полю, получаем текст через сет текст.
        * затем обращаемся к нашей переменнойЮ указывает что
        *  мы хотим сохранить данные и записываем их с нужным нам ключем  вторым значением передаём значение по умолчанию*/

        val currentvalue = preferences.getString(KEY_NAME, "")
        binding.editText.setText(currentvalue)
        binding.textView.text = currentvalue
        /*через биндинг обращаемся к кнопке и сохраняем*/
        binding.btnSave.setOnClickListener {
            /* заводим переменную, указываем что её значение это текст из текстового поля */
            val value = binding.editText.text.toString()
            /* у нашего sharedPreferences вызываем метод edit, таким образом мы открываем транзакцию для редактирования
            *получаем доступ к editable внутри которого вызываем метод put с выбором типа данныхдля сохранения */
            preferences.edit()
                /* в качестве параметров указываем ключ и имя переменной*/
                .putString(KEY_NAME, value)
                /* и завершаем транзакцию через аплай */
                .apply()
        }
        /*подписываемся на обновление переменной */
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }


}