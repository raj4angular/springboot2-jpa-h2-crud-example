package net.guides.springboot2.springboot2jpacrudexample.model;


import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {


    private Integer id;
    private Integer roomId;
    private String bookingDate;
    private Integer fromTimeId;
    private Integer toTimeId;



    private String message;

    public Booking() {
    }

    public Booking(Integer roomId, String bookingDate, Integer fromTimeId, Integer toTimeId) {
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.fromTimeId = fromTimeId;
        this.toTimeId = toTimeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "room_id", nullable = false)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Column(name = "booking_date", nullable = false)
    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Column(name = "from_time_id", nullable = false)
    public Integer getFromTimeId() {
        return fromTimeId;
    }

    public void setFromTimeId(Integer fromTimeId) {
        this.fromTimeId = fromTimeId;
    }

    @Column(name = "to_time_id", nullable = false)
    public Integer getToTimeId() {
        return toTimeId;
    }

    public void setToTimeId(Integer toTimeId) {
        this.toTimeId = toTimeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
