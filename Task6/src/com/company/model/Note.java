package com.company.model;

import com.company.controller.AlreadyExistedLogin;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class Note {

    private Notebook notebook;
    private String lastName;
    private String name;
    private String patronymic;
    private String fullName;
    private String login;
    private String comment;
    private Group group;
    private String homePhone;
    private String mobilePhone;
    private String additionalMobilePhone;
    private String email;
    private String skype;
    private String index;
    private String city;
    private String street;
    private String home;
    private String flat;
    private String fullAddress;
    private String dateOfCreation;
    private String dateOfChange;

    public Note(Notebook notebook){
        this.notebook = notebook;
    }

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAdditionalMobilePhone() {
        return additionalMobilePhone;
    }

    public void setAdditionalMobilePhone(String additionalMobilePhone) {
        this.additionalMobilePhone = additionalMobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(String dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws AlreadyExistedLogin{
        for(int i = 0; i<notebook.getNotes().size(); i++) {
            if(notebook.getNotes().get(i).getLogin().equals(login)){
                throw new AlreadyExistedLogin();
            }
        }
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

    /**
     * Method for printing last name, name, patronymuc, full name and login
     * @return string which contains the value of last name, name, patrnymuc, full name, login
     */
    @Override
    public String toString() {
        return "Note{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                '}';
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
