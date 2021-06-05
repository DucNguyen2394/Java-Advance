package Session03_CollectionAPI;

public class Doctor implements Comparable {
    private String name;
    private int task = 0;

    public Doctor(){

    }
    public Doctor(String name, int task){
        int a;
        int b;
        this.name = name;
        this.task = task;
    }

    @Override
    public int compareTo(Object o) {
        Doctor doctor=  (Doctor) o;
        int a = this.task;
        int b = doctor.task;

        if (a < b){
            return -1;
        }
        if (a > b){
            return  1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", task=" + task +
                '}';
    }
}
