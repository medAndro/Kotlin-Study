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
        super.drink() //부모의
    }
}

