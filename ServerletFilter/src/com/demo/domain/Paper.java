package com.demo.domain;



/**
 * Paper entity. @author MyEclipse Persistence Tools
 */

public class Paper  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer choiceCount;
     private Integer completionCount;
     private Integer trueOrFalseCount;
     private Integer shortAnswerCount;


    // Constructors

    /** default constructor */
    public Paper() {
    }

    
    /** full constructor */
    public Paper(Integer choiceCount, Integer completionCount, Integer trueOrFalseCount, Integer shortAnswerCount) {
        this.choiceCount = choiceCount;
        this.completionCount = completionCount;
        this.trueOrFalseCount = trueOrFalseCount;
        this.shortAnswerCount = shortAnswerCount;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChoiceCount() {
        return this.choiceCount;
    }
    
    public void setChoiceCount(Integer choiceCount) {
        this.choiceCount = choiceCount;
    }

    public Integer getCompletionCount() {
        return this.completionCount;
    }
    
    public void setCompletionCount(Integer completionCount) {
        this.completionCount = completionCount;
    }

    public Integer getTrueOrFalseCount() {
        return this.trueOrFalseCount;
    }
    
    public void setTrueOrFalseCount(Integer trueOrFalseCount) {
        this.trueOrFalseCount = trueOrFalseCount;
    }

    public Integer getShortAnswerCount() {
        return this.shortAnswerCount;
    }
    
    public void setShortAnswerCount(Integer shortAnswerCount) {
        this.shortAnswerCount = shortAnswerCount;
    }
   








}