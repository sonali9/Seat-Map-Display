package prs;

public class User {
	private int trainno;
	private String journeydate;
	private String cls;
	private String coachid;
	private int berthid;
	private String availability;
	
	
	public User(int trainno, String journeydate, String cls, String coachid, int berthid, String availability) {
		super();
		this.trainno = trainno;
		this.journeydate = journeydate;
		this.cls = cls;
		this.coachid = coachid;
		this.berthid = berthid;
		this.availability = availability;
	}
	public int getTrainno() {
		return trainno;
	}
	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public String getCoachid() {
		return coachid;
	}
	public void setCoachid(String coachid) {
		this.coachid = coachid;
	}
	public int getBerthid() {
		return berthid;
	}
	public void setBerthid(int berthid) {
		this.berthid = berthid;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	

}
