/**
 * Created by Dudchenko Liudmila on 05.07.2021
 */
public class Regex {
    /**
     * The regex for last name
     * "Ivan"
     */
    public static final String REGEX_LASTNAME = "^([А-Я]{1}[а-яё]{1,35}|[A-Z]{1}[a-z]{1,40})$";

    /**
     * The regex for name
     * "Ivanov"
     */
    public static final String REGEX_NAME = "^([А-Я]{1}[а-яё]{1,35}|[A-Z]{1}[a-z]{1,40})$";

    /**
     * The regex for patronymic
     *"Ivanovich"
     */
    public static final String REGEX_PATRONYMIC = "^([А-Я]{1}[а-яё]{1,40}|[A-Z]{1}[a-z]{1,40})$";

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
     * The regex for city
     * "Харьков"
     */
    public  static  final String REGEX_CITY = "^[A-ZА-Я]{1}[A-Za-zА-Яа-я\\s-]{1,89}$";

    /**
     * The regex for street
     * "Академика Янгеля"
     */
    public  static final String REGEX_STREET = "^[A-ZА-Я]{1}[A-Za-zА-Яа-я\\s-]{1,89}$";

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
