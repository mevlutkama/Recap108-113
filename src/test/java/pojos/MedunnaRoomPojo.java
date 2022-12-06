package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedunnaRoomPojo {
    private String createdBy;
    private String createdDate;
    private int roomNumber;
    private String roomType;
    private boolean status;
    private int price;
    private String description;

    public MedunnaRoomPojo(String createdBy, String createdDate, int roomNumber, String roomType, boolean status, int price, String description) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public MedunnaRoomPojo() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MedunnaRoomPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
