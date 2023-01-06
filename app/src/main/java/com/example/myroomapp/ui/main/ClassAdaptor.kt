package com.example.myroomapp.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myroomapp.R
import com.example.myroomapp.database.ClassList
import com.squareup.picasso.Picasso

class ClassAdaptor(private val context: Context, private val classList:List<ClassList>,
    private val listener: (ClassList)->Unit)
    :RecyclerView.Adapter<ClassAdaptor.ViewHolderClass>(){

        class ViewHolderClass(view: View): RecyclerView.ViewHolder(view){
            private val name = view.findViewById<TextView>(R.id.name)
            private val nim = view.findViewById<TextView>(R.id.nim)
            private val image = view.findViewById<ImageView>(R.id.image)

            fun bindClass(classList: ClassList, listener:(ClassList)->Unit){
                name.text = classList.name
                nim.text = classList.nim
                classList.image?.let{
                    Picasso.get().load(it).fit().into(image)
                }

                itemView.setOnClickListener {
                    listener(classList)
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderClass(LayoutInflater.from(context).inflate(R.layout.card_mahasiswa,parent,false))

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        holder.bindClass(classList[position], listener)
    }

    override fun getItemCount(): Int = classList.size
}