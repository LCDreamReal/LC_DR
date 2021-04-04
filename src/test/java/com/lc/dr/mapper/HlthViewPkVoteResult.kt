package com.lc.dr.mapper

enum class HlthViewPkVoteResult private constructor(
        /**
         * 投票结果
         */
        val result: Int,
        /**
         * 描述
         */
        val desc: String) {
    SUPPORT(1, "正方"),
    OPPOSE(2, "反方");


    companion object {

        operator fun contains(result: Int): Boolean {
            for (c in values()) {
                if (c.result == result) {
                    return true
                }
            }
            return false
        }
    }
}
