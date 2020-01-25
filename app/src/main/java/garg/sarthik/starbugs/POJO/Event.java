package garg.sarthik.starbugs.POJO;

public class Event {

    String eventId;
    String eventLatlng;
    String eventStartTime;
    String eventEndTime;

    public Event() {
    }


    public Event(String eventLatlng, String eventStartTime) {

        //this.eventId = eventId;
        /*TODO
            Add the id generating function
            and also add all the functions from KPIT project
         */
        this.eventLatlng = eventLatlng;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = "0";
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventLatlng() {
        return eventLatlng;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }
}
