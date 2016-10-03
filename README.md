# 函数式编程

一种编程范式，把计算当做数学函数的求值过程，避免了改变状态和可变的数据。

> scala的REPL中使用`:paste`可以打开输入一大段代码的模式

## 函数式编程的几个重要概念

- 纯函数(Pure Function)，或者函数的纯粹性(Purity)，没有副作用(Side Effect)。
- *副作用*指的是状态的变化(mutation)，例如：修改全局变量、抛出异常、IO读写、调用有副作用的函数。
- 引用透明(Referential Transparency)，对于相同的输入，总是得到相同的输出。如果f(x)的参数x和函数体都是引用透明的，那么函数f是纯函数。
- 不变性(Immutability)，为了获得引用透明性，任何值都不能变化。
- 在函数式编程中，函数是一等公民(First-class Function)，一切都是计算，函数式编程中只有表达式。变量和函数都是表达式。
- 表达式求值策略有2种：严格求值(Call By Value)和非严格求值(Call By Name)。
- 惰性求值(Lazy Evaluation):定义好函数之后并不会立即求值，而是在第一次调用的时候才会求值。
- 递归函数(Recursive Function)：没有循环的概念，使用递归实现循环。Tail Resursive,尾递归，解决递归调用栈过深的问题。

## 函数式编程语言的优点

生产效率特别高。同样功能的程序，LISP(第一个函数式编程语言)是C代码的1/7~1/10。非常适合并行编程，多核计算和云计算，因为没有副作用

# 语言基础

## 变量

### 三种变量修饰符:

- val:immutable variable,常量
- var:mutable variable,变量
- lazy val:惰性求值常量,当第一次被使用的时候会自动求值。如果我们定义的变量在后续的程序中可能不被用到,可以定义为lazy val。val和var会在定义时直接被求值

可以不显式指定变量类型,scale会自动进行类型推导。

## 数据类型

![scala的类型体系](http://7xlan5.com1.z0.glb.clouddn.com/scala-types.png)

其中AnyVal中的Unit是空类型,相当于C中的void。在Scala中我们通常不会使用null,会使用Nothing,表示程序异常终止,如果函数的返回值是Nothing,表示该函数发生了异常。如:

```scala
def foo() = throw new Exception("error occurred")
```

String构建于java的String之上,新增了字符串插值(interpolation)特性,ES6模板字符串。

### 函数和代码块

代码块也是表达式,最终的值是最后一个表达式。

### if和for表达式

特别注意:scala中*if是表达式而不是语句*。

for comprehension是用于实现循环的推导式。

```scala
for {
  x <- xs
  y = x + 1
  if (y > 0)
} yield y
```

其本质是map,reduce,for只是一种语法糖(Syntax Sugar)。

### try和match表达式

match类似于switch-case,`case _`表示通配符。

## 求值策略

Evaluation Strategy

- Call By Value:对实参求值,且仅求值一次
- Call By Name:函数实参每次在函数体内被用到时都会求值

通常使用Call By Value。如果函数形参以`=>`开头,会使用Call By Name。

```scala
def foo(x:Int) = x // call by value
def foo(x: => Int) = x // call by name
```

## 高阶函数

函数类型格式为A => B,表示接受类型A的参数并返回类型B的函数。`Int => String`是将整型映射为字符串的函数类型。

> Anonymous Function本质上是函数常量,也叫做函数字面量(Function Literal)

### 柯里化

Curried Function:把具有多个参数的函数转化为一条函数链,每个节点上都是单一参数。以下2个add函数定义等价。

```scala
def add(x:Int,y:Int) = x + y
def add(x:Int)(y:Int) = x + y
```

### 递归函数

函数式编程中递归非常重要,用于实现循环。

```scala
def fac(n:Int):Int =
    if (n <= 0) 1
    else n * fac(n - 1)
```

*Tail Recursive Function*是对递归进行优化的一种方式,所有的递归调用都放在函数末尾。当编译器检测到一个函数调用是尾递归的时候,它就会覆盖当前的活动记录,而不是在栈中创建一个新的。

## Immutable Collections

![scala collections](http://7xlan5.com1.z0.glb.clouddn.com/scala-collections.png)

### 规约

通过某种操作将集合元素合并成一个值。

> scala中的Stream是Lazy List,惰性求值列表

参考资料:

- [scala collections](http://docs.scala-lang.org/zh-cn/overviews/collections/overview)