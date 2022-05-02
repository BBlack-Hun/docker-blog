package kr.co.bblackhun.dockerblog.system.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resuorceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resuorceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s:  '%s'", resuorceName, fieldName, fieldValue)); // post not found with id: 1
        this.resuorceName = resuorceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
