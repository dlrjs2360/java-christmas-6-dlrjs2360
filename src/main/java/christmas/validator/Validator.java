package christmas.validator;

import christmas.constant.message.ErrorMessage;

public interface Validator<T> {

    void validate(T data);
    default void throwException(ErrorMessage errorMessage) {
        throw new IllegalArgumentException(errorMessage.getMessage());
    }
}
