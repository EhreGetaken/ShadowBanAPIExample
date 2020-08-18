package net.shadowapi.types;

public class TypeConverter {

    public static ShadowType convert(String s) {
        if (s.startsWith("CONNECTED")) {
            return ShadowType.CONNECTED;
        } else if (s.startsWith("ERROR_ALREADY_CONNECTED")) {
            return ShadowType.ERROR_ALREADY_CONNECTED;
        } else if (s.startsWith("ERROR_AUTH_KEY_NOT_VALID")) {
            return ShadowType.ERROR_AUTH_KEY_NOT_VALID;
        } else if (s.startsWith("REQUEST_BANNED=")) {
            return ShadowType.REQUEST_BANNED;
        } else if (s.startsWith("REQUEST_TYPE=")) {
            return ShadowType.REQUEST_TYPE;
        }
        return ShadowType.TIMEOUT;
    }

}
