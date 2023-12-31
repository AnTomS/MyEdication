package com.example.myapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R

class LifeCycleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*
    В методе onCreate() активити создана, но пока не видна вообще. [инициализация интерфейса, быстро создаваемых и уничтожаемых ресурсов, назначение обработчиков]
 */


    override fun onStart() {
        super.onStart()

    }
    /*
        В методе onStart  прорисовка активити, она уже видна пользователю, но еще недоступна для взаимодействия
         [инициализация блютуз, геолокациии, подключение к БД - т.е. все, что будет работать, пока активити видна и доступна пользователю]
     */


    override fun onResume() {
        super.onResume()
    }

    /*
  В методе onResume() активити уже и видна пользователю, и он может с ней взаимодействовать [запуск анимации]
*/

    override fun onPause() {
        super.onPause()
    }

    /*
  В методе onPause() активити видна, но уже недоступна для взаимодействия [останавливает анимации]
*/

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
    }

    /*
  В методе onStop активити перестает быть видимой [освобождает ресурсы блютуз, геолокации и др., что уже не нужно пока пользователь не использует активити]
*/

    override fun onDestroy() {
        super.onDestroy()
    }
    /*
      В методе onDestroy()  —  активити уничтожается [если в onCreate() были какие-то инициализации, то здесь их можно освободить]
   */

    /*
    1)При первом старте Активити сперва отрабатывает onCreate() с параметром onSaveInstanceState()=null.
     Это значит что наша активити запустилсь впервые и в Бандре нет сохранённого сотояния. затем onStart(), затем onResume(),

     2)Если нажать программную кнопку назад,то у нас отработают onPause(), затем onStop(), затем onDestroy()

     3)Если свернуть приложение нажав програмную кнопку Home, то у нас отработают методы onPause(), onStop(), onSaveInstanceState().
     то есть активити сперва станет недоступна для нажатия, затем для отображения и затем она сохранит своё состояние

     4)После разворачивания приложения, если система не убила наш процесс, будут вызваны методы onStart(), onResume(),

     5)Если же приложение было уничтожено, то будут вызваны методы onCreate(с параметром savedState=Bundle)- это значит что будет загружено сохранённое состояние,
      onStart(), onResume(),

     6)При открытии другой активити, первая сначала становится недоступной onPause(), но отображается до тех пор, пока вторая полностью не отрисуется и не станет доступной пользователю.
     вызов методом будет onCreate(), onStart(), onResume(),
      Т.к. запуск второй активити сопровождается анимацией, а значит во время анимации "всплывания" второй активити, первая еще должна быть видна.
      Когда вторая активити отрисуется и станет доступной пользователю, то первая активити перестанет быть видимой onStop()
      и затем сохранит своё состояние в Bundle, вызвав onSaveInstanceState().

     7) Если была открыта сперва первая активити, а затем с неё был переход на вторую активити. И затем приложение было убито.
     то при следующей запуске приложения сперва запустится вторая активити, с восстановлением состояние из Bundle.
     А при переходе назад по стеку из второй активити будет выполнен переход в первую Активити, так же с восстановлением состояние из Bundle.
     Будет вызван onPause на Второй активити, а затем onCreate() с параметром onSaveInstanceState(), onStart(), onResume(), на первой активити
     А после этого на Второй Активити будет вызван omStop and onDestroy()

     8) При запуске прозрачной активити, для первой вызовется только метод onPause().
      и когда прозрачная Активити будет завершена, то основная активити будет возобновлена с помощью OnResume()
      Если мы свернём приложение с запущеной прозрачной активити, то на основной Активтити будет вызван onStop и savedInstanceState()
      Когда мы развернём приложение после такого сворачивания, то на основной Активити будет вызван onStart(), для её отображения.
      И как только мы завершим работу с прозрачной Активити, то на основной Активти будет вызван onResume()

        У активити есть состояние, которое сохраняется в методе onSaveInstanceState().
        Так как он может быть вызван в любой момент времени, то действия в нем не надо привязывать к методам паузы или стоп. В нем надо только сохранять данные.

        Он срабатывает, когда:
        - система убивает процесс активити, чтобы освободить себе ресурсы
        - пользователь сворачивает приложение и оно может быть еще вызвано в будущем
        - запуск другой активити

        И не срабатывает, когда:
        -пользователь явно закрыл приложение

        А восстанавливается состояние когда активити было утеряно - был вызван onDestroy()

        */

}