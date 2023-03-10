package ies.luiscarrillodesotomayor.gestionincidencias.CuadroDialogo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.os.Process
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import ies.luiscarrillodesotomayor.gestionincidencias.Datos.DatosIncidencias
import ies.luiscarrillodesotomayor.gestionincidencias.Datos.Incidencia
import ies.luiscarrillodesotomayor.gestionincidencias.MainActivity
import ies.luiscarrillodesotomayor.gestionincidencias.Menu.ModificarIncidencia
import ies.luiscarrillodesotomayor.gestionincidencias.R
import ies.luiscarrillodesotomayor.gestionincidencias.adapter.ViewHolder
import ies.luiscarrillodesotomayor.gestionincidencias.adapter.adapter

class CuadroDialogo: DialogFragment() {
/*
    fun DialogoModificarBorrar(datosIncidencias: DatosIncidencias,holder: ViewHolder): Boolean {
        var respuesta = false
        val builder = AlertDialog.Builder(holder.itemView.context)
        builder.setTitle("¿Que Desea Hacer?")
        builder.setMessage(datosIncidencias.ID + " - " + datosIncidencias.nombre)

        builder.setPositiveButton("Modificar") { dialog, which ->
            // Do something when user press the positive button

            // Modificar incidencia

            CargarModificarFragment(datosIncidencias, holder)

            respuesta = true
            return@setPositiveButton
        }

        builder.setNegativeButton("Borrar") { dialog, which ->
            // Do something when user press the negative button
            respuesta = false
            DialogoBorrarIncidencias(datosIncidencias, holder)
            return@setNegativeButton
        }

        // Create the dialog
        val dialog = builder.create()

        // Show the dialog
        dialog.show()

        return respuesta
    }
    // Funcion para mostrar un dialogo de confirmacion de borrado de la incidencia
    fun DialogoBorrarIncidencias(datosIncidencias: DatosIncidencias, holder: ViewHolder, incidencias: ArrayList<DatosIncidencias>): Boolean {
        var respuesta = false
        val builder = AlertDialog.Builder(holder.itemView.context)
        builder.setTitle("¿Desea borrar la incidencia?")
        builder.setMessage(datosIncidencias.ID + " - " + datosIncidencias.nombre)

        builder.setPositiveButton("Confirmar") { dialog, which ->
            // Do something when user press the positive button
            respuesta = true
            Incidencia(
                datosIncidencias.nombre,
                datosIncidencias.fecha,
                datosIncidencias.descripcion,
                datosIncidencias.acabada,
                datosIncidencias.foto,
                datosIncidencias.prioridad,
                datosIncidencias.ID
            ).BorrarIncidencia(datosIncidencias.ID)

            val position = incidencias.indexOf(datosIncidencias)
            incidencias.removeAt(position)
            /*
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, incidencias.size)
            notifyDataSetChanged()*/

            Log.d("Borrar Incidencia", "Incidencia borrada correctamente")


            return@setPositiveButton
        }

        builder.setNegativeButton("Cancelar") { dialog, which ->
            // Do something when user press the negative button
            respuesta = false
            Log.d("Borrar Incidencia", "incidencia no borrada")
            return@setNegativeButton
        }

        // Create the dialog
        val dialog = builder.create()

        // Show the dialog
        dialog.show()

        return respuesta
    }

    fun CargarModificarFragment(datosIncidencias: DatosIncidencias, holder: ViewHolder) {

        // Llevar al de modificar incidencia
        val fragment = ModificarIncidencia()
        val args  = Bundle()
        args.putString("ID", datosIncidencias.ID)
        args.putString("nombre", datosIncidencias.nombre)
        args.putString("fecha", datosIncidencias.fecha)
        args.putString("descripcion", datosIncidencias.descripcion)
        args.putString("prioridad", datosIncidencias.prioridad)
        args.putBoolean("acabada", datosIncidencias.acabada)

        fragment.arguments = args

        val fragmentManager: FragmentManager = (holder.itemView.context as MainActivity).supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment).commit()



    }

*/
}


