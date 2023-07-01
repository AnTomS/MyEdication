package com.example.myapp.ui.state


import android.graphics.Color
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapp.R
import com.example.myapp.databinding.TestStateBinding
import java.io.Serializable
import kotlin.random.Random

/* изучение сохранения состояния через saveInstanceState */
class StateActivity : AppCompatActivity() {

    private lateinit var binding: TestStateBinding
    private lateinit var state: State


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestStateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.incrementButton.setOnClickListener { increment() }

        binding.randomColorbtn.setOnClickListener { setRandomColor() }

        binding.VisibilityBtn.setOnClickListener { switchVisibility() }


        if (savedInstanceState == null) {
            State(
                counterValue = 0,
                counterTextColor = ContextCompat.getColor(this, R.color.amber_700),
                counterTextVisible = true
            )
        } else {
            @Suppress("DEPRECATION")
            savedInstanceState.getSerializable(KEY_STATE) as State
        }
        renderState()

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_STATE, state)
    }

    private fun increment() {
        state.counterValue++
        renderState()
    }

    private fun setRandomColor() {
        state.counterTextColor = Color.rgb(
            Random.nextInt(255), Random.nextInt(255), Random.nextInt(255)
        )
        renderState()
    }

    private fun switchVisibility() {
        state.counterTextVisible = !state.counterTextVisible
        renderState()
    }

    private fun renderState() = with(binding) {
        counterTextView.text = state.counterValue.toString()
        counterTextView.setTextColor(state.counterTextColor)
        counterTextView.visibility = if (state.counterTextVisible) VISIBLE else INVISIBLE
    }

    class State(
        var counterValue: Int,
        var counterTextColor: Int,
        var counterTextVisible: Boolean
    ) : Serializable

    companion object {
        private const val KEY_STATE = "STATE"
    }

}