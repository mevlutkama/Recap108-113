package pojos;

public class DummyApiDeleteResponsePojo {
    private String status;
    private String data;
    private String message;

    public DummyApiDeleteResponsePojo(String status, String data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyApiDeleteResponsePojo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyApiDeleteResponsePojo{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
