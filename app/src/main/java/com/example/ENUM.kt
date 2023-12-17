package com.example


/* ENUM- класс для перечисления
полезен там где сущность может принимать одно из заранее известных значений
к примеру возможный тип цвета, дни недели, статусы
преимущество в Enum-е - ограничивать возможные состояние приложения
Так же ЕНАМ может содержать в себе методы. Для этого нужно поставить ; после перечисления

так же важно, типы возвращаемые в функциях
1) Unit- ничего не возвращает
2)Nothing- ничего не возвращает и говорит компилятору что функция гарантировано не выполнится успешно
 */

fun main() {

    // сервер отправляет статусы в виде чисел
    val statusesFromServer = listOf(101, 102, 103)

    for (i in statusesFromServer) {
        when (i) {
            Status.NEW.id-> setStatus(Status.NEW)
            Status.COOKING.id -> setStatus(Status.COOKING)
            Status.COMPLETED.id  -> setStatus(Status.COMPLETED)
            Status.ERROR.id  -> setStatus(Status.ERROR)
        }
            Thread.sleep(1000)


        }
    }


        enum class Status(val id: Int) {
            NEW(101) {
                override fun getStatusDescription(): String {
                    return "Заказ создан"
                }
            },
            COOKING(102) {
                override fun getStatusDescription(): String {
                    return "Готовится"
                }
            },
            COMPLETED(103) {
                override fun getStatusDescription(): String {
                    return "Заказ приготовлен и готов к выдаче"
                }
            },
            ERROR(0) {
                override fun getStatusDescription(): String {
                    return "Неопознанный статус"
                }
            };

            abstract fun getStatusDescription(): String
        }

        fun setStatus(status: Status) {
            when (status) {
                Status.NEW -> println("Новый")
                Status.COOKING -> println("Готовится")
                Status.COMPLETED -> println("Готово")
                Status.ERROR -> println("Неопознанный статус")
            }
        }

