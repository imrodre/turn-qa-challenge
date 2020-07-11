package backgroundCheck.pojo;

public class InformationFormData {

	public InformationFormData(String fstName, String lstName, String midName, String hasMidName, String dayOfBdy,
			String monthOfBdy, String yearOfBdy, String gender, String ssn, String zipCode, String email,
			String phoneNum, String driverLicenseSt, String driverLicenseNum) {
		super();
		this.fstName = fstName;
		this.lstName = lstName;
		this.midName = midName;
		this.hasMidName = Boolean.valueOf(hasMidName);
		this.dayOfBdy = dayOfBdy;
		this.monthOfBdy = monthOfBdy;
		this.yearOfBdy = yearOfBdy;
		this.dateOfBirth = formatDateOfBirth(dayOfBdy, monthOfBdy, yearOfBdy);
		this.gender = formatGender(gender);
		this.ssn = formatSSN(ssn);
		this.zipCode = zipCode;
		this.email = email;
		this.phoneNum = formatPhoneNumber(phoneNum);
		this.driverLicenseSt = driverLicenseSt.toUpperCase();
		this.driverLicenseNum = driverLicenseNum;
	}

	String fstName;
	String lstName;
	String midName;
	boolean hasMidName;
	String dayOfBdy;
	String monthOfBdy;
	String yearOfBdy;
	String dateOfBirth;
	String gender;
	String ssn;
	String zipCode;
	String email;
	String phoneNum;
	String driverLicenseSt;
	String driverLicenseNum;

	public String firstName() {
		return this.fstName;
	}

	public String lastName() {
		return this.lstName;
	}

	public String middleName() {
		return this.midName;
	}

	public boolean hasMiddleName() {
		return this.hasMidName;
	}

	public String dayOfBirthday() {
		return this.dayOfBdy;
	}

	public String monthOfBirthday() {
		return this.monthOfBdy;
	}

	public String yearOfBirthday() {
		return this.yearOfBdy;
	}

	public String dateOfBirth() {
		return this.dateOfBirth;
	}

	public String gender() {
		return this.gender;
	}

	public String ssn() {
		return this.ssn;
	}

	public String zipCode() {
		return this.zipCode;
	}

	public String email() {
		return this.email;
	}

	public String phoneNumber() {
		return this.phoneNum;
	}

	public String driverLicenseState() {
		return this.driverLicenseSt;
	}

	public String driverLicenseNumber() {
		return this.driverLicenseNum;
	}

	private String formatGender(String genderCode) {

		if (genderCode.toLowerCase().equalsIgnoreCase("m")) {
			return "male";
		} else if (genderCode.toLowerCase().equalsIgnoreCase("f")) {
			return "female";
		}
		return genderCode;
	}

	private String formatSSN(String ssn) {
		return String.format("%s-%s-%s",ssn.substring(0, 3), ssn.substring(4, 6),ssn.substring(5));
	}

	private String formatDateOfBirth(String day, String month, String year) {
		return String.format("%s/%s/%s", month, day, year);
	}
	
	private String formatPhoneNumber(String phoneNumber) {
		if(phoneNumber.length()==11){
			return String.format("%s (%s) %s-%s", phoneNumber.substring(0, 1), phoneNumber.substring(1, 4), phoneNumber.substring(4, 7), phoneNumber.substring(7));
		}else if(phoneNumber.length()==10){
			return String.format("(%s) %s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6));
		}
		return phoneNumber;
	}
}
