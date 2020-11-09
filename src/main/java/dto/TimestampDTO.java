package dto;

public class TimestampDTO {

    private long unix;
    private String utc;

    public TimestampDTO(long unix, String utc) {
        super();
        this.unix = unix;
        this.utc = utc;
    }

    public long getUnix() {
        return unix;
    }

    public void setUnix(long unix) {
        this.unix = unix;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

}
