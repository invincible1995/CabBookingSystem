package cabbookingsystem.entity;

public class Driver extends User {

	@Override
	public boolean ckeckNull() {
		if(this.getId() != null || this.getName() != null ||  this.getMobile_no() != null){
            return false;
        }
        return true;
	}
	
	
	

}
