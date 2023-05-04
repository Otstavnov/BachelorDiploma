package com.example.app_test_user;

public class Question {

    public String  section, id, text, answer1, answer2, answer3, answer4, correct_answer;

    public Question() {
        section = null;
        id = null;
        text = null;
        answer1 = null;
        answer2 = null;
        answer3 = null;
        answer4 = null;
        correct_answer = null;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getSection() {
        return section;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }
}
