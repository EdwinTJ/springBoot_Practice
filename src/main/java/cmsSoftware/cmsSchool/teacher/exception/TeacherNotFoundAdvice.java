package cmsSoftware.cmsSchool.teacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class TeacherNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(TeacherNotFoundException exception) {
        return Map.of("error", exception.getMessage());
    }

}
