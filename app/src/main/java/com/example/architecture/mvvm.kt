package com.example.architecture

class mvvm {
}

/*
разбор архитерного патерна model view viewmodel

суть архитектуры разбить приложение на несколько словё, со своей задачей. Кадлый слой знает только о следующем слое.

как пример:
view - экран, который видит пользователь и нажмает кнопку
viewmodel - слой, который не знает о view, но знает o business logic, можно использовать usecase
model:
 - business logic- слой, который не знает о viewmodel, но знает об источнике данных.
 - repository - источник данных - слой, с данными, либо database либо remote  api, только предоставляет данные, не знает о слоях выше ничего
главные принципы:

1) центральные слои, viewmodel и бизнес логика не должны содержать андроид зависимостей вообще.
никаких view, активити, контекстов, прямых сетевых запросов и sql запросов.
Это позволит лучше написать тесты либо заменить логику программы.

2) слой view лучше сделать максимально простым, насколько это позволяет логика приложения.
В идеале наши активити и фрагменты должно только выводить пользователю картинку, передавать данные во viewmodel
и слушать изменения во viewmodel


Жизненный цикл viewmodel это 3 стадии
1) Create
onCreate onStart onResume
2)Rotated
onPause onStop onDestroy onCreate onStart onResume
3)finish
onPause onStop onDestroy
viewmodel не знает о view, но знает о business logic.
 Для передачи данных в обе стороны используют переменные поля специального типа LiveData. Фрагменты подписываются на них и слушают изменения.
 КОгда подписчик подписывается, то он получает текущее значение, а так же все последующие изменения.
 При каждом изменении списка LiveData оповестит всех подписчиков
ViewModel выживает при смене конфигурации устройства, то данные никуда не пропадут, подписчики учитываю ЖЦ.
 если фрагмент свернут\уничтожен, то произойдёт автоматическая отписка. И так же если фрагмент будет создан, то автоматическая подписка

чтобы подписаться на LiveData, нужно использовать метод observe
сперва обратитсья к viewmodel, а затем к LiveData

так же если в нашей viewmodel есть параметры в конструкторе, то нужно создать фабрику viewmodel.
Задача фабрики создавать viewmodel.
 */