import java.util.Date
import java.time.Instant.now
import java.time.LocalDate.now
import java.time.LocalDateTime

class NuevoMovimiento {

    val mostramelo = Mostrarmenu()
    fun newMovimiento (id: Int, Vmonto: Int, Vfecha: LocalDateTime){

        val newmovimiento = MovimientosCuenta(id, Vmonto, Vfecha)
        println("Movimiento Ingresado satisfactoriamente $id-$Vmonto-$Vfecha")

    }
}
