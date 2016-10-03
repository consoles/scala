val l = List("alice", "bob", "cindy")

for (
  x <- l // generator,会循环遍历List中的元素并赋值给x
) println(x)

for (
  x <- l
  if (x.length > 3) // filter
) println(x)

val result_for = for {
  s <- l
  s1 = s.toUpperCase() // variable binding
  if (s1 != "")
} yield (s1) // generator new collection,yield是导出的意思