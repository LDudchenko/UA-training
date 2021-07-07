package com.company.controller;

/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public interface RegexContainer {
    /**
     * The regex for last name in english
     * "Ivanov"
     */
    public static final String REGEX_LASTNAME_ENG = "^[A-Z]{1}[a-z]{1,40}$";

    /**
     * The regex for last name in ukrainian
     * "Іванов"
     */
    public static final String REGEX_LASTNAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,40}$";


    /**
     * The regex for name in english
     * "Ivan"
     */
    public static final String REGEX_NAME_ENG = "^[A-Z]{1}[a-z]{1,35}$";

    /**
     * The regex for name in ukrainian
     * "Ivan"
     */
    public static final String REGEX_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,35}$";


    /**
     * The regex for patronymic in english
     *"Ivanovich"
     */
    public static final String REGEX_PATRONYMIC_ENG = "^[A-Z]{1}[a-z]{1,40}$";

    /**
     * The regex for patronymic in ukrainian
     *"Ivanovich"
     */
    public static final String REGEX_PATRONYMIC_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[а-щьюяґіїє']{1,40}$";


    /**
     * The regex for nickname
     * "_mila098_p.mt"
     */
    public static final String REGEX_NICKNAME = "^([A-za-z_])[\\w\\s\\-.]{1,29}$";

    /**
     * The regex for comment
     *
     */
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

    /**
     * The regex for skype
     * ""
     */
    public static final String REGEX_SKYPE = "^[A-Za-z]{1}\\w{5,31}$";

    /**
     * The regex for address
     * 01001, г.Киев, ул. Академика Янгеля, д.5, кв.9
     */
    public static final String REGEX_ADDRESS = "^(\\d{5},\\sг\\.[А-Яа-я\\s]{1,90},\\sул\\.[А-Яа-я\\s]{2,},\\sд\\.[\\dА-Я]+,\\sкв\\.\\d+)$";

    /**
     * The regex for index
     * "83003"
     */
    public  static  final String REGEX_INDEX = "^\\d{5}$";

    /**
     * The regex for city in english
     * "Kharkiv"
     */
    public  static  final String REGEX_CITY_ENG = "^[A-Z]{1}[A-Za-z\\s-]{1,89}$";

    /**
     * The regex for city in ukrainian
     * "Харьків"
     */
    public  static  final String REGEX_CITY_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'\\s-]{1,89}$";


    /**
     * The regex for street in english
     * "Academic Yangelya"
     */
    public  static final String REGEX_STREET_ENG = "^[A-Z]{1}[A-Za-z\\s-]{1,89}$";

    /**
     * The regex for street in ukrainian
     * "Академіка Янгеля"
     */
    public  static final String REGEX_STREET_UKR = "^[А-ЩЬЮЯҐІЇЄ]{1}[А-ЩЬЮЯҐІЇЄа-щьюяґіїє'\\s-]{1,89}$";

    /**
     * The regex for home
     * "5" or "5A"
     */
    public static final String REGEX_HOME = "^\\d+([A-Z]|[А-Я])?$";

    /**
     * The regex for flat
     *"78"
     */
    public static final String REGEX_FLAT = "^\\d{1,4}$";

}
