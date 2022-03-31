package com.than.recyclerproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.than.recyclerproject.databinding.MyContactItemBinding


class ContactAdapter(private val listContact: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    //diff
        private val diffCallBack = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.id == oldItem.id
            }

            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

        }

    private val differ = AsyncListDiffer(this, diffCallBack)
    fun submitData(value: ArrayList<Contact>) = differ.submitList(value)
    //end diff

    class ViewHolder(val itemBinding: MyContactItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MyContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]

        holder.itemBinding.tvNama.text = data.nama
        holder.itemBinding.tvNomor.text = data.noHp
        holder.itemBinding.tvId.text = data.id.toString()
//        holder.itemBinding.apply {
//            tvNama.text = listContact[position].nama
//            ivGambar.setImageResource(listContact[position].noHp)
//        }
//
//        holder.itemBinding.cvMain.setOnClickListener{ view ->
//            Snackbar.make(view,"Clicked element ${listContact[position].nama}", Snackbar.LENGTH_LONG).show()
//        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}

// DiffUtil
//    private val diffCallBack = object : DiffUtil.ItemCallback<Contact>() {
//        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
//            return oldItem.nama == oldItem.nama
//        }
//
//        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
//            return oldItem.hashCode() == newItem.hashCode()
//        }
//
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallBack)
//    fun submitData(value: ArrayList<Contact>) = differ.submitList(value)

//binding
//override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//    val view = MyContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//    return ViewHolder(view)
//}
//
//class ViewHolder(private val itemBinding: MyContactItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
//    fun bind(contact: Contact){
//        itemBinding.tvNama.text = contact.nama
//        itemBinding.tvNomor.text = contact.noHp
//    }
//}
//
//override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//    val contact: Contact = listContact[position]
//    holder.bind(contact)
//}
//
//override fun getItemCount(): Int {
//    return listContact.size
//}

//tidak binding
//class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    val nama: TextView = itemView.findViewById(R.id.tvNama)
//    val nomor: TextView = itemView.findViewById(R.id.tvNomor)
//}
//override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//    val view = LayoutInflater.from(parent.context).inflate(R.layout.my_contact_item, parent, false)
//    return ViewHolder(view)
//}
//
//override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//    holder.nama.text = listContact[position].nama
//    holder.nomor.text = listContact[position].noHp
//}
//
//override fun getItemCount(): Int = listContact.size