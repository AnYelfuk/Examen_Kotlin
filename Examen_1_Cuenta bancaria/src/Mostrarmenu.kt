import java.math.BigDecimal
import kotlin.system.exitProcess
import java.time.LocalDateTime
import kotlin.test.assertTrue
import kotlin.test.*
import java.util.Scanner;

class Mostrarmenu
{
    fun showmenu(){
        val operar = NuevoMovimiento()
        val movimiento1 = MovimientosCuenta(1,10000, LocalDateTime.now())
        val movimiento2 = MovimientosCuenta(2,20000, LocalDateTime.now())
        val movimiento3 = MovimientosCuenta(3,30000, LocalDateTime.now())
        val movimiento4 = MovimientosCuenta(4,40000, LocalDateTime.now())
        val movimiento5 = MovimientosCuenta(5,50000, LocalDateTime.now())
        val movimiento6 = MovimientosCuenta(6,65000000, LocalDateTime.now())
        val movimiento7 = MovimientosCuenta(7,70000000, LocalDateTime.now())
        val movimiento8 = MovimientosCuenta(8,-8000000, LocalDateTime.now())
        val movimiento9 = MovimientosCuenta(9,-50000, LocalDateTime.now())
        val movimiento10 = MovimientosCuenta(10,-65000000, LocalDateTime.now())
        val movimiento11 = MovimientosCuenta(11,-70000000, LocalDateTime.now())
        val movimiento12 = MovimientosCuenta(12,-8000000, LocalDateTime.now())


        val listaMovimientos = mutableListOf<MovimientosCuenta>()
        listaMovimientos.add(movimiento1)
        listaMovimientos.add(movimiento2)
        listaMovimientos.add(movimiento3)
        listaMovimientos.add(movimiento4)
        listaMovimientos.add(movimiento5)
        listaMovimientos.add(movimiento6)
        listaMovimientos.add(movimiento7)
        listaMovimientos.add(movimiento8)
        listaMovimientos.add(movimiento9)
        listaMovimientos.add(movimiento10)
        listaMovimientos.add(movimiento11)
        listaMovimientos.add(movimiento12)

        println("<-------------------------------------->")
        println("<---------------  Movimientos Transaccionales  ----------------->")
        println("1) AGREGAR UN NUEVO MOVIMIENTO.")
        println("2) MOSTRAR EL MOVIMIENTO MAS ALTO EN MAGNITUD DEL ULTIMO AÑO.")
        println("3) MOSTRAR LOS ULTIMOS TRES MOVIMIENTOS.")
        println("4) MOSTRAR PROMEDIO DE TRANSACCIONES POSITIVAS Y NEGATIVAS")
        println("5) MOVIMIENTOS MAYORES A $500'000")
        println("<-- 6) Salir de la Aplicacion")
        val opcion = readLine()!!.toString()

        if (opcion == "1"){

            println("Debe ingresar los siguientes datos: ")
            println("->Id:")
            val id: Int = readLine()!!.toInt()
            println("->Monto: \n")
            val Vmonto = readLine()!!.toInt()
            val Vfecha = LocalDateTime.now()

                operar.newMovimiento(id, Vmonto, Vfecha)
                println("Avanzar --->")
                readLine()
                showmenu()

        }else if (opcion == "2"){
            println("movimiento mas alto en el ultimo año: \n")

            val idToMontoMap = listaMovimientos.associateBy({ it.id}, { it.monto})
            val maxMonto = idToMontoMap.maxBy { it.value }
            println(maxMonto)

            println("Avanzar --->")
            readLine()
            showmenu()
        }else if (opcion == "3"){
            println("ultimos tres movimientos: \n")

            val mapitaMovimiento = listaMovimientos.associateBy({ it.id}, { it.monto})
            val indexMovimiento = mapitaMovimiento.size
            val rangoindez = indexMovimiento - 2
            val rangoIndex = mapitaMovimiento.filter { it.key >= rangoindez }
            println(rangoIndex)

            println("Avanzar --->")
            readLine()
            showmenu()
        }else if (opcion == "4"){
            println("Promedio de transacciones: \n")

            val idToMontoMap = listaMovimientos.associateBy({ it.id}, { it.monto})
            val montoPositivo = idToMontoMap.filter { it.value >= 1 }
            val montoNegativo = idToMontoMap.filter { it.value <= -1 }
            /*val keyPositivo = ArrayList(montoPositivo.keys)*/
            val valPositivo = ArrayList(montoPositivo.values)
            /*val keyNegativo = ArrayList(montoNegativo.keys)*/
            val valNegativo = ArrayList(montoNegativo.values)
            println(valPositivo)
            println(valNegativo)
            println("Calcular!")
            readLine()
            val sumaPositivos = valPositivo.sum()
            val sumaNegativo = valNegativo.sum()
            val cantPositivo = valPositivo.size
            val cantNegativo = valNegativo.size
            println("promedio de Movimientos +: ${sumaPositivos / cantPositivo}")
            println("promedio de Movimientos -: ${sumaNegativo / cantNegativo}")

            println("Avanzar --->")
            readLine()
            showmenu()
        }else if (opcion == "5"){
            println("lista de transacciones mayores a $500'000: \n")

            val idToMontoMap = listaMovimientos.associateBy({ it.id}, { it.monto})
            val mayorQueMonto = idToMontoMap.filter { it.value >= 500000 }
            println(mayorQueMonto)

            println("Avanzar --->")
            readLine()
            showmenu()
        }else if (opcion == "6") {
            println("hasta pronto")
            exitProcess(1)
        }else if (opcion == ""){
            println("No ingresaste nada")
            readLine()
            showmenu()
        }else{
            println("La Opcion no es Valida")
            readLine()
            showmenu()

        }

    }

}