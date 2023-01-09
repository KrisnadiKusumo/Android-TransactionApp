package com.example.uasppbkrisnadi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MenuPorkActivity : AppCompatActivity() {
    private lateinit var progressBar : ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_pork)
        progressBar = findViewById(R.id.pb_menu_meal)
        recyclerView = findViewById(R.id.rv_menu_meal)
        val layoutManager = LinearLayoutManager(this)
        val itemDecoration = DividerItemDecoration(this,layoutManager.orientation)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(itemDecoration)
        getMenuMeal()
    }

    private fun getMenuMeal() {
        progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Pork"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                progressBar.visibility = View.GONE
                val result = String(responseBody!!)
                try {
                    val responseObject = JSONObject(result)
                    val menuMeals = responseObject.getJSONArray("meals")
                    menuAdapter = MenuAdapter(menuMeals)
                    recyclerView.adapter = menuAdapter
                } catch (e: Exception) {

                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                progressBar.visibility= View.GONE
                val errorMessage = when(statusCode){
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@MenuPorkActivity , errorMessage, Toast.LENGTH_LONG).show()
            }

        })
    }
}


