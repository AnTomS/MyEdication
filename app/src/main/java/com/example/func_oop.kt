package com.example

fun main() {
    abstract class Weapon {
        open fun attack() {
            println("attack")
        }

        fun shoot() {
            println("shoot")
        }

        fun reload() {
            println("reload")
        }

        abstract fun aim()
    }

    class MachineGun : Weapon() {

         override fun attack() {
             println("бах бах бах бах бах бах")
            super.attack()
        }
        override fun aim() {
            println("бах")
        }
    }

    val weapon = MachineGun()
    weapon.attack()
    weapon.shoot()
    weapon.reload()
    weapon.aim()

}

/* Чтобы натренировать себе мышление инженера- разработчика, котоырй использует ООП, нужно:

1) выделить сущности, которые будут использоваться как основа приложения.
2)определить их свойства
3)наделить сущность действиями.
пример, представим, что мы проектируем приложение с рецептами блюд
создаёшь сущность,в данном случае это блюдо
class Dish (
val name : String,
val description : String,
val ingredients : List<String>,
val id : Int,
) {

}
создаём экземпляр класса
val dish1 = Dish(
name = "Яичница",
description = "Очень вкусная яичница",
ingredients = listOf("яйцо", "молоко", "соль"),
id = 1
)
println(dish1.name)
*/




