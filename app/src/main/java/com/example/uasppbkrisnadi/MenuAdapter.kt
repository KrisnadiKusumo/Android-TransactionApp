package com.example.uasppbkrisnadi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import com.bumptech.glide.Glide

class MenuAdapter(private val menuMeal: JSONArray)
     : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.menu_meal,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = menuMeal.getJSONObject(position)
        val strMeal = meal.getString("strMeal")
        val strMealThumb = meal.getString("strMealThumb")
        holder.bind(strMeal, strMealThumb )
    }

    override fun getItemCount(): Int {
        return menuMeal.length()
    }

    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val tvMeal = view.findViewById<TextView>(R.id.tv_meal)
        val imMealThumb = view.findViewById<ImageView>(R.id.im_meal_thumb)
        fun bind(strMeal: String, strMealThumb: String){
            tvMeal.text = strMeal
            Glide.with(imMealThumb.context).load(strMealThumb).into(imMealThumb)
        }
    }
}