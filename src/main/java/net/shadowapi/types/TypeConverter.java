package net.shadowapi.types;

public class TypeConverter {

    public static ShadowType convert(String s) {
        if (s.equalsIgnoreCase("CONNECTED")) {
            return ShadowType.CONNECTED;
        } else if (s.equalsIgnoreCase("ERROR_ALREADY_CONNECTED")) {
            return ShadowType.ERROR_ALREADY_CONNECTED;
        } else if (s.equalsIgnoreCase("ERROR_AUTH_KEY_NOT_VALID")) {
            return ShadowType.ERROR_AUTH_KEY_NOT_VALID;
        }
        return ShadowType.TIMEOUT;
    }

}
