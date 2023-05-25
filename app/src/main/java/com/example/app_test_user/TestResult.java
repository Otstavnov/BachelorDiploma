package com.example.app_test_user;

public class TestResult {
    public int pointsBasic, pointsCollections, pointsExceptions, pointsOOP, pointsOperators, pointsAll;

    public TestResult() {
        this.pointsBasic = 0;
        this.pointsCollections = 0;
        this.pointsExceptions = 0;
        this.pointsOOP = 0;
        this.pointsOperators = 0;
        this.pointsAll = 0;
    }

    public TestResult(int pointsBasic, int pointsCollections, int pointsExceptions, int pointsOPP, int pointsOperators) {
        this.pointsBasic = pointsBasic * 4;
        this.pointsCollections = pointsCollections * 4;
        this.pointsExceptions = pointsExceptions * 4;
        this.pointsOOP = pointsOPP * 4;
        this.pointsOperators = pointsOperators * 4;
        this.pointsAll = this.pointsBasic + this.pointsCollections + this.pointsExceptions + this.pointsOOP + this.pointsOperators;
    }


    public int getPointsBasic() {
        return pointsBasic;
    }

    public void setPointsBasic(int pointsBasic) {
        this.pointsBasic = pointsBasic;
    }

    public int getPointsCollections() {
        return pointsCollections;
    }

    public void setPointsCollections(int pointsCollection) {
        this.pointsCollections = pointsCollection;
    }

    public int getPointsExceptions() {
        return pointsExceptions;
    }

    public void setPointsExceptions(int pointsExceptions) {
        this.pointsExceptions = pointsExceptions;
    }

    public int getPointsOOP() {
        return pointsOOP;
    }

    public void setPointsOOP(int pointsOPP) {
        this.pointsOOP = pointsOPP;
    }

    public int getPointsOperators() {
        return pointsOperators;
    }

    public void setPointsOperators(int pointsOperators) {
        this.pointsOperators = pointsOperators;
    }

    public int getPointsAll() {
        return pointsAll;
    }

    public void setPointsAll(int pointsAll) {
        this.pointsAll = pointsAll;
    }
}
