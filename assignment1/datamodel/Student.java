package fsd.assignment.assignment1.datamodel;

public class Student {
    private String studId;
    private String yearOfStudy;
    private String module1;
    private String module2;
    private String module3;

    /* TODO: the constructor must accept parameters so that all
             instance variables are set accordingly
    */

    public Student(String studId, String yearStudy, String mod1, String mod2, String mod3) {
        this.studId = studId;
        this.yearOfStudy = yearStudy;
        this.module1 = mod1;
        this.module2 = mod2;
        this.module3 = mod3;
    }
    /* TODO: ensure that all getters are included here
     */
    public String getStudId() {
        return studId;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public String getModule1() {
        return module1;
    }

    public String getModule2() {
        return module2;
    }

    public String getModule3() {
        return module3;
    }


    /* TODO: include a toString() that returns studId
    */
    @Override
    public String toString(){ return studId; }
}
