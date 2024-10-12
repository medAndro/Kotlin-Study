fun main() {
    array()
    forAndWhile()
    nullCheck()
}

// 4. 배열
fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"d",11L)
    array[0] = 3
    //list[0] = 2 //immutable 값 변경 불가
    val arrayList = arrayListOf<Int>() //mutable한 List
    arrayList.add(10)
    arrayList.add(20)

    //arrayList = arrayListOf<Int>() //val 선언시 재할당 불가
}

// 5. 반복문
fun forAndWhile(){
    val students = arrayListOf("one", "two", "three", "four")

    for (name in students) {
        println("${name}")
    }
    for ((index, value) in students.withIndex()){
        println("인덱스: ${index}, 값 : ${value}")
    }
    var sum = 0
    for (i in 1..10){ //1 이상 10 이하
        sum += i
    }
    println(sum)
    sum = 0
    for (i in 1 until 10){ //1 이상 10 미만
        sum += i
    }
    println(sum)
    sum = 0
    for (i in 10 downTo 1){ //10 이하 1이상
        sum += i
    }
    println(sum)

    var idx = 0
    while(idx < 5){
        println("현재 인덱스 : ${idx}") // 0부터 4까지 출력
        idx++
    }
}

// 6. Nullable, NotNull, nullable 체크, ?:, !!

fun nullCheck(){
    var name = "Kotlin" //타입 생략시 기본적으로 Non-Nullable 타입
    var nullName : String? = null //물음표를 붙여서 Nullable 타입

    var nameInUpperCase = name.uppercase()
    var nullNameInUpperCase = nullName?.uppercase() // "변수?" 사용으로 Null이 아니면 해당값을, 아니면 Null을 대입
    // ?: 앨비스 연산자, Null일경우 default값을 지정
    var addName : String? = null
    var fullName = name + " "+(addName?: "has not fullName")
    println(fullName) // 변수?:기본값, 변수가 null일경우 기본값이 출력됨

    addName = "is fun"
    fullName = name + " "+(addName?: "has not fullName")
    println(fullName) // 변수가 null이 아닐경우 변수가 출력됨

    if (true){
        // null을 바로 대입하면 컴파일이 실패하므로 if문 안에서 null 대입하는 테스트코드
        addName = null
    }
    // !! 빅뱅 연산자
    try {
        addName = addName!! //Nullable타입을 Non-Nullable 타입으로 강제로 지정함
        //절대로 Null값이 들어올 가능성이 없을때만 사용해야함.
        //코틀린은 Null safety한 언어지만 !!사용시 NullPointException 유발 가능성이 있음
        fullName = name + " ${addName.uppercase()}"
        println(fullName)
    }catch (e: Exception){
        println("오류: "+e)
    }

    var bestLanguage : String? = "kotlin"
    bestLanguage?.let{ //null이 아닐때만 작동
        println("최고의 언어는 ${bestLanguage}이다")
        println("$it 최고") // let 람다식의 객체는 it 키워드로도 호출이 가능하다
    }
    bestLanguage = null
    bestLanguage?.let{ //null이므로 작동이 되지 않음
        println("최고의 언어는 ${bestLanguage}이다")
    }
}



