package com.example.myapp.ui.adapter

class recyclerview {
}
/* разбор recyclerview
 используется для отображения списка.

класс для адаптера должен наследоваться от RecyclerView.Adapter
пример UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>(), View,OnClickListener {
в качестве параметра передаем ViewHolder, который будет хранить все компоненты вью Имплементируем методы.


создаём onBindViewHolder для обновления элемента списка
}
передаём внутрь адаптера список пользователей, добавим сеттер, что после каждого изменения спсика нужно данные на экране.
notifyDataSetChanged() - заставит адаптер перерисовать все элементы
var users: List<User> = emptyList()
set(value) {
field = value
notifyDataSetChanged()
}

адаптер должен знать количество элементов в списке- через метод getItemCount
override fun getItemCount():Int = users.size
}

создаём onCreateViewHolder используется когда ресайклер создаёт новый элемент списка
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
создаём inflater binding и экземпляр Холдера
return ViewHolder(view)
}
override fun onBindViewHolder(holder: ViewHolder, position: Int) {

используется для вытягивания элемента со спиcка
val user = users[position]
with(holder) {
holder.itemView.tag = user - сохраняем данные в тег
ак же на кнопках тоже нужно сохранить данные в тег
    и внутри блока обращаемся напрямую к компонентам вью напрямую.
    userName.text = user.name
    если прописано if else то во всех случаях нужно прописать весь код, внутри каждого if else чтобы переиспользование не пошло с ошибками
}
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val textView: TextView = itemView.findViewById(R.id.textView)
}
Ресайклер вьб может отображать данные разными списками. Вертикальным списком, горизонтальным, или в несколько колонок
создаём лаяут менеджер
val layoutManager = LinearLayoutManager(this)
binding.recyclerView.layoutManager = layoutManager
binding.recyclerView.adapter = adapter

добавим слушателя на список. В качестве аргумента нам будет приходить изменный список, и всё что нам нужно сделать это казать этот список для адаптера
private val userListener: UserListener= {
adapter.users = it

для добавления действий со списком лучше использовать интерфейс. Создаём интерфейс, вносим туда нужные методы
и передаём его в конструктор адаптера и добавляем к адаптеру интерфейс View,OnClickListener
реализуем метод onClick внутри адаптера
  override fun onClick(v: View) {
      val user = v.tag as User ткт тег возвращает тип Any то мы приводим его к типу User
  }
  когда мы сделаем слушатель на элемент спсика и на нопку, то у нас будет вызываться этот метод.
  И так как мы в каждый из компонентов в качестве тега передали пользователя, то мы узнаем на каком компоненте нажали на экран
   */