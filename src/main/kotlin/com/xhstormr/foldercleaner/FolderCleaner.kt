package com.xhstormr.foldercleaner

import java.io.File
import java.util.*

private object FolderCleaner {
    @JvmStatic
    fun main(args: Array<String>) = FolderCleaner.start()

    fun start() {
//      val files = URLDecoder.decode(FolderCleaner::class.java.protectionDomain.codeSource.location.path, "utf-8").let { File(it.substring(1, it.lastIndexOf('/') + 1)) }
        val files = File(".")
                .listFiles { file -> file.isFile }
                .groupBy { it.nameWithoutExtension.substringBefore('(').trim() }
                .values
                .map { it.sortedByDescending { getNum(it.nameWithoutExtension) }.drop(1) }
                .flatten()

        if (files.isEmpty()) {
            println("没有多余文件!")
            System.`in`.read()
        } else {
            files.forEach { println(it) }
            print("是否要删除以上文件（y or n）：")

            Scanner(System.`in`).use {
                when (it.next()) {
                    "y", "Y" -> {
                        files.forEach {
                            if (it.delete()) {
                                println("已删除：$it")
                            } else {
                                println("未删除：$it")
                            }
                        }
                        println("已完成!")
                    }
                    else -> println("已取消!")
                }
                System.`in`.read()
            }
        }
    }

    private fun getNum(name: String): Int {
        val index1 = name.lastIndexOf('(')
        val index2 = name.lastIndexOf(')')
        return if (index1 == -1 || index2 == -1) 0 else name.substring(index1 + 1, index2).toInt()
    }
}
