package utils;

import business.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import step.ApiSteps;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

public class Helper {

    static Logger log = Logger.getLogger(Helper.class.getName());

    public static String generateString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static User getUserFromFile(String pathToFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(new File(pathToFile), User.class);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return user;
    }
}
