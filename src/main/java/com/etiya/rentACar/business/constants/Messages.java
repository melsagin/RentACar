package com.etiya.rentACar.business.constants;

public class Messages {
    public class IdMessages{
        public static final String ID_NOT_NULL = "Id boş geçilemez";
        public static final String ID_NOT_NEGATIVE = "Id 0'dan küçük olamaz!";
    }
    public class BrandMessages{
        public static final String BRAND_NAME_NOT_BLANK = "Marka adı boş olamaz!";
        public static final String BRAND_NAME_LENGHT_MIN_TWO_LETTERS = "Girilen marka en az 2 harfli olmalıdır!";

        public static final String BRAND_NOT_FOUND_ID = "Bu id'ye ait bir araç bulunamadı!";
    }
    public class CarMessages{
        public static final String KILOMETER_NOT_NULL = "Kilometre boş geçilemez.";
        public static final String CAR_STATE_MIN_VALUES = "Araba durumu minimum 1 olmalıdır.";
        public static final String CAR_STATE_MAX_VALUES = "Araba durumu maximum 3 olmalıdır.";
        public static final String CAR_STATE_IS_NOT_NEGATIVE = "Araba durumu negatif girilmemelidir.";
        public static final String KILOMETER_NOT_NEGATIVE = "Kilometre 0'dan küçük olamaz.";
        public static final String YEAR_NOT_NULL = "Yıl boş geçilemez";
        public static final String YEAR_NOT_LESS_THAN_TWO_THOUSAND_FIVE = "Yıl 2005'den küçük olamaz.";
        public static final String YEAR_NOT_GREATER_THAN_TWO_THOUSAND_TWENTY_FOUR = "Yıl 2024'den büyük olamaz.";
        public static final String DAILY_PRICE_NOT_NEGATIVE = "Günlük kiralama ücreti 0'dan küçük olamaz.";
        public static final String ENTER_VALID_PLATE = "geçerli bir plaka giriniz.";
        public static final String SAME_PLATE_CAR_EXISTS = "Aynı plakada başka bir araç eklenemez.";
        public static final String CAR_NOT_FOUND = "Bu id'ye sahip araç bulunmamaktadır.";
        public static final String ENTER_VALID_PLATE_REGEX = "(?i)^\\s*[0-9]{2}\\s*[A-Z]{1,3}\\s*[0-9]{1,4}\\s*$";
        public static final String COLOR_NOT_BLANK = "Araç rengi boş bırakılamaz!";
        public static final String COLOR_LENGTH_MIN_TWO_LETTERS = "Araç rengi en az iki karakterden oluşmalıdır!";


    }
    public class FuelMessages{
        public static final String FUEL_NOT_NULL = "Yakıt tipi alanı boş geçilemez!";
        public static final String FUEL_NOT_FOUND_ID = "Bu id'ye ait bir fuel bulunamadı!";

    }
    public class ModelMessages{
        public static final String MODEL_NAME_NOT_BLANK = "Model adı boş olamaz!";

        public static final String MODEL_NAME_LENGHT_MIN_TWO_LETTERS = "Girilen model en az 2 harfli olmalıdır!";

        public static final String MODEL_NOT_FOUND_ID = "Bu id'ye ait bir model bulunamadı!";
    }

    public class TransmissionMessages{
        public static final String TRANSMISSION_NOT_FOUND_ID = "Bu id'ye ait bir transmission bulunamadı!";
        public static final String TRANSMISSION_NOT_NULL = "Vites tipi alanı boş geçilemez!";
    }

    public class RentalMessages{
        public static final String RENTED_BEFORE = "Bu araba şu anda başka bir kişi tarafından kiralanmıştır! ";
        public static final String UNDER_MAINTENANCE = "Bu araç bakımdadır!";

    }

}
