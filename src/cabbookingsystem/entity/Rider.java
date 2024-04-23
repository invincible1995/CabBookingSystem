package cabbookingsystem.entity;

import java.util.List;

public class Rider extends User {
	
	private List<String> bookingHistory;

    public List<String> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(List<String> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

	@Override
	public boolean ckeckNull() {
		if(this.getId() != null || this.getName() != null ||  this.getMobile_no() != null){
            return false;
        }
        return true;
	}

	
	

	public Rider() {
		
	}

	@Override
	public String toString() {
		return "Rider [bookingHistory=" + bookingHistory + "]";
	}
	
	
	
	
}
