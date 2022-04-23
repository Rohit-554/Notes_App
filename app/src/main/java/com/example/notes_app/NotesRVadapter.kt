package com.example.notes_app

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Delete
import org.w3c.dom.Text

class NotesRVadapter(private val context:Context, private val listener: MainActivity): RecyclerView.Adapter<NotesRVadapter.NoteViewHolder>() {

    val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val textView:TextView = itemView.findViewById(R.id.text)
        val deleteBtn: View? = itemView.findViewById(R.id.delete_btn)
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val ViewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        ViewHolder.deleteBtn?.setOnClickListener {
            listener.onItemClicked(allNotes[ViewHolder.adapterPosition])
        }
        return ViewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

}
interface INoteRVAdapter{
    fun onItemClicked(note:Note)
}