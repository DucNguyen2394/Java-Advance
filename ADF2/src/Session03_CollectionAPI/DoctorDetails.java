package Session03_CollectionAPI;

public class DoctorDetails {
    String name;
    String docCode;
    int hours;
    String specialization;
    public DoctorDetails(){

    }
    public DoctorDetails(final String code,final String lastname,final String speciality,final int hours){
        this.name = lastname;
        this.docCode = code;
        this.hours = hours;
        this.specialization = speciality;
    }

    @Override
    public String toString() {
        return "DoctorDetails{" +
                "name='" + name + '\'' +
                ", docCode='" + docCode + '\'' +
                ", hours=" + hours +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
