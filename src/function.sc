// 高阶函数
def operate(f: (Int, Int) => Int) = {
  f(4, 4)
}

def greeting() = (name: String) => {
  s"hello ${name}"
}

def tr(x: Int, y: Int) = x + y

greeting()("123")
operate(tr)

def curriedAdd(a: Int)(b: Int) = a + b
curriedAdd(2)(2) // 4

val addOne = curriedAdd(1) _ // _统配所有参数列表,基于通用加法函数定义加1的函数
addOne(2)

// 递归
def fac(n: Int): Int =
  if (n <= 0) 1
  else n * fac(n - 1)

fac(10)

// 注解告诉编译器进行尾递归优化
@annotation.tailrec
def factorial(n: Int, m: Int): Int =
  if (n <= 0) m
  else factorial(n - 1, m * n)

factorial(10, 1)

// 柯里化
def sum(f: Int => Int)(a: Int)(b: Int): Int = {

  @annotation.tailrec
  def loop(n: Int, acc: Int): Int = {
    if (n > b) {
      println(s"n=${n},acc=${acc}")
      acc
    } else {
      println(s"n=${n},acc=${acc}")
      loop(n + 1, acc + f(n))
    }
  }
  loop(a, 0)
}

sum(x => x)(1)(5) // f(x) = x,求Σf(x) 1到5
sum(x => x * x)(1)(5) // f(x) = x * x,求Σf(x) 1到5

val sumSquare = sum(x => x * x)_ // sum的偏函数
sumSquare(1)(5)
