// 高阶函数

def operator(f: (Int, Int) => Int) {
  f(4, 4)
}

def greeting() = (name: String) => {
  s"hello ${name}"
}

