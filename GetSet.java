public class Student {
    int IDnumber;
    int hours;
    int points;
    public static void main(String[] args) {
        Student pupil = new Student();
        pupil.setIDnumber(234);
        pupil.setPoints(47);
        pupil.setHours(15);
        System.out.printf(pupil.getIDnumber() + ", Hours: " + pupil.getHours() + ", Points:" + pupil.getPoints());
    }
    public void setIDnumber(int ID){
        this.IDnumber = ID;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public void setHours(int hours){
        this.hours = hours;
    }
    public Integer getIDnumber(){
        return this.IDnumber;
    }
    public Integer getHours(){
        return this.hours;
    }
    public Integer getPoints(){
        return this.points;
    }

}
