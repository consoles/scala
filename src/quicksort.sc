/**
  * 快速排序:比指定元素小的分区+指定元素+比指定元素大的分区
  *
  * @param a
  * @return
  */
def qSort(a: List[Int]): List[Int] = {
  if (a.length < 2) a
  else qSort(a.filter(_ < a.head)) ++
    a.filter(a.head == _) ++
    qSort(a.filter(_ > a.head))
}

qSort(List(6, 4, 5, 3, 2, 1, 8, 0))