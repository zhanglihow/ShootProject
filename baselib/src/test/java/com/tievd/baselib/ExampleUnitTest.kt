package com.tievd.baselib

import com.tievd.baselib.utils.UtilsBigDecimal
import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.math.ceil

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test1() {
        val a = 1.2
        val c = 25
        val b = UtilsBigDecimal.mul(a.toDouble(), c.toDouble())
        print(b)
    }


    @Test
    fun testStr1() {
        val str = ".9" +
                "\n" +
                "09"
        println(str)
        val s = replaceBlank(str)
        println(s)
    }

    fun replaceBlank(str: String): String {
        var dest = ""
        val p: Pattern = Pattern.compile("\\s*|\t|\r|\n")
        val m: Matcher = p.matcher(str)
        dest = m.replaceAll("")
        return dest
    }

    @Test
    fun testMath() {
        val a = 16.0
        val allPage = ceil(a / 5).toInt()
        println(allPage)
    }
}