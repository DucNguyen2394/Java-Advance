package Session03_CollectionAPI;

import javax.print.Doc;
import java.util.PriorityQueue;

public class ApointDoctor {
    public ApointDoctor(){

    }
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        Doctor d1 = new Doctor("Casuality",4);
        Doctor d2 = new Doctor("physicallity",2);
        Doctor d3 = new Doctor("archorphobia",3);


        q.offer(d1);
        q.offer(d2);
        q.offer(d3);
        while (!q.isEmpty()){
            Doctor doctor = (Doctor) q.remove();

            System.out.println(doctor.toString());
        }
    }
}
