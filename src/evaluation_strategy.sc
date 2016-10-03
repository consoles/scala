def test1(x: Int, y: Int): Int = x * x
def test2(x: => Int, y: => Int): Int = x * x

test1(3 + 4, 8) // test1(7,8) = 7*7 = 49
test2(3 + 4, 8) // test2(3+4,8) = (3+4)*(3+4) = 7 * (3+4)

// 在以上的程序中call by name多执行了一步,下面的call by value多执行了一步
test1(7, 2 * 4) // test1(7,8) = 7 * 7 = 49
test2(7, 2 * 4) // 7*7 = 49

def bar(x: Int, y: => Int): Int = 1
def loop(): Int = loop // 死循环递归函数

bar(1, loop) // 返回值1,y 是call by name的,在bar函数体内没有被用到
bar(loop, 1) // 一直没有返回值,call by value,首先会求值,但是死循环无法得到返回值