package com.example.myapp.datastructures




class Array {
}

/*
Массивы- это упорядоченная коллекция объектов одного типа.
Имеет фиксированную длину, которая задается при создании и не может быть изменена.
 Только создавать новый массив через сохранение в переменную var.
 предыдущий массив будет уничтожен безвозвратно, ткт мы не пересоздаём массив, а изменяем данные ячеек памяти в уже созданном.


ВАЖНО. При сравнениюю сравниваются адреса ячеек в памяти.

создаётся с помощью обычной переменной.

val arrayOfIngredients = arrayOf("flour", "eggs", "milk")

инициализация массива происходит с помощью arrayOf(), в скобочках указываем значения одного типа -  содержимое массива.

для массива чисел можно использовать intArraOf(1, 2, 3)
А для символов - charArrayOf('a', 'b', 'c')
Они будут работать очень быстро, разница в нюансах подкпотной работы
Оптимизированы для примитивов.!


узнать размер массива можно через имя массива :
 имя массива.size

получить идекс элемента можно через имя массива:
имя массива.indexOf("имя_элемента")


Чтобы обратиться к элементу массива через индекс можно написать :
 имя_массива[индекс] в квадратных скобочках

По индексу можно поменять значение, обратившись к объекту по индексу.
 Имя_массива[индекс] = новое_значение

 обращаться ко всем значением массива можно перебором, через цикл for. Это может пригодиться для поиска, сортивки или других мометов

 for (item in имя_массива) {
     println(item)} получаем списрк значений c которыми мыпотом можем что-то сделать, например умножить все элементы на 2
  */