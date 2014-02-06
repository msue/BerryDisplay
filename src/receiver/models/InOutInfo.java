package receiver.models;

/**
 * Created by 1 on 06.02.14.
 */
public class InOutInfo {
    private String safescanId;
    private String firstName;
    private String lastName;
    private String status;
    private String start;
    private String end;


    public InOutInfo(String safescanId, String firstName, String lastName, String status, String start, String end) {
        this.safescanId = safescanId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "safescanId='" + safescanId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InOutInfo)) return false;

        InOutInfo inOutInfo = (InOutInfo) o;

        if (end != null ? !end.equals(inOutInfo.end) : inOutInfo.end != null) return false;
        if (firstName != null ? !firstName.equals(inOutInfo.firstName) : inOutInfo.firstName != null) return false;
        if (lastName != null ? !lastName.equals(inOutInfo.lastName) : inOutInfo.lastName != null) return false;
        if (safescanId != null ? !safescanId.equals(inOutInfo.safescanId) : inOutInfo.safescanId != null) return false;
        if (start != null ? !start.equals(inOutInfo.start) : inOutInfo.start != null) return false;
        if (status != null ? !status.equals(inOutInfo.status) : inOutInfo.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = safescanId != null ? safescanId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
