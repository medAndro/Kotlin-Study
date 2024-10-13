fun main() {
    val human = Human("Meda")
    println("나는 ${human.name} 이다")
    human.drink()
    println()

    val stranger = Human()
    println("나는 ${stranger.name} 이다")
    println()

    val baby = Human("Baby", 1)
    println()

    var koreanBaby = Korean("KoreanBaby", 2)
    koreanBaby.drink() //오버라이드 했으므로 식혜를 마심
    koreanBaby.sing() //상속을 받았으므로 부모의 메소드 호출가능

    lambdaExtensionExample()
}

// 7. 클래스

//상속을 위해서는 open 키워드 추가
open class Human constructor (name:String="Anonymous") { //주 생성자 constructor 키워드는 생략 가능함

    init { // 클래스 초기화시 필요한 작업을 하기 위한 init 블록, 주로 주 생성자와 같이 사용
        // 부 생성자보다 init블록이 먼저 실행됨
        println("새로운 사람이 나타났다!")
    }
    //부 생성자
    constructor(name:String="Anonymous", age: Int =99) : this(name){
        //this 예약어를 사용해서 주 생성자를 상속받아야 함.
        println("나는 ${name}이고 ${age}살이야")
    }

    val name = name

    //메소드 오버라이딩을 위해서는 open키워드 추가 필요
    open fun drink(){
        println("${name} 은 무언가를 마심")
    }

    fun sing(){
        println("라라라")
    }
}

class Korean : Human{
    //super 키워드를 사용해서 부모의 생성자를 호출함
    constructor(name: String) : super(name)
    constructor(name: String, age: Int) : super(name, age)

    //메소드 오버라이딩
    override fun drink(){
        println("${name} 은 식혜를 마심")
        println("부모의 drink():")
        super.drink() //부모의 drink
    }
}

// 8. 람다와 확장함수
fun lambdaExtensionExample() {
    // 람다는 값처럼 익명함수이며 값처럼 다룰 수 있다. (메소드의 파라미터나 리턴값으로 사용가능)
    // val 람다이름: (타입1, 타입2) -> 반환타입 = { 파라미터1: 타입, 파라미터2: 타입 -> 코드 }
    // 위 예시에서 타입은 = 기준 앞 뒤 한번만 입력해도 추론됨
    val lambdaHuman: (String, Int) -> String = { name: String, age: Int ->
        "람다) ${name}는 영원한 ${age}세"
    }
    val lambdaHumanTypeInference1 = { name: String, age: Int ->
        "람다_타입추론1) ${name}는 영원한 ${age}세"
    }
    val lambdaHumanTypeInference2: (String, Int) -> String = { name, age ->
        "람다_타입추론2) ${name}는 영원한 ${age}세"
    }
    fun methodHuman(name: String, age: Int): String {
        return "메소드) ${name}는 영원한 ${age}세 "
    }

    println(lambdaHuman("NANA", 17)) // 람다) NANA는 영원한 17세
    println(lambdaHumanTypeInference1("NANA", 17)) // 람다_타입추론1) NANA는 영원한 17세
    println(lambdaHumanTypeInference2("NANA", 17)) // 람다_타입추론2) NANA는 영원한 17세
    println(methodHuman("NANA", 17)) // 메소드) NANA는 영원한 17세

    // 메소드에서 인자로 람다 사용하기
    fun lambdaInFun(name: String, age: Int, idx:Int, lambda : (String, Int) -> String): String {
        val strSplit = lambda(name, age).split(")", limit = 2)
        return "인자로_람다받기${idx}) ${strSplit[1]}"
    }
    println(lambdaInFun("NANA", 17, 1, lambdaHuman)) // 인자로_람다받기1) NANA는 영원한 17세
    println(lambdaInFun("NANA", 17, 2,
        {n:String, a:Int -> "람다리터럴) ${n}는 영원한 ${a}세"})) // 인자로_람다받기2) NANA는 영원한 17세

    // 확장함수
    // 프로퍼티, 클래스 등을 상속 없이 간단하게 확장할때 사용되며 메소드가 실제 생성되는것은 아님
    val extensionLambdaHuman : String.(String, Int) -> String =  { name, age ->
        "$this ${name}는 영원한 ${age}세 "
    }
    val infoStr = "확장함수_프로퍼티)"
    println(infoStr.extensionLambdaHuman("NANA", 17)) // 확장함수_프로퍼티) NANA는 영원한 17세

    // 예시로 사용할 클래스
    class NanaClass{
        val name = "NANA"
        val age = 17
    }
    // 확장함수로 클래스에 말하기 기능 추가
    fun NanaClass.speak(info: String): String{
        return "$info ${name}는 영원한 ${age}세 "
    }
    // 확장함수 사용
    val nana = NanaClass()
    println(nana.speak("확장함수_클래스)")) // 확장함수_클래스) NANA는 영원한 17세
}
