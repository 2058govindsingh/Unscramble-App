package com.example.android.unscramble.ui.game
import androidx.lifecycle.ViewModel
class GameViewModel :ViewModel() {
    private var wordsList:MutableList<String> = mutableListOf()
    private lateinit var currentWord:String
    private var _score = 0
    val score:Int
        get()=_score
    private var _currentWordCount = 0
    val currentWordCount:Int
        get()=_currentWordCount
    private lateinit var _currentScrambledWord :String
    val currentScrambledWord: String
        get()=_currentScrambledWord
    init {
        getNextWord()
    }
    fun nextWord() :Boolean
    {
        return if(currentWordCount< MAX_NO_OF_WORDS)
        {
            getNextWord()
            true
        }
        else false
    }
    private fun getNextWord()
    {
        currentWord= allWordsList.random()
        if(wordsList.contains(currentWord))
        {
            getNextWord()
            return
        }
        val tempWord=currentWord.toCharArray()
        while(String(tempWord)==currentWord)
        {
            tempWord.shuffle()
        }
        _currentScrambledWord= String(tempWord)
        wordsList.add(currentWord)
        ++_currentWordCount
    }
}