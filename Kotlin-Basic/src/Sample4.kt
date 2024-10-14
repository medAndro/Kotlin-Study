import java.time.LocalDate


fun main() {
    dataClassTest()
    println()
    objectDeclarationsTest()
    objectExpressionsTest()
    companionObjTest()
}

// 9. 데이터 클래스 - 데이터를 저장하기 위한 객체
// copy(), equals(), toString(), hashCode(), componentN()등의 메소드가 내장되어 있음
data class GameDataClass(var name: String, var released: LocalDate)
class GameNormalClass(var name: String, var released: LocalDate)
fun dataClassTest(){
    val trickcal = GameDataClass( "Trickcal", LocalDate.of(2021, 9, 27))

    // copy()로 객체 복사가 가능하며 동시에 일부 데이터를 변경할 수 있음.
    val trickcaCopy = trickcal.copy()
    val trickcalRevive = trickcal.copy(name = "Trickcal RE:VIVE")

    // equals() 객체 비교, (==도 동일한 결과)
    println("${trickcal.equals(trickcaCopy)}, ${trickcal == trickcaCopy}") // true, true
    println(trickcal == trickcalRevive) // false

    // componentN()을 통해 N번째 인덱스 기반으로 값을 가져올 수 있음
    trickcalRevive.released = trickcalRevive.component2().plusYears(2)

    // hashCode()로 객체의 해시값 출력
    println(trickcalRevive.hashCode()) // -1151190857 (매 실행시 달라짐)

    // 객체를 print하면 toString()한 결과가 출력됨
    println(trickcalRevive) // GameDataClass(name=Trickcal RE:VIVE, released=2023-09-27)
    println(trickcalRevive.toString()) // GameDataClass(name=Trickcal RE:VIVE, released=2023-09-27)

    // 일반 클래스는 해당 클래스의 주소가 출력됨
    val normalClassExample = GameNormalClass( "Trickcal", LocalDate.of(2021, 9, 27))
    println(normalClassExample) // GameNormalClass@3d494fbf
}

// 10. object와 companion object(동반 객체)

// Object Declarations(선언식)- 싱글톤을 언어차원에서 지원
// 프로그램 전체에서 공용으로 사용되며, 프로그램이 종료될 때까지 유지됨
object SingletonGame{
    var day = 1
    fun nextDay(){ day++ }
    // 커스텀 게터(custom getter)를 사용한 프로퍼티: 접근할 때마다 새로운 문자열 생성
    val goblin:String get() = "고블린무녀 출시 기원 ${day}일차"
}

fun objectDeclarationsTest(){
    println(SingletonGame.goblin) // 고블린무녀 출시 기원 1일차
    SingletonGame.nextDay()
    println(SingletonGame.goblin) // 고블린무녀 출시 기원 2일차
}

// Object Expressions(표현식)- 익명 객체로 사용
interface TitleCall{
    fun enter()
}
// 기존 방법) 클래스에서 인터페이스 구현
class GameStartClass: TitleCall{
    override fun enter(){
        println("클래스) 볼을 잡아 당겨서 시작하기")
    }
}
// Object Expressions사용 ) 익명 객체가 인터페이스의 구현체로서 사용됨
val gameStart= object: TitleCall{
    override fun enter(){
        println("익명객체) 볼을 잡아당겨서 시작하기!")
    }
}
fun objectExpressionsTest(){
    GameStartClass().enter() //클래스) 볼을 잡아 당겨서 시작하기
    gameStart.enter() //익명객체) 볼을 잡아당겨서 시작하기!
}


// Companion Object(동행객체) - 클래스와 동행하는 유일한 오브젝트
// 인스턴스가 여러개 생성되도 한번만 생성되는 객체
// 자바의 static과 같이 프라이빗 프로퍼티나 메소드를 읽어올 수 있음
class ElifManager private constructor() {
    companion object ElifFactory :ElifInfo { //동행객체 이름 (ElifFactory) 생략 가능, 인터페이스 상속 가능
        var elif = 10000
        fun createWallet(): ElifManager = ElifManager()
        override fun getCurrentElif(): Int {
            return elif
        }
    }
    fun drawCard(){
        elif -= 1000
    }
    fun buyKingCandy(){
        elif -= 30
    }
}
interface ElifInfo{
    fun getCurrentElif() : Int
}
fun companionObjTest(){
    // var test = ElifManager() // private 객체 직접 생성 불가능
    val gaCha = ElifManager.ElifFactory.createWallet()
    val adventure = ElifManager.createWallet() //동행객체 이름 (ElifFactory) 생략 가능
    println("같은 객체: ${gaCha == adventure}, ${ElifManager.getCurrentElif()} 엘리프 보유") // 같은 객체: false, 10000 엘리프 보유
    gaCha.drawCard() // 엘리프 1000 소모
    println("${ElifManager.getCurrentElif()} 엘리프 보유") // 9000 엘리프 보유
    adventure.buyKingCandy() // 엘리프 30 소모
    println("${ElifManager.getCurrentElif()} 엘리프 보유") // 8970 엘리프 보유
}

