package com.example.myapp.datastructures

class List {


}
/*

Коллекции:
List ( Список) - это упорядоченная коллекция элементов одного типа. Могут встречаться дубликаты, можно обращаться по индексу.
Set (Множество) - это коллекция уникальных элементов. Нельзя встречать дубликаты. Порядок может быть любым.
Map (Словарь) - это коллекция пар ключ-значение. Ассоциативный список. Зная ключ можно обратиться к значению, ключи уникальны, а значения могут иметь дубликаты.

 Список является интефейсом.
 В списках сравнивается значение элемента, а не адрес ячейки в памяти.

 val listOfIngredients = listOf("flour", "eggs", "milk")
 создаёт незименяемый список. Но его можно читать, но нельзя изменять.

 val listOfIngredients2 = mutableListOf("flour", "eggs", "milk")
 создаёт изменяемый список.

У списка есть такие методы:
1. add() - добавить элемент в конец списка

listOfIngredients2.add("butter") - добавить элемент в конец списка

listOfIngredients2.add(0, "butter") - добавить элемент в начало списка
Если указать в скобочках 2 параметра, то элемент добавится в указанный индекс

2. addAll() - добавить несколько элементов в конец списка
3. clear() - очистить список
4. remove() - удалить элемент из списка

5.contains() - проверить наличие элемента в списке
6.indexOf() - получить индекс элемента, если элементов несколько, то вернёт первое, которое встречается
7).lastIndexOf() - получить индекс последнего встречающего элемента
8.isEmpty() - проверить пустой ли список
9.isNotEmpty() - проверить не пустой ли список
10. sort() - сортировать список
11. shuffle() - перемешать список
12. sortDescending() - сортировать список в обратном порядке
13. reversed() - получить список в обратном порядке
14. filter{} - фильтровать список, в фигурных скобках нужно задать условие. Функция не изменяет список.
15. map{} - применить функцию к каждому элементу списка. Используется для взаимодействия со всеми элементами. К примеру умножить все элементы на 2
или поменять общее свойство у всех элементов.
если используется интервал, то логичнее использовать цикл for
коллекция -> forEach
если нужно использовать break continue то лучше использовать for

  */
