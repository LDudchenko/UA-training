package com.company.controller;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public interface RegexContainer {

    public static final String REGEX_LASTNAME_ENG = "^[A-Z]{1}[a-z]{1,40}$";
    public static final String REGEX_LASTNAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,40}$";
    public static final String REGEX_NAME_ENG = "^[A-Z]{1}[a-z]{1,35}$";
    public static final String REGEX_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,35}$";
    public static final String REGEX_PATRONYMIC_ENG = "^[A-Z]{1}[a-z]{1,40}$";
    public static final String REGEX_PATRONYMIC_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,40}$";
    public static final String REGEX_NICKNAME = "^([A-za-z_])[\\w\\s\\-.]{1,29}$";
    public static final String REGEX_COMMENT = "^.+$";

    /**
     * The regex for mobile phone
     * "+38(044)555-55-55"
     */
    public static final String REGEX_MOBILE_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";

    /**
     * The regex for home phone
     *"215-87-90"
     */
    public static final String REGEX_HOME_PHONE = "^\\d{3}-\\d{2}-\\d{2}$";

    /**
     * The regex for email
     * "nick@mail.com"
     */
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    public static final String REGEX_SKYPE = "^[A-Za-z]{1}\\w{5,31}$";

    /**
     * The regex for address
     * 01001, г.Киев, ул. Академика Янгеля, д.5, кв.9
     */
    public static final String REGEX_ADDRESS = "^(\\d{5},\\sг\\.[А-Яа-я\\s]{1,90},\\sул\\.[А-Яа-я\\s]{2,},\\sд\\.[\\dА-Я]+,\\sкв\\.\\d+)$";
    public  static  final String REGEX_INDEX = "^\\d{5}$";
    public  static  final String REGEX_CITY_ENG = "^[A-Z]{1}[A-Za-z\\s-]{1,89}$";
    public  static  final String REGEX_CITY_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'\\s-]{1,89}$";
    public  static final String REGEX_STREET_ENG = "^[A-Z]{1}[A-Za-z\\s-]{1,89}$";
    public  static final String REGEX_STREET_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'\\s-]{1,89}$";
    public static final String REGEX_HOME = "^\\d+([A-Z]|[А-Я])?$";
    public static final String REGEX_FLAT = "^\\d{1,4}$";

}
