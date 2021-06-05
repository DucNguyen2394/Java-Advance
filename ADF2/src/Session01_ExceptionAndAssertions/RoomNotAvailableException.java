package Session01_ExceptionAndAssertions;

public class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(){
        super();
    }

    public RoomNotAvailableException(int roomAvailable){
        super("Currently there are " + roomAvailable + "room available");
    }
}
