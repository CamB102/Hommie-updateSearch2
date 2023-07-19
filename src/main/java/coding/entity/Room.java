package coding.entity;

public class Room {
	private int id;
	private String title;
	private String description;
	private int price;
	private int bond;
	private int squareArea;
	private int capacity;
	private int countBed;
	private int countBath;
	private String availableDate;
	private int landlordId;
	private int studentId;



// location:
	private String mapUrl;
	private String lat;
	private String lng;
	private String address;
	private String state;
	private String postcode;
	
// Image: 
	private String image1Url;
	private String image2Url;
	private String image3Url;
	private String image4Url;
	
	
	
	public Room () {
		
	}

// constructor for getAllRooms and getThreeRooms
	public Room(int id, String title, String description, int price, int countBed, int countBath, String image1Url) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.countBed = countBed;
		this.countBath = countBath;
		this.image1Url = image1Url;
	}
	

// constructor for getRoomDetails
	public Room(int id, String title, String description, int price, int bond, int squareArea, int capacity, int countBed,
			int countBath, String availableDate, int landlordId, String lat, String lng, String address,
			String state, String postcode, String image1Url, String image2Url, String image3Url, String image4Url, String mapUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.bond = bond;
		this.squareArea = squareArea;
		this.capacity = capacity;
		this.countBed = countBed;
		this.countBath = countBath;
		this.availableDate = availableDate;
		this.landlordId = landlordId;
		this.lat = lat;
		this.lng = lng;
		this.address = address;
		this.state = state;
		this.postcode = postcode;
		this.image1Url = image1Url;
		this.image2Url = image2Url;
		this.image3Url = image3Url;
		this.image4Url = image4Url;
		this.mapUrl = mapUrl;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getSquareArea() {
		return squareArea;
	}



	public void setSquareArea(int squareArea) {
		this.squareArea = squareArea;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public int getCountBed() {
		return countBed;
	}



	public void setCountBed(int countBed) {
		this.countBed = countBed;
	}



	public int getCountBath() {
		return countBath;
	}



	public void setCountBath(int countBath) {
		this.countBath = countBath;
	}



	public String getAvailableDate() {
		return availableDate;
	}



	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}



	public int getLandlordId() {
		return landlordId;
	}



	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	public String getLng() {
		return lng;
	}



	public void setLng(String lng) {
		this.lng = lng;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPostcode() {
		return postcode;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}



	public String getImage1Url() {
		return image1Url;
	}



	public void setImage1Url(String image1Url) {
		this.image1Url = image1Url;
	}



	public String getImage2Url() {
		return image2Url;
	}



	public void setImage2Url(String image2Url) {
		this.image2Url = image2Url;
	}



	public String getImage3Url() {
		return image3Url;
	}



	public void setImage3Url(String image3Url) {
		this.image3Url = image3Url;
	}



	public String getImage4Url() {
		return image4Url;
	}



	public void setImage4Url(String image4Url) {
		this.image4Url = image4Url;
	}

	public int getBond() {
		return bond;
	}

	public void setBond(int bond) {
		this.bond = bond;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	

	
}