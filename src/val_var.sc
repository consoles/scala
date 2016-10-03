val x = 10
val y: Int = 10
//y = 200 常量!
x + x // res0是scala为默认没有变量名的表达式的命名,在REPL中可以直接使用res0
val z = x + y

var a = 200
a = 300
val d = 20
val e = 30
lazy val f = d * e // 该值不会立即求解
f

