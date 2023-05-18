package com.example.app_test_user;

public class TestResult {
    public int pointsBasic, pointsCollection, pointsExceptions, pointsOPP, pointsOperators, pointsAll;

    public TestResult(int pointsBasic, int pointsCollection, int pointsExceptions, int pointsOPP, int pointsOperators) {
        this.pointsBasic = pointsBasic * 4;
        this.pointsCollection = pointsCollection * 4;
        this.pointsExceptions = pointsExceptions * 4;
        this.pointsOPP = pointsOPP * 4;
        this.pointsOperators = pointsOperators * 4;
        this.pointsAll = this.pointsBasic + this.pointsCollection + this.pointsExceptions + this.pointsOPP + this.pointsOperators;
    }

    public int getPointsBasic() {
        return pointsBasic;
    }

    public void setPointsBasic(int pointsBasic) {
        this.pointsBasic = pointsBasic;
    }

    public int getPointsCollection() {
        return pointsCollection;
    }

    public void setPointsCollection(int pointsCollection) {
        this.pointsCollection = pointsCollection;
    }

    public int getPointsExceptions() {
        return pointsExceptions;
    }

    public void setPointsExceptions(int pointsExceptions) {
        this.pointsExceptions = pointsExceptions;
    }

    public int getPointsOPP() {
        return pointsOPP;
    }

    public void setPointsOPP(int pointsOPP) {
        this.pointsOPP = pointsOPP;
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
