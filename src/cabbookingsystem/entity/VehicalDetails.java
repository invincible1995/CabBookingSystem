package cabbookingsystem.entity;

public class VehicalDetails {
	 private String carNumber;
	    private Double lat;
	    private Double lon;
	    private String type;
	    private Boolean isAvailable;
	    private String driverId;
	    
	    

	    public VehicalDetails(String carNumber, Double lat, Double lon, String type, Boolean isAvailable, String driverId) {
			super();
			this.carNumber = carNumber;
			this.lat = lat;
			this.lon = lon;
			this.type = type;
			this.isAvailable = isAvailable;
			this.driverId = driverId;
		}



		public VehicalDetails() {
			// TODO Auto-generated constructor stub
		}



		public String getCarNumber() {
			return carNumber;
		}



		public void setCarNumber(String carNumber) {
			this.carNumber = carNumber;
		}



		public Double getLat() {
			return lat;
		}



		public void setLat(Double lat) {
			this.lat = lat;
		}



		public Double getLon() {
			return lon;
		}



		public void setLon(Double lon) {
			this.lon = lon;
		}



		public String getType() {
			return type;
		}



		public void setType(String type) {
			this.type = type;
		}



		public Boolean getIsAvailable() {
			return isAvailable;
		}



		public void setIsAvailable(Boolean isAvailable) {
			this.isAvailable = isAvailable;
		}



		public String getDriverId() {
			return driverId;
		}



		public void setDriverId(String driverId) {
			this.driverId = driverId;
		}



		@Override
		public String toString() {
			return "VehicalDetails [carNumber=" + carNumber + ", lat=" + lat + ", lon=" + lon + ", type=" + type
					+ ", isAvailable=" + isAvailable + ", driverId=" + driverId + "]";
		}



		public boolean isNull() {
	        if(this.getCarNumber() != null || this.getLat() != null || this.getLon() != null || this.getType() != null || this.getIsAvailable() != null || this.getDriverId() != null){
	            return false;
	        }
	        return true;

	    }

}
