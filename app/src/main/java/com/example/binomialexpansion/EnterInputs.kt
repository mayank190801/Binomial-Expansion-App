package com.example.binomialexpansion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_enter_inputs.*
import java.lang.Math.pow

class EnterInputs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_inputs)

        analyzeButton.setOnClickListener {

            var a = alphaEt.text.toString().toInt()
            var b = betaEt.text.toString().toInt()
            var n = gammaEt.text.toString().toInt()

            //now we have selected the variables
            //now we have to take this text and send it to the next phase
            //we have finally been able to get the binomial equation!!!!
            val intent = Intent(this, FinalSolution::class.java)
            intent.putExtra("FinalAnswer", series(a,b,n))
            startActivity(intent)
            finish()

        }
    }

    private fun factorial(n:Int):Int {
        var f = 1
        for (i in 2..n)
            f *= i
        return f
    }

    private fun series(A:Int, X:Int, n:Int):String {
        // calculating the value of n!
        var nFact = factorial(n)

        var stringFinal = ""
        // loop to display the series
        for (i in 0 until n + 1)
        {
            // For calculating the
            // value of nCr
            var niFact = factorial(n - i)
            var iFact = factorial(i)
            // calculating the value of
            // A to the power k and X to
            // the power k
            var aPow = pow(A.toDouble(), (n - i).toDouble()).toInt()
            var xPow = pow(X.toDouble(), i.toDouble()).toInt()
            // display the series

            var printBelow = (nFact * aPow * xPow) / (niFact * iFact)

            var justforNow = "${printBelow}"

            //from here onwards we start adding x and y with there powers in the equation
            //Let's do it

            var x = ""
            var y = ""

            if(i == 0){
                if(n == 1){
                    x = "x"
                }else {

                    x = "x^${n}"
                }
            }else if( i == n ){
                if(n == 1){
                    y = "y"
                }else {
                    y = "y^${n}"
                }
            }else{
                if(n-i == 1){
                    x = "x"
                }else {
                    x = "x^${n-i}"
                }
                if(i== 1){
                    y = "y"
                }else {
                    y = "y^${i}"
                }

            }

            if(justforNow == "1" || justforNow == "-1"){
                justforNow = x + y + " "
            }else {
                justforNow = justforNow + x + y + " "
            }

            if(justforNow.get(0) != '-'){
                if(i != 0) {
                    justforNow = "+ " + justforNow
                }
            }else{
                justforNow = "- " + justforNow.substring(1,justforNow.length)
            }

            stringFinal = stringFinal + justforNow

        }

        return stringFinal
    }
}