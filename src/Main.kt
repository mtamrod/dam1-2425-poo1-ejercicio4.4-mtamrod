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
El número de caballos deberá tener un valor entre 70 y 700.
El número de puertas no podrá ser inferior a 3, ni superior a 5.
Ten en cuenta todas estas condiciones a la hora de crear el constructor de la clase.
En el programa principal, instancia varios coches, muéstralos por pantalla (toString) y realiza lo siguiente:

Intenta instanciar un coche con la marca y modelo con valores nulos o vacíos y comprueba que no es posible.
Intenta instanciar un coche con el número de caballos con un valor inferior a 70 o superior a 700 y comprueba que no es posible.
Intenta instanciar un coche con el número de puertas con un valor inferior a 3 o superior a 5 y comprueba que no es posible.
Intenta instanciar un coche con la matrícula con un valor que no tenga 7 caracteres y comprueba que no es posible.
Intenta instanciar y modificar el color a un valor nulo y comprueba que no es posible.
Todas estas pruebas debes hacerla capturando las excepciones que deben lanzarse desde la clase Coche cuando el valor de una propiedad no es correcto (según los resuisitos del ejercicio)
 */


//TODO: Cambiar la actividad a la corregida por Diego (Revisar correo)

class Coche(var color: String, marca: String, modelo: String, cv: Int, matricula: String, nPuertas: Int) {
    private val marca: String = marca
        get() =  field.lowercase().replaceFirstChar { it.uppercase() }

    private val modelo: String = modelo
        get() = field.lowercase().replaceFirstChar { it.uppercase() }

    var cv: Int = 70
        set(value) {
            require(cv in 70..700)
            field = value
        }

    var matricula: String = "000000A"
        set(value) {
            require(matricula.length == 7)
            field = value
        }

    var nPuertas: Int = 3
        set(value) {
            require(nPuertas in 3..5)
            field = value
        }

    init {
        require(this.marca.isNotEmpty())
        require(this.modelo.isNotEmpty())
    }
}

fun main() {
    val c1 = Coche("Blanco", "Nissan", "Juke", 150, "123456A", 5)
    val c3 = Coche("Negro", "Ford", "Focus", 50, "000560C", 2)
    val c4 = Coche("Naranja", "Seat", "Toledo", 120, "000", 5)
    val c5 = Coche("Azul", "Volkswagen", "Golf", 150, "654321F", 20)

    println(c1)
}