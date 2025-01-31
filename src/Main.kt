/*
Ejercicio 4.4¶
Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. Crear el constructor del coche, así como el método toString().

Todas sus propiedades tendrán tipos de datos nulables.
Marca y modelo no podrán ser vacíos, ni nulos. Tampoco podrán modificarse y solo se inicializarán al crear el objeto.
Número de caballos, número de puertas y matrícula no podrán modificarse, ni podrán ser nulos.
Color podrá modificarse, pero no podrá ser nulo.
Recuerda que Kotlin añade los getters y setters con el comportamiento por defecto, por lo que no es necesario que los implementes, a no ser que tengas que añadir alguna funcionalidad extra.

El atributo matricula no debe permitir un valor que no tenga 7 caracteres.
Los atributos modelo y marca siempre se devolverán con la primera letra en mayúscula (getter).
El número de caballosdeberá tener un valor entre 70 y 700.
El número de puertasno podrá ser inferior a 3, ni superior a 5.
Ten en cuenta todas estas condiciones a la hora de crear el constructor de la clase.
En el programa principal, instancia varios coches, muéstralos por pantalla (toString) y realiza lo siguiente:

Intenta instanciar un coche con la marca y modelo con valores nulos o vacíos y comprueba que no es posible.
Intenta instanciar un coche con el número de caballos con un valor inferior a 70 o superior a 700 y comprueba que no es posible.
Intenta instanciar un coche con el número de puertas con un valor inferior a 3 o superior a 5 y comprueba que no es posible.
Intenta instanciar un coche con la matrícula con un valor que no tenga 7 caracteres y comprueba que no es posible.
Intenta instanciar y modificar el color a un valor nulo y comprueba que no es posible.
Todas estas pruebas debes hacerla capturando las excepciones que deben lanzarse desde la clase Coche cuando el valor de una propiedad no es correcto (según los requisitos del ejercicio)
 */

class Coche(color: String?, marca: String?, modelo: String?,
            private val cv: Int?, private val matricula: String?, private val nPuertas: Int?) {

    //El IDE me solicita que ponga el atributo color como privado, ya que no lo estoy llamando directamente.
    private var color: String? = color
        //En este set controlamos que lance una excepción solo en el caso en el que al ¡¡¡modificarse!!! sea nulo
        set(value) {
            if (value == null) throw IllegalArgumentException("El color no puede ser nulo")
            field = value
        }

    //En estos 2 setters se controla que la salida de marca y modelo sea 'Capitalize'
    private var marca: String? = marca
        get() = field?.lowercase()?.replaceFirstChar { it.uppercase() }

    private var modelo: String? = modelo
        get() = field?.lowercase()?.replaceFirstChar { it.uppercase() }


    //Restricciones aplicadas al crear un objeto con su correspondiente mensaje de error en caso de capturar excepciones
    init {
        require(!marca.isNullOrEmpty()) { "El campo 'marca' no puede ser nula ni vacía.\nMarca introducida: $marca" }
        require(!modelo.isNullOrEmpty()) { "El campo 'modelo' no puede ser nula ni vacía.\nMarca introducida: $modelo" }
        require(matricula?.length == 7) { "El campo 'matrícula' no puede contener una cantidad de caracteres diferente a 7.\nCaracteres introducidos: ${matricula?.length}" }
        require(cv in 70..700) { "El campo 'caballos de fuerza' debe de estar entre 70 y 700.\nCv introducidos: $cv" }
        require(nPuertas in 3..5) { "El campo 'numero de puertas' debe de estar entre 3 y 5.\nNumero de puertas introducido: $nPuertas" }
        require(color != null) { "El campo 'color' no puede ser nulo.\nColor introducido: $color" }
    }

    override fun toString(): String {
        return "|Coche| Color: $color, Marca: $marca, Modelo: $modelo, Número de caballos: $cv, Matrícula: $matricula, Número de puertas: $nPuertas"
    }
}

fun main() {
    try {
        //Instancia de Objetos
        val c1 = Coche(null, "nissan", "Juke", 150, "123456A", 5)

        val c2 = Coche("Negro", "", "Focus", 50, "000560C", 4)
        val c3 = Coche("Naranja", "Seat", "Toledo", 120, "000000W", 3)
        val c4 = Coche("Azul", "Volkswagen", "Golf", 150, "654321F", 20)
        val c5 = Coche("Verde", "Peugeot", "205d", 60, "440625N", 4)

        //Mostrar por pantalla
        println(c1.toString())
        println(c2.toString())
        println(c3.toString())
        println(c4.toString())
        println(c5.toString())

    } catch (e: Exception) {
        println(e.message)
    }
}
