package com.company.model;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class Note {

    /** Field for saving last name */
    private String lastName;

    /** Field for saving name */
    private String name;

    /** Field for saving patronymic */
    private String patronymic;

    /** Field for saving full name in format last name and first letter of name */
    private String fullName;

    /** Field for saving nickname */
    private String login;

    /** Field for saving comment */
    private String comment;

    /** Field for saving group */
    private Group group;

    /** Field for saving home phone */
    private String homePhone;

    /** Field for saving mobile phone */
    private String mobilePhone;

    /** Field for saving additional mobile phone */
    private String additionalMobilePhone;

    /** Field for saving email */
    private String email;

    /** Field for saving skype */
    private String skype;

    /** Field for saving index */
    private String index;

    /** Field for saving city */
    private String city;

    /** Field for saving name of street */
    private String street;

    /** Field for saving number of phone */
    private String home;

    /** Field for saving number of flat */
    private String flat;

    /** Field for saving full address */
    private String fullAddress;

    /** Field for saving date of creation note */
    private String dateOfCreation;

    /** Field for saving date of change note */
    private String dateOfChange;

    /**
     * Method for getting value of field{@link Note#name}
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for getting value of field{@link Note#index}
     * @return index
     */
    public String getIndex() {
        return index;
    }

    /**
     * Method for setting value of field{@link Note#index}
     * @param index - postcode
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * Method for getting value of field{@link Note#city}
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method for setting value of field{@link Note#city}
     * @param city - city where user lives
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method for getting value of field{@link Note#street}
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method for setting value of field{@link Note#street}
     * @param street - street where user lives
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method for getting value of field{@link Note#home}
     * @return home
     */
    public String getHome() {
        return home;
    }

    /**
     * Method for setting value of field{@link Note#home}
     * @param home - number of home
     */
    public void setHome(String home) {
        this.home = home;
    }

    /**
     * Method for getting value of field{@link Note#flat}
     * @return flat
     */
    public String getFlat() {
        return flat;
    }

    /**
     * Method for setting value of field{@link Note#flat}
     * @param flat - number of flat
     */
    public void setFlat(String flat) {
        this.flat = flat;
    }

    /**
     * Method for setting value of field{@link Note#name}
     * @param name - name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method for getting value of field{@link Note#patronymic}
     * @return patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Method for setting value of field{@link Note#patronymic}
     * @param patronymic - patronymic of user
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Method for getting value of field{@link Note#fullName}
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Method for setting value of field{@link Note#fullName}
     * @param fullName - full name of user which consists of last name and first letter of name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Method for getting value of field{@link Note#comment}
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Method for setting value of field{@link Note#comment}
     * @param comment - additional comment of user
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Method for getting value of field{@link Note#index}
     * @return group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Method for setting value of field{@link Note#group}
     * @param group - group of people to which user is related to
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Method for getting value of field{@link Note#homePhone}
     * @return home phone
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Method for setting value of field{@link Note#homePhone}
     * @param homePhone - namber of home phone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * Method for getting value of field{@link Note#mobilePhone}
     * @return mobile phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Method for setting value of field{@link Note#mobilePhone}
     * @param mobilePhone - number of mobile phone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Method for getting value of field{@link Note#additionalMobilePhone}
     * @return addditional mobile phone
     */
    public String getAdditionalMobilePhone() {
        return additionalMobilePhone;
    }

    /**
     * Method for setting value of field{@link Note#additionalMobilePhone}
     * @param additionalMobilePhone - second mob
     */
    public void setAdditionalMobilePhone(String additionalMobilePhone) {
        this.additionalMobilePhone = additionalMobilePhone;
    }

    /**
     * Method for getting value of field{@link Note#email}
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method for setting value of field{@link Note#email}
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method for getting value of field{@link Note#skype}
     * @return skype
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Method for setting value of field{@link Note#skype}
     * @param skype
     */
    public void setSkype(String skype) {
        this.skype = skype;
    }

    /**
     * Method for getting value of field{@link Note#fullAddress}
     * @return full address
     */
    public String getFullAddress() {
        return fullAddress;
    }

    /**
     * Method for setting value of field{@link Note#fullAddress}
     * @param fullAddress
     */
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    /**
     * Method for getting value of field{@link Note#dateOfCreation}
     * @return date of creation note
     */
    public String getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * Method for setting value of field{@link Note#dateOfCreation}
     * @param dateOfCreation
     */
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * Method for getting value of field{@link Note#dateOfChange}
     * @return date of change note
     */
    public String getDateOfChange() {
        return dateOfChange;
    }

    /**
     * Method for setting value of field{@link Note#dateOfChange}
     * @param dateOfChange
     */
    public void setDateOfChange(String dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    /**
     * Method for getting value of field{@link Note#lastName}
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method for setting value of field{@link Note#lastName}
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method for getting value of field{@link Note#login}
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Method for setting value of field{@link Note#login}
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Method for forming full name like last name + the first letter of name
     */
    public void formLastNameAndFirstLetterOfName(){
        this.fullName = this.lastName + " " + this.name.charAt(0)+".";
    }

    /**
     * Method for forming full address
     */
    public void formFullAdress(){
        this.fullAddress = index+", "+city+", "+street+", "+home+", "+flat;
    }
}

/**
 * Enum which contains groups of people at the notebook
 */
enum Group{
    Family,
    Work,
    Friends,
}
