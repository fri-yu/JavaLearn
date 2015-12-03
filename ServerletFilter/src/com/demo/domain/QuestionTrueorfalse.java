package com.demo.domain;



/**
 * QuestionTrueorfalse entity. @author MyEclipse Persistence Tools
 */

public class QuestionTrueorfalse  implements java.io.Serializable {


    // Fields    

     private Integer hiloId;
     private String content;
     private String answer;
     private String difficultyPonit;


    // Constructors

    /** default constructor */
    public QuestionTrueorfalse() {
    }

    
    /** full constructor */
    public QuestionTrueorfalse(String content, String answer, String difficultyPonit) {
        this.content = content;
        this.answer = answer;
        this.difficultyPonit = difficultyPonit;
    }

   
    // Property accessors

    public Integer getHiloId() {
        return this.hiloId;
    }
    
    public void setHiloId(Integer hiloId) {
        this.hiloId = hiloId;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDifficultyPonit() {
        return this.difficultyPonit;
    }
    
    public void setDifficultyPonit(String difficultyPonit) {
        this.difficultyPonit = difficultyPonit;
    }
   








}