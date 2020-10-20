package com.garnagaaa.lesson05.task01.app1.exception;

/**
 * @author Aleksei Garnaga
 * Исключение ограничения по возврату
 */
public class AgeExceptionBase extends BasePersonException {
    public AgeExceptionBase(String message) {
        super("Age restrictions. Age = " + message);
    }
}
