package com.demo.domain;



/**
 * QuestionShortanswer entity. @author MyEclipse Persistence Tools
 */

public class QuestionShortanswer  implements java.io.Serializable {


    // Fields    

     private Integer hiloId;
     private String content;
     private String difficultyPonit;


    // Constructors

    /** default constructor */
    public QuestionShortanswer() {
    }

    
    /** full constructor */
    public QuestionShortanswer(String content, String difficultyPonit) {
        this.content = content;
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

    public String getDifficultyPonit() {
        return this.difficultyPonit;
    }
    
    public void setDifficultyPonit(String difficultyPonit) {
        this.difficultyPonit = difficultyPonit;
    }
   








}