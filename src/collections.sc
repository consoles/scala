// List[T]

val a = List(1, 2, 3, 4) // 类型推导,不需要使用泛型
val b = 0 :: a // 一个新的List,a的头部加了1,`::`是连接操作符
val c = "x" :: "y" :: "z" :: Nil // Nil空列表,执行过程res0 = "z"::Nil,res1 = "y" :: res1,res2 = "z"::res1
val d = a ::: c // `:::`操作符用于连接2个List,String是引用类型,Int是值类型,而值类型和引用类型的公共类型为Any,所以d被推导为Any

a.head // 取List第一个元素
c.head
d.head

a.tail // 除了第一个元素外的所有其他元素组成的列表,被称为尾列表
c.tail

a.isEmpty
Nil.isEmpty

// 遍历List
def walkthru(l: List[Int]): String = {
  if (l.isEmpty) ""
  else l.head.toString + " " + walkthru(l.tail)
}
walkthru(a)

// filter
a.filter(x => x % 2 == 0)

"37 Red Ballons".toList.filter(x => Character.isDigit(x)) // string -> character list
"37 Red Ballons".toList.takeWhile(x => x != 'B')

// map
c.map(x => x.toUpperCase)
c.map(_.toUpperCase) // 和上面的等价,使用通配符
a.filter(_ % 2 == 0).map(_ * -1)

val q = List(a, List(5, 6, 7))
q.flatMap(_.filter(_ % 2 == 0))

// reduce left
a.reduceLeft((x, y) => x + y)
// 简写
a.reduceLeft(_ + _)
a.foldLeft(0)(_ + _)
a.foldLeft(1)(_ * _)

// range
1 to 10
1 to 10 by 2
(1 to 10).toList

1 until (10)

// stream,按需求值,程序更加高效
1 #:: 2 #:: 3 #:: Stream.empty // 只有第一个元素是确定的,只有用到才会求值
val stream = (1 to 100000000).toStream
stream.head
stream.tail

// tuple
(1, 2) // 只有2个元素的tuple又叫pair
// 简写
1 -> 2
val t = (1, "Alice", "Math", 95.5)
t._1
t._2

/**
  * @param in List
  * @return tuple {count,sum,pow sum}
  */
def sumSq(in: List[Int]): (Int, Int, Int) = in.foldLeft((0, 0, 0))((t, v) => (t._1 + 1, t._2 + v, t._3 + v * v))
sumSq(a)

// Map
val p = Map(1 -> "Consoles", 2 -> "Cindy")
p(1)
p(2)
p.contains(1)
p.contains(99)
p + (8 -> "New") // 新生成Map
p ++ List(3->"Alice",6->"Big")
p -- List(1,2)
p - 1 // 新生成Map删除
p.keys
p.values