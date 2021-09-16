package com.kevin.easyaudiorecord

/**
 *    @author : 王康
 *    @date   : 2021/9/14
 *    @desc   : kotlin 学习示例
 */

fun main() {

//    val user = User(sex = "男")
//    val user = User()
//    val toString = user.toString()
//    println(toString)
//    val mName = user.mName
//    val mSex = user.mSex
//    println(mName)
//    println(mSex)

    // 实例化类
    User1("帅康") // 调用主构造函数
    User1()      // 调用次构造函数1
    User1(2)     // 调用次构造函数2
    User1("帅康", 26) // 调用次构造函数3

//    val init = EasyAudioRecorder.init(Uri.EMPTY, EasyAudioRecorderConfig())

}


class User(name: String = "帅康", sex: String = "男") {
    var mName: String = name
    var mSex: String = sex

    override fun toString(): String {
        return "{" +
                "mName=" +
                "'" +
                mName +
                "'" +
                "," +
                "mSex=" +
                "'" +
                mSex +
                "'" +
                "}"
    }
}

// 形式
//constructor(参数名：参数类型) :{函数体}

// 示例
class User1(userName: String) {


//    lateinit var mUserName: String
//    lateinit var mAge:  Int
//    lateinit var mUserName: String

    // 主构造函数
    init {

        println(userName)
    }

    // 次构造函数1：可通过this调主构造函数
    constructor() : this("帅康")

    // 次构造函数2：可通过this调主构造函数
    constructor(age: Int) : this("帅康") {
        println(age)
    }

    // 次构造函数3：通过this调主构造函数
    constructor(sex: String, age: Int) : this("帅康") {
        println("$sex$age")
    }


}

