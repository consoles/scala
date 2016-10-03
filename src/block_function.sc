def hello(name: String): String = {
  s"Hello,${name}"
}

// 由于类型推导,我们可以省略返回值
def hello2(name: String) = {
  s"Hello ${name}"
}

def add(x: Int, y: Int) = x + y

hello("consoles")
hello2("大梦初晓")
add(1, 2)